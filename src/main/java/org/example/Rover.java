package org.example;

public interface Rover {

    void initialRoverLocation(int x, int y, char direction);
    void roverCommand(char[] command);
    void presentLocation();
    void commandsToBeFollowed();
}
