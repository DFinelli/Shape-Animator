package cs5004.animator.view;

import java.util.SortedMap;

import cs5004.animator.model.IMotion;
import cs5004.animator.model.IShape;

/**
 * This class representing i view.
 */
public interface IView {

  //void render(java.util.List<IViewShape> shapes);

  /**
   * Runs the view.
   */
  void render(java.util.List<IShape> toRenderShapes);

  /**
   * Gets the shapes/motions and updates the views arrays with them.
   */
  void getModelShapes(SortedMap<IShape, String> shapes, SortedMap<IMotion, String> motions);

  int getSpeed();
}
