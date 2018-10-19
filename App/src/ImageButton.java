import javax.swing.*;  
  
public class ImageButton{  
ImageButton(){  
JFrame f=new JFrame();  
                  
          
JButton b=new JButton(new ImageIcon("b.jpg"));  
b.setBounds(130,100,100, 40);  
      
f.add(b);  
          
f.setSize(300,400); 
b.setText("Sign in");
f.setLayout(null);  
f.setVisible(true);  
          
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          
    }  
      
public static void main(String[] args) {  
    new ImageButton();  
}  
}  