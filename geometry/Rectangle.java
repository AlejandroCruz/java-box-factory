package geometry;

/* Creates rectangles from points.
 */

public class Rectangle{
  
  // CLASS VARIABLES
  private static int count;          // Counter reference
  
  // INSTANCE VARIABLES
  private int    index;              // Index identifier for each rectangle
  private double area;               // Rectangle area
  private Point  pointA;             // Rectangle corner A
  private Point  pointB;             // Rectangle corner B
  private Point  pointC;             // Rectangle corner C
  private Point  pointD;             // Rectangle corner D
  private Line   lineAB;             // Rectangle line A+B
  private Line   lineBC;             // Rectangle line B+C

  // CONSTRUCTORS
  public Rectangle(Rectangle oldR){
      pointA = oldR.pointA;
      pointB = oldR.pointB;
      pointC = oldR.pointC;
      pointD = oldR.pointD;
  }
  public Rectangle(Line inLineAB, Line inLineBC){
    lineAB = inLineAB;
    lineBC = inLineBC;
  }
  public Rectangle(
    final Point inA,
    final Point inB,
    final Point inC,
    final Point inD){
      pointA = inA;
      pointB = inB;
      pointC = inC;
      pointD = inD;
  }
  public Rectangle(
    final Point inA,
    final Point inB,
    final Point inC,
    final Point inD, int index){
      this(inA, inB, inC, inD);
      this.index  = index;
      count++;
  }

  // ACCESS
  public Point getA(){
    return pointA;
  }
  public Point getB(){
    return pointB;
  }
  public Point getC(){
    return pointC;
  }
  public Point getD(){
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