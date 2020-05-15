
package model;
import java.util.*;
public class CarDealership{



//Dealership constants
private final static int EMPLOYEES=10;
private final static int PARKING_ROWS=10;
private final static int PARKING_COLUMNS=5;

//Dealership attributes
private String name;
private int nit;
private double totalEarnings;
private int totalSales;
private Salesman[] salesmen;
private Car[][] oldParking;
private ArrayList<Vehicle> vehicles;
private ArrayList<Vehicle> catalog;



// Constructor
 /** Constructor method for a CarDealership <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a CarDealership and initializes its attributes, with 10 employees<br>
	@param name, a name for the cargo, must be a String !=null or !=" "
	@param nit, an int representing the nit of the company
	*/
public CarDealership(String name, int nit){
this.name=name;
this.nit=nit;
totalEarnings=0;
totalSales=0;

salesmen= new Salesman[EMPLOYEES];
//Dealership employees are created
salesmen[0]=new Salesman("Andrew", "Wiggins",2785622);
salesmen[1]=new Salesman("Sue", "Bird",3478990);
salesmen[2]=new Salesman("Steve", "Kerr",23007855);
salesmen[3]=new Salesman("Jamal", "Crawford",47928733);
salesmen[4]=new Salesman("Diana", "Taurasi",9942877);
salesmen[5]=new Salesman("Sabrina", "Ionescu",128429);
salesmen[6]=new Salesman("Paul", "Pierce",34342211);
salesmen[7]=new Salesman("Kevin", "Garnett",55212199);
salesmen[8]=new Salesman("Cole", "Anthony",23114566);
salesmen[9]=new Salesman("Candace", "Parker",119965743);

oldParking= new Car[PARKING_ROWS][PARKING_COLUMNS];
vehicles= new ArrayList<Vehicle>();
catalog= new ArrayList<Vehicle>();
}

//Operational Methods
 /** Method for adding vehicles <br>
	<b> pre: </b> <br>
	<b> post: </b> adds a vehicle to the arraylist of vehicles <br>
	@param vehicle, a vehicle object that has been created 
	@return a String with the confirmation
	*/
public String addVehicle(Vehicle vehicle){
String confirmation="";
vehicle.calculatePrice(0.0);
vehicles.add(vehicle);
confirmation="The vehicle was added successfully to the dealership";
return confirmation;
}

 /** Method for adding cars to parking lot<br>
	<b> pre: </b> <br>
	<b> post: </b> adds a car to the parking lot if not full and meets conditions <br>
	@param car, a car object that has been created 
	@return a String with the confirmation
	*/
public String addToParking(Car car){
/*Old Parking Conditions, 1st Column(2014), 2nd Column(2013), 3rd Column(2012)
4th Column(2011),5th Column(2010 and below) 
*/
car.calculatePrice(0.0);
int carModel= car.getModel();
boolean isNew= car.getIsNew();
boolean added=false;
String confirmation="";

if(carModel>2014){
confirmation="The car cannot be added to the old parking because the model is newer than 2014";
}else if(isNew==true){
confirmation="The car cannot be added to the old parking because it is new"	;
}else if(carModel==2014){
for(int i=0; i<PARKING_ROWS && added==false; i++){
if(oldParking[i][0]==null){
oldParking[i][0]=car;
added=true;	
confirmation="The car was added successfully to the old parkings' first column";
}else{
confirmation="The car cannot be added because parking is full please hire someone to expand parking ";	
}
}	
}else if(carModel==2013){
for(int i=0; i<PARKING_ROWS && added==false; i++){
if(oldParking[i][1]==null){
oldParking[i][1]=car;
added=true;	
confirmation="The car was added successfully to the old parkings' second column";
}else{
confirmation="The car cannot be added because parking is full please hire someone to expand parking ";	
}
}	
}else if(carModel==2012){
for(int i=0; i<PARKING_ROWS && added==false; i++){
if(oldParking[i][2]==null){
oldParking[i][2]=car;
added=true;	
confirmation="The car was added successfully to the old parkings' third column";
}else{
confirmation="The car cannot be added because parking is full please hire someone to expand parking ";	
}
}
}else if(carModel==2011){
for(int i=0; i<PARKING_ROWS && added==false; i++){
if(oldParking[i][3]==null){
oldParking[i][3]=car;
added=true;	
confirmation="The car was added successfully to the old parkings' fourth column";
}else{
confirmation="The car cannot be added because parking is full please hire someone to expand parking ";	
}
}	
}else if(carModel<2011){
for(int i=0; i<PARKING_ROWS && added==false; i++){
if(oldParking[i][4]==null){
oldParking[i][4]=car;
added=true;
confirmation="The car was added successfully to the old parkings' fifth column";	
}else{
confirmation="The car cannot be added because parking is full please hire someone to expand parking ";	
}
}	
}
return confirmation;
}


/** Method for removing cars from parking lot<br>
	<b> pre: </b> <br>
	<b> post: </b> removes a car to the parking lot if not empty <br>
	@param car, a car object that has been created 
	@return a String with the confirmation
	*/
public String removeFromParking(Vehicle vehicle){
//Method for getting rid of old cars when they are sold
boolean removed=false;
String confirmation="";
for(int i=0; i<PARKING_ROWS; i++){
for(int j=0; j<PARKING_COLUMNS && removed==false; j++){
if(vehicle==oldParking[i][j]){
oldParking[i][j]=null;
removed=true;
confirmation="The car has been sold succesfully\n";
}else{
confirmation="The car was not found";	
}
}
}
return confirmation;
}



/** Method for showing salesmen<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the all the salesmen<br>	
	*/
public String showSalesmen(){
String info="";
for(int i=0; i<EMPLOYEES; i++){
info+=i+1+") "+salesmen[i].getName()+" "+salesmen[i].getLastName()+"\n";
}
return info;
}

 /** Method for adding cars to catalog<br>
	<b> pre: </b> <br>
	<b> post: </b> adds a vehicle to catalog <br>
	@param vehicle, a vehicle object that has been created 

	*/
public void addToCatalog(Vehicle vehicle){
vehicle.calculatePrice(0.0);
catalog.add(vehicle);
}


/** Method for selling vehicles<br>
	<b> pre: </b> <br>
	<b> post: </b> removes a car to the parking lot if not empty <br>
	@param car, a car object that has been created 
	@return a String with the confirmation
	*/
public String sell(Vehicle vehicle, int salesman){
String confirmation="";
if(vehicle instanceof Car && vehicle.getIsNew()==false && vehicle.getModel()<=2014){
confirmation+=removeFromParking(vehicle);	
}
totalEarnings+= vehicle.getTotalSalesPrice();
totalSales+=1;
int sales=salesmen[salesman].getTotalSales();
sales+=1;
salesmen[salesman].setTotalSales(sales);
confirmation="Company sales updated";
return confirmation;
}

/** Method for showing company information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the company information<br>	
	*/
public String showCompanyInfo(){
String info="";
info+="\nCompany Information\n";
info+="Name: "+ name+"\n";
info+="NIT: "+nit+"\n";
info+="Total earnings: "+ totalEarnings+"\n";
info+="Total sales: "+ totalSales;
return info;
}

/** Method for showing catalog<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the catalog<br>	
	*/
public String showCatalog(){
String info="";
if(catalog.isEmpty()){
info="There are no vehicles in stock for this filter";
}else{
for(int i=0; i< catalog.size(); i++){
info+="\n----------------------------\n";
info+="---------Vehicle "+(i+1)+"---------\n";		
info+="----------------------------\n";	
info+=catalog.get(i).description();
}	
}
return info;
}

 /** Method for filtering old cars and adding them to catalog<br>
	<b> pre: </b> <br>
	<b> post: </b> filters old cars and adds them to catalog <br>
	*/
public void catalogOldCars(int option,int filter){
for(int i=0; i<PARKING_COLUMNS;i++){
switch(option){
case 1:
if(filter==2014){
if(oldParking[i][0]!=null){

addToCatalog(oldParking[i][0]);
}

}else if(filter==2013){
if(oldParking[i][1]!=null){

addToCatalog(oldParking[i][1]);	
}
}else if(filter==2012){
if(oldParking[i][2]!=null){

addToCatalog(oldParking[i][2]);		
}	
}else if(filter==2011){
if(oldParking[i][3]!=null){

addToCatalog(oldParking[i][3]);		
}	
}else if(filter<2011){
if(oldParking[i][4]!=null){
if(oldParking[i][4].getModel()==filter){
addToCatalog(oldParking[i][4]);	
}	
}	
}
break;

case 2:
if(filter==1){
	
}else if (filter ==2){
if(oldParking[i][0]!=null){
if(oldParking[i][0] instanceof Gas){	
addToCatalog(oldParking[i][0]);
}
}
if(oldParking[i][1]!=null){
if(oldParking[i][1] instanceof Gas){	
addToCatalog(oldParking[i][1]);
}
}
if(oldParking[i][2]!=null){
if(oldParking[i][2] instanceof Gas){	
addToCatalog(oldParking[i][2]);
}
}
if(oldParking[i][3]!=null){
if(oldParking[i][3] instanceof Gas){	
addToCatalog(oldParking[i][3]);
}
}
if(oldParking[i][4]!=null){
if(oldParking[i][4] instanceof Gas){	
addToCatalog(oldParking[i][4]);
}
}		
}else if (filter ==3){
if(oldParking[i][0]!=null){
if(oldParking[i][0] instanceof Hybrid){	
addToCatalog(oldParking[i][0]);
}
}
if(oldParking[i][1]!=null){
if(oldParking[i][1] instanceof Hybrid){	
addToCatalog(oldParking[i][1]);
}
}
if(oldParking[i][2]!=null){
if(oldParking[i][2] instanceof Hybrid){	
addToCatalog(oldParking[i][2]);
}
}
if(oldParking[i][3]!=null){
if(oldParking[i][3] instanceof Hybrid){	
addToCatalog(oldParking[i][3]);
}
}
if(oldParking[i][4]!=null){
if(oldParking[i][4] instanceof Hybrid){	
addToCatalog(oldParking[i][4]);
}
}

}else{
if(oldParking[i][0]!=null){
if(oldParking[i][0] instanceof Electric){	
addToCatalog(oldParking[i][0]);
}
}
if(oldParking[i][1]!=null){
if(oldParking[i][1] instanceof Electric){	
addToCatalog(oldParking[i][1]);
}
}
if(oldParking[i][2]!=null){
if(oldParking[i][2] instanceof Electric){	
addToCatalog(oldParking[i][2]);
}
}
if(oldParking[i][3]!=null){
if(oldParking[i][3] instanceof Electric){	
addToCatalog(oldParking[i][3]);
}
}
if(oldParking[i][4]!=null){
if(oldParking[i][4] instanceof Electric){	
addToCatalog(oldParking[i][4]);
}
}

	
}


break;

case 3:

if (filter==2){
if(oldParking[i][0]!=null){
addToCatalog(oldParking[i][0]);	
}

if(oldParking[i][1]!=null){
addToCatalog(oldParking[i][1]);
}

if(oldParking[i][2]!=null){	
addToCatalog(oldParking[i][2]);
}

if(oldParking[i][3]!=null){
addToCatalog(oldParking[i][3]);
}
if(oldParking[i][4]!=null){	
addToCatalog(oldParking[i][4]);
}
}

break;	
}
}
}


/** Method for filtering vehicles and adding them to catalog<br>
	<b> pre: </b> <br>
	<b> post: </b> filters vehicles and adds them to catalog <br>
	*/
public void catalogVehicles(int option,int filter){
/*
option=1 model check
option=2 type
option=3 condition
*/

for(int i=0; i<vehicles.size();i++){
if(vehicles.get(i).getOwner().getName().equals("Sanin's")){
switch(option){
	
case 1:
if(vehicles.get(i).getModel()==filter){
addToCatalog(vehicles.get(i));
}

break;	

case 2:
if(filter==1){
if(vehicles.get(i) instanceof Motorcycle){
addToCatalog(vehicles.get(i));	
}

}else if(filter==2){
if(vehicles.get(i) instanceof Gas){
addToCatalog(vehicles.get(i));	
}
}else if(filter==3){
if(vehicles.get(i) instanceof Hybrid){
addToCatalog(vehicles.get(i));	
}
}else if(filter==4){
if(vehicles.get(i) instanceof Electric){
addToCatalog(vehicles.get(i));	
}
}
break;
case 3:
if(filter==1){
if(vehicles.get(i).getIsNew()==true){
addToCatalog(vehicles.get(i));
}
}else{
if(vehicles.get(i).getIsNew()==false){
addToCatalog(vehicles.get(i));
}	
}

break;
	
}
}
}
}

//Getters and Setters

/** Getter method for accessing the Dealership's  name <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the Dealership's  name<br>
	@return a String with the name of the Dealership
	*/
public String getName(){
return name;
}

/** Setter method for modifying the Dealership's name<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the Dealership's name<br>
	@param name, a String with the Dealership's name
	*/
public void setName(String name){
this.name=name;
}

/** Getter method for accessing the Dealership's nit<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the Dealership's nit<br>
	@return an int with the Dealership's nit
	*/
public int getNit(){
return nit;
}

/** Setter method for modifying the Dealership's nit<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the Dealership's nit<br>
	@param nit, an int with the Dealership's nit
	*/
public void setNit(int nit){
this.nit=nit;
}

/** Getter method for accessing the dealership's total earnings<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the dealership's total earnings<br>
	@return a double with the dealership's total earnings
	*/
public double getTotalEarnings(){
return totalEarnings;
}

/** Setter method for modifying the dealership's total earnings<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the dealership's total earnings<br>
	@param totalEarnings, a double with the dealership's total earnings
	*/
public void setTotalEarnings(double totalEarnings){
this.totalEarnings=totalEarnings;
}

/** Getter method for accessing the dealership's total sales<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the dealership's total sales<br>
	@return an int with the dealership's total sales
	*/
public int getTotalSales(){
return totalSales;
}

/** Setter method for modifying the dealership's total sales<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the dealership's total salesbr>
	@param totalSales, an int with the dealership's total sales
	*/
public void setTotalSales(int totalSales){
this.totalSales=totalSales;
}

/** Getter method for accessing the dealership's salesmen<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the dealership's salesmen<br>
	@return an object array with the dealership's salesmen
	*/
public Salesman getSalesman(int i){
return salesmen[i];
}

/** Getter method for accessing the vehicles <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the arraylist of vehicles<br>
	@return an arraylist of vehicles
	*/
public ArrayList<Vehicle> getVehicles(){
return(vehicles);
}

/** Getter method for accessing a vehicle <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to a vehicle<br>
	@return a vehicle
	*/
public Vehicle getVehicle(int i){
return(vehicles.get(i));
}

/** Getter method for accessing the Catalog <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the arraylist of Catalog<br>
	@return an arraylist of vehicles
	*/
public ArrayList<Vehicle> getCatalog(){
return(catalog);
}
}