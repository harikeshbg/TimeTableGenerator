package javaopenendedtt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class page1 extends JFrame implements ActionListener
{
	JButton login,time;
	page1()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login=new JButton("ADD TEACHER");
		time=new JButton("Generate Time Table");
		setVisible(true);
		setSize(1600,800);
		setLayout(null);
		login.setSize(300,40);
		login.setLocation(300,300);
		login.addActionListener(this);
		add(login);
		time.setSize(300,40);
		time.setLocation(900,300);
		time.addActionListener(this);
		add(time);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String ActionPerformed = ae.getActionCommand();
		if(ActionPerformed.equals("ADD TEACHER"))
           {
			   dispose();
        	   new page1tt();
           }
		if(ActionPerformed.equals("Generate Time Table"))
        {
			 dispose();
     	   new generate();
        }
	}
	public static void main(String args[])
	{
		new adminlogin();
	}
}
