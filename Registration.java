package aywon;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.Date;


public class Registration extends JFrame implements ActionListener{
     private Container c;FirstFrame f;
    private JButton button1,button2;
    private JLabel label1,label2,label3,label4,label5;
    private Font f1,f2,f3;
    private JTextField t1,t2,t3,t4;
    private JPasswordField t5;
    Date date = new Date();
     @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            
     
            
            
            //JOptionPane.showMessageDialog (this, "Hello", "Error", 3);   
     Database db = new Database();
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));  
        FirstFrame temp = new FirstFrame ();
        String s=" ";
         String s1=" ";
        
            String query = "INSERT INTO `user` (`user_name`,`phone_number`,`gmail`,`password`,date) VALUES ('"+t1.getText()+"', '"+t2.getText()+"', '"+t3.getText()+"', '"+t5.getText()+"','"+dtf.format(now)+"');";
            //JOptionPane.showMessageDialog (this, query, "Error", 3);
            System.out.println(query);
            if(t2.getText().equals("")||t1.getText().equals("")||t3.getText().equals("")||t5.getText().equals(""))
                    {JOptionPane.showMessageDialog(this,"Please give all informations");}
            
            else{
            
            try 
            {
                db.openConnection();
                //JOptionPane.showMessageDialog (this, query, "Error", 3);
                db.st.executeUpdate (query);
                db.closeConnection();
                System.out.println("Done");
              temp.setIDPASS (t2.getText(), t5.getText());
               temp.setVisible (true);
                this.setVisible (false);
                
            } catch (ClassNotFoundException ex) 
            {
                System.out.println("An error has occured\n");
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) 
            {
                System.out.println("There is an error\n");
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
        } }
            else if(e.getSource()==button2){
                     FirstFrame f1 = new FirstFrame ();
            f1.setVisible(true);
            this.setVisible(false);
                    }
    
    }

 Registration(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        setTitle("Registration");
        setResizable(false);
        
        f1=new Font("Arial",Font.BOLD,40);
        
        f2=new Font("Cooper Black",Font.BOLD,50);
        f3=new Font("Arial",Font.BOLD,20);
        
         c=this.getContentPane();
         c.setLayout(null);
         c.setBackground(new Color(0,0,0));
        
           label1 = new JLabel("Name:");
           //label1.setText("Welcome To");
           label1.setBounds(92,150,160,70);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           c.add(label1);
           
           label2 = new JLabel("Phone Number:");
           //label1.setText("Welcome To");
           label2.setBounds(92,250,360,70);
           label2.setForeground(Color.WHITE);
           label2.setFont(f1);
           c.add(label2);
           
           label3 = new JLabel("Gmail:");
           //label1.setText("Welcome To");
           label3.setBounds(92,350,360,70);
           label3.setForeground(Color.WHITE);
           label3.setFont(f1);
           c.add(label3);
           
           
           label4 = new JLabel("Set Password:");
           //label1.setText("Welcome To");
           label4.setBounds(92,450,360,70);
           label4.setForeground(Color.WHITE);
           label4.setFont(f1);
           c.add(label4);
           
           label5 = new JLabel("Personal Information");
           //label1.setText("Welcome To");
           label5.setBounds(154,35,700,100);
           label5.setForeground(Color.RED);
           label5.setFont(f2);
           c.add(label5);
           
            /*label2 = new JLabel("Phone Number:");
           //label1.setText("Welcome To");
           label2.setBounds(92,304,360,70);
           label2.setForeground(Color.WHITE);
           label2.setFont(f1);
           c.add(label2);
            label3 = new JLabel("Password:");
           //label1.setText("Welcome To");
           label3.setBounds(92,415,360,70);
           label3.setForeground(Color.WHITE);
           label3.setFont(f1);
           c.add(label3);*/
           
         
           t1 = new JTextField("");
           //label1.setText("Welcome To");
           t1.setBounds(227,150,536,70);
           //t1.setForeground(Color.WHITE);
           t1.setFont(f1);
           c.add(t1);
           
           t2 = new JTextField("");
           //label1.setText("Welcome To");
           t2.setBounds(400,250,360,70);
           //t2.setForeground(Color.WHITE);
           t2.setFont(f1);
           c.add(t2);
           
           t3 = new JTextField("");
           //label1.setText("Welcome To");
           t3.setBounds(227,350,536,70);
           //t2.setForeground(Color.WHITE);
           t3.setFont(f1);
           c.add(t3);
           
           
           t5 = new JPasswordField("");
           //label1.setText("Welcome To");
           t5.setBounds(374,455,384,70);
           //t2.setForeground(Color.WHITE);
           t5.setFont(f1);
           c.add(t5);
           
           
           button1 = new JButton("Confirm");
           //label1.setText("Welcome To");
           button1.setBounds(700,550,150,70);
           button1.setForeground(Color.RED);
           button1.setFont(f3);
           button1.setBackground(Color.GREEN);
           c.add(button1);
           
          button2 = new JButton("Previous");
           //label1.setText("Welcome To");
           button2.setBounds(200,550,200,70);
          button2.setForeground(Color.BLACK);
          button2.setBackground(Color.GRAY);
           button2.setFont(f3);
           c.add(button2);
           
           
           /*button3 = new JButton("Back");
           //label1.setText("Welcome To");
           button3.setBounds(590,415,200,70);
          // button2.setForeground(Color.WHITE);
           button3.setFont(f3);
           c.add(button3);*/
          
           button1.addActionListener(this); 
           button2.addActionListener(this); 
         addMouseListener(new MouseSensor());
         addMouseMotionListener(new MouseSensor());      
        
    }
                          

 void setPrevious(FirstFrame f){
    
        this.f=f;
        
    }
    FirstFrame getPrevious(){
        return f;
    }
}