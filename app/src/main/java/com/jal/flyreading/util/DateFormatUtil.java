package com.jal.flyreading.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SEELE on 2017/4/6.
 * 日期转换工具类
 */

public class DateFormatUtil {

    public static String zhuHuDailyDateFormart(long date) {
        Date d = new Date(date + 24 * 60 * 60 * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(d);
        return format;
    }

    public static String douBanDateFormart(long date) {
        Date d = new Date(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(d);
        return format;
    }

}
