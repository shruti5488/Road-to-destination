//import java.util.PriorityQueue;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.Collections;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Comparator;
//
////diff between uniform cost search and dijkstra algo is that UCS has a goal
//
//public class test{
//    public static void main(String[] args){
//
//        //initialize the graph base on the Romania map
//        Node n1 = new Node("A");
//        Node n2 = new Node("B");
//        Node n3 = new Node("C");
//        Node n4 = new Node("D");
//        Node n5 = new Node("S");
////        Node n6 = new Node("Rimnicu Vilcea");
////        Node n7 = new Node("Pitesti");
////        Node n8 = new Node("Timisoara");
////        Node n9 = new Node("Lugoj");
////        Node n10 = new Node("Mehadia");
////        Node n11 = new Node("Drobeta");
////        Node n12 = new Node("Craiova");
////        Node n13 = new Node("Bucharest");
////        Node n14 = new Node("Giurgiu");
//
//        //initialize the edges
//        n1.adjacencies = new Edge[]{
//            new Edge(n2,1),
//            new Edge(n3,1)
//        };
//
//        n2.adjacencies = new Edge[]{
//            new Edge(n3,5),
//            new Edge(n4,4)
//        };
//
//        n3.adjacencies = new Edge[]{
//            new Edge(n5,1)
//        };
//
////        n4.adjacencies = new Edge[]{
////            new Edge(n1,140),
////            new Edge(n5,99),
////            new Edge(n3,151),
////            new Edge(n6,80),
////        };
////
////        n5.adjacencies = new Edge[]{
////            new Edge(n4,99),
////            new Edge(n13,211)
////        };
////
////        n6.adjacencies = new Edge[]{
////            new Edge(n4,80),
////            new Edge(n7,97),
////            new Edge(n12,146)
////        };
////
////        n7.adjacencies = new Edge[]{
////            new Edge(n6,97),
////            new Edge(n13,101),
////            new Edge(n12,138)
////        };
////
////        n8.adjacencies = new Edge[]{
////            new Edge(n1,118),
////            new Edge(n9,111)
////        };
////
////        n9.adjacencies = new Edge[]{
////            new Edge(n8,111),
////            new Edge(n10,70)
////        };
////
////        n10.adjacencies = new Edge[]{
////            new Edge(n9,70),
////            new Edge(n11,75)
////        };
////
////        n11.adjacencies = new Edge[]{
////            new Edge(n10,75),
////            new Edge(n12,120)
////        };
////
////        n12.adjacencies = new Edge[]{
////            new Edge(n11,120),
////            new Edge(n6,146),
////            new Edge(n7,138)
////        };
////
////        n13.adjacencies = new Edge[]{
////            new Edge(n7,101),
////            new Edge(n14,90),
////            new Edge(n5,211)
////        };
////
////        n14.adjacencies = new Edge[]{
////            new Edge(n13,90)
////        };
//
//        UniformCostSearch(n1,n5);
//
//        List<Node> path = printPath(n5);
//
//        System.out.println("Path: " + path);
//
//    }
//
//    public static void UniformCostSearch(Node source, Node goal){
//
//        source.pathCost = 0;
//        PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
//            new Comparator<Node>(){
//
//                //override compare method
//                public int compare(Node i, Node j){
//                    if(i.pathCost > j.pathCost){
//                        return 1;
//                    }
//
//                    else if (i.pathCost < j.pathCost){
//                        return -1;
//                    }
//
//                    else{
//                        return 0;
//                    }
//                }
//            }
//
//        );
//
//        queue.add(source);
//        Set<Node> explored = new HashSet<Node>();
//        boolean found = false;
//
//        //while frontier is not empty
//        do{
//
//            Node current = queue.poll();
//            explored.add(current);
//
//
//            if(current.value.equals(goal.value)){
//                found = true;
//
//
//            }
//            
//            if (current.adjacencies !=null){
//
//                for(Edge e: current.adjacencies){
//                    Node child = e.target;
//                    double cost = e.cost;
//                    child.pathCost = current.pathCost + cost;
//
//
//
//                    if(!explored.contains(child) && !queue.contains(child)){
//
//                        child.parent = current;
//                        queue.add(child);
//
//                        System.out.println(child);
//                        System.out.println(queue);
//                        System.out.println();
//
//                    }
//                    else if((queue.contains(child))&&(child.pathCost>current.pathCost)){
//                        child.parent=current;
//
//                        // the next two calls decrease the key of the node in the queue
//                        queue.remove(child);
//                        queue.add(child);
//                    }
//
//
//                }
//            }
//
//        }while(!queue.isEmpty());
//
//    }
//
//    public static List<Node> printPath(Node target){
//        List<Node> path = new ArrayList<Node>();
//        for(Node node = target; node!=null; node = node.parent){
//            path.add(node);
//        }
//
//        Collections.reverse(path);
//
//        return path;
//
//    }
//
//}
//
////class Node{
////
////    public final String value;
////    public double pathCost;
////    public Edge[] adjacencies;
////    public Node parent;
////
////    public Node(String val){
////
////        value = val;
////
////    }
////
////    public String toString(){
////        return value;
////    }
////
////}
////
////class Edge{
////    public final double cost;
////    public final Node target;
////
////    public Edge(Node targetNode, double costVal){
////        cost = costVal;
////        target = targetNode;
////
////    }
////}