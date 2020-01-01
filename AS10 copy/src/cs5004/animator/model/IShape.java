package cs5004.animator.model;

/**
 * This interface represents a shape and all its operations.
 */
public interface IShape extends Cloneable {

  /** Checks constructor inputs of for validity.
   *
   * @param appears    the appear time.
   * @param disappears the disappear time.
   * @param x          the x coordinate value postion.
   * @param y          the y coordinate value postion.
   * @param w          the width of shape.
   * @param h          the height of shape.
   * @param r          the red value of RGB.
   * @param g          the green value of RGB.
   * @param b          the blue value of RGB
   * @throws IllegalArgumentException if parameter inputs are invalid: if objects are null, if any
   *                                  numbers are < 0, if rgb >255, if conflict with
   *                                  appears/disappear times.
   */
  void checkConstructorInputs(String shapeId, int appears, int disappears,
                              double x, double y, double w, double h,
                              double r, double g, double b) throws IllegalArgumentException;

  /**
   * Get the shape id of shape.
   *
   * @return the shape id of the shape.
   */
  String getShapeId();

  /**
   * Get the x coord position value of shape.
   *
   * @return the x coord position value of shape.
   */
  double getX();

  /**
   * Get the y coord position value of shape.
   *
   * @return the y coord position value of shape.
   */
  double getY();

  /**
   * Get the width value of shape.
   *
   * @return the width value of shape.
   */
  double getW();

  /**
   * Get the height value of shape.
   *
   * @return the height  value of shape.
   */
  double getH();

  /**
   * Get the red (r of RGB) value of shape.
   *
   * @return the red (r of RGB) value of shape.
   */
  double getR();

  /**
   * Get the green (g of RGB) value of shape.
   *
   * @return the green (g of RGB) value of shape.
   */
  double getG();

  /**
   * Get the blue (b of RGB) value of shape.
   *
   * @return the blue (b of RGB) value of shape.
   */
  double getB();

  /**
   * Get the appear time of the shape.
   *
   * @return the appear time of the shape.
   */
  int getAppears();

  /**
   * Get the disappear time of the shape.
   *
   * @return the disappear time of the shape.
   */
  int getDisappears();

  /**
   * Prints the string description of the shape.
   *
   * @return the the string description of the shape.
   */
  String printString();

  /**
   * Gets the shape Type.
   *
   * @return the shape type.
   */
  ShapeType getShapeType();

  /**
   * Set the appear time.
   *
   * @param changeTo new value.
   */
  void setAppears(int changeTo);

  /**
   * Set the disappear time.
   *
   * @param changeTo new value.
   */
  void setDisappears(int changeTo);

  /**
   * Set the x value.
   *
   * @param newX new value.
   */
  void setX(int newX);

  /**
   * Set the y value.
   *
   * @param newY new value.
   */
  void setY(int newY);

  /**
   * Set the w value.
   *
   * @param newW new value.
   */
  void setW(int newW);

  /**
   * Set the H value.
   *
   * @param newH new value.
   */
  void setH(int newH);

  /**
   * Set the r value.
   *
   * @param newR new value.
   */
  void setR(double newR);

  /**
   * Set the G value.
   *
   * @param newG new value.
   */
  void setG(double newG);

  /**
   * Set the B value.
   *
   * @param newB new value.
   */
  void setB(double newB);


}
