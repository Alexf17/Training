package org.example.TeamsGame;

import com.github.javafaker.Faker;
import org.example.TeamsGame.Exceptions.TeamCantBeEmptyException;
import org.example.TeamsGame.TypesOfPlayers.Adult;
import org.example.TeamsGame.TypesOfPlayers.Pupil;
import org.example.TeamsGame.TypesOfPlayers.TeenAger;
import org.example.TeamsGame.Exceptions.ErrorMessages;

import java.util.*;

import static org.example.TeamsGame.GenerateCard.getAllCardInfo;

public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static Set<Team<Adult>> generateAdults() {
        Set<Team<Adult>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<Adult> teamMembers = new Team<>(FAKER.team().name(),new HashSet<>());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new Adult(FAKER.name().name(), RANDOM.nextInt(30, 45),getAllCardInfo()));
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
                teamMembers.addNewMembers(new Pupil(FAKER.name().name(), RANDOM.nextInt(9, 18),getAllCardInfo()));
            }
            team.add(teamMembers);
        }
        if (team.isEmpty()) {
            throw new TeamCantBeEmptyException(ErrorMessages.TEAM_MUST_BE_NOT_EMPTY);
        }
        return team;
    }

    public static Set<Team<TeenAger>> generateTeenAger() {
        Set<Team<TeenAger>> team = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            Team<TeenAger> teamMembers = new Team<>(FAKER.team().name(),new HashSet<>());
            for (int j = 1; j < 5; j++) {
                teamMembers.addNewMembers(new TeenAger(FAKER.name().name(), RANDOM.nextInt(18, 31),getAllCardInfo()));
            }
            team.add(teamMembers);
        }
        if (team.isEmpty()) {
            throw new TeamCantBeEmptyException(ErrorMessages.TEAM_MUST_BE_NOT_EMPTY);
        }
        return team;
    }

    public static <T extends Members> String getRandomTeamName(Set<Team<T>> teams) {
        if(teams.isEmpty()){
            throw new TeamCantBeEmptyException(ErrorMessages.TEAM_MUST_BE_NOT_EMPTY);
        }
        int random = new Random().nextInt(1, teams.size());
        List<String> list = new ArrayList<>();
        for (Team<T> team : teams) {
            list.add(team.getTeamName());
        }
        return list.get(random);
    }
    public static <T extends Members> Team<T> getRandomTeam(Set<Team<T>> teams) {
        if(teams.isEmpty()){
            throw new TeamCantBeEmptyException(ErrorMessages.TEAM_MUST_BE_NOT_EMPTY);
        }
        int random = new Random().nextInt(1, teams.size());
        List<Team<T>> list = new ArrayList<>(teams);
        return list.get(random);
    }

}




