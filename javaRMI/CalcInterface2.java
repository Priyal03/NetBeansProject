import java.rmi.*;
public interface CalcInterface2 extends Remote{
	public float mul(float x,float y) throws Exception;
	public float div(float x,float y) throws Exception;
}