package cs5004.animator.model;

/**
 * This class representing an rectangle shape which extends the abstract shape.
 */
public class Rectangle extends AbstractShape {


  /** Constructs a rectangle.
   *
   * @param id the shape id.
   * @param appears the appear time.
   * @param disappears the disappear time.
   * @param x the x value.
   * @param y the y value.
   * @param w the width.
   * @param h the height.
   * @param r the red rgb value.
   * @param g the green rgb value.
   * @param b the blue rgb value.
   */
  public Rectangle(String id, int appears, int disappears,
                      double x, double y, double w, double h,
                      double r, double g, double b) {

    super(id, appears, disappears, x, y, w, h, r, g, b);
    shapeType = ShapeType.RECTANGLE;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String printString() {

    return "Name: " + this.shapeId + "\nType: " +  this.shapeType.getPrintWord()
            + "\nMin corner: (" + this.x + "," + this.y + "), Width: " + this.w
            + ", Height: " + this.h + ", Color: (" + this.r + "," + this.g + ","
            + this.b + ")\nAppears at t=" + this.appears + "\nDisappears at t="
            + this.disappears;

  }


}
