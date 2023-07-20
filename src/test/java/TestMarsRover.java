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

}
