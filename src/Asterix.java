import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Asterix {
    private Maze maze;
    public Asterix(Maze maze) {
        this.maze = maze;
    }
    public ArrayList<Node> asterix(Maze maze)
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
            for (Node neighbour: neighbourNodes(current)) {
                if (closedSet.contains(neighbour)) {
                    continue;
                }
                int tentative_g = g(current) + dist_between(current, neighbour);
                if(!openSet.contains(neighbour) || tentative_g < g(neighbour)) {
                    parent.put(neighbour, current);
                    // TODO
                    // g =
                    // f =
                    if (!openSet.contains(neighbour)) {
                        openSet.add(neighbour);
                    }
                }
            }
        }
        // return failure
        return new ArrayList<Node>();
    }

    private int dist_between(Node current, Node neighbour) {
        // TODO
        return 0;
    }
    private ArrayList<Node> neighbourNodes(Node current) {
        // TODO
        ArrayList<Node> neighbours = new ArrayList<>();

        return neighbours;
    }

    private ArrayList<Node> reconstructPath(HashMap<Node, Node> parent, Node current) {
        // TODO
        return new ArrayList<Node>();
    }

    private Node getNodeWithLowestFValue() {
        // TODO
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
