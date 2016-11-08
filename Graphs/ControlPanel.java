// Michael Wilson
// Graphing Side project
// The intent of this project is to create a visualization of various graphic algorithms

// START DATE: 11/7/2016

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

// class that contains container elements that will 
// allow the user a wide variety of functionality
// for the graph(s)
public class ControlPanel extends JPanel{
   private MyPanel reference;

   // general constructor
   // @param reference This parameter keeps track of another panel so that we may
   //                  modify the contents of the other panel 
   public ControlPanel(JPanel reference) {
      super();
      this.reference = (MyPanel)reference;
      setLayout(new FlowLayout());
      addButtons();
   }  
   
   // method that adds buttons
   private void addButtons() {
      JButton DFS = new JButton("Depth First Search");
      DFS.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
            // for now this will start at node a
            reference.DFSAnimation();                        
         }
      });
      add(DFS);
      
      JButton step = new JButton("Step");
      step.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
            // for now this will start at node a
            reference.DFSStep();                        
         }
      });
      add(step);
            
      
      JButton reset = new JButton("Reset");
      reset.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            reference.reset();
         }
      });
      add(reset);
   } 
   
   // This just really sets up the color scheme 
   // there will be additional features and animations added
   public void paintComponent(Graphics g)
   {      
   }
}