package org.example.TeamsGame;

import org.example.TeamsGame.TypesOfPlayers.Adult;
import org.example.TeamsGame.TypesOfPlayers.Pupil;
import org.example.TeamsGame.TypesOfPlayers.TeenAger;

import java.util.*;
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
        System.out.println(teams.stream().flatMap(team -> team.getMemberList().stream()).mapToInt(Members::getAge).average().orElse(0.0));
    }

    //    Команды с баллами выше среднего:
    public static void getBestTeams(Map<String, Double> teamsResults) {
        double averageScore = teamsResults.entrySet().stream().mapToDouble(e -> e.getValue()).average().getAsDouble();
        System.out.println(teamsResults.entrySet().stream().filter(e -> e.getValue() > averageScore).toList());
    }

    //    Команды с победами над определенной командой: Определить команды, которые выиграли у заданной команды.
    public static <T extends Members> void winnersTeams(Map<Team<T>, Double> teams, Team<T> teamName) {
        System.out.println(teams.keySet().stream().filter(t -> t.getWins().contains(teamName.getTeamName())).map(t -> t.getTeamName()).toList());
    }

    //        Самый молодой участник среди всех команд:
    public static <T extends Members> void getYoungestParticipant(Set<Team<T>> teams) {
        System.out.println(teams.stream().flatMap(e -> e.getMemberList().stream()).min(Comparator.comparingInt(Members::getAge)).stream().toList());
    }

    //        Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.
    public static <T extends Members> void getExperiencedTeam(Set<Team<T>> teams) {
        System.out.println(teams.stream().max(Comparator.comparingInt(t -> t.getMemberList().stream().mapToInt(e -> e.getAge()).sum())).map(e -> e.getTeamName()).orElse(""));
    }

    //        Команды с участниками в определенном возрастном диапазоне:
    public static <T extends Members> void getTeamInAgeRange(Set<Team<T>> teams, int max, int min) {
        System.out.println(teams.stream().filter(e -> e.getMemberList().stream().allMatch(t -> t.getAge() >= min && t.getAge() <= max)).map(e -> e.getTeamName()).toList());
    }

    //        Имена участников по убыванию возраста:
    public static <T extends Members> void getParticipantsDescendingByAge(Set<Team<T>> teams) {
        System.out.println(teams.stream().flatMap(e -> e.getMemberList().stream()).sorted(Comparator.comparingInt(Members::getAge).reversed()).toList());
    }

    //        Найти команду с наибольшим разбросом возрастов участников.
    public static <T extends Members> void getTeamsWithMaxAgeRange(Set<Team<T>> teams) {
        System.out.println(teams.stream().max(Comparator.comparingInt(t -> {
            int maxAge = t.getMemberList().stream().mapToInt(p -> p.getAge()).max().orElse(0);
            int minAge = t.getMemberList().stream().mapToInt(p -> p.getAge()).min().orElse(0);
            return maxAge - minAge;
        })));
    }

    //        Найти все пары команд, чьи участники имеют одинаковый суммарный возраст.
    public static <T extends Members> void getTeamsWithSameTotalAge(Set<Team<T>> teams) {
        teams.stream()
                .collect(Collectors
                        .groupingBy(t -> t.getMemberList()
                                .stream()
                                .mapToInt(member -> member.getAge())
                                .sum(), Collectors.toList())).forEach((a, b) -> {
                    if (b.size() > 1) {
                        System.out.println("Total age: " + a);
                        b.forEach(member -> System.out.println(member.getTeamName()));
                        System.out.println("---");
                    }
                });

    }

    //        Вычислить средний балл для команд в каждой категории участников (Adult, Teenager, Pupil).
    public static <T extends Members> void getAverageScore(Set<Team<T>> teams) {
        System.out.println(teams.stream().mapToDouble(Team::getTeamScore).average().orElse(0.0));
    }

    //        Найти команды, чьи баллы улучшались с каждой игрой.
    public static <T extends Members> void getMostProgressiveTeam(Set<Team<T>> teams) {
        System.out.println(teams.stream().min(Comparator.comparingInt(t -> {
            int games = t.getGameСounter();
            int wins = t.getWins().size();
            return games - wins;
        })).map(e -> e.getTeamName() + " : " + e.getWins().size() + " wins in " + e.getGameСounter() + " games").stream().toList());
    }

    //        Выявить команды, которые не имеют проигрышей.
    public static <T extends Members> void getTeamsWithoutLoses(Set<Team<T>> teams) {
        System.out.println(teams.stream().filter(t -> t.getLosses().isEmpty()).map(Team::getTeamName).toList());
    }

    //        Список команд, которые имели ничейные результаты с заданной командой.
    public static <T extends Members> void getTeamWithDraw(Set<Team<T>> teams, String teamName) {
        System.out.println(teams.stream().filter(t -> t.getWins().contains(teamName)).map(e -> e.getTeamName()).toList());
    }

    //        Вывести результаты всех игр между двумя конкретными командами.
    public static <T extends Members> void getResultsBetweenSpecificTeams(Set<Team<T>> teams) {
        Team<T> team1 = Generator.getRandomTeam(teams);
        Team<T> team2 = Generator.getRandomTeam(teams);
        if (Objects.equals(team1.getTeamName(), team2.getTeamName())){
            team2 = Generator.getRandomTeam(teams);
        }
        Team<T> finalTeam = team2;
        long wins = team1.getWins().stream().filter(r -> r.contains(finalTeam.getTeamName())).count();
        long losses = team1.getLosses().stream().filter(r -> r.contains(finalTeam.getTeamName())).count();
        long draws = team1.getDraws().stream().filter(r -> r.contains(finalTeam.getTeamName())).count();
        System.out.println("Team '" + team1.getTeamName() + "' play with '" + team2.getTeamName() + "'");
        System.out.println("'" + team1.getTeamName() + "' win " + wins + ", lose "
                + losses + " and draw " + draws + " times");
        System.out.println("---");
    }


    //        Сравнить две команды по средним баллам и среднему возрасту участников.
    public static <T extends Members> void checkTwoTeamsForPointsAndAge(Set<Team<T>> teams) {
        Team<T> team1 = Generator.getRandomTeam(teams);
        Team<T> team2 = Generator.getRandomTeam(teams);
        double age1 = team1.getMemberList().stream().mapToInt(Members::getAge).average().orElse(0);
        double age2 = team1.getMemberList().stream().mapToInt(Members::getAge).average().orElse(0);
        System.out.println("Team '" + team1.getTeamName() + "'  with '" + team2.getTeamName() + "'");
        System.out.println("Average score of: '" + team1.getTeamName() + "' is " + team1.getTeamScore());
        System.out.println("Average score of: '" + team2.getTeamName() + "' is " + team2.getTeamScore());
        System.out.println("Average age in: '" + team1.getTeamName() + "' is " + age1);
        System.out.println("Average age in: '" + team2.getTeamName() + "' is " + age2);
        System.out.println("---");

    }

    //        Найти команды, в которых все участники имеют уникальные имена.
    public static <T extends Members> void getTeamWithUniqueParticipantsName(Set<Team<T>> teams) {

        System.out.println(teams.stream()
                .filter(team -> team.getMemberList().stream().allMatch(member ->
                        team.getMemberList().stream().filter(secondMember -> !member.equals(secondMember))
                                .map(T::getName)
                                .noneMatch(teamMember -> Objects.equals(member.getName(), teamMember))))
                .map(t -> t.getTeamName()).toList());
    }

    //        Определить команды с самой длинной последовательностью побед.
    public static <T extends Members> void getMaxWinsTeam(Set<Team<T>> teams) {
        System.out.println(teams.stream().max(Comparator.comparingInt(t -> t.getWins().size())).map(t -> t.getTeamName()).orElse(""));
    }

    //        Найти команды с наибольшим количеством ничьих результатов.
    public static <T extends Members> void getMostDrawsTeam(Set<Team<T>> teams) {
//        System.out.println(teams.stream().mapToInt(t -> t.getDraws().size()).max());
        System.out.println(teams.stream().max(Comparator.comparingInt(t -> t.getDraws().size())).map(e -> e.getTeamName() + " : " + e.getDraws().size() + " draws").orElse(""));

    }
//        Выявить команды, которые показали наибольшее улучшение баллов к концу сезона.

    //        Создать комплексный отчет, включающий средний возраст команды, общее количество баллов, наибольшую победную серию, и сравнение с другими командами.
    public static <T extends Members> void getReport(Set<Team<T>> teams) {

        String teamType = null;
        if(teams.iterator().next().getMemberList().toArray()[0] instanceof Adult){
            teamType = "Adult";
        } else if(teams.iterator().next().getMemberList().toArray()[0] instanceof TeenAger){
            teamType = "TeenAger";
        }else if(teams.iterator().next().getMemberList().toArray()[0] instanceof Pupil){
            teamType = "Pupil";
        }
        double totalScore = teams.stream().mapToDouble(Team::getTeamScore).sum();
        double averageAge = teams.stream().flatMap(e -> e.getMemberList().stream()).mapToDouble(t -> t.getAge()).average().orElse(0.0);
        int maxWins = teams.stream().max(Comparator.comparingInt(t->t.getWins().size())).map(e->e.getWins().size()).orElse(0);
        System.out.println("Teams of "+teamType +" have average age: "+averageAge+" ,total score: "+totalScore + ",longest winning streaks: "+maxWins);
    }
}
