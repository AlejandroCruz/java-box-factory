package Geometry;
/* 
 * Ch5: TRY IT OUT - The Line Class
 * Class Point tha represents point objects
 */

public class Line {
  Point start;                   // Start point of line
  Point end;                     // End point of line
  
  // Create a line from two points
  public Line(final Point start, final Point end){
    this.start = new Point(start);
    this.end   = new Point(end);
  }
  
  // Create a line from two coordinate pairs
  public Line(double xStart, double yStart, double xEnd, double yEnd){
    start = new Point(xStart, yStart);    // Create the start point
    end   = new Point(xEnd, yEnd);        // Create the end point
  }
  
  // Calcualte the length of the line
  public double length(){
    return start.distance(end);           // Use the method from the Point class
  }
  
  // Convert a line to a string
  public String toString(){
    return "(" + start + "):(" + end + ")";   // As "(start):(end)"
  }
  
  // Return a point as the intersection of two lines
  public Point intersects(final Line line1) {
    Point localPoint = new Point(0, 0);
    
    double num = (end.getY() - start.getY()) * (start.getX() - line1.start.getX()) -
                  (end.getX() - start.getX()) * (start.getY() - line1.start.getY());

    double denom = (end.getY() - start.getY()) * (line1.end.getX() - line1.start.getX()) -
                    (end.getX() - start.getX()) * (line1.end.getY() - line1.start.getY());

    localPoint.setX(line1.start.getX() + (line1.end.getX() - line1.start.getX())*num/denom);
    localPoint.setY(line1.start.getY() + (line1.end.getY() - line1.start.getY())*num/denom);
    
    return localPoint;
  }
  
}