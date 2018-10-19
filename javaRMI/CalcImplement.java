import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
public class CalcImplement extends UnicastRemoteObject implements CalcInterface{
public CalcImplement() throws Exception{
	super();
}
public float add(float x,float y){
return x+y;
}
public float sub(float x,float y){
return x-y;
}

}