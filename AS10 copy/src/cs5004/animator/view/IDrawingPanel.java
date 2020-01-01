package cs5004.animator.view;


import cs5004.animator.model.IShape;


/**
 * Interface for a IdrawingPanel.
 */
public interface IDrawingPanel {

  void drawShapes(java.util.List<IShape> shapesToDraw);

}
