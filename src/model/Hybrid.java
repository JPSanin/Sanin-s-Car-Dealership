package model;
import java.util.*;
public class Hybrid extends Car implements GasConsumption, BatteryConsumption{
	
//Price Constants
private final static double MISSING_DOCS=500.00;
private final static double USED_DISCOUNT=0.1;
private final static double HYBRID_INCREASE=0.15;	

//Hybrid attributes
private int tankCapacity;
private String gasType;
private double gasConsumption;
private boolean fastCharger;
private double batteryDuration;
private double batteryConsumption;

//Constructor
/** Constructor method for a Hybrid car <br>
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
	@param fastCharger,  a boolean representing the cars charger
	@param batteryDuration, a double with the battery duration
	*/
public Hybrid(double basePrice,String brand,int model,int engineDisplacement,int mileage,boolean isNew,
String licensePlate,String type,int doors,boolean tintedWindows,int tankCapacity, String gasType,boolean fastCharger,double batteryDuration ){
	
super(basePrice,brand, model, engineDisplacement, mileage, isNew,
 licensePlate, type, doors, tintedWindows);
this.tankCapacity=tankCapacity;
this.gasType=gasType;
this.fastCharger=fastCharger;
this.batteryDuration=batteryDuration;

}

//override methods
/** Method for calculating hybrid car final price<br>
		
	<b> pre: </b> <br>
	<b> post: </b>calculates the final price with an optional discount<br>	
	@param discount,  a double with a discount
	*/
@Override
public void calculatePrice(double discount) {

//For Hybrid Car missing docs 500, increase 15%, used discount 10%
int nowYear= super.getDate().getYear();
ArrayList<Document> docs;
docs=super.getDocuments();
double finalPrice=super.getBasePrice();
if(docs.isEmpty()||docs.size()==1){
finalPrice+=MISSING_DOCS;	
}else if(docs.get(docs.size()-1).getYear()!=nowYear || docs.get(docs.size()-2).getYear()!=nowYear){
finalPrice+=MISSING_DOCS;
}

finalPrice+= super.getBasePrice()*HYBRID_INCREASE;

if(super.getIsNew()==false){
finalPrice-= finalPrice*USED_DISCOUNT;
}

finalPrice-= finalPrice*discount;

super.setTotalSalesPrice(finalPrice);

}


/** Method for showing hybrid car description<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the description<br>	
	*/
@Override
public String description() {
calculateGasConsumption();
calculateBatteryConsumption();

String info="";
info+="\nHybrid Car\n";
info+=super.description();	
info+= "\nTank capacity: "+tankCapacity;
info+= "\nGas type: "+gasType;		
info+= "\nGas consumption: "+gasConsumption;
if(fastCharger==true){
info+= "\nCharger: Fast ";	
}else{
info+= "\nCondition: Normal";		
}
info+= "\nBattery duration: "+batteryDuration;		
info+= "\nBattery consumption: "+batteryConsumption;	
info+="\nBase price: "+super.getBasePrice();
info+="\nFinal price: "+super.getTotalSalesPrice();
return info;
}


/** Method for calculating car battey consumption<br>
		
	<b> pre: </b> <br>
	<b> post: </b>calculates the battery consumption<br>	
	*/
@Override
public void calculateBatteryConsumption(){
if(fastCharger){
batteryConsumption=(batteryDuration)*(super.getEngineDisplacement()/100.0);	
}else{
batteryConsumption=(batteryDuration+5.0)*(super.getEngineDisplacement()/100.0);	
}	
}

/** Method for calculating car gas consumption<br>
		
	<b> pre: </b> <br>
	<b> post: </b>calculates the gas consumption<br>	
	*/
@Override
public void calculateGasConsumption(){
gasConsumption=(tankCapacity)*(super.getEngineDisplacement()/110.0);		
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

/** Getter method for accessing the charger(fast/normal)<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the charger(fast/normal)<br>
	@return a boolean representing the charger(fast/normal)
	*/
public boolean getFastCharger(){
return fastCharger;
}


/** Setter method for modifying the charger(fast/normal)<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the charger(fast/normal)<br>
	@param fastCharger, a boolean with the charger(fast/normal)
	*/
public void setFastCharger(boolean fastCharger){
this.fastCharger=fastCharger;
}

/** Getter method for accessing the  battery consumption <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the  battery consumption<br>
	@return a double with the  battery consumption
	*/
public double getBatteryConsumption(){
return batteryConsumption;
}

/** Setter method for modifying the  battery consumption<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the  battery consumption <br>
	@param batteryConsumption, a double with the  battery consumption
	*/
public void setBatteryConsumption(double batteryConsumption){
this.batteryConsumption=batteryConsumption;
}


/** Getter method for accessing the  battery duration <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the  battery duration<br>
	@return a double with the  battery duration
	*/
public double getBatteryDuration(){
return batteryDuration;
}

/** Setter method for modifying the  battery duration<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the  battery duration <br>
	@param batteryDuration, a double with the  battery duration
	*/
public void setBatteryDuration(double batteryDuration){
this.batteryDuration=batteryDuration;
}

}