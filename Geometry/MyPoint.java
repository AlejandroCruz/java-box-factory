package Geometry;

/* Chapter 5, Exercise: 1
 * Class MyPoint in Geometry package creates points in
 *   the form "x, y".
 */

import static java.lang.Math.sqrt;      // For calculating distance between two points

public class MyPoint {
  
  // CLASS VARIABLES
  private static int count;             // Counter for amount of points
  private static double highX;          // Highest & lowest value of x & y coordinates
  private static double highY;          //   ...
  private static double lowX;           //   ...
  private static double lowY;           //   ...
  private static double coordX  = 0.0;  // Create new coords by adding
  private static double coordY  = 0.0;  //   or subtracting one.

  // INSTANCE VARIABLES
  private double  x;                    // Hold value for x &
  private double  y;                    //   y coords.
  private int     index;                // Identifier for each point
  MyPoint pA;                           // Rectangle corner A
  MyPoint pB;                           // Rectangle corner B
  MyPoint pC;                           // Rectangle corner C
  MyPoint pD;                           // Rectangle corner D


  /* CONSTRUCTOR
   * Points not included in initial points array (no index).
   */
  public MyPoint(double inX, double inY){
    x = inX;
    y = inY;
  }
  /* CONSTRUCTOR
   * Take coordinates from user supplied values.
   */
  public MyPoint(double inX, double inY, int index){
    this(inX, inY);
    this.index = index;
    count++;
  }
  
  // ACCESS
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }
  public int getIndex(){
    return index;
  }
  public static int getCount(){
    return count;
  }
  // MUTATE
  public void setX(double inX){
    x = inX;
  }
  public void setY(double inY){
    y = inY;
  }


  // Auto-convert to a string
  public String toString() {
    return Double.toString(x) + ", " + y;   // As "x, y"
  }


  // Display coordinates for one point
  ///CODE CHECK: Not using toString()
  public void displayOneCoord(){
   System.out.println(
     "\nPoint #" + getIndex() +
     " coordinates (x,y): " + x + ", " + y);
  }

  
  // Display coordinates for all points
  public void displayAllCoords(MyPoint[] p){
    for(int i = 0; i < p.length; i++){
      System.out.println("Point #" + p[i].getIndex() +
      " coordinates: (" + p[i] + ")");
    }
  }


  // Calculate distance to another point (c2 = a2 + b2)
  public double distance(final MyPoint inP){
    return sqrt( (x - inP.x)*(x - inP.x)+(y - inP.y)*(y - inP.y) );
  }

  // Find highest & lowest values for X/Y and return a new rectangle
  public Rectangle oversizePoints(double[][] c){

    // Find highest & lowest value of x & y coordinates
    highX = 0.0;
    highY = 0.0;
    lowX  = c[0][0];
    lowY  = c[0][1];

    for(int i = 0; i < c.length; i++){
      
      if( highX < c[i][0] ){ highX = c[i][0]; }      
      if( highY < c[i][1] ){ highY = c[i][1]; }
      
      if( lowX > c[i][0] ){ lowX = c[i][0]; }      
      if( lowY > c[i][1] ){ lowY = c[i][1]; }      
    }
    
    // Create a rectangle encompassing all others inside.
    pA  =  new  MyPoint( lowX  , lowY  );
    pB  =  new  MyPoint( lowX  , highY );
    pC  =  new  MyPoint( highX , highY );
    pD  =  new  MyPoint( highX , lowY  );
    
    // Add and subtract to move points to one point oversize 
    coordX = pA.getX(); coordX--; pA.setX(coordX);
    coordY = pA.getY(); coordY--; pA.setY(coordY);
    
    coordX = pB.getX(); coordX--; pB.setX(coordX);
    coordY = pB.getY(); coordY++; pB.setY(coordY);
    
    coordX = pC.getX(); coordX++; pC.setX(coordX);
    coordY = pC.getY(); coordY++; pC.setY(coordY);
    
    coordX = pD.getX(); coordX++; pD.setX(coordX);
    coordY = pD.getY(); coordY--; pD.setY(coordY);
    
    // Create new rectangle with moved points.
    return new Rectangle(pA, pB, pC, pD);
  }


  // Sum the highest points and make a rectangle
  public Rectangle sumPoints(Rectangle[] r){
    
    // Create a rectangle encompassing all others inside.
    pA  =  new  MyPoint( lowX  , lowY );
    pB  =  new  MyPoint( lowX  , 0.0 );
    pC  =  new  MyPoint( 0.0  , 0.0 );
    pD  =  new  MyPoint( 0.0  , lowY );
    
    for(int i = 0; i < r.length; i++){
      
      // Add  highest points to move points to maximum coordinates 
      coordY += r[i].getB().getY(); 
      coordX += r[i].getC().getX();
      coordY += r[i].getC().getY();
      coordX += r[i].getD().getX();
      pB.setY(coordY);
      pC.setX(coordX);
      pC.setY(coordY);
      pD.setX(coordX);
    }
    return new Rectangle(pA, pB,pC,pD);
  }

}