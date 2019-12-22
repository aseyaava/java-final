/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aywon;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.JComboBox;
import java.util.Date;

class Payment extends JFrame implements ActionListener
{
private Container c;
    private JButton button1,button2;
    private JLabel label1,label2,label3,label4;
    private Font f1,f2,f3;
    private JTextField t1,t2,t3;
    private JComboBox cb;
    private String[] PaymentSystem={"Select Payment Method","Card","bKash","Nagad","Rocket","Cash On Delivery"};
    String ss1, ss2;
    int pp;
    private final String use;
    
    Payment(String s1, String s2, int p,String use){
       this.use=use;
        ss1=s1;
        ss2=s2;
        pp=p;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        setTitle("Payment");
        setResizable(false);
       
        f1=new Font("Arial",Font.BOLD,40);
       
        f2=new Font("Cooper Black",Font.BOLD,60);
        f3=new Font("Arial",Font.BOLD,20);
       
         c=this.getContentPane();
         c.setLayout(null);
         c.setBackground(new Color(0,0,0));
         cb=new JComboBox(PaymentSystem);
         cb.setBounds(330,220,200,70);
         //cb.setEditable(true);
         c.add(cb);
         
         label1 = new JLabel("");
           //label1.setText("Welcome To");
           label1.setBounds(150,300,800,70);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           c.add(label1);
           cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
            String s=cb.getSelectedItem().toString();
            if(cb.getSelectedIndex()>0)
            label1.setText("You have selected:"+s);
            //label1.setForeground(Color.RED);
            }
       
            });
                   
     
            label2 = new JLabel("Select Payment Method");
           //label1.setText("Welcome To");
           label2.setBounds(70,22,800,70);
           label2.setForeground(Color.RED);
           label2.setFont(f2);
           c.add(label2);
           
           label3 = new JLabel("Total Amount:");
           //lalabel3bel1.setText("Welcome To");
           label3.setBounds(150,122,800,70);
           label3.setForeground(Color.WHITE);
           label3.setFont(f1);
           c.add(label3);
           
           t1 = new JTextField("");
           //label1.setText("Welcome To");
           t1.setBounds(415,135,200,50);
           t1.setForeground(Color.RED);
           t1.setFont(f1);
           //String ss= p.toString();
           t1.setText(String.valueOf(p));
           c.add(t1);
           
            button1 = new JButton("Search Again");
           //label1.setText("Welcome To");
           button1.setBounds(277,510,260,50);
           //button1.setForeground(Color.WHITE);
           button1.setFont(f3);
           c.add(button1);
           
          button2 = new JButton("Confirm Payment");
           //label1.setText("Welcome To");
           button2.setBounds(277,450,260,50);
          button2.setForeground(Color.WHITE);
          button2.setBackground(Color.RED);
           button2.setFont(f3);
           c.add(button2);
           
         button1.addActionListener(this); 
         button2.addActionListener(this);
         addMouseListener(new MouseSensor());
         addMouseMotionListener(new MouseSensor());
         
           
}
    
     public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==button1)
        {
        Medicine f2 = new Medicine(use);
            f2.setVisible(true);
            this.setVisible(false);
        
        }
         else if(e.getSource()==button2&&cb.getSelectedIndex()>0){
            
          
            
             
               Database db = new Database();
            // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
            //LocalDateTime now = LocalDateTime.now(); 
             Address f2 = new Address (ss1,ss2,String.valueOf(pp),"2020/12/31",use);
            f2.setVisible(true);
            this.setVisible(false);
           //f2.setPrevious(this);
            
            
        }   
        
        
    }

}