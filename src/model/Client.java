package model;
import java.util.*;
public class Client{

//Client attributes
private String name;
private String lastName;
private int id;
private int phoneNumber;
private String email;
private ArrayList<Vehicle> wishList;



//Constructor
 /** Constructor method for a Client <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates Client and initializes its attributes<br>
	@param name, a name for the Client, must be a String !=null or !=" "
	@param lastName, a last name for the Client, must be a String !=null or !=" "
	@param id, an int representing the Client id
	@param phoneNumber, an int representing the Client phone number
	@param email, an email for the Client, must be a String !=null or !=" "
	*/
public Client(String name,String lastName, int id,int phoneNumber,String email){
this.name=name;
this.lastName=lastName;
this.id=id;
this.phoneNumber=phoneNumber;
this.email=email;	
wishList=new ArrayList<Vehicle>();
}

/** Method for showing client information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the client information<br>	
	*/
public String clientInfo(){
String info="";
info+="Client Information\n";
info+="Name: "+ name+"\n";
info+="Last name: "+lastName+"\n";
info+="Id: "+ id+"\n";
info+="Phone number: "+ phoneNumber+"\n";
info+="Email: "+ email+"\n";
return info;
}

 /** Method for adding vehicles to wishlist<br>
	<b> pre: </b> <br>
	<b> post: </b> adds vehicle to wish list <br>
	@param vehicle, a vehicle object that has been created 
	@return a String with the confirmation
	*/
public String addToWishList(Vehicle vehicle){
String confirmation="";
wishList.add(vehicle);
confirmation="The vehicle was added successfully to the wish list";
return confirmation;
}


/** Method for removing vehicles from wishlist<br>
	<b> pre: </b> <br>
	<b> post: </b> removes vehicles from wishlist <br>
	@param vehicle, a vehicle object that has been created  
	@return a String with the confirmation
	*/
public String removeFromWishList(Vehicle vehicle){
String confirmation="";
wishList.remove(vehicle);
confirmation="The vehicle was removed successfully from wish list";	
return confirmation;
}

/** Method for showing wishlist<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the wishlist<br>	
	*/
public String showWishList(){
String info="";
if(wishList.isEmpty()){
info="Wish list is empty please add a vehicle to wish list ";
}else{
info+="----------------------\n";
info+="-------WISHLIST-------\n";
info+="----------------------\n";
for (int i=0; i<wishList.size(); i++){
info+=i+1+") "+wishList.get(i).description();
}	
}
return info;
}



//Getters and Setters
/** Getter method for accessing the client's name <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's name<br>
	@return a String with the name of the client
	*/
public String getName(){
return name;
}

/** Setter method for modifying the client's name<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's name<br>
	@param name, a String with the client's name
	*/
public void setName(String name){
this.name=name;
}

/** Getter method for accessing the client's lastname <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's lastname<br>
	@return a String with the lastname of the client
	*/
public String getLastName(){
return lastName;
}

/** Setter method for modifying the client's lastname<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's lastname<br>
	@param lastName, a String with the client's lastname
	*/
public void setLastName(String lastName){
this.lastName=lastName;
}

/** Getter method for accessing the client's id<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's id<br>
	@return an int with the client's id
	*/
public int getId(){
return id;
}

/** Setter method for modifying the client's id<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's id<br>
	@param id, an int with the client's id
	*/
public void setId(int id){
this.id=id;
}

/** Getter method for accessing the client's phone number<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's phone number<br>
	@return an int with the client's phone number
	*/
public int getPhoneNumber(){
return phoneNumber;
}

/** Setter method for modifying the client's phone number<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's phone number<br>
	@param phoneNumber, an int with the client's phone number
	*/
public void setPhoneNumber(int phoneNumber){
this.phoneNumber=phoneNumber;
}

/** Getter method for accessing the client's email <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the client's email<br>
	@return a String with the emailof the client
	*/
public String getEmail(){
return email;
}

/** Setter method for modifying the client's email<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the client's email<br>
	@param email, a String with the client's email
	*/
public void setEmail(String email){
this.email=email;
}
/** Getter method for accessing the wishlist <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the arraylist of vehicles<br>
	@return an arraylist of vehicles
	*/
public ArrayList<Vehicle> getWishList(){
return(wishList);
}

}