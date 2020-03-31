import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class app
{
    JFrame f;
    //JTextField text1,text2;
    JLabel head,name,address,district,state,pincode,dob,father,mother,email,h2,nation,income,percent;
    JTextField namet,addresst,districtt,statet,pincodet,dobt,fathert,mothert,emailt,incomet,percentt,nationt;
    JButton SUBMIT;
    app()
    {
        f=new JFrame("SCHOLORSHIP FORM");
        Font f1=new Font("TimesRoman",Font.BOLD,40);
        Font f2=new Font("TimesRoman",Font.PLAIN,25);
        Font f3=new Font("TimesRoman",Font.BOLD,33);
        SUBMIT=new JButton("SUBMIT");
        nation=new JLabel("Nationality");
        income=new JLabel("Annual Income");
        percent=new JLabel("12th Percentage");
        head=new JLabel("SCHOLARSHIP FORM");
        name=new JLabel("Student name");
        address=new JLabel("Address");
        district=new JLabel("District");
        state=new JLabel("State");
        pincode=new JLabel("Pincode");
        dob=new JLabel("Date of Birth");
        father=new JLabel("Father name");
        mother=new JLabel("Mother name");
        email=new JLabel("Email");
        h2=new JLabel("Personal Information");
        namet=new JTextField(15);
        incomet=new JTextField(10);
        percentt=new JTextField(10);
        nationt=new JTextField(15);
        addresst=new JTextField(15);
        districtt=new JTextField(15);
        statet=new JTextField(15);
        pincodet=new JTextField(15);
        dobt=new JTextField(15);
        fathert=new JTextField(15);
        mothert=new JTextField(15);
        emailt=new JTextField(15);
        f.add(head);
        f.add(income);
        f.add(incomet);
        f.add(nation);
        f.add(nationt);
        f.add(percent);
        f.add(percentt);
        f.add(name);
        f.add(address);
        f.add(district);
        f.add(state);
        f.add(pincode);
        f.add(dob);
        f.add(father);
        f.add(mother);
        f.add(email);
        f.add(namet);
        f.add(addresst);
        f.add(districtt);
        f.add(statet);
        f.add(pincodet);
        f.add(dobt);
        f.add(fathert);
        f.add(mothert);
        f.add(emailt);
        f.add(h2);
        f.add(SUBMIT);
        nation.setFont(f2);
        percent.setFont(f2);
        income.setFont(f2);
        head.setFont(f1);
        name.setFont(f2);
        address.setFont(f2);
        district.setFont(f2);
        state.setFont(f2);
        pincode.setFont(f2);
        dob.setFont(f2);
        father.setFont(f2);
        mother.setFont(f2);
        email.setFont(f2);
        h2.setFont(f3);
        nation.setBounds(900,180,200,30);
        percent.setBounds(900,240,200,30);
        income.setBounds(900,300,200,30);
        nationt.setBounds(1100,180,200,30);
        percentt.setBounds(1100,240,200,30);
        incomet.setBounds(1100,300,200,30);
        head.setBounds(570,0,700,80);
        name.setBounds(30,180,200,30);
        address.setBounds(30,240,200,30);
        district.setBounds(30,300,200,30);
        state.setBounds(30,360,200,30);
        pincode.setBounds(30,420,200,30);
        dob.setBounds(30,480,200,30);
        father.setBounds(30,540,200,30);
        mother.setBounds(30,600,200,30);
        email.setBounds(30,660,200,30);
        h2.setBounds(60,110,350,30);
        namet.setBounds(250,180,250,30);
        addresst.setBounds(250,240,280,30);
        districtt.setBounds(250,300,250,30);
        statet.setBounds(250,360,250,30);
        pincodet.setBounds(250,420,230,30);
        dobt.setBounds(250,480,230,30);
        fathert.setBounds(250,540,250,30);
        mothert.setBounds(250,600,250,30);
        emailt.setBounds(250,660,280,30);
        SUBMIT.setBounds(1100,360,200,30);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);
        f.setSize(2100,1500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        SUBMIT.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
            	String name=namet.getText();
                String addr=addresst.getText();
                String dist=districtt.getText();
                String state=statet.getText();
                String pincode=pincodet.getText();
                //String pincode=Integer.parseInt(pin);
                String dob=dobt.getText();
                String father=fathert.getText();
                String mother=mothert.getText();
                String email=emailt.getText();
                String inc=incomet.getText();
                float income=Float.parseFloat(inc);
                String per=percentt.getText();
                float percent=Float.parseFloat(per);
                String nation=nationt.getText();
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
                   String query="INSERT INTO application values ('"+name+"','"+addr+"','"+dist+"','"+state+"','"+dob+"','"+father+"','"+mother+"','"+email+"',"+percent+",'"+nation+"',"+income+",'"+pincode+"')";
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
            	if(!(namet.getText().equals("")) && !(addresst.getText().equals("")) && !(districtt.getText().equals("")) && !(statet.getText().equals("")) && !(pincodet.getText().equals("")) && !(dobt.getText().equals("")) && !(fathert.getText().equals("")) && !(mothert.getText().equals("")) && !(emailt.getText().equals("")) )
                {
                    f.dispose();
                    new app();
            		/*try{
                        java.sql.Statement s1=conn.createStatement();
                       String query="INSERT INTO application values ('"+name+"','"+addr+"','"+dist+"','"+state+"','"+dob+"','"+father+"','"+mother+"','"+email+"',"+percent+",'"+nation+"',"+income+",'"+pincode+"')";
                        //String query="INSERT INTO signup values ('akshit','akki')";
                        s1.execute(query);
                        System.out.println("Data inserted");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Insert exception" + e);
                        System.exit(1);
                    }*/
                }
            }
        });
    }
    public static void main(String args[])
    {
        new app();
    }
}