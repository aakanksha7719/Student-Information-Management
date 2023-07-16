package stdd;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Front_Page implements ActionListener{
JFrame f;
JButton b;
Front_Page(){

f=new JFrame("Student Record Management System");
f.setBackground(Color.BLACK);
f.setLayout(null);

b = new JButton("CLICK HERE TO CONTINUE");
b.setBackground(Color.BLACK);
b.setForeground(Color.WHITE);

b.setBounds(500,600,300,60);
b.addActionListener(this);

JLabel lid=new JLabel("STUDENT RECORD MANAGEMENT SYSTEM");
lid.setBounds(70,200,1500,100);
lid.setFont(new Font("serif",Font.BOLD,50));
lid.setForeground(Color.BLACK);
f.add(lid);
f.add(b);
f.getContentPane().setBackground(Color.PINK);
f.setVisible(true);
f.setSize(800,800);
f.setLocation(200,100);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b){
f.setVisible(false);
new Details();
}
}
public static void main(String[] arg){
new Front_Page();
}
}