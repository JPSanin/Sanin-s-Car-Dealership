package model;
public class Soat extends Document{
private final static int SIZE=4;
//Soat attributes
private double coverageAmount;

//Constructor
/** Constructor method for a Technomecanical<br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a Technomecanical document and initializes its attributes<br>
	@param price, a double with the  price
	@param year, an int with the  year
	@param coverageAmount, a double with the coverage amount
	*/
  public Soat(double price,int year, double coverageAmount) {
  super(price,year);
  this.coverageAmount=coverageAmount;
  }	
  
  
/** Method for decoding document's code<br>
		
	<b> pre: </b> <br>
	<b> post: </b>decodes the document's picture<br>	
	*/
 @Override
 public void decode() {
	int[][] pic= super.getPicture();
	String decoded="";
	//Soat code is obtained by transversing the matrix in L shape
	for(int i=0; i< SIZE; i++){
	decoded+=pic[i][0];
	}
	for(int i=1; i< SIZE-1; i++){
	decoded+=pic[SIZE-1][i];
	}
	super.setCode(decoded);
  }
  
@Override
public String printInfo(){
decode();
String info="";
info+="SOAT\n";
info+=super.printInfo();
info+= "\nCoverage amount: "+coverageAmount;
info+="\nCode: "+super.getCode()+"\n";
return info;
}
 //Getters and Setters
/** Getter method for accessing the coverage amount <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the coverage amount<br>
	@return a double with the coverage amount
	*/
public double getCoverageAmount(){
return coverageAmount;
}

/** Setter method for modifying the coverage amount<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the coverage amount<br>
	@param coverageAmount, a double with the coverage amount
	*/
public void setCoverageAmount(double coverageAmount){
this.coverageAmount=coverageAmount;
}
}