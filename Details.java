package stdd;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Details implements ActionListener
{
Button b1,b2;
Statement s=null;
Connection c=null;
JFrame f;
String a,b,d,ff,n;
int cc;
String e;
JLabel l,l1,l2,l3,l4,l5,l6;
TextField t1,t2,t3,t4,t5,t6;
Details()
{
f=new JFrame("Add student");
Container x=f.getContentPane();
x.setBackground(Color.PINK);
l=new JLabel("STUDENT INFORMATION");
l.setBounds(100,50,800,50);
l.setFont(new Font("serif",Font.PLAIN,25));
l1=new JLabel("Name");
l1.setBounds(50,150,100,30);
l1.setFont(new Font("serif",Font.PLAIN,20));

t1=new TextField();
t1.setBounds(300, 150, 100,30);
t1.setFont(new Font("serif",Font.PLAIN,20));
l2= new JLabel("Surname");
l2.setBounds(50,200,100,30);
l2.setFont(new Font("serif",Font.PLAIN,20));
t2=new TextField();
t2.setBounds(300, 200, 100,30);
t2.setFont(new Font("serif",Font.PLAIN,20));
l3=new JLabel("Year");
l3.setBounds(50,250,100,30);
l3.setFont(new Font("serif",Font.PLAIN,20));
t3=new TextField();
t3.setBounds(300, 250, 100,30);
t3.setFont(new Font("serif",Font.PLAIN,20));
l4=new JLabel("Branch");
l4.setBounds(50,300,100,30);
l4.setFont(new Font("serif",Font.PLAIN,20));
t4=new TextField();
t4.setBounds(300,300, 100,30);
t4.setFont(new Font("serif",Font.PLAIN,20));
l5=new JLabel("Mobile No");
l5.setBounds(50,350,100,30);
l5.setFont(new Font("serif",Font.PLAIN,20));
t5=new TextField();

t5.setBounds(300, 350, 100,30);
t5.setFont(new Font("serif",Font.PLAIN,20));
l6=new JLabel("Email ID");
l6.setBounds(50,400,100,30);
l6.setFont(new Font("serif",Font.PLAIN,20));
t6=new TextField();
t6.setBounds(300,400,200,30);
t6.setFont(new Font("serif",Font.PLAIN,20));
b1=new Button("Add");
b1.setBounds(50,450,100,30);
b1.setFont(new Font("serif",Font.PLAIN,20));
b2=new Button("Delete");
b2.setBounds(300,450,100,30);
b2.setFont(new Font("serif",Font.PLAIN,20));
Button b3=new Button("Exit");
b2.setBounds(300,450,100,30);
b2.setFont(new Font("serif",Font.PLAIN,20));
f.add(l);
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(l4);
f.add(t4);
f.add(l5);

f.add(t5);
f.add(l6);
f.add(t6);
f.add(b1);
f.add(b2);
f.add(b3);
f.setVisible(true);
f.setSize(600,600);
f.setLayout(null);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
try{
s = c.createStatement();
a= t1.getText();
b = t2.getText();
cc = Integer.parseInt(t3.getText());
d =t4.getText();
e =t5.getText();
ff = t6.getText();
System.out.println("name"+a+" surname" +b+" ,year"+cc+" ,branch"+d+" ,email"+ff+","+e );
System.out.println("insert into studr values('"+a+"','"+b+"',"+cc+",'"+d+"',"+ff+"',"+e+"')");
String q="insert into studr values('"+a+"','"+b+"',"+cc+",'"+d+"','"+ff+"','"+e+"')";

s.executeUpdate(q);
JOptionPane.showMessageDialog(b1,"Record Added Successfully");
System.out.println("Record added successfully");
}
catch(SQLException e){
System.out.println(e);
}
}
if(ae.getSource()==b2)
{
try
{
n=t1.getText();
System.out.println("delete from studr where name='a'");
String q1="delete from studr where NAME='"+n+"'";
s = c.createStatement();
s.executeUpdate(q1);
JOptionPane.showMessageDialog(b2,"Record deleted Successfully");
}
catch(SQLException e){
System.out.println(e);
}
catch(NullPointerException ee){
ee.printStackTrace();
}
}
}
public void getDBConnection() {
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("Connecting to a selected database...");
c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
"system","admin");
}
catch(Exception e){
e.printStackTrace();
}
}
public static void main(String args[])throws SQLException, ClassNotFoundException
{
Details d=new Details();
d.getDBConnection();
}
}