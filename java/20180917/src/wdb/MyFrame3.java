package wdb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame3 extends JFrame {

 // ������

 public MyFrame3() {
  setSize(500, 300);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("�̻���");

  this.setLayout(new GridLayout(3, 1));

  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();

  panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
  JLabel label1_1 = new JLabel("�й�");
  panel1.add(label1_1);
  
  JTextField text1_2 = new JTextField(15);
  text1_2.setText("1501205");
  panel1.add(text1_2);
  
  JLabel label1_3 = new JLabel("�̸�");
  panel1.add(label1_3);
  
  JTextField text1_4 = new JTextField(15);
  text1_4.setText("�̻���");
  panel1.add(text1_4);

  /***************************************************************/

  panel2.setLayout(new GridLayout(5,2));
  
  JLabel label2_1_1 = new JLabel(" ");
  panel2.add(label2_1_1);
  JLabel label2_1_2 = new JLabel("���� ���� ");
  panel2.add(label2_1_2);
  JLabel label2_1_3 = new JLabel("���� ����");
  panel2.add(label2_1_3);

  ////////////////////////////////////////////////////////////

  JLabel label2_2_1 = new JLabel("1-1�б�");
  panel2.add(label2_2_1);
  JTextField text2_2_2 = new JTextField(15);
  text2_2_2.setText("5");
  panel2.add(text2_2_2);
  JTextField text2_2_3 = new JTextField(15);
  text2_2_3.setText("10");
  panel2.add(text2_2_3);

   ///////////////////////////////////////////////////////////

  JLabel label2_3_1 = new JLabel("1-2�б�");
  panel2.add(label2_3_1);
  JTextField text2_3_2 = new JTextField(15);
  text2_3_2.setText("15");
  panel2.add(text2_3_2);
  JTextField text2_3_3 = new JTextField(15);
  text2_3_3.setText("20");
  panel2.add(text2_3_3);

   ///////////////////////////////////////////////////////////

  JLabel label2_4_1 = new JLabel("2-1�б�");
  panel2.add(label2_4_1);
  JTextField text2_4_2 = new JTextField(15);
  text2_4_2.setText("25");
  panel2.add(text2_4_2);
  JTextField text2_4_3 = new JTextField(15);
  text2_4_3.setText("30");
  panel2.add(text2_4_3);


  /***************************************************************/

  panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
  JButton button1 = new JButton("Ȯ��");
  panel3.add(button1,BorderLayout.CENTER);
  JButton button2 = new JButton("���");
  panel3.add(button2,BorderLayout.CENTER);
  
  
  /***************************************************************/
  
  this.add(panel1);
  this.add(panel2);
  this.add(panel3);

  setVisible(true);
 }
}