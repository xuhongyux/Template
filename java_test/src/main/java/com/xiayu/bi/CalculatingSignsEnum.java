package com.xiayu.bi;

/**
 * @author caitao
 * @date 2021/4/28
 */
public enum CalculatingSignsEnum {

    /**
     * 获得统计结果
     */
    KPI("KPI", "KPI", 1, "null", 6, "null", "KPI",1,1),

    /**
     * 收集结果，存储到TraceBo event级别
     */
    ATTR("ATTR", "ATTR", 1, "null", 6, "null", "属性",1,1),

    /**
     * 收集结果，存储到TraceBo CASE_ATTR级别
     */
    CASE_ATTR("CASE_ATTR", "CASE_ATTR", 1, "null", 6, "null", "案例属性",1,1),


    /**
     * 收集结果，存储到TraceBo event级别
     */
    EVENT_ATTR("EVENT_ATTR", "EVENT_ATTR", 1, "null", 6, "null", "事件属性",1,1),


    // --------------------------------------------------  List函数 -------------------------------------------

    /**
     * 检查是否满足一个或多个条件，且返回符合第一个 TRUE 条件的值 (已添加)
     */
    IFS("IFS", "IFS", 1, "null", 3, "null", "如果",1,99),

    /**
     * if条件 (已添加)
     */
    IF("IF", "IF", 1, "null", 3, "null", "如果",1,3),

    /**
     * 统计数量CASE(已添加)
     */
    CASE_COUNT("CASE_COUNT", "CASE_COUNT", 1, "Double", 2, "number", "案例数量",0,1),

    /**
     * 统计数量EVENT(已添加)
     */
    EVENT_COUNT("EVENT_COUNT", "EVENT_COUNT", 1, "Double", 2, "number", "事件数量",0,1),

    /**
     * CASE_PCT
     */
    CASE_PCT("CASE_PCT", "CASE_PCT", 1, "Double", 2, "percentage", "案例百分比",0,1),

    /**
     * EVENT_PCT
     */
    EVENT_PCT("EVENT_PCT", "EVENT_PCT", 1, "Double", 2, "percentage", "事件百分比",0,1),

    /**
     * 过滤函数，返回true(已添加)
     */
    FILTER("FILTER", "FILTER", 1, "Double", 4, "null", "过滤",1,99),

    /**
     * 等级，返回true(已添加)
     */
    RANK("RANK", "RANK", 1, "null", 3, "Boolean", "出现次数",1,1),


    /**
     * 排序(已添加)
     */
    SORT("SORT", "SORT", 1, "Double", 2, "null", "排序",2,99),

    /**
     * sum(已添加)
     */
    SUM("SUM", "SUM", 1, "Double", 2, "number", "求和",1,2),

    /**
     * max(已添加)
     */
    MAX("MAX", "MAX", 1, "Double", 2, "number", "最大值",1,2),

    /**
     * min(已添加)
     */
    MIN("MIN", "MIN", 1, "Double", 2, "number", "最小值",1,2),

    /**
     * avg(已添加)
     */
    AVG("AVG", "AVG", 1, "Double", 2, "number", "平均值",1,2),

    /**
     * count_distinct(已添加)
     */
    COUNT_DISTINCT("COUNT_DISTINCT", "COUNT_DISTINCT", 1, "Double", 2, "number", "计非重复数",1,1),

    /**
     * 相隔日期
     */
    DATE_DIFF("DATE_DIFF", "DATE_DIFF", 1, "Date", 5, "number", "间隔时间",2,2),


    /**
     * 复制，后面是否包含一样的
     */
    DUPLICATE("DUPLICATE", "DUPLICATE", 1, "null", 3, "number", "重复值",1,1),

    /**
     * 相邻的，后面是否包含一样的
     */
    NEIGHBOR("NEIGHBOR", "NEIGHBOR", 1, "Integer", 3, "number", "连续值",1,2),

    /**
     * YEAR
     */
    YEAR("YEAR", "YEAR", 1, "Date", 5, "number", "年份",1,1),

    /**
     * MONTH
     */
    MONTH("MONTH", "MONTH", 1, "Date", 5, "number", "月份",1,1),

    /**
     * YEARMONTH
     */
    YEARMONTH("YEARMONTH", "YEARMONTH", 1, "Date", 5, "number", "年月",1,1),

    /**
     * DAY
     */
    DAY("DAY", "DAY", 1, "Date", 5, "number", "天",1,1),

    /**
     * HOUR
     */
    HOUR("HOUR", "HOUR", 1, "Date", 5, "number", "小时",1,1),

    /**
     * ADDMONTH
     */
    ADDMONTH("ADDMONTH", "ADDMONTH", 1, "Date", 5, "number", "增加月份",1,2),

    /**
     * ADDDAY
     */
    ADDDAY("ADDDAY", "ADDDAY", 1, "Date", 5, "number", "增加天数",1,2),

    /**
     * WEEKDAY
     */
    WEEKDAY("WEEKDAY", "WEEKDAY", 1, "Date", 5, "number", "星期几",1,1),

    /**
     * while循环
     **/
    WHILE("WHILE", "WHILE", 0, null, 7, "null", "",1,99),

    /**
     * FOREACH
     **/
    FOREACH("FOREACH", "FOREACH", 0, null, 7, "null", "",1,1),

    /**
     * VALUE
     **/
    VALUE("VALUE", "VALUE", 1, null, 7, "number", "",1,1),

    /**
     * MODE
     **/
    MODE("MODE", "MODE", 1, "Double", 2, "number", "",1,1),

    /**
     * MED
     **/
    MED("MED", "MED", 1, "Double", 2, "number", "",1,1),

    /**
     * BIN
     */
    BIN("BIN", "BIN", 1, "Double", 2, "String", "",2,2),

    /**
     * NOTEMPTY_COUNT
     */
    NOTEMPTY_COUNT("NOTEMPTY_COUNT", "NOTEMPTY_COUNT", 1, "Double", 2, "number", "有效值计数",1,1),

    /**
     * NOTEMPTY_PCT
     */
    NOTEMPTY_PCT("NOTEMPTY_PCT", "NOTEMPTY_PCT", 1, "Double", 2, "percentage", "有效值百分比",1,1),

    /**
     * APPEND 合并
     */
    APPEND("APPEND", "APPEND", 1, "String", 2, "String", "合并",1,99),


    // -----------------------------------------------非List函数-----------------------------------------------

    /**
     * 取左边几个字符
     */
    LEFT("LEFT", "LEFT", 0, "null", 3, "String", "",2,2),

    /**
     * 取右边几个字符
     */
    RIGHT("RIGHT", "RIGHT", 0, "null", 3, "String", "",2,2),


    /**
     * 大于（ > ）(已添加)
     */
    MORE_THAN("MORE_THAN", ">", 0, "Double", 0, "Boolean", "",2,2),

    /**
     * 大于（ >= ）(已添加)
     */
    MORE_THAN_EQUAL("MORE_THAN_EQUAL", ">=", 0, "Double", 0, "Boolean", "",2,2),

    /**
     * 小于（ < ）(已添加)
     */
    LESS_THAN("LESS_THEN", "<", 0, "Double", 0, "Boolean", "",2,2),


    /**
     * 小于等于（ <= ）(已添加)
     */
    LESS_THAN_EQUAL("LESS_THAN_EQUAL", "<=", 0, "Double", 0, "Boolean", "",2,2),

    /**
     * 等于（ == ）(已添加)
     */
    EQUAL("EQUAL", "==", 0, "Double", 0, "Boolean", "",2,2),

    /**
     * 加（ + ）(已添加)
     */
    PLUS("PLUS", "+", 0, "Double", 0, "number", "",2,2),

    /**
     * 减（ - ）(已添加)
     */
    MINUS("MINUS", "-", 0, "Double", 0, "number", "",2,2),

    /**
     * 满足一个条件就为真(已添加)
     */
    OR("OR", "OR", 0, "Double", 1, "Boolean", "",1,99),

    /**
     * 异或(相同为0，不同为1)(已添加)
     */
    XOR("XOR", "XOR", 0, "Double", 1, "Boolean", "",1,99),

    /**
     * 多个条件必须同时满足(已添加)
     */
    AND("AND", "AND", 0, "Double", 1, "Boolean", "",1,99),

    /**
     * 取反(已添加)
     */
    NOT("NOT", "NOT", 0, "boolean", 1, "Boolean", "",1,1),

    /**
     * 判断字符串是否为空(已添加)
     */
    ISEMPTY("ISEMPTY", "ISEMPTY", 0, "Double", 1, "Boolean", "",1,1),

    /**
     * 对数字类型取整(已添加)
     */
    INT("INT", "INT", 0, "Double", 3, "number", "",1,1),

    /**
     * 保留位数(已添加)
     */
    ROUND("ROUND", "ROUND", 0, "Double", 3, "number", "",2,2),

    /**
     * 乘积(已添加)
     */
    PRODUCT("PRODUCT", "*", 0, "Double", 0, "number", "",2,3),

    /**
     * 除以(已添加)
     */
    DIVISION("DIVISION", "/", 0, "Double", 0, "number", "",2,3),

    /**
     * 不等于(已添加)
     */
    NOT_EQUAL("NOT_EQUAL", "!=", 0, "Double", 1, "Boolean", "",2,2),

    /**
     * 包含区间(已添加)
     */
    BETWEEN("BETWEEN", "BETWEEN", 0, "String", 1, "Boolean", ",",3,3);


    /**
     * 函数名称
     */
    public String name;
    /**
     * 函数符号
     */
    public String symbol;
    /**
     * 是否为聚合函数  0：为普通的 1：为List
     */
    public int isList;
    /**
     * 该函数入参的参数类型
     */
    public String paramType;
    /**
     * 函数计算出来的结果类型
     */
    public String resultType;
    /**
     * 函数的类型
     * 1。逻辑运算
     * 2。数学函数
     * 3.运算函数
     * 4.逻辑函数
     * 5.日期函数
     * 6.赋值函数
     * 7.高阶函数
     */
    public int functionType;
    public String cnName;
    public Integer  valueLongMax;
    public Integer  valueLongMin;

    CalculatingSignsEnum(String name, String symbol, int isList, String paramType, Integer functionType, String resultType, String cnName, Integer valueLongMin, Integer valueLongMax) {
        this.name = name;
        this.symbol = symbol;
        this.isList = isList;
        this.paramType = paramType;
        this.functionType = functionType;
        this.resultType = resultType;
        this.cnName = cnName;
        this.valueLongMax = valueLongMax;
        this.valueLongMin = valueLongMin;
    }

    public static CalculatingSignsEnum getBySymbol(String symbol) {
        CalculatingSignsEnum[] values = CalculatingSignsEnum.values();
        for (CalculatingSignsEnum value : values) {
            if (value.symbol.equals(symbol)) {
                return value;
            }
        }
        return null;
    }

}
