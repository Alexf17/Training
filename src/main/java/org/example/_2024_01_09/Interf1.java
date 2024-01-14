package org.example._2024_01_09;

import java.util.function.Consumer;

public class Interf1 {
    public static void main(String[] args) {
//        У нас есть профессия в строительстве - чернорабочий. Он может выполнять любые низкоквалифицированные работы на стройке.
//        На каждый день ему дается список работ, которые он должен выполнить, но не факт что в течении рабочего времени его задание
//        может измениться.
//        Напишите программу рабочего дня профессии, которая позволяет динамический давать ему задание на работу, в любое нужное время.
//        И он их должен выполнять. Применяйте функциональные интерфейсы.
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String string) {
                String work = switch(string){
                    case "кирпичи" -> "ношу кирпичи";
                    case "сено" -> "ношу сено";
                    default-> "отдіх";

                };
                System.out.println(work);
            }

        };
       consumer.accept("сено");
    }

}
