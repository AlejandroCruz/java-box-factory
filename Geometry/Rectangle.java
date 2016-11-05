package Geometry;

/* Chapter 5, Exercise: 1
 * Class Rectangle in Geometry package creates rectangles
 *  from points.
 */

public class Rectangle{
  
  // CLASS VARIABLES
  private static int count;             // Counter reference
  
  // INSTANCE VARIABLES  
  private MyPoint   pointA;             // Rectangle corner A
  private MyPoint   pointB;             // Rectangle corner B
  private MyPoint   pointC;             // Rectangle corner C
  private MyPoint   pointD;             // Rectangle corner D
  private MyLine    lineAB;             // Rectangle line A+B
  private MyLine    lineBC;             // Rectangle line B+C
  private double    area;               // Rectangle area
  private int       index;              // Index identifier for each rectangle


  /* CONSTRUCTOR
   * Create a rectangle from an existing object
   */
  public Rectangle(Rectangle oldR){
      pointA = oldR.pointA;
      pointB = oldR.pointB;
      pointC = oldR.pointC;
      pointD = oldR.pointD;
  }
  /* CONSTRUCTOR
   * Create a rectangle from 2 lines: width, length. No index.
   */
  public Rectangle(MyLine inLineAB, MyLine inLineBC){
    lineAB = inLineAB;
    lineBC = inLineBC;
  }
  /* CONSTRUCTOR  
   * Create a rectangle from four points. No index.
   */
  public Rectangle(
    final MyPoint inA,
    final MyPoint inB,
    final MyPoint inC,
    final MyPoint inD){

      pointA = inA;
      pointB = inB;
      pointC = inC;
      pointD = inD;
  }
  /* CONSTRUCTOR
   * Create a rectangle from four points.
   * Append an index reference for each.
   * Increment rectangle counter.
   */
  public Rectangle(
    final MyPoint inA,
    final MyPoint inB,
    final MyPoint inC,
    final MyPoint inD, int index){

      this(inA, inB, inC, inD);
      this.index  = index;
      count++;
  }


  // ACCESS
  public MyPoint getA(){
    return pointA;
  }
  public MyPoint getB(){
    return pointB;
  }
  public MyPoint getC(){
    return pointC;
  }
  public MyPoint getD(){
    return pointD;
  }
  public double getArea(){
    return area;
  }
  public int getIndex(){
    return index;
  }
  public static int getCount(){
    return count;
  }


  // Auto-convert to a string
  public String toString(){
    return(
      "Point A: (" + pointA + ")" +
      "\nPoint B: (" + pointB + ")" +
      "\nPoint C: (" + pointC + ")" +
      "\nPoint D: (" + pointD + ")" );
  }


  // Display all rectangles (corner points)
  public static void displayAllRectangles(Rectangle[] r){
    for(int i = 0; i < r.length; i++){
      System.out.println("\nRectangle #" +
        r[i].getIndex() + "\n" + r[i]);
    }
  }
  
  
  // Rectangle version of area
  public double recArea(){
    return area = lineAB.getLineAB() * lineBC.getLineBC();
  }

  
  // Move the points from an existing rectangle
  public void movePoints(Rectangle inR){
    inR.getA().setX( (1 + inR.getA().getX()) );
    inR.getB().setX( (1 + inR.getB().getX()) );
    inR.getC().setX( (1 + inR.getC().getX()) );
    inR.getD().setX( (1 + inR.getD().getX()) );
  }

}