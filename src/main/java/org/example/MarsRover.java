package org.example;

import java.util.Arrays;

public class MarsRover implements Rover{
   private int x;
   private int y;

   private int obstacles[]={0};
   private char direction;
   private char[] commands;
    @Override
    public void initialRoverLocation(int x, int y, char direction) {
        this.x = x;
        this.y= y;
        this.direction = direction;
    }

    @Override
    public void setObstacles(int[] location)
    {
            obstacles= Arrays.copyOfRange(location,0,location.length);
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
        newX = wrappingAtEdges(newX, 'x');
        newY = wrappingAtEdges(newY, 'y');

        if (!hasObstacle(newX, newY)) {
                x = newX;
                y = newY;
        } else {
                System.out.println("Obstacle detected at (" + newX + ", " + newY + "). this moving is aborted. Back to the last move " + x + ", " + y);
        }
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
    private boolean hasObstacle(int newX, int newY) {
        if(obstacles.length != 1) {
            for (int i = 0; i < obstacles.length; i++) {
                if (newX == obstacles[i] && newY == obstacles[++i]) {
                    return true;
                }
            }
        }
        return false;
    }

    private int wrappingAtEdges(int coordinate, char axis)
    {
        int size = 10;            //let it be of max 10,10

        if (coordinate < 0)       //case for negative axis
        {
            coordinate += size;
        }
        else if (axis == 'x' && coordinate >= size)
        {
            coordinate %= size;
        }
        else if (axis == 'y' && coordinate >= size)
        {
            coordinate %= size;
        }
        return coordinate;
    }


}
