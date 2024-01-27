package org.example._2024_01_27;

public class BitMove {

    public static void printBinary(int b) {
        System.out.println("0b " + Integer.toBinaryString(0b10000000 | (b & 0xff)));
    }

    public static void main(String[] args) {
        int a = 5;  // 00000101
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
        printBinary(a1);
        printBinary(b1);
        printBinary(a1 & b1);

        System.out.println(" '^' XOR : ");
        printBinary(a1);
        printBinary(b1);
        printBinary(a1 ^ b1);

        System.out.println(" '~' inversion : ");
        printBinary(a1);
        printBinary(~a1);

    }
}
