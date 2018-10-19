import java.rmi.*;
public interface CalcInterface extends Remote{
	public float add(float x,float y) throws Exception;
	public float sub(float x,float y) throws Exception;
	
}