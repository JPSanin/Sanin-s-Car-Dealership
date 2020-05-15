package model;
import java.util.*;
public class Gas extends Car implements GasConsumption{
	
//Price Constants
private final static double MISSING_DOCS=500.00;
private final static double USED_DISCOUNT=0.1;

//Gas attributes

private int tankCapacity;
private String gasType;
private double gasConsumption;

//Constructor
/** Constructor method for a car <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a vehicle and initializes its attributes, with special owner<br>
	@param basePrice, a double with the base price
	@param brand, a String with the brand
	@param model, an int with the year model
	@param engineDisplacement, an int with the engine displacement
	@param mileage,  an int with the mileage
	@param isNew,  a boolean representing the vehicles condition
	@param licensePlate, a String with the licensePlate
	@param type, a String with the type of car
	@param doors,  an int with the number of doors
	@param tintedWindows,  a boolean representing the cars windows
	@param tankCapacity, an int with the tank capacity of the gas car
	@param gasType, a String with the type of gas the car uses
	*/
public Gas(double basePrice,String brand,int model,int engineDisplacement,int mileage,boolean isNew,
String licensePlate,String type,int doors,boolean tintedWindows,int tankCapacity, String gasType){
	
super( basePrice, brand, model, engineDisplacement, mileage,isNew,
licensePlate,type,doors, tintedWindows);
this.tankCapacity=tankCapacity;
this.gasType=gasType;

}



/** Method for calculating gas car final price<br>
		
	<b> pre: </b> <br>
	<b> post: </b>calculates the final price with an optional discount<br>	
	@param discount,  a double with a discount
	*/
@Override
public void calculatePrice(double discount) {
//For Gas car missing docs 500, increase 0%, used discount 10%

int nowYear= super.getDate().getYear();
ArrayList<Document> docs;
docs=super.getDocuments();
double finalPrice=super.getBasePrice();
if(docs.isEmpty()||docs.size()==1){
finalPrice+=MISSING_DOCS;	
}else if(docs.get(docs.size()-1).getYear()!=nowYear || docs.get(docs.size()-2).getYear()!=nowYear ){
finalPrice+=MISSING_DOCS;
}
if(super.getIsNew()==false){
finalPrice-= finalPrice*USED_DISCOUNT;
}

finalPrice-= finalPrice*discount;

super.setTotalSalesPrice(finalPrice);
}

/** Method for showing gas car description<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the description<br>	
	*/
@Override
public String description() {
calculateGasConsumption();

String info="";
info+="\nGas Car\n";
info+=super.description();	
info+= "\nTank capacity: "+tankCapacity;
info+= "\nGas type: "+gasType;		
info+= "\nGas consumption: "+gasConsumption;
info+="\nBase price: "+super.getBasePrice();
info+="\nFinal price: "+super.getTotalSalesPrice();
return info;
}


/** Method for calculating car gas consumption<br>
		
	<b> pre: </b> <br>
	<b> post: </b>calculates the gas consumption<br>	
	*/
@Override
public void calculateGasConsumption(){
gasConsumption=(tankCapacity)*(super.getEngineDisplacement()/100.0);		
}

//Getters and Setters
/** Getter method for accessing the gas type<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the gas type<br>
	@return a String representing the gas type
	*/
public String getGasType(){
return gasType;
}

/** Setter method for modifying the gas type<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the gas type<br>
	@param gasType, a String with the gas type
	*/
public void setGasType(String gasType){
this.gasType=gasType;
}

/** Getter method for accessing the tank capacity <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the tank capacity<br>
	@return a int with the tank capacity
	*/
public int getTankCapacity(){
return tankCapacity;
}

/** Setter method for modifying the tank capacity<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the tank capacity <br>
	@param tankCapacity, a int with the tank capacity
	*/
public void setTankCapacity(int tankCapacity){
this.tankCapacity=tankCapacity;
}

/** Getter method for accessing the  gas consumption <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the  gas consumption<br>
	@return a double with the  gas consumption
	*/
public double getGasConsumption(){
return gasConsumption;
}

/** Setter method for modifying the  gas consumption<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the  gas consumption <br>
	@param gasConsumption, a double with the  gas consumption
	*/
public void setGasConsumption(double gasConsumption){
this.gasConsumption=gasConsumption;
}
}
