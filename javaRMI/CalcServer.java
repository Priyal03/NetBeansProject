import java.rmi.*;
import java.io.*;

public class CalcServer{

	public static void main(String[] args){
	try{
	CalcImplement ci=new CalcImplement();
	Naming.rebind("rmi://127.0.0.1/ADDSERVICE",ci);
	
	}
	
	catch(Exception e){
	System.out.println("Error:"+e);
	}
	}
}