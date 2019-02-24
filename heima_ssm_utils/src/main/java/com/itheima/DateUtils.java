package com.itheima;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 日期转化成字符串
     * @param date
     * @param patt
     * @return
     */
    public static String dataToString (Date date,String patt){
        SimpleDateFormat sdf =new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    public static Date StringToData (String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}
