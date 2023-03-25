import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        Maze maze = new Maze(10, 15, 0.3);
        System.out.println(maze);

        Asterix asterix = new Asterix(maze);

        var result = asterix.asterix();

        System.out.println(result);

        System.out.println(maze);

        String fileName = "output.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(maze));


            if(result == null)
            {
                bufferedWriter.write("The obstacles are preventing us from finding the path!");
            }
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}