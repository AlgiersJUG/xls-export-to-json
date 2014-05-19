package org.jpuzzler.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abderrazak BOUADMA
 * Date: 5/19/14
 * Time: 3:55 PM
 */
public class MyRow implements Serializable{

    private List<MyCell> cells;

    public MyRow() {
        cells = new ArrayList<>();
    }

    public void addCell(MyCell myCell) {
        this.cells.add(myCell);
    }
}
