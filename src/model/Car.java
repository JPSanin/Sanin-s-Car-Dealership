package model;

public abstract class Car extends Vehicle{
//Price constants
private final static double MISSING_DOCS=500.00;
private final static double USED_DISCOUNT=0.1;

//Car attributes
private String type;
private int doors;
private boolean tintedWindows;

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
	*/
public Car(double basePrice,String brand,int model,int engineDisplacement,int mileage,boolean isNew,String licensePlate,String type,int doors,boolean tintedWindows){
super(basePrice,brand,model, engineDisplacement, mileage, isNew,licensePlate);
this.type=type;
this.doors=doors;
this.tintedWindows=tintedWindows;
}

//Methods



/** Method for showing car description<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the description<br>	
	*/
@Override
public String description() {
String info="";
info+=super.description();
info+= "\nType: "+type;	
info+= "\nDoors: "+doors;	
if(tintedWindows==true){
info+= "\nTinted windows: YES";	
}else{
info+= "\nTinted windows: NO";		
}

return info;
}



//Getters and Setters
/** Getter method for accessing the car's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the car's type<br>
	@return a String representing the car's type
	*/
public String getType(){
return type;
}

/** Setter method for modifying the car's type<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the car's type<br>
	@param type, a String with the car's type
	*/
public void setType(String type){
this.type=type;
}


/** Getter method for accessing the car's doors<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the car's doors<br>
	@return an int representing the car's doors
	*/
public int getDoors(){
return doors;
}

/** Setter method for modifying the car's doors<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the car's doors<br>
	@param doors, an int with the car's doors
	*/
public void setDoors(int doors){
this.doors=doors;
}	

/** Getter method for accessing the car's windows (tinted/not tinted)<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the car's windows (tinted/not tinted)<br>
	@return a boolean representing the car's windows (tinted/not tinted)
	*/
public boolean getTintedWindows(){
return tintedWindows;
}


/** Setter method for modifying the car's windows (tinted/not tinted)<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the car's windows (tinted/not tinted)<br>
	@param tintedWindows, a boolean with the car's windows (tinted/not tinted)
	*/
public void setTintedWindows(boolean tintedWindows){
this.tintedWindows=tintedWindows;
}
}