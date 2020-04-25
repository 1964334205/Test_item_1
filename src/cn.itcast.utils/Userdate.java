package cn.itcast.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Userdate {
    public static String transform(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);

    }
}
