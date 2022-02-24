package com.xiayu.bi;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xuhongyu
 * @create 2022-01-17 10:36 上午
 */
public class AnalysisFunctionContent {

    public static void main(String[] args) {

        String b = "a = IFS(records.事件排序求和  == 1 ,'good' ,.事件排序求和  == 2,'good,good');";
        AnalysisFunctionContent analysisFunctionContent = new AnalysisFunctionContent();
        AttrsAndFunctionBo attrsAndFunctionBo = analysisFunctionContent.analysisFunctionContent(b);
        System.out.println(attrsAndFunctionBo);
    }


    private static final String FUNCTION_VALUE_TYPE_STRING = "string";
    private static final String FUNCTION_VALUE_TYPE_NUMBER = "number";
    private static final String FUNCTION_VALUE_TYPE_COLUMN = "column";

    public AttrsAndFunctionBo analysisFunctionContent( String functionContent) {
        functionContent = functionContent.replaceAll("\\s", "");
        List<AttrTypeBo> attrList = Lists.newArrayList();
        AttrTypeBo attrTypeBo = new AttrTypeBo();
        attrTypeBo.setAttrName("setAttrName");
        attrTypeBo.setType("CASE_ATTR");
        attrList.add(attrTypeBo);

        List<String> contentList = splitManyFunction(functionContent);
        List<Stack<CustomFunctionObjBo>> stackList = Lists.newLinkedList();

        for (String content : contentList) {
            CustomFunctionObjBo customFunctionObjBo = new CustomFunctionObjBo();
            analysis(customFunctionObjBo, content);


            // 入栈
            Stack stack = new Stack();
            stack.push(customFunctionObjBo);
            stackPush(stack, customFunctionObjBo);
            stackList.add(stack);
        }

        return new AttrsAndFunctionBo(stackList, attrList);
    }




    private void stackPush(Stack stack, CustomFunctionObjBo customFunctionObjBo) {

        for (CustomFunctionObjBo child : customFunctionObjBo.getChild()) {
            stack.push(child);
        }

        for (CustomFunctionObjBo child : customFunctionObjBo.getChild()) {
            stackPush(stack, child);
        }

    }

    /**
     * 分割若干函数
     *
     * @param functionContent
     * @return
     */
    private List<String> splitManyFunction(String functionContent) {

        if (functionContent.lastIndexOf(";") == functionContent.length() - 1) {
            functionContent = functionContent.substring(0, functionContent.length() - 1);
        }

        List<String> functions = Lists.newArrayList();
        int startIndex = 0;
        int functionCount = 0;

        char[] chars = functionContent.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (i == (functionContent.length() - 1)) {
                functions.add(functionContent.substring(startIndex));
                break;

            }

            if ('{' == chars[i]) {
                functionCount += 1;
                continue;

            }

            if ('}' == chars[i]) {
                functionCount -= 1;
                continue;

            }

            if (functionCount == 0 && ';' == chars[i]) {
                functions.add(functionContent.substring(startIndex, i));

                if (i + 1 < functionContent.length() - 1) {
                    startIndex = i + 1;
                }

            }

        }

        return functions;

    }
    /**
     * 解析函数
     *
     * @param parent
     * @param str
     * @throws
     */
    private void analysis(CustomFunctionObjBo parent, String str) {
        List<ValueOfFunctionAndTypeBo> values = new ArrayList<>();
        List<CustomFunctionObjBo> childs = new ArrayList<>();

        if (isForeachFunction(str)) { // FOREACH函数
//            FunctionContentAsBo functionObj = getForeachFunctionObj(str);
//
//            // 前缀as
//            String asOfHeader = functionObj.getAsOfHeader();
//            // 后缀as
//            String asOfLast = functionObj.getAsOfLast();
//            // 函数符号
//            String symbol = functionObj.getFunctionName();
//            // 子函数
//            String content = functionObj.getContent();
//
//            if(!StringUtils.isEmpty(asOfHeader)){
//                parent.setAsOfHeader(asOfHeader);
//            }
//            if(!StringUtils.isEmpty(asOfLast)){
//                parent.setAsOfHeader(asOfLast);
//            }
//
//            // 解析函数的参数
//            CalculatingSignsEnum calculatingSignsEnum = getBySymbol(symbol);
//            analysisOfForeachFunction(parent, childs, values, content, calculatingSignsEnum);

        } else {
            FunctionContentAsBo typeOneFunctionObj = getTypeOneFunctionObj(str);
            if (typeOneFunctionObj != null) {   // 判断类型1函数

                // 前缀as
                String asOfHeader = typeOneFunctionObj.getAsOfHeader();
//            // 后缀as
//            String asOfLast = typeOneFunctionObj.getAsOfLast();
                // 函数符号
                String symbol = typeOneFunctionObj.getFunctionName();
                // 子函数
                String content = typeOneFunctionObj.getContent();

                if (!StringUtils.isEmpty(asOfHeader)) {
                    parent.setAsOfHeader(asOfHeader);
                }
//            if(!StringUtils.isEmpty(asOfLast)){
//                parent.setAsOfHeader(asOfLast);
//            }

                // 解析函数的参数
                CalculatingSignsEnum calculatingSignsEnum = getBySymbol(symbol);
                analysisOfManyParamFunction(parent, childs, values, content, calculatingSignsEnum);

            } else {
                // 比较函数
                SymbolAndFunctionStrsBo typeTwoObj = getTypeTwoFunctionObj(str);
                if (typeTwoObj != null) {
                    List<String> functionStrs = typeTwoObj.getFunctionStrs();
                    String symbol = typeTwoObj.getSymbol();
                    String idsName = typeTwoObj.getIdsName();
                    parent.setAsOfHeader(idsName);
                    pushFunctionOfCompare(parent, childs, values, symbol, functionStrs);

                } else {
                    // 基础函数
                    SymbolAndFunctionStrsBo typeThreeObj = getTypeThreeFunctionObj(str);
                    if (typeThreeObj != null) {
                        List<String> functionStrs = typeThreeObj.getFunctionStrs();
                        String idsName = typeThreeObj.getIdsName();
                        String symbol = typeThreeObj.getSymbol();
                        parent.setAsOfHeader(idsName);
                        if (!StringUtils.isEmpty(idsName)) {    // 基础函数如果有as，就封装成VALUE函数
                            String content = functionStrs.get(0) + symbol + functionStrs.get(1);
                            symbol = CalculatingSignsEnum.VALUE.symbol;
                            analysisOfManyParamFunction(parent, childs, values, content, CalculatingSignsEnum.getBySymbol(symbol));

                        } else {
                            pushFunctionOfCompare(parent, childs, values, symbol, functionStrs);

                        }

                    }

                }
            }
        }

    }
    private FunctionContentAsBo getTypeOneFunctionObj(String functionStr) {

        // 判断函数最外侧是否有括号包裹
        if (functionStr.indexOf("(") == 0
                && functionStr.lastIndexOf(")") == functionStr.length() - 1) {
            functionStr = functionStr.substring(1, functionStr.length() - 1);
        }

        if (functionStr.contains("(") && functionStr.lastIndexOf(")") == functionStr.length() - 1) {
            String header = functionStr.substring(0, functionStr.indexOf("("));

            String[] headerSplit = header.split("=");
            if (headerSplit.length == 1) {  // 没有asOfHeader
                CalculatingSignsEnum bySymbol = CalculatingSignsEnum.getBySymbol(headerSplit[0]);

                if (bySymbol != null && checkAllFunction(bySymbol)) {
                    String content = functionStr.substring(functionStr.indexOf("(") + 1, functionStr.length() - 1);
                    return new FunctionContentAsBo(null, null, bySymbol.symbol, null, content);

                }
            } else if (headerSplit.length == 2) {   // 有asOfHeader
                CalculatingSignsEnum bySymbol = CalculatingSignsEnum.getBySymbol(headerSplit[1]);
                if (bySymbol != null && checkAllFunction(bySymbol)) {
                    String content = functionStr.substring(functionStr.indexOf("(") + 1, functionStr.length() - 1);
                    return new FunctionContentAsBo(headerSplit[0], null, bySymbol.symbol, null, content);

                }
            }

        }

        return null;
    }


    /**
     * 添加比较函数 如 > >= < <= ==
     *
     * @param parent
     * @param childs
     * @param values
     * @return
     * @throws
     */
    private void pushFunctionOfCompare(CustomFunctionObjBo parent, List<CustomFunctionObjBo> childs, List<ValueOfFunctionAndTypeBo> values, String symbol, List<String> functionStrs)  {

        if (CollectionUtils.isEmpty(functionStrs)
                || functionStrs.size() < 2
                || StringUtils.isEmpty(functionStrs.get(0))
                || StringUtils.isEmpty(functionStrs.get(1))) {

        }

        parent.setFunction(getBySymbol(symbol));
        int seq = 1;
        for (String function : functionStrs) {

            // 判断函数最外侧是否有括号包裹
            if (function.indexOf("(") == 0
                    && function.lastIndexOf(")") == function.length() - 1) {
                function = function.substring(1, function.length() - 1);
            }

            if (checkFunction(function)) {
                CustomFunctionObjBo child = new CustomFunctionObjBo();
                child.setSeq(seq);
                analysis(child, function); // 递归
                if (child.isHaveIdsName()) {
                    parent.setHaveIdsName(true);
                }
                childs.add(child);
            } else {
                ValueOfFunctionAndTypeBo valueOfFunctionAndTypeBo;
                if (function.contains(".")) {
                    String[] split = function.split("\\.");
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(split[1], FUNCTION_VALUE_TYPE_COLUMN, seq);
                    parent.setHaveIdsName(true);

                } else if (function.contains("\"")) {
                    function = function.replaceAll("\"", "");
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_STRING, seq);

                } else if (function.contains("'")) {
                    function = function.replaceAll("'", "");
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_STRING, seq);

                } else if (isNumberType(function)) {
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_NUMBER, seq);

                } else {
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_COLUMN , seq);

                }
                values.add(valueOfFunctionAndTypeBo);

            }

            seq += 1;
        }

        parent.setValues(values);
        parent.setChild(childs);

    }

    private SymbolAndFunctionStrsBo getTypeTwoFunctionObj(String str) {

//        >=
        SymbolAndFunctionStrsBo morethanEqualBo = checkTypeTwoFunctionObj(str, CalculatingSignsEnum.MORE_THAN_EQUAL.symbol);
        if (morethanEqualBo != null) {
            return morethanEqualBo;
        }

//        <=
        SymbolAndFunctionStrsBo lessthanEqualBo = checkTypeTwoFunctionObj(str, CalculatingSignsEnum.LESS_THAN_EQUAL.symbol);
        if (lessthanEqualBo != null) {
            return lessthanEqualBo;
        }

//        ==
        SymbolAndFunctionStrsBo equalBo = checkTypeTwoFunctionObj(str, CalculatingSignsEnum.EQUAL.symbol);
        if (equalBo != null) {
            return equalBo;
        }

//        !=
        SymbolAndFunctionStrsBo notEqualBo = checkTypeTwoFunctionObj(str, CalculatingSignsEnum.NOT_EQUAL.symbol);
        if (notEqualBo != null) {
            return notEqualBo;
        }

//        >
        SymbolAndFunctionStrsBo morethanBo = checkTypeTwoFunctionObj(str, CalculatingSignsEnum.MORE_THAN.symbol);
        if (morethanBo != null) {
            return morethanBo;
        }

//        <
        SymbolAndFunctionStrsBo lessthanBo = checkTypeTwoFunctionObj(str, CalculatingSignsEnum.LESS_THAN.symbol);
        if (lessthanBo != null) {
            return lessthanBo;
        }

        return null;

    }


    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumberType(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public boolean isForeachFunction(String str) {
        int foreachFunctionStartCount = 0, foreachFunctionEndCount = 0;
        for (char c : str.toCharArray()) {
            if ('{' == c) {
                foreachFunctionStartCount += 1;
                continue;
            }

            if ('}' == c) {
                foreachFunctionEndCount += 1;

            }
        }

        if (foreachFunctionStartCount > 0
                && foreachFunctionStartCount == foreachFunctionEndCount) {
            String prefixOfForeach = str.substring(0, str.indexOf("{"));
            int headerIndex = 0;
            if (prefixOfForeach.indexOf("=") > 0) {
                headerIndex = prefixOfForeach.indexOf("=") + 1;
            }
            String headerOfForeach = str.substring(headerIndex, str.indexOf("{"));
            if (headerOfForeach.indexOf("(") == 7
                    && headerOfForeach.indexOf(")") > 7
                    && headerOfForeach.indexOf("(") == headerOfForeach.lastIndexOf("(")
                    && headerOfForeach.indexOf(")") == headerOfForeach.lastIndexOf(")")
                    && headerOfForeach.indexOf("(") < headerOfForeach.indexOf(")")
                    && str.indexOf("{") - str.indexOf(")") == 1) {
                String values = headerOfForeach.substring(headerOfForeach.indexOf("(") + 1, headerOfForeach.indexOf(")"));
                if (values.split(",").length > 0) {
                    return true;

                }

            }

        }

        return false;
    }

    // 判断所有函数
    private boolean checkFunction(String str) {

        if (isForeachFunction(str)) {
            return true;
        }

        if (str.indexOf("\"") == 0 && str.lastIndexOf("\"") == str.length() - 1) {
            return false;
        }

        if ((str.indexOf("(") > 0 && str.lastIndexOf(")") == str.length() - 1)
                || checkCompareFunction(str)
                || checkBaseFunction(str)) {
            return true;
        }

        return false;
    }
    /**
     * 校验并解析类型2函数
     *
     * @return
     */
    private SymbolAndFunctionStrsBo checkTypeTwoFunctionObj(String str, String symbol) {
        String regexSymbol = symbol;
        if (CalculatingSignsEnum.PLUS.symbol.equals(symbol)) {
            regexSymbol = "\\+";

        }

        if (CalculatingSignsEnum.PRODUCT.symbol.equals(symbol)) {
            regexSymbol = "\\*";

        }

        String idsName;
        List<String> content = new ArrayList<>(2);

        String[] functionSplit = str.split(regexSymbol + "(?=(\\(|[^\\(]))");
        if (functionSplit.length == 2) {
            String[] headerSplit = functionSplit[0].split("=(?=(\\(|[^\\(]))");
            if (headerSplit.length == 2) {  // 有as
                idsName = headerSplit[0];
                String firstOfContent = headerSplit[1];
                content.add(firstOfContent);

            } else if (headerSplit.length == 1) {   // 没有as
                idsName = null;
                String firstOfContent = headerSplit[0];
                content.add(firstOfContent);

            } else {
                return null;

            }

            String secondOfContent = functionSplit[1];
            content.add(secondOfContent);

            return new SymbolAndFunctionStrsBo(symbol, content, idsName);
        }

        return null;

    }



    // 包含 + - * /
    private boolean checkBaseFunction(String str) {
        if (str.contains(CalculatingSignsEnum.PLUS.symbol)
                || str.contains(CalculatingSignsEnum.PRODUCT.symbol)
                || str.contains(CalculatingSignsEnum.DIVISION.symbol)
                || str.contains(CalculatingSignsEnum.MINUS.symbol)) {
            return true;
        }
        return false;
    }


    // 包含> >= < <= == !=
    private boolean checkCompareFunction(String str) {
        if (str.contains(CalculatingSignsEnum.MORE_THAN_EQUAL.symbol)
                || str.contains(CalculatingSignsEnum.LESS_THAN_EQUAL.symbol)
                || str.contains(CalculatingSignsEnum.MORE_THAN.symbol)
                || str.contains(CalculatingSignsEnum.LESS_THAN.symbol)
                || str.contains(CalculatingSignsEnum.NOT_EQUAL.symbol)
                || str.contains(CalculatingSignsEnum.EQUAL.symbol)) {
            return true;
        }
        return false;
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

    private boolean checkAllFunction (CalculatingSignsEnum calculatingSignsEnum) {
        CalculatingSignsEnum[] values = CalculatingSignsEnum.values();
        for (CalculatingSignsEnum value : values) {
            if (calculatingSignsEnum.name.equals(value.name)) {
                return true;
            }
        }
        return false;
    }

    private void analysisOfManyParamFunction(CustomFunctionObjBo parent, List<CustomFunctionObjBo> childs, List<ValueOfFunctionAndTypeBo> values, String str, CalculatingSignsEnum calculatingSignsEnum)  {
        parent.setFunction(calculatingSignsEnum);

        // 判断函数最外侧是否有括号包裹
        if (str.indexOf("(") == 0
                && str.lastIndexOf(")") == str.length() - 1) {
            str = str.substring(1, str.length() - 1);
        }

        // 拆解函数的参数
        FunctionsAnsAsBo functionsAnsAsBo = splitTypeOneFunctionStr(str, ",");

        List<String> functions = functionsAnsAsBo.getFunctions();
        int seq = 1;
        for (String function : functions) {    // 分数1>90

            // 判断函数最外侧是否有括号包裹
            if (function.indexOf("(") == 0
                    && function.lastIndexOf(")") == function.length() - 1) {
                function = function.substring(1, function.length() - 1);
            }

            if (checkFunction(function)) {   // 是函数
                CustomFunctionObjBo child = new CustomFunctionObjBo();
                child.setSeq(seq);
//                child.setNewAddedAttrName(as);
                analysis(child, function); // 递归
                if (child.isHaveIdsName()) {
                    parent.setHaveIdsName(true);
                }
                childs.add(child);
            } else {
                ValueOfFunctionAndTypeBo valueOfFunctionAndTypeBo;
                if (function.contains(".")) {
                    String[] split = function.split("\\.");
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(split[1], FUNCTION_VALUE_TYPE_COLUMN, seq);
                    parent.setHaveIdsName(true);
                } else if (function.contains("\"")) {
                    function = function.replaceAll("\"", "");
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_STRING, seq);

                } else if (function.contains("'")) {
                    function = function.replaceAll("'", "");
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_STRING, seq);

                } else if (isNumberType(function)) {
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_NUMBER, seq);

                } else {
                    valueOfFunctionAndTypeBo = new ValueOfFunctionAndTypeBo(function, FUNCTION_VALUE_TYPE_COLUMN, seq);

                }
                values.add(valueOfFunctionAndTypeBo);
            }

            seq += 1;

        }

        parent.setValues(values);
        parent.setChild(childs);

    }

    private FunctionsAnsAsBo splitTypeOneFunctionStr(String str, String split) {
        FunctionsAnsAsBo functionsAndAs = new FunctionsAnsAsBo();
        String pattern = split + "(?![^()]*+\\))";
        if (!str.contains("(")) {   // 无内嵌函数
            List<String> functions = Lists.newArrayList(str.split(pattern));
            functionsAndAs.setFunctions(functions);

        } else {    // 有内嵌函数
            List<String> functions = Lists.newArrayList();
            int start = 0;
            int end = 0;
            char[] chars = str.toCharArray();
            int functionStartCount = 0;
            int functionEndCount = 0;

            for (int i = 0; i < chars.length; i++) {

                if (chars[i] == '(') {
                    functionStartCount += 1;

                }

                if (chars[i] == ')') {
                    functionEndCount += 1;

                }

                // 判断逗号
                if (functionStartCount == functionEndCount) {
                    if (',' == chars[i]) {
                        end = i - 1;
                        functionStartCount = 0;
                        functionEndCount = 0;
                        functions.add(str.substring(start, end + 1));

                        if (i + 1 <= str.length() - 1) {
                            start = i + 1;

                        }

                    } else {
                        if (i == str.length() - 1) {
                            functions.add(str.substring(start));
                        }
                    }

                }


            }

            functionsAndAs.setFunctions(functions);

        }

        return functionsAndAs;
    }

    /**
     * 获取类型3函数
     *
     * @param str
     * @return
     */
    private SymbolAndFunctionStrsBo getTypeThreeFunctionObj(String str) {
        StringBuilder number = new StringBuilder();
        Stack<StrWithIndexBo> stack = new Stack<StrWithIndexBo>();
        for (int i = 0; i < str.length(); i++) {
            String temp = String.valueOf(str.charAt(i));
            if ("+".equals(temp) || "-".equals(temp)) {
                while (!stack.isEmpty()) {
                    if ("(".equals(stack.peek().getStr())) {
                        break;
                    }
                    number.append(stack.pop().getStr());

                }
                stack.push(new StrWithIndexBo(temp, i));
            } else if ("*".equals(temp) || "/".equals(temp)) {
                while (!stack.isEmpty()) {
                    String aa = stack.peek().getStr();
                    if ("(".equals(aa)) {
                        break;
                    }
                    if ("+".equals(aa) || "-".equals(aa)) {
                        break;
                    }
                    number.append(stack.pop().getStr());

                }
                stack.push(new StrWithIndexBo(temp, i));
            } else if ("(".equals(temp)) {

                //扫描到"("  直接入栈
                stack.push(new StrWithIndexBo(temp, i));

            } else if (")".equals(temp)) {
                while (!stack.isEmpty()) {
                    String tempF = stack.pop().getStr();
                    if ("(".equals(tempF)) {
                        break;

                    }
                    number.append(tempF);
                }

            } else {
                //扫描到操作数直接加入后缀表达式  即 加入操作数栈
                number.append(temp);

            }
        }


        StrWithIndexBo pop = stack.pop();
        String symbol = pop.getStr();
        Integer symbolIndex = pop.getIndex();
        String first = str.substring(0, symbolIndex);
        String second = str.substring(symbolIndex + 1);


        String idsName;
        List<String> content = new ArrayList<>(2);

        List<String> functionSplit = Arrays.asList(first, second);
        String[] headerSplit = functionSplit.get(0).split("=(?=(\\(|[^\\(]))");
        if (headerSplit.length == 2) {  // 有as
            idsName = headerSplit[0];
            String firstOfContent = headerSplit[1];
            content.add(firstOfContent);

        } else if (headerSplit.length == 1) {   // 没有as
            idsName = null;
            String firstOfContent = headerSplit[0];
            content.add(firstOfContent);

        } else {
            return null;

        }

        String secondOfContent = functionSplit.get(1);
        content.add(secondOfContent);

        return new SymbolAndFunctionStrsBo(symbol, content, idsName);

    }

}
