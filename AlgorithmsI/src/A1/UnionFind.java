/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package A1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Priyal
 */
public class UnionFind 
{
    private final int id[];
    public UnionFind(int N)
    {
        id=new int[N];
        for(int i=0;i<N;i++)
        {
            id[i]=i;
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        
        PrintWriter out = new PrintWriter(System.out);
        int N=Integer.parseInt(in.readLine());
        UnionFind uf=new UnionFind(N);
        StringTokenizer token=new StringTokenizer(in.readLine());
        while(N-->0)
        {
            int p=Integer.parseInt(token.nextToken());
            int q=Integer.parseInt(token.nextToken());
            if(uf.connected(p,q))
            {
            } else 
            {
                uf.union(p,q);
                out.println(p+" "+q);
            
            }
        }
        
            
        
    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) 
    {
        return id[p]==id[q];
    }

    private void union(int p, int q) 
    {
        int pid=id[p];
        int qid=id[q];
        for(int i=0;i<id.length;i++)
        {
            if(id[i]==pid)
                id[i]=qid;
        }
    }
}