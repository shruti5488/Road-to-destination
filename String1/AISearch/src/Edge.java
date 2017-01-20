public class Edge{
	
	public Node child;
	public int pathCost;
	
	
	public Edge(Node child, int pathCost){
		this.child = child;
		this.pathCost = pathCost;
	}
	
	public Node getChild(){
		return child;	
	}
	
	public int getCost(){
		return pathCost;	
	}
	
}