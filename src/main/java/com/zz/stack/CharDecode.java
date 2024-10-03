package com.zz.stack;

/**
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。*/

public class CharDecode {

    private int ptr = 0;

    public String decodeString(String s) {
        // 返回结果
        String ret = "";
        // 递归推出条件
        if(ptr == s.length() || s.charAt(ptr) == ']') {
            return ret;
        }

        char ch = s.charAt(ptr);
        int repeat = 1;
        // 数字：解析数字
        if(Character.isDigit(ch)) {
            repeat = getDigit(s);
            // 过滤掉'['
            ptr++;
            String subRes = decodeString(s);
            // 过滤掉 ']'
            ptr++;
            while (repeat-- > 0) {
                ret = ret + subRes;
            }
        } else if(Character.isLetter(ch)) {
            // 字符：解析字符
            ret = String.valueOf(ch);
            ptr++;
        }

        return ret + decodeString(s);
    }

    // 获取字符串 s 的连续数字位并返回对应的整型数字
    private int getDigit(String s) {
        int start = ptr;
        while (Character.isDigit(s.charAt(ptr))) {
            ptr++;
        }
        String digit = s.substring(start, ptr);
        return Integer.parseInt(digit);
    }
}
