// Michael Wilson
// Graphing Side project
// The intent of this project is to create a visualization of various graphic algorithms

// START DATE: 11/7/2016

// library for frame and components
import javax.swing.*;

// library for shapes
import java.awt.*;

// This class deals with setting up the actual
// layout of the GUI
public class MyFrame extends JFrame {
   // creates a new toolkit
   private Toolkit myKit = Toolkit.getDefaultToolkit();
   private final int FRAME_HEIGHT = (int)myKit.getScreenSize().getHeight();
   private final int FRAME_WIDTH = (int)myKit.getScreenSize().getWidth();
    
   private MyPanel myPanel;
   
   // constructor to get things kicked off
   public MyFrame(Graph graph) {
      super();
      
      setTitle("Graph Visualizer");
      
      Dimension dimensionality = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
      
      // setting the size of the frame
      setPreferredSize(new Dimension(dimensionality.width/2, dimensionality.height/2));
            
      // sets the location of the frame relative to the dimensionality of the users 
      // computer screen
      setLocationRelativeTo(null);
      
      
     
      JPanel mainPanel = new JPanel(new BorderLayout());
            
      
      // method that adds the panels
      
      
      myPanel = new MyPanel(dimensionality.width/2 /* - (int)control.getSize().getWidth() */, dimensionality.height/2, graph);
      
      ControlPanel control = new ControlPanel(myPanel);
      mainPanel.add(control, BorderLayout.LINE_START);
      mainPanel.add(myPanel, BorderLayout.CENTER);
      
      // set the closing
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // sets up the icon for the frame      
      setIconImage(new ImageIcon("images/graph.png").getImage());
      add(mainPanel);
      
      pack();
      setVisible(true);      
   }      
}