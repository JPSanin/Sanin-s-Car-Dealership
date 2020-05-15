package ui;
import model.*;
import java.util.*;

public class Menu{

//Menu option constants
//Menu 1
private final static int ADMIN=1;
private final static int SALESMAN=2;
private final static int EXIT=3;
//Salesman menu 
private final static int SELECT_CLIENT=1;
private final static int ADD_CLIENT=2;
private final static int REMOVE_CLIENT=3;

//Vehicle filtering constants
private final static int MODEL=1;
private final static int VEHICLE_TYPE=2;
private final static int CONDITION=3;


//Admin menu 
private final static int ADD_VEHICLE=1;
private final static int VIEW_SALESMAN_INFO=2;
private final static int VIEW_COMPANY_INFO=3;
private final static int ADMIN_EXIT=4;

//Vehicle Constants 
private final static int MOTORCYCLE=1;
private final static int GAS_CAR=2;
private final static int HYBRID_CAR=3;
private final static int ELECTRIC_CAR=4;

private final static int CLIENT_INFO=1;
private final static int SHOW_CATALOG=2;
private final static int SHOW_WISHLIST=3;

//
private CarDealership saninsDealership ;
private int salesman;

 /** Constructor method for menu <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a menu and creates vehicles <br>
	*/
public Menu(){
saninsDealership= new CarDealership("Sanin's Motor Dealership", 118923922);
salesman=0;
}

/** Method for showing welcome message <br>
		
	<b> pre: </b> <br>
	<b> post: </b> Prints a welcome message<br>	
	*/
public void showWelcome(){
System.out.println("\nWelcome to Sanin's Motor Dealership app ");
}

/** Method for adding initial vehicles<br>
		
	<b> pre: </b> <br>
	<b> post: </b> adds vehicles to dealership<br>	
	*/
public void initialVehicles(){
saninsDealership.addVehicle(new  Motorcycle(55000.00,"Ducatti",2019,1600,0,true,"","Sport",5.5));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(220.00,2020, 5000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(150.00,2020, 200.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);

saninsDealership.addVehicle(new Gas(500000.00,"Lamborghini",2020,2400,0,true,"","Sport",2,true,12, "Extra"));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(400.00,2020, 10000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(300.00,2020, 400.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);

saninsDealership.addVehicle(new Electric(100000.00,"Tesla",2014,1800,0,true,"","Sedan",4,true,true, 15.5));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(300.00,2020, 7000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(150.00,2020, 30.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);

saninsDealership.addVehicle(new Hybrid(150000.00,"Kia",2017,1600,0,true,"","Sedan",4,false,7, "Regular",false,8.3 ));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(280.00,2020, 4000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(120.00,2020, 50.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);

saninsDealership.addVehicle(new  Motorcycle(9000.00,"Honda",2016,1300,1000,false,"SZS-922","Standard",3.5));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(300.00,2020, 5000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(150.00,2020, 100.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(280.00,2019, 4000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(140.00,2019, 65.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(260.00,2018, 3000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(120.00,2018, 30.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);

saninsDealership.addVehicle(new Gas(100000.00,"Ford",2020,2000,0,true,"","Truck",6,true,15, "Diesel"));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);

saninsDealership.addVehicle(new Electric(300000.00,"Porsche",2019,2000,0,true,"","Sport",2,true,true, 9.3));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);


saninsDealership.addVehicle(new Gas(30000.00,"Chevrolet",2015,1300,600,false,"JHZ-346","Hatchback",4,true,8, "Regular"));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(260.00,2015, 5000.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(120.00,2015, 100.00));
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);

saninsDealership.addToParking(new Gas(20000.00,"Nissan",2014,1200,2200,false,"TJT-234","Sedan",4,true,6, "Regular"));
saninsDealership.addToParking(new Gas(18000.00,"Renault",2013,1000,1200,false,"RTT-635","Sedan",4,true,5, "Regular"));
saninsDealership.addToParking(new Gas(12000.00,"Hyundai",2012,800,1000,false,"GHX-687","Sedan",4,false,4, "Regular"));
saninsDealership.addToParking(new Gas(12000.00,"Chevrolet",2011,800,3000,false,"EFG-665","Sedan",4,false,4, "Regular"));
saninsDealership.addToParking(new Gas(9000.00,"Daewoo",2009,800,22000,false,"RTX-841","Sedan",2,false,4, "Regular"));

}

/** Method for showing first menu<br>
		
	<b> pre: </b> <br>
	<b> post: </b> Prints a first menu<br>	
	*/
public void firstMenu(){
System.out.println("\nPlease select the number that represents your job title or exit program");
System.out.println("1) Administrator");
System.out.println("2) Salesman");
System.out.println("3) EXIT");
}

/** Method for showing admin menu<br>
		
	<b> pre: </b> <br>
	<b> post: </b> Prints a admin menu<br>	
	*/
public void adminMenu(){
System.out.println("\nHello Administrator, select the option that represents what you would like to do");
System.out.println("1) Add Vehicle");
System.out.println("2) View Salesman Information");
System.out.println("3) View Company Information");
System.out.println("4) EXIT");
}

/** Method for reading a selection<br>
		
	<b> pre: </b>Previously showing the options <br>
	<b> post: </b> Reads an a selected option and returns it <br>	
	@return a int of the selected option ;
	*/
public int readOption(){
Scanner sc = new Scanner(System.in);
int option= sc.nextInt();
sc.nextLine();
return option;
}


/** Method for doing administrators actions<br>
		
	<b> pre: </b> <br>
	<b> post: </b> Admin side of program can function <br>	

	*/
public void adminActions(){
int option;
do{
adminMenu();
option=readOption();
switch(option){
case ADD_VEHICLE:
addVehicle();
break;

case VIEW_SALESMAN_INFO:
viewSalesman();

break;

case VIEW_COMPANY_INFO:
System.out.println(saninsDealership.showCompanyInfo());
break;

}
if(option>ADMIN_EXIT){
System.out.println("\nPlease select a valid option");
}
}while(option !=ADMIN_EXIT);
}

/** Method for viewing salesman information<br>
		
	<b> pre: </b> <br>
	<b> post: </b> salesman information is shown <br>	

	*/
public void viewSalesman(){
int option;	
do{
System.out.println("\nPlease select the salesman's information who you would like to view");
System.out.println(saninsDealership.showSalesmen());
option=readOption();
if(option>10){
System.out.println("\nPlease select a valid option");
}else{
System.out.println(saninsDealership.getSalesman(option-1).salesmanInformation());		
}
}while(option>10);
}

/** Method for adding a vehicle<br>
		
	<b> pre: </b> <br>
	<b> post: </b> A vehicle is created with the options the client selects<br>
	*/
public void addVehicle(){
System.out.println("\nYou have decided to add a vehicle");
Scanner sc2 = new Scanner(System.in);
int type;
do{
System.out.println("\nPlease select the type of vehicle");
System.out.println("1) Motorcycle");
System.out.println("2) Gas Car");
System.out.println("3) Hybrid Car");
System.out.println("4) Electric Car");
type=sc2.nextInt();
sc2.nextLine();
if(type>4){
System.out.println("Please select a valid option");
}
}while(type>4);	

switch(type){
case MOTORCYCLE:
addMotorcycle();
break;

case GAS_CAR:
addGasCar();
break;

case HYBRID_CAR:
addHybridCar();
break;

case ELECTRIC_CAR:
addElectricCar();
break;
	
}
}

/** Method for adding a motorcycle<br>
		
	<b> pre: </b> <br>
	<b> post: </b> A motorcycle is created with the options the client selects<br>
	*/
public void addMotorcycle(){
System.out.println("\nYou have decided to add a motorcycle");

//Doubles
Scanner sc = new Scanner(System.in);
//Strings
Scanner sc2 = new Scanner(System.in);
//Ints
Scanner sc3 = new Scanner(System.in);
int option;
boolean isNew;
double price;
String brand="";
int model;
int engineDisplacement;
int mileage;
String licensePlate="";
String type;
double gasCapacity;


do{
System.out.println("\nIs the motorcycle new or used");
System.out.println("1) New");
System.out.println("2) Used");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);	

if(option==1){
isNew=true;	
System.out.println("\nWhat is the motorcycle's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the motorcycle's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the motorcycle's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the motorcycle's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

mileage=0;
licensePlate="";

do{
System.out.println("\nWhat type of motorcycle is it");
System.out.println("1) Standard");
System.out.println("2) Sport");
System.out.println("3) Scooter");
System.out.println("4) Cross");
option=sc3.nextInt();
sc3.nextLine();
if(option>4){
System.out.println("Please select a valid option");
}
}while(option>4);	
if(option==1){
type="Standard";	
}else if(option==2){
type="Sport";	
}else if(option==3){
type="Scooter";	
}else{
type="Cross";		
}
System.out.println("\nWhat is the motorcycle's gas capacity");
gasCapacity=sc.nextDouble();
sc.nextLine();

}else{
isNew=false;	
System.out.println("\nWhat is the motorcycle's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the motorcycle's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the motorcycle's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the motorcycle's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the motorcycle's mileage");
mileage=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the motorcycle's license plate");
licensePlate=sc2.nextLine();

do{
System.out.println("\nWhat type of motorcycle is it");
System.out.println("1) Standard");
System.out.println("2) Sport");
System.out.println("3) Scooter");
System.out.println("4) Cross");
option=sc3.nextInt();
sc3.nextLine();
if(option>4){
System.out.println("Please select a valid option");
}
}while(option>4);	
if(option==1){
type="Standard";	
}else if(option==2){
type="Sport";	
}else if(option==3){
type="Scooter";	
}else{
type="Cross";		
}
System.out.println("\nWhat is the motorcycle's gas capacity");
gasCapacity=sc.nextDouble();
sc.nextLine();
	
}

saninsDealership.addVehicle(new  Motorcycle(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,gasCapacity));
addDocs();
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);
System.out.println("\nThe motorcycle has been added successfully");

}

/** Method for adding a gas car<br>
		
	<b> pre: </b> <br>
	<b> post: </b> A gas car is created with the options the client selects<br>
	*/
public void addGasCar(){
System.out.println("\nYou have decided to add a Gas Car");

//Doubles
Scanner sc = new Scanner(System.in);
//Strings
Scanner sc2 = new Scanner(System.in);
//Ints
Scanner sc3 = new Scanner(System.in);
int option;
boolean isNew;
double price;
String brand="";
int model;
int engineDisplacement;
int mileage;
String licensePlate="";
String type;
int doors;
boolean tintedWindows;
int tankCapacity;
String gasType;

do{
System.out.println("\nIs the Gas Car new or used");
System.out.println("1) New");
System.out.println("2) Used");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);

if(option==1){
isNew=true;	
System.out.println("\nWhat is the Gas Car's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the Gas Car's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the Gas Car's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the Gas Car's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

mileage=0;
licensePlate="";

do{
System.out.println("\nWhat type of Gas Car is it");
System.out.println("1) Sedan");
System.out.println("2) Sport");
System.out.println("3) Truck");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
type="Sedan";	
}else if(option==2){
type="Sport";	
}else{
type="Truck";	
}

System.out.println("\nHow many doors does the Gas Car have");
doors=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nDoes the Gas Car have tinted windows");
System.out.println("1) Yes");
System.out.println("2) No");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);
if(option==1){
tintedWindows=true;	
}else{
tintedWindows=false;		
}

System.out.println("\nWhat is the Gas Car's tank capacity");
tankCapacity=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nWhat type of Gasoline does the Gas Car recieve");
System.out.println("1) Regular");
System.out.println("2) Extra");
System.out.println("3) Diesel");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
gasType="Regular";	
}else if(option==2){
gasType="Extra";	
}else{
gasType="Diesel";	
}

saninsDealership.addVehicle(new  Gas(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,tankCapacity,gasType));
addDocs();
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);
System.out.println("\nThe Gas Car has been added successfully");
	
}else{
isNew=false;
System.out.println("\nWhat is the Gas Car's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the Gas Car's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the Gas Car's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the Gas Car's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

mileage=0;
licensePlate="";

do{
System.out.println("\nWhat type of Gas Car is it");
System.out.println("1) Sedan");
System.out.println("2) Sport");
System.out.println("3) Truck");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
type="Sedan";	
}else if(option==2){
type="Sport";	
}else{
type="Truck";	
}

System.out.println("\nHow many doors does the Gas Car have");
doors=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nDoes the Gas Car have tinted windows");
System.out.println("1) Yes");
System.out.println("2) No");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);
if(option==1){
tintedWindows=true;	
}else{
tintedWindows=false;		
}

System.out.println("\nWhat is the Gas Car's tank capacity");
tankCapacity=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nWhat type of Gasoline does the Gas Car recieve");
System.out.println("1) Regular");
System.out.println("2) Extra");
System.out.println("3) Diesel");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
gasType="Regular";	
}else if(option==2){
gasType="Extra";	
}else{
gasType="Diesel";	
}

if(model<2015){
saninsDealership.addToParking(new  Gas(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,tankCapacity,gasType));	
addDocs();
System.out.println("\nThe Gas Car has been added successfully");	
}else{
saninsDealership.addVehicle(new  Gas(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,tankCapacity,gasType));
addDocs();
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);
System.out.println("\nThe Gas Car has been added successfully");	
}
	
}

}

/** Method for adding a hybrid car<br>
		
	<b> pre: </b> <br>
	<b> post: </b> A hybrid car is created with the options the client selects<br>
	*/
public void addHybridCar(){
System.out.println("\nYou have decided to add a Hybrid Car");

//Doubles
Scanner sc = new Scanner(System.in);
//Strings
Scanner sc2 = new Scanner(System.in);
//Ints
Scanner sc3 = new Scanner(System.in);
int option;
boolean isNew;
double price;
String brand="";
int model;
int engineDisplacement;
int mileage;
String licensePlate="";
String type;
int doors;
boolean tintedWindows;
int tankCapacity;
String gasType;
boolean fastCharger;
double batteryDuration;

do{
System.out.println("\nIs the Hybrid Car new or used");
System.out.println("1) New");
System.out.println("2) Used");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);

if(option==1){
isNew=true;	
System.out.println("\nWhat is the Hybrid Car's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the Hybrid Car's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the Hybrid Car's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the Hybrid Car's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

mileage=0;
licensePlate="";

do{
System.out.println("\nWhat type of Hybrid Car is it");
System.out.println("1) Sedan");
System.out.println("2) Sport");
System.out.println("3) Truck");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
type="Sedan";	
}else if(option==2){
type="Sport";	
}else{
type="Truck";	
}

System.out.println("\nHow many doors does the Hybrid Car have");
doors=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nDoes the Hybrid Car have tinted windows");
System.out.println("1) Yes");
System.out.println("2) No");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);
if(option==1){
tintedWindows=true;	
}else{
tintedWindows=false;		
}

System.out.println("\nWhat is the Hybrid Car's tank capacity");
tankCapacity=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nWhat type of Gasoline does the Hybrid Car recieve");
System.out.println("1) Regular");
System.out.println("2) Extra");
System.out.println("3) Diesel");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
gasType="Regular";	
}else if(option==2){
gasType="Extra";	
}else{
gasType="Diesel";	
}

do{
System.out.println("\nWhat type of charger does the Hybrid Car have");
System.out.println("1) Fast");
System.out.println("2) Normal");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);	
if(option==1){
fastCharger=true;	
}else{
fastCharger=false;	
}

System.out.println("\nWhat is the Hybrid Car's batteryDuration");
batteryDuration=sc.nextInt();
sc.nextLine();


saninsDealership.addVehicle(new  Hybrid(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,tankCapacity, gasType, fastCharger,batteryDuration));
addDocs();
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);
System.out.println("\nThe Hybrid Car has been added successfully");
	
}else{
isNew=false;
System.out.println("\nWhat is the Hybrid Car's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the Hybrid Car's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the Hybrid Car's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the Hybrid Car's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

mileage=0;
licensePlate="";

do{
System.out.println("\nWhat type of Hybrid Car is it");
System.out.println("1) Sedan");
System.out.println("2) Sport");
System.out.println("3) Truck");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
type="Sedan";	
}else if(option==2){
type="Sport";	
}else{
type="Truck";	
}

System.out.println("\nHow many doors does the Hybrid Car have");
doors=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nDoes the Hybrid Car have tinted windows");
System.out.println("1) Yes");
System.out.println("2) No");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);
if(option==1){
tintedWindows=true;	
}else{
tintedWindows=false;		
}

System.out.println("\nWhat is the Hybrid Car's tank capacity");
tankCapacity=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nWhat type of Gasoline does the Hybrid Car recieve");
System.out.println("1) Regular");
System.out.println("2) Extra");
System.out.println("3) Diesel");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
gasType="Regular";	
}else if(option==2){
gasType="Extra";	
}else{
gasType="Diesel";	
}


do{
System.out.println("\nWhat type of charger does the Hybrid Car have");
System.out.println("1) Fast");
System.out.println("2) Normal");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);	
if(option==1){
fastCharger=true;	
}else{
fastCharger=false;	
}

System.out.println("\nWhat is the Hybrid Car's batteryDuration");
batteryDuration=sc.nextInt();
sc.nextLine();


if(model<2015){
saninsDealership.addToParking(new  Hybrid(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,tankCapacity, gasType,fastCharger,batteryDuration));	
addDocs();
System.out.println("\nThe Hybrid Car has been added successfully");	
}else{
saninsDealership.addVehicle(new  Hybrid(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,tankCapacity, gasType,fastCharger,batteryDuration));
addDocs();
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);
System.out.println("\nThe Hybrid Car has been added successfully");	
}
	
}	
}

/** Method for adding an electric car<br>
		
	<b> pre: </b> <br>
	<b> post: </b> An electric car is created with the options the client selects<br>
	*/
public void addElectricCar(){
System.out.println("\nYou have decided to add a Electric Car");

//Doubles
Scanner sc = new Scanner(System.in);
//Strings
Scanner sc2 = new Scanner(System.in);
//Ints
Scanner sc3 = new Scanner(System.in);
int option;
boolean isNew;
double price;
String brand="";
int model;
int engineDisplacement;
int mileage;
String licensePlate="";
String type;
int doors;
boolean tintedWindows;
boolean fastCharger;
double batteryDuration;

do{
System.out.println("\nIs the Electric Car new or used");
System.out.println("1) New");
System.out.println("2) Used");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);

if(option==1){
isNew=true;	
System.out.println("\nWhat is the Electric Car's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the Electric Car's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the Electric Car's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the Electric Car's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

mileage=0;
licensePlate="";

do{
System.out.println("\nWhat type of Electric Car is it");
System.out.println("1) Sedan");
System.out.println("2) Sport");
System.out.println("3) Truck");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
type="Sedan";	
}else if(option==2){
type="Sport";	
}else{
type="Truck";	
}

System.out.println("\nHow many doors does the Electric Car have");
doors=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nDoes the Electric Car have tinted windows");
System.out.println("1) Yes");
System.out.println("2) No");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);
if(option==1){
tintedWindows=true;	
}else{
tintedWindows=false;		
}

do{
System.out.println("\nWhat type of charger does the Electric Car have");
System.out.println("1) Fast");
System.out.println("2) Normal");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);	
if(option==1){
fastCharger=true;	
}else{
fastCharger=false;	
}

System.out.println("\nWhat is the Electric Car's batteryDuration");
batteryDuration=sc.nextInt();
sc.nextLine();


saninsDealership.addVehicle(new  Electric(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,fastCharger,batteryDuration));
addDocs();
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);
System.out.println("\nThe Electric Car has been added successfully");
	
}else{
isNew=false;
System.out.println("\nWhat is the Electric Car's base price");
price=sc.nextDouble();
sc.nextLine();

System.out.println("\nWhat is the Electric Car's brand");
brand=sc2.nextLine();

System.out.println("\nWhat is the Electric Car's model");
model=sc3.nextInt();
sc3.nextLine();

System.out.println("\nWhat is the Electric Car's engine displacement");
engineDisplacement=sc3.nextInt();
sc3.nextLine();

mileage=0;
licensePlate="";

do{
System.out.println("\nWhat type of Electric Car is it");
System.out.println("1) Sedan");
System.out.println("2) Sport");
System.out.println("3) Truck");
option=sc3.nextInt();
sc3.nextLine();
if(option>3){
System.out.println("Please select a valid option");
}
}while(option>3);	
if(option==1){
type="Sedan";	
}else if(option==2){
type="Sport";	
}else{
type="Truck";	
}

System.out.println("\nHow many doors does the Electric Car have");
doors=sc3.nextInt();
sc3.nextLine();

do{
System.out.println("\nDoes the Electric Car have tinted windows");
System.out.println("1) Yes");
System.out.println("2) No");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);
if(option==1){
tintedWindows=true;	
}else{
tintedWindows=false;		
}

do{
System.out.println("\nWhat type of charger does the Electric Car have");
System.out.println("1) Fast");
System.out.println("2) Normal");
option=sc3.nextInt();
sc3.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
}while(option>2);	
if(option==1){
fastCharger=true;	
}else{
fastCharger=false;	
}

System.out.println("\nWhat is the Electric Car's batteryDuration");
batteryDuration=sc.nextInt();
sc.nextLine();


if(model<2015){
saninsDealership.addToParking(new  Electric(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,fastCharger,batteryDuration));	
addDocs();
System.out.println("\nThe Electric Car has been added successfully");	
}else{
saninsDealership.addVehicle(new  Electric(price,brand,model,engineDisplacement,mileage,isNew,licensePlate,type,doors,tintedWindows,fastCharger,batteryDuration));
addDocs();
saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).calculatePrice(0.0);
System.out.println("\nThe Electric Car has been added successfully");	
}
	
}
	
}

/** Method for adding a document car<br>
		
	<b> pre: </b> vehicle must be created to add documents to <br>
	<b> post: </b> A document is created with the options the client selects<br>
	*/
public void addDocs(){
//ints
Scanner sc = new Scanner(System.in);
//doubles
Scanner sc2 = new Scanner(System.in);

int option;
int option2;
double price;
int year;
double coverageAmount=0.0;
double gasLevels=0.0;
do{
System.out.println("\nDoes the vehicle have any documents");
System.out.println("1) Yes");
System.out.println("2) No");
option=sc.nextInt();
sc.nextLine();
if(option>2){
System.out.println("Please select a valid option");
}
if(option==1){
do{
System.out.println("\nPlease select the type of document and fill the information");
System.out.println("1) SOAT");
System.out.println("2) TechnoMechanical");
option2=sc.nextInt();
sc.nextLine();	
if(option2>2){
System.out.println("Please select a valid option");
}
}while(option2>2);
if(option2==1){
System.out.println("\nWhat was the documents price");	
price=sc2.nextDouble();
sc2.nextLine();

System.out.println("\nWhat year is the document from");	
year=sc.nextInt();
sc.nextLine();

System.out.println("\nWhat was the coverage amount");	
coverageAmount=sc2.nextDouble();
sc2.nextLine();
System.out.println(saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new Soat(price,year,coverageAmount)));

}else{
System.out.println("\nWhat was the documents price");	
price=sc2.nextDouble();
sc2.nextLine();

System.out.println("\nWhat year is the document from");	
year=sc.nextInt();
sc.nextLine();

System.out.println("\nWhat where the gas levels");	
gasLevels=sc2.nextDouble();
sc2.nextLine();	
System.out.println(saninsDealership.getVehicle(saninsDealership.getVehicles().size()-1).addDocument(new TechnoMechanical(price,year,gasLevels)));
}
}
}while(option!=2);
}

/** Method for showing salesman menu<br>
		
	<b> pre: </b> <br>
	<b> post: </b> prints salesmen<br>	
	*/
public int salesmanMenu(){
Scanner sc = new Scanner(System.in);
do{
System.out.println("\nHello Salesman, please identify yourself");	
System.out.println(saninsDealership.showSalesmen());
salesman=sc.nextInt();
sc.nextLine();
if(salesman>10){
System.out.println("Please select a valid option");
}
}while(salesman>10);
return salesman;	
}

/** Method for showing and doing salesman menu<br>
		
	<b> pre: </b> <br>
	<b> post: </b> salesman side of the program can function correctly<br>	
	@param salesman, an int representing the salesman in the array of salesmen
	*/
public void salesmanAction(int salesman){
int option;
int seller=salesman-1;
do{
System.out.println("\nHello "+saninsDealership.getSalesman(seller).getName()+", please select what you would like to do");
System.out.println("1) Select a Client");
System.out.println("2) Add a Client");
System.out.println("3) Remove a Client");
System.out.println("4) EXIT");
option=readOption();
switch(option){
case SELECT_CLIENT:
if(saninsDealership.getSalesman(seller).getClients().isEmpty()){
System.out.println("\nYou have no clients, please add at least one to access this feature");	
}else{
clientMenu(selectClient(seller));	
}

break;
case ADD_CLIENT:
addClient(seller);
break;
case REMOVE_CLIENT:

if(saninsDealership.getSalesman(seller).getClients().isEmpty()){
System.out.println("\nYou have no clients, please add at least one to access this feature");	
}else{
System.out.println(saninsDealership.getSalesman(seller).removeClient(selectClient(seller)));	
}

break;
}
if(option>4){
System.out.println("\nPlease select a valid option");
}
}while(option!=4);
}

/** Method for adding a client<br>
		
	<b> pre: </b> <br>
	<b> post: </b> A client is created with the options the salesman selects<br>
	@param salesman, an int representing the salesman in the array of salesmen
	*/
public void addClient(int salesman){
Scanner sc = new Scanner(System.in);
Scanner sc2 = new Scanner(System.in);
String name;
String lastName;
int id;
int phoneNumber;
String email;
System.out.println("What is the client's first name");
name=sc2.nextLine();

System.out.println("What is the client's last name");
lastName=sc2.nextLine();

System.out.println("What is the client's id number");
id=sc.nextInt();
sc.nextLine();

System.out.println("What is the client's phone number");
phoneNumber=sc.nextInt();
sc.nextLine();

System.out.println("What is the client's email");
email=sc2.nextLine();

System.out.println(saninsDealership.getSalesman(salesman).addClient(new Client(name,lastName,id,phoneNumber,email)));
}

/** Method for selecting a client<br>
		
	<b> pre: </b> <br>
	<b> post: </b> A client is selected by the salesman<br>
	@param salesman, an int representing the salesman in the array of salesmen
	@return Client, the client object that was selected
	*/
public Client selectClient(int salesman){
int option;

do{
System.out.println("\nPlease select client");	
System.out.println(saninsDealership.getSalesman(salesman).showClients());
option=readOption();
if(option>saninsDealership.getSalesman(salesman).getClients().size()){
System.out.println("\nPlease select a valid option");	
}
}while(option>saninsDealership.getSalesman(salesman).getClients().size());
return saninsDealership.getSalesman(salesman).getClients().get(option-1);
}

/** Method for showing client menu<br>
		
	<b> pre: </b> <br>
	<b> post: </b> allows client side of program to function<br>	
	@param client, a client object 
	*/
public void clientMenu(Client client){
int option;

do{
System.out.println("\nWhat would you like to do with "+client.getName());
System.out.println("1) View Client Info");
System.out.println("2) Show Catalog");
System.out.println("3) Show Wish List");
System.out.println("4) EXIT");
option=readOption();
switch(option){
case CLIENT_INFO:
System.out.println(client.clientInfo());

break;

case SHOW_CATALOG:
saninsDealership.getCatalog().clear();
showCatalog(client);
break;

case SHOW_WISHLIST:
System.out.println(client.showWishList());
selectFromWishList(client);


break;

}	
if(option>4){
System.out.println("\nPlease select a valid option");
}
}while(option!=4);
}


/** Method for showing catalog<br>
		
	<b> pre: </b> <br>
	<b> post: </b> prints catalog of selected vehicles<br>	
	@param client, a client object 
	*/
public void showCatalog(Client client){
int option;
int models;
int types;
int conds;
int action;
do{
System.out.println("\nPlease select how you would like to filter the vehicles");	
System.out.println("1) Model");
System.out.println("2) Vehicle Type");
System.out.println("3) Vehicle condition new or used");
System.out.println("4) EXIT");
option=readOption();
switch(option){	

case MODEL:
System.out.println("\nPlease enter the vehicle models you would like to view");	
models=readOption();
saninsDealership.getCatalog().clear();
saninsDealership.catalogVehicles(MODEL,models);
saninsDealership.catalogOldCars(MODEL,models);
System.out.println(saninsDealership.showCatalog());
selectVehicle(client);

break;

case VEHICLE_TYPE:
do{
System.out.println("\nPlease enter the vehicle types you would like to view");	
System.out.println("1) Motorcycles");
System.out.println("2) Gas Cars");
System.out.println("3) Hybrid Cars");
System.out.println("4) Electric Cars");
types=readOption();
if(types>4){
System.out.println("\nPlease select a valid option");
}
}while(types>4);
saninsDealership.getCatalog().clear();
saninsDealership.catalogVehicles(VEHICLE_TYPE,types);
saninsDealership.catalogOldCars(VEHICLE_TYPE,types);
System.out.println(saninsDealership.showCatalog());
selectVehicle(client);
break;

case CONDITION:
do{
System.out.println("\nPlease enter the vehicle condition you would like to view");	
System.out.println("1) New");
System.out.println("2) Used");
conds=readOption();
if(conds>2){
System.out.println("\nPlease select a valid option");
}
}while(conds>2);
saninsDealership.getCatalog().clear();
saninsDealership.catalogVehicles(CONDITION,conds);
saninsDealership.catalogOldCars(CONDITION,conds);
System.out.println(saninsDealership.showCatalog());
selectVehicle(client);



break;




}
if(option>4){
System.out.println("\nPlease select a valid option");
}
}while(option!=4);

}


/** Method for selecting a vehicle from catalog<br>
		
	<b> pre: </b> <br>
	<b> post: </b> Selects and sells vehicles<br>
	@param client, a client object 
	*/
public void selectVehicle(Client client){
String info="";
int selection;
int option;
for(int i=0; i< saninsDealership.getCatalog().size(); i++){
info+=(i+1)+") Vehicle "+(i+1)+"\n";	
}
info+=(saninsDealership.getCatalog().size()+1)+") EXIT";

do{
System.out.println("\nPlease select a vehicle");	
System.out.println(info);
selection=readOption();
if(selection>saninsDealership.getCatalog().size()+1){
System.out.println("\nPlease select a valid option");
}	
}while(selection>saninsDealership.getCatalog().size()+1);

if(selection==saninsDealership.getCatalog().size()+1){
	
}else{
System.out.println("\nVehicle selected");
do{
System.out.println("\nWhat would you like to do");
System.out.println("1) Add vehicle to wish list");
System.out.println("2) Buy the vehicle");
option=readOption();
if(option>2){
System.out.println("\nPlease select a valid option");
}	
}while(option>2);
if(option==1){
System.out.println(client.addToWishList(saninsDealership.getCatalog().get(selection-1)));
}else{
purchase(client,saninsDealership.getCatalog().get(selection-1));
}	
}
}


/** Method for purchasing a vehicle<br>
		
	<b> pre: </b> <br>
	<b> post: </b> purchases the selected vehicle<br>
	@param client, a client object 
	@param vehicle, the selected vehicle 
	
	*/
public void purchase(Client client, Vehicle vehicle){
Scanner sc= new Scanner(System.in);
double option;
System.out.println("\nEnter special discount in percentage (Ex. if discount is 5% enter 0.05)");
System.out.println("if there is none enter 0.0 ");
option=sc.nextDouble();
vehicle.calculatePrice(option);
System.out.println("Final price is: "+vehicle.getTotalSalesPrice());
System.out.println(vehicle.assignOwner(client));
System.out.println(saninsDealership.sell(vehicle,salesman-1));
}

/** Method for selecting a vehicle from wishlist<br>
		
	<b> pre: </b> <br>
	<b> post: </b> Selects and sells vehicles<br>
	@param client, a client object 
	*/
public void selectFromWishList(Client client){
String info="";
int selection;
int option;
if(client.getWishList().isEmpty()){
	
}else{
for(int i=0; i< client.getWishList().size(); i++){
info+=(i+1)+") Vehicle "+(i+1)+"\n";	
}
info+=(client.getWishList().size()+1)+") EXIT";

do{
System.out.println("\nPlease select a vehicle");	
System.out.println(info);
selection=readOption();
if(selection>client.getWishList().size()+1){
System.out.println("\nPlease select a valid option");
}	
}while(selection>client.getWishList().size()+1);
if(selection==saninsDealership.getCatalog().size()+1){
	
}else{
System.out.println("\nVehicle selected");
do{
System.out.println("\nWhat would you like to do");
System.out.println("1) Buy the vehicle");
System.out.println("2) Remove vehicle from wish list");
option=readOption();
if(option>2){
System.out.println("\nPlease select a valid option");
}	
}while(option>2);	
if(option==1){
purchase(client,client.getWishList().get(selection-1));	
}else{
System.out.println(client.removeFromWishList(client.getWishList().get(selection-1)));
}
}
}
}

/** Method that excecutes the main menu<br>
		
	<b> pre: </b> <br>
	<b> post: </b> The user can administrate the dealership or be a saleman<br>

	*/
public void doMenu(){
int option;
initialVehicles();
do{
firstMenu();
option=readOption();
switch(option){
case ADMIN:
adminActions();
break;

case SALESMAN:
//System.out.println(saninsDealership.getVehicles().get(saninsDealership.getVehicles().size()-1).description());
salesmanAction(salesmanMenu());
break;

}
if(option>EXIT){
System.out.println("\nPlease select a valid option");
}
}while(option !=EXIT);
System.out.println("The program has closed successfully, until next time:)");
}


/** Method that initializes the program<br>
		
	<b> pre: </b> <br>
	<b> post: </b> The user can use the program<br>

	*/
public void start(){
showWelcome();
doMenu();
}

}