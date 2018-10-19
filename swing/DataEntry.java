import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class DataEntry implements ActionListener{  
    Connection conn = null;
    Statement stmt = null;

       //  Insert Page
   JFrame insertframe=new JFrame("Insert into Database");
   JPanel insertpanel=new JPanel();
   JLabel idlabel=new JLabel(" id");
   JTextField idtext=new JTextField(20);
   JLabel agelabel=new JLabel(" age");
   JTextField agetext=new JTextField(20);
   JButton insertsubmit=new JButton("Submit");
   JButton insertbtn=new JButton("Insert");


            //Create and set up the window.
   JFrame mainframe=new JFrame("Database Operation");
   JPanel mainpanel=new JPanel();
           
   JButton viewbtn=new JButton("View");
   JLabel label1=new JLabel("ID: ");
   JLabel label2=new JLabel("Age: ");
   JLabel label3=new JLabel("");
   JFrame viewframe=new JFrame("View Database Data");
   JPanel viewpanel=new JPanel();
   Vector datacol=new Vector();
   Vector datarow=new Vector();
   JTable datatable;
   JScrollPane viewdata;

   public void init()
     {
            mainwindow();
   }
   public void mainwindow()
   {
             mainpanel.setBackground(Color.GRAY);
            mainpanel.setLayout(null);
            insertbtn.setBounds(300, 300, 100, 30);
            viewbtn.setBounds(800, 300, 100, 30);
            mainpanel.add(insertbtn);
           mainframe.add(mainpanel);
            mainframe.setSize(1350, 700);
            mainframe.setVisible(true);
            insertbtn.addActionListener(this); 
   }  
   public void insertwindow()
   {
           insertpanel.setBackground(Color.GRAY);
           idlabel.setForeground(Color.WHITE);
           agelabel.setForeground(Color.WHITE);

           insertpanel.setLayout(null);
           idlabel.setBounds(400, 150, 100, 20);
           idtext.setBounds(550, 150, 150, 30);
           agelabel.setBounds(400, 200, 100, 20);
           agetext.setBounds(550, 200, 150, 30);

           insertsubmit.setBounds(490, 300, 100, 30);

           insertpanel.add(idlabel);

           insertpanel.add(idtext);
           insertpanel.add(agelabel);
           insertpanel.add(agetext);

           insertpanel.add(insertsubmit);
           insertframe.add(insertpanel);

           insertframe.setSize(1350, 700);
           insertframe.setVisible(true);
           insertsubmit.addActionListener(this);
           insertframe.addWindowListener(new WindowAdapter()
           {
            public void windowClosing(WindowEvent e)
            {
             mainframe.setVisible(true);
            }
            });
   }
   public void viewwindow()
   {

            datacol.removeAllElements();
            datarow.removeAllElements();
            OpenDatabase();
            try
            {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select id,age from employee");
            ResultSetMetaData rms=rs.getMetaData();
            int cols=rms.getColumnCount();
            for(int i=1;i<=cols;i++)
            {
             datacol.addElement(rms.getColumnName(i));
            }
            while(rs.next())
            {
             Vector row=new Vector(cols);
             for(int i=1;i<=cols;i++)
             {
              row.addElement(rs.getObject(i));
             }
             datarow.addElement(row);
            }
            datatable=new JTable(datarow,datacol);
            viewdata=new JScrollPane(datatable);

            }
            catch(SQLException e)
            {
             JOptionPane.showConfirmDialog(null, e.getMessage(), "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);

            }
            viewpanel.setBackground(Color.GRAY);
            viewpanel.setLayout(null);
            viewdata.setBounds(20, 50, 1250, 600);
            viewpanel.add(viewdata);
            viewframe.add(viewpanel);
            viewframe.setSize(1350, 700);
            viewframe.setVisible(true);
            viewframe.addWindowListener(new WindowAdapter()
            {
             public void windowClosing(WindowEvent e)
             {
              mainframe.setVisible(true);
             }
            });}
           public void insertdata(String id, String age)
           {
            try
            {
            Statement st=conn.createStatement();
            st.executeUpdate("insert into employee values('"+id+"','"+age+")");
            JOptionPane.showConfirmDialog(null, "Your Data Has been Inserted", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
            } 
            catch(HeadlessException | SQLException e)
            {
             JOptionPane.showConfirmDialog(null, e.getMessage(), "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
           }
           public void OpenDatabase()
           {

            try
            {
             Class.forName("com.mysql.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");

            }
            catch(ClassNotFoundException | SQLException e)
            {
             System.out.println(e);
            }
           }
           public void CloseDatabase()
           {
            try {
             conn.close();
            } catch (SQLException e) {
            }

           }public void actionPerformed(ActionEvent arg0) {

               if(arg0.getSource()==insertbtn)
               {
                mainframe.setVisible(false);
                insertwindow();
               }
               if(arg0.getSource()==viewbtn)
               {
                mainframe.setVisible(false);
                viewwindow();
               }if(arg0.getSource()==insertsubmit)
               {
                   String id=idtext.getText();
                   String age=agetext.getText();

                   try
                   {
                   OpenDatabase();
                  insertdata(id,age);

                   CloseDatabase();

                   }
                   catch(Exception e)
                   {
                    System.out.println(e);
                   }
                   idtext.setText("");
                   agetext.setText("");}}


                   public static void main(String args[])
                   {
                   DataEntry dm=new DataEntry();
                    dm.init();

                   }
                  }