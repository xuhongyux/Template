package com.xiayu.work;

/**
 * @author xuhongyu
 * @create 2021-07-14 15:21
 */
public class Test extends Object {
    public static void main(String[] args) throws  CloneNotSupportedException  {
        RiskLevelButtonVo riskLevelButtonVo = new RiskLevelButtonVo();
        RiskLevelButtonVo clone = (RiskLevelButtonVo) riskLevelButtonVo.clone();
        riskLevelButtonVo.setPayType("12312312");
        clone.setPayType("中挖坟啊的服务");

        System.out.println(clone);
    }
}
