
 
package aywon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Medicine extends JFrame implements ActionListener{
    
   
    private Container c;Frame2 f;
    private JButton button1,button2;
    private JLabel label1,label2,label3;
    private Font f1,f2,f3;
    private JTextField t1;
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
    
    Medicine(String use){
        this.use=use;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        setTitle("Search Medicine");
        setResizable(false);
        
        f1=new Font("Arial",Font.BOLD,40);
        
        f2=new Font("Cooper Black",Font.BOLD,60);
        f3=new Font("Arial",Font.BOLD,20);
        
         c=this.getContentPane();
         c.setLayout(null);
         c.setBackground(new Color(0,0,0));
        
           label1 = new JLabel("Medicine:");
           //label1.setText("Welcome To");
           label1.setBounds(92,250,360,70);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           c.add(label1);
           
            label2 = new JLabel("Search Medicine");
           //label1.setText("Welcome To");
           label2.setBounds(180,122,600,70);
           label2.setForeground(Color.RED);
           label2.setFont(f2);
           c.add(label2);
           
            /*label3 = new JLabel("Appointment");
           //label1.setText("Welcome To");
           label3.setBounds(300,130,360,70);
           label3.setForeground(Color.WHITE);
           label3.setFont(f1);
           c.add(label3);*/
         
           t1 = new JTextField("");
           //label1.setText("Welcome To");
           t1.setBounds(280,250,360,70);
           //t1.setForeground(Color.WHITE);
           t1.setFont(f1);
           c.add(t1);
           
           /*t2 = new JPasswordField("");
           //label1.setText("Welcome To");
           t2.setBounds(400,390,360,70);
           //t2.setForeground(Color.WHITE);
           t2.setFont(f1);
           c.add(t2);*/
           
           button1 = new JButton("Previous");
           //label1.setText("Welcome To");
           button1.setBounds(353,485,160,50);
           button1.setForeground(Color.YELLOW);
           button1.setBackground(Color.BLUE);
           button1.setFont(f3);
           c.add(button1);
          //button1.addActionListener(this);
           
          button2 = new JButton("Search");
           //label1.setText("Welcome To");
           button2.setBounds(353,385,160,50);
          button2.setForeground(Color.WHITE);
          button2.setBackground(Color.BLACK);
           button2.setFont(f3);
           c.add(button2);
           
           
         button1.addActionListener(this); 
         button2.addActionListener(this);
         addMouseListener(new MouseSensor());
         addMouseMotionListener(new MouseSensor());
         
        
        
    }

    //@Override
 public void actionPerformed(ActionEvent e)
    {
        
        //JOptionPane.showMessageDialog (this, "Please input medicine name");  
        if(e.getSource()==button2){
           //Connection con = null;
           
            try {
               // Statement stmt = con.createStatement();
                String query = "select Price from medicine where Medicine_Name = '"+t1.getText()+"'";
                //
                Database db = new Database ();
                //MedicineInfo mi=new MedicineInfo();
               // try {
                //db.openConnection();
                db.eQuery(query);
                if (db.rs.next()==true)
                {
               new MedicineInfo(t1.getText(),db.rs.getString("Price"),use).setVisible(true);
                 this.setVisible (false);
                }
                //ResultSet r =db.rs;
                else {
        
                              
//mi.setPrice(db.rs.getString("m_price"));
                //mi.setVisible (true);
         
                 //JOptionPane.showMessageDialog (this, "Please input medicine name");
                String query1 = "select price from unavailable where m_name = '"+t1.getText()+"'";
               // System.out.println(query1);
                Database db1 = new Database ();
                //MedicineInfo mi=new MedicineInfo();
               // try {
                //db.openConnection();
                db1.eQuery(query1);
                db1.rs.next();
                new UnavailableMedicine(t1.getText(),db1.rs.getString("price"),use).setVisible(true); 
                
                this.setVisible (false);
                }
                db.closeConnection();
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (SQLException ex) {
                Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
                }
        }  
      else if(e.getSource()==button1){
          Frame2 f2 = new Frame2(use);
            f2.setVisible(true);
            this.setVisible(false); 
      }
      
}
}
  
        

    

