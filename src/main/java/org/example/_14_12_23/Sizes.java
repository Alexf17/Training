package org.example._14_12_23;

public enum Sizes {
    XS, S, M, L, XL;

    public boolean isEquals(){
        Sizes s = Sizes.valueOf(this.toString());
        System.out.println(s);
        boolean equal = false;
        for(Sizes s2 : Sizes.values()){
            if (s == s2) {
                equal = true;
                break;
            }
        }
            return equal;


    }
    //    Задача: Размеры одежды
//    Создайте перечисление (enum) для представления размеров одежды (XS, S, M, L, XL).
//    Напишите метод, который принимает на вход размер и возвращает true, если размер существует
//    в перечислении, и false в противном случае. Используйте цикл и метод values() для проверки.
}
