package common;

import java.awt.Dimension;
import javax.swing.JFrame;

public class StartDust
{

   public static void main(String[] args)
   {
      JFrame window = new JFrame();

      Dust dust = new Dust();          
      window.getContentPane().add(dust);
      window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
      window.setSize(new Dimension(2560, 700)); // needs a large monitor
      window.setLocationRelativeTo(null);
      window.setVisible(true);
   }

}
