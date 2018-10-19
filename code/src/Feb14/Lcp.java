/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Feb14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Priyal
 */
public class Lcp {
    public static void main(String args[]) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the desired length");
        int n=Integer.parseInt(args[0]);
        System.out.println("Enter the first string:");
        String s1=in.readLine();
        System.out.println("Enter the second string:");
        String s2=in.readLine();
        for(int i=0;i<n;i++){
            for(int j=0;j<n; j++){
            if((s1.charAt(i))==(s2.charAt(j))){
                System.out.println(s1.charAt(i));
                
                
            }
            else{
                
            }
            }
               
        }
           
             
        
            
        
        
    }
    
}
