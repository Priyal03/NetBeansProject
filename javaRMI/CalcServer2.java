import java.rmi.*;
import java.io.*;
public class CalcServer2{

	public static void main(String[] args){
	try{
	
	CalcImplement2 ci2=new CalcImplement2();
	Naming.rebind("rmi://127.0.0.1/MULSERVICE",ci2);
	}
	
	catch(Exception e){
	System.out.println("Error:"+e);
	}
	}
}