package model;
import java.util.*;
public class Salesman{

//Salesman constants
private final static int MAX_CLIENTS=5;

//Salesman attributes
private String name;
private String lastName;
private int id;
private int totalSales;
private ArrayList<Client> clients;


//Constructor
 /** Constructor method for a Salesman <br>
	<b> pre: </b> <br>
	<b> post: </b> Creates salesman and initializes its attributes<br>
	@param name, a name for the salesman, must be a String !=null or !=" "
	@param lastName, a last name for the salesman, must be a String !=null or !=" "
	@param id, an int representing the salesman id
	*/
public Salesman(String name,String lastName, int id){
this.name=name;
this.lastName=lastName;
this.id=id;
totalSales=0;
clients=new ArrayList<Client>();
}

//Methods
 /** Method for adding clients<br>
	<b> pre: </b> <br>
	<b> post: </b> adds client to salesman if it can <br>
	@param client, a client object that has been created 
	@return a String with the confirmation
	*/
public String addClient(Client client){
String confirmation="";
if(checkSize()){
clients.add(client);
confirmation="The client was added successfully";
}else{
confirmation="The client cannot be added, salesman has reached maximum clients";	
}
return confirmation;	
}

/** Method for removing clients<br>
	<b> pre: </b> <br>
	<b> post: </b> removes a client <br>
	@param client, a client object that has been created  
	@return a String with the confirmation
	*/
public  String  removeClient(Client client){
String confirmation="";
clients.remove(client);
confirmation="The client was removed successfully";
return confirmation;
}


/** Method for showing salesman information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the salesman information<br>	
	*/
public String salesmanInformation(){
String info="";
info+="\nSalesman Information\n";
info+="Name: "+ name+"\n";
info+="Last name: "+lastName+"\n";
info+="Id: "+ id+"\n";
info+="Total sales: "+ totalSales;
return info;
}

/** Method for showing clients information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the clients information<br>	
	*/
public String showClientsInfo(){
String info="";
for(int i=0; i<clients.size();i++){
info+=i+1+") "+clients.get(i).clientInfo();
}
return info;
}

/** Method for showing clients <br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the clients <br>	
	*/
public String showClients(){
String info="";
if(clients.isEmpty()){
info+="You have no clients, please add at least one to access this feature";
}else{
for(int i=0; i<clients.size();i++){
info+=i+1+") "+clients.get(i).getName()+" "+clients.get(i).getLastName()+"\n";
}
}
return info;
}



/** Method for checking size of arraylist <br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns boolean <br>	
	*/
public boolean checkSize(){
int size=clients.size();
boolean check=false;
if(size<5){
check=true;
}
return check;
}



//Getters and setters
/** Getter method for accessing the salesman's name <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the salesman's name<br>
	@return a String with the name of the salesman
	*/
public String getName(){
return name;
}

/** Setter method for modifying the salesman's name<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the salesman's name<br>
	@param name, a String with the salesman's name
	*/
public void setName(String name){
this.name=name;
}

/** Getter method for accessing the salesman's lastname <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the salesman's lastname<br>
	@return a String with the lastname of the salesman
	*/
public String getLastName(){
return lastName;
}

/** Setter method for modifying the salesman's lastname<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the salesman's lastname<br>
	@param lastName, a String with the salesman's lastname
	*/
public void setLastName(String lastName){
this.lastName=lastName;
}

/** Getter method for accessing the salesman's id<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the salesman's id<br>
	@return an int with the salesman's id
	*/
public int getId(){
return id;
}

/** Setter method for modifying the salesman's id<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the salesman's id<br>
	@param id, an int with the salesman's id
	*/
public void setId(int id){
this.id=id;
}

/** Getter method for accessing the salesman's  total sales<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the salesman's  total sales<br>
	@return an int with the salesman's total sales
	*/
public int getTotalSales(){
return totalSales;
}

/** Setter method for modifying the salesman's total sales<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the salesman's  total salesbr>
	@param totalSales, an int with the salesman's  total sales
	*/
public void setTotalSales(int totalSales){
this.totalSales=totalSales;
}

/** Getter method for accessing the clients <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the arraylist of clients<br>
	@return an arraylist of clients
	*/
public ArrayList<Client> getClients(){
return(clients);
}

}