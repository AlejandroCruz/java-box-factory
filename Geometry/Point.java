package Geometry;
/* 
 * Ch5: TRY IT OUT - The Point Class
 * Class Point tha represents point objects
 */

import static java.lang.Math.sqrt;

public class Point {

  // Create a point from coordinates
  public Point(double xVal, double yVal){
    x = xVal;
    y = yVal;
  }
  
  // Create a point from another object
  public Point(final Point oldPoint){
    x = oldPoint.x;              // Copy x coordinates 
    y = oldPoint.y;              // Copy y coordinates
  }
  
  // Move a point
  public void move(double xDelta, double yDelta){
    // Parameter values are increments to the current coordinates
    x += xDelta;
    y += yDelta;
  }
  
  // Calculate the distance from another point
  public double distance(final Point aPoint){
    return sqrt( (x - aPoint.x)*(x - aPoint.x) + (y - aPoint.y)*(y - aPoint.y) );
  }
  
  // Convert a point to a string
  /*
   * java.lang.String
   * It is recommended that all subclasses override this method.
   * public String toString()
   * This object (which is already a string!) is itself returned.
   * Specified by:
   *  toString in interface CharSequence
   * Overrides:
   *  toString in class Object
   * Returns:
   *  the string itself.
   *
   * java.lang.Double
   * public String toString()
   * Returns a string representation of this Double object. The primitive double value represented by this object is converted to a string exactly as if by the method toString of one argument.
   * Overrides:
   *  toString in class Object
   * Returns:
   *  a String representation of this object.
   * See Also:
   *  toString(double)
  */
  public String toString(){
    return Double.toString(x) + ", " + y;   // As "x, y"
  }
  
  // Retrieve the x coordinate
  public double getX(){
    return x;
  }
  // Retrieve the y coordinate
  public double getY(){
    return y;
  }
  // Set the x coordinate
  public void setX(double inputX){
    x = inputX;
  }
  // Set the y coordinate
  public void setY(double inputY){
    y = inputY;
  }
  
  // Coordinates of the points
  private double x;
  private double y;
}