package com.xiayu.http.invoice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhongyu
 * @create 2021-12-22 11:13 上午
 */
public class CheckCompanyName {



    public static void main(String[] args) {
        List oldCustomerName = getOldCustomerName();

         List<String> customerNames = getCustomerName(null);

        List<String> results = new ArrayList<>();

        for (String customerName : customerNames) {
            if(oldCustomerName.contains(customerName)){
                results.add(customerName);
            }
        }
        System.out.println("原数据信息："+ results.toString());
        System.out.println("公司个数："+ results.size());
        System.out.println("过滤后信息："+ results.stream().distinct().collect(Collectors.toList()));
    }

    private static List getOldCustomerName() {
        String oldCustomName = "上海文鳐供应链科技有限公司\n" +
                "伊航船务有限公司\n" +
                "上海亚东国际货运有限公司安吉分公司\n" +
                "浙江万联国际货运代理有限公司\n" +
                "青岛中外运储运有限公司\n" +
                "湖州众诚国际货运代理有限公司\n" +
                "丹马士环球物流（上海）有限公司\n" +
                "宁波太平国际贸易联运有限公司杭州分公司\n" +
                "上海瑞玲国际物流有限公司\n" +
                "浙江三石力供应链管理有限公司\n" +
                "浙江大华科技有限公司\n" +
                "海南美的国际物流科技有限公司\n" +
                "宁波龙毅国际物流有限公司\n" +
                "浙江凯鸿物流股份有限公司\n" +
                "湖州霄华物流有限公司\n" +
                "中集凯通国际物流有限公司\n" +
                "江苏方正苏高新港有限公司\n" +
                "浙江经茂国际货运代理有限公司\n" +
                "港中旅华贸国际物流股份有限公司常州分公司\n" +
                "苏州华韬物流供应链管理有限公司\n" +
                "上海瑞风国际物流有限公司\n" +
                "常州恒萱物流有限公司\n" +
                "杭州桥宇国际货运代理有限公司安吉分公司\n" +
                "嘉兴恒元国际货运代理有限公司\n" +
                "无锡世集国际货运有限公司\n" +
                "浙江鑫骋物流有限公司\n" +
                "江苏万舜国际货运代理有限公司\n" +
                "浙江兴港国际货运代理有限公司嘉兴分公司\n" +
                "湖州佳利达国际物流有限公司\n" +
                "江苏常利来国际货运代理有限公司\n" +
                "苏州有您网国际物流股份有限公司\n" +
                "西安新纪元供应链管理有限公司宁波分公司\n" +
                "江苏联洋国际货运代理有限公司\n" +
                "浙江华虹国际货运代理有限公司\n" +
                "安徽保捷船务有限公司\n" +
                "苏州华诚国际物流有限公司沿江分公司\n" +
                "浙江凯西国际货运代理有限公司";
        String[] split = oldCustomName.split("\n");
        ArrayList<String> objects = new ArrayList<>();
        for (String s : split) {
            objects.add(s);
        }
        return objects;
    }

    private static List getCustomerName(CustomerNameReq customerNameReq){
        OkHttpClient okHttpClient = new OkHttpClient();
        String cookie = "Hm_lvt_565e591bdb40c562966b267b3dbe5f82=1637570126,1638149157,1638755108,1639646487; SESSION=1ca7224a-5774-4ba6-a57f-39573fcf57f1; Hm_lpvt_565e591bdb40c562966b267b3dbe5f82=1640138972; acw_tc=2f624a1116401428556423001e6216016c6db3b2cc83125b09c49d1712c360";

        // 正式环境
        StringBuilder url = new StringBuilder();
        url.append(" https://new.carrierglobe.com/ws-truck/bill/ar_writeoff/list?customer=&invoiceTitle=&payee=&salesman=&predictPaidFromDate=&predictPaidToDate=&accountingFromDate=&accountingToDate=&writeOffFromDate=&writeOffToDate=&mailDateFrom=&mailDateTo=&creationTimeFrom=&creationTimeTo=2021-12-22+23%3A59%3A59&status=INVOICE_SUBMITTED&customerAgentName=%E4%B8%8A%E6%B5%B7&invoiceTimeStart=&invoiceTimeEnd=&payed=&vatRate=&invoiceNumber=&yongyouSynchronous=&isInvoiceIssued=&page=1&pageSize=25&vatInvoice=1&accountPeriodDateFrom=&accountPeriodDateTo=&_=1640138972309");

        Request request = new Request.Builder()
                .url(url.toString())
                .get()
                .addHeader("Cookie", cookie)
                .build();
        Call call = okHttpClient.newCall(request);
        List<String> companyName = new ArrayList<>();
        try {
            Response response = call.execute();

            String StringTemp = response.body().string();
            JSONObject jsonObjectTemp = (JSONObject) JSONObject.parse(StringTemp);
            JSONArray jsonArrays = jsonObjectTemp.getJSONArray("objs");
            for (Object obj : jsonArrays) {
                JSONObject  jsonArray = (JSONObject) obj;
                String customer = jsonArray.getString("customer");
                companyName.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyName;
    }
}
