package com.xiayu.feign.consumer.permutations;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongyu
 * @create 2021-04-15 16:40
 */
public class LinkListOrder {
    public static void main(String[] args) {
        Map<String, List<String>> detailsForEachDimensionItem = new HashMap<>();
        List<String> strings = new ArrayList<>();

        strings.add("邮箱1");
        strings.add("账户1");
        strings.add("密码1");
        detailsForEachDimensionItem.put("邮箱1@账户1@密码1",strings);

        List<String> Strings1 = new ArrayList<>();
        Strings1.add("邮箱2");
        Strings1.add("账户2");
        Strings1.add("密码1");
        detailsForEachDimensionItem.put("邮箱2@账户2@密码1",Strings1);

        List<String> Strings2 = new ArrayList<>();
        Strings2.add("邮箱2");
        Strings2.add("账户1");
        Strings2.add("密码1");
        detailsForEachDimensionItem.put("邮箱2@账户1@密码1",Strings2);
        LinkListOrder linkListOrder = new LinkListOrder();


        Map<String, List<String>> stringListMap = linkListOrder.linkedListSort(detailsForEachDimensionItem);
        System.out.println(stringListMap);
    }

    /**
     * 链表排序
     *
     * @param detailsForEachDimensionItem
     * @return
     */
    private  Map<String, List<String>> linkedListSort(Map<String, List<String>> detailsForEachDimensionItem) {
        Map<String, DimensionKpiValue> dimensionKpiValueMap = Maps.newLinkedHashMap();
        for (Map.Entry<String, List<String>> detailsForEachDimension : detailsForEachDimensionItem.entrySet()) {
            List<String> attrValueList = detailsForEachDimension.getValue();
            int flag = 0;
            recursionProcessFilling(dimensionKpiValueMap, null, attrValueList, flag);
        }
        List<String> dimensionPermutationPro = Lists.newArrayList();
        for (Map.Entry<String, DimensionKpiValue> stringDimensionKpiValueEntry : dimensionKpiValueMap.entrySet()) {
            List<String> dimensionList = Lists.newArrayList();
            recursionProcessObtain(stringDimensionKpiValueEntry, dimensionList);
            dimensionPermutationPro.addAll(dimensionList);
        }
        Map<String, List<String>> detailsForEachDimensionItemOrder = Maps.newLinkedHashMap();
        for (String str : dimensionPermutationPro) {
            if (detailsForEachDimensionItem.containsKey(str)) {
                detailsForEachDimensionItemOrder.put(str, detailsForEachDimensionItem.get(str));
            }
        }
        return detailsForEachDimensionItemOrder;
    }


    /**
     * 递归处理数据填充
     * getTagAnalyze
     *
     * @param dimensionKpiValueMap
     * @param attrValueList
     */
    private void recursionProcessFilling(Map<String, DimensionKpiValue> dimensionKpiValueMap, Map<String, DimensionKpiValue> ParentDimensionKpiValueMap, List<String> attrValueList, int flag) {
        // 当前层数值
        String attrValue = attrValueList.get(flag);
        // 包含
        if (dimensionKpiValueMap.containsKey(attrValue)) {

            // 不包含
        } else {
            DimensionKpiValue dimension = new DimensionKpiValue();
            dimension.setDimensionValue(attrValue);
            StringBuffer stringBuffer = new StringBuffer();
            if (flag < 1) {

            } else {
                DimensionKpiValue parentNode = ParentDimensionKpiValueMap.get(attrValueList.get(flag - 1));
                String parentSequence = parentNode.getParentSequence();

                stringBuffer.append(parentSequence);
                stringBuffer.append("@");
            }
            stringBuffer.append(attrValue);
            dimension.setParentSequence(stringBuffer.toString());

            dimensionKpiValueMap.put(attrValue, dimension);

            // 将null 放在最后
            if (dimensionKpiValueMap.containsKey("null")) {
                DimensionKpiValue dimensionKpiValue = dimensionKpiValueMap.get("null");
                dimensionKpiValueMap.remove("null");
                dimensionKpiValueMap.put("null", dimensionKpiValue);
            }
        }
        flag++;
        if (flag < attrValueList.size()) {
            recursionProcessFilling(dimensionKpiValueMap.get(attrValue).getChildrenDimensionValue(), dimensionKpiValueMap, attrValueList, flag);
        }

    }

    /**
     * 递归取链表中的数据
     *
     * @param stringDimensionKpiValueEntry
     * @param dimensionList
     */
    private void recursionProcessObtain(Map.Entry<String, DimensionKpiValue> stringDimensionKpiValueEntry, List<String> dimensionList) {
        Map<String, DimensionKpiValue> childrenDimensionValue = stringDimensionKpiValueEntry.getValue().getChildrenDimensionValue();
        if (childrenDimensionValue.size() == 0) {
            String parentSequence = stringDimensionKpiValueEntry.getValue().getParentSequence();
            dimensionList.add(parentSequence);

        } else {
            for (Map.Entry<String, DimensionKpiValue> dimensionKpiValueEntry : childrenDimensionValue.entrySet()) {
                recursionProcessObtain(dimensionKpiValueEntry, dimensionList);
            }
        }
    }

}
