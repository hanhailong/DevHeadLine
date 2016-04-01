package com.hhl.devheadline.utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/3/29.
 */
public class AppTools {
    /**
     * 截取长字符
     * @param str
     * @return
     */
    public static String clipLongText(String str) {
        if (str != null) {
            final String encoding = "GBK";
            try {
                byte[] b = str.getBytes(encoding);
                if (b.length > 20) {
                    int end = 16;
                    String result = new String(b, 0, end, encoding);
                    if (str.indexOf(result) == -1) {
                        return new String(b, 0, end - 1, encoding) + "...";
                    }
                    return result + "...";
                }
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return str;
    }
}
