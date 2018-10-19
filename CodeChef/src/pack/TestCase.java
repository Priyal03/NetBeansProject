/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;

import java.util.Scanner;

/**
 *
 * @author Priyal
 */
public class TestCase 
{    
		public static void main(String args[]){
		
			Scanner kbd = new Scanner(System.in);
			
			int T = kbd.nextInt();
			
			for(int t=0;t<T;t++){
			
				double B = kbd.nextDouble();
				double LS = kbd.nextDouble();
				
				double minRS = Math.sqrt((LS*LS)-(B*B));
				double maxRS = Math.sqrt((LS*LS)+(B*B));
				
				System.out.println(minRS+" "+maxRS);
			
			}
		}
}
