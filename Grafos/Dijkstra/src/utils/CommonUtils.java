package utils;

import java.util.Collection;

public class CommonUtils {

    public static String SPACE = " ";

    public static Boolean isNull(Object object) {
        return object == null;
    }

    public static Boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static Boolean isZero(Number number) {
        Boolean isZero = false;
        if (isNotNull(number)) {
            isZero = number.doubleValue() == 0L;
        }
        return isZero;
    }

    public static boolean isEmpty(Collection coll) {
        return (coll == null || coll.isEmpty());
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

    public static Boolean isNotZero(Number number) {
        return !isZero(number);
    }

}
