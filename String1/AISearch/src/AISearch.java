
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class AISearch {
	private static final boolean String = false;
	public static String ShortestPath_DFS(String start, String end, HashMap<String, List<List<String>>> DFS_map) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		Deque<String> stack = new ArrayDeque<>();
		Stack<String> temp_stack = new Stack<String>();
		ArrayList<List<String>> pathStack = new ArrayList<List<String>>();
		int count =0;
		ArrayList<String> list_short  = new ArrayList<String>();
		List<List<String>> shortestPathList = new ArrayList<List<String>>();
		String hold_path;
		int index = 0, pathCost = 0;
		String pathRoute = "", node;
		
		
		stack.push(start);
		if (start.equals(end)){
			return start;
		}
		String vertex = start;
		visited.put(vertex, true);
		pathStack.add(Arrays.asList(start, start, "0"));

		while (!stack.isEmpty()) {
			vertex = stack.pollFirst();
			if (DFS_map.containsKey(vertex)) {
				for (List<String> v : DFS_map.get(vertex)) {
					temp_stack.add(v.get(0));
					visited.put(v.get(0), true);
					pathStack.add(Arrays.asList(v.get(0), vertex, v.get(1).toString() ));
					if (end.equals(v.get(0))) {
						count++;
					}
				} 
				for(int i=temp_stack.size()-1;i>=0;i--){
					stack.addFirst(temp_stack.get(i));
				}
				temp_stack.clear();
			}
		}

		while(index<count){
			list_short.add(end);
			node = end;
			while(!node.equals(start)){
				for(int i=0 ; i<pathStack.size() ; i++){
					if(pathStack.get(i).get(0).equals(node)){
						pathCost += Integer.parseInt(pathStack.get(i).get(2));
						list_short.add(pathStack.get(i).get(1));
						node = pathStack.get(i).get(1);
						pathStack.remove(i);
						if(node.equals(start)){
							break;
						}
					}
				}
			} 
			Collections.reverse(list_short);
			hold_path = list_short.toString();
			shortestPathList.add(Arrays.asList(hold_path, Integer.toString(pathCost)));
			list_short.clear();
			pathCost = 0;
			index++;
		}
		Collections.sort(shortestPathList, new Comparator<List<String>>(){
			@Override
			public int compare(List<String> o1, List<String> o2) {
				// TODO Auto-generated method stub
				return o1.get(1).compareTo(o2.get(1));
			}
		});
		return shortestPathList.get(0).get(0);
	}


	public static ArrayList<String> DFS(String start, String end, HashMap<String, List<List<String>>> DFS_map) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		Deque<String> stack = new ArrayDeque<>();
		Stack<String> temp_stack = new Stack<String>();
		ArrayList<String> shortestPathList = new ArrayList<String>();
		HashMap<String, String> pathStack = new HashMap<String, String>();
		boolean flag = false;
		
		stack.push(start);
		String vertex = start;
		visited.put(vertex, true);
		pathStack.put(start, start);
		if (start.equals(end)) {
			shortestPathList.add(start);
			return shortestPathList;
		}

		while (!stack.isEmpty()) {
			vertex = stack.pollFirst();
			if (vertex.equals(end)) {
				break;
			}
			if (DFS_map.containsKey(vertex)) {
				for (List<String> v  : DFS_map.get(vertex)) {
					if (!visited.containsKey(v.get(0))) {
						temp_stack.add(v.get(0));
						visited.put(v.get(0), true);
						pathStack.put(v.get(0), vertex);
						if (end.equals(v.get(0))) {
							flag = true;
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
		shortestPathList = getShortestPath(start, end,  pathStack);
		return shortestPathList;
	}


	public static ArrayList<String> BFS(String start, String end, HashMap<String, List<List<String>>> graph) {
		ArrayList<String> shortestPathList = new ArrayList<String>();
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		Queue<String> queue = new LinkedList<String>();
		HashMap<String, String> pathStack = new HashMap<String, String>();
		Boolean flag = false;
		
		if (start.equals(end)) {
			shortestPathList.add(start);
			return shortestPathList;
		}
		queue.add(start);
		pathStack.put(start, start);
		visited.put(start, true);
		while (!queue.isEmpty()) {
			String next = queue.poll();
			if (graph.containsKey(next)) {
				for (List<String> v  : graph.get(next)) {
					if (!visited.containsKey(v.get(0))) {
						queue.add(v.get(0));
						visited.put(v.get(0), true);
						pathStack.put(v.get(0), next);
						if (end.equals(v.get(0))) {
							flag = true;
							break;
						}
					}
				}
			}
		}
		shortestPathList = getShortestPath(start, end,  pathStack);
		return shortestPathList;
	}

	public static ArrayList<String> getShortestPath(String start, String end, HashMap<String, String> pathStack){
		ArrayList<String> shortestPathList = new ArrayList<String>();
		String node = end;
		String current = end;
		
		shortestPathList.add(end);
		while (node != start) {
			node = pathStack.get(current);
			current = node;
			shortestPathList.add(node);
		}
		Collections.reverse(shortestPathList);
		return shortestPathList;
	}

	public static ArrayList<String> UCS(String start, String end, HashMap<String, List<List<String>>> graph) {
		ArrayList<String> shortestPathList = new ArrayList<String>();
		String parent = "";
		MyComparator comparator = new MyComparator();
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>(13, comparator);
		ArrayList<List<String>> pathStack = new ArrayList<List<String>>();
		int count =0, costParent = 0, cost_node, i =0;
		String node = end;
		String vertex = start;
		
		pQueue.offer(new Node(start, start, 0, 0));
		if (start.equals(end)){
			shortestPathList.add(start +" "+ "0");
			return shortestPathList;
		}

		while (!pQueue.isEmpty()) {
			vertex = pQueue.peek().node;
			parent = pQueue.peek().parent;
			costParent = pQueue.poll().pathCost;
			pathStack.add(Arrays.asList(vertex, parent, Integer.toString(costParent)));
			if (graph.containsKey(vertex)) {
				for (List<String> v : graph.get(vertex)) {
					cost_node = costParent+ Integer.parseInt(v.get(1));
					pQueue.offer(new Node(v.get(0), vertex, cost_node, 0));
					if (end.equals(v.get(0))) {
						count++;
					}
				} graph.remove(vertex);
				costParent = 0;
			}
		}
		
		for(i=0;i<pathStack.size();i++){
			if(node.equals(start)){
				shortestPathList.add(pathStack.get(i).get(0) +" "+ pathStack.get(i).get(2));
				break;
			}
			if (pathStack.get(i).get(0).equals(node)){
				node = pathStack.get(i).get(1);
				shortestPathList.add(pathStack.get(i).get(0) +" "+ pathStack.get(i).get(2));
				i=-1;
			} 
		}
		Collections.reverse(shortestPathList);
		return shortestPathList;
	}

	public static ArrayList<String> AStar(String start, String end, HashMap<String, List<List<String>>> graph, HashMap<String, Integer> live_traffic) {
		ArrayList<String> shortestPathList = new ArrayList<String>();
		String parent = "";
		MyComparator comparator = new MyComparator();
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>(13, comparator);
		ArrayList<List<String>> pathStack = new ArrayList<List<String>>();
		int count =0, costParent = 0, cost_node, heuristic = 0;
		String vertex = start;
		String node = end;
		
		pQueue.offer(new Node(start, start, live_traffic.get(start), 0));
		if (start.equals(end)){
			shortestPathList.add(start + " 0");
			return shortestPathList;
		}
		while (!pQueue.isEmpty()) {
			vertex = pQueue.peek().node;
			parent = pQueue.peek().parent;
			costParent = pQueue.peek().heuristic;
			heuristic =  pQueue.poll().heuristic;
			pathStack.add(Arrays.asList(vertex, parent,Integer.toString(heuristic)));

			if (graph.containsKey(vertex)) {
				for (List<String> v : graph.get(vertex)) {
					cost_node = costParent+ Integer.parseInt(v.get(1)) + live_traffic.get(v.get(0));
					pQueue.offer(new Node(v.get(0), vertex,  cost_node, costParent+ Integer.parseInt(v.get(1))));
					if (end.equals(v.get(0))) {
						count++;
					}
				} graph.remove(vertex);
				costParent = 0;
			}
		}

		for(int i=0;i<pathStack.size();i++){
			if(node.equals(start)){
				shortestPathList.add(pathStack.get(i).get(0) +" " + pathStack.get(i).get(2));
				break;
			}
			if (pathStack.get(i).get(0).equals(node)){
				node = pathStack.get(i).get(1);
				shortestPathList.add(pathStack.get(i).get(0) +" "+ pathStack.get(i).get(2));
				i=-1;
			} 
		}
		Collections.reverse(shortestPathList);
		return shortestPathList;
	}

	public void printTraversedPath(ArrayList<String> pathList, String algo, String pathAllPath){
		String caption ="";
		int i =0;
		
		if(algo.equals("DFS")){
			caption = "DFS Traversal: ";
		} else if(algo.equals("BFS")){
			caption = "BFS Traversal: ";
		}else if(algo.equals("DFS_short")){
			caption = "ShortestPath by DFS traversal: ";
		}else if(algo.equals("UCS")){
			caption = "ShortestPath by UCS traversal: ";
		}else if(algo.equals("A*")){
			caption = "Path traversed by A* algorithm: ";
		}
		System.out.println(caption);
		if(pathList!=null){
			if (algo.equals("DFS") || algo.equals("BFS")){
				for(String v : pathList){
					System.out.println(v + " " + i);
					i++;
				}
			} else if (algo.equals("UCS") || algo.equals("A*")){
				for(String v : pathList){
					System.out.println(v);
					i++;
				}
			}
		} else{
			String[] path = new String[pathAllPath.length()-1];
			path = pathAllPath.split(" ");
			for(int j=0;j<pathAllPath.length(); j++){
				System.out.println(path[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("/Users/shruti5488/Documents/JAVA/JavaPractice/String1/AISearch/src/testcases_BFS.txt"));

		String algo = br.readLine();
		String start = br.readLine();
		String end = br.readLine();
		String node, path = "";
		HashMap<String, Integer> live_traffic = new HashMap<String, Integer>();
		ArrayList<String> pathList = new ArrayList<String>();
		String caption, pathAllPath;
		
		int numOfPath = Integer.parseInt(br.readLine());
		String file_line;
		int weight;
		Graph graph = new Graph();
		AISearch ai = new AISearch();

		for (int i = 0; i < numOfPath; i++) {
			file_line = br.readLine().trim();
			node = file_line.split(" ")[0];
			path = file_line.split(" ")[1];
			weight = Integer.parseInt(file_line.split(" ")[2]);
			graph.addEdge(node, path, weight);
		} 
		
		int num_live_traffic = Integer.parseInt(br.readLine().trim());

		for(int j=0;j<num_live_traffic;j++){
			file_line = br.readLine();
			live_traffic.put(file_line.split(" ")[0], Integer.parseInt(file_line.split(" ")[1]));
		}

		if(algo.equals("DFS")){
			pathList = ai.DFS(start, end, graph.getGraph());
			ai.printTraversedPath(pathList, algo, "");
		} else if(algo.equals("BFS")){
			pathList = ai.BFS(start, end, graph.getGraph());
			ai.printTraversedPath(pathList, algo, "");
		}else if(algo.equals("DFS_short")){
			pathAllPath = ai.ShortestPath_DFS(start, end, graph.getGraph());
			ai.printTraversedPath(null, algo, pathAllPath);
		}else if(algo.equals("UCS")){
			pathList = ai.UCS(start, end, graph.getGraph());
			ai.printTraversedPath(pathList, algo, "");
		}else if(algo.equals("A*")){
			pathList =  ai.AStar(start, end, graph.getGraph(), live_traffic);
			ai.printTraversedPath(pathList, algo, "");
		}
	}
}