package Box;

/* Program: Carpets
 * Calcualte and display length of carpets.
 */

// User created classes
import Conversion.Metrico;              // Convert values to metric m/cm/mm
import Geometry.MyPoint;                // Create points and lines
import Geometry.MyLine;                 //   for area calcualtion.
import Geometry.Rectangle;              // Assign lines to rectangle

public class Carpets {
  public static void main(String[] args){

    // Constant object placeholder
    int cpt1 = 0;
    int cpt2 = 3;
    
    int[] calcResult = new int[4];      // Receives result from called methods
    int   carpetW    = 4;               // Carpet width
    int   carpetL    = 2;               // Carpet length
    int   cArea;                        // Carpet area

    
    // Point objects in x,y format. (Area = W*L : width = y, length = x)
    MyPoint pA = new MyPoint(0, 0);          // origin
    MyPoint pB = new MyPoint(0, carpetW);    // corner
    MyPoint pC = new MyPoint(carpetL, 0);    // ...


    // Lines for the carpet at origin 0,0
    MyLine cWidth  = new MyLine(pA, pB);
    MyLine cLength = new MyLine(pA, pC);
    cWidth.setLineAB(cWidth.length());       // Calcualte distance
    cLength.setLineBC(cLength.length());     // Calcualte distance


    // Length objects
    Metrico[] length = new Metrico[4];
    length[0] = new Metrico(4,2,9);
    length[1] = new Metrico(4);
    length[2] = new Metrico(123);
    length[3] = new Metrico(4,5,6);
    
    
    // Rectangle objects
    Rectangle carpet01 = new Rectangle(cWidth, cLength); 


    /**/
    System.out.println(
    "\n-----------------------------------------------\n");


    ///CODE CHECK Display m/cm/mm & total
    System.out.println("Length in meters: " + length[cpt1].getMeter());
    System.out.println("Length in centimeters: " + length[cpt1].getCenti());
    System.out.println("Length in millimeters: " + length[cpt1].getMilli());
    System.out.println("\nSum of processed values in mm: " + length[cpt1].getTotalL());
    System.out.println("\n--\n");
    System.out.println("Length in meters: " + length[cpt2].getMeter());
    System.out.println("Length in centimeters: " + length[cpt2].getCenti());
    System.out.println("Length in millimeters: " + length[cpt2].getMilli());
    System.out.println("\nSum of processed values in mm: " + length[cpt2].getTotalL());
    /**/


    System.out.println(
    "\n-----------------------------------------------\n");


    // Get area
    /* cArea = (int)carpet01.recArea();
    System.out.println("\nArea: " + cArea); */
    
    
    // Compare objects
    System.out.println("Comparing length of two Carpet objects:");
    if(length[cpt1].greaterThan(length[cpt2])){
      System.out.println("Length " + length[cpt1].getTotalL() + " > " +
        " length " + length[cpt2].getTotalL());
    } else if(length[cpt1].lessThan(length[cpt2])){
      System.out.println("Length " + length[cpt1].getTotalL() + " < " +
        " length " + length[cpt2].getTotalL());
    } else if(length[cpt1] == length[cpt2]){
      System.out.println("Length " + length[cpt1].getTotalL() + " = " +
        " length " + length[cpt2].getTotalL());
    } else {
      System.out.println("Error; carpet value missing.");
    }


    System.out.println(
    "\n-----------------------------------------------\n");


    // Sum and and subtract length objects; display
    /* calcResult = length[2].addSub(length[3]);
    System.out.println("\nResult from addition: " + calcResult[0]);
    System.out.println("Result from subtraction: " + calcResult[1]); */
    
    // Multiply and divide length objects; display
    /* calcResult = length[3].multiDiv(length[3], 2);
    System.out.println("\nResult from multiplication: " + calcResult[2]);
    System.out.println("Result from division: " + calcResult[3]); */
    
  } // END main
}