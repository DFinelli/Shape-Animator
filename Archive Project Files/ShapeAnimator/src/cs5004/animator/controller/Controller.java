package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs5004.animator.model.IModel;
import cs5004.animator.model.IShape;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.IView;

/**
 * This class representing a controller.
 */
public class Controller implements IController {

  IView view;
  IModel model;
  int currentFrame;
  Timer timer;


  /**
   * Construct a controller.
   *
   * @param model the model.
   * @param view  the view.
   * @throws IllegalArgumentException if invalid inputs.
   */
  public Controller(IModel model, IView view) {

    this.view = view;
    this.model = model;
    currentFrame = 0;
    // IDK DOES TIMER MESS UP MY OTHER VIEWS?

    timer = new Timer((1000 / this.view.getSpeed()), new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {



        java.util.List<IShape> toRenderShapes = model.getAllShapesAtFrame(currentFrame);

        if (view instanceof AnimationView) {

          view.render(toRenderShapes);
          currentFrame++;
        }

        int x = 0;

      }
    });

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void goRun() {

    this.view.getModelShapes(this.model.getShapes(), this.model.getMotions());


    if (this.view instanceof AnimationView) {

      return;


    } else {

      this.view.render(null);

    }


  }


  @Override
  public void runTimer() {
    timer.start();
  }


}
