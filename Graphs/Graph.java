import java.util.*;

public class Graph {
   // keeps a set of edges
   private Set<Edge> myEdges;
   
   // keeps a set of vertices
   private List<Node> myVertices;
   
   public Graph(Set<Edge> edges, List<Node> vertices) {
      // LOL
      myEdges = new TreeSet<>(edges);
      myVertices = new ArrayList<>(vertices);
   }   
   
   // returns a set of the edges in the graph
   public Set<Edge> getEdges() {
      return myEdges;
   }
   
   // returns a set of the vertices in the graph
   public List<Node> getVertices() {
      return myVertices;
   }
   
   // method that returns a string of the vertices that currently live within 
   // the confines of the graph
   public String verticesInGraph() {
      StringBuilder alpha = new StringBuilder();
      alpha.append("[");      
      int iteration = 0;
      for(Node n : myVertices) {
         ++iteration;
         if(iteration != 1)          
            alpha.append(" | ");         
         alpha.append(n.toString());
      }
      return alpha.toString();
   }
}