package org.example._2024_01_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        String[][]arrStr = {{"a,b,c"},{"d","e","f"}};
        List<String> list = Arrays.stream(arrStr).flatMap(x->Arrays.stream(x)).collect(Collectors.toList());
        System.out.println(list);}
}
