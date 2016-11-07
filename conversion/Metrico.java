package conversion;

/* Represent a length measured in meters, centimeters, and millimeters.
 */

public class Metrico{

  // CLASS VARIABLES
  private static int CENTI = 100;       // Centimeter factor
  private static int CM_MM = 10;        // Centimeter factor
  private static int MILLI = 1000;      // Millimeter factor
  private static int counter = 0;       // Object counter
  
  // INSTANCE VARIABLES
  public int totalSumInMilli = 0;       // Sum passed values into millimeters
  private int lengthM  = 0;             // Meters
  private int lengthCM = 0;             // Centimeters
  private int lengthMM = 0;             // Millimeters
  private int totalL   = 0;             // Sum of m/cm/mm fo each object
  private int[] outCalc = new int[4];   // Array of results from arithmentic calculation

  // CONSTRUCTORS
  public Metrico(){
  }
  public Metrico(double inCM){
    this((int)Math.round(1000*inCM));
  }
  public Metrico(int inMM){
    lengthM  = inMM / MILLI;
    lengthCM = (inMM - lengthM * MILLI)/CM_MM;
    lengthMM = inMM - lengthM*MILLI - lengthCM*CM_MM;
    counter++;
    totalL = lengthM*MILLI + lengthCM*CM_MM + lengthMM;
  }  
  public Metrico(int inM, int inCM, int inMM){
    this(inM + CENTI*inCM + MILLI*inMM);
    totalSumInMilli = inM + CENTI*inCM + MILLI*inMM;
  }

  // ACCESS
  public int getMeter(){
    return lengthM;
  }
  public int getCenti(){
    return lengthCM;
  }
  public int getMilli(){
    return lengthMM;
  }
  public int getTotalL(){
    return totalL;
  }
  public static int getCount(){
    return counter;
  }
  public int getCalc(int arrayElement){
    return outCalc[arrayElement];
  }

  // Convert all measurements to mm
  public int toMM(){
    return lengthM*MILLI + lengthCM*CM_MM + lengthMM;
  }
 
  // Add & subtract objects
  public int[] addSub(Metrico inLength){
    outCalc[0] = this.totalL + inLength.totalL;
    outCalc[1] = this.totalL - inLength.totalL;
    return outCalc;
  }

  public int[] multiDiv(Metrico inLength, int inVal){
    outCalc[2] = inLength.totalL * inVal;
    outCalc[3] = inLength.totalL / inVal;
    return outCalc;
  }

  // Compare objects (boolean returned)
  public boolean greaterThan(Metrico inLength){
    return totalL > inLength.totalL; // toMM() > inLength.toMM();
  }
  public boolean lessThan(Metrico inLength){
    return toMM() < inLength.toMM();
  }
  public boolean equalThan(Metrico inLength){
    return toMM() == inLength.toMM();
  }
}