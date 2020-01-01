package cs5004.animator.model;

/**
 * This class representing an recolor motion which extends the abstract motion.
 */
public class Recolor extends AbstractMotion {

  double fromR;
  double fromG;
  double fromB;
  double toR;
  double toG;
  double toB;

  /**
   * Construct a move motion.
   *
   * @param shapeId   the shape id.
   * @param startTime the start time.
   * @param endTime   the end time.
   * @param fromR     the from r.
   * @param fromG     the from g.
   * @param fromB     the from b.
   * @param toR       the to r.
   * @param toG       the to g.
   * @param toB       the to b.
   * @throws IllegalArgumentException if invalid inputs.
   */
  public Recolor(String shapeId, int startTime, int endTime,
                 double fromR, double fromG, double fromB,
                 double toR, double toG, double toB) throws IllegalArgumentException {

    checkConstructorInputs(shapeId, startTime, endTime, fromR, fromG, fromB,
            toR, toG, toB);

    //abstract fields
    this.motionType = MotionType.RECOLOR;
    this.shapeId = shapeId;
    this.startTime = startTime;
    this.endTime = endTime;

    //recolor fields
    this.fromR = fromR;
    this.fromG = fromG;
    this.fromB = fromB;
    this.toR = toR;
    this.toG = toG;
    this.toB = toB;

  }

  /** Gets from r.
   * @return from r.
   */
  public double getFromR() {

    return this.fromR;

  }

  /** Gets from g.
   * @return from g.
   */
  public double getFromG() {

    return this.fromG;

  }

  /** Gets from b.
   * @return from b.
   */
  public double getFromB() {

    return this.fromB;

  }

  /** Gets to r.
   * @return to r.
   */
  public double getToR() {

    return this.toR;

  }

  /** Gets to g.
   * @return to g.
   */
  public double getToG() {

    return this.toG;

  }

  /** Gets to b.
   * @return to b.
   */
  public double getToB() {

    return this.toB;

  }


  /** Gets the string.
   * @return string the string.
   */
  @Override
  public String printString() {

    return "Shape " + this.shapeId + " changes color from (" + this.fromR + "," + this.fromG
            + "," + this.fromB + ") to (" + this.toR + "," + this.toB + "," + this.toG + ") from t="
            + this.startTime + " to t=" + this.endTime;

  }

  //NOT an override because inputs are different for each move

  /**
   * Checks the instructors inputs for validity.
   *
   * @param shapeId   the shapeid.
   * @param startTime the starttime.
   * @param endTime   the endtime.
   * @param fromR     the fromr.
   * @param fromG     the fromg.
   * @param fromB     the fromb.
   * @param toR       the tor.
   * @param toG       the fromg.
   * @param toB       the fromb.
   * @throws IllegalArgumentException throw exception if invalid inputs.
   */

  public void checkConstructorInputs(String shapeId, int startTime, int endTime,
                                     double fromR, double fromG, double fromB,
                                     double toR, double toG, double toB)
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

    if (fromR < 0 || fromR > 255) {

      throw new IllegalArgumentException("fromR can't be < 0 or > 255");

    }

    if (fromG < 0 || fromG > 255) {

      throw new IllegalArgumentException("fromG can't be < 0 or > 255");

    }

    if (fromB < 0 || fromB > 255) {

      throw new IllegalArgumentException("fromB can't be < 0 or > 255");

    }

    if (toR < 0 || toR > 255) {

      throw new IllegalArgumentException("toR can't be < 0 or > 255");

    }

    if (toG < 0 || toG > 255) {

      throw new IllegalArgumentException("toG can't be < 0 or > 255");

    }

    if (toB < 0 || toB > 255) {

      throw new IllegalArgumentException("toB can't be < 0 or > 255");

    }

    if (endTime == startTime) {

      throw new IllegalArgumentException("Can't have a motion that end&starts at same time");

    }

    if (startTime > endTime) {

      throw new IllegalArgumentException("Motion can't start after its end time");

    }

  }

}

