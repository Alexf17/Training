package org.example._25_12_23;

public class Main {
    public static void main(String[] args) {
met ((s)->s.length(),"awddawdw");
    }
    public static void met (StringLength stringLength, String str){
        System.out.println(stringLength.getLength(str));
    }


}
@FunctionalInterface
interface StringLength {
    int getLength(String str);
    int hashCode();
}