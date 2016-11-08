import java.util.*;

public class GraphClient {
   private static List<Node> myVertices;
   
   // random variable to be used throughout several different methods
   private static Random rand;
   
   public static void main(final String[] theArgs) {
      rand = new Random();
      myVertices = new ArrayList<Node>();
      char letter = 'a';
      for(int i = 0; i < 26; i++) {
         Node newTemp = new Node(letter++);
         myVertices.add(newTemp);
      }
      
      // create a set of edges            
      for(int i = 0; i < myVertices.size()/2; i++) {
         Edge newEdge = new Edge(randomVertex(), randomVertex(), randomWeight());
      }
   }   
   
   // method that chooses a random vertex
   private static Node randomVertex() {      
      return myVertices.get(rand.nextInt(myVertices.size()));
   }
   
   
   // method that adds a random weight
   private static int randomWeight() {
      return rand.nextInt(1000) + 1;
   }
}