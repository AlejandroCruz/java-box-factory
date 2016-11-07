package geometry;

/* Create lines from points.
 */
 
public class Line{
  
  // INSTANCE VARIABLES
  private final  String ID_A  =  "A";   // Identify line by point pair combination
  private final  String ID_B  =  "B";
  private final  String ID_C  =  "C";
  private final  String ID_D  =  "D";
  private String strLineId    =  "XX";  //  ...
  private double lineAB;                // Line used in area calculation (width)
  private double lineBC;                // Line used in area calculation (length)  
  private double lineCD;                // Used in calculation of total length of all lines
  private double lineDA;                // Used in calculation of total length of all lines
  private double linesLength = 0;       // Hold total length of all lines
  private Point  start;                 // Beginning of a line
  private Point  end;                   // End of a line

  // CONSTRUCTORS
  public Line(){
  }  
  public Line(Point inStart, Point inEnd){ // Set lines AB, BC
    start = inStart;
    end   = inEnd;
  }

  // ACCESS
  public Point getStart(){
    return start;
  }
  public Point getEnd(){
    return end;
  }
  public double getLineAB(){
    return lineAB;
  }
  public double getLineBC(){
    return lineBC;
  }
  public double getLineCD(){
    return lineCD;
  }
  public double getLineDA(){
    return lineDA;
  }

  // MUTATE
  public void setStart(Point s){
    start = s;
  }
  public void setEnd(Point e){
    end = e;
  }
  public void setLineAB(double ab){
    lineAB = ab;
  }
  public void setLineBC(double bc){
    lineBC = bc;
  }
  public void setLineCD(double cd){
    lineCD = cd;
  }
  public void setLineDA(double da){
    lineDA = da;
  }
  
  // Auto-convert to a string
  public String toString() {
    return "(" + start + "):(" + end + ")";
  }

  // Calculate the length of a line
  public double length(){
    return getStart().distance(getEnd());
  }

  // Calculate area using lines AB + BC (Formula A = wl where width w = y, length l = x)
  public double area(){
    return lineAB * lineBC;
  }
  
  /* Set lines for all four sides (loop counter)of a rectangle.
   * Set width & length for area function.
   * Create a string to identify each line by point pair combination.
   * Call 'area()' method to calculate area.
   */
  public double defineAllSides(final int inSides, final Rectangle inRectAngle){
    
    for(int i = 0; i < inSides; i++){
      switch(i){
        case 0:
          setStart( inRectAngle.getA() );
          setEnd(   inRectAngle.getB() );
          setLineAB(length());
          linesLength += getLineAB();
          strLineId = ID_A + ID_B;
          break;
        case 1:
          setStart( inRectAngle.getB() );
          setEnd(   inRectAngle.getC() );
          setLineBC(length());
          linesLength += getLineBC();
          strLineId = ID_B + ID_C;
          break;
        case 2:
          setStart( inRectAngle.getC() );
          setEnd(   inRectAngle.getD() );
          setLineCD(length());
          linesLength += getLineCD();
          strLineId = ID_C + ID_D;
          break;
        case 3:
          setStart( inRectAngle.getD() );
          setEnd(   inRectAngle.getA() );
          setLineDA(length());
          linesLength += getLineDA();
          strLineId = ID_D + ID_A;
          break;
      }
      System.out.print(
        "Line " + strLineId + " " + this);
      System.out.println("  -  length: " + length());      
    }
    area(); // Calculate area using AB + BC lines
    return linesLength;
  }
}