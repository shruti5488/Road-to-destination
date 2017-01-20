
public class Node {

	private String node_value;
	public Node child;
	public int pathCost;
	public Node parent;
	
	public Node(String node_value){
		this.node_value = node_value;
	}
	
	public String getNode(){
		return node_value;
	}
}

