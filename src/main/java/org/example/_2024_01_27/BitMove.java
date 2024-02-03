package org.example._2024_01_27;

public class BitMove {

    public static String printBinary(int b) {

       return Integer.toBinaryString(0b10000000 | (b & 0xff)).substring(1);
    }


    public static void main(String[] args) {
        int a = 5;  // 00000101
        int c = 1;
        int b = 111; //0 1 1 0 1 1 1 1
        int ab = 0b000101;
        System.out.println(ab);

//        System.out.println("Сдвиг вправо: "+(a>>1));
//        System.out.println("Сдвиг влево: "+(a<<1));
//        System.out.println("Сдвиг влево: "+(a<<2));
        int a1 = 0b00001001;
        int b1 = 0b00001010;


        System.out.println(" '|' OR : ");
        printBinary(a1);
        printBinary(b1);
        printBinary(a1 | b1);

        System.out.println(" '&' AND : ");
//        System.out.println(printBinary(5));
//        System.out.println(printBinary(a&c));
//        System.out.println(printBinary(a|c));
//        System.out.println(printBinary(a^c));
//        System.out.println(printBinary(a-c-c));
        int r = Integer.parseInt(Integer.toBinaryString(a));
//     byte f =  Byte.parseByte(a);
        System.out.println(r);
        System.out.println(printBinary(r^a));

//        static int countOnesInBinary(int num) {
//            int count = 0;
//            while (num > 0) {
//                count += num & 1;
//                num >>= 1;
//            }
//            return count;
//        }

//        System.out.println(printBinary(b1));
//        System.out.println(printBinary(a1 & b1));
        int t = Integer.parseInt(printBinary(a1 & b1));
//        System.out.println(r);
        int u = Integer.parseInt(printBinary(r & b1));
//        System.out.println(u);

        System.out.println(" '^' XOR : ");
        printBinary(a1);
        printBinary(b1);
        printBinary(a1^ b1);

        System.out.println(" '~' inversion : ");
        printBinary(a);
        printBinary(~a);

    }
}
