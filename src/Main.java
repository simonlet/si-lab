
public class Main
{
    public static void main(String[] args)
    {
        Maze maze = new Maze(10, 15, 0.3);
        System.out.println(maze);
        System.out.println(maze.getStart().row);
        System.out.println(maze.getStart().column);
        System.out.println(maze.getEnd().row);
        System.out.println(maze.getEnd().column);


        Asterix asterix = new Asterix(maze);
        var result = asterix.asterix();

        System.out.println(result);
    }
}