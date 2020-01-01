package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.JOptionPane;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.IController;
import cs5004.animator.model.IModel;
import cs5004.animator.model.Model;

import cs5004.animator.util.AnimationFileReader;
import cs5004.animator.util.TweenModelBuilder;

import static java.lang.System.exit;


/**
 * This class representing main holder.
 */
public class EasyAnimator {

  /**
   * This class representing main.
   */
  public static void main(String[] args) throws FileNotFoundException {

    IView view;
    IModel model;
    IController controller;

    String ifAnimationFile = null;
    String ivViewType = null;
    Appendable oOutput = null;
    int speedTickPerSec = 1;
    //Appendable oOutput = System.out;

    // loop through input

    int i;

    for (i = 0; i < args.length; i++) {

      //System.out.println(args[i]);

      if (args[i].equals("-if")) {

        ifAnimationFile = args[i + 1];

      }

      if (args[i].equals("-iv")) {

        ivViewType = args[i + 1];

      }

      if (args[i].equals("-o")) {

        if (ivViewType.equals("svg")) {

          File file = new File(args[i + 1] + ".svg");

          try {

            oOutput = new FileWriter(file);

          } catch (IOException e) {
            e.printStackTrace();
          }

        }

        if (ivViewType.equals("text")) {

          File file = new File(args[i + 1] + ".txt");

          try {

            oOutput = new FileWriter(file);

          } catch (IOException e) {
            e.printStackTrace();
          }

        }




      }

      if (args[i].equals("-speed")) {

        speedTickPerSec = Integer.parseInt(args[i + 1]);
        //System.out.println("\n\nheyyyy\n\n" + speedTickPerSec);

      }

    }

    /// check nulls

    if (ifAnimationFile == null) {

      JOptionPane.showMessageDialog(null, "Error: filename is a required inputs");
      exit(-1);

    }

    if (ivViewType == null) {

      JOptionPane.showMessageDialog(null, "Error: view type is a required inputs");
      exit(-1);

    }

    if (oOutput == null) {

      oOutput = System.out;

    }

    // make model, file is read into model, model populates shapes into its arrays

    TweenModelBuilder<IModel> builder = Model.getBuilder();

    AnimationFileReader fileReader = new AnimationFileReader();

    try {

      model = fileReader.readFile(ifAnimationFile, builder);


    } catch (Exception e) {

      throw new FileNotFoundException("In Main() file problems:" + e.getMessage());

    }


    // make view, pass model's arrays into view

    if (ivViewType.equals("text")) {

      view = new Text(speedTickPerSec, oOutput);


    } else if (ivViewType.equals("svg")) {

      view = new SVG(speedTickPerSec, oOutput);

    }

    else if (ivViewType.equals("visual")) {

      view = new AnimationView(speedTickPerSec, oOutput);

    }

    else {

      throw new IllegalArgumentException("invalid view");

    }


    if (view instanceof AnimationView) {

      //System.out.println("hereA");

      ((AnimationView) view).showWindow(true);

      controller = new Controller(model, view);
      controller.runTimer();

    } else {

      controller = new Controller(model, view);


      controller.goRun();

    }



  }

}