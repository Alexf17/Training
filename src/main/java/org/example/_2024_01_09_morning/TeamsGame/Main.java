package org.example._2024_01_09_morning.TeamsGame;

import static org.example._2024_01_09_morning.TeamsGame.Handler.*;

public class Main {


    public static void main(String[] args) {

        Handler.start();
        System.out.println("----------------Teams with max score-------------------------------------");
        //    Найти команду с максимальными баллами:
        Streams.maxScore(adultTeamResults);
        Streams.maxScore(teenAgerTeamResults);
        Streams.maxScore(pupilTeamResults);
        System.out.println("-----------------Total teams score---------------------------------------");
//        Подсчет общего количества баллов:
        Streams.totalScore(adultTeamResults);
        Streams.totalScore(teenAgerTeamResults);
        Streams.totalScore(pupilTeamResults);
        System.out.println("-----------------Teams without points------------------------------------");
//        Список команд без баллов:
        Streams.withoutPoints(adultTeamResults);
        Streams.withoutPoints(teenAgerTeamResults);
        Streams.withoutPoints(pupilTeamResults);
        System.out.println("-----------------Average age in team ------------------------------------");
//        Средний возраст участников в каждой команде:
        Streams.getAverageAge(adultTeams);
        Streams.getAverageAge(teenAgerTeams);
        Streams.getAverageAge(pupilTeams);

    }

}
