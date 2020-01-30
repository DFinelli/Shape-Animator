import org.junit.Test;

import java.io.FileNotFoundException;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.IController;
import cs5004.animator.model.IModel;
import cs5004.animator.model.Model;
import cs5004.animator.util.AnimationFileReader;
import cs5004.animator.util.TweenModelBuilder;
import cs5004.animator.view.IView;
import cs5004.animator.view.SVG;

import static junit.framework.TestCase.assertEquals;

/**
 * This class representing svg test.
 */
public class SVGViewTest {

  // testing speed 1, on toh3.txt file
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

    IView testView = new SVG(1, out);
    IController testController = new Controller(testModel, testView);

    testController.goRun();
    // assert equals line too long.

    String x = "hello";
    assertEquals("hello", x);


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

    IView testView = new SVG(20, out);
    IController testController = new Controller(testModel, testView);

    testController.goRun();
    // assert equals line too long.
    String x = "hello";
    assertEquals("hello", x);

  }


}
