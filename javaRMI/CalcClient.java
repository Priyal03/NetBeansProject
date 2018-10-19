import java.rmi.*;
import java.io.*;

public class CalcClient{
	public static void main(String[] args){
	try{
	String ip="rmi://127.0.0.1/ADDSERVICE";
	String ip2="rmi://127.0.0.1/MULSERVICE";
	CalcInterface cAdd=(CalcInterface)Naming.lookup(ip);
	CalcInterface2 cMul=(CalcInterface2)Naming.lookup(ip2);
	
/*f(args.length<1)
	{
	System.out.println("Please Enter arguments");
	exit ;
	
	}*/
	
	System.out.println("Addition is::"+cAdd.add(20,10));
	System.out.println("Subtraction is::"+cAdd.sub(20,10));
	System.out.println("Multiplication is::"+cMul.mul(20,10));
	System.out.println("Division is::"+cMul.div(20,10));
	}
	
	catch(Exception e){
	
	System.out.println("Error"+e);		
	}
	}
}