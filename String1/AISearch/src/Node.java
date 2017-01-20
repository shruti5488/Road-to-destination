
public class Node {
	
	public String node;
	public int pathCost;
	public String parent;
	public int heuristic;
	
	public Node(String node, String parent, int pathCost, int heuristic){
		this.node = node;
		this.parent = parent;
		this.pathCost = pathCost;
		this.heuristic = heuristic;
	}

}
