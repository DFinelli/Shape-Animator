package cs5004.animator.model;

/**
 * This class representing an move motion which extends the abstract motion.
 */
public class Move extends AbstractMotion {

  private double fromX;
  private double fromY;
  private double toX;
  private double toY;

  /**
   * Construct a move motion.
   *
   * @param shapeId   the shape id.
   * @param startTime the start time.
   * @param endTime   the end time.
   * @param fromX     the from x.
   * @param fromY     the from y.
   * @param toX       the to x.
   * @param toY       the to y.
   * @throws IllegalArgumentException if invalid inputs.
   */
  public Move(String shapeId, int startTime, int endTime,
              double fromX, double fromY, double toX, double toY)
          throws IllegalArgumentException {

    checkConstructorInputs(shapeId, startTime, endTime, fromX, fromY, toX, toY);

    //abstract fields
    this.motionType = MotionType.MOVE;
    this.shapeId = shapeId;
    this.startTime = startTime;
    this.endTime = endTime;

    //move fields
    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;

  }

  /**
   * Gets the from x value.
   *
   * @return from x value.
   */
  public double getFromX() {

    return fromX;

  }

  /**
   * Gets the from y value.
   *
   * @return from y value.
   */
  public double getFromY() {

    return fromY;

  }

  /**
   * Gets the to x value.
   *
   * @return to x value.
   */
  public double getToX() {

    return toX;

  }

  /**
   * Gets the to y value.
   *
   * @return to y value.
   */
  public double getToY() {

    return toY;

  }

  /**
   * Sets the from x value.
   */
  public void setFromX(double newX) {

    this.fromX = newX;

  }


  /**
   * Gets the from y value.
   */
  public void setFromY(double newY) {

    this.fromY = newY;

  }


  /**
   * {@inheritDoc}
   */
  @Override
  public String printString() {

    return "Shape " + this.shapeId + " moves from (" + this.fromX + "," + this.fromY
            + ") to (" + this.toX + "," + this.toY + ") from t=" + this.startTime
            + " to t=" + this.endTime;

  }

  //NOT an override because inputs are different for each move

  /**
   * Checks the instructors inputs for validity.
   *
   * @param shapeId   the shapeid.
   * @param startTime the starttime.
   * @param endTime   the endtime.
   * @param fromX     the fromx.
   * @param fromY     the fromy.
   * @param toX       the tox.
   * @param toY       the toy.
   * @throws IllegalArgumentException throw exception if invalid inputs.
   */
  public void checkConstructorInputs(String shapeId, int startTime, int endTime,
                                     double fromX, double fromY, double toX, double toY)
          throws IllegalArgumentException {

    if (shapeId == null) {

      throw new IllegalArgumentException("shapeId can't be null");

    }

    if (startTime < 0) {

      throw new IllegalArgumentException("start time can't be < 0");

    }

    if (endTime < 0) {

      throw new IllegalArgumentException("end time can't be < 0");

    }


    if (endTime == startTime) {

      throw new IllegalArgumentException("Can't have a motion that end&starts at same time");

    }

    if (startTime > endTime) {

      throw new IllegalArgumentException("Motion can't start after its end time");

    }


  }


}
