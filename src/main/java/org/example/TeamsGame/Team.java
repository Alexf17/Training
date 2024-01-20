package org.example.TeamsGame;

import lombok.Getter;

import java.util.*;

@Getter
public class Team<T extends Members> {
    private String teamName;
    private double teamScore;
    private Set<T> memberList = new HashSet<T>();
    private final List<String> wins = new ArrayList<String>();
    private final List<String> losses= new ArrayList<String>();
    private final List<String> draws=new ArrayList<String>();
    private int gameСounter;

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamScore=" + teamScore +
                ", memberList=" + memberList +
                ", wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                ", gameСounter=" + gameСounter +
                '}';
    }

    public Team(String teamName,Set<T> memberList) {
        this.teamName = teamName;
        this.memberList = memberList;

    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public void addNewMembers(T members) {
        memberList.add(members);
    }

    public void play(Team<T> secondTeam) {
        this.gameСounter+=1;
        secondTeam.gameСounter+=1;
        int randomDigit = new Random().nextInt(3);
        if (randomDigit == 0) {
            secondTeam.losses.add(this.getTeamName());
            this.teamScore += 1;
            this.wins.add(secondTeam.getTeamName());
        } else if (randomDigit == 1) {
            this.losses.add(secondTeam.getTeamName());
            secondTeam.teamScore += 1;
            secondTeam.wins.add(this.getTeamName());
        } else {
            this.draws.add(secondTeam.getTeamName());
            secondTeam.draws.add(this.getTeamName());
            this.teamScore += 0.5;
            secondTeam.teamScore += 0.5;
        }

    }
}
