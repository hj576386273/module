package com.demo.tool.utils;

import java.util.Random;

/**
 * @author huangjian
 * @version 1.0
 * @Description TODO
 * @date 2018/4/18
 */
public class StringUtils {

    private static Random random = new Random();

    private static final String[] num_str = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /**
      * @author huangjian
      * @Description 获取随机位数数值的字符串(可以以0开头)
      * @Date 2018/4/18
      * @Param [leng] 字符位数
      * @return java.lang.String
      */
    public static String getRandomNumStr(int leng){
        String result = "";
        while (leng > 0){
            result += random.nextInt(num_str.length);
            leng--;
        }
        return result;
    }

    /**
      * @author huangjian
      * @Description 获取从0开始的随机数字
      * @Date 2018/4/18
      * @Param [num]
      * @return int
      */
    public static int getRandom(int num) {
        return random.nextInt(num);
    }

    /**
     * 原理:要得到的随机数的范围是[2,100]，假设返回的伪随机数的范围是[0,N)，
     * 也即[0,N-1];对得到的这个数模99，于是计算得到的数的范围是[0,98]； 再把结果加2，范围就是[2,100]了。
     */
    public static String getRandom(int min, int max) {
        int s = random.nextInt(max) % (max - min + 1) + min;
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        for(int x=0; x<1000; x++){
            System.out.println(getRandomNumStr(6));

        }
    }

}
