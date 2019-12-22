package aywon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
/**
 *
 * @author pc
 */
public class UnavailableMedicine extends JFrame implements ActionListener{
    
    private Container c;
    private JButton button1,button2;
    private JLabel label1,label2,label3,label4,label5;
    private Font f1,f2,f3;
    private JTextField t1,t2,t3,t4;
    //private JPasswordField t2;
    private final String use;
    
    /*public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            
            Frame2 f2 = new Frame2();
            f2.setVisible(true);
            this.setVisible(false);
            f2.setPrevious(this);
            
            
        }   
        else if(e.getSource()==button2){
            
            Registration f2 = new Registration();
            f2.setVisible(true);
            this.setVisible(false);
            f2.setPrevious(this);
            
            
        }   
        }*/
    
    UnavailableMedicine (String bx, String ex,String use){
        this.use=use;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        setTitle("UnavailableMedicine");
        setResizable(false);
        
        f1=new Font("Arial",Font.BOLD,40);
        
        f2=new Font("Cooper Black",Font.BOLD,60);
        f3=new Font("Arial",Font.BOLD,20);
        
         c=this.getContentPane();
         c.setLayout(null);
         c.setBackground(new Color(0,0,0));
        
           label1 = new JLabel("Medicine Name:");
           //label1.setText("Welcome To");
           label1.setBounds(92,150,360,70);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           c.add(label1);
           
            label2 = new JLabel("Quantity:");
           //label1.setText("Welcome To");
           label2.setBounds(92,250,360,70);
           label2.setForeground(Color.WHITE);
           label2.setFont(f1);
           c.add(label2);
           
            label3 = new JLabel("Unavailable Medicine");
           //label1.setText("Welcome To");
           label3.setBounds(120,30,900,100);
           label3.setForeground(Color.RED);
           label3.setFont(f2);
           c.add(label3);
           
           label4 = new JLabel("Price:");
           //label1.setText("Welcome To");
           label4.setBounds(92,350,360,70);
           label4.setForeground(Color.WHITE);
           label4.setFont(f1);
           c.add(label4);
           
           /*label5 = new JLabel("Delivery Date:");
           //label1.setText("Welcome To");
           label5.setBounds(92,450,360,70);
           label5.setForeground(Color.WHITE);
           label5.setFont(f1);
           c.add(label5);
*/
         
           t1 = new JTextField("");
           t1.setText(bx);
           //label1.setText("Welcome To");
           t1.setBounds(400,150,360,70);
           //t1.setForeground(Color.WHITE);
           t1.setFont(f1);
           c.add(t1);
           
           t2 = new JTextField("");
           //label1.setText("Welcome To");
           t2.setBounds(270,255,360,70);
           //t2.setForeground(Color.WHITE);
           t2.setFont(f1);
           c.add(t2);
           
            t3 = new JTextField("");
           //label1.setText("Welcome To");
           t3.setBounds(210,355,360,70);
           //t1.setForeground(Color.WHITE);
           t3.setText(ex);
           t3.setFont(f1);
           c.add(t3);
           
          // t4 = new JTextField("");
           //label1.setText("Welcome To");
          // t4.setBounds(360,450,360,70);
           //t2.setForeground(Color.WHITE);
           //t4.setFont(f1);
           //c.add(t4);
          
           
            button1 = new JButton("Previous");
           //label1.setText("Welcome To");
           button1.setBounds(281,535,160,50);
           //button1.setForeground(Color.WHITE);
           button1.setFont(f3);
           c.add(button1);
           
          button2 = new JButton("Calculate Bill");
           //label1.setText("Welcome To");
           button2.setBounds(481,485,200,50);
          button2.setForeground(Color.WHITE);
          button2.setBackground(Color.RED);
           button2.setFont(f3);
           c.add(button2);
           
           
         button1.addActionListener(this); 
         button2.addActionListener(this);
         addMouseListener(new MouseSensor());
         addMouseMotionListener(new MouseSensor());
         
        
        
    }
   // public void setPrice(String a)
         //{ 
          //t1.setText(a);
         //  }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==button1)
        {
        Medicine f2 = new Medicine(use);
            f2.setVisible(true);
            this.setVisible(false);
        
        }
         else if(e.getSource()==button2){
            
          int a = Integer.parseInt(t2.getText());
            int  b = Integer.parseInt(t3.getText());
            int p = a*b;
            
            String s1 = t1.getText();
            String s2 = t2.getText();
            Payment f2 = new Payment(s1,s2,p,use);
            f2.setVisible(true);
            this.setVisible(false);
           //f2.setPrevious(this);
            
            
        }   
        
        
    }

  
          
    
    
}
