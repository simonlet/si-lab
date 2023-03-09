import java.util.Arrays;
import java.util.Random;

public class Maze {
    private String[][] maze;
    private int rows;
    private int columns;
    private double percentage;


    public Maze(int rows, int columns, double percentage) {
        this.maze = new String[rows][columns];
        this.rows = rows;
        this.columns = columns;
        this.percentage = percentage;
        generateMaze(rows, columns);
    }

    private void generateMaze(int rows, int columns) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                this.maze[row][col] = " ";
            }
        }
        addObstacles(this.percentage);
        addStartGoal();
    }
    //percentage is a decimal number in interval 0 < percentage < 1
    private void addObstacles(double percentage)
    {
        int numbOfObstacles = (int)(Math.round(rows * columns * percentage));
        Random rand = new Random();
        for(int i = 0; i < numbOfObstacles; i++)
        {
            boolean obstaclePut = false;
            do {
                int randRow = rand.nextInt(rows);
                int randCol = rand.nextInt(columns);

                if(maze[randRow][randCol] == " ") // in this case the space is empty -> we can put obstical inside
                {
                    maze[randRow][randCol] = "*";
                    obstaclePut = true;
                }
            }
            while(!obstaclePut);
        }
    }

    private void addStartGoal()
    {
        Random rand = new Random();
        boolean obstaclePut = false;
        do {
            int randRow = rand.nextInt(rows);
            int randCol = rand.nextInt(columns);

            if(maze[randRow][randCol] == " ") // in this case the space is empty -> we can put obstical inside
            {
                maze[randRow][randCol] = "I";
                obstaclePut = true;
            }
        } while(!obstaclePut);
        obstaclePut = false;
        do {
            int randRow = rand.nextInt(rows);
            int randCol = rand.nextInt(columns);

            if(maze[randRow][randCol] == " ") // in this case the space is empty -> we can put obstical inside
            {
                maze[randRow][randCol] = "G";
                obstaclePut = true;
            }
        } while(!obstaclePut);
    }


    @Override
    public String toString() {
        String output ="";
        for (int row = 0; row < rows; row++) {
            output += Arrays.toString(maze[row]) + "\n";
        }
        return output;
    }
}