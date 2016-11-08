// Michael Wilson
// Graphing Side project
// The intent of this project is to create a visualization of various graphic algorithms

// START DATE: 11/7/2016

import java.awt.*;

// really should have made this class vertex, oh well
public class Node implements Comparable<Node> {
   private char name;
   
   // representation of the nodes location with respect to the jpanel
   private int x;
   private int y;
   
   // the current visitation status of the node
   private boolean visited = false;
   
   // color of the node
   private Color color;
   
   // see if the node has been paired
   private boolean paired = false;
   
   public Node(char name) {
      this.name = name;
      color = Color.black;
      x = 0;
      y = 0;
   }
   
   // method that returns the name of this node
   public char getName() {
      return name;
   }
   
   // method that prints out the contents of the node
   public String toString() {
      return "" + name;
   }
   
   // gets the x value
   public int getX() {
      return x;
   }
   
   // sets the x value
   public void setX(int spot) {
      x = spot;
   }
   
   // gets the y value
   public int getY() {
      return y;
   }
   
   // sets the y value
   public void setY(int spot) {
      y = spot;
   }   
   
   // sets visited field
   public void setVisited(boolean visited) {
      this.visited = visited;
      color = visited ? Color.RED : Color.BLACK;
   }

   // returns the visited status
   public boolean visited(){
      return visited;
   }
   
   // method that returns the current color of the NODE
   public Color getColor() {
      return color;
   }
   
   // method that sets the pairing status of the node
   public void setPaired(boolean value) {
      paired = value;
   }
   
   // returns the current pairing status of the node
   public boolean isPaired() {
      return paired;
   }
   
   // comparison method for one node to the other
   // under the assumption that there can be no nodes with the same name
   public int compareTo(Node other) {
      return name - other.name;
   }
}