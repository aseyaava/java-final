/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aywon;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.sql.PreparedStatement;

/**
 *
 * @author aywon
 */
public class DoctorsInfo extends  JFrame implements ActionListener{

    private Container c; 
    private JPanel panel1;
    private JButton button1,button2;
    private JLabel label1,label2,label3;
    private Font f1,f2;
    private JTextArea t1;
    private JScrollPane scrollableList;
    private JList list;
    private JTextField m1,m2,m3;
        DefaultListModel<String> Rl = new DefaultListModel<>();
        String d,un1;
        String[] s = new String[100];
        String[] un = new String[100];
    private String[] s1= new String[100] ;
    private String uo;
    private String sr;


        public void initcomponent(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Doctors Information ");
        setResizable(false);
    }

    DoctorsInfo(String s1,String use){
        initcomponent();
        addR(s1);
        uo=use;
        //System.out.println(uo);
        
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(0,0,0));
        f1=new Font("Arial",Font.BOLD,15);
        f2=new Font("Arial",Font.BOLD,25);
        button1 = new JButton("Back");
        button1.setBounds(70,580,120,40);
        button1.setBackground(Color.white);
        button1.setFont(f1);
        c.add(button1);
        t1 = new JTextArea("t1", 1, 20);
       
        list = new JList(Rl);
        scrollableList = new JScrollPane(list,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableList.setBounds(250,50,600,500);
        scrollableList.setBackground(new Color(255,255,255));
        c.add(scrollableList);
        button2 = new JButton("Confirm Appontment");
        button2.setBounds(600,580,200,40);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.RED);
        button2.setFont(f1);
        c.add(button2);
       
        button2.addActionListener(this);


        label1=new JLabel("Appointments:");

        label1.setForeground(Color.RED);
        label1.setFont(f2);
        Dimension size = label1.getPreferredSize();
        label1.setBounds(5,20,size.width,size.height);
         button1.addActionListener(this); 
         button2.addActionListener(this);
         addMouseListener(new MouseSensor());
         addMouseMotionListener(new MouseSensor());

       
    }



void addR(String DID){
    try {
            d=DID;
          
            Connection con =
DriverManager.getConnection("jdbc:mysql://localhost/online appointment and medicine system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
"root", "");
            Statement stmt = con.createStatement();
     
            
             String query = "SELECT * FROM `doctor_information` WHERE specialist='"+d+"'";
             System.out.println(query);
 
            ResultSet rs = stmt.executeQuery(query);
           for(int i=0;rs.next();++i){
             //s[i] = rs.getString("Doctor_Name");
             //un[i] = rs.getString("TSF");
             String s3 = rs.getString("Visiting_Fee");
             s1[i] = rs.getString("Doctor_Name");
             String s2 = rs.getString("TSF");
             Rl.addElement(" Doctor Name:"+s1[i]+".   TSF: "+s2+".   Visiting Fee: "+s3);

           }         

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex+"h");
        }
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            //this.dispose();
            //getP().setVisible(true);
                       // Dpage u= new Dpage(un1,d);
    Appointment f2= new Appointment(uo);
    f2.setVisible(true);
    this.setVisible(false);
                //u.setVisible(true);
                //u.setP(m.getP());
                        //getP().addR(d);

        }
        if(e.getSource()==button2){
         try {
           
        Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/online appointment and medicine system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
"root", "");
            Statement stmt = con.createStatement();
            int i=list.getSelectedIndex();

          /*  String query = "INSERT INTO appoinments (DID,SL,PName)
VALUES ('"+d+"','"+s[i]+"','"+un[i]+"')"; */

         
           Rl.removeElementAt(i);


      // execute the preparedstatement
      
                   
      
             String query = "INSERT INTO `appointment`(`p_name`, `d name`) VALUES ('"+uo+"','"+s1[i]+"')";
              System.out.println(query);
             
             if(stmt.executeUpdate(query)!=1){
             
               stmt.executeQuery(query);
             } 
             
             
             String query2 = "SELECT * FROM `appointment` WHERE p_name='"+uo+"'";
             System.out.println(query2);
               if(stmt.executeQuery(query2)!=null){
             
               ResultSet rs = stmt.executeQuery(query2);
               rs.next();
               sr = rs.getString("sl");
               rs.close();
               
             }
    
             String query1 = "UPDATE `user` SET `sl`='"+sr+"',`d name`='"+s1[i]+"' WHERE user_name='"+uo+"'";
           // System.out.println(query1);
              if(stmt.executeUpdate(query1)!=1){
             stmt.executeUpdate(query1);
              //System.out.println("ok");
              }
             
              // ResultSet rs = stmt.executeQuery(query1);
             
           
              
            //System.out.println(query);
            if(stmt.executeUpdate(query1)==1){
                System.out.println("ok2");
                JOptionPane.showMessageDialog(this, "Record Added");
                Frame2 f2= new Frame2(uo);
    f2.setVisible(true);
    this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(this, "Record not Added");
            }

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex+"kk");
            //System.out.println("Error: "+ ex.getMessage());
        }

        }
    }
    }

	
	
	

    

