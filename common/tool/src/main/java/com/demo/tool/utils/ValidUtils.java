package com.demo.tool.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author huangjian
 * @version 1.0
 * @Description 常用正则校验
 * @date 2018/4/9
 */
public class ValidUtils {

    private static final String MOBILE = "^(13|15|18|17|16)[0-9]{9}$";

    private static final String CODE_AND_MOBILE = "^\\+[0-9]{2}\\-(13|15|18|17|16)[0-9]{9}$";

    /**
     * 整数
     */
    private static final String INTEGE = "^-?[1-9]\\d*$";
    /**
     * 正整数
     */
    private static final String INTEGE_1 = "^[1-9]\\d*$";
    /**
     * 负整数
     */
    private static final String INTEGE_2 = "^-[1-9]\\d*$";
    /**
     * 数字
     */
    private static final String NUM = "^([+-]?)\\d*\\.?\\d+$";
    /**
     * 正数（正整数 + 0）
     */
    private static final String NUM_1 = "^[1-9]\\d*|0$";
    /**
     * 负数（负整数 + 0）
     */
    private static final String NUM_2 = "^-[1-9]\\d*|0$";
    /**
     * 浮点数
     */
    private static final String DECMAL = "^([+-]?)\\d*\\.\\d+$";
    /**
     * 正浮点数
     */
    private static final String DECMAL_1 = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";
    /**
     * 负浮点数
     */
    private static final String DECMAL_2 = "^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$";
    /**
     * 浮点数
     */
    private static final String DECMAL_3 = "^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$";
    /**
     * 非负浮点数（正浮点数 + 0）
     */
    private static final String DECMAL_4 = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$";
    /**
     * 非正浮点数（负浮点数 + 0）
     */
    private static final String DECMAL_5 = "^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$";
    /**
     * 邮件
     */
    private static final String EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    /**
     * 颜色
     */
    private static final String COLOR = "^[a-fA-F0-9]{6}$";
    /**
     * URL
     */
    private static final String URL = "^http[s]?=\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";
    /**
     * 仅中文
     */
    private static final String CHINESE = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
    /**
     * 仅ACSII字符
     */
    private static final String ASCII = "^[\\x00-\\xFF]+$";
    /**
     * 邮编
     */
    private static final String ZIPCODE = "^\\d{6}$";
    /**
     * ip地址
     */
    private static final String IP_4 = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";
    /**
     * 非空
     */
    private static final String NOTEMPTY = "^\\S+$";
    /**
     * 图片
     */
    private static final String PICTURE = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$";
    /**
     * 压缩文件
     */
    private static final String RAR = "(.*)\\.(rar|zip|7zip|tgz)$";
    /**
     * 日期
     */
    private static final String DATE = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";
    /**
     * QQ号码
     */
    private static final String QQ = "^[1-9]*[1-9][0-9]*$";
    /**
     * 电话号码的函数(包括验证国内区号;国际区号;分机号)
     */
    private static final String TEL = "^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{1,}))?$";
    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     */
    private static final String USERNAME = "^\\w+$";
    /**
     * 字母
     */
    private static final String LETTER = "^[A-Za-z]+$";
    private static final String LETTER_AND_SPACE = "^[A-Za-z ]+$";
    /**
     * 大写字母
     */
    private static final String LETTER_U = "^[A-Z]+$";
    /**
     * 小写字母
     */
    private static final String LETTER_L = "^[a-z]+$";
    /**
     * 身份证
     */
    private static final String IDCARD = "^[1-9]([0-9]{14}|[0-9]{17})$";
    /**
     * 判断字符串是否为浮点数
     */
    private static final String IS_FLOAT = "^[-]?\\d+(\\.\\d+)?$";
    /**
     * 判断字符串是否为正浮点数
     */
    private static final String IS_U_FLOAT = "^\\d+(\\.\\d+)?$";
    /**
     * 判断是否是整数
     */
    private static final String IS_INTEGER = "^[-]?\\d+$";
    /**
     * 判断是否是正整数
     */
    private static final String IS_U_INTEGER = "^\\d+$";
    /**
     * 判断车辆Vin码
     */
    private static final String IS_CAR_VIN = "^[1234567890WERTYUPASDFGHJKLZXCVBNM]{13}[0-9]{4}$";

    /**
     * 手机号
     */
    public static boolean isMobile(String input) {
        return matches(MOBILE, input);
    }

    public static boolean isCodeAndMobile(String input) {
        return matches(CODE_AND_MOBILE, input);
    }

    /**
     * 整数
     */
    public static boolean isIntege(String input) {
        return matches(INTEGE, input);
    }

    /**
     * 正整数
     */
    public static boolean isintege1(String input) {
        return matches(INTEGE_1, input);
    }

    /**
     * 负整数
     */
    public static boolean isIntege2(String input) {
        return matches(INTEGE_2, input);
    }

    /**
     * 数字
     */
    public static boolean isNum(String input) {
        return matches(NUM, input);
    }

    /**
     * 正数（正整数 + 0）
     */
    public static boolean isNum1(String input) {
        return matches(NUM_1, input);
    }

    /**
     * 负数（负整数 + 0）
     */
    public static boolean isNum2(String input) {
        return matches(NUM_2, input);
    }

    /**
     * 浮点数
     */
    public static boolean isDecmal(String input) {
        return matches(DECMAL, input);
    }

    /**
     * 正浮点数
     */
    public static boolean isDecmal1(String input) {
        return matches(DECMAL_1, input);
    }

    /**
     * 负浮点数
     */
    public static boolean isDecmal2(String input) {
        return matches(DECMAL_2, input);
    }

    /**
     * 浮点数
     */
    public static boolean isDecmal3(String input) {
        return matches(DECMAL_3, input);
    }

    /**
     * 非负浮点数（正浮点数 + 0）
     */
    public static boolean isDecmal4(String input) {
        return matches(DECMAL_4, input);
    }

    /**
     * 非正浮点数（负浮点数 + 0）
     */
    public static boolean isDecmal5(String input) {
        return matches(DECMAL_5, input);
    }

    /**
     * 邮件
     */
    public static boolean isEmail(String input) {
        return matches(EMAIL, input);
    }

    /**
     * 颜色
     */
    public static boolean isColor(String input) {
        return matches(COLOR, input);
    }

    /**
     * URL
     */
    public static boolean isUrl(String input) {
        return matches(URL, input);
    }

    /**
     * 中文
     */
    public static boolean isChinese(String input) {
        return matches(CHINESE, input);
    }

    /**
     * ascii码
     */
    public static boolean isAscii(String input) {
        return matches(ASCII, input);
    }

    /**
     * 邮编
     */
    public static boolean isZipcode(String input) {
        return matches(ZIPCODE, input);
    }

    /**
     * IP地址
     */
    public static boolean isIP4(String input) {
        return matches(IP_4, input);
    }

    /**
     * 非空
     */
    public static boolean isNotEmpty(String input) {
        return matches(NOTEMPTY, input);
    }

    /**
     * 图片
     */
    public static boolean isPicture(String input) {
        return matches(PICTURE, input);
    }

    /**
     * 压缩文件
     */
    public static boolean isRar(String input) {
        return matches(RAR, input);
    }

    /**
     * 日期
     */
    public static boolean isDate(String input) {
        return matches(DATE, input);
    }

    /**
     * QQ
     */
    public static boolean isQQ(String input) {
        return matches(QQ, input);
    }

    /**
     * 电话号码的函数(包括验证国内区号;国际区号;分机号)
     */
    public static boolean isTel(String input) {
        return matches(TEL, input);
    }

    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     */
    public static boolean isUserName(String input) {
        return matches(USERNAME, input);
    }

    /**
     * 字母
     */
    public static boolean isLetter(String input) {
        return matches(LETTER, input);
    }

    public static boolean isLetterAndSpace(String input) {
        return matches(LETTER_AND_SPACE, input);
    }

    /**
     * 小写字母
     */
    public static boolean isLowLetter(String input) {
        return matches(LETTER_L, input);
    }

    /**
     * 大写字母
     */
    public static boolean isUpperLetter(String input) {
        return matches(LETTER_U, input);
    }

    /**
     * 身份证
     */
    public static boolean isIDCard(String input) {
        return matches(IDCARD, input);
    }

    public static boolean isFloat(String input) {
        return matches(IS_FLOAT, input);
    }

    public static boolean isUFloat(String input) {
        return matches(IS_U_FLOAT, input);
    }

    public static boolean isInteger(String input) {
        return matches(IS_INTEGER, input);
    }

    public static boolean isUInteger(String input) {
        return matches(IS_U_INTEGER, input);
    }

    public static boolean isCarVin(String carVin) {
        return matches(IS_CAR_VIN, carVin);
    }

    public static boolean matches(String regex, String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        if (input.matches(regex)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isInteger("1"));
        System.out.println(isInteger("0"));
        System.out.println(isInteger("-1"));
        System.out.println(isInteger("1.0"));
        System.out.println("--------------------");
        System.out.println(isUInteger("-1"));
        System.out.println(isUInteger("0"));
        System.out.println(isUInteger("10"));
        System.out.println(isUInteger("1.3"));
        System.out.println(isLetterAndSpace("tai  wan"));

    }
}
