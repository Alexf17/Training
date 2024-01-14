package org.example._2024_01_09_morning.TeamsGame;

import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Adult;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Pupil;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.TeenAger;


import java.util.*;
import java.util.stream.Collectors;

public class Handler {
    static Set<Team<Adult>> adultTeams = new HashSet<>();
    static Set<Team<TeenAger>> teenAgerTeams = new HashSet<>();
    static Set<Team<Pupil>> pupilTeams = new HashSet<>();
    static Map<String, Double> adultTeamResults = new HashMap<>();
    static Map<String, Double> teenAgerTeamResults = new HashMap<>();
    static Map<String, Double> pupilTeamResults = new HashMap<>();
//    static ArrayList<Set<? extends Team<? extends Members>>> allTeams = new ArrayList<>();

    public static void start() {
        generateTeams();
        playGames(adultTeams);
//        playGames(teenAgerTeams);
//        playGames(pupilTeams);
        System.out.println(adultTeamResults);
//        System.out.println(adultTeams);


    }

    public static <T extends Members> void generateTeams() {
        adultTeams = Generator.generateAdults();
        teenAgerTeams = Generator.generateTeenAger();
        pupilTeams = Generator.generatePupils();
//        allTeams.add(teenAgerTeams);
//        allTeams.add(pupilTeams);
//        allTeams.add(adultTeams);
//        List<Set<Team<T>>> teams = new ArrayList<>();
//        teams.add(teenAgerTeams);
    }

    public static <T extends Members> void playGames(Set<Team<T>> teams) {
//        for (Team<T> team : teams) {
//            System.out.println(team.getTeamName() + " : " + team.getTeamScore());
//        }
//        System.out.println("---Players-------");
//        System.out.println(adultTeamResults);
//        System.out.println("------------");
//        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Team<T> team_1 : teams) {
//            if (count >= 7) {
//                break;
//            }
//            count++;
            sb.append(team_1.getTeamName());
            for (Team<T> team_2 : teams) {
//                if (count >= 7) {
//                    break;
//                }
//                count++;
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
                adultTeamResults = createSortedList(adultTeamResults);
//                if(adultTeamResults.size()==25){
//                    check();
//                }
            } else if (team.getMemberList().toArray()[0] instanceof Pupil) {
                pupilTeamResults.put(team.getTeamName(), team.getTeamScore());
                pupilTeamResults = createSortedList(pupilTeamResults);
            } else if (team.getMemberList().toArray()[0] instanceof TeenAger) {
                teenAgerTeamResults.put(team.getTeamName(), team.getTeamScore());
                teenAgerTeamResults = createSortedList(teenAgerTeamResults);
            }
        }

        check();


//        boolean firstFourEntries = adultTeamResults.entrySet()
//                .stream()
//                .limit(5).distinct().count() < 4;
//        if (!firstFourEntries) {
//          playGames(adultTeams,5);
//        }
//
//        for (Team<T> team : teams) {
//            if (team.getMemberList().iterator().next() instanceof Adult) {
//                adultTeamResults.put(team.getTeamName(), team.getTeamScore());
//            } else if (team.getMemberList().iterator().next() instanceof Pupil) {
//                pupilTeamResults.put(team.getTeamName(), team.getTeamScore());
//            } else if (team.getMemberList().iterator().next() instanceof TeenAger) {
//                teenAgerTeamResults.put(team.getTeamName(), team.getTeamScore());
//            }
//        }
    }

    public static void check() {
        List<Map.Entry<String, Double>> topFive = adultTeamResults.entrySet()
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

        //вариант GPT
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
            Set<Team<Adult>> champions = new HashSet<>();
            for (int i = 0; i < topFive.size(); i++) {
                for (Team<Adult> team : adultTeams) {
                    if (topFive.get(i).getKey().contentEquals(team.getTeamName())) {
                        champions.add(team);
                    }
                }
            }
            playGames(champions);
        }
    }

    public static Map<String, Double> createSortedList(Map<String, Double> results) {
        Map<String, Double> sortedValues = results.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedValues;
    }

//    public static void playGames() {
//        StringBuilder sb = new StringBuilder();
//        for (Team<Adult> t1 : adultTeams) {
//            sb.append(t1.getTeamName());
//            for (Team<Adult> t2 : adultTeams) {
//                if (sb.indexOf(t2.getTeamName()) == -1) {
//                    t1.play(t2);
//                }
//            }
//        }
//    }

}
