package Try;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * @author Priyal
 */
public class Magic 
{
    @SuppressWarnings("empty-statement")
    public static void main(String args[]) throws IOException
    {
        int a[][]=new int[4][4];
        int b[][]=new int[4][4];
        int s[]=new int[4];
        int t[]=new int[4];
        
        System.out.println("\nEnter the number of testcase");        
        BufferedReader test=new BufferedReader(new InputStreamReader(System.in));   
        String tt=test.readLine();
        int not=Integer.parseInt(tt);       
        for(int c=0; c<not; c++)
        {
        BufferedReader row1=new BufferedReader(new InputStreamReader(System.in));                    
        int l=16,i,j;
        String str="\t";
        String str2="\t";
        
        System.out.println("Choose a row");
       
        String r1=row1.readLine();
        int x1=Integer.parseInt(r1);
        
        StringTokenizer st = new StringTokenizer(row1.readLine());
            for(i=0;i<4;i++)
            {
                for(j=0;j<4;j++)
                {
                    a[i][j]=Integer.parseInt(st.nextToken());
                   str += a[i][j] + "\t";                     
                                        
                }
              //  System.out.println(str);
                str="\t";           
            }
        }
       /* System.out.println("Choose a row");
        String r2=row1.readLine();       
        int x2=Integer.parseInt(r2);       
        while(l!=0)
        {
            for(i=0;i<4;i++)
            {
                for(j=0;j<4;j++)
                {                    
                    b[i][j]=l;
                    str2+=b[i][j] + "\t";             
                    l--;
                }           
                System.out.println(str2);
                str2="\t";
            }
        }
            for(i=0; i<4; i++)
            {
                s[i]=a[x1-1][i];
            }
            for(j=0;j<4;j++)
            {
                t[j]=b[x2-1][j];
            }
        }
/*                   if(s[i]==t[j])
                    {
                       System.out.println(s[i]); 
                    } */                                                                                            
    
    }
}