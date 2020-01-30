package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import cs5004.animator.util.TweenModelBuilder;

//import cs5004.cs5004.animator.cs5004.animator.util.*;


/**
 * This class representing a cs5004.animator.model.
 */
public class Model implements IModel, Cloneable {

  // make private?
  java.util.SortedMap<IShape, String> shapes;
  java.util.SortedMap<IMotion, String> motions;
  List<IShape> latestShapes;

  /**
   * Constructs a cs5004.animator.model.Model. Defines the shape database and motion database.
   */
  public Model() {

    shapes = new java.util.TreeMap<IShape, String>();
    motions = new java.util.TreeMap<IMotion, String>();
    // do i need to populate this with an empty
    latestShapes = new ArrayList<>();

  }

  ///******************************************************************************************//
  // BUILDER
  ///******************************************************************************************//

  /**
   * This class representing a builder.
   */
  public static final class Builder implements TweenModelBuilder<IModel> {

    IModel model = new Model();

    /**
     * Add a new oval to the cs5004.animator.model with the given specifications.
     *
     * @param name        the unique name given to this shape
     * @param cx          the x-coordinate of the center of the oval
     * @param cy          the y-coordinate of the center of the oval
     * @param xRadius     the x-radius of the oval
     * @param yRadius     the y-radius of the oval
     * @param red         the red component of the color of the oval
     * @param green       the green component of the color of the oval
     * @param blue        the blue component of the color of the oval
     * @param startOfLife the time tick at which this oval appears
     * @param endOfLife   the time tick at which this oval disappears
     * @return the builder object
     */
    @Override
    public TweenModelBuilder<IModel> addOval(String name, float cx, float cy, float xRadius,
                                             float yRadius, float red, float green, float blue,
                                             int startOfLife, int endOfLife) {

      model.addShape(ShapeType.OVAL, name, startOfLife, endOfLife, cx, cy, xRadius, yRadius,
              red, green, blue);

      return this;

    }

    /**
     * Add a new rectangle to the cs5004.animator.model with the given specifications.
     *
     * @param name        the unique name given to this shape
     * @param lx          the minimum x-coordinate of a corner of the rectangle
     * @param ly          the minimum y-coordinate of a corner of the rectangle
     * @param width       the width of the rectangle
     * @param height      the height of the rectangle
     * @param red         the red component of the color of the rectangle
     * @param green       the green component of the color of the rectangle
     * @param blue        the blue component of the color of the rectangle
     * @param startOfLife the time tick at which this rectangle appears
     * @param endOfLife   the time tick at which this rectangle disappears
     * @return the builder object
     */
    @Override
    public TweenModelBuilder<IModel> addRectangle(String name, float lx, float ly, float width,
                                                  float height, float red, float green, float blue,
                                                  int startOfLife, int endOfLife) {

      model.addShape(ShapeType.RECTANGLE, name, startOfLife, endOfLife, lx, ly, width, height, red,
              green, blue);

      return this;

    }

    /**
     * cs5004.animator.model.Move the specified shape to the given position during time interval.
     *
     * @param name      the unique name of the shape to be moved
     * @param moveFromX the x-coordinate of the initial position of this shape. What this
     *                  x-coordinate represents depends on the shape.
     * @param moveFromY the y-coordinate of the initial position of this shape. what this
     *                  y-coordinate represents depends on the shape.
     * @param moveToX   the x-coordinate of the final position of this shape. What  xcoordinate.
     *                  represents depends on the shape.
     * @param moveToY   the y-coordinate of the final position of this shape. what ycoordinate.
     *                  represents depends on the shape.
     * @param startTime the time tick at which this movement should start
     * @param endTime   the time tick at which this movement should end
     */
    @Override
    public TweenModelBuilder<IModel> addMove(String name, float moveFromX, float moveFromY,
                                             float moveToX, float moveToY, int startTime,
                                             int endTime) {

      model.addMoveMotion(name, startTime, endTime, moveFromX, moveFromY, moveToX, moveToY);
      return this;

    }

    /**
     * Change the color of the specified shape to the new specified color in the specified time
     * interval.
     *
     * @param name      the unique name of the shape whose color is to be changed
     * @param oldR      the r-component of the old color
     * @param oldG      the g-component of the old color
     * @param oldB      the b-component of the old color
     * @param newR      the r-component of the new color
     * @param newG      the g-component of the new color
     * @param newB      the b-component of the new color
     * @param startTime the time tick at which this color change should start
     * @param endTime   the time tick at which this color change should end
     */
    @Override
    public TweenModelBuilder<IModel> addColorChange(String name, float oldR, float oldG,
                                                    float oldB, float newR, float newG,
                                                    float newB, int startTime, int endTime) {

      model.addRecolorMotion(name, startTime, endTime, oldR, oldG, oldB, newR, newG, newB);
      return this;

    }

    /**
     * Change the x and y extents of this shape from the specified extents to the specified target
     * extents. What these extents actually mean depends on the shape, but these are roughly the
     * extents of the box enclosing the shape
     */
    @Override
    public TweenModelBuilder<IModel> addScaleToChange(String name, float fromSx, float fromSy,
                                                      float toSx, float toSy, int startTime,
                                                      int endTime) {

      model.addScaleMotion(name, startTime, endTime, fromSx, fromSy, toSx, toSy);
      return this;

    }

    /**
     * Return the cs5004.animator.model built so far.
     *
     * @return the cs5004.animator.model that was constructed so far
     */
    @Override
    public IModel build() {

      // proper approach;;;
      // for i in
      /// store build in a list <shapes> <Motions>
      // then in build, we iterate through the list and add to list

      return this.model;

    }

  }

  ///******************************************************************************************//
  // END BUILDER
  ///******************************************************************************************//

  /**
   * Makes a builder.
   *
   * @return a builder.
   */
  public static TweenModelBuilder<IModel> getBuilder() {

    return new Builder();

  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  ///// Shapes /////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean checkIfShapeExists(String shapeId) throws IllegalArgumentException {

    if (shapeId == null) {

      throw new IllegalArgumentException("[checkIfShapeExits fx] shapeId can't be negative ");

    }

    Iterator<Map.Entry<IShape, String>>

            i = shapes.entrySet().iterator();

    while (i.hasNext()) {

      Map.Entry entry = i.next();

      if (shapeId.equals(entry.getValue())) {

        return true;

      }

    }

    return false;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addShape(ShapeType type, String shapeId, int appears, int disappears,
                       double x, double y, double w, double h,
                       double r, double g, double b) throws IllegalArgumentException {

    if (type == null) {

      throw new IllegalArgumentException("can't have null cs5004.animator.model.ShapeType " +
              "as an argument");

    }

    IShape shape;

    switch (type) {

      case RECTANGLE:

        try {

          shape = new Rectangle(shapeId, appears, disappears, x, y, w, h, r, g, b);

        } catch (IllegalArgumentException exception) {

          throw new IllegalArgumentException("cs5004.animator.model.Model providing error" +
                  " message from abstract"
                  + "shape class: " + exception.getMessage());

        }

        break;

      case OVAL:

        try {

          shape = new Oval(shapeId, appears, disappears, x, y, w, h, r, g, b);

        } catch (IllegalArgumentException exception) {

          throw new IllegalArgumentException("cs5004.animator.model.Model providing error " +
                  "message from abstract"
                  + "shape class: " + exception.getMessage());

        }

        break;

      default:

        shape = null;

    }

    if (checkIfShapeExists(shapeId)) {

      throw new IllegalArgumentException("shape ID already exist in the tree");

    }

    if (shape != null) {

      shapes.put(shape, shapeId);

    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeShape(String shapeId) throws IllegalArgumentException {

    if (shapeId == null) {

      throw new IllegalArgumentException("shapeId can't be null ");

    }

    if (!shapes.containsValue(shapeId)) {

      throw new IllegalArgumentException(("shapeId doesn't exist in tree"));

    }

    Iterator<Map.Entry<IShape, String>>

            i = shapes.entrySet().iterator();

    while (i.hasNext()) {

      Map.Entry entry = i.next();

      if (shapeId.equals(entry.getValue())) {

        i.remove();

      }

    }

  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  ///// Motions ///////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * {@inheritDoc}
   */
  @Override
  public void addMoveMotion(String shapeId, int startTime, int endTime, double fromX, double fromY,
                            double toX, double toY)
          throws IllegalArgumentException {

    // check if shape id even exists
    if (!shapes.containsValue(shapeId)) {

      throw new IllegalArgumentException(("shapeId doesn't exist in tree, " +
              "therefore can't add move motion"));

    }

    /////////////////////////////////////////////////////////////////////////////////////
    // iterate through to find shape id referred to, so we can get some info
    // checking for
    //    (2) getting appear/disappear time to check if alive during desired motion time.
    /////////////////////////////////////////////////////////////////////////////////////
    int appears = -1;
    int disappears = -1;

    Iterator<Map.Entry<IShape, String>>

            i = shapes.entrySet().iterator();

    while (i.hasNext()) {

      Map.Entry<IShape, String> entry = i.next();

      if (shapeId.equals(entry.getValue())) {


        appears = entry.getKey().getAppears();
        disappears = entry.getKey().getDisappears();

      }

    }
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    // make sure shape is alive during the motion's time frame
    if (startTime < appears || endTime > disappears) {

      throw new IllegalArgumentException("Shape does not exist during the "
              + "desired motion time frame");

    }

    // throw exception if from x,y is same as to x,y
    if (fromX == toX && fromY == toY) {

      throw new IllegalArgumentException("Cant move to the same spot");

    }

    /////////////////////////////////////////////////////////////////////////////////////

    IMotion motion;

    try {

      motion = new Move(shapeId, startTime, endTime, fromX, fromY, toX, toY);

    } catch (IllegalArgumentException e) {

      throw new IllegalArgumentException("cs5004.animator.model caught argument from motion. " +
              "displaying motion"
              + "class message" + e.getMessage());
    }

    /////////////////////////////////////////////////////////////////////////////////////


    if (isExistingOverlapMotion(motion)) {

      throw new IllegalArgumentException("overlapping time conflict of an existing same motion"
              + "with the same shape");

    }

    /////////////////////////////////////////////////////////////////////////////////////

    motions.put(motion, shapeId);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addScaleMotion(String shapeId, int startTime, int endTime,
                             double fromW, double fromH,
                             double toW, double toH)
          throws IllegalArgumentException {

    // check if shape id even exists
    if (!shapes.containsValue(shapeId)) {

      throw new IllegalArgumentException(("shapeId doesn't exist in tree, "
              + "therefore can't add scale motion"));

    }


    /////////////////////////////////////////////////////////////////////////////////////
    // iterate through to find shape id referred to, so we can get some info
    // checking for
    //    (1) getting from/to to check if its the same
    //    (2) getting appear/disappear time to check if alive during desired motion time.
    /////////////////////////////////////////////////////////////////////////////////////
    int appears = -1;
    int disappears = -1;

    Iterator<Map.Entry<IShape, String>>

            i = shapes.entrySet().iterator();

    while (i.hasNext()) {

      Map.Entry<IShape, String> entry = i.next();

      if (shapeId.equals(entry.getValue())) {

        appears = entry.getKey().getAppears();
        disappears = entry.getKey().getDisappears();

      }

    }

    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    // make sure shape is alive during the motion's time frame
    if (startTime < appears || endTime > disappears) {

      throw new IllegalArgumentException("Shape does not exist during the "
              + "desired motion time frame");

    }

    // throw exception if from w,h == to w,h
    if (fromW == toW && fromH == toH) {

      throw new IllegalArgumentException("Cant scale to the same current size");

    }
    /////////////////////////////////////////////////////////////////////////////////////

    IMotion motion;

    try {

      motion = new Scale(shapeId, startTime, endTime, fromW, fromH, toW, toH);

    } catch (IllegalArgumentException e) {

      throw new IllegalArgumentException("cs5004.animator.model caught argument from motion." +
              " displaying motion"
              + "class message" + e.getMessage());
    }

    /////////////////////////////////////////////////////////////////////////////////////

    if (isExistingOverlapMotion(motion)) {

      throw new IllegalArgumentException("overlapping time conflict of an existing same motion"
              + "with the same shape");

    }

    /////////////////////////////////////////////////////////////////////////////////////

    motions.put(motion, shapeId);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addRecolorMotion(String shapeId, int startTime, int endTime,
                               double fromR, double fromG, double fromB,
                               double toR, double toG, double toB)
          throws IllegalArgumentException {

    // check if shape id even exists
    if (!shapes.containsValue(shapeId)) {

      throw new IllegalArgumentException(("shapeId doesn't exist in tree, "
              + "therefore can't add recolor motion"));

    }

    /////////////////////////////////////////////////////////////////////////////////////
    // iterate through to find shape id referred to, so we can get some info
    // checking for
    //    (1) getting from/to to check if its the same
    //    (2) getting appear/disappear time to check if alive during desired motion time.
    /////////////////////////////////////////////////////////////////////////////////////
    int appears = -1;
    int disappears = -1;

    Iterator<Map.Entry<IShape, String>>

            i = shapes.entrySet().iterator();

    while (i.hasNext()) {

      Map.Entry<IShape, String> entry = i.next();

      if (shapeId.equals(entry.getValue())) {

        appears = entry.getKey().getAppears();
        disappears = entry.getKey().getDisappears();

      }

    }

    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    // make sure shape is alive during the motion's time frame
    if (startTime < appears || endTime > disappears) {

      throw new IllegalArgumentException("Shape does not exist during the "
              + "desired motion time frame");

    }


    /////////////////////////////////////////////////////////////////////////////////////

    IMotion motion;

    try {

      motion = new Recolor(shapeId, startTime, endTime, fromR, fromB, fromG, toR, toB, toG);

    } catch (IllegalArgumentException e) {

      throw new IllegalArgumentException("cs5004.animator.model caught argument from motion." +
              " displaying motion"
              + "class message" + e.getMessage());
    }

    /////////////////////////////////////////////////////////////////////////////////////


    if (isExistingOverlapMotion(motion)) {

      throw new IllegalArgumentException("overlapping time conflict of an existing same motion"
              + "with the same shape");

    }

    /////////////////////////////////////////////////////////////////////////////////////

    motions.put(motion, shapeId);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isExistingOverlapMotion(IMotion newMotion) {

    // iterate through the all existing motions to compare
    // the newly made motion against existing motions.
    for (Map.Entry<IMotion, String> entry : motions.entrySet()) {

      // the current iteration's existing motion
      // current key:value  (shapeId:motion)
      String existingMotionShapeId = entry.getValue();
      IMotion existingMotion = entry.getKey();

      // if the a ShapeId has an existing motion && same type of motion
      // then we need to check if they occur at in the same time frame.
      if (newMotion.getShapeId().equals(existingMotionShapeId)
              && newMotion.getMotionType().equals(existingMotion.getMotionType())) {

        // if the new motion's beginning time is within the start/end of an existing
        // then this means there would be a conflict
        if (newMotion.getStartTime() >= existingMotion.getStartTime()
                && newMotion.getStartTime() <= existingMotion.getEndTime()) {

          //conflict
          return true;

        }

        // if the new motion's end time is within the start/end of an existing
        // then this means there would be a conflict
        if (newMotion.getEndTime() <= existingMotion.getEndTime()
                && newMotion.getEndTime() >= existingMotion.getStartTime()) {

          //conflict
          return true;

        }

        // if same start and end times, conflict
        if (newMotion.getEndTime() == existingMotion.getEndTime()
                && newMotion.getStartTime() == existingMotion.getStartTime()) {

          //conflict
          return true;
        }

      }

    }

    // if no conflicts found through loop, return false for no conflicts
    return false;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeMotion(String id) {

    motions.remove(id);

  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  ///// Print /////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * {@inheritDoc}
   */
  @Override
  public String printShapes() {

    String output = "Shapes:\n";

    for (IShape key : shapes.keySet()) {

      output += key.printString() + "\n\n";

    }

    return output;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String printMotions() {

    String output = "";

    for (IMotion key : motions.keySet()) {

      output += key.printString() + "\n";

    }

    return output;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String printState() {

    String shapesPrinted = printShapes();
    String motionsPrinted = printMotions();

    return shapesPrinted + motionsPrinted;

  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  ///// idk ///// /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////


  @Override
  public SortedMap<IShape, String> getShapes() {


    return this.shapes;

  }

  @Override
  public SortedMap<IMotion, String> getMotions() {

    return this.motions;

  }


  /**
   * Get a list of shapes/motions at a current time frame to make animations.
   *
   * @param frame the time frame to retrieve motions at.
   * @return a list of shapes at the specified time frame, and their motions?
   */
  @Override
  public List<IShape> getAllShapesAtFrame(int frame) {

    List<IShape> returnShapesList = new ArrayList<>();

    // 1. determine what shapes appear at t = frame.
    // 2. which motions at that time
    // 3. apply the motions (tween)

    Iterator<Map.Entry<IShape, String>>

            // need to iterate through the array LATEST SHAPES.
            i = shapes.entrySet().iterator();


    while (i.hasNext()) {

      Map.Entry<IShape, String> entryShape = i.next();


      // if the shape exists within the time frame
      if (entryShape.getKey().getAppears() <= frame
              && entryShape.getKey().getDisappears() >= frame) {

        IShape holderShape = null;

        //System.out.print("outer loop Shape: " + entryShape.getKey().getShapeId() + "\n");
        if (entryShape.getKey() instanceof Rectangle) {

          holderShape = new Rectangle(entryShape.getKey().getShapeId(),
                  entryShape.getKey().getAppears(), entryShape.getKey().getDisappears(),
                  entryShape.getKey().getX(), entryShape.getKey().getY(),
                  entryShape.getKey().getW(), entryShape.getKey().getH(),
                  entryShape.getKey().getR(), entryShape.getKey().getG(),
                  entryShape.getKey().getB());

        }

        if (entryShape.getKey() instanceof Oval) {

          holderShape = new Oval(entryShape.getKey().getShapeId(),
                  entryShape.getKey().getAppears(), entryShape.getKey().getDisappears(),
                  entryShape.getKey().getX(), entryShape.getKey().getY(),
                  entryShape.getKey().getW(), entryShape.getKey().getH(),
                  entryShape.getKey().getR(), entryShape.getKey().getG(),
                  entryShape.getKey().getB());

        }

        Iterator<Map.Entry<IMotion, String>>

                j = motions.entrySet().iterator();

        while (j.hasNext()) {

          Map.Entry<IMotion, String> entryMotion = j.next();

          // if the motion belongs to the current shape
          if (entryMotion.getValue().equals(entryShape.getValue())) {

            // if the shape's motion is within frame
            if (entryMotion.getKey().getStartTime() <= frame
                    && entryMotion.getKey().getEndTime() >= frame) {

              // IF MOVE MOTION

              if (entryMotion.getKey() instanceof Move) {

                double tweenX = entryShape.getKey().getX();
                double tweenY = entryShape.getKey().getY();


                // CHECK IF I NEED TO EVEN TWEEN IT???

                // tween x values
                tweenX = entryMotion.getKey().tween(((Move) entryMotion.getKey()).getFromX(),
                        ((Move) entryMotion.getKey()).getToX(),
                        entryMotion.getKey().getStartTime(),
                        entryMotion.getKey().getEndTime(), frame);

                tweenY = entryMotion.getKey().tween(((Move) entryMotion.getKey()).getFromY(),
                        ((Move) entryMotion.getKey()).getToY(),
                        entryMotion.getKey().getStartTime(),
                        entryMotion.getKey().getEndTime(), frame);


                holderShape.setX(((int) tweenX));
                holderShape.setY(((int) tweenY));

                if (entryMotion.getKey().getEndTime() == frame) {

                  entryShape.getKey().setX(((int) tweenX));
                  entryShape.getKey().setY(((int) tweenY));

                }

              }


              if (entryMotion.getKey() instanceof Scale) {

                double tweenW = entryShape.getKey().getW();
                double tweenH = entryShape.getKey().getH();

                // tween x values
                tweenW = entryMotion.getKey().tween(((Scale) entryMotion.getKey()).getFromW(),
                        ((Scale) entryMotion.getKey()).getToW(),
                        entryMotion.getKey().getStartTime(),
                        entryMotion.getKey().getEndTime(), frame);

                tweenH = entryMotion.getKey().tween(((Scale) entryMotion.getKey()).getFromH(),
                        ((Scale) entryMotion.getKey()).getToH(),
                        entryMotion.getKey().getStartTime(),
                        entryMotion.getKey().getEndTime(), frame);

                holderShape.setW(((int) tweenW));
                holderShape.setH(((int) tweenH));

                if (entryMotion.getKey().getEndTime() == frame) {

                  entryShape.getKey().setW(((int) tweenW));
                  entryShape.getKey().setH(((int) tweenH));

                }

              }


              if (entryMotion.getKey() instanceof Recolor) {

                double tweenR = entryShape.getKey().getR();
                double tweenG = entryShape.getKey().getG();
                double tweenB = entryShape.getKey().getB();

                // tween x values
                tweenR = entryMotion.getKey().tween(((Recolor) entryMotion.getKey()).getFromR(),
                        ((Recolor) entryMotion.getKey()).getToR(),
                        entryMotion.getKey().getStartTime(),
                        entryMotion.getKey().getEndTime(), frame);

                tweenG = entryMotion.getKey().tween(((Recolor) entryMotion.getKey()).getFromG(),
                        ((Recolor) entryMotion.getKey()).getToG(),
                        entryMotion.getKey().getStartTime(),
                        entryMotion.getKey().getEndTime(), frame);

                tweenB = entryMotion.getKey().tween(((Recolor) entryMotion.getKey()).getFromB(),
                        ((Recolor) entryMotion.getKey()).getToB(),
                        entryMotion.getKey().getStartTime(),
                        entryMotion.getKey().getEndTime(), frame);




                holderShape.setR(tweenR);
                holderShape.setG(tweenG);
                holderShape.setB(tweenB);

                if (entryMotion.getKey().getEndTime() == frame) {

                  entryShape.getKey().setR(tweenR);
                  entryShape.getKey().setG(tweenG);
                  entryShape.getKey().setB(tweenB);

                }

              }


            }

          }

        }


        // if the shape at the current frame add it.
        // do this at the end because tween might have switched its values
        returnShapesList.add(holderShape);

      }
    }

    // this clears the list before
    latestShapes.clear();
    // the add all the modified shapes
    latestShapes.addAll(returnShapesList);

    return returnShapesList;

  }


}