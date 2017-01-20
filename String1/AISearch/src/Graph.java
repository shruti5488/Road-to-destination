import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
	private static HashMap<String, List<List<String>>> graph = new HashMap<String, List<List<String>>>();

	public void setGraph(HashMap<String, List<List<String>>> graph) {
		this.graph = graph;
	}

	public HashMap<String, List<List<String>>> getGraph() {
		return graph;
	}

	public void addEdge(String node, String path, int weight) {
		List<List<String>> list_path_bfs = new ArrayList<List<String>>();
		if (getGraph().containsKey(node)) {
			list_path_bfs.addAll(getGraph().get(node));
			list_path_bfs.add(Arrays.asList(path, Integer.toString(weight)));
			getGraph().put(node, list_path_bfs);
			setGraph(getGraph());
		} else {
			list_path_bfs.add(Arrays.asList(path, Integer.toString(weight)));
			getGraph().put(node, list_path_bfs);
			setGraph(getGraph());
			
		}

	}

}
