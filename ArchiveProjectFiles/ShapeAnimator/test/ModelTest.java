import org.junit.Test;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.Model;
import cs5004.animator.model.Move;
import cs5004.animator.model.ShapeType;

import static junit.framework.TestCase.assertEquals;

import static junit.framework.TestCase.assertFalse;

import static junit.framework.TestCase.assertTrue;

/**
 * This class representing a JUnit test for the cs5004.animator.model class.
 * Also tests all associated classes through the cs5004.animator.model.
 */
public class ModelTest {

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// CONSTRUCTOR
  ///////////////////////////////////////////////////////////////////////////////////////////
  @Test
  public void testConstructor() {

    IModel testModel = new Model();

    assertEquals("Shapes:\n", testModel.printState());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD SHAPE (valid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // add one shape
  @Test
  public void testAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    assertEquals("Shapes:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

  }

  // add two shapes, checks to make sure reorders properly
  @Test
  public void testAddShape2() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

  }

  // add three shapes, checks to make sure reorders properly,
  // testing adding both oval / rectangle
  @Test
  public void testAddShape3() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD SHAPE (invalid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  //////// cs5004.animator.model exceptions thrown ////////

  // testing adding a shape with null cs5004.animator.model.ShapeType
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNullShapeTypeAddShape() {

    IModel testModel = new Model();

    testModel.addShape(null, "R1", 0, 100, 4, 4, 5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing adding a shape with an existing ID
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidExistingIDAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 5, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  //////// shape exceptions thrown ////////

  // testing null shapeId
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidShapeIdAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, null, 2, 100, 4, 4, 5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing <0 appear time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAppearAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", -2, 100, 4, 4, 5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing <0 disappear time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDisappearAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, -10, 4, 4, 5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing <0 x coordinate
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidXAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 10, -50, 4, 5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing <0 y coordinate
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidYAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 10, 5, -4, 5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing <0 width
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWidthAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, -5, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing =0 width
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWidth2AddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 0, 4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing <0 height
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHeightAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 5, -4, 55, 55, 55);
    // test passes if exception caught

  }

  // testing =0 height
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWHeight2AddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 0, 55, 55, 55);
    // test passes if exception caught

  }

  // testing <0 r
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, -55, 55, 55);
    // test passes if exception caught

  }

  // testing  r > 255
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidR2AddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 300, 55, 55);
    // test passes if exception caught

  }

  // testing <0 g
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, -55, 55);
    // test passes if exception caught

  }

  // testing  g > 255
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidG2AddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 300, 55);
    // test passes if exception caught

  }

  // testing <0 b
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBAddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, -55);
    // test passes if exception caught

  }

  // testing  b > 255
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidB2AddShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 300);
    // test passes if exception caught

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// checkIfShapeExists (valid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // checking both true and false scenarios
  @Test
  public void testCheckIfShapeExists() {

    IModel testModel = new Model();
    assertFalse(testModel.checkIfShapeExists("R1"));
    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    assertTrue(testModel.checkIfShapeExists("R1"));

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// checkIfShapeExists (invalid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // invalid if shapeId is null
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNullCheckIfShapeExists() {

    IModel testModel = new Model();
    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    assertTrue(testModel.checkIfShapeExists(null));

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// REMOVE SHAPE (valid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // add remove shape. And making sure order tree is sorted afterwards.
  @Test
  public void testRemoveShape() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O2", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 1, 100, 4, 4, 4, 4, 55, 55, 55);

    assertEquals("Shapes:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

    testModel.removeShape("R2");

    assertEquals("Shapes:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// REMOVE SHAPE (invalid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // test removing a shape that doesn't exist && when there is an empty tree
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemoveShape() {

    IModel testModel = new Model();

    testModel.removeShape("R2");

  }

  // test removing a shape that doesn't exist && non empty tree
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemove2Shape() {

    IModel testModel = new Model();
    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);

    testModel.removeShape("R2");

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD MOVE MOTION (valid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // adding 1 motion
  @Test
  public void testAddMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

    testModel.addMoveMotion("R1", 2, 10, 4, 4, 10, 10);

    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R1 moves from (4.0,4.0) to (10.0,10.0) from t=2 to t=10\n",
            testModel.printState());

  }

  // testing multiple add moves
  // testing ordering is kept true
  @Test
  public void testOrderingAddMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 3, 10, 4, 4, 10, 10);
    testModel.addMoveMotion("O1", 1, 20, 4, 4, 25, 25);
    testModel.addMoveMotion("R2", 2, 20, 4, 4, 33, 33);


    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape O1 moves from (4.0,4.0) to (25.0,25.0) from t=1 to t=20\n" +
            "Shape R2 moves from (4.0,4.0) to (33.0,33.0) from t=2 to t=20\n" +
            "Shape R1 moves from (4.0,4.0) to (10.0,10.0) from t=3 to t=10\n",
            testModel.printState());

  }

  // adding a motion with a shape that has that motion already
  // (although no overlapping time conflicts)
  @Test
  public void testSameShapeAddMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 0, 10, 4, 4, 10, 10);
    testModel.addMoveMotion("R1", 11, 20, 4, 4, 25, 25);


    assertEquals("Shapes:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R1 moves from (4.0,4.0) to (10.0,10.0) from t=0 to t=10\n" +
            "Shape R1 moves from (4.0,4.0) to (25.0,25.0) from t=11 to t=20\n",
            testModel.printState());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD MOVE MOTION (invalid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // invalid adding a move to a nonexistent shape
  @Test(expected = IllegalArgumentException.class)
  public void testNonExistentShapeInvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addMoveMotion("O5", 0, 10, 1, 1,4, 4);
    //test passes if exception is caught

  }

  // invalid--- shape exists, but not during the duration of motion
  // new motion start < existing motion start
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotExistInvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 10, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 3, 7, 1, 1, 10, 10);
    //test passes if exception is caught

  }

  // invalid--- shape exists, but not during the duration of motion
  // new motion end > existing motion end
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotExist2InvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 10, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 7, 12, 1, 1, 10, 10);
    //test passes if exception is caught

  }

  // invalid moving to same spot. (from xy == to xy)
  @Test(expected = IllegalArgumentException.class)
  public void testSameToFromInvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 0, 10, 4, 4,4, 4);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // in middle
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapMiddleInvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 0, 10, 4, 4,10, 10);
    testModel.addMoveMotion("R1", 2, 7, 4, 4,77, 77);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // starts before, but end is within duration of other motion.
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapStartInvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 5, 10, 4, 4, 10, 10);
    testModel.addMoveMotion("R1", 2, 7, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // starts within duration of other motion but ends after.
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapEndInvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 5, 10, 4, 4, 10, 10);
    testModel.addMoveMotion("R1", 7, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // inputs invalid

  // test if shapeId is null
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMoveMotion() {

    IModel testModel = new Model();

    testModel.addMoveMotion(null, 7, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // test if start time < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMove2Motion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", -5, 11, 4, 4,77, 77);
    //test passes if exception is caught

  }

  // test if end time < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMove3Motion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 5, -11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // test if to x < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMove4Motion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 5, 11, 4, 4, -77, 77);
    //test passes if exception is caught

  }

  // test if to y < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMove5Motion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 5, 11, 4, 4, 77, -77);
    //test passes if exception is caught

  }

  // test if to start time == end time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMove6Motion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 11, 11, 4, 4,77, 77);
    //test passes if exception is caught

  }

  // test if to start time > end time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMove7Motion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 15, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD cs5004.animator.model.Scale MOTION (valid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // adding 1 motion
  @Test
  public void testScaleMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

    testModel.addScaleMotion("R1", 2, 10, 4, 4,10, 10);

    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R1 scales from " +
            "Width: 4.0, Height: 4.0, to Width: 10.0, Height: 10.0 from t=2 to t=10\n",
            testModel.printState());

  }

  // testing multiple add moves
  // testing ordering is kept true
  @Test
  public void testOrderingAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 3, 10, 4, 4,10, 10);
    testModel.addScaleMotion("O1", 1, 20, 4, 4, 25, 25);
    testModel.addScaleMotion("R2", 2, 20, 4, 4, 33, 33);


    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape O1 scales from Width: 4.0, Height: 4.0, to Width: 25.0, " +
            "Height: 25.0 from t=1 to t=20\n" +
            "Shape R2 scales from Width: 4.0, Height: 4.0, to Width: 33.0, " +
            "Height: 33.0 from t=2 to t=20\n" +
            "Shape R1 scales from Width: 4.0, Height: 4.0, to Width: 10.0, " +
            "Height: 10.0 from t=3 to t=10\n", testModel.printState());

  }

  // adding a motion with a shape that has that motion already
  // (although no overlapping time conflicts)
  @Test
  public void testSameShapeAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 0, 10, 4, 4, 10, 10);
    testModel.addScaleMotion("R1", 11, 20, 4, 4,25, 25);


    assertEquals("Shapes:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R1 scales from Width: 4.0, Height: 4.0, to Width: 10.0, " +
            "Height: 10.0 from t=0 to t=10\n" +
            "Shape R1 scales from Width: 4.0, Height: 4.0, to Width: 25.0, " +
            "Height: 25.0 from t=11 to t=20\n", testModel.printState());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD cs5004.animator.model.Scale MOTION (invalid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // invalid adding a move to a nonexistent shape
  @Test(expected = IllegalArgumentException.class)
  public void testNonExistentShapeInvalidAddcale() {

    IModel testModel = new Model();

    testModel.addScaleMotion("O5", 0, 10, 4, 4, 4, 4);
    //test passes if exception is caught

  }

  // invalid--- shape exists, but not during the duration of motion
  // new motion start < existing motion start
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotExistInvalidAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 10, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 3, 7, 4, 4, 10, 10);
    //test passes if exception is caught

  }

  // invalid--- shape exists, but not during the duration of motion
  // new motion end > existing motion end
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotExist2InvalidAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 10, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 7, 12, 4, 4, 10, 10);
    //test passes if exception is caught

  }

  // invalid moving to same spot. (from xy == to xy)
  @Test(expected = IllegalArgumentException.class)
  public void testSameToFromInvalidAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 0, 10, 4, 4, 4, 4);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // in middle
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapMiddleInvalidAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 0, 10, 4, 4, 10, 10);
    testModel.addScaleMotion("R1", 2, 7, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // starts before, but end is within duration of other motion.
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapStartInvalidAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 5, 10, 4, 4, 10, 10);
    testModel.addScaleMotion("R1", 2, 7, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // starts within duration of other motion but ends after.
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapEndInvalidAddScale() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 5, 10, 4, 4,10, 10);
    testModel.addScaleMotion("R1", 7, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // inputs invalid

  // test if shapeId is null
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddMoveScale() {

    IModel testModel = new Model();

    testModel.addScaleMotion(null, 7, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // test if start time < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddScale2() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", -5, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // test if end time < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddScale3() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 5, -11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // test if to x < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddScale4() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 5, 11, 4, 4,-77, 77);
    //test passes if exception is caught

  }

  // test if to y < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddScale5() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 5, 11, 4, 4, 77, -77);
    //test passes if exception is caught

  }

  // test if to start time == end time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddScale6() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 11, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  // test if to start time > end time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddScale7() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addScaleMotion("R1", 15, 11, 4, 4, 77, 77);
    //test passes if exception is caught

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD RECOLOR MOTION (valid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // adding 1 motion
  @Test
  public void testRecolorMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n\n", testModel.printState());

    testModel.addRecolorMotion("R1", 2, 10, 55, 55, 55, 33, 44, 55);

    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R1 changes color from (55.0,55.0,55.0) to (33.0,44.0,55.0) from t=2 to t=10\n",
            testModel.printState());

  }

  // testing multiple add moves
  // testing ordering is kept true
  @Test
  public void testOrderingAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 3, 10, 55, 55, 55, 99, 99, 99);
    testModel.addRecolorMotion("O1", 1, 20, 55, 55, 55, 99, 99, 99);
    testModel.addRecolorMotion("R2", 2, 20, 55, 55, 55, 99,99, 99);


    assertEquals("Shapes:\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=2\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape O1 changes color from (55.0,55.0,55.0) to (99.0,99.0,99.0) from t=1 to t=20\n" +
            "Shape R2 changes color from (55.0,55.0,55.0) to (99.0,99.0,99.0) from t=2 to t=20\n" +
            "Shape R1 changes color from (55.0,55.0,55.0) to (99.0,99.0,99.0) from t=3 to t=10\n",
            testModel.printState());

  }

  // adding a motion with a shape that has that motion already
  // (although no overlapping time conflicts)
  @Test
  public void testSameShapeAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "R2", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.RECTANGLE, "O1", 1, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 0, 10, 55, 55, 55, 99, 99, 99);
    testModel.addRecolorMotion("R1", 11, 20, 55, 55, 55, 99, 99,99);


    assertEquals("Shapes:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: O1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape R1 changes color from (55.0,55.0,55.0) to (99.0,99.0,99.0) from t=0 to t=10\n" +
            "Shape R1 changes color from (55.0,55.0,55.0) to (99.0,99.0,99.0) from t=11 to t=20\n",
            testModel.printState());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// ADD RECOLOR MOTION (invalid)
  ///////////////////////////////////////////////////////////////////////////////////////////

  // invalid adding a move to a nonexistent shape
  @Test(expected = IllegalArgumentException.class)
  public void testNonExistentShapeInvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addRecolorMotion("O5", 0, 10, 55, 55, 55, 4, 4, 4);
    //test passes if exception is caught

  }

  // invalid--- shape exists, but not during the duration of motion
  // new motion start < existing motion start
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotExistInvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 10, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 3, 7, 55, 55, 55, 10, 10, 10);
    //test passes if exception is caught

  }

  // invalid--- shape exists, but not during the duration of motion
  // new motion end > existing motion end
  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotExist2InvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 10, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 7, 12, 55, 55, 55, 10, 10, 10);
    //test passes if exception is caught

  }

  // invalid moving to same spot. (from rgb == to rgb)
  @Test(expected = IllegalArgumentException.class)
  public void testSameToFromInvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 2, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 0, 10, 55, 55, 55, 4, 4, 4);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // in middle
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapMiddleInvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 0, 10, 55, 55, 55, 10, 10, 10);
    testModel.addRecolorMotion("R1", 2, 7, 55, 55, 55, 77, 77, 77);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // starts before, but end is within duration of other motion.
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapStartInvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 10, 55, 55, 55, 10, 10, 10);
    testModel.addRecolorMotion("R1", 2, 7, 55, 55, 55, 77, 77, 77);
    //test passes if exception is caught

  }

  // invalid adding new motion that occurs during same time frame as an existing same motion type
  // starts within duration of other motion but ends after.
  @Test(expected = IllegalArgumentException.class)
  public void testOverlapEndInvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 10, 55, 55, 55, 10, 10, 10);
    testModel.addRecolorMotion("R1", 7, 11, 55, 55, 55, 77, 77, 77);
    //test passes if exception is caught

  }

  // inputs invalid

  // test if shapeId is null
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor() {

    IModel testModel = new Model();

    testModel.addRecolorMotion(null, 7, 11, 55, 55, 55, 77, 77, 77);
    //test passes if exception is caught

  }

  // test if start time < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor2() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", -5, 11, 55, 55, 55, 77, 77, 77);
    //test passes if exception is caught

  }

  // test if end time < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor3() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, -11, 55, 55, 55, 77, 77, 77);
    //test passes if exception is caught

  }

  // test if to r < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor4() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 11, 55, 55, 55, -77, 77, 77);
    //test passes if exception is caught

  }

  // test if to r > 255
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor4b() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 11, 55, 55, 55, 300, 77, 77);
    //test passes if exception is caught

  }

  // test if to g < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor5() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 11, 55, 55, 55, 77, -77, 77);
    //test passes if exception is caught

  }

  // test if to g > 255
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor5b() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 11, 55, 55, 55, 77, 300, 77);
    //test passes if exception is caught

  }

  // test if to b < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor5half() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 11, 55, 55, 55, 77, 77, -77);
    //test passes if exception is caught

  }

  // test if to b > 255
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor5halfb() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 5, 11, 55, 55, 55,77, 77, 300);
    //test passes if exception is caught

  }

  // test if to start time == end time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor6() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 11, 11, 55, 55, 55, 77, 77, 77);
    //test passes if exception is caught

  }

  // test if to start time > end time
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddRecolor7() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addRecolorMotion("R1", 15, 11, 55, 55, 55,77, 77, 77);
    //test passes if exception is caught

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// is ExistingOverlapMotion
  ///////////////////////////////////////////////////////////////////////////////////////////

  // returns true if there is a conflict overlapping motion existing
  @Test
  public void testExistingOverlapMotion() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 5, 10, 4, 4, 77, 77);
    IMotion testMotion = new Move("R1", 5, 10, 4, 4, 77, 77);
    assertTrue(testModel.isExistingOverlapMotion(testMotion));

    IMotion testMotion2 = new Move("R1", 3, 7, 4, 4, 77, 77);
    assertTrue(testModel.isExistingOverlapMotion(testMotion2));

    IMotion testMotion3 = new Move("R1", 5, 12, 4, 4, 77, 77);
    assertTrue(testModel.isExistingOverlapMotion(testMotion3));

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// printShapes
  ///////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void testPrintShapes() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.OVAL, "O1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    assertEquals("Shapes:\n" +
            "Name: O1\n" +
            "Type: oval\n" +
            "Center: (4.0,4.0), X radius: 4.0, Y radius: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=5\n" +
            "Disappears at t=100\n" +
            "\n", testModel.printShapes());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// printMotions
  ///////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void testPrintMotions() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.OVAL, "O1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 8, 18, 4, 4,5, 5);
    testModel.addMoveMotion("O1", 7, 18, 4, 4, 5, 5);


    assertEquals("Shape O1 moves from (4.0,4.0) to (5.0,5.0) from t=7 to t=18\n" +
            "Shape R1 moves from (4.0,4.0) to (5.0,5.0) from t=8 to t=18\n",
            testModel.printMotions());

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  /////// printState
  ///////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void testPrintState() {

    IModel testModel = new Model();

    testModel.addShape(ShapeType.RECTANGLE, "R1", 5, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addShape(ShapeType.OVAL, "O1", 0, 100, 4, 4, 4, 4, 55, 55, 55);
    testModel.addMoveMotion("R1", 8, 18, 4, 4, 5, 5);
    testModel.addMoveMotion("O1", 7, 18, 4, 4, 5, 5);

    assertEquals("Shapes:\n" +
            "Name: O1\n" +
            "Type: oval\n" +
            "Center: (4.0,4.0), X radius: 4.0, Y radius: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (4.0,4.0), Width: 4.0, Height: 4.0, Color: (55.0,55.0,55.0)\n" +
            "Appears at t=5\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape O1 moves from (4.0,4.0) to (5.0,5.0) from t=7 to t=18\n" +
            "Shape R1 moves from (4.0,4.0) to (5.0,5.0) from t=8 to t=18\n",
            testModel.printState());

  }





}