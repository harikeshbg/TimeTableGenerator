package javaopenendedtt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class page2 extends JFrame implements ActionListener
{
	JButton login,back;
	page2()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login=new JButton("ADD ONE MORE TEACHER");
		back=new JButton("BACK");
		setVisible(true);
		setSize(1600,800);
		setLayout(null);
		login.setSize(300,40);
		login.setLocation(300,300);
		login.addActionListener(this);
		add(login);
		back.setSize(300,40);
		back.setLocation(900,300);
		back.addActionListener(this);
		add(back);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String ActionPerformed = ae.getActionCommand();
		if(ActionPerformed.equals("ADD ONE MORE TEACHER"))
           {
			 dispose();
        	   new page1tt();
           }
		if(ActionPerformed.equals("BACK"))
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
