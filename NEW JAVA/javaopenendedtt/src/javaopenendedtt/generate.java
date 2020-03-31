package javaopenendedtt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class generate extends JFrame implements ActionListener
{
	JButton sem3,sem5,sem7,back;
	String data3[][]=new String[6][10];
    String data5[][]=new String[6][10];
    String data7[][]=new String[6][10];
	generate()
	{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sem3=new JButton("3 SEM");
		sem5=new JButton("5 SEM");
		sem7=new JButton("7 SEM");
		back=new JButton("BACK");
		setVisible(true);
		setSize(1600,800);
		setLayout(null);
		sem3.setSize(300,40);
		sem3.setLocation(200,300);
		sem3.addActionListener(this);
		add(sem3);
		sem5.setSize(300,40);
		sem5.setLocation(600,300);
		sem5.addActionListener(this);
		add(sem5);
		sem7.setSize(300,40);
		sem7.setLocation(1000,300);
		sem7.addActionListener(this);
		add(sem7);
		back.setSize(300,40);
		back.setLocation(600,600);
		add(back);
		back.addActionListener(this);
		String timetablem[][]=new String[3][9];
		String timetablet[][]=new String[3][9];
		String timetablew[][]=new String[3][9];
		String timetableth[][]=new String[3][9];
		String timetablef[][]=new String[3][9];
		String timetables[][]=new String[3][9];
		Connection conn=null;
		try
		{
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtimetable","root","");
            String q1 = "select sname,hours from professordetails";
            Statement s=conn.createStatement();
            ResultSet r=s.executeQuery(q1);
            r.last();
            int x=r.getRow();
            r.first();
            String professors[]=new String[x];
            int whrs[]=new int[x];
            int i=0;
            //System.out.println("Snames of professors");
            do 
            {
            	professors[i]=r.getString(1);
            	whrs[i]=Integer.parseInt(r.getString(2));
            	//System.out.println(professors[i]+"	"+whrs[i]);
            	i++;
            }while(r.next());
           /* for(int p=0;p<3;p++)
            	for(int q=0;q<9;q++)
            		timetable[p][q]="";*/
            for(int a=0;a<3;a++)
            {
            	timetablem[a][2]="small-break";
            	timetablem[a][5]="lunch-break";
            	timetablet[a][2]="small-break";
            	timetablet[a][5]="lunch-break";
            	timetablew[a][2]="small-break";
            	timetablew[a][5]="lunch-break";
            	timetableth[a][2]="small-break";
            	timetableth[a][5]="lunch-break";
            	timetablef[a][2]="small-break";
            	timetablef[a][5]="lunch-break";
            	timetables[a][2]="small-break";
            	//timetables[a][5]="lunch-break";
            }
            int svtrackm=0;
            for(int b=0;b<3;b++)
            {	
            	int index=svtrackm;
            	for(int j=0;j<9;j++)
            	{	
            		if(j!=2 && j!=5)
	            	{	
            			if(svtrackm>0&&index==x)
	            			index=(index)%(x);
	            		timetablem[b][j]=professors[index];
	            		index=index+1;
	            	}
            	}
            	svtrackm++;
            }
            System.out.println("MONDAY");
            int z=3;
            for(int d=0;d<3;d++)
            {
            	System.out.print(z+" ");
            	for(int m=0;m<9;m++)
            		System.out.print(timetablem[d][m]+"	");
            	System.out.println();
            	z=z+2;
            }
            int svtrackt=1;
            for(int b=0;b<3;b++)
            {	
            	int index=svtrackt;
            	for(int j=0;j<9;j++)
            	{	
            		if(j!=2 && j!=5)
	            	{	
            			if(svtrackt>0&&index==x)
	            			index=(index)%(x);
	            		timetablet[b][j]=professors[index];
	            		index=index+1;
	            	}
            	}
            	svtrackt++;
            }
            System.out.println("TUESDAY");
            int z1=3;
            for(int d=0;d<3;d++)
            {
            	System.out.print(z1+" ");
            	for(int m=0;m<9;m++)
            		System.out.print(timetablet[d][m]+"	");
            	System.out.println();
            	z1=z1+2;
            }
            int svtrackw=2;
            for(int b=0;b<3;b++)
            {	
            	int index=svtrackw;
            	for(int j=0;j<9;j++)
            	{	
            		if(j!=2 && j!=5)
	            	{	
            			if(svtrackw>0&&index==x)
	            			index=(index)%(x);
	            		timetablew[b][j]=professors[index];
	            		index=index+1;
	            	}
            	}
            	svtrackw++;
            }
            System.out.println("WEDNESDAY");
            int z11=3;
            for(int d=0;d<3;d++)
            {
            	System.out.print(z11+" ");
            	for(int m=0;m<9;m++)
            		System.out.print(timetablew[d][m]+"	");
            	System.out.println();
            	z11=z11+2;
            }
            int svtrackth=3;
            for(int b=0;b<3;b++)
            {	
            	int index=svtrackth;
            	for(int j=0;j<9;j++)
            	{	
            		if(j!=2 && j!=5)
	            	{	
            			if(svtrackth>0&&index==x)
	            			index=(index)%(x);
	            		timetableth[b][j]=professors[index];
	            		index=index+1;
	            	}
            	}
            	svtrackth++;
            }
            System.out.println("THURSDAY");
            int z111=3;
            for(int d=0;d<3;d++)
            {
            	System.out.print(z111+" ");
            	for(int m=0;m<9;m++)
            		System.out.print(timetableth[d][m]+"	");
            	System.out.println();
            	z111=z111+2;
            }
            int svtrackf=4;
            for(int b=0;b<3;b++)
            {	
            	int index=svtrackf;
            	for(int j=0;j<9;j++)
            	{	
            		if(j!=2 && j!=5)
	            	{	
            			if(svtrackf>0&&index==x)
	            			index=(index)%(x);
	            		timetablef[b][j]=professors[index];
	            		index=index+1;
	            	}
            	}
            	svtrackf++;
            }
            System.out.println("FRIDAY");
            int z1111=3;
            for(int d=0;d<3;d++)
            {
            	System.out.print(z1111+" ");
            	for(int m=0;m<9;m++)
            		System.out.printf(timetablef[d][m]+"	");
            	System.out.println();
            	z1111=z1111+2;
            }
            int svtracks=5;
            for(int b=0;b<3;b++)
            {	
            	int index=svtracks;
            	for(int j=0;j<5;j++)
            	{	
            		if(j!=2 && j!=5)
	            	{	
            			if(svtracks>0&&index==x)
	            			index=(index)%(x);
	            		timetables[b][j]=professors[index];
	            		index=index+1;
	            	}
            	}
            	svtracks++;
            }
            System.out.println("SATURDAY");
            int z11111=3;
            for(int d=0;d<3;d++)
            {
            	System.out.print(z11111+" ");
            	for(int m=0;m<5;m++)
            		System.out.print(timetables[d][m]+"	");
            	System.out.println();
            	z11111=z11111+2;
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(1);
        }
        System.out.println("Connection Established");
        data3[0][0]="MON";
        data3[1][0]="TUE";
        data3[2][0]="WED";
        data3[3][0]="THU";
        data3[4][0]="FRI";
        data3[5][0]="SAT";
        data5[0][0]="MON";
        data5[1][0]="TUE";
        data5[2][0]="WED";
        data5[3][0]="THU";
        data5[4][0]="FRI";
        data5[5][0]="SAT";
        data7[0][0]="MON";
        data7[1][0]="TUE";
        data7[2][0]="WED";
        data7[3][0]="THU";
        data7[4][0]="FRI";
        data7[5][0]="SAT";
        for(int i=0;i<9;i++)
        {
        	data3[0][i+1]=timetablem[0][i];
        	data5[0][i+1]=timetablem[1][i];
        	data7[0][i+1]=timetablem[2][i];
        	data3[1][i+1]=timetablet[0][i];
        	data5[1][i+1]=timetablet[1][i];
        	data7[1][i+1]=timetablet[2][i];
        	data3[2][i+1]=timetablew[0][i];
        	data5[2][i+1]=timetablew[1][i];
        	data7[2][i+1]=timetablew[2][i];
        	data3[3][i+1]=timetableth[0][i];
        	data5[3][i+1]=timetableth[1][i];
        	data7[3][i+1]=timetableth[2][i];
        	data3[4][i+1]=timetablef[0][i];
        	data5[4][i+1]=timetablef[1][i];
        	data7[4][i+1]=timetablef[2][i];
        	data3[5][i+1]=timetables[0][i];
        	data5[5][i+1]=timetables[1][i];
        	data7[5][i+1]=timetables[2][i];
        }
		
		//j.setBounds(30, 40, 200, 300); 
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		JFrame f = new JFrame();
        JTable j;
		String ActionPerformed = ae.getActionCommand();
		if(ActionPerformed.equals("3 SEM"))
           {
			String[] columnNames = { "DAYS", "8:00-9:00", "9:00-10:00","10:00-10:30","10:30-11:30","11:30-12:30","12:30-2:00","2:00-3:00","3:00-4:00","4:00-5:00" }; 
			j = new JTable(data3, columnNames);
			j.setDefaultEditor(Object.class, null);
			JScrollPane sp = new JScrollPane(j); 
			f.add(sp); 
			f.setSize(1600,800); 
			f.setVisible(true); 
           }
		if(ActionPerformed.equals("5 SEM"))
        {
			String[] columnNames = { "DAYS", "8:00-9:00", "9:00-10:00","10:00-10:30","10:30-11:30","11:30-12:30","12:30-2:00","2:00-3:00","3:00-4:00","4:00-5:00" }; 
			j = new JTable(data5, columnNames);
			j.setDefaultEditor(Object.class, null);
			JScrollPane sp = new JScrollPane(j); 
			f.add(sp); 
			f.setSize(1600,800); 
			f.setVisible(true); 
        }
		if(ActionPerformed.equals("7 SEM"))
        {
			String[] columnNames = { "DAYS", "8:00-9:00", "9:00-10:00","10:00-10:30","10:30-11:30","11:30-12:30","12:30-2:00","2:00-3:00","3:00-4:00","4:00-5:00" }; 
			j = new JTable(data7, columnNames);
			j.setDefaultEditor(Object.class, null);
			JScrollPane sp = new JScrollPane(j); 
			f.add(sp); 
			f.setSize(1600,800); 
			f.setVisible(true); 
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

