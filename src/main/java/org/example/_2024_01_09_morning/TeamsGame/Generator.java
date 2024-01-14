package org.example._2024_01_09_morning.TeamsGame;

import com.github.javafaker.Faker;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Adult;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Pupil;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.TeenAger;

import java.util.*;

public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static Set<Team<Adult>> generateAdults() {
        Set<Team<Adult>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<Adult> teamMembers = new Team<>(FAKER.team().name());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new Adult(FAKER.name().name(), RANDOM.nextInt(21, 40)));
            }
            team.add(teamMembers);
        }
        return team;
    }

    public static Set<Team<Pupil>> generatePupils() {
        Set<Team<Pupil>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<Pupil> teamMembers = new Team<>(FAKER.team().name());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new Pupil(FAKER.name().name(), RANDOM.nextInt(21, 40)));
            }
            team.add(teamMembers);
        }
        return team;
    }

    public static Set<Team<TeenAger>> generateTeenAger() {
        Set<Team<TeenAger>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<TeenAger> teamMembers = new Team<>(FAKER.team().name());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new TeenAger(FAKER.name().name(), RANDOM.nextInt(21, 40)));
            }
            team.add(teamMembers);
        }
        return team;
    }

}
//    public static Set<Set<Adult>> generateAdults(){
//    Set<Set<Adult>>team = new HashSet<>();
//    for (int i = 0;i <= 25;i++){
//        Set<Adult>team2 = new HashSet<>();
//        for (int j = 1; j < 5; j++) {
//            team2.add(new Adult(FAKER.name().name(), RANDOM.nextInt(21,40)));
//        }
//        team.add(team2);
//    }
//return team;
//}
//public static <T extends Members> ArrayList<T>[] generateTeams() {
//    ArrayList<T> teams = new ArrayList<T>();
//
//    for (int i = 0;i < 26;i++){
//        teams.get(i) =new Team(FAKER.team().name());
//        for (int j = 1; j <= 5; j++) {
//           teams[i].addNewMembers(new Adult(FAKER.name().name(), RANDOM.nextInt(21,40)));
//        }
//    }
//    return teams;
//
//}
//    Pupil p1 = new Pupil(FAKER.name().name(), RANDOM.nextInt(7,11));
//    Pupil p2 = new Pupil(FAKER.name().name(), RANDOM.nextInt(7,11));
//    TeenAger t1 = new TeenAger(FAKER.name().name(), RANDOM.nextInt(12,20));
//    TeenAger t2 = new TeenAger(FAKER.name().name(), RANDOM.nextInt(12,20));
//    Adult a1 = new Adult(FAKER.name().name(), RANDOM.nextInt(21,40));
//    Adult a2 = new Adult(FAKER.name().name(), RANDOM.nextInt(21,40));
//    Team<Pupil> pt1 = new Team<>(FAKER.name().name());
//    Team<Adult> at1 = new Team<>(FAKER.name().name());
//    Team<TeenAger> tt1 = new Team<>(FAKER.team().name());
//    Team<TeenAger> tt2 = new Team<>(FAKER.team().name());


