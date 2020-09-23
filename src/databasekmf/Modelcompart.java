/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasekmf;

import databasemti.*;
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class Modelcompart extends AbstractTableModel{

    private String[] columns;
    private Object[][] rows;

    public Modelcompart(){}
    
    public Modelcompart(Object[][] data, String[] columnname){
        this.rows = data;
        this.columns = columnname;
    }
    
    public Class getcolumnclass(int column){
        if(column == 2){
            return Icon.class;
        }else{
            return getValueAt(0,column).getClass();
        }
    }
    
    public int getRowCount() {
        return this.rows.length;
    }

    public int getColumnCount() {
        return this.columns.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    public String getcolumnname(int col){
        return this.columns[col];
    }
}
