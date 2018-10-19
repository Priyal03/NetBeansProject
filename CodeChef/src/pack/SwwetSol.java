/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Priyal
 */
public class SwwetSol 
{
    public static void main(String[] args) throws Exception {
 
 				
 			Scanner s = new Scanner(System.in);
 
 			int testcases=s.nextInt();
 
 		
 			while(testcases-->0)
 
 			{
 
 				int no_notes=s.nextInt();
 
 				int sweetprice=s.nextInt();
 
 				
 				int Notes[]= new int[no_notes];
 
 				
 				int sum=0;
 
 				for(int i=0;i<no_notes;i++)
 
 				{
 
 					
 					Notes[i]=s.nextInt();
 
 					sum=sum+Notes[i];
 
 				}
 
 				
 				Arrays.sort(Notes);
 
 				
 				int remainder=sum%sweetprice;
 
 				
 				
 				boolean allflag=true;
 
 				for (int j=0;j<no_notes;j++)
 
 				{
 
 					if(remainder>=Notes[j])
 
 					{
 
 						allflag=false;
 
 						break;
 
 					}
 
 				}
 
 				
 				
 				if(allflag)
 
 				{
 
 					System.out.println((sum-remainder)/sweetprice);
 
 				}else
 
 					System.out.println("-1");
 
 			}
 
 		}
 
 	}