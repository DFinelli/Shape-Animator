package cs5004.animator.model;

/**
 * This enum class representing a shape type.
 */
public enum ShapeType {

  RECTANGLE("rectangle"), OVAL("oval");

  public String printWord;

  /** Creates a shape type enum.
   *
   * @param print the print string.
   */
  ShapeType(String print) {

    this.printWord = print;

  }

  /** Gets the print string of the enum.
   *
   * @return the print string.
   */
  public String getPrintWord() {

    return this.printWord;

  }

}
