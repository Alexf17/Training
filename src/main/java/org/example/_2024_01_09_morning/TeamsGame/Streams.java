package org.example._2024_01_09_morning.TeamsGame;

import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Adult;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;


public class Streams {
    //    Найти команду с максимальными баллами:
    public static void maxScore(Map<String, Double> teamsResults) {
//        System.out.println(teamsResults.entrySet().stream().max(Comparator.comparingDouble((entry)->entry.getValue())));
        System.out.println(teamsResults.entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue)));
    }

    //    Подсчет общего количества баллов:
    public static void totalScore(Map<String, Double> teamsResults) {
        System.out.println(teamsResults.entrySet().stream().flatMapToDouble(entry -> DoubleStream.of(entry.getValue())).sum());
    }

    //    Список команд без баллов:
    public static void withoutPoints(Map<String, Double> teamsResults) {
        System.out.println(teamsResults.entrySet().stream().filter(entry -> entry.getValue() == 0).toList());
    }

    //        Средний возраст участников в каждой команде:
    public static <T extends Members> void getAverageAge(Set<Team<T>> teams) {
        System.out.println(teams.stream().flatMap(team->team.getMemberList().stream()).mapToInt(Members::getAge).average());
    }
}
