package com.Student_Management_System_final;

import java.sql.*;

public class SqlHelper {
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	String dir="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=student management system;integratedSecurity=true;";
	
	public void close(){
		try{
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	public boolean update(String sql,String [] paras){
		
		boolean b=true;
		try{
			Class.forName(dir);
			ct=DriverManager.getConnection(url);
			ps=ct.prepareStatement(sql);
			for (int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
				
			if(ps.executeUpdate()!=1){
					b=false;
			}
				
				
						
		}catch(Exception e1){
			b=false;
			e1.printStackTrace();
		}finally{
			this.close();
		}
		return b;
		
	}
	
	
	
	public ResultSet query(String sql,String [] paras){
		try{
			Class.forName(dir);
			ct=DriverManager.getConnection(url);
			ps=ct.prepareStatement(sql);
			if(paras!=null){
				for (int i=0;i<paras.length;i++){
					ps.setString(i+1, paras[i]);
				}
			}
			rs=ps.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return rs;
		}
	}
	
}
