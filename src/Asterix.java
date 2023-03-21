import java.lang.reflect.Array;
import java.util.*;

public class Asterix {
    private Maze maze;
    private HashSet<Node> closedSet = new HashSet<Node>();
    private HashSet<Node> openSet = new HashSet<Node>();
    private HashMap<Node, Node> parent = new HashMap<Node, Node>();

    private Dictionary<Node, Integer> f = new Hashtable<Node, Integer>(); // Node is the Key and the value is the distance
    private Dictionary<Node, Integer> g = new Hashtable<Node, Integer>(); // Node is the Key and the value is the distance

    public Asterix(Maze maze) {
        this.maze = maze;
    }
    public ArrayList<Node> asterix()
    {
        while (!openSet.isEmpty()) {
            Node current = getNodeWithLowestFValue(openSet);
            if (current.equals(maze.getEnd())) {
                return reconstructPath(parent, current);
            }
            openSet.remove(current);
            closedSet.add(current);
            for (Node neighbour: neighbourNodes(current)) {
                if (closedSet.contains(neighbour)) {
                    continue;
                }
                int tentative_g = g.get(current) + dist_between(current, neighbour);
                if(!openSet.contains(neighbour) || tentative_g < g.get(neighbour)) {
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

    private int dist_between(Node current, Node neighbour)
    {
        return Math.abs(current.x - neighbour.x) + Math.abs(current.y - neighbour.y);
    }
    private ArrayList<Node> neighbourNodes(Node current)
    {
        ArrayList<Node> neighbours = new ArrayList<>();

        neighbours.add(new Node(current.x, current.y - 1));
        neighbours.add(new Node(current.x, current.y + 1));
        neighbours.add(new Node(current.x - 1, current.y));
        neighbours.add(new Node(current.x + 1, current.y));

        return neighbours;
    }

    private ArrayList<Node> reconstructPath(HashMap<Node, Node> parent, Node current) {
        // TODO
        return new ArrayList<Node>();
    }

    private Node getNodeWithLowestFValue(HashSet<Node> openSet)
    {
        Node result = null;
        int current_f = 0, f_old = -1;

        for(Node node : openSet)
        {
            current_f = g.get(node) + h(node);

            if(current_f < f_old || f_old < 0)
                result = node;

            f_old = current_f;
        }

        return result;
    }

    private boolean is_goal(Node position)
    {
        return (position.x == maze.getEnd().x) && (position.y == maze.getEnd().y);
    }

    private int h(Node position)
    {
        Node end = maze.getEnd();
        return Math.abs(position.x - end.x) + Math.abs(position.y - end.y);
    }

}
