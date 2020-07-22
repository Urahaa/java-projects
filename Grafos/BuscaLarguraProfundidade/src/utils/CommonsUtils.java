package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonsUtils {

    public static boolean isNotNull(final Object value) {
        return value != null;
    }

    public static boolean isEmpty(final Object[] value) {
        return value == null || value.length == 0 || (value.length == 1 && value[0] == null);
    }

    public static boolean isNotEmpty(final Object[] value) {
        return !isEmpty(value);
    }

    public static boolean isNotEmpty(final String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isNotEmpty(final Object value) {
        if (value != null) {
            if (value instanceof String) {
                return isNotEmpty((String) value);
            } else {
                return true;
            }
        }
        return false;
    }

    public static String gerarData() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
