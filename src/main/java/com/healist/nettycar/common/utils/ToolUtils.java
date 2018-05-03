package com.healist.nettycar.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title:  </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017  </p>
 * <p>Company: netease
 * <p>@author: lanyl</p>
 * <p>@Create Time: 2017年12月20日 19:45  </p>
 **/
public class ToolUtils {
    /**
     * 判断字符串是否是中文
     * @param str
     * @return
     */
    public static boolean isChinese(String str){
        if(StringUtils.isBlank(str)){
            return false;
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符是否是中文
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }


    public static Date timestamp2Date(String time) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long timeStamp = Long.valueOf(time);
        System.out.println(time);
        String d = format.format(new Date(timeStamp * 1000L));
        Date date = null;
        try {
            date=format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}


