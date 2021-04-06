package com.xiayu.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author xuhongyu
 * @create 2021-03-03-9:57 上午
 */
public class TestStream {
    public static void main(String[] args) {

        Map<String, UserPo> hashMap = new HashMap<String, UserPo>(2);
        hashMap.put("huihui", new UserPo("huihui", "15"));
        hashMap.put("xiaoming", new UserPo("xiaoming", "15"));

        hashMap.entrySet().parallelStream().forEach(
                po -> {
                    UserPo value = po.getValue();
                    value.setAge("16");
                    po.setValue(value);
                }
        );

        System.out.println(hashMap.toString());


//        Map hashMap = new HashMap<String, UserPo>();
//        hashMap.put("xiayu",new UserPo("xiayu","15"));
//        hashMap.put("xuhongyu",new UserPo("xuhongyu","15"));
//
//
//        List<Map> list = new ArrayList<>();
//        list.add(hashMap);
//        list.add(hashMap1);


        // list.stream().filter(vo ->vo.containsKey("xiayu")).collect(Collectors.toCollection(map ->map));


    }
    // Stream 时间排序
    private Map<String, Long> getTimeListPro(Set<String> currentCaseIdList, Map<String, Vector<UserPo>> trace) {
        Map<String, Long> mapStream = currentCaseIdList.stream().collect(Collectors.toMap(
                caseId -> caseId, caseId -> {
                    Optional<UserPo> maxTime = trace.get(caseId).stream().max(comparator);
                    Optional<UserPo> minTime = trace.get(caseId).stream().min(comparator);
                   // return SimpleDateUtil.getIntervalSecond(minTime.get().getTimestamp(),maxTime.get().getTimestamp());
                    return  null;
                }
        ));
        return mapStream;
    }

    Comparator<UserPo> comparator = Comparator.comparing(UserPo::getName);
}