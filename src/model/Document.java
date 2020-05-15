package model;
import java.util.*;
public abstract class Document{
	
//Document constants
private final static int SIZE=4;
	
//Document attributes
private double price;
private int year;
private int[][] picture;
private String code;

//Constructor
/** Constructor method for a document<br>
	<b> pre: </b> <br>
	<b> post: </b> Creates a document and initializes its attributes<br>
	@param price, a double with the  price
	@param year, an int with the  year
	
	*/
public Document(double price,int year){
this.price=price;
this.year=year;
picture=new int[SIZE][SIZE];
Random ran= new Random();
for(int i=0; i<SIZE; i++){
	for(int j=0;j<SIZE; j++){
	picture[i][j]=ran.nextInt(100);
}
}
code="";
}
/** Method for showing document information<br>
		
	<b> pre: </b> <br>
	<b> post: </b>Returns the document information<br>	
	*/
public String printInfo(){
String info="";
String picString="";
info+= "Price: "+price;
info+= "\nYear: "+year;
/*
for(int i=0; i<SIZE; i++){
for(int j=0;j<SIZE; j++){
picString+=picture[i][j]+" ";
}	
picString+="\n";
}
info+= "\nPicture: \n"+picString;*/
return info;
}

public abstract void decode();


//Getters and Setters
/** Getter method for accessing the document's price <br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the document's price<br>
	@return a double with the document's price
	*/
public double getPrice(){
return price;
}

/** Setter method for modifying the document's price<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the document's price<br>
	@param price, a double with the document's price
	*/
public void setPrice(double price){
this.price=price;
}

/** Getter method for accessing the document's year<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the document's year<br>
	@return an int representing the document's year
	*/
public int getYear(){
return year;
}

/** Setter method for modifying the document's year<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the document's year<br>
	@param year, an int with the document's year
	*/
public void setYear(int year){
this.year=year;
}

/** Getter method for accessing the document's picture<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the document's picture<br>
	@return an array of ints representing the document's picture
	*/
public int[][] getPicture(){
return picture;
}

/** Setter method for modifying the document's picture<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the document's picture<br>
	@param picture, an array of ints with the document's picture
	*/
public void setPicture(int[][] picture){
this.picture=picture;
}

/** Getter method for accessing the document's code<br>
	<b> pre: </b> <br>
	<b> post: </b> Grants access to the document's code<br>
	@return an String representing the document's code
	*/
public String getCode(){
return code;
}

/** Setter method for modifying the document's code<br>
	<b> pre: </b> <br>
	<b> post: </b> Changes the document's code<br>
	@param code, an String with the document's code
	*/
public void setCode(String code){
this.code=code;
}
}