package cs5004.animator.model;

/**
 * This class representing an oval shape which extends the abstract shape.
 */
public class Oval extends AbstractShape {

  /** Constructs an oval.
   *
   * @param shapeId the shape id.
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
  protected Oval(String shapeId, int appears, int disappears,
                 double x, double y, double w, double h,
                 double r, double g, double b) {

    super(shapeId, appears, disappears, x, y, w, h, r, g, b);
    shapeType = ShapeType.OVAL;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String printString() {

    return "Name: " + this.shapeId + "\nType: " +  this.shapeType.getPrintWord()
            + "\nCenter: (" + this.x + "," + this.y + "), X radius: " + this.w
            + ", Y radius: " + this.h + ", Color: (" + this.r + "," + this.g + ","
            + this.b + ")\nAppears at t=" + this.appears + "\nDisappears at t="
            + this.disappears;

  }


}