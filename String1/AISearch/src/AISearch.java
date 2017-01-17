import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AISearch {

	private static HashMap<String, List<String>> graph = new HashMap<String, List<String>>();

	public void setGraph(HashMap<String, List<String>> graph) {
		this.graph = graph;
	}

	public static HashMap<String, List<String>> getGraph() {
		return graph;
	}

	public static void addEdge(String node, String path) {
		int index = 0;

		LinkedList<String> list_path = new LinkedList<String>();
		if (graph.containsKey(node)) {
			index = Collections.frequency(graph.values(), node);
			list_path.addAll(graph.get(node));
			list_path.add(path);
			graph.put(node, list_path);
			// visited.put(node, false);
		} else {
			list_path.add(path);
			graph.put(node, list_path);
			// visited.put(node, false);
		}

	}

	public static ArrayList<String> DFS(String start, String end, HashMap<String, List<String>> DFS_map) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		Stack<String> stack = new Stack<String>();
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
		String v;
		while (!stack.isEmpty()) {
			if (vertex.equals(end)) {
				break;
			}
			if (DFS_map.containsKey(vertex)) {
				Collections.sort(DFS_map.get(vertex), Collections.reverseOrder());
				for (int i = 0; i < DFS_map.get(vertex).size(); i++) {
					v = DFS_map.get(vertex).get(i);
					if (!visited.containsKey(v)) {

						visited.put(v, true);
						stack.push(v);
						pathStack.put(v, vertex);

					}
				}
			}

			vertex = stack.pop();
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
		for (int i = 0; i < num_live_traffic; i++) {
			file_line = br.readLine().trim();
			node = file_line.split(" ")[0];
			path = file_line.split(" ")[1];

			addEdge(node, path);
		}

		ArrayList<String> DFSPath = DFS(start, end, graph);
		System.out.println("DFS Traversal: " + DFSPath);
		ArrayList<String> shortestPathList = BFS(start, end, graph);
		System.out.println("BFS Traversal: " + shortestPathList);

	}

}
