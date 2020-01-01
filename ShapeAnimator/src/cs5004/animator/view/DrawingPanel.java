package cs5004.animator.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs5004.animator.model.IShape;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;

/**
 * A class representing a drawing panel which extends Jpanel and implements idrawingpanel.
 */
public class DrawingPanel extends JPanel implements IDrawingPanel {


  List<IShape> shapesToDraw = null;

  @Override
  public void drawShapes(List<IShape> argShapesToDraw) {



    this.shapesToDraw = argShapesToDraw;
    repaint();
  }

  // REPAINT CALLS paintComponent
  @Override
  public void paintComponent(Graphics g) {




    if (shapesToDraw != null) {
      for (IShape shape : this.shapesToDraw) {
        //g. is what makes it appear on the sreen

        System.out.println("\nGET R= " + shape.getR() + "\n");
        System.out.println("\nGET G= " + shape.getG() + "\n");
        System.out.println("\nGET B= " + shape.getB() + "\n");

        double rr = shape.getR() * 100;
        double gg = shape.getG() * 100;
        double bb = shape.getB() * 100;

        System.out.println("\nrr= " + rr + "\n");
        System.out.println("\ngg= " + gg + "\n");
        System.out.println("\nbb= " + bb + "\n");

        Color myColor = new Color(((int) rr), ((int) gg), ((int) bb));

        g.setColor(myColor);


        // if g.getshape is rect, fillRect


        if (shape instanceof Rectangle) {


          g.fillRect(((int) shape.getX()), ((int) shape.getY()),
                  ((int) shape.getW()), ((int) shape.getH()));

        }

        if (shape instanceof Oval) {

          g.fillOval(((int) shape.getX()), ((int) shape.getY()),
                  ((int) shape.getW()), ((int) shape.getH()));

        }


      }

    }
  }
}
