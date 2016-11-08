// Michael Wilson
// Graphing Side project
// The intent of this project is to create a visualization of various graphic algorithms

// START DATE: 11/7/2016

import java.util.*;

// class that kicks off the whole program and constructs
// a list of vertices and a set of edges
public class GUIClient {    
   private static List<Node> myVertices;
   
   // sets of edges
   private static Set<Edge> myEdges;
   
   // random variable to be used throughout several different methods
   private static Random rand;
   
   // method that gets the whole program running 
   public static void main(final String[] theArgs) {
      rand = new Random();
      myVertices = new ArrayList<Node>();
      myEdges = new TreeSet<Edge>();
      
      makeVertices();
      makeEdges();
   }   
   
   // method that makes the individual vertices to use for the graphing problems
   private static void makeVertices() {
      char letter = 'a';
      for(int i = 0; i < 26; i++) 
         myVertices.add(new Node(letter++));      
   }
   
   // method that makes the edge pairs
   private static void makeEdges() {      
      // create a set of edges    
      // an algorithm that takes O(N^2) running time        
      while(!allPaired()) {
         Node v1 = randomVertex();
         v1.setPaired(true);
         Node v2 = randomVertex();
         v2.setPaired(true);
         Edge newEdge = new Edge(v1, v2, randomWeight());
         myEdges.add(newEdge);
      }
      Graph temp = new Graph(myEdges, myVertices); 
      new MyFrame(temp);

   }   
   
   // method that chooses a random vertex
   // RT: bad
   private static Node randomVertex() {   
      while(true) {
         Node vertex = myVertices.get(rand.nextInt(myVertices.size()));
         if(!vertex.isPaired())
            return vertex;
      }   
   }
   
   
   // method that adds a random weight
   // will improve this method a bit because
   // at the moment it is fairly useless and just takes up more lines
   // this comment is longer than the method haha
   private static int randomWeight() {
      return rand.nextInt(1000) + 1;
   }
   
   // private method that checks if all the nodes have been paired
   private static boolean allPaired() {
      for(int i = 0; i < myVertices.size(); i++) {
         if(!myVertices.get(i).isPaired())
            return false;
      }
      return true;
   }         
}