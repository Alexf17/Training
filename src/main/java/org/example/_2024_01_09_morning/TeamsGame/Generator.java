package org.example._2024_01_09_morning.TeamsGame;

import com.github.javafaker.Faker;
import org.example._2024_01_09_morning.TeamsGame.Exceptions.ErrorMessages;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Adult;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.Pupil;
import org.example._2024_01_09_morning.TeamsGame.Exceptions.TeamCantBeEmptyException;
import org.example._2024_01_09_morning.TeamsGame.TypesOfPlayers.TeenAger;

import java.util.*;

public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static Set<Team<Adult>> generateAdults() {
        Set<Team<Adult>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<Adult> teamMembers = new Team<>(FAKER.team().name(),new HashSet<>());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new Adult(FAKER.name().name(), RANDOM.nextInt(30, 45)));
            }
            team.add(teamMembers);
        }
        if (team.isEmpty()) {
            throw new TeamCantBeEmptyException(ErrorMessages.TEAM_MUST_BE_NOT_EMPTY);
        }
        return team;
    }

    public static Set<Team<Pupil>> generatePupils() {
        Set<Team<Pupil>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<Pupil> teamMembers = new Team<>(FAKER.team().name(),new HashSet<>());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new Pupil(FAKER.name().name(), RANDOM.nextInt(9, 18)));
            }
            team.add(teamMembers);
        }
        if (team.isEmpty()) {
            throw new TeamCantBeEmptyException("Team must be not empty");
        }
        return team;
    }

    public static Set<Team<TeenAger>> generateTeenAger() {
        Set<Team<TeenAger>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<TeenAger> teamMembers = new Team<>(FAKER.team().name(),new HashSet<>());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new TeenAger(FAKER.name().name(), RANDOM.nextInt(18, 31)));
            }
            team.add(teamMembers);
        }
        if (team.isEmpty()) {
            throw new TeamCantBeEmptyException("Team must be not empty");
        }
        return team;
    }

    public static <T extends Members> String getRandomTeamName(Set<Team<T>> teams) {
        int random = new Random().nextInt(1, teams.size());
        List<String> list = new ArrayList<>();
        for (Team<T> team : teams) {
            list.add(team.getTeamName());
        }
        return list.get(random);
    }
    public static <T extends Members> Team<T> getRandomTeam(Set<Team<T>> teams) {
        int random = new Random().nextInt(1, teams.size());
        List<Team<T>> list = new ArrayList<>(teams);
        return list.get(random);
    }

}




