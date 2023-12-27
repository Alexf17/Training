package org.example._25_12_23;


public class T7 {
    public static void main(String[] args) {
met(el -> {
   String []r = el.split(" ");
    int uniqueWord = 0;
    StringBuilder unique = new StringBuilder();
    for (String string : r) {
        if (unique.indexOf(string) == -1) {
            unique.append(string).append(",");
            uniqueWord++;
        }
    }
   return uniqueWord;

},"Hello my name is Alex name");
    }
    public static void met(TextAnalyzer textAnalyzer, String text){
        System.out.println(textAnalyzer.analyze(text));
    }
}
//    Создайте функциональный интерфейс TextAnalyzer с методом analyze, который принимает текст и анализирует его,
//    возвращая результат анализа.
//    Напишите метод, который принимает строку и TextAnalyzer, и подсчитывает количество уникальных слов в тексте.
@FunctionalInterface
interface TextAnalyzer{
    int analyze(String text);
}
