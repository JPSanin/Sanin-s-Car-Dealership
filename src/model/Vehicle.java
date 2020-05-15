package model;
import java.util.*;
import java.time.LocalDate; 
public abstract class Vehicle{


//Vehicle attributes
private double totalSalesPrice;
private double basePrice;
private String brand;
private int model;
private int engineDisplacement;
private int mileage;
private boolean isNew;
private String licensePlate;
private Client owner;
private ArrayList<Document> documents;
private LocalDate date;

//Constructor
/** Constructor method for a vehicle <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a vehicle and initializes its attributes, with special owner<br>
	@param basePrice, a double with the base price
	@param brand, a String with the brand
	@param model, an int with the year model
	@param engineDisplacement, an int with the engine displacement
	@param mileage,  an int with the mileage
	@param isNew,  a boolean representing the vehicles condition
	@param licensePlate, a String with the licensePlate
	*/
public Vehicle(double basePrice,String brand,int model,int engineDisplacement,int mileage,boolean isNew,String licensePlate){
this.basePrice=basePrice;
this.brand=brand;
this.model=model;
this.engineDisplacement=engineDisplacement;
this.mileage=mileage;
this.isNew=isNew;
if(isNew==true){
this.licensePlate="Unassigned";
}else{
this.licensePlate=licensePlate;
}
/*Special owner, the dealership, owns all the cars that are 
going to be sold. If a vehicle is owned by someone other than the
dealership it has been sold and it must not be displayed for sale
*/
owner= new Client("Sanin's","Dealership", 1193393239, 1187287343,"saninsdealership@gmail.com");
documents=new ArrayList<Document>();
date= LocalDate.now();
}



public abstract void calculatePrice(double discount);

/** Method for showing vehicle description<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the description<br>	
	*/
public String description(){
String info="";
info+= "Brand: "+brand;
info+= "\nModel: "+model;
info+= "\nEngine displacement: "+engineDisplacement;
info+= "\nMileage: "+mileage;
if(isNew==true){
info+= "\nCondition: NEW ";	
}else{
info+= "\nCondition: USED ";		
}
info+= "\nLicense plate: "+licensePlate;
info+= "\nDocuments: "+showDocuments();
return info;	
}

/** Method for adding documents <br>
	<b> pre: </b> <br>
	<b> post: </b> adds a document to the arraylist of documents <br>
	@param document, a document object that has been created 
	@return a String with the confirmation
	*/
public String addDocument(Document document){
String confirmation="";
boolean added=false;
if(documents.isEmpty()){
documents.add(document);
confirmation="The document was added successfully to the vehicles documents";	
}else{
for(int i=1; i<=documents.size()&& added==false; i++){
//System.out.println(1);
if(document.getYear()>=documents.get(documents.size()-i).getYear()){
documents.add(documents.size(),document);
added=true;
confirmation="The document was added successfully to the vehicles documents";		
}else{
documents.add(0,document);
added=true;
confirmation="The document was added successfully to the vehicles documents";
}
}	
}
return confirmation;	
}



/** Method for showing documents<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the all the documents<br>	
	*/
public String showDocuments(){
String info="";
if(documents.isEmpty()){
info="The vehicle has no documents";	
}else{
for(int i=0; i<documents.size(); i++){
info+="\n"+(i+1)+") "+documents.get(i).printInfo();	
}	
}
return info;
}
	
/** Method for assigning an owner<br>
	<b> pre: </b> <br>
	<b> post: </b> assigns a owner to vehicle<br>
	@param client, a client object that has been created 
	@return a String with the confirmation
	*/
public String assignOwner(Client client){
String confirmation="";	
owner=client;
confirmation="Congratulations "+client.getName()+ " "+ client.getLastName()+ " for your purchase";
return confirmation;
}



//Getters and Setters
/** Getter method for accessing the vehicle's total sales price <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's total sales price<br>
	@return a double with the vehicle's total sales price
	*/
public double getTotalSalesPrice(){
return totalSalesPrice;
}

/** Setter method for modifying the vehicle's total sales price<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's total sales price<br>
	@param totalSalesPrice, a double with the vehicle's total sales price
	*/
public void setTotalSalesPrice(double totalSalesPrice){
this.totalSalesPrice=totalSalesPrice;
}

/** Getter method for accessing the vehicle's base price <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's  base price<br>
	@return a double with the vehicle's base price
	*/
public double getBasePrice(){
return basePrice;
}

/** Setter method for modifying the vehicle's base price<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's  base price<br>
	@param basePrice, a double with the vehicle's base price
	*/
public void setBasePrice(double basePrice){
this.basePrice=basePrice;
}

/** Getter method for accessing the vehicle's brand <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's brand<br>
	@return a String with the vehicle's brand
	*/
public String getBrand(){
return brand;
}

/** Setter method for modifying the vehicle's brand<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's brand<br>
	@param brand, a String with the vehicle's brand
	*/
public void setBrand(String brand){
this.brand=brand;
}

/** Getter method for accessing the vehicle's model <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's model<br>
	@return an int with the vehicle's model
	*/
public int getModel(){
return model;
}

/** Setter method for modifying the vehicle's model<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's model<br>
	@param model, a int with the vehicle's model
	*/
public void setModel(int model){
this.model=model;
}

/** Getter method for accessing the vehicle's engine displacement<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's engine displacement<br>
	@return an int representing the vehicle's engine displacement
	*/
public int getEngineDisplacement(){
return engineDisplacement;
}

/** Setter method for modifying the vehicle's engine displacement<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's engine displacement<br>
	@param engineDisplacement, an int with the vehicle's engine displacement
	*/
public void setEngineDisplacement(int engineDisplacement){
this.engineDisplacement=engineDisplacement;
}

/** Getter method for accessing the vehicle's mileage<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's mileage<br>
	@return an int representing the vehicle's mileage
	*/
public int getMileage(){
return mileage;
}

/** Setter method for modifying the vehicle's mileage<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's mileage<br>
	@param mileage, an int with the vehicle's mileage
	*/
public void setMileage(int mileage){
this.mileage=mileage;
}

/** Getter method for accessing the vehicle's condition (new/used)<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's condition (new/used)<br>
	@return a boolean representing the vehicle's condition (new/used)
	*/
public boolean getIsNew(){
return isNew;
}


/** Setter method for modifying the vehicle's condition (new/used)<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's condition (new/used)<br>
	@param isNew, a boolean with the vehicle's condition (new/used)
	*/
public void setIsNew(boolean isNew){
this.isNew=isNew;
}

/** Getter method for accessing the vehicle's license plate <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the vehicle's license plate<br>
	@return a String with the vehicle's license plate
	*/
public String getLicensePlate(){
return licensePlate;
}

/** Setter method for modifying the vehicle's license plate<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the vehicle's license plate<br>
	@param licensePlate, a String with the vehicle's license plate
	*/
public void setLicensePlate(String licensePlate){
this.licensePlate=licensePlate;
}


/** Getter method for accessing the date <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the date<br>
	@return a Local Date object with the date
	*/
public LocalDate getDate(){
	return date;
}

/** Getter method for accessing the arraylist of documents <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the arraylist of documents<br>
	@return an arraylist of documents
	*/
public ArrayList<Document> getDocuments(){
return(documents);
}

/** Getter method for accessing  the owner <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the owner<br>
	@return the owner
	*/
public Client getOwner(){
return owner;
}
}