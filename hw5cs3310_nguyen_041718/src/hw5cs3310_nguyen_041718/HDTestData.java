package hw5cs3310_nguyen_041718;


public class HDTestData {
int hashc;
String HDNumber;
String HDModel;
String HDCapacity;
String HDHours;
public HDTestData next;


/**
 * constructor that passes an int and MyNode object and sets them to local variables
 * @param myNum 
 * @param next
 */



public HDTestData(String num, String model, String capacity, String hours) {
	this.HDNumber = num;
	this.HDModel = model;
	this.HDCapacity = capacity;
	this.HDHours = hours;
	//this.next = next;
}

public HDTestData(String myNum, HDTestData next){
	this.HDNumber = myNum;
	this.next = next;
}


/**
 * sets MyNode object to local object next
 * @param next
 */
public HDTestData(HDTestData next){
	//this.myData = (Character) null;
	this.next = next;
}

/**
 * set next to passed object n
 * @param n
 */
public void setNext(HDTestData n) {
	next = n;
	
}


/**
 * 
 * @return MyNum object next
 */
public HDTestData next() {
	return next;
}

public void setElement(String s) {
	this.HDNumber = s;
}
public void setModel(String s) {
	this.HDModel= s;
}
public void setCapacity(String s) {
	this.HDCapacity = s;
}
public void setHours(String s) {
	this.HDHours = s;
}

/**
 * 
 * @return local integer
 */
public String element() {
	return HDNumber;
}

public String getModel() {
	return HDModel;
}

public String getCapacity() {
	return HDCapacity;
}

public String getHours() {
	return HDHours;
}
}


