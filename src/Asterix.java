import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.math;

public class Asterix {
    private Maze maze;
    public Asterix(Maze maze) {
        this.maze = maze;
    }
    public List<Node> asterix(Maze maze)
    {
        HashSet<Node> closedSet = new HashSet<Node>();
        HashSet<Node> openSet = new HashSet<Node>();
        HashMap<Node, Node> parent = new HashMap<Node, Node>();
        while (!openSet.isEmpty()) {
            Node current = getNodeWithLowestFValue();
            if (current.equals(maze.getEnd())) {
                return reconstructPath(parent, current);
            }
            openSet.remove(current);
            closedSet.add(current);
            for (Node neighbour: neighbourNodes()) {

            }
        }


        return new List<Node>();
    }

    private List<Node> neighbourNodes(Node current) {
        List<Node> neighbours
    }

    private List<Node> reconstructPath(HashMap<Node, Node> parent, Node current) {
        return new List<Node>();
    }

    private Node getNodeWithLowestFValue() {
        return new Node(0, 0);
    }

    private boolean is_goal(Node position)
    {
        return (position.x == maze.getEnd().x) && (position.y == maze.getEnd().y);
    }

    private int g(Node position)
    {
        Node start = maze.getStart();

        return Math.abs(start.x - position.x) + Math.abs(start.y - position.y);
    }

    private int h(Node position)
    {
        Node end = maze.getEnd();
        return Math.abs(position.x - end.x) + Math.abs(position.y - end.y);
    }

}
