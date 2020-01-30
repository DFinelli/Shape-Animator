package cs5004.animator.model;

import java.util.SortedMap;


/**
 * This interface represents a cs5004.animator.model and all its operations.
 */
public interface IModel {

  /**
   * Model interface.
   *
   * @param shapeId the shapeId to check for.
   * @return true if there is an existing shape with the shapeId given. False otherwise.
   * @throws IllegalArgumentException if the shapeId is null.
   */
  boolean checkIfShapeExists(String shapeId) throws IllegalArgumentException;

  /**
   * Adds a shape to the cs5004.animator.model's database.
   *
   * @param type       the type of the shape.
   * @param shapeId    the Id of the shape.
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
   *                                  number values are < 0, if rgb > 255, if conflicting
   *                                  appear/disappear times.
   */
  void addShape(ShapeType type, String shapeId, int appears, int disappears,
                double x, double y, double w,
                double h, double r, double g, double b) throws IllegalArgumentException;

  /**
   * Removes a shape from the cs5004.animator.model's database.
   *
   * @param shapeId the id of the shape to remove.
   */
  void removeShape(String shapeId);

  /**
   * Adds a move motion to the database.
   *
   * @param shapeId   the shape id of the shape the motion will occur on.
   * @param startTime the start time of the motion.
   * @param endTime   the end time of the motion.
   * @param toX       the "to" W location of the motion.
   * @param toY       the "to" H location of the motion.
   * @throws IllegalArgumentException if x/y < 0, if conflict with start/end times, if objects are
   *                                  null, etc.
   */
  void addMoveMotion(String shapeId, int startTime, int endTime,
                     double fromX, double fromY,
                     double toX, double toY)
          throws IllegalArgumentException;

  /**
   * Adds a scale motion to the database.
   *
   * @param shapeId   the shape id of the shape the motion will occur on.
   * @param startTime the start time of the motion.
   * @param endTime   the end time of the motion.
   * @param toW       the "to" W location of the motion.
   * @param toH       the "to" H location of the motion.
   * @throws IllegalArgumentException if w/h < 0, if conflict with start/end times, if objects are
   *                                  null, etc.
   */
  void addScaleMotion(String shapeId, int startTime, int endTime,
                      double fromW, double fromH,
                      double toW, double toH)
          throws IllegalArgumentException;

  /**
   * Adds a recolor motion to the database.
   *
   * @param shapeId   the shape id of the shape the motion will occur on.
   * @param startTime the start time of the motion.
   * @param endTime   the end time of the motion.
   * @param toR       the "to" R location of the motion.
   * @param toG       the "to" G location of the motion.
   * @param toB       the "to" B location of the motion.
   * @throws IllegalArgumentException if r/g/b < 0 or > 255, if conflict with start/end times, if
   *                                  objects are null, etc.
   */
  void addRecolorMotion(String shapeId, int startTime, int endTime,
                        double fromR, double fromG, double fromB,
                        double toR, double toG, double toB)
          throws IllegalArgumentException;

  /**
   * Removes a motion from the cs5004.animator.model's database.
   *
   * @param shapeId the id of the motion to remove.
   */
  void removeMotion(String shapeId);

  /**
   * Prints the shapes into a string format.
   *
   * @return a string describing the shapes.
   */
  String printShapes();

  /**
   * Prints the motions into a string format.
   *
   * @return a string describing the motions.
   */
  String printMotions();

  /**
   * Prints the state of shapes+motions into a string format.
   *
   * @return a string describing the shapes+motions.
   */
  String printState();

  /**
   * Checks if there is a motion of the same type in the motion database occurring at a conflicting
   * time.
   *
   * @return true if conflicting motion, false if no conflicts.
   */
  boolean isExistingOverlapMotion(IMotion motion);


  /**
   * Get a list of shapes/motions at a current time frame to make animations.
   *
   * @param frame the time frame to retrieve motions at.
   * @return a list of shapes at the specified time frame, and their motions?
   */
  java.util.List<IShape> getAllShapesAtFrame(int frame);


  SortedMap<IShape, String> getShapes();

  SortedMap<IMotion, String> getMotions();


}
