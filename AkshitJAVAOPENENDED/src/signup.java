import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class signup
{
    JFrame f;
    JTextField text1,text2;
    JLabel label1,label2,background,title;
    JButton SUBMIT;
    signup()
    {
        f=new JFrame("SIGNUP FORM");
        Font f1=new Font("TimesRoman",Font.BOLD,14);
        Font f2=new Font("TimesRoman",Font.BOLD,40);
        text1=new JTextField(15);
        text2=new JPasswordField(15);
        SUBMIT=new JButton("SUBMIT");
        label1=new JLabel("CREATE  USERNAME");
        label2=new JLabel("CREATE  PASSWORD");
        title =new JLabel("SIGNUP");
        //background=new JLabel(new ImageIcon("C:\\Users\\PRABHU T P\\Music\\Java Openended\\b1"));
        f.add(title);
        f.add(label1);
        f.add(text1);
        f.add(label2);
        f.add(text2);
        f.add(SUBMIT);
        f.getContentPane().setBackground(Color.CYAN);
        title.setFont(f2);
        label1.setFont(f1);
        label2.setFont(f1);
        text1.setFont(f1);
        text2.setFont(f1);
        //f.pack();
        //f.add(background);
        title.setBounds(560,100,450,200);
        label1.setBounds(420,220,500,250);
        text1.setBounds(570,320,300,50);
        label2.setBounds(420,260,500,290);
        text2.setBounds(570,380,300,50);
        SUBMIT.setBounds(420,440,150,25);
        f.setLayout(null);
        //f.setLayout(new GridLayout(3,4));
        f.setSize(2100,1500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        SUBMIT.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String uname=text1.getText();
                String pass=text2.getText();
                java.sql.Connection conn=null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                    //conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship?user=root&password=");
                    //java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship","root","");
                    conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship","root","");
                    //PreparedStatement s=conn.prepareStatement("INSERT INTO signup values ("+uname+","+pass+")");
                    //ResultSet res=s.execute();
                }
                catch(ClassNotFoundException e)
                {
                    System.out.println("class not found exception");
                    System.exit(1);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    System.exit(1);
                }
                System.out.println("Connectiom Established");
                System.out.println(uname);
                System.out.println(pass);
                try{
                    java.sql.Statement s=conn.createStatement();
                   String query="INSERT INTO signup values ('"+uname+"','"+pass+"')";
                    //String query="INSERT INTO signup values ('akshit','akki')";
                    s.execute(query);
                    System.out.println("Data inserted");
                }
                catch(Exception e)
                {
                    System.out.println("Insert exception" + e);
                    System.exit(1);
                }
                //conn.close();
                if(!(text1.getText().equals("")) && !(text2.getText().equals("")) )
                {
                    f.dispose();
                    new login();
                }
            }
        });
    }
    public static void main(String args[])
    {
        new signup();
    }
}