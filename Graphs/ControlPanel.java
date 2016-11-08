import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{
   private MyPanel reference;

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
   public void paintComponent(Graphics g)
   {      
   }
}