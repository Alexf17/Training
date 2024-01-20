package org.example._2024_01_09_morning.TeamsGame;

import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Adult;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Pupil;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.TeenAger;


import java.util.*;
import java.util.stream.Collectors;

public class Handler {
    public static Set<Team<Adult>> adultTeams = new HashSet<>();
    public static Set<Team<TeenAger>> teenAgerTeams = new HashSet<>();
    public static Set<Team<Pupil>> pupilTeams = new HashSet<>();
    public static Map<String, Double> adultTeamResults = new HashMap<>();
    public static Map<String, Double> teenAgerTeamResults = new HashMap<>();
    public static Map<String, Double> pupilTeamResults = new HashMap<>();
    public static Map<Team<Adult>, Double> fullAdultTeamResults = new HashMap<>();
    public static Map<Team<TeenAger>, Double> fullTeenAgerTeamResults = new HashMap<>();
    public static Map<Team<Pupil>, Double> fullPupilTeams = new HashMap<>();


    public static void start() {
        generateTeams();
        playGames(adultTeams);
        playGames(teenAgerTeams);
        playGames(pupilTeams);
//        System.out.println("-----Adult team results--------------");
//        System.out.println(adultTeamResults);
//        System.out.println("-----TeenAger team results--------------");
//        System.out.println(teenAgerTeamResults);
//        System.out.println("-----Pupil team results--------------");
//        System.out.println(pupilTeamResults);
//        System.out.println("-------------------");

//        for(Team<Adult>t: adultTeams){
//            System.out.println(t.getTeamName()+" : "+t.getWins().size()+" : "+t.getGameСounter());
//        }
//        System.out.println(adultTeams.stream().map(e->e.getLosses()).toList());
//        System.out.println(pupilTeams.stream().map(e->e.getLosses()).toList());
//        System.out.println(teenAgerTeams.stream().map(e->e.getLosses()).toList());


    }

    public static <T extends Members> void generateTeams() {
        adultTeams = Generator.generateAdults();
        teenAgerTeams = Generator.generateTeenAger();
        pupilTeams = Generator.generatePupils();

    }

    public static <T extends Members> void playGames(Set<Team<T>> teams) {
        StringBuilder sb = new StringBuilder();
        for (Team<T> team_1 : teams) {
            sb.append(team_1.getTeamName());
            for (Team<T> team_2 : teams) {
                if (sb.indexOf(team_2.getTeamName()) == -1) {
                    team_1.play(team_2);
                }
            }
        }
        createRating(teams);
    }

    public static <T extends Members> void createRating(Set<Team<T>> teams) {
        for (Team<T> team : teams) {
            if (team.getMemberList().toArray()[0] instanceof Adult) {
                adultTeamResults.put(team.getTeamName(), team.getTeamScore());
                fullAdultTeamResults.put((Team<Adult>) team, team.getTeamScore());
                adultTeamResults = createSortedList(adultTeamResults);
            } else if (team.getMemberList().toArray()[0] instanceof Pupil) {
                pupilTeamResults.put(team.getTeamName(), team.getTeamScore());
                fullPupilTeams.put((Team<Pupil>) team, team.getTeamScore());
                pupilTeamResults = createSortedList(pupilTeamResults);
            } else if (team.getMemberList().toArray()[0] instanceof TeenAger) {
                teenAgerTeamResults.put(team.getTeamName(), team.getTeamScore());
                fullTeenAgerTeamResults.put((Team<TeenAger>) team, team.getTeamScore());
                teenAgerTeamResults = createSortedList(teenAgerTeamResults);
            }
        }
        check(teams);
    }

    public static <T extends Members> void check(Set<Team<T>> teams) {
        Map<String, Double> results = new HashMap<>();
        for (Team<T> team : teams) {
            if (team.getMemberList().toArray()[0] instanceof Adult) {
                results = adultTeamResults;
            } else if (team.getMemberList().toArray()[0] instanceof Pupil) {
                results = pupilTeamResults;
            } else if (team.getMemberList().toArray()[0] instanceof TeenAger) {
                results = teenAgerTeamResults;
            }
        }
        List<Map.Entry<String, Double>> topFive = results.entrySet()
                .stream()
                .limit(5)
                .toList();

        boolean hasDuplicates = false;
        for (int i = 0; i < topFive.size(); i++) {
            for (int j = i + 1; j < topFive.size(); j++) {
                if (topFive.get(i).getValue().equals(topFive.get(j).getValue())) {
                    hasDuplicates = true;
                    break;
                }
            }
        }

        //вариант оптимиации от  GPT
//        boolean hasDuplicates = topEntries.stream()
//                .anyMatch(entry -> topEntries.stream()
//                        .filter(e -> !e.equals(entry))
//                        .anyMatch(e -> e.getValue().equals(entry.getValue())));

//        if (hasDuplicates) {
//            Set<Team<Adult>> topTeams = topFive.stream()
//                    .map(entry -> getTeamByName(entry.getKey()))
//                    .collect(Collectors.toSet());
//
//            playGames(topTeams);
//        }
//        private static Team<Adult> getTeamByName(String teamName) {
//            return adultTeams.stream()
//                    .filter(team -> teamName.equals(team.getTeamName()))
//                    .findFirst()
//                    .orElse(null);
//        }


        if (hasDuplicates) {
            Set<Team<T>> champions = new HashSet<>();
            for (int i = 0; i < topFive.size(); i++) {
                for (Team<T> team : teams) {
                    if (topFive.get(i).getKey().contentEquals(team.getTeamName())) {
                        champions.add(team);
                    }
                }
            }
            playGames(champions);
        }
    }

    public static Map<String, Double> createSortedList(Map<String, Double> results) {
        return results.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
