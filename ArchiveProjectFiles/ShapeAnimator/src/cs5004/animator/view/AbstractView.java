package cs5004.animator.view;

import java.util.SortedMap;

import cs5004.animator.model.IMotion;
import cs5004.animator.model.IShape;

/**
 * This class representing an abstract view.
 */
public abstract class AbstractView implements IView {

  protected java.util.SortedMap<IShape, String> shapes;
  protected  java.util.SortedMap<IMotion, String> motions;
  protected int speed;
  public Appendable ap;

  //int speed;

  AbstractView(int speed, Appendable ap) {

    shapes = new java.util.TreeMap<IShape, String>();
    motions = new java.util.TreeMap<IMotion, String>();
    this.speed = speed;
    this.ap = ap;

  }

  @Override
  public void getModelShapes(SortedMap<IShape, String> shapes, SortedMap<IMotion, String> motions) {

    this.shapes = shapes;
    this.motions = motions;

  }



}
