import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class first 
{
    JFrame f;
    JButton signup,login;
    JLabel jlab1,jlab2,title;
    first()
    {
        f = new JFrame("HOME PAGE");
        Font f1=new Font("TimesRoman",Font.BOLD,16);
        Font f2=new Font("TimesRoman",Font.BOLD,32);
        signup = new JButton("Sign Up");
        login = new JButton("Login");
        jlab1 = new JLabel("Click on Sign Up to create an account");
        jlab2 = new JLabel("Login to an existing account");
        title = new JLabel("HOME PAGE");
        title.setFont(f2);
        jlab1.setFont(f1);
        jlab2.setFont(f1);
        f.add(jlab1);
        f.add(signup);
        f.add(jlab2);
        f.add(login);
        f.add(title);
        title.setBounds(550,50,450,200);
        jlab1.setBounds(540,200,450,200);
        signup.setBounds(520,320,300,50);
        jlab2.setBounds(540,285,450,200);
        login.setBounds(520,400,300,50);
        f.setLayout(null);
        f.setSize(2100,1500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        signup.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                f.dispose();
                new signup();
            }
        });
        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                f.dispose();
                new login();
            }
        });
    }
    public static void main(String[] args)
    {
        new first();
    }
}