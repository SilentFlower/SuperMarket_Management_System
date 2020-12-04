package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SiletFlower
 * @date 2020/11/30 13:16:10
 * @description
 */
public class DateUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static String getDateString(Date date){
        return simpleDateFormat.format(date);
    }

    public static Date getDate(String date) throws ParseException {
        return simpleDateFormat.parse(date);
    }
}
