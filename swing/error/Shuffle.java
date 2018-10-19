/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import org.junit.Assert.assertEquals;

/**
 *
 * @author Priyal
 */
public class Shuffle 
{
    public void test()
    {
        Integer[][] array = { {1, 2, 3}, {4, 5, 6} } ;
        List list;
        list = new TwoDimensionalArrayViewList(array);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
        Collections.shuffle(list);
    }
}
