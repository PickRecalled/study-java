package com.pickrecalled;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Objects;

public class StringFormatUtil {
    private static final String LEFT = "{";
    private static final String RIGHT = "}";

    public static String format(String message, Object[] params) {
        if (Objects.isNull(message) || ArrayUtils.isEmpty(params)) {
            return message;
        }
        message = formatMessage(message);
        for (int index = 0; index < params.length; index++) {
            message = message.replace(build(index), String.valueOf(params[index]));
        }
        return message;
    }

    private static String formatMessage(String message) {
        String temp = message;
        int index = 0;
        while (hasOne(message)) {
            String target = message.substring(message.indexOf(LEFT), message.indexOf(RIGHT) + 1);
            message = message.substring(message.indexOf(target) + target.length());
            temp = temp.replace(target, build(index++));
        }
        return temp;
    }

    private static boolean hasOne(String data) {
        int left = data.indexOf(LEFT);
        int right = data.indexOf(RIGHT);
        return left >= 0 && right >= 0 && left < right;
    }

    private static String build(int index) {
        return contact(LEFT, String.valueOf(index), RIGHT);
    }

    public static String contact(Object strOne, Object strTwo, String connector) {
        StringBuilder sb = new StringBuilder();
        sb.append(strOne);
        sb.append(connector);
        sb.append(strTwo);
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = StringFormatUtil.format("这是测试第一个参数{}，第二个参数{}", new Object[] {"124", "ABC"});
        System.out.println("test:" + test);
    }
}
