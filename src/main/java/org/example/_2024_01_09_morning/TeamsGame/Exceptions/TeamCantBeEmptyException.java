package org.example._2024_01_09_morning.TeamsGame.Exceptions;

public class TeamCantBeEmptyException extends RuntimeException{
    public TeamCantBeEmptyException(String message) {
        super(message);
    }
}
