package org.example;

import java.util.Arrays;

public class MarsRover implements Rover{
   private int x;
   private int y;
   private char direction;
   private char[] commands;
    @Override
    public void initialRoverLocation(int x, int y, char direction) {
        this.x = x;
        this.y= y;
        this.direction = direction;
    }

    @Override
    public void roverCommand(char[] commands) {
     this.commands = commands;
    }

    @Override
    public void presentLocation() {
        System.out.println("coordinates are (x,y):" +x + "," +y +"  and direction is:" +direction);
    }

    @Override
    public void commandsToBeFollowed() {
        System.out.println("commands are:" + Arrays.toString(commands));
    }

}
