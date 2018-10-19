import java.rmi.server.*;
import java.rmi.*;
import java.io.*;
public class CalcImplement2 extends UnicastRemoteObject implements CalcInterface2{
public CalcImplement2() throws Exception{
	super();
}
public float mul(float x,float y){
return x*y;
}
public float div(float x,float y){
return x/y;
}
}