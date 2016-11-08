// Michael Wilson
// Graphing Side project
// The intent of this project is to create a visualization of various graphic algorithms


import java.awt.*;
import java.util.*;

public class Edge implements Comparable<Edge> {
   private Node first;
   private Node second;
   private int cost;  
   
   // THIS IS FOR THE SOLE PURPOSE OF COLORING THE EDGES
   private Color color = Color.RED; 
   
   // simple edge constructor, used for unweighted graph
   public Edge(Node start, Node end) {      
      this(start, end, 0);
   }
   
   // Makes an edge
   public Edge(Node start, Node end, int weight) {
      if(start == null || end == null) throw new IllegalArgumentException();
      first = start;
      second = end;
      cost = weight;
   }
   
   // returns the first vertex
   public Node getFirst() {
      return first;
   }
      
   // returns the second vertex
   public Node getSecond() {
      return second;
   }   
   
   // returns the weight of this edge
   public int getCost() {
      return cost;
   }
   
   // allows the user to set the color of the edge
   public void setColor(Color color) {
      if(color == null) throw new IllegalArgumentException();
      this.color = color;
   }
   
   // a method that does nothing more than return the current edge color
   public Color getColor() {
      return color;
   }
   
   // method that checks to see if an edge contains a certain vertex
   public boolean contains(Node vertex) {
      if(vertex == null) throw new IllegalArgumentException();
      return (first.compareTo(vertex) == 0 || second.compareTo(vertex) == 0) ? true : false; 
   }
   
   // method that gets the counterpart to a passed in node    
   public Node counterPart(Node vertex) {
      if(vertex == null) throw new IllegalArgumentException();
      return (first.compareTo(vertex) == 0) ? second : first;
   }
   
   // compares the costs of two edges
   public int compareTo(Edge other) {
      if(other == null) throw new IllegalArgumentException();
      return cost - other.cost;
   }
}