package cs5004.animator.model;

/**
 * This class representing an scale motion which extends the abstract motion.
 */
public class Scale extends AbstractMotion {

  private double fromW;
  private double fromH;
  private double toW;
  private double toH;

  /** Construct a move motion.
   *
   * @param shapeId the shape id.
   * @param startTime the start time.
   * @param endTime the end time.
   * @param fromW the from W.
   * @param fromH the from H.
   * @param toW the to W.
   * @param toH the to H.
   * @throws IllegalArgumentException if invalid inputs.
   */
  public Scale(String shapeId, int startTime, int endTime,
                   double fromW, double fromH, double toW, double toH)
                  throws IllegalArgumentException {

    checkConstructorInputs(shapeId, startTime, endTime, fromW, fromH, toW, toH);

    //abstract fields
    this.motionType = MotionType.SCALE;
    this.shapeId = shapeId;
    this.startTime = startTime;
    this.endTime = endTime;

    //scale fields
    this.fromW = fromW;
    this.fromH = fromH;
    this.toW = toW;
    this.toH = toH;

  }

  /** Gets from w.
   * @return from w.
   */
  public double getFromW() {

    return this.fromW;

  }

  /** Gets from h.
   * @return from h.
   */
  public double getFromH() {

    return this.fromH;

  }

  /** Gets to w.
   * @return to w.
   */
  public double getToW() {

    return this.toW;

  }

  /** Gets from h.
   * @return from h.
   */
  public double getToH() {

    return this.toH;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String printString() {

    return "Shape " + this.shapeId + " scales from Width: " + this.fromW + ", Height: " + this.fromH
            + ", to Width: " + this.toW + ", Height: " + this.toH + " from t=" + this.startTime
            + " to t=" + this.endTime;

  }

  //NOT an override because inputs are different for each move

  /** Checks the instructors inputs for validity.
   *
   * @param shapeId the shapeid.
   * @param startTime the starttime.
   * @param endTime the endtime.
   * @param fromW the fromw.
   * @param fromH the fromh.
   * @param toW the tow.
   * @param toH the toh.
   * @throws IllegalArgumentException throw exception if invalid inputs.
   */
  public void checkConstructorInputs(String shapeId, int startTime, int endTime,
                                     double fromW, double fromH, double toW, double toH)
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

    if (fromW < 0) {

      throw new IllegalArgumentException("fromW can't be < 0");

    }

    if (fromH < 0) {

      throw new IllegalArgumentException("fromH can't be < 0");

    }

    if (toW < 0) {

      throw new IllegalArgumentException("toW can't be < 0");

    }

    if (toH < 0) {

      throw new IllegalArgumentException("toH can't be < 0");

    }

    if (endTime == startTime) {

      throw new IllegalArgumentException("Can't have a motion that end&starts at same time");

    }

    if (startTime > endTime) {

      throw new IllegalArgumentException("Motion can't start after its end time");

    }

  }

}
