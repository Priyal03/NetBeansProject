package pack;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Radio extends JFrame {

JTextField jtfAnswer = new JTextField(10);
JRadioButton jrbMale = new JRadioButton("Male");
JRadioButton jrbFemale = new JRadioButton("Female");
JButton jbSubmit = new JButton("Submit");

public Radio(){
    setLayout(new GridLayout(5,1));

    ButtonGroup group = new ButtonGroup();
    group.add(jrbMale);
    group.add(jrbFemale);

    add(new Label("Select gender:"));
    add(jrbMale);
    add(jrbFemale);
    add(jtfAnswer);
    add(jbSubmit);

    setTitle("Radio Button");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(200, 200);
    setSize(150, 150);
    setVisible(true);
    
    ActionListener actionListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JRadioButton){
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if(radioButton.isSelected()){
                jtfAnswer.setText(radioButton.getText());
            }
        }
    }
};

jrbMale.addActionListener(actionListener);
jrbFemale.addActionListener(actionListener);

}
public static void main(String[] args) {
    new Radio();
}
}