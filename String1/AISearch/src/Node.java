
public class Node {
	
	public String node;
	public int pathCost;
	public String parent;
	
	public Node(String node, String parent, int pathCost){
		this.node = node;
		this.parent = parent;
		this.pathCost = pathCost;
	}
	
	public void changeNode(int pathCost){
		this.pathCost = pathCost;
	}
}
