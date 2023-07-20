import org.example.MarsRover;
import org.example.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class TestMarsRover {

    @Test
    public void testInitialPosition()
    {
        Rover rover = new MarsRover();
        rover.initialRoverLocation(1,1,'N');
        char[] commands = {'f','f','l','f','r'};
        rover.roverCommand(commands);
        rover.presentLocation();
        rover.commandsToBeFollowed();
    }

    @Test
    public void testForSingleCommandMove()
    {
        Rover rover = new MarsRover();
        rover.initialRoverLocation(1,1,'N');
        char[] commands = {'f'};
        rover.roverCommand(commands);
        Assertions.assertEquals("(x,y):1,2 & direction is:N",rover.presentLocation());
    }

    @Test
    public void testForMultipleCommandsMove()
    {
        Rover rover = new MarsRover();
        rover.initialRoverLocation(1,1,'E');
        char[] commands = {'f','b','f','f'};
        rover.roverCommand(commands);
        Assertions.assertEquals("(x,y):3,1 & direction is:E",rover.presentLocation());
    }

    @Test
    public void testForWrongCommandMoveAndTurn()
    {
        Rover rover = new MarsRover();
        rover.initialRoverLocation(1,1,'N');
        char[] commands = {'s'};
        rover.roverCommand(commands);
        Assertions.assertEquals("(x,y):1,1 & direction is:N",rover.presentLocation());
    }

    @Test
    public void testForSingleCommandTurn()
    {
        Rover rover = new MarsRover();
        rover.initialRoverLocation(1,1,'N');
        char[] commands = {'l'};
        rover.roverCommand(commands);
        Assertions.assertEquals("(x,y):1,1 & direction is:W",rover.presentLocation());
    }

    @Test
    public void testForMultipleCommandsTurn()
    {
        Rover rover = new MarsRover();
        rover.initialRoverLocation(1,1,'W');
        char[] commands = {'l','l','r','l'};
        rover.roverCommand(commands);
        Assertions.assertEquals("(x,y):1,1 & direction is:E",rover.presentLocation());
    }

    @Test
    public void testForMultipleCommandsMoveAndTurn()
    {
        Rover rover = new MarsRover();
        rover.initialRoverLocation(3,3,'S');
        char[] commands = {'f','f','r','l','b','r'};
        rover.roverCommand(commands);
        Assertions.assertEquals("(x,y):3,2 & direction is:W",rover.presentLocation());
    }


}
