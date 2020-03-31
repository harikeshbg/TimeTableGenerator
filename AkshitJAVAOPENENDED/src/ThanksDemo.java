import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class thanks extends JFrame
{
     //ImageIcon icon = new ImageIcon(new ImageIcon("emoji.jpg").getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT));
     JFrame f=new JFrame();
     //JLabel label=new JLabel(icon);
     JLabel head;
     public thanks()
     {
         head=new JLabel("SCHOLARSHIP AQUIRED");
         Font f1=new Font("TimesRoman",Font.BOLD,40);
         setTitle("Thank You");
         //add(label,BorderLayout.CENTER);
         f.add(head);
         head.setFont(f1);
        head.setBounds(570,0,700,80);
        //f.setSize(2100,1500);
        //f.setBackground(Color.WHITE);
        //setVisible(true);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);
        f.setSize(2100,1500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
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
       // System.out.println(uname);
       // System.out.println(pass);
        try{
            java.sql.Statement s=conn.createStatement();
            String query="SELECT percent,income FROM application ";
            //String query="INSERT INTO signup values ('akshit','akki')";
            java.sql.ResultSet r= s.executeQuery(query);
            System.out.println(r);
           int size=0;
           int count=0;
            while (r.next()) {

                size++;
                System.out.println("Entered 1 while");
            }
            
            float per[]=new float[size];
            float inc[]=new float[size];
            while (r.next()) {


                per[count]= r.getFloat("percent");
                inc[count]=  r.getFloat("income");
                count++;
                System.out.println("Entered 2 while");
            }
            
            
            System.out.println(per[size-1]);
           //System.out.println(x.percent);
            //System.out.println("Data inserted");
        }
        catch(Exception e)
        {
            System.out.println("Insert exception" + e);
            System.exit(1);
        }
     }
}
class ThanksDemo
{
    public static void main(String args[])
    {
        thanks frame=new thanks();
    }
}