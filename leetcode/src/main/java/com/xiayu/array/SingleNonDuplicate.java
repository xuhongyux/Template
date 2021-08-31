package com.xiayu.array;

/**
 * @author xuhongyu
 * @describe
 *  540 .有序数组的单一元素
 *  给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * @create 2020-11-25-11:35
 */
public class SingleNonDuplicate {

    public static void main(String[] args) {
        int [] arrys  = new int[] {1,1,2,2,3,5,5};
        int solution = solution(arrys);
        System.out.println(solution);
    }
    /**
     * 暴力破解
     */
    public static int solution(int [] arrys ){
        Integer one = Num.valueOf("ONE").getInfo();
        for(int i = 0; i<arrys.length; i += Num.valueOf("ONE").getInfo()){
            if(arrys[i] != arrys[i+1]){
                return arrys[i];
            }
        }
       return arrys[arrys.length-1];
    }
}

enum Num{
    ONE(1){
       public int getContent(){
           return 2;
       }
       @Override
       Integer getInfo(){
           return 2;
       }
    };

    Num(int i) {

    }
    abstract Integer getInfo();
}
