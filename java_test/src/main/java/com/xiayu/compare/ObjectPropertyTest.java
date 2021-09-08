package com.xiayu.compare;

import com.xiayu.json.Test;
import org.omg.CORBA.FieldNameHelper;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-07-11:04 上午
 */
public class ObjectPropertyTest {

    public static void main(String[] args) throws IllegalAccessException {
        TestPoOne testPoOne = new TestPoOne();
        LocalDateTime now = LocalDateTime.now();
        testPoOne.setOne("oneContext");
        testPoOne.setObj(null);
        testPoOne.setLists(new ArrayList<>());
        testPoOne.setABoolean(true);
        testPoOne.setALong(1L);
        testPoOne.setStr("strContext");
        testPoOne.setLocalDateTime(now);


        TestPoTwo testPoTwo = new TestPoTwo();

        testPoTwo.setTwo("oneContext");
        testPoTwo.setObj(null);
        testPoTwo.setLists(new ArrayList<>());
        testPoTwo.setABoolean(true);
        testPoTwo.setALong(1L);
        testPoTwo.setStr("strContext");
        testPoTwo.setLocalDateTime(now);

       boolean bo =  checkObjectProperty(testPoOne,testPoTwo);
        System.out.println(bo);
    }


    /**
     *  比较两个包装类的属性是否一致
     *  只校验属性名称一致的属性，区分属性类型
     *
     * @param objBefore
     * @param objAfter
     * @return
     * @throws IllegalAccessException
     */
    private static boolean checkObjectProperty(Object objBefore,Object objAfter) throws IllegalAccessException {
        // 获取 field类型
        Map<String, Field> fieldMapBe = getFieldProperty(objBefore);
        Map<String, Field> fieldMapAf = getFieldProperty(objAfter);

        // 开始校验是否一致
        for (Map.Entry<String, Field> fieldEntryBe : fieldMapBe.entrySet()) {
            if (!fieldMapAf.containsKey(fieldEntryBe.getKey())) {
                continue;
            }

            Field fieldBe = fieldEntryBe.getValue();
            Field fieldAf = fieldMapAf.get(fieldEntryBe.getKey());

            // 校验属性值类型是否一致
            if (fieldBe.getType().equals(fieldAf.getType())) {
                Object valueBf = fieldBe.get(objBefore);
                Object valueAf = fieldAf.get(objAfter);
                // 校验属性为null
                if(valueBf == null && valueAf == null){
                    continue;
                }
                if(valueBf == null || valueAf == null){
                    return false;
                }
                String type = fieldBe.getType().getName();
                // 根据属性类型来校验
                if (type.equals("java.lang.String") ||
                        type.equals("ava.lang.Integer")||
                        type.equals("java.lang.Long")||
                        type.equals("java.lang.Double")||
                        type.equals("boolean")||
                        type.equals("java.time.LocalDateTime")||
                        type.equals("java.math.BigDecimal")
                ) {
                    String strBf = valueBf.toString();
                    String strAf = valueAf.toString();
                    if(!strBf.equals(strAf)){
                        return false;
                    }
                }
                // 其他类型对比

            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取 一个对象的 field
     * @param obj
     * @return
     */
    private static Map<String, Field> getFieldProperty(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, Field> fieldMap = new HashMap<>();
        for (Field fieldBe : fields) {
            fieldBe.setAccessible(true);
            String key = fieldBe.getName();
            fieldMap.put(key, fieldBe);
        }
        return fieldMap;
    }
}

//            try {
//
//                Object v1 = fieldOne.get(testPoOne);
//
//                System.out.println(v1);
//
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }