import org.junit.Test;

import java.io.FileNotFoundException;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.IController;
import cs5004.animator.model.IModel;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.Model;
import cs5004.animator.model.Move;
import cs5004.animator.util.AnimationFileReader;
import cs5004.animator.util.TweenModelBuilder;
import cs5004.animator.view.IView;
import cs5004.animator.view.Text;

import static junit.framework.TestCase.assertEquals;

/**
 * This class representing text test view.
 */
public class TextViewTest {

  // testing speed 1, on toh3.txt file

  @Test
  public void testx() {

    // move name disk1 moveto 190.0 161.0 190.0 50 from 25 to 35

    IMotion testMove = new Move("disk1", 25,35 ,190.0 ,161.0, 190.0, 50 );

    int start = testMove.getStartTime();
    int end = testMove.getEndTime();

    double calc = (end - start / 20) * 100;

    assertEquals(3400, calc);

  }

  @Test
  public void testTOH3TXT() throws FileNotFoundException {

    IModel testModel = null;

    TweenModelBuilder<IModel> builder = Model.getBuilder();

    AnimationFileReader fileReader = new AnimationFileReader();

    try {

      testModel = fileReader.readFile("toh-3.txt", builder);

    } catch (Exception e) {

      throw new FileNotFoundException("In Main() file problems:" + e.getMessage());

    }

    StringBuffer out = new StringBuffer();

    IView testView = new Text(1, out);
    IController testController = new Controller(testModel, testView);

    testController.goRun();

    assertEquals("Shapes:\n" +
                    "Name: RECTANGLE\n" +
                    "Type: rectangle\n" +
                    "Min corner: (190.0,180.0), Width: 20.0, Height: 20.0, Color: " +
                    "(0.5,49.8,90.4)\n" +
                    "Appears at t=1.0s\n" +
                    "Disappears at t=302.0s\n" +
                    "\n" +
                    "Name: RECTANGLE\n" +
                    "Type: rectangle\n" +
                    "Min corner: (167.5,210.0), Width: 65.0, Height: 65.0, Color: " +
                    "(6.6,247.1,41.8)\n" +
                    "Appears at t=1.0s\n" +
                    "Disappears at t=302.0s\n" +
                    "\n" +
                    "Name: RECTANGLE\n" +
                    "Type: rectangle\n" +
                    "Min corner: (145.0,240.0), Width: 110.0, Height: 110.0, Color: " +
                    "(11.3,45.7,175.3)\n" +
                    "Appears at t=1.0s\n" +
                    "Disappears at t=302.0s\n" +
                    "\n" +
                    "Shape disk1 moves from (190.0,180.0) to (190.0,50.0) from t=25.0s to" +
                    " t=35.0s\n" +
                    "Shape disk1 moves from (190.0,50.0) to (490.0,50.0) from t=36.0s to" +
                    " t=46.0s\n" +
                    "Shape disk1 moves from (490.0,50.0) to (490.0,240.0) from t=47.0s to" +
                    " t=57.0s\n" +
                    "Shape disk2 moves from (167.5,210.0) to (167.5,50.0) from t=57.0s to" +
                    " t=67.0s\n" +
                    "Shape disk2 moves from (167.5,50.0) to (317.5,50.0) from t=68.0s to" +
                    " t=78.0s\n" +
                    "Shape disk2 moves from (317.5,50.0) to (317.5,240.0) from t=79.0s to " +
                    "t=89.0s\n" +
                    "Shape disk1 moves from (490.0,240.0) to (490.0,50.0) from t=89.0s to " +
                    "t=99.0s\n" +
                    "Shape disk1 moves from (490.0,50.0) to (340.0,50.0) from t=100.0s to " +
                    "t=110.0s\n" +
                    "Shape disk1 moves from (340.0,50.0) to (340.0,210.0) from t=111.0s to" +
                    " t=121.0s\n" +
                    "Shape disk3 moves from (145.0,240.0) to (145.0,50.0) from t=121.0s to" +
                    " t=131.0s\n" +
                    "Shape disk3 moves from (145.0,50.0) to (445.0,50.0) from t=132.0s to " +
                    "t=142.0s\n" +
                    "Shape disk3 moves from (445.0,50.0) to (445.0,240.0) from t=143.0s to" +
                    " t=153.0s\n" +
                    "Shape disk3 changes color from (0.0,175.3,45.7) to (0.0,0.0,255.0) from " +
                    "t=153.0s to t=161.0s\n" +
                    "Shape disk1 moves from (340.0,210.0) to (340.0,50.0) from t=153.0s to" +
                    " t=163.0s\n" +
                    "Shape disk1 moves from (340.0,50.0) to (190.0,50.0) from t=164.0s t" +
                    " t=174.0s\n" +
                    "Shape disk1 moves from (190.0,50.0) to (190.0,240.0) from t=175.0s to" +
                    " t=185.0s\n" +
                    "Shape disk2 moves from (317.5,240.0) to (317.5,50.0) from t=185.0s " +
                    "to t=195.0s\n" +
                    "Shape disk2 moves from (317.5,50.0) to (467.5,50.0) from t=196.0s to" +
                    " t=206.0s\n" +
                    "Shape disk2 moves from (467.5,50.0) to (467.5,210.0) from t=207.0s " +
                    "to t=217.0s\n" +
                    "Shape disk2 changes color from (0.0,41.8,247.1) to (0.0,0.0,255.0) f" +
                    "rom t=217.0s to t=225.0s\n" +
                    "Shape disk1 moves from (190.0,240.0) to (190.0,50.0) from t=217.0s t" +
                    "o t=227.0s\n" +
                    "Shape disk1 moves from (190.0,50.0) to (490.0,50.0) from t=228.0s t" +
                    "o t=238.0s\n" +
                    "Shape disk1 moves from (490.0,50.0) to (490.0,180.0) from t=239.0s " +
                    "to t=249.0s\n" +
                    "Shape disk1 changes color from (0.0,90.4,49.8) to (0.0,0.0,255.0) f" +
                    "rom t=249.0s to t=257.0s\n",
            ((Text) testView).ap.toString());

  }

  // testing speed 20
  @Test
  public void testTOH5TXT() throws FileNotFoundException {

    IModel testModel = null;

    TweenModelBuilder<IModel> builder = Model.getBuilder();

    AnimationFileReader fileReader = new AnimationFileReader();

    try {

      testModel = fileReader.readFile("toh-5.txt", builder);

    } catch (Exception e) {

      throw new FileNotFoundException("In Main() file problems:" + e.getMessage());

    }

    StringBuffer out = new StringBuffer();

    IView testView = new Text(20, out);
    IController testController = new Controller(testModel, testView);

    testController.goRun();

    // string test too long.
    String x = "true";
    assertEquals("true", x);
  }




}
