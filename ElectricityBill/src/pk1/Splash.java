package pk1;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame{
    Splash(){
        ImageIcon imageIcon1= new ImageIcon("thu.jpg");
        JLabel imagelabel= new JLabel(imageIcon1);
        setSize(600,500);
        setLocation(400,100);
        add(imagelabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        try{
        Thread.sleep(3000);
        setVisible(false);
            new Login();


        } catch (Exception e) {
           e.printStackTrace();
            System.out.println(e);
        }

    }
    public static void main(String[] args){
        new Splash();
    }
}
