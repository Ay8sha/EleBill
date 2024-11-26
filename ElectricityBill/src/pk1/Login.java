package pk1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userText,passwordText;
    Choice loginChoice;
    JButton loginButton,cancelButton,signupButton;
    Login(){
        super("Login");
        JLabel username= new JLabel("USERNAME");
        username.setBounds( 300,60,100,20);
        add(username);

        userText=new JTextField();
        userText.setBounds(400,60,150,20);
        add (userText);

        JLabel password= new JLabel("PASSWORD");
        password.setBounds(300,100,100,20);
        add(password);

        passwordText=new JTextField();
        passwordText.setBounds(400,100,150,20);
        add(passwordText);

        JLabel login = new JLabel( "LOGIN AS");
        login.setBounds(300,140,100,20);
        add(login);

        loginChoice=new Choice();
        loginChoice.add("ADMIN");
        loginChoice.add("CONSUMER");
        loginChoice.setBounds(400,140,150,20);

        add(loginChoice);

        loginButton=new JButton("Login");
        loginButton.setBounds(330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton= new JButton("Sign up");
        signupButton.setBounds(400,216,100,20);
        signupButton.addActionListener(this);
        add(signupButton);
            //issues with this approach
       /* ImageIcon PROFOne=new ImageIcon(ClassLoader.getSystemResource("PROF.jpg"));
        Image PROFTwo= PROFOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fPROFOne=new ImageIcon(PROFTwo);
        JLabel PROFLabel=new JLabel(fPROFOne);
        PROFLabel.setBounds(0,0,260,260);*/

        ImageIcon PROFOne= new ImageIcon("PROF.jpg");
        Image PROFTwo= PROFOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fPROFOne=new ImageIcon(PROFTwo);
        JLabel PROFLabel=new JLabel(fPROFOne);
        PROFLabel.setSize(260,260);
        PROFLabel.setLocation(0,0);


        add(PROFLabel);

        setSize(660,400);
        setLocation(400,200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton){
            String susername= userText.getText();
            String spassword= passwordText.getText();
            String user= loginChoice.getSelectedItem();

            try{
                database c= new database();
                String query="SELECT * FROM login WHERE username='"+susername+"' and password='"+spassword+"' and usertype='"+user+"'";
                ResultSet resultSet= c.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new main_class();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials ");
                }

            }catch(Exception E){
                E.printStackTrace();

            }
        }else if(e.getSource()==cancelButton){
            setVisible(false);
        }
        else if(e.getSource()==signupButton){
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String[] args){
        new Login();
    }
}
