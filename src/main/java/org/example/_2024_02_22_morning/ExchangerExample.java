package org.example._2024_02_22_morning;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerExample {

    private static final Faker FAKER = new Faker();
    public static List<Action> actions() {
        List<Action> actionList = new ArrayList<>();
        Random random = new Random();
        Action[] actions = Action.values();
        for (int i = 0; i < 10; i++) {
            actionList.add(actions[random.nextInt(actions.length)]);
        }

        return actionList;
    }

    public static void main(String[] args)  {
        Exchanger<Action> exchanger = new Exchanger<>();
//        List<Action> G1List = actions();
//        List<Action> G2List = actions();
//        new Gamer("G1", G1List, exchanger).start();
//        new Gamer("G2", G2List, exchanger).start();

        Team team1 = new Team(FAKER.team().name(), Arrays.asList(
                new Gamer(FAKER.name().name(),actions(), exchanger),
                new Gamer(FAKER.name().name(),actions(),exchanger),
                new Gamer(FAKER.name().name(),actions(),exchanger),
                new Gamer(FAKER.name().name(),actions(), exchanger),
                new Gamer(FAKER.name().name(),actions(),exchanger)));

        Team team2 = new Team(FAKER.team().name(), Arrays.asList(
                new Gamer(FAKER.name().name(),actions(), exchanger),
                new Gamer(FAKER.name().name(),actions(),exchanger),
                new Gamer(FAKER.name().name(),actions(),exchanger),
                new Gamer(FAKER.name().name(),actions(), exchanger),
                new Gamer(FAKER.name().name(),actions(),exchanger)));

        for (int i = 0; i < team1.getGamers().size(); i++) {
            Thread t1 = new Thread(team1.getGamers().get(i));
            Thread t2 = new Thread(team2.getGamers().get(i));
            t1.start();
            t2.start();

        }

        System.out.println("Team1 : "+team1.getGamers().stream().mapToDouble(Gamer::getScore).sum());
        System.out.println("Team2 : "+team2.getGamers().stream().mapToDouble(Gamer::getScore).sum());
    }
}


enum Action {
    STONE,
    SCISSORS,
    PAPER
}
@Getter
@Setter
class Gamer implements Runnable{
    private String name;
    private List<Action> actionList;
    private Exchanger<Action> exchanger;
    private double score =0;

    public Gamer(String name, List<Action> actionList, Exchanger<Action> exchanger) {
        this.name = name;
        this.actionList = actionList;
        this.exchanger = exchanger;

    }

    public  void getWinner(Action G1, Action G2) {
        if (G1 == Action.STONE && G2 == Action.SCISSORS ||
                G1 == Action.SCISSORS && G2 == Action.PAPER ||
                G1 == Action.PAPER && G2 == Action.STONE) {
//            System.out.println("Winner: " + name + " || Action: G1 " + G1 + " || Action G2 " + G2);
            setScore(getScore()+1);
        } else if (G1 == Action.STONE && G2 == Action.STONE ||
                G1 == Action.SCISSORS && G2 == Action.SCISSORS ||
                G1 == Action.PAPER && G2 == Action.PAPER) {
            setScore(getScore()+0.5);

        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action ac : actionList) {
            try {
                reply = exchanger.exchange(ac);
                getWinner(ac, reply);
                Thread.sleep(1111);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
@Getter
@Setter
class Team{
    String name;
    List<Gamer> gamers = new ArrayList<>();

    public Team(String name, List<Gamer> gamers) {
        this.name = name;
        this.gamers = gamers;
    }


}