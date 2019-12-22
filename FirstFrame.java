package aywon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class FirstFrame extends JFrame implements ActionListener{
    
    private Container c;
    private JButton button1,button2;
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8;
    private Font f1,f2,f3,f4,f5;
    private JTextField t1;
    private JPasswordField t2;
    private String use;
   
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            
           if(e.getSource()==button1){
            
            String query = "select * from user where phone_number = '"+t1.getText()+"'";
            Database db = new Database ();
            try {
                db.eQuery(query);
                if (db.rs.next()==false) 
                    JOptionPane.showMessageDialog (this, "No such user","Error",2);
                else {
                    if (t2.getText().toString().equals(db.rs.getString("password"))) {
                       
                        use=db.rs.getString("user_name");
                        System.out.println(use);
                        new Frame2(use).setVisible(true);
                        this.setVisible(false);
                    }
                    else JOptionPane.showMessageDialog(this,"Wrong password","Error",2);
                    
                }
                
                
             db.closeConnection();   
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FirstFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FirstFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }   
            
            
        }   
        else if(e.getSource()==button2){
            
            Registration f2 = new Registration();
            f2.setVisible(true);
            this.setVisible(false);
           //f2.setPrevious(this);
            
            
        }   
        }
    
    FirstFrame(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        setTitle("Welcome to Doctor Appointment & Medicine");
        setResizable(false);
        
        f1=new Font("Arial",Font.BOLD,40);
        
        f2=new Font("Cooper Black",Font.BOLD,60);
        f3=new Font("Cooper Black",Font.BOLD,50);
        f4=new Font("Arial",Font.BOLD,80);
        f5=new Font("Arial",Font.BOLD,20);
        
         c=this.getContentPane();
         c.setLayout(null);
         c.setBackground(new Color(0,0,0));
        
           label1 = new JLabel("Welcome to");
           //label1.setText("Welcome To");
           label1.setBounds(90,90,660,70);
           label1.setForeground(Color.RED);
           label1.setFont(f2);
           c.add(label1);
           
            label2 = new JLabel("Phone Number:");
           //label1.setText("Welcome To");
           label2.setBounds(92,254,360,70);
           label2.setForeground(Color.WHITE);
           label2.setFont(f1);
           c.add(label2);
           
            label3 = new JLabel("Password:");
           //label1.setText("Welcome To");
           label3.setBounds(185,365,360,70);
           label3.setForeground(Color.WHITE);
           label3.setFont(f1);
           c.add(label3);
           
           label4 = new JLabel("Don't Have an Account?");
           //label1.setText("Welcome To");
           label4.setBounds(500,480,360,70);
           label4.setForeground(Color.RED);
           label4.setFont(f5);
           c.add(label4);
           
           label5 = new JLabel("Doctor");
           //label1.setText("Welcome To");
           label5.setBounds(500,23,360,70);
           label5.setForeground(Color.WHITE);
           label5.setFont(f3);
           c.add(label5);
           
           label6 = new JLabel("Appointment");
           //label1.setText("Welcome To");
           label6.setBounds(500,70,600,70);
           label6.setForeground(Color.YELLOW);
           label6.setFont(f3);
           c.add(label6);
           
           label7 = new JLabel("&");
           //label1.setText("Welcome To");
           label7.setBounds(500,120,360,70);
           label7.setForeground(Color.GREEN);
           label7.setFont(f4);
           c.add(label7);
           
           label8 = new JLabel("Medicine");
           //label1.setText("Welcome To");
           label8.setBounds(500,160,360,70);
           label8.setForeground(Color.PINK);
           label8.setFont(f3);
           c.add(label8);
         
           t1 = new JTextField("");
           //label1.setText("Welcome To");
           t1.setBounds(395,254,360,70);
           t1.setForeground(Color.RED);
           t1.setFont(f1);
           c.add(t1);
           
           t2 = new JPasswordField("");
           //label1.setText("Welcome To");
           t2.setBounds(399,365,360,70);
           t2.setForeground(Color.RED);
           t2.setFont(f1);
           c.add(t2);
           
           button1 = new JButton("Login");
           //label1.setText("Welcome To");
           button1.setBounds(281,535,160,50);
           button1.setForeground(Color.WHITE);
           button1.setFont(f5);
           button1.setBackground(Color.RED);
           c.add(button1);
           
          button2 = new JButton("Registration");
           //label1.setText("Welcome To");
           button2.setBounds(530,535,160,50);
           button2.setForeground(Color.WHITE);
           button2.setFont(f5);
           button2.setBackground(Color.BLUE);
           c.add(button2);
           
           
         button1.addActionListener(this); 
         button2.addActionListener(this);
         addMouseListener(new MouseSensor());
         addMouseMotionListener(new MouseSensor());
         // Appointment ap = new Appointment();
    //ap.setVisible(true);
         
        
        
    }
   public void setIDPASS (String a, String b) {
       t1.setText(a);
       t2.setText(b);
    }

    private void JOptionPane(FirstFrame aThis, String no_such_user, String error, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
    
}
