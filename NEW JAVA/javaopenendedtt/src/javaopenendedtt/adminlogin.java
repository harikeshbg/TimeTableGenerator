package javaopenendedtt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminlogin extends JFrame implements ActionListener
{
	JLabel title=new JLabel("Time Table Generator");

	
	JButton login;
	adminlogin()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1600,800);
		setLayout(null);
		title.setFont(new Font(title.getName(),Font.PLAIN,50));
		login=new JButton("ADMIN");
		title.setSize(700,50);
		title.setLocation(530,200);
		login.setSize(300,40);
		login.setLocation(600,300);
		login.addActionListener(this);
		add(login);
		add(title);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String ActionPerformed = ae.getActionCommand();
		if(ActionPerformed.equals("ADMIN"))
           {
        	   dispose();
        	   new page1();
           }
		
	}
	public static void main(String args[])
	{
		new adminlogin();
	}
}
