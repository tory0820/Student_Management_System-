package com.Student_Management_System_final;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class StuUpdDia extends JDialog implements ActionListener {
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	
	public StuUpdDia(Frame owner, String title, boolean modal,Stumodel sm,int row){
		super(owner,title,modal);
		jl1=new JLabel("Student ID:");
		jl2=new JLabel("Name:");
		jl3=new JLabel("Age:");
		jl4=new JLabel("Gender:");
		jl5=new JLabel("Department:");
		jl6=new JLabel("GPA:");

		
		jtf1=new JTextField();
		jtf1.setText(sm.getValueAt(row, 0).toString());
		jtf1.setEditable(false);
		jtf2=new JTextField();
		jtf2.setText(sm.getValueAt(row, 1).toString());
		jtf3=new JTextField();
		jtf3.setText(sm.getValueAt(row, 2).toString());
		jtf4=new JTextField();
		jtf4.setText(sm.getValueAt(row, 3).toString());
		jtf5=new JTextField();
		jtf5.setText(sm.getValueAt(row, 4).toString());
		jtf6=new JTextField();
		jtf6.setText(sm.getValueAt(row, 5).toString());
		
		jb1=new JButton("Update");
		jb1.addActionListener(this);
		jb2=new JButton("Cancel");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.setSize(300,200);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jb1){
			String sql="update student set studentName=?,studentage=?,studentgender=?,studentdept=?,studentGPA=? where studentID=?";
			String []paras={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
			Stumodel temp=new Stumodel();
			temp.updstu(sql, paras);
			this.dispose();
		}
	}
}
