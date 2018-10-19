package Lucky;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Lucky1
{
  int t,l,r,n=0;
  public static final int seven=7,four=4;
  
      /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException
  {
      System.out.println("Enter the value of l and r");
     BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in)); 
    String number = bufferedreader.readLine(); 
    int l = Integer.parseInt(number);       
    int r=Integer.parseInt(number);
          for(int i=l;i<=r;i++)
          {
              String numString = String.valueOf(i);
             int len=numString.length();
         
                for(int j=0; j<len; j++)
                {
                    char c = numString.charAt(i);
			if(c  == four || c == seven){
                            {
                                                             
                            }
                            
                }
          }
          
  