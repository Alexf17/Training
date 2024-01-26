package org.example._2023._25_12_23;

public class T1 {
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