package com.Student_Management_System_final;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class StuMangSys extends JFrame implements ActionListener {
	
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	Stumodel sm;
	
	public static void main(String[] args) {
		StuMangSys test=new StuMangSys();
		// TODO Auto-generated method stub

	}
	public StuMangSys(){
		jp1=new JPanel();
		jtf=new JTextField(10);
		jb1=new JButton("Search");
		jb1.addActionListener(this);
		jl1=new JLabel("Please enter student ID:");
		jb5=new JButton("Back");
		jb5.addActionListener(this);

		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb5);
		
		jp2=new JPanel();
		jb2=new JButton("Add");
		jb2.addActionListener(this);
		jb3=new JButton("Update");
		jb3.addActionListener(this);
		jb4=new JButton("Delete");
		jb4.addActionListener(this);
		

		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		

		sm=new Stumodel();
		sm.qureystu("select * from student", null);
		jt=new JTable(sm);
		
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			String id= this.jtf.getText().trim();
			String sql="select * from student where studentID=?";
			String[] paras={id};
			sm=new Stumodel();
			sm.qureystu(sql, paras);
			jt.setModel(sm);
			
			
		}else if(e.getSource()==jb2){
			StuAddDia sad=new StuAddDia(this,"Add Student",true);
			sm=new Stumodel();
			sm.qureystu("select * from student", null);
			jt.setModel(sm);
			
			
			
			
		}else if(e.getSource()==jb3){
			int row=this.jt.getSelectedRow();
			if (row==-1){
				JOptionPane.showMessageDialog(this, "Please select one row");
				return;
			}
			StuUpdDia sad=new StuUpdDia(this,"Update Student",true,sm,row);
			sm=new Stumodel();
			sm.qureystu("select * from student", null);
			jt.setModel(sm);
			
			
		}else if(e.getSource()==jb4){
			int row=this.jt.getSelectedRow();
			if (row==-1){
				JOptionPane.showMessageDialog(this, "Please select one row");
				return;
			}
			String stuid=sm.getValueAt(row, 0).toString();
			
			String sql="delete from student where studentID=?";
			String[] paras={stuid};
			Stumodel temp=new Stumodel();
			temp.updstu(sql, paras);
			
			sm=new Stumodel();
			sm.qureystu("select * from student", null);
			jt.setModel(sm);			
			
			
			
		}else if(e.getSource()==jb5){
			sm=new Stumodel();
			sm.qureystu("select * from student", null);
			jt.setModel(sm);
		}
	}

}
