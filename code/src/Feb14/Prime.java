public class Prime 
{
    public static void main(String args[])
    {
        int x,y,z,s=0;
    System.out.println("\nEnter the no of testcases");
   // t=Integer.parseInt(args[0]);
  //  for(int j=0; t>=j; j++)
   // {
        System.out.println("\nEnter the values of potatoes from field x and y");
        x=Integer.parseInt(args[1]);
        y=Integer.parseInt(args[2]);
        for(int i=0; i<100; i++)
        {
            s=x+y+i;
            if(prim(s))
            {
                System.out.println("total no of potatoes is prime");
            }
            
        }
        
    }
          public int prim(int sum)
          {
            for(int k=2;k<sum/2;k++)
            {
                int a=sum%k;
                if(a!=0)
                {
                    return 1;  
                }
            
           }
        return 1;
          }
}
