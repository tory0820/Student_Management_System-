package com.Student_Management_System_final;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class Stumodel extends AbstractTableModel {

	Vector rowData,colmNames;
	

	
	public boolean updstu(String sql,String [] paras){
		SqlHelper sh=new SqlHelper();
		return sh.update(sql,paras);
	}
	
	
	public void qureystu(String sql,String [] paras){
		SqlHelper sh=null;
		
		colmNames=new Vector();
		colmNames.add("Student ID");
		colmNames.add("Name");
		colmNames.add("Age");
		colmNames.add("Gender");
		colmNames.add("Department");
		colmNames.add("GPA");
		
		rowData=new Vector();
		try{
			sh=new SqlHelper();
			ResultSet rs=sh.query(sql,paras);
			while(rs.next()){
				Vector row=new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getInt(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getFloat(6));
				
				rowData.add(row);
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sh.close();
		}
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.colmNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(col);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.colmNames.get(column);
	}

}
