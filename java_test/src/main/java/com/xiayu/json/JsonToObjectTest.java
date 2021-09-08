package com.xiayu.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-04-4:22 下午
 */
public class JsonToObjectTest {
    public static void main(String[] args) {
        String jsonString ="{\"classType\":\"listContainerResponseDto\",\"haveDetails\":false,\"success\":true,\"page\":1,\"pageSize\":25,\"total\":102,\"totalPage\":5,\"containers\":[{\"blNo\":\"SHZ4062685-D5F5FE\",\"chatImagePaths\":[],\"containerNo\":\"SGCU5543462\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市厚街镇永丰街5号\",\"id\":1889245,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-04 09:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 16:15:12\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1889245,\"costGroup\":[],\"costs\":[],\"customerService\":\"邓明发\",\"detentionTime\":\"\",\"documentOperationId\":1518949,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"SGCU5543462\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"212790642\",\"chatImagePaths\":[],\"containerNo\":\"MRSU5508201\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市清溪镇银湖工业区\",\"id\":1881811,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-04 09:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 14:44:11\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1881811,\"costGroup\":[],\"costs\":[],\"customerService\":\"师闪闪\",\"detentionTime\":\"\",\"documentOperationId\":1511676,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"MRSU5508201\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":45.6000000000,\"weekCash\":0,\"weight\":5878.8000000000},{\"blNo\":\"721BK1134543\",\"chatImagePaths\":[],\"containerNo\":\"TSTU0233459\",\"containerSize\":\"20GP\",\"doorAddress\":\"广东省深圳市龙华区观澜佰公坳工业区5巷5号\",\"id\":1887998,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-04 08:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 11:44:51\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1887998,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1517743,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"TSTU0233459\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"73508194\",\"chatImagePaths\":[],\"containerNo\":\"HLXU5129116\",\"containerSize\":\"40GP\",\"doorAddress\":\"广东省东莞市茶山镇沙墩村沿溪路100号\",\"id\":1886526,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-04 08:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 13:14:46\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1886526,\"costGroup\":[],\"costs\":[],\"customerService\":\"杨倩\",\"detentionTime\":\"\",\"documentOperationId\":1516271,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"HLXU5129116\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":9112.0000000000},{\"blNo\":\"213015711\",\"chatImagePaths\":[],\"containerNo\":\"MRSU5502142\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市东莞市东城街道温塘创盈路东城段1号\",\"id\":1883092,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-04 08:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 14:18:41\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1883092,\"costGroup\":[],\"costs\":[],\"customerService\":\"邓明发\",\"detentionTime\":\"\",\"documentOperationId\":1512938,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"MRSU5502142\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"ZSN0439396-47DA8F\",\"chatImagePaths\":[],\"containerNo\":\"TRHU4482574\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省广州市增城区新塘镇黄沙头村方中二路3号\",\"id\":1885993,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 19:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 07:45:33\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1885993,\"costGroup\":[],\"costs\":[],\"customerService\":\"邓明发\",\"detentionTime\":\"\",\"documentOperationId\":1515835,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"TRHU4482574\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"181DS0214151506J1\",\"chatImagePaths\":[],\"containerNo\":\"MSMU6383691\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省阳江市阳东区北惯镇霍达二路13号\",\"id\":1885141,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 18:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 10:50:39\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1885141,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1514975,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"MSMU6383691\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"181CS0214151506J1\",\"chatImagePaths\":[],\"containerNo\":\"MSMU6384785\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省阳江市阳东区北惯镇霍达二路13号\",\"id\":1885139,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 18:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 01:10:23\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1885139,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1514973,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"MSMU6384785\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"181BS0214151506J1\",\"chatImagePaths\":[],\"containerNo\":\"MSMU6384682\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省阳江市阳东区北惯镇霍达二路13号\",\"id\":1885134,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 18:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 02:21:17\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1885134,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1514968,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"MSMU6384682\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"181AS0214151506J1\",\"chatImagePaths\":[],\"containerNo\":\"MSMU6398834\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省阳江市阳东区北惯镇霍达二路13号\",\"id\":1885113,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 18:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 01:10:07\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1885113,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1514950,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"MSMU6398834\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"BANR35YTSS0643\",\"chatImagePaths\":[],\"containerNo\":\"CHSU8119991\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市清溪镇福龙路8号\",\"id\":1886488,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 15:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 09:36:07\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1886488,\"costGroup\":[],\"costs\":[],\"customerService\":\"唐红\",\"detentionTime\":\"\",\"documentOperationId\":1516232,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"CHSU8119991\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"BANR35YTSS0642\",\"chatImagePaths\":[],\"containerNo\":\"CHSU8116708\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市清溪镇福龙路8号\",\"id\":1886467,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 15:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 05:15:48\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1886467,\"costGroup\":[],\"costs\":[],\"customerService\":\"唐红\",\"detentionTime\":\"\",\"documentOperationId\":1516222,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"CHSU8116708\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"149111340615-D8DF\",\"chatImagePaths\":[],\"containerNo\":\"TEMU6125382\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市东莞市中堂镇江南开发区西区6号之4\",\"id\":1885977,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 15:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 03:29:41\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1885977,\"costGroup\":[],\"costs\":[],\"customerService\":\"邓明发\",\"detentionTime\":\"\",\"documentOperationId\":1515818,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"TEMU6125382\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"213095141\",\"chatImagePaths\":[],\"containerNo\":\"MRKU7470587\",\"containerSize\":\"20GP\",\"doorAddress\":\"广东省揭阳市榕城区凤林村\",\"id\":1884251,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 15:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 06:07:30\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1884251,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1514059,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"MRKU7470587\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"SHZ4100347\",\"chatImagePaths\":[],\"containerNo\":\"CMAU8293276\",\"containerSize\":\"40GP\",\"doorAddress\":\"广东省东莞市东莞市虎门镇龍眼社區東十路\",\"id\":1873752,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 15:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 04:08:02\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1873752,\"costGroup\":[],\"costs\":[],\"customerService\":\"邓明发\",\"detentionTime\":\"\",\"documentOperationId\":1504054,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"CMAU8293276\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"149111273527-6F5B\",\"chatImagePaths\":[],\"containerNo\":\"EGSU9184902\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市中堂镇江南西区一环路46号\",\"id\":1887458,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 14:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 03:51:17\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1887458,\"costGroup\":[],\"costs\":[],\"customerService\":\"邓明发\",\"detentionTime\":\"\",\"documentOperationId\":1517232,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"EGSU9184902\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"SZPM83459300\",\"chatImagePaths\":[],\"containerNo\":\"KOCU5003436\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省阳江市阳东区325国道\",\"id\":1887373,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 14:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 13:09:47\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1887373,\"costGroup\":[],\"costs\":[],\"customerService\":\"李思明\",\"detentionTime\":\"\",\"documentOperationId\":1517144,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"KOCU5003436\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"149111343185\",\"chatImagePaths\":[],\"containerNo\":\"BMOU3109785\",\"containerSize\":\"40GP\",\"doorAddress\":\"广东省深圳市龙岗区平安大道乾隆物流园5B栋111-11;广东省东莞市凤岗镇油甘埔乐富工业区同兴路177号\",\"id\":1882780,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 14:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-03 21:15:22\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1882780,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1512644,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"BMOU3109785\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"E226071710001\",\"chatImagePaths\":[],\"containerNo\":\"SEGU6800329\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市东莞市大岭山镇梅林村梅连路8号\",\"id\":1878140,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 14:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 08:12:45\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1878140,\"costGroup\":[],\"costs\":[],\"customerService\":\"闵菊\",\"detentionTime\":\"\",\"documentOperationId\":1508186,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"SEGU6800329\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"ZIMUSHH30647843\",\"chatImagePaths\":[],\"containerNo\":\"TLLU4951088\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省惠州市惠阳区永湖镇彩一村惠澳大道旁（惠州市迈臣业工艺品有限公司）\",\"id\":1888119,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 13:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 03:09:29\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1888119,\"costGroup\":[],\"costs\":[],\"customerService\":\"杨倩\",\"detentionTime\":\"\",\"documentOperationId\":1517855,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"TLLU4951088\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"HKGA10356300\",\"chatImagePaths\":[],\"containerNo\":\"KOCU4729450\",\"containerSize\":\"40GP\",\"doorAddress\":\"广东省深圳市宝安区福永镇怀德翠岗六区北方骏亿工业园第四栋1层\",\"id\":1887460,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 13:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 06:12:52\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1887460,\"costGroup\":[],\"costs\":[],\"customerService\":\"杨倩\",\"detentionTime\":\"\",\"documentOperationId\":1517234,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"KOCU4729450\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":2160.0000000000},{\"blNo\":\"SHZ3979349\",\"chatImagePaths\":[],\"containerNo\":\"CICU1796326\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省广州市花都区石头记矿物园石缘二路1号\",\"id\":1860342,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 10:30:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 12:37:24\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1860342,\"costGroup\":[],\"costs\":[],\"customerService\":\"张兰兰\",\"detentionTime\":\"\",\"documentOperationId\":1490998,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"CICU1796326\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":5758.2000000000},{\"blNo\":\"HKGBK4864501\",\"chatImagePaths\":[],\"containerNo\":\"TRHU5579419\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省东莞市高埗镇草墩工业园1号\",\"id\":1887401,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 10:00:00\",\"portDistrict\":\"盐田\",\"portDistrictId\":65602,\"supportAppoint\":false,\"approachTime\":\"2021-09-04 10:00:32\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1887401,\"costGroup\":[],\"costs\":[],\"customerService\":\"杨倩\",\"detentionTime\":\"\",\"documentOperationId\":1517173,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"TRHU5579419\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"025B679455\",\"chatImagePaths\":[],\"containerNo\":\"SZLU9912223\",\"containerSize\":\"40RH\",\"doorAddress\":\"广东省深圳市龙岗区丹运路1号\",\"id\":1887265,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 10:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-03 17:05:23\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1887265,\"costGroup\":[],\"costs\":[],\"customerService\":\"李思明\",\"detentionTime\":\"\",\"documentOperationId\":1517031,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"SZLU9912223\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10},{\"blNo\":\"025B683999\",\"chatImagePaths\":[],\"containerNo\":\"WHLU5550530\",\"containerSize\":\"40HC\",\"doorAddress\":\"广东省深圳市龙岗区丹运路1号\",\"id\":1887186,\"imagePaths\":[],\"planArrivalTime\":\"2021-09-03 10:00:00\",\"portDistrict\":\"蛇口\",\"portDistrictId\":65601,\"supportAppoint\":false,\"approachTime\":\"2021-09-03 16:01:42\",\"binningAccessory\":[],\"chargeOtherList\":[],\"checkModifyPlanArrivalTime\":false,\"compareGateInData\":false,\"containerId\":1887186,\"costGroup\":[],\"costs\":[],\"customerService\":\"李思明\",\"detentionTime\":\"\",\"documentOperationId\":1516956,\"doorTags\":[],\"gateIn\":true,\"hasTerminationTodoTask\":false,\"mailingInfoId\":0,\"monthCash\":0,\"needPrerecord\":false,\"newSum\":0,\"number\":\"WHLU5550530\",\"oilCard\":0,\"otherChargeDetail\":[],\"portId\":\"SHENZHEN\",\"portName\":\"深圳港\",\"preRecorded\":false,\"totalVolume\":0E-10,\"weekCash\":0,\"weight\":0E-10}]}";

        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONArray containers = (JSONArray) jsonObject.get("containers");

        List<String> ids = new ArrayList<>();
        for (Object container : containers) {
            JSONObject containerObject =  (JSONObject) container;
            Object id = containerObject.get("id");
            ids.add(id.toString());
        }
        System.out.println(ids.toString());
    }
}