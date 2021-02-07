package com.zhaokai.singleton;

public class demo {

    public static void main(String[] args) {
        String str = "晚来天欲雪 能饮一杯无";
        System.out.println("字符串的长度是："+str.length()); //字符串的雪字打印输出  charAt(int index)
        System.out.println(str.charAt(4)); //取出子串  天欲
        System.out.println(str.substring(2));   //取出从index2开始直到最后的子串，包含2
        System.out.println(str.substring(2,4));  //取出index从2到4的子串，包含2不包含4  顾头不顾尾
    }

}
