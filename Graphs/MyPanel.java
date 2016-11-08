// Michael Wilson
// Graphing Side project
// The intent of this project is to create a visualization of various graphic algorithms

// START DATE: 11/7/2016

// this is for the panel
import javax.swing.*;

// this is for the shapes
import java.awt.*;

// using this library to temporarily debug the program
import java.util.*;

// class that contains the contents of the graph
public class MyPanel extends JPanel {

   // This will keep track of the animation speed
   private static final int ANIMATION_SPEED = 100; 

   // default size for the boxes
   private final int NODE_HEIGHT = 25;
   private final int NODE_WIDTH = 50;
   
   // takes into consideration the width and height of the frame
   private int panelWidth;
   private int panelHeight;
   
   // keeps reference to the graph
   private Graph myGraph;
   
   
   // keeps track of the current width and height of the squares
   private int x;
   private int y;
   
   // stepper that keeps track of how far into an algorithm we have stepped
   private int stepper;

   // stack that is used for DFS && DFSStep --> will probably remove this later
   // down the road when I start to refactor the code. For now I'm just cramming 
   // out a lot to see the functionality.    
   private Stack<Node> myStack; 
   
   
   // doing a quick set up here of elements that don't have 
   // to be set up in the constructor
   {
      stepper = 0;
      myStack = new Stack<>();
      x = y = 10;
   }      

   public MyPanel(int frameW, int frameH, Graph graph) {
      super();
      setBackground(Color.GREEN);
      panelWidth = frameW;
      panelHeight = frameH;
      myGraph = graph;      
   }   
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      drawVertices(g); 
      drawEdges(g);
   }   
  
   // private helper method that draws the vertices
   private void drawVertices(Graphics g) {
      // keeps space between the vertices
      int spacer = 50;
     
      // calculate the number of nodes that can fit per row
      int colCount = panelWidth / (NODE_WIDTH + spacer);
      
      int vertexNumber = 0;
      
      while(vertexNumber < myGraph.getVertices().size()) {
         for(int i = 0; i < colCount; i++) {
            Rectangle top = new Rectangle(x, y, NODE_WIDTH, NODE_HEIGHT);
            // designate where the text should be relative to the 'box'
            int lineX = top.x + top.width/2;
            int lineY = top.y + top.height/2;
            if(vertexNumber >= myGraph.getVertices().size())
               break;
            Node vertex = myGraph.getVertices().get(vertexNumber);   
            // draw the vertex
            g.setColor(vertex.getColor());
            g.fillRect(top.x, top.y, top.width, top.height);
            g.setColor(Color.GREEN);
            g.drawString(vertex.toString(), lineX, lineY);            
            
            // VERY IMPORTANT TO SET THE X AND Y BEFORE MOVING FORWARD
            // THIS IS CRUCIAL FOR THE EDGE METHOD TO WORK
            vertex.setX(x);
            vertex.setY(y);
            
            vertexNumber++;
            x += (spacer + NODE_WIDTH);
         }  
         x = 10;
         y += NODE_HEIGHT + spacer;             
      }      
      x = y = 10;  
   }  
   
   // private helper method that draws edges between the vertices
   private void drawEdges(Graphics g) {
      // loop through the edges, find the vertices, and connect
      for(Edge e : myGraph.getEdges()){
         Node start = e.getFirst();
         Node end = e.getSecond();
         
         // set the color to the appropriate edge color
         g.setColor(e.getColor());
         
         
         g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
         //g.drawString("cost: " + e.getCost(), Math.abs((end.getX() - start.getX())) / 2, 
         //          Math.abs((end.getY() - start.getY())) / 2);
      }
   }   
   
   // public method that deals with DFS
   public void DFSAnimation(){
      // this will traverse through the current graph 
      // IDEA
      // repeat until all edges have been reached:
      // explore all nearby edges
      // mark visited edges as red
      myStack.push(myGraph.getVertices().get(0)); 
      for(int i = 0; i < myGraph.getEdges().size(); i++) {
         if(myStack.size() == 0) break;          
         DFSHelper();       
      }              
   }
   
   // method that allows you to step through DFS
   public void DFSStep() {
      ++stepper;
      if(stepper == 1) myStack.push(myGraph.getVertices().get(0));   
      if(stepper < myGraph.getEdges().size()) 
         DFSHelper();
   } 
   
   
   // private helper method that deals with most of the DFS algorithm
   private void DFSHelper() {
      // remove the first element
          Node current = myStack.pop();
          current.setVisited(true);
          repaint();
          // explore
          for(Edge e : myGraph.getEdges()) {
             // check to make sure that there is an edge to another node
             // make sure that that node as not been visited
             if(e.contains(current) && !e.counterPart(current).visited()) {               
                myStack.push(e.counterPart(current));               
             }                 
          }    
   }
   
   // method that resets the vertices to their unvisited states
   public void reset() {
      for(Node n : myGraph.getVertices()) 
         n.setVisited(false);
      stepper = 0;
      repaint();
   }
   
}