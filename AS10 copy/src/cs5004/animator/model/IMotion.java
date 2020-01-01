package cs5004.animator.model;

/**
 * This interface represents a motion and all its operations.
 */
public interface IMotion {

  /**
   * Gets the motion type.
   *
   * @return motion type of the motion.
   */
  MotionType getMotionType();

  /**
   * Gets the shape id associated with the motion.
   *
   * @return the shape id associated with the motion.
   */
  String getShapeId();

  /**
   * Gets the start time of the motion.
   *
   * @return the start time of the motion.
   */
  int getStartTime();

  /**
   * Gets the end time of the motion.
   *
   * @return the end time of the motion.
   */
  int getEndTime();

  /**
   * Prints the string visual of the motion.
   *
   * @return the string visual of the motion.
   */
  String printString();

  /**
   * Calculates the in between value of a motion according to the current tick. For example,
   * an x value that changes from the Move function.
   *
   * @param a the begin value.
   * @param b the end value.
   * @param ta the beginning time of motion.
   * @param tb the end time of motion.
   * @param tick the current frame/tick.
   *
   * @return the in between value
   *
   */
  double tween(double a, double b, int ta, int tb, int tick);


}
