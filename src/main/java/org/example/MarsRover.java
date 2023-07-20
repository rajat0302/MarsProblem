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
    public void roverCommand(char[] commands)
    {
     this.commands = commands;
     for(char command : commands)
     {
         if(command == 'f' || command == 'b')
         {
             moveRover(command);
         }
         else if (command == 'l' || command == 'r')
         {
             turnRover(command);
         }
     }
    }

    public void moveRover(char command)
    {
      int newX = x;
      int newY = y;
        switch (direction) {
            case 'N':
                newY += (command == 'f') ? 1 : -1;
                break;
            case 'S':
                newY += (command == 'f') ? -1 : 1;
                break;
            case 'E':
                newX += (command == 'f') ? 1 : -1;
                break;
            case 'W':
                newX += (command == 'f') ? -1 : 1;
                break;
        }
        x = newX;
        y = newY;
    }
    private void turnRover(char command)
    {
      switch (command){
          case 'l':
              switch (direction) {
                  case 'N':
                      direction = 'W';
                      break;
                  case 'S':
                      direction = 'E';
                      break;
                  case 'E':
                      direction = 'N';
                      break;
                  case 'W':
                      direction = 'S';
                      break;
              }
          break;
          case 'r':
              switch (direction) {
                  case 'N':
                      direction = 'E';
                      break;
                  case 'S':
                      direction = 'W';
                      break;
                  case 'E':
                      direction = 'S';
                      break;
                  case 'W':
                      direction = 'N';
                      break;
              }
          break;
      }
    }

    @Override
    public String presentLocation() {
        return "(x,y):" +x + "," +y +" & direction is:" +direction;
    }

    @Override
    public String commandsToBeFollowed() {
        return "commands are:" + Arrays.toString(commands);
    }
    
}
