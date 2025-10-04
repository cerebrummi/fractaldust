package common;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

import enums.Symbol;
import fa.walksets.CPn;

/**
 * In analogy to Cantors fractal dust.
 * All L's are black, all M's are wiped out.
 */
public class Dust extends JPanel
{
   private static final long serialVersionUID = -8630127659972157978L;

   private Color colorForL = Color.BLACK;;
   private double x = 0;
   private double y = 60;
   private double width;
   
   private final int MAX_STEPS = 12; // because of screen pixels available

   private SFA sfa;

   public Dust()
   {
      sfa = new SFA();
      JButton knopf = new JButton("start");
      knopf.addActionListener(_ -> {
         knopf.setEnabled(false);
         for (int i = 0; i < MAX_STEPS; i++)
         {
            step();
         }
      });
      this.add(knopf);
   }

   public void step()
   {
      sfa.step();
      CPn walksetCPn = sfa.getWalksetCPn();
      LinkedList<Symbol> symbols = walksetCPn.getSymbols();
      width = 2400D / symbols.size();
      x = 80;
      for (Symbol symbol : symbols)
      {
         if (Symbol.L.equals(symbol))
         {
            paintComponent(this.getGraphics());
           
         }           
         x = x + width;
      }
      y += 50;
   }

   public void paintComponent(Graphics g)
   {
      int actualWidth = (int) width;
      if(actualWidth < 1)
      {
         actualWidth = 1;
         colorForL = Color.CYAN;
      }
      else
      {
         colorForL = Color.BLACK;
      }
      g.setColor(colorForL);
      g.fillRect((int) (x), (int) (y), (int) actualWidth, 10);
   }
}
