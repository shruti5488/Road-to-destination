//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Deque;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Stack;
//import java.util.TreeMap;
//
//public class AISearch {
//
//	private HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
//	//	List<Maintain_Weight> scores = new ArrayList<Maintain_Weight>();
//	//	static HashMap<String, HashMap<String, Integer>> path_cost = new HashMap<>();
//	//	private static ArrayList path_cost = new ArrayList();
//	private static HashMap<String, Integer> path_cost = new HashMap<>();
//	public void setGraph(HashMap<String, List<String>> graph) {
//		this.graph = graph;
//	}
//
//	public HashMap<String, List<String>> getGraph() {
//		return graph;
//	}
//
//	public void addEdge(String node, String path) {
//		LinkedList<String> list_path = new LinkedList<String>();
//		if (getGraph().containsKey(node)) {
//			list_path.addAll(getGraph().get(node));
//			list_path.add(path);
//			getGraph().put(node, list_path);
//			setGraph(getGraph());
//
//		} else {
//			list_path.add(path);
//			getGraph().put(node, list_path);
//			setGraph(getGraph());
//		}
//
//	}
//	
////	public static ArrayList<String> UCS(String start, String end, HashMap<String, List<String>> graph) {
////		ArrayList<String> shortestPathList = new ArrayList<String>();
////		
////		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
////
////		if (start.equals(end)) {
////			shortestPathList.add(start);
////			return shortestPathList;
////		}
////
//////		Queue<String> queue = new LinkedList<String>();
////		Queue<HashMap<String, Integer>> queue = new Queue<HashMap<String, Integer>>();
////		
////		HashMap<String, String> pathStack = new HashMap<String, String>();
////
////		Boolean flag = false;
////		queue.add(start);
////		pathStack.put(start, start);
////		visited.put(start, true);
////
////		while (!queue.isEmpty()) {
////			String next = queue.poll();
////
////			if (graph.containsKey(next)) {
////				for (String v : graph.get(next)) {
////
////					if (!visited.containsKey(v)) {
////						queue.add(v);
////						visited.put(v, true);
////						pathStack.put(v, next);
////						if (end.equals(v)) {
////							flag = true;
////							break;
////						}
////						if (flag == true) {
////							break;
////						}
////					}
////
////				}
////				if (flag == true) {
////					break;
////				}
////			}
////
////		}
////
////		String current = end;
////		String node;
////		shortestPathList.add(end);
////
////		node = current;
////		while (node != start) {
////			node = pathStack.get(current);
////			current = node;
////			shortestPathList.add(node);
////		}
////		return shortestPathList;
////	
////		
////	}
//
////	public static String DFS(Node start, Node end, HashMap<String, List<String>> DFS_map) {
////		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
////		Deque<Node> stack = new ArrayDeque<>();
////		Stack<Node> temp_stack = new Stack<Node>();
////		//		ArrayList<String> shortestPathList = new ArrayList<String>();
////		String shortestPathList;
////////				HashMap<String, String> pathStack = new HashMap<String, String>();
////////				Graph pathStack = new Graph();
////		ArrayList<String> pathStack = new ArrayList<String>();
////		stack.push(start);
////		String vertex = start.getNode();
////		visited.put(vertex, true);
////		pathStack.add(start + " " + start);
////////		pathStack.put(start, start);
////		
////		if (start.equals(end)) {
////			shortestPathList = start.getNode();
////			return shortestPathList;
////		}
////		int i = 1;
////		boolean flag = false;
////		int count = 0;
////		while (!stack.isEmpty()) {
////			vertex = stack.pollFirst();
////			if(vertex.equals(end)){
////				count ++ ;
////			}
////			if (DFS_map.containsKey(vertex)) {
////				for (String child : DFS_map.get(vertex)) {
////					//					if (!visited.containsKey(v)) {	
////					temp_stack.add(child);
////					visited.put(child, true);
//////					pathStack.put(child, vertex);
////					pathStack.add(child + " " + vertex) ;
////
////					i++;
////					if(i == DFS_map.size() -1){
////						
////////						break;
////					}
////				} 
////				for(int j=temp_stack.size()-1;j>=0;j--){
////					stack.addFirst(temp_stack.get(j));
////				}
////				temp_stack.clear();
////				if (flag == true) {
////					//					break;
////				}
////			}
////		}
////		System.out.println(pathStack);
////		//		shortestPathList.add(end);
////		String node = end;
////		String second = node;
////		List<String> node_list;
////		int index=pathStack.size()-1;
////		TreeMap<Integer, ArrayList<String>> pathList = new TreeMap<Integer, ArrayList<String>>();
////		ArrayList<String> path_name = new  ArrayList<String>();
////		int sum = 0 ;
//////		System.out.println(count);
////		while (count>0) {
////			//			node = pathStack.get(second).get(index);
////			System.out.println(pathStack.size()-1);
////			for(int a =0;a<pathStack.size()-1;a++){
////				System.out.println(node);
////				if(pathStack.get(a).split(" ")[0].equals(node)){
////					node = pathStack.get(a).split(" ")[1];
////					System.out.println(node);
////				}
////			}
//////			node_list = pathStack.get(node);
////			while(node!=second){
//////				node = node_list.get(count-1);
////				System.out.println(node);
////				
////				//				sum += path_cost.get(node).get(second);
////				//				second = node = pathStack.get(second).get(index);
////				path_name.add(second);
////			}
////			pathList.put(sum, path_name);
////			count--;
////			//			index--;
////		}
////		//		shortestPathList = pathList.get(0).get(0);
////		return null;
////	}
//
//	public static void mark_visited() {
//
//	}
//
//	public static ArrayList<String> BFS(String start, String end, HashMap<String, List<String>> graph) {
//		ArrayList<String> shortestPathList = new ArrayList<String>();
//		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
//
//		if (start.equals(end)) {
//			shortestPathList.add(start);
//			return shortestPathList;
//		}
//
//		Queue<String> queue = new LinkedList<String>();
//		HashMap<String, String> pathStack = new HashMap<String, String>();
//
//		Boolean flag = false;
//		queue.add(start);
//		pathStack.put(start, start);
//		visited.put(start, true);
//
//		while (!queue.isEmpty()) {
//			String next = queue.poll();
//
//			if (graph.containsKey(next)) {
//				for (String v : graph.get(next)) {
//
//					if (!visited.containsKey(v)) {
//						queue.add(v);
//						visited.put(v, true);
//						pathStack.put(v, next);
//						if (end.equals(v)) {
//							flag = true;
//							break;
//						}
//						if (flag == true) {
//							break;
//						}
//					}
//
//				}
//				if (flag == true) {
//					break;
//				}
//			}
//
//		}
//
//		String current = end;
//		String node;
//		shortestPathList.add(end);
//
//		node = current;
//		while (node != start) {
//			node = pathStack.get(current);
//			current = node;
//			shortestPathList.add(node);
//		}
//		return shortestPathList;
//
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(
//				new FileReader("/Users/shruti5488/Documents/JAVA/JavaPractice/String1/AISearch/src/testcases_DFS.txt"));
//
//		String algo = br.readLine();
//		String start_node = br.readLine();
//		String end_node = br.readLine();
//		Node start = new Node(start_node);
//		Node end = new Node(end_node);
//		String node;
//		String path = "";
//
//		int num_live_traffic = Integer.parseInt(br.readLine());
//		String file_line;
//		int weight;
//		AISearch ai = new AISearch();
//
//		HashMap<String, Integer> child_path = new HashMap<String, Integer>();
//		HashMap<String, Boolean> checkForNode = new HashMap<String, Boolean>();
//		List<Graph> path_graph = new ArrayList<Graph>();
//		Graph parent = new Graph();
//		for (int i = 0; i < num_live_traffic; i++) {
//			file_line = br.readLine().trim();
//			node = file_line.split(" ")[0];
//			path = file_line.split(" ")[1];
//			weight = Integer.parseInt(file_line.split(" ")[2]);
//			
//			
//				
//				
//				
//				Node n = new Node(node);
//				checkForNode.containsKey(node);
//				if(checkForNode.containsKey(node)){
//					Node p = new Node(path);
//					int index = n.adjacencies.length;
//					n.adjacencies = new Edge[]{
//							new Edge(p, weight)
//					};
//					p.parent = n;
//					checkForNode.put(node, true);
//				}else{
//					Node p = new Node(path);
//					n.adjacencies = new Edge[]{
//							new Edge(p, weight)
//					};
//					p.parent = n;
//				}
//				
//				
//				
//				
////				if(checkForNode.containsKey(node)){
////					
////				}else{
////					
////					checkForNode.put(node, "N");
////					
////				}
//				
//				
//					
//			
//
//			
//			
//			
//			
////			ai.addEdge(node, path);
//			child_path = new HashMap<String, Integer>();
//			child_path.put(node,weight);
//			path_cost.put(node + " " + path,weight );
//			//			parent.setId(node);
//			//			path_graph.add(parent.setValue(path, weight));
//
//		}
//		String test = "X";
//
//
//		//System.out.println(path_cost.get("B F"));
//		if(algo.equals("DFS")){
////			String DFSPath = ai.DFS(start, end, ai.getGraph());
//			//Collections.reverse(DFSPath);
//			//			System.out.println("DFS Traversal: " + DFSPath);
//		}else if(algo.equals("BFS")){
////			ArrayList<String> shortestPathList = ai.BFS(start, end, ai.getGraph());
////			Collections.reverse(shortestPathList);
////			System.out.println("BFS Traversal: " + shortestPathList);
//		} else if(algo.equals("USC")){
////			ArrayList<String> shortestPathList = ai.UCS(start, end, ai.getGraph());
//			
//		}
//		
//
//
//	}
//
//}
//
//
//
