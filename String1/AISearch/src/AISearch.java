import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AISearch {

	private HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
	List<Maintain_Weight> scores = new ArrayList<Maintain_Weight>();

	
	public void setGraph(HashMap<String, List<String>> graph) {
		this.graph = graph;
	}

	public HashMap<String, List<String>> getGraph() {
		return graph;
	}

	public void addEdge(String node, String path) {
		LinkedList<String> list_path = new LinkedList<String>();
		if (getGraph().containsKey(node)) {
			list_path.addAll(getGraph().get(node));
			list_path.add(path);
			getGraph().put(node, list_path);
			setGraph(getGraph());

		} else {
			list_path.add(path);
			getGraph().put(node, list_path);
			setGraph(getGraph());
		}

	}

	public static ArrayList<String> DFS(String start, String end, HashMap<String, List<String>> DFS_map) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		Deque<String> stack = new ArrayDeque<>();
		Stack<String> temp_stack = new Stack<String>();
		ArrayList<String> shortestPathList = new ArrayList<String>();
		HashMap<String, String> pathStack = new HashMap<String, String>();

		stack.push(start);
		String vertex = start;
		visited.put(vertex, true);
		pathStack.put(start, start);
		if (start.equals(end)) {
			shortestPathList.add(start);
			return shortestPathList;
		}

		boolean flag = false;
		while (!stack.isEmpty()) {
			vertex = stack.pollFirst();
			if (vertex.equals(end)) {
				break;
			}
			if (DFS_map.containsKey(vertex)) {
				for (String v : DFS_map.get(vertex)) {
					if (!visited.containsKey(v)) {
						temp_stack.add(v);
						visited.put(v, true);
						pathStack.put(v, vertex);
						if (end.equals(v)) {
							flag = true;
							break;
						}
						if (flag == true) {
							break;
						}
					}

				} 
				for(int i=temp_stack.size()-1;i>=0;i--){
					stack.addFirst(temp_stack.get(i));
				}
				temp_stack.clear();
				if (flag == true) {
					break;
				}
			}
		}
		shortestPathList.add(end);
		String node = end;
		String current = node;
		while (node != start) {
			node = pathStack.get(current);
			current = node;
			shortestPathList.add(node);
		}
		return shortestPathList;
	}

	public static void mark_visited() {

	}

	public static ArrayList<String> BFS(String start, String end, HashMap<String, List<String>> graph) {
		ArrayList<String> shortestPathList = new ArrayList<String>();
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

		if (start.equals(end)) {
			shortestPathList.add(start);
			return shortestPathList;
		}

		Queue<String> queue = new LinkedList<String>();
		HashMap<String, String> pathStack = new HashMap<String, String>();

		Boolean flag = false;
		queue.add(start);
		pathStack.put(start, start);
		visited.put(start, true);

		while (!queue.isEmpty()) {
			String next = queue.poll();

			if (graph.containsKey(next)) {
				for (String v : graph.get(next)) {

					if (!visited.containsKey(v)) {
						queue.add(v);
						visited.put(v, true);
						pathStack.put(v, next);
						if (end.equals(v)) {
							flag = true;
							break;
						}
						if (flag == true) {
							break;
						}
					}

				}
				if (flag == true) {
					break;
				}
			}

		}

		String current = end;
		String node;
		shortestPathList.add(end);

		node = current;
		while (node != start) {
			node = pathStack.get(current);
			current = node;
			shortestPathList.add(node);
		}
		return shortestPathList;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("/Users/shruti5488/Documents/JAVA/JavaPractice/String1/AISearch/src/testcases_DFS.txt"));

		String algo = br.readLine();
		String start = br.readLine();
		String end = br.readLine();
		String node;
		String path = "";

		int num_live_traffic = Integer.parseInt(br.readLine());
		String file_line;
		int weight;
		AISearch ai = new AISearch();
		
		for (int i = 0; i < num_live_traffic; i++) {
			file_line = br.readLine().trim();
			node = file_line.split(" ")[0];
			path = file_line.split(" ")[1];
			weight = Integer.parseInt(file_line.split(" ")[2]);
			ai.addEdge(node, path);
			Maintain_Weight mw = new Maintain_Weight(node+" " + path, weight);	
		}

		if(algo.equals("DFS")){
			ArrayList<String> DFSPath = ai.DFS(start, end, ai.getGraph());
			Collections.reverse(DFSPath);
			System.out.println("DFS Traversal: " + DFSPath);
		}else if(algo.equals("BFS")){
			ArrayList<String> shortestPathList = ai.BFS(start, end, ai.getGraph());
			Collections.reverse(shortestPathList);
			System.out.println("BFS Traversal: " + shortestPathList);
		}


	}

}
