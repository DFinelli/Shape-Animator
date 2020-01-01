package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import cs5004.animator.model.IMotion;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Move;
import cs5004.animator.model.Recolor;
import cs5004.animator.model.Scale;
import cs5004.animator.model.ShapeType;

/**
 * This class representing svg view.
 */
public class Text extends AbstractView {

  /** Construct a svg view.
   *
   * @param speed the speed.
   * @param ap the appendable.
   *
   */
  public Text(int speed, Appendable ap) {

    super(speed, ap);

    shapes = new java.util.TreeMap<IShape, String>();
    motions = new java.util.TreeMap<IMotion, String>();


  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  ///// Print /////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Put shapes into string form.
   * @returns a string of formmated shape.
   */
  public String printShapes() {

    String output = "Shapes:\n";

    for (IShape key : shapes.keySet()) {

      if (key.getShapeType().equals(ShapeType.RECTANGLE)) {

        output = output + "Name: " + key.getShapeType() + "\nType: "
                +  key.getShapeType().getPrintWord()
                + "\nMin corner: (" + key.getX() + "," + key.getY() + "), Width: " + key.getW()
                + ", Height: " + key.getW() + ", Color: (" + String.format("%1.1f",
                (key.getR() * 255)
        ) + "," + String.format("%1.1f", (key.getG() * 255)) + ","
                + String.format("%1.1f", (key.getB() * 255))
                + ")\nAppears at t=" + ((float)((key.getAppears() / speed)))
                + "s\nDisappears at t="
                + ((float)((key.getDisappears() / speed))) + "s";

      }

      if (key.getShapeType().equals(ShapeType.OVAL)) {

        return "Name: " + key.getShapeId() + "\nType: " +  key.getShapeType().getPrintWord()
                + "\nCenter: (" + key.getX() + "," + key.getY() + "), X radius: " + key.getW()
                + ", Y radius: " + key.getH() + ", Color: ("
                + String.format("%.0f", (key.getR() * 255))
                + "," + String.format("%.0f", (key.getG() * 255)) + ","
                + String.format("%.0f", (key.getB() * 255))
                + ")\nAppears at t=" + (key.getAppears() / speed) + "s\nDisappears at t="
                + (key.getDisappears() / speed) + "s";


      }

      output = output + "\n\n";

    }

    return output;

  }

  /**
   * Put motions into string form.
   * @returns a string of formmated motions.
   */
  public String printMotions() {

    String output = "";

    for (IMotion key : motions.keySet()) {

      //String.format("%.0f", (key.getG()*255))

      if (key instanceof Move) {

        output = output + "Shape " + key.getShapeId() + " moves from ("
                + (((Move) key).getFromX()) + ","
                + (((Move) key).getFromY()) + ") to (" +
                (((Move) key).getToX()) + "," + (((Move) key).getToY()) + ") from t="
                + ((float)(key.getStartTime() / speed)) + "s to t="
                + ((float)(key.getEndTime() / speed)) + "s";

      }

      if (key instanceof Scale) {

        output = output + "Shape " + key.getShapeId() + " scales from Width: "
                + ((Scale) key).getFromW()
                + ", Height: " + ((Scale) key).getFromH()
                + ", to Width: " + ((Scale) key).getToW() + ", Height: " +
                ((Scale) key).getToH() + " from t="
                + ((float)(key.getStartTime() / speed))
                + "s to t=" + ((float)(key.getEndTime() / speed)) + "s";

      }

      if (key instanceof Recolor) {

        output = output + "Shape " + key.getShapeId() + " changes color from ("
                + String.format("%1.1f", ((Recolor) key).getFromR())
                + "," + String.format("%1.1f", (((Recolor) key).getFromG() * 255))
                + "," + String.format("%1.1f", (((Recolor) key).getFromB() * 255))
                + ") to (" + String.format("%1.1f", (((Recolor) key).getToR() * 255))
                + "," + String.format("%1.1f", (((Recolor) key).getToG() * 255))
                + "," + String.format("%1.1f", (((Recolor) key).getToB() * 255))
                + ") from t="
                + ((float)(key.getStartTime() / speed))
                + "s to t=" + ((float)(key.getEndTime() / speed)) + "s";

      }

      output = output + "\n";

    }


    return output;

  }


  /**
   * {@inheritDoc}
   */
  public void render(java.util.List<IShape> toRenderShapes) {


    String shapesPrinted = printShapes();
    String motionsPrinted = printMotions();

    //System.out.println(shapesPrinted + motionsPrinted);

    if (this.ap instanceof FileWriter) {


      write((shapesPrinted + motionsPrinted));

    } else {

      String str = shapesPrinted + motionsPrinted;

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

      ((FileWriter)ap).write(str);
      ((FileWriter)ap).flush();
      ((FileWriter)ap).close();

    } catch (IOException e) {

      e.printStackTrace();

    }


  }


}
