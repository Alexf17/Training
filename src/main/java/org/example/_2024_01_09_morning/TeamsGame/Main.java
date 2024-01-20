package org.example._2024_01_09_morning.TeamsGame;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.example._2024_01_09_morning.TeamsGame.Handler.*;

public class Main {


    public static void main(String[] args) {

        Handler.start();

        System.out.println("-----------------Teams with max score------------------------------------");
//          Найти команду с максимальными баллами:
//        Streams.maxScore(adultTeamResults);
//        Streams.maxScore(teenAgerTeamResults);
//        Streams.maxScore(pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Total teams score---------------------------------------");
//          Подсчет общего количества баллов:
//        Streams.totalScore(adultTeamResults);
//        Streams.totalScore(teenAgerTeamResults);
//        Streams.totalScore(pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Teams without points------------------------------------");
//          Список команд без баллов:
//        Streams.withoutPoints(adultTeamResults);
//        Streams.withoutPoints(teenAgerTeamResults);
//        Streams.withoutPoints(pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Average age in team ------------------------------------");
//          Средний возраст участников в каждой команде:
//        Streams.getAverageAge(adultTeams);
//        Streams.getAverageAge(teenAgerTeams);
//        Streams.getAverageAge(pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with above average scores ------------------------");
//          Команды с баллами выше среднего:
//        Streams.getBestTeams(adultTeamResults);
//        Streams.getBestTeams(teenAgerTeamResults);
//        Streams.getBestTeams(pupilTeamResults);

        System.out.println();
        System.out.println("-----------------Teams that beat a given team ---------------------------");
//        Команды с победами над определенной командой: Определить команды, которые выиграли у заданной команды.
//        Streams.winnersTeams(fullAdultTeamResults, Generator.getRandomTeam(fullAdultTeamResults));
//        Streams.winnersTeams(fullTeenAgerTeamResults, Generator.getRandomTeam(fullTeenAgerTeamResults));
//        Streams.winnersTeams(fullPupilTeams, Generator.getRandomTeam(fullPupilTeams));

        System.out.println();
        System.out.println("-----------------The Youngest Participant in team------------------------");
//        Самый молодой участник среди всех команд:
//        Streams.getYoungestParticipant(adultTeams);
//        Streams.getYoungestParticipant(teenAgerTeams);
//        Streams.getYoungestParticipant(pupilTeams);

        System.out.println();
        System.out.println("-----------------The Oldest team-----------------------------------------");
//        Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.
//        Streams.getExperiencedTeam(adultTeams);
//        Streams.getExperiencedTeam(teenAgerTeams);
//        Streams.getExperiencedTeam(pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with participants in a age range------------------");
//        Команды с участниками в определенном возрастном диапазоне:
//        Streams.getTeamInAgeRange(adultTeams,44,30);
//        Streams.getTeamInAgeRange(teenAgerTeams,29,18);
//        Streams.getTeamInAgeRange(pupilTeams,17,9);

        System.out.println();
        System.out.println("-----------------Names of participants in order of age from max to min---");
//        Имена участников по убыванию возраста:
//        Streams.getParticipantsDescendingByAge(adultTeams);
//        Streams.getParticipantsDescendingByAge(teenAgerTeams);
//        Streams.getParticipantsDescendingByAge(pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with the greatest age range-----------------------");
//        Найти команду с наибольшим разбросом возрастов участников.
//        Streams.getTeamsWithMaxAgeRange(adultTeams);
//        Streams.getTeamsWithMaxAgeRange(teenAgerTeams);
//        Streams.getTeamsWithMaxAgeRange(pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with the same total age---------------------------");
//        Найти все пары команд, чьи участники имеют одинаковый суммарный возраст.
//        Streams.getTeamsWithSameTotalAge(adultTeams);
//        Streams.getTeamsWithSameTotalAge(teenAgerTeams);
//        Streams.getTeamsWithSameTotalAge(pupilTeams);


        System.out.println();
        System.out.println("-----------------Average Score in the team-------------------------------");
//        Вычислить средний балл для команд в каждой категории участников (Adult, Teenager, Pupil).
//        Streams.getAverageScore(adultTeams);
//        Streams.getAverageScore(teenAgerTeams);
//        Streams.getAverageScore(pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams that scores improved with each game---------------");
//        Найти команды, чьи баллы улучшались с каждой игрой.
//        Streams.getMostProgressiveTeam(adultTeams);
//        Streams.getMostProgressiveTeam(teenAgerTeams);
//        Streams.getMostProgressiveTeam(pupilTeams);
//
        System.out.println();
        System.out.println("-----------------Teams without losses------------------------------------");
//        Выявить команды, которые не имеют проигрышей.
//        Streams.getTeamsWithoutLoses(adultTeams);
//        Streams.getTeamsWithoutLoses(pupilTeams);
//        Streams.getTeamsWithoutLoses(teenAgerTeams);

        System.out.println();
        System.out.println("-----------------Teams with draw-----------------------------------------");
//        Список команд, которые имели ничейные результаты с заданной командой.
//        Streams.getTeamWithDraw(adultTeams, Generator.getRandomTeamName(adultTeams));
//        Streams.getTeamWithDraw(teenAgerTeams, Generator.getRandomTeamName(teenAgerTeams));
//        Streams.getTeamWithDraw(pupilTeams, Generator.getRandomTeamName(pupilTeams));

        System.out.println();
        System.out.println("-----------------All results between two team--------------------------------------");
//        Вывести результаты всех игр между двумя конкретными командами.
//        Streams.getResultsBetweenSpecificTeams(adultTeams);
//        Streams.getResultsBetweenSpecificTeams(teenAgerTeams);
//        Streams.getResultsBetweenSpecificTeams(pupilTeams);

        System.out.println();
        System.out.println("-----------------Compare two teams--------------------------------------");
//        Сравнить две команды по средним баллам и среднему возрасту участников.
//        Streams.checkTwoTeamsForPointsAndAge(adultTeams);
//        Streams.checkTwoTeamsForPointsAndAge(teenAgerTeams);
//        Streams.checkTwoTeamsForPointsAndAge(pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with unique participants name---------------------");
//        Найти команды, в которых все участники имеют уникальные имена.
//        Streams.getTeamWithUniqueParticipantsName(adultTeams);
//        Streams.getTeamWithUniqueParticipantsName(teenAgerTeams);
//        Streams.getTeamWithUniqueParticipantsName(pupilTeams);

        System.out.println();
        System.out.println("-----------------Teams with max wins-------------------------------------");
//        Определить команды с самой длинной последовательностью побед.
//        Streams.getMaxWinsTeam(adultTeams);
//        Streams.getMaxWinsTeam(teenAgerTeams);
//        Streams.getMaxWinsTeam(pupilTeams);

        System.out.println();
        System.out.println("-----------------The most draws team-------------------------------------");
//        Найти команды с наибольшим количеством ничьих результатов.
//        Streams.getMostDrawsTeam(adultTeams);
//        Streams.getMostDrawsTeam(teenAgerTeams);
//        Streams.getMostDrawsTeam(pupilTeams);

// !!!       Выявить команды, которые показали наибольшее улучшение баллов к концу сезона.

// !!!       Создать комплексный отчет, включающий средний возраст команды, общее количество баллов, наибольшую победную серию, и сравнение с другими командами.
    }

}
