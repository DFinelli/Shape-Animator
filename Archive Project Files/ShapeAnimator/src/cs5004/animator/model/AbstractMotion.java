package cs5004.animator.model;

/**
 * This class representing an abstract motion.
 */
public abstract class AbstractMotion implements IMotion, Comparable<IMotion> {

  protected MotionType motionType;
  protected String shapeId;
  protected int startTime;
  protected int endTime;

  /**
   * {@inheritDoc}
   */
  public MotionType getMotionType() {

    return this.motionType;

  }

  /**
   * {@inheritDoc}
   */
  public String getShapeId() {

    return this.shapeId;

  }

  /**
   * {@inheritDoc}
   */
  public int getStartTime() {

    return this.startTime;

  }

  /**
   * {@inheritDoc}
   */
  public int getEndTime() {

    return this.endTime;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(IMotion b) {

    if (this.getStartTime() < b.getStartTime()) {

      return -1;

    }

    if (this.getStartTime() > b.getStartTime()) {

      return 1;

    }

    if (this.getStartTime() == b.getStartTime()) {

      return 1;

    }

    return 1;

  }


  /**
   * {@inheritDoc}
   */
  @Override
  public double tween(double a, double b, int ta, int tb, int tick) {

    double aNum = (tb - tick);
    double aDen = (tb - ta);

    double divide1 = aNum / aDen;

    double multiplyA = a * divide1;


    double bNum = (tick - ta);
    double bDen = (tb - ta);

    double divide2 = bNum / bDen;

    double multiplyB = b * divide2;


    double sum = multiplyA + multiplyB;


    return sum;


  }


  /**
   * Sets the start time.
   *
   * @param newTime the new start time.
   */
  public void setStartTime(int newTime) {

    this.startTime = newTime;


  }



}
