package cs5004.animator.model;

/**
 * This class representing an abstract shape.
 */
public abstract class AbstractShape implements IShape, Comparable<IShape> {

  protected ShapeType shapeType;
  protected String shapeId;
  protected int appears;
  protected int disappears;
  protected double x;
  protected double y;
  protected double w;
  protected double h;
  protected double r;
  protected double g;
  protected double b;

  protected AbstractShape(String shapeId, int appears, int disappears,
                          double x, double y, double w, double h,
                          double r, double g, double b) {

    //check inputs and throw appropriate exception.
    checkConstructorInputs(shapeId, appears, disappears, x, y, w, h, r, g, b);

    this.shapeId = shapeId;
    this.appears = appears;
    this.disappears = disappears;

    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void checkConstructorInputs(String shapeId, int appears, int disappears,
                                double x, double y, double w, double h,
                                double r, double g, double b) throws IllegalArgumentException {

    if (shapeId == null) {

      throw new IllegalArgumentException("shapeId can't be null");

    }

    if (appears < 0) {

      throw new IllegalArgumentException("appear time can't be < 0");

    }

    if (disappears < 0) {

      throw new IllegalArgumentException("disappear time can't be < 0");

    }

    if (w <= 0) {

      throw new IllegalArgumentException("w can't be <= 0");

    }


    if (h <= 0) {

      throw new IllegalArgumentException("h can't be <= 0");

    }

    if (r < 0 || r > 255) {

      throw new IllegalArgumentException("r can't be < 0 || r can't be > 255");

    }

    if (g < 0 || g > 255) {

      throw new IllegalArgumentException("g can't be < 0 || g can't be > 255");

    }

    if (b < 0 || b > 255) {

      throw new IllegalArgumentException("b can't be < 0 ||  can't be > 255");

    }


  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getShapeId() {
    return this.shapeId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getX() {
    return this.x;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getY() {
    return this.y;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getW() {
    return this.w;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getH() {
    return this.h;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getR() {
    return this.r;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getG() {
    return this.g;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double getB() {
    return this.b;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getAppears() {

    return this.appears;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getDisappears() {

    return this.disappears;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(IShape b) {

    if (this.getAppears() < b.getAppears()) {

      return -1;

    }

    if (this.getAppears() > b.getAppears()) {

      return 1;

    }

    if (this.getAppears() == b.getAppears()) {

      return 1;

    }

    return 1;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ShapeType getShapeType() {

    return this.shapeType;

  }

  /**
   * Changes appear time.
   *
   * @param changeTo the num to change to.
   *
   */
  public void setAppears(int changeTo) {

    this.appears = changeTo;


  }

  /**
   * Changes disappear time.
   *
   * @param changeTo the num to change to.
   *
   */
  public void setDisappears(int changeTo) {

    this.disappears = changeTo;


  }

  /**
   * {@inheritDoc}
   */
  public void setX(int newX) {

    this.x = newX;

  }

  /**
   * {@inheritDoc}
   */
  public void setY(int newY) {

    this.y = newY;

  }

  /**
   * {@inheritDoc}
   */
  public void setW(int newW) {

    this.w = newW;

  }

  /**
   * {@inheritDoc}
   */
  public void setH(int newH) {

    this.h = newH;

  }

  /**
   * {@inheritDoc}
   */
  public void setR(double newR) {

    this.r = newR;

  }

  /**
   * {@inheritDoc}
   */
  public void setG(double newG) {

    this.g = newG;

  }

  /**
   * {@inheritDoc}
   */
  public void setB(double newB) {

    this.b = newB;

  }







}




