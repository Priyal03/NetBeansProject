package Front;
import javax.swing.JFrame;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

 

public class Ancestor
{

    public static void main(String args[]) {

  JFrame jFrame = new JFrame("Move this Window");
  jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  AncestorListener ancListener = new AncestorListener() {
public void ancestorAdded(AncestorEvent ancestorEvent) {

}
 

@Override
public void ancestorMoved(AncestorEvent ancestorEvent) {
    System.out.println("Window Moved");

}

@Override

public void ancestorRemoved(AncestorEvent ancestorEvent) {
 
} };
  jFrame.getRootPane().addAncestorListener(ancListener);
  jFrame.getRootPane().setVisible(false);
  jFrame.getRootPane().setVisible(true);
  jFrame.setSize(300, 100);
  jFrame.setVisible(true);
    }
}
