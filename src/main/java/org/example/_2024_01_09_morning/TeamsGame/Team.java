package org.example._2024_01_09_morning.TeamsGame;

import lombok.Getter;

import java.util.*;

@Getter
public class Team<T extends Members> {
    private String teamName;
    private double teamScore;
    private final Set<T> memberList = new HashSet<T>();
    @Override
    public  String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamScore=" + teamScore +
                ", membersList=" + memberList +
                '}';
    }



    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public void addNewMembers(T members) {
        memberList.add(members);
    }

    public void play(Team<T> secondTeam) {
        String winner;
        int randomDigit = new Random().nextInt(3);
        if (randomDigit == 0) {
            winner = this.teamName;
            this.teamScore += 1;
        } else if (randomDigit == 1) {
            winner = secondTeam.teamName;
            secondTeam.teamScore += 1;
        } else {
            winner = "both teams";
            this.teamScore += 0.5;
            secondTeam.teamScore += 0.5;
        }
//        System.out.println("Winner: " + "'"+winner+ "'" + " congratulation!");
    }
}
