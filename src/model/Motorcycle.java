package model;
import java.util.*;
public class Motorcycle extends Vehicle implements GasConsumption{
	
//Price Constants
private final static double MISSING_DOCS=500.00;
private final static double MOTORCYCLE_INCREASE=0.04;
private final static double USED_DISCOUNT=0.02;

//Motorcycle attributes
private String type;
private double gasCapacity;
private double gasConsumption;

//Constructor
/** Constructor method for a motorcycle <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a vehicle and initializes its attributes, with special owner<br>
	@param basePrice, a double with the base price
	@param brand, a String with the brand
	@param model, an int with the year model
	@param engineDisplacement, an int with the engine displacement
	@param mileage,  an int with the mileage
	@param isNew,  a boolean representing the vehicles condition
	@param licensePlate, a String with the licensePlate
	@param type, a String with the type of motorcycle
	@param gasCapacity, a double with the gas capacity
	*/
	
public Motorcycle(double basePrice,String brand,int model,int engineDisplacement,int mileage,boolean isNew,String licensePlate,String type,double gasCapacity){
super(basePrice, brand, model, engineDisplacement, mileage, isNew, licensePlate);
this.type=type;
this.gasCapacity=gasCapacity;
}



/** Method for showing motorcycle description<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the description<br>	
	*/
@Override
public String description() {
calculateGasConsumption();
String info="";
info+="\nMotorcycle\n";
info+=super.description();
info+= "\nType: "+type;	
info+= "\nGas capacity: "+gasCapacity;	
info+= "\nGas consumption: "+gasConsumption;
info+="\nBase price: "+super.getBasePrice();
info+="\nFinal price: "+super.getTotalSalesPrice();
return info;
}


/** Method for calculating motorcycle final price<br>
		
	<b> pre: </b> <br>
	<b> post: </b>calculates the final price with an optional discount<br>	
	@param discount,  a double with a discount
	*/
@Override
public void calculatePrice(double discount) {
//For motorcycle missing docs 500, increase 4%, used discount 2%
int nowYear= super.getDate().getYear();
ArrayList<Document> docs;
docs=super.getDocuments();
double finalPrice=super.getBasePrice();
if(docs.isEmpty()||docs.size()==1){
finalPrice+=MISSING_DOCS;	
}else if(docs.get(docs.size()-1).getYear()!=nowYear || docs.get(docs.size()-2).getYear()!=nowYear){
finalPrice+=MISSING_DOCS;
}

finalPrice+= super.getBasePrice()*MOTORCYCLE_INCREASE;

if(super.getIsNew()==false){
finalPrice-= finalPrice*USED_DISCOUNT;
}

finalPrice-= finalPrice*discount;

super.setTotalSalesPrice(finalPrice);

}



/** Method for calculating motorcycle gas consumption<br>
		
	<b> pre: </b> <br>
	<b> post: </b>calculates the gas consumption<br>	
	*/
@Override
public void calculateGasConsumption(){
gasConsumption=gasCapacity*(super.getEngineDisplacement()/90.0);		
}
//Getters and Setters
/** Getter method for accessing the motorcycle's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the motorcycle's type<br>
	@return a String representing the motorcycle's type
	*/
public String getType(){
return type;
}

/** Setter method for modifying the motorcycle's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the motorcycle's type<br>
	@param type, a String with the motorcycle's type
	*/
public void setType(String type){
this.type=type;
}

/** Getter method for accessing the motorcycle's gas capacity <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the motorcycle's gas capacity<br>
	@return a double with the motorcycle's gas capacity
	*/
public double getGasCapacity(){
return gasCapacity;
}

/** Setter method for modifying the motorcycle's gas capacity<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the motorcycle's gas capacity <br>
	@param gasCapacity, a double with the motorcycle's gas capacity
	*/
public void setGasCapacity(double gasCapacity){
this.gasCapacity=gasCapacity;
}

/** Getter method for accessing the motorcycle's gas consumption <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the motorcycle's gas consumption<br>
	@return a double with the motorcycle's gas consumption
	*/
public double getGasConsumption(){
return gasConsumption;
}

/** Setter method for modifying the motorcycle's gas consumption<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the motorcycle's gas consumption <br>
	@param gasConsumption, a double with the motorcycle's gas consumption
	*/
public void setGasConsumption(double gasConsumption){
this.gasConsumption=gasConsumption;
}
}