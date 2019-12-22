/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aywon;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class Frame2 extends JFrame implements ActionListener {
    
    private Container c; FirstFrame f;
    private JButton button1,button2,button3;
    private JLabel label1,label2,label3,label4;
    private Font f1,f2,f3,f4;
    private JTextField t1;
    private JPasswordField t2;
    private final String use;
    
    public void actionPerformed(ActionEvent e){
       
         if(e.getSource()==button1){
            
            setVisible(false);
            Appointment ap=new Appointment(use);
            ap.setVisible(true);
            //ap.setP(this);
            
            
            
        }   
        else if(e.getSource()==button2){
            
            setVisible(false);
            Medicine m = new Medicine(use);
            m.setVisible(true);
            //m.setP(this);
            
            
        }   
         else if(e.getSource()==button3){
            
            setVisible(false);
            FirstFrame m = new FirstFrame();
            m.setVisible(true);
            //m.setP(this);
            
            
        }   
        }
    
    
    Frame2(String use){
        this.use=use;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        setTitle("Registration");
        setResizable(false);
        
        f1=new Font("Arial",Font.BOLD,30);
        
        f2=new Font("Cooper Black",Font.BOLD,60);
        f3=new Font("Arial",Font.BOLD,20);
        f4=new Font("Arial",Font.BOLD,80);
        
         c=this.getContentPane();
         c.setLayout(null);
         c.setBackground(new Color(0,0,0));
        
           label1 = new JLabel("Doctor");
           //label1.setText("Welcome To");
           label1.setBounds(260,57,800,70);
           label1.setForeground(Color.WHITE);
           label1.setFont(f4);
           c.add(label1);
           
            label2 = new JLabel("Appointment");
           //label1.setText("Welcome To");
           label2.setBounds(258,137,600,70);
           label2.setForeground(Color.YELLOW);
           label2.setFont(f4);
           c.add(label2);
            label3 = new JLabel("&");
           //label1.setText("Welcome To");
           label3.setBounds(258,185,360,70);
           label3.setForeground(Color.RED);
           label3.setFont(f4);
           c.add(label3);
           
           label4 = new JLabel("Medicine");
           //label1.setText("Welcome To");
           label4.setBounds(258,236,360,70);
           label4.setForeground(Color.GREEN);
           label4.setFont(f4);
           c.add(label4);
           
         
           /*t1 = new JTextField("");
           //label1.setText("Welcome To");
           t1.setBounds(395,304,360,70);
           //t1.setForeground(Color.WHITE);
           t1.setFont(f1);
           c.add(t1);
           
           t2 = new JPasswordField("");
           //label1.setText("Welcome To");
           t2.setBounds(306,415,360,70);
           //t2.setForeground(Color.WHITE);
           t2.setFont(f1);
           c.add(t2);*/
           
           button1 = new JButton("Appointment");
           //label1.setText("Welcome To");
           button1.setBounds(70,419,260,70);
           button1.setForeground(Color.GRAY);
           button1.setBackground(Color.BLACK);
           button1.setFont(f1);
           c.add(button1);
           button1.addActionListener(this); 
           
          button2 = new JButton("Order Medicine");
           //label1.setText("Welcome To");
           button2.setBounds(340,485,300,70);
          button2.setForeground(Color.BLUE);
          button2.setBackground(Color.BLACK);
           button2.setFont(f1);
           c.add(button2);
            button2.addActionListener(this);
           
           button3 = new JButton("Back");
           //label1.setText("Welcome To");
           button3.setBounds(650,575,200,70);
          button3.setForeground(Color.RED);
          button3.setBackground(Color.BLACK);
           button3.setFont(f1);
           c.add(button3);
           button3.addActionListener(this); 
         addMouseListener(new MouseSensor());
         addMouseMotionListener(new MouseSensor());      
        
    }
          
   //void setPrevious(FirstFrame f){
    
      //  this.f=f;
        
  //  }
    //FirstFrame getPrevious(){
    //    return f;
   // }
    
    //Appointment ap = new Appointment();
    //ap.setVisible(true);
}
    

    

