/*
package com.xiayu.commons.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

*/
/**
 * 短信验证类
 *
 *//*


public class AliyunSmsUtil {

    private static final String regionId = "cn-hangzhou";
    private static final String accessKeyId = "LTAI4FfBsSyzm8uHHfD64qYT";
    private static final String secret = "YO6qL30YJqph3s7MwpurImRHziBaXd";

    public static void main(String[] args) {
        System.out.println(":");
    }

    private static void parsingResult(String data) {
        */
/*Map<String, Object> map = JsonUtils.json2map(data);
        if (map == null) {
            throw new BusinessException(BusinessStatus.FAIL, "短信发送失败");
        }
        String code = MapperUtils.defaultString(map.get("Code"));
        if (MapperUtils.isBlank(code)) {
            throw new BusinessException(BusinessStatus.FAIL, "短信发送失败");
        }
        switch (code) {
            case "OK":
                return;
            case "isv.DAY_LIMIT_CONTROL":
                throw new BusinessException(BusinessStatus.FAIL, "短信发送已达每日上线");
            case "isv.MOBILE_NUMBER_ILLEGAL":
                throw new BusinessException(BusinessStatus.FAIL, "手机号错误");
            case "isv.BUSINESS_LIMIT_CONTROL":
                throw new BusinessException(BusinessStatus.FAIL, "该手机号发送短信频率过快");
            default:
                throw new BusinessException(BusinessStatus.FAIL, "短信发送失败");
        }*//*


    }

    */
/**
     * 发送验证码
     *
     * @param tel
     *//*

    public static void sendCode(String tel, Integer code) {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        //todo
        //request.putQueryParameter("PhoneNumbers", MapperUtils.trimKonggeAll(tel));
        request.putQueryParameter("SignName", "Reborn家教平台");
        request.putQueryParameter("TemplateCode", "SMS_187938238");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//           parsingResult(response.getData());
//        } catch (BusinessException e) {
//            throw e;
//        } catch (Exception e) {
//            throw new BusinessException(BusinessStatus.FAIL, "短信发送失败");
//        }YO6qL30YJqph3s7MwpurImRHziBaXd
        try {
            CommonResponse response = client.getCommonResponse(request);
            parsingResult(response.getData());
           // System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }


}
*/
