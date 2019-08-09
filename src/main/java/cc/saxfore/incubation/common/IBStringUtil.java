/**
 * (C) Copyright 2017 BmSmart(Beijing) Technology * Co.Ltd.
 * All Rights Reserved.
 **/
package cc.saxfore.incubation.common;

import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串实例处理工具类
 *
 * @author Administrator
 * @date 2015年4月15日 下午6:08:24
 */
public class IBStringUtil {
    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";

    /**
     * 生成主键的方法
     *
     * @return
     */
    public static String generalID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 判断字符串是否为null
     *
     * @param str 待验证的字符串
     * @return 如果为NULL返回true，否则返回false
     */
    public static boolean isNull(String str) {
        boolean result = str == null ? true : false;
        return result;
    }

    /**
     * 判断字符串是否不为null
     *
     * @param str 待验证的字符串
     * @return 如果为NULL返回false，否则返回true
     */
    public static boolean isNotNull(String str) {
        boolean result = str != null ? true : false;
        return result;
    }

    /**
     * 判断字符串是否为空白
     *
     * @param str 待验证的字符串
     * @return 如果为空白字符串或者Null返回true，否则返回false
     */
    public static boolean isBlank(String str) {
        boolean result = false;
        if (isNull(str)) {
            result = true;
        } else if ("".equals(str.trim())) {
            result = true;
        }
        return result;
    }

    /**
     * 判断字符串是否不为空白
     *
     * @param str 待验证的字符串
     * @return 不过为空白字符串返回false，否则返回true
     */
    public static boolean isNotBlank(String str) {
        boolean result = true;
        if (isNull(str)) {
            result = false;
        } else if ("".equals(str.trim())) {
            result = false;
        }
        return result;
    }

    /**
     * <p>Title: str2HexStr</p>
     * <p>Description: 将字符串转换为16进制的形式 </p>
     *
     * @param content 待转换的字符串
     * @return 转换后的字符串
     */
    public static String str2HexStr(final String content) {
        Assert.hasText(content, "content不能为空");

        byte[] b = content.getBytes();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String strTmp = Integer.toHexString(b[i]);
            if (strTmp.length() > 2) {
                strTmp = strTmp.substring(strTmp.length() - 2);
            }
            sb.append(strTmp);
        }

        return sb.toString();
    }

    /**
     * <p>Title: hexStr2Str</p>
     * <p>Description: 将16进制形式的字符串还原为原文</p>
     *
     * @param hexStrContent 待还原的字符串
     * @param charSet       使用的字符编码
     * @return 转换后的字符原文
     * @throws UnsupportedEncodingException charSet设置错误时将会抛出该异常
     */
    public static String hexStr2Str(String hexStrContent, String charSet) throws UnsupportedEncodingException {
        Assert.hasText(hexStrContent, "hexStrContent不能为空");
        Assert.hasText(charSet, "charSet不能为空");
        byte[] contByte = new byte[hexStrContent.length() / 2];
        for (int i = 0; i < contByte.length; i++) {
            contByte[i] = (byte) (0xff & Integer.parseInt(hexStrContent.substring(i * 2, i * 2 + 2), 16));
        }
        return new String(contByte, charSet);
    }

    /**
     * 转换为字节数组
     *
     * @param str
     * @return
     */
    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 转换为Boolean类型
     * 'true', 'on', 'y', 't', 'yes' or '1' (case insensitive) will return true. Otherwise, false is returned.
     */

    /**
     * 如果对象为空，则使用defaultVal值
     * see: ObjectUtils.toString(obj, defaultVal)
     *
     * @param obj
     * @param defaultVal
     * @return
     */
    public static String toString(final Object obj, final String defaultVal) {
        return obj == null ? defaultVal : obj.toString();
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 替换为手机识别的HTML，去掉样式及属性，保留回车。
     *
     * @param html
     * @return
     */
    public static String replaceMobileHtml(String html) {
        if (html == null) {
            return "";
        }
        return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 将一串使用特定分割符的字符串转换成List
     *
     * @param str
     * @param separator
     * @return
     */
    public static List<String> str2List(String str, String separator) {
        List<String> stringList = new ArrayList<>();

        if (!isBlank(str) && !isBlank(separator)) {
            String[] strArr = str.split(separator);
            if (strArr != null && strArr.length > 0) {
                stringList.addAll(Arrays.asList(strArr));
            }
        }

        if (stringList.isEmpty()) {
            stringList.add(str);
        }

        return stringList;
    }

    /**
     * 将List转换成特定分割符的字符串
     *
     * @param stringList
     * @param separator
     * @return
     */
    public static String list2Str(List<String> stringList, String separator) {
        if (stringList == null || stringList.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stringList) {
            sb.append(str).append(separator);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }


}
