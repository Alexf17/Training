package org.example._2024_01_18;

public class Utils {
    public static <T extends Number> T add(T arg1,T arg2) {
        return (T)Double.valueOf(arg2.doubleValue()+ arg1.doubleValue());
    }
}
