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
        Node start = maze.getStart();

        openSet.add(start);

        g.put(start, 0);
        f.put(start, g.get(start) + h(start));

        while (!openSet.isEmpty())
        {
            Node current = getNodeWithLowestFValue(openSet);

            if (is_goal(current))
            {
                return reconstructPath(parent, current);
            }

            openSet.remove(current);
            closedSet.add(current);

            for (Node neighbour: neighbourNodes(current))
            {
                if (closedSet.contains(neighbour)) {
                    continue;
                }
                int tentative_g = g.get(current) + dist_between(current, neighbour);

                if(!openSet.contains(neighbour) || tentative_g < g.get(neighbour))
                {
                    parent.put(neighbour, current);
                    g.put(neighbour, tentative_g);
                    f.put(neighbour, g.get(neighbour) + h(neighbour));

                    if (!openSet.contains(neighbour)) {
                        openSet.add(neighbour);
                    }
                }
            }
        }
        return new ArrayList<Node>();
    }

    private int dist_between(Node current, Node neighbour)
    {
        return Math.abs(current.row - neighbour.row) + Math.abs(current.column - neighbour.column);
    }
    private ArrayList<Node> neighbourNodes(Node current)
    {
        ArrayList<Node> neighbours = new ArrayList<>();

        if(current.column - 1 >= 0)
            neighbours.add(new Node(current.row, current.column - 1));
        if(current.column + 1 < maze.columns)
            neighbours.add(new Node(current.row, current.column + 1));
        if(current.row - 1 >= 0)
            neighbours.add(new Node(current.row - 1, current.column));
        if(current.row + 1 < maze.rows)
            neighbours.add(new Node(current.row + 1, current.column));

        return neighbours;
    }

    private ArrayList<Node> reconstructPath(HashMap<Node, Node> parent, Node current)
    {
        var result = new ArrayList<Node>();
        current=parent.get(current);
        while(current!=maze.getStart())
        {
            maze.setNode(current, "+");
            current = parent.get(current);
            result.add(current);
        }

        return result;
    }

    private Node getNodeWithLowestFValue(HashSet<Node> openSet)
    {
        Node result = null;
        int current_f = 0, lowest_f = -1;

        for(Node node : openSet)
        {
            current_f = g.get(node).intValue() + h(node);

            if(current_f < lowest_f || lowest_f < 0) {
                result = node;
                lowest_f = current_f;
            }
        }

        return result;
    }

    private boolean is_goal(Node position)
    {
        return position.row == maze.getEnd().row && position.column == maze.getEnd().column;
    }

    private int h(Node position)
    {
        Node end = maze.getEnd();
        return Math.abs(position.row - end.row) + Math.abs(position.column - end.column);
    }
}
