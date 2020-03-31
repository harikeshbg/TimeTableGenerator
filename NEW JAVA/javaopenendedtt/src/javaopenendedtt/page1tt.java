package javaopenendedtt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class page1tt extends JFrame implements ActionListener
{
	JButton submit,back;
	JLabel id,name,sname,hours;
	JTextField idfld,namefld,snamefld,hoursfld;
    page1tt()
    {
    	setVisible(true);
		setSize(1600,800);
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        id=new JLabel("  ID  :");
        id.setSize(250,30);
        id.setLocation(300,100);
        idfld=new JTextField(45);
        idfld.setSize(250,30);
        idfld.setLocation(300,150);
        name=new JLabel("NAME  :");
        name.setSize(250,30);
        name.setLocation(300,200);
        namefld=new JTextField(45);
        namefld.setSize(250,30);
        namefld.setLocation(300,250);
        sname=new JLabel("Short Name  :");
        sname.setSize(250,30);
        sname.setLocation(300,300);
        snamefld=new JTextField(45);
        snamefld.setSize(250,30);
        snamefld.setLocation(300,350);
        hours=new JLabel("Working Hours  :");
        hours.setSize(250,30);
        hours.setLocation(300,400);
        hoursfld=new JTextField(45);
        hoursfld.setSize(250,30);
        hoursfld.setLocation(300,450);
        submit=new JButton("SUBMIT");
        submit.setSize(250,30);
        submit.setLocation(300,500);
        back=new JButton("BACK");
        back.setSize(250,30);
        back.setLocation(300,550);
        add(id);
        add(idfld);
        add(name);
        add(namefld);
        add(sname);
        add(snamefld);
        add(hours);
        add(hoursfld);
        add(submit);
        add(back);
        setVisible(true);
        submit.addActionListener(this);
        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {   
    	String ActionPerformed = ae.getActionCommand();
    	int phrs;
    	 phrs=Integer.parseInt(hoursfld.getText());
	        if(phrs>24)
	        	JOptionPane.showMessageDialog(null, "Working Hours is too high","error",JOptionPane.ERROR_MESSAGE);
	        else if(phrs<1)
	        	JOptionPane.showMessageDialog(null, "Invalid Working Hours","error",JOptionPane.ERROR_MESSAGE);
	        else if(ActionPerformed.equals("SUBMIT"))
           {
			String pname,pid,psname;
	        pid=idfld.getText();
	        pname=namefld.getText();
	        psname=snamefld.getText();
	        System.out.println(pid);
	        System.out.println(pname);
	        System.out.println(psname);
	        System.out.println(phrs);
	        Connection conn=null;
	        try{
	            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtimetable","root","");
	            String q1 = "insert into professordetails(id,name,hours,sname)"+"values(?,?,?,?)";
	            PreparedStatement ps = conn.prepareStatement(q1);
	            ps.setString(1, pid);
	            ps.setString(2, pname);
	            ps.setInt(3, phrs);
	            ps.setString(4, psname);
	            ps.execute();
	            
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	            System.exit(1);
	        }
	        System.out.println("Connection Established");
	        dispose();
			new page2();
           }
	        else if(ActionPerformed.equals("BACK"))
        {
			dispose();
			new page1();
        }
    }
    public static void main(String args[])
    {   
    	new page1tt();
    }
}

