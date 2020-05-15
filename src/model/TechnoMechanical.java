package model;
public class TechnoMechanical extends Document{
private final static int SIZE=4;
//Soat attributes
private double gasLevels;


//Constructor
/** Constructor method for a Technomecanical<br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a Technomecanical document and initializes its attributes<br>
	@param price, a double with the  price
	@param year, an int with the  year
	@param gasLevels, a double with the gas levels
	*/
  public TechnoMechanical(double price,int year, double gasLevels) {
  super(price,year);
  this.gasLevels=gasLevels;
  }	
  
/** Method for decoding document's code<br>
		
	<b> pre: </b> <br>
	<b> post: </b>decodes the document's picture<br>	
	*/
 @Override
 public void decode() {
	int[][] pic= super.getPicture();
	String decoded="";
	//Soat code is obtained by transversing the matrix in Z shape
	for(int i=0; i< SIZE; i++){
	decoded+=pic[0][i];
	}
	for(int i=1; i< SIZE; i++){
	decoded+=pic[i][SIZE-i-1];
	}
	for(int i=1; i<SIZE; i++){
	decoded+=pic[SIZE-1][i];
	}
	super.setCode(decoded);
  }
  
@Override
public String printInfo(){
decode();
String info="";
info+="Techno Mechanical\n";
info+=super.printInfo();
info+= "\nGas levels: "+gasLevels;
info+="\nCode: "+super.getCode()+"\n";
return info;
}

 //Getters and Setters
/** Getter method for accessing the gas levels <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the gas levels<br>
	@return a double with the gas levels
	*/
public double getGasLevels(){
return gasLevels;
}

/** Setter method for modifying the gas levels<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the gas levels<br>
	@param gasLevels, a double with the gas levels
	*/
public void setGasLevels(double gasLevels){
this.gasLevels=gasLevels;
}
}