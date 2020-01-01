package cs5004.animator.view;

import java.awt.*;
import java.util.SortedMap;

import javax.swing.*;

import cs5004.animator.model.IMotion;
import cs5004.animator.model.IShape;

/**
 * Creates a GUI AnimationView.
 */
public class AnimationView extends JFrame implements IView {

  DrawingPanel drawingPanel;
  JButton play;
  JButton pause;

  //DF
  protected java.util.SortedMap<IShape, String> shapes;
  protected  java.util.SortedMap<IMotion, String> motions;
  protected int speed;
  public Appendable ap;

  /**
   * Constructs an Animation view.
   *
   * @param speed the speed.
   * @param ap the appendable.
   */
  public AnimationView(int speed, Appendable ap) {

    //DF
    shapes = new java.util.TreeMap<IShape, String>();
    motions = new java.util.TreeMap<IMotion, String>();
    this.speed = speed;
    this.ap = ap;


    drawingPanel = new DrawingPanel();
    drawingPanel.setBackground(Color.white);
    //drawingPanel.setSize(1500,1500);

    //play = new JButton("play");
    //pause = new JButton("pause");


    setSize(1500,1500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    setLayout(new BorderLayout());


    JScrollPane scrollPanel = new JScrollPane(drawingPanel,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


    Dimension myDimension = new Dimension(1500, 1500);
    scrollPanel.setPreferredSize(myDimension);
    this.add(scrollPanel, BorderLayout.CENTER);


    setVisible(true);



  }

  /**
   * Gets the speed of view.
   *
   * @return the speed.
   */
  public int getSpeed() {

    return this.speed;

  }

  /**
   * Shows the Window.
   *
   * @param value the value of window.
   */
  public void showWindow(boolean value) {

    setVisible(value);

  }

  @Override
  public void render(java.util.List<IShape> toRenderShapes) {

    drawingPanel.drawShapes(toRenderShapes);

  }

  /**
   * Gets the shapes/motions and updates the views arrays with them.
   */
  @Override
  public void getModelShapes(SortedMap<IShape, String> shapes, SortedMap<IMotion, String> motions) {

    //saved from code example.


  }



}
