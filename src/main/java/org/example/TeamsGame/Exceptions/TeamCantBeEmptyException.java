package org.example.TeamsGame.Exceptions;

public class TeamCantBeEmptyException extends RuntimeException{
    public TeamCantBeEmptyException(String message) {
        super(message);
    }
}
