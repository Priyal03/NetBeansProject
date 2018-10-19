import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main extends JFrame implements KeyListener{

Image caitlanImage = new ImageIcon("b.jpg").getImage();
Person caitlan = new Person(caitlanImage, "Caitlan", 10, 200, true);

Person jake;
Image jakeImage;

//Background images
Image granadaBackground;

public static void main(String[] args) throws InterruptedException{
    new Main();
}
public Main() throws InterruptedException{
    setSize(700,300);
    setTitle("Project Anniversary");
    setVisible(true);   
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    addKeyListener(this);

    //Instantiate background images
    granadaBackground = new ImageIcon("Granada Background.jpg").getImage();

    //Spawn first background
    spawnBackground(granadaBackground);

    //Spawn initial sprite
    spawnSprite(caitlan);
}

public void moveSprite(Person p) throws InterruptedException{   //Method to move a         
sprite 10 pixels (BROKEN)
    Graphics g = this.getGraphics();
        p.setLocation(p.getPosX() + 10, p.getPosY());
        g.drawImage(caitlan.getImage(), caitlan.getPosX() + 10,     
caitlan.getPosY(), caitlan.getImage().getWidth(null), caitlan.getImage().getHeight(null), 
null);
}
public void paint(Graphics g){   //Overridden paint method

}
public void spawnSprite(Person p){  //Method to initially spawn a sprite
    Graphics g = this.getGraphics();
    g.drawImage(p.getImage(), p.getPosX(), p.getPosY(), 
            p.getImage().getWidth(null), p.getImage().getHeight(null), null);
}
public void keyPressed(KeyEvent e) { //Method called whenever a key is pressed
    if(e.getKeyChar() == new String("d").charAt(0)){
        try {
            moveSprite(caitlan);
        } catch (InterruptedException e1) {
                System.out.println(e1);
        }
    }
}
public void spawnBackground(Image backgroundImage){
    Graphics g = this.getGraphics();
    g.drawImage(backgroundImage, 0, 0, backgroundImage.getWidth(null),    
backgroundImage.getHeight(null),null);
}

public void keyReleased(KeyEvent e) {   //IGNORE

}
public void keyTyped(KeyEvent e) {      //IGNORE

}

}
