package box;

/* Program: BoxFactory
 * Create rectangles with (x,y) points and display to console.
 *
 * Compile/execute from CL:
 *  cd "C:\JavaWorkspace\...\Box"
 *  javac -cp "C:\Users\...\main" BoxFactory.java
 *  java -cp "C:\Users\...\main" Box.BoxFactory
 */
 
import conversion.Metrico;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

public class BoxFactory{

  public static void main(String[] args){
    
    int shapeSides = 4;                        // Sides of the shape (int this case 4)
    double totalArea = 0;                      // Total area of all sahpes
    double totalLength = 0;                    // Total length of sum of all lines
    
    Point[]   points;                          // Array object jolds coordinates
    Line      line = new Line();               // Connects points and gives distance & area
    
    Rectangle[] rectAngle = new Rectangle[4];  // Rectangle array initialized amount of shapes
    Rectangle   parentRectangle;               // Declare object for oversize rectangle
    Rectangle   derivedRect;                   // Daclare object for summed recangle
    
    Metrico[] metricLength = new Metrico[3];   // Metrico objects will hold three values m/cm/mm:
    int       aLengthM  = 0;                   //  - meters
    int       aLengthCM = 0;                   //  - centimeters
    int       aLengthMM = 0;                   //  - millimeters
    int       anyIntVal = 2;                   // Integer value for calculation
    double    anyDblVal = 5.5;                 // Double value for calcualtion

    /* Each element represents coordinates for points in
     *  the form (x,y).
     * Rectangles built with point pairs - odd elements
     *  represent top-left points while even represent
     *  bottom-right points.
     */
     double[][] coords = {
      // rectangle #1
      {1.0 , 1.0},        // element 0 : point #1, bottom-left
      {1.0 , 3.0},        // element 1 : point #2, top-left
      {4.0 , 3.0},        // element 2 : point #3, top-right
      {4.0 , 1.0},        // element 3 : point #4, bottom-right

      // rectangle #2
      {5.0 , 1.0},
      {5.0 , 4.0},
      {8.0 , 4.0},
      {8.0 , 1.0},

      // rectangle #3
      {2.0 , 5.0},
      {2.0 , 7.0},
      {4.0 , 7.0},
      {4.0 , 5.0},
      
      // rectangle #4
      {7.0 , 6.0},
      {7.0 , 9.0},
      {9.0 , 9.0},
      {9.0 , 6.0}         // element 15 : point #16, bottom-right
    };

    System.out.println("\n-----------------------------------------------\n");
    
    // Create Point array and fill with points
    points = new Point[coords.length];
    for(int i = 0; i < points.length; i++){
      points[i] = new Point(coords[i][0], coords[i][1], i+1);
    }

    // Display coordinates for one point
    //points[0].displayOneCoord();
 
    // Display coordinates for all points
    System.out.println("\nTotal of " +
    Point.getCount() + " points in the form (x,y):\n");
    points[0].displayAllCoords(points); 

    System.out.println("\n-----------------------------------------------\n");

    // Create Rectangles with four existing points
    for(int i = 0, j = 0; i < points.length; i += 4, j++){
      rectAngle[j] = new Rectangle(
        points[i],
        points[i+1],
        points[i+2],
        points[i+3],
        j+1);
    }

    //Display all rectangles
    System.out.println("Total of rectangles: " + Rectangle.getCount());
    Rectangle.displayAllRectangles(rectAngle);

    System.out.println("\n-----------------------------------------------\n");

    /* Create 3 objects tor calculating metric m/cm/mm.
     * Use random numbers for passed measurements.
     * Call method in Metrico class for calcualtion.
     * Third Metrico obj will pass a double to test comunication
     *   between constructors.
     */
/*  // Create Metrico aray with random values from 1 to 999.
    for(int i = 0; i < 2; i++){

      aLengthM  = 1 + (int)(999*Math.random());
      aLengthCM = 1 + (int)(99*Math.random());
      aLengthMM = 1 + (int)(9*Math.random());
      
      metricLength[i] = new Metrico(aLengthM, aLengthCM, aLengthMM);    
    
      System.out.println("Random 1: " + aLengthM + " * 1" +
        "\nRandom 2: " + aLengthCM + " * 100" + " = " + aLengthCM*100 +
        "\nRandom 3: " + aLengthMM + " * 1000" + " = " + aLengthMM*1000);
        
      System.out.println("\nLength of Metrico #" + (1+i) + ": " +
        metricLength[i].getTotalL());
    }
    
    // Add total length
    metricLength[0].addSub(metricLength[1]);
    System.out.println("\nAdding length: " + metricLength[0].getCalc(0) );

    // Multiplication & division of Metrico object
    metricLength[2] = new Metrico(anyDblVal);  
    System.out.println(
      "\nLength of Metrico #3" + ": " + metricLength[2].getTotalL());

    System.out.println();
                       
    metricLength[0].multiDiv(metricLength[0], anyIntVal);
    System.out.print("\nDivision of " + metricLength[0].getTotalL() +
      " by " + anyIntVal + " = "   + metricLength[0].getCalc(3) );
    System.out.print("\nMultiply " + metricLength[0].getTotalL() +
      " by " + anyIntVal + " = "   + metricLength[0].getCalc(2) );

    System.out.println();
    System.out.println("\n-----------------------------------------------\n");
*/
  }
}