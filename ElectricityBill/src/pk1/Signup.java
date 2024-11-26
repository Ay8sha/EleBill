package pk1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.function.Consumer;

public class Signup extends JFrame implements ActionListener {
    Choice loginASCho;
    TextField meterText, empText, usernameText, nameText, passText;
    JButton create, cancel;
    Signup(){
        super("Signup Page");
        getContentPane().setBackground(Color.pink);
        JLabel createAS= new JLabel("Create account as");
        createAS.setBounds(30,50,125,20);
        add(createAS);

        loginASCho= new Choice();
        loginASCho.add("Admin");
        loginASCho.add("Consumer");
        loginASCho.setBounds(170,50,120,20);
        add(loginASCho);

        JLabel meterNo= new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText=new TextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(true);
        add(meterText);

        JLabel EmpID= new JLabel("Employee ID");
        EmpID.setBounds(30,100,125,20);
        EmpID.setVisible(true);
        add(EmpID);

        empText=new TextField();
        empText.setBounds(170,100,125,20);
        empText.setVisible(true);
        add(empText);

        JLabel username= new JLabel("Username");
        username.setBounds(30,130,125,20);
        add(username);

        usernameText= new TextField();
        usernameText.setBounds(170,130,125,20);
        add(usernameText);


        JLabel name= new JLabel("Name");
        name.setBounds(30,160,125,20);
        add(name);

        nameText= new TextField();
        nameText.setBounds(170,160,125,20);
        add(nameText);

        JLabel password= new JLabel("Password");
        password.setBounds(30,190,125,20);
        add(password);

        passText= new TextField();
        passText.setBounds(170,190,125,20);
        add(passText);

        //changes on selecting admin or consumer in drop down
        loginASCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginASCho.getSelectedItem();
                if(user.equals("Consumer")){
                    EmpID.setVisible(false);
                    empText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);

                }else {
                    EmpID.setVisible(true);
                    empText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);

                }
            }
        });

        //buttons
        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(Color.pink);
        create.setBounds(50,250,100,25);
        create.addActionListener(this);
        add(create);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.pink);
        cancel.setBounds(200,250,100,25);
        cancel.addActionListener(this);
        add(cancel);

        //adding the image on the side
        ImageIcon sOne= new ImageIcon("qq.png");
        Image sTwo= sOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fsOne=new ImageIcon(sTwo);
        JLabel sLabel=new JLabel(fsOne);
        sLabel.setSize(260,260);
        sLabel.setLocation(300,10);

        add(sLabel);


        setSize(600,350);
        setLocation(500,200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
                String sloginAs= loginASCho.getSelectedItem();
                String susername= usernameText.getText();
                String sname=nameText.getText();
                String spassword=passText.getText();
                String smeter= meterText.getText();
                try{
                    database a= new database();
                    String query= null;
                    query= "INSERT INTO login VALUES ('"+susername+"','"+smeter+"','"+sname+"','"+spassword+"','"+sloginAs+"')";
                a.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created successfully!");
                setVisible(false);
                new Login();
                }catch(Exception E){
                    E.printStackTrace();
                }

        } else if(e.getSource()==cancel) {
            setVisible(false);
            new Login();

        }

    }

    public static void main(String[] args){
        new Signup();
    }
}
