package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import cs5004.animator.model.IMotion;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Move;
import cs5004.animator.model.Recolor;
import cs5004.animator.model.Scale;
import cs5004.animator.model.ShapeType;

/**
 * This class representing svg view.
 */
public class SVG extends AbstractView {


  /** Construct a svg view.
   *
   * @param speed the speed.
   * @param ap the appendable.
   *
   */
  public SVG(int speed, Appendable ap) {

    super(speed, ap);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void render(java.util.List<IShape> toRenderShapes) {

    int width = 700;
    int height = 500;

    // set default

    String str = "<svg width=\"" + width + "\" height=\"" + height + "\" version=\"1.1\"\n" +
            "     xmlns=\"http://www.w3.org/2000/svg\">\n";

    // holder rectangle used as a base

    int begin = 0;
    int totalDur = 10000; //ms

    str = str + "\n<rect>\n" +
            "     <animate id=\"base\" begin=\"" + begin + ";base.end\" " +
            "dur=\"" + totalDur + "ms\" " +
            "attributeName=\"visibility\" from=\"hide\" to=\"hide\"/>\n" +
            "</rect>\n";

    for (IShape key : shapes.keySet()) {

      String shapeId = key.getShapeId();
      double x = key.getX();
      double y = key.getY();
      double w = key.getW();
      double h = key.getH();
      double r = key.getR() * 100;
      double g = key.getG() * 100; //rgb can be decimal or whole num
      double b = key.getB() * 100;
      // convert to MS?
      int appears = (key.getAppears() / this.speed) * 1000;
      int disappears = (key.getDisappears() / this.speed) * 1000;

      //// RECT

      if (key.getShapeType().equals(ShapeType.RECTANGLE)) {

        str = str + "\n<rect id=\"" + shapeId + "\" x=\"" + x + "\" y=\"" + y + "\" " +
                "width=\"" + w + "\" height=\"" + h + "\" " +
                "fill=\"rgb(" + r + "%," + g + "%," + b + "%)\" visibility=\"visible\">";

      }


      if (key.getShapeType().equals(ShapeType.OVAL)) {

        str = str + "\n<ellipse id=\"" + shapeId + "\" cx=\"" + x + "\" cy=\"" + y + "\" " +
                "rx=\"" + w + "\" ry=\"" + h + "\" " +
                "fill=\"rgb(" + r + "%," + g + "%," + b + "%)\" visibility=\"visible\">";

      }



      for (Map.Entry<IMotion, String> entry : motions.entrySet()) {

        //System.out.printf("\n %d \n", this.speed);

        //conver to MS & account for speed

        double beginInt = (entry.getKey().getStartTime());
        double beginDivideSpeed = beginInt / this.speed;
        double beginTimesMS = beginDivideSpeed * 1000;
        System.out.printf("\n begin: %f", beginTimesMS);

        double endInt = (entry.getKey().getEndTime());
        double endDivideSpeed = endInt / this.speed;
        double endTimesMS = endDivideSpeed * 1000;
        System.out.printf("\n end: %f", endTimesMS);


        double endMinusBegin = endTimesMS - beginTimesMS;
        System.out.printf("\n END-BEGIN = %f", endMinusBegin);

        double beginMotion = (entry.getKey().getStartTime() / this.speed) * 1000;
        //System.out.printf("\nshapeID=" + entry.getValue() + " beginMotion = %.2f", beginMotion);



        double endMotion = (entry.getKey().getEndTime() / this.speed) * 1000;
        //System.out.printf("\nshapeID=" + entry.getValue() + " endMotion = %.2f", endMotion);


        // if there is a motion that matches the shape
        if (entry.getValue().equals(key.getShapeId())) {

          if (entry.getKey() instanceof Move) {

            double fromX = ((Move) entry.getKey()).getFromX();
            double fromY = ((Move) entry.getKey()).getFromY();
            double toX = ((Move) entry.getKey()).getToX();
            double toY = ((Move) entry.getKey()).getToY();


            //System.out.printf("\nhi  %.2f", endMotion - beginMotion);


            str = str + "\n\n<animate attributeType=\"xml\" " +
                    "begin=\"" + (begin + beginMotion) + "ms\" " +
                    "dur=\"" + endMinusBegin + "ms\" " +

                    "attributeName=\"x\" from=\"" + fromX + "\" " +
                    "to=\"" + toX + "\" fill=\"freeze\"  />\n" +

                    "<animate attributeType=\"xml\" " +
                    "begin=\"" + (begin + beginMotion) + "ms\" " +
                    "dur=\"" + endMinusBegin + "ms\" " +

                    "attributeName=\"y\" from=\"" + fromY + "\" " +
                    "to=\"" + toY + "\" fill=\"freeze\" />";

          }

          if (entry.getKey() instanceof Scale) {

            double fromW = ((Move) entry.getKey()).getFromX();
            double fromH = ((Move) entry.getKey()).getFromY();
            double toW = ((Move) entry.getKey()).getToX();
            double toH = ((Move) entry.getKey()).getToY();


            str = str + "\n\n<animateTransform attributeType=\"xml\" " +
                    "begin=\"" + (begin + beginMotion) + "ms\" " +
                    "dur=\"" + endMinusBegin + "ms\" " +

                    "attributeName=\"transform\" type=\"scale\"" +
                    " from=\"" + fromW + "," + fromH + "\" " +
                    "to=\"" + toW + "," + toH + "\" additive=\"sum\" fill=\"freeze\"  />\n";

          }

          if (entry.getKey() instanceof Recolor) {

            String toR = String.format("%f" , ((Recolor) entry.getKey()).getToR());
            String toG = String.format("%f" , ((Recolor) entry.getKey()).getToG());
            String toB = String.format("%f" , ((Recolor) entry.getKey()).getToB());

            str = str + "\n\n<animate attributeType=\"xml\" " +
                    "begin=\"" + (begin + beginMotion) + "ms\" " +
                    "dur=\"" + endMinusBegin + "ms\" " +

                    "attributeName=\"fill\" to=\"rgb(" + toR + "," + toG + ","
                    + toB + ")\" fill=\"freeze\" />";

          }


        }

      }

      if (key.getShapeType().equals(ShapeType.RECTANGLE)) {

        str = str + "</rect>\n";

      } else {

        str = str + "</ellipse>\n";

      }


    }

    str = str + "\n\n</svg>";


    if (ap instanceof FileWriter) {

      write(str);

    } else {

      StringWriter myStr = new StringWriter(str.length() + 1);
      myStr.write(str);

      ap = myStr;

      System.out.println(str);

    }

  }

  @Override
  public int getSpeed() {
    return this.speed;
  }


  /**
   * Writes the string to file.
   * @param str the str to write.
   */
  public void write(String str) {

    try {

      //File file = new File("test1.svg");
      //FileWriter fileWriter = new FileWriter(file);
      ((FileWriter)this.ap).write(str);
      ((FileWriter)this.ap).flush();
      ((FileWriter)this.ap).close();

    } catch (IOException e) {

      e.printStackTrace();

    }


  }


}
