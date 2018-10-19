/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;

import java.util.AbstractList;
import java.util.RandomAccess;

/**
 *
 * @author Priyal
 */
public class TwoDimensionalArrayViewList extends AbstractList implements RandomAccess {
    private Object[][] array;

    public TwoDimensionalArrayViewList(Object[][] array) {
        this.array = array;
    }

    @Override
    public Object get(int index) {
        int row = rowForIndex(index);
        int column = columnForIndex(index);
        return array[row][column];
    }

    private int columnForIndex(int index) {
        return index % array[0].length;
    }

    private int rowForIndex(int index) {
        return index / array[0].length;
    }

    @Override
    public Object set(int index, Object element) {
        Object previous = get(index);
        int row = rowForIndex(index);
        int column = columnForIndex(index);
        array[row][column] = element;
        return previous;
    }

    @Override
    public int size() {
        return array.length*array[0].length;
    }
}
