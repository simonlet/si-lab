import java.util.Arrays;

public class Maze {
    char[][] maze;

    public Maze(int rows, int columns) {
        this.maze = maze = new char[rows][columns];
        generateMaze(rows, columns);
    }

    private void generateMaze(int rows, int columns) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                this.maze[row][col] = getNextChar();
            }
        }
    }

    private char getNextChar() {
        return 0;
    }
}
