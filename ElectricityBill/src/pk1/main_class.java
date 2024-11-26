package pk1;

import javax.swing.*;
import java.awt.*;

public class main_class extends JFrame {
    main_class(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //the background picture
        ImageIcon img1= new ImageIcon("bub.jpg");
        Image img2= img1.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon frimg2=new ImageIcon(img2);
        JLabel simLabel=new JLabel(frimg2);
        add(simLabel);


        //menu bar, will be made visible to admin
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu= new JMenu("Menu");
        menu.setFont(new Font("monospaced",Font.PLAIN,15));
        menuBar.add(menu);

        //creating different options for menu
        JMenuItem newconsumer= new JMenuItem("New Consumer");
        newconsumer.setFont(new Font("monospaced",Font.PLAIN,15));
        menu.add(newconsumer);

        JMenuItem consumerdetails= new JMenuItem("Consumer Details");
        consumerdetails.setFont(new Font("monospaced",Font.PLAIN,15));
        menu.add(consumerdetails);

        JMenuItem depositdetail= new JMenuItem("Deposit Details");
        depositdetail.setFont((new Font("monospaced",Font.PLAIN,15)));
        menu.add(depositdetail);

        JMenuItem calcbill= new JMenuItem("Calculate Bill");
        calcbill.setFont((new Font("monospaced",Font.PLAIN,15)));
        menu.add(calcbill);

        //info menu, will be made visible to consumer
        JMenu info= new JMenu("Information");
        info.setFont(new Font("monospaced",Font.PLAIN,15));
        menuBar.add(info);

        //different options for info menu
        JMenuItem upinfo= new JMenuItem("Update Information");
        upinfo.setFont((new Font("monospaced",Font.PLAIN,15)));
        info.add(upinfo);

        JMenuItem vinfo= new JMenuItem("View Information");
        vinfo.setFont((new Font("monospaced",Font.PLAIN,15)));
        info.add(vinfo);

        //user menu, visible to consumer
        JMenu user=new JMenu("User");
        user.setFont(new Font("monospaced",Font.PLAIN,15));
        menuBar.add(user);

        //different options for user menu
        JMenuItem paybill= new JMenuItem("Pay Bill");
        paybill.setFont((new Font("monospaced",Font.PLAIN,15)));
        user.add(paybill);

        JMenuItem billdetails= new JMenuItem("Bill Details");
        billdetails.setFont((new Font("monospaced",Font.PLAIN,15)));
        user.add(billdetails);

        //bill menu, visible to ?
        JMenu bill= new JMenu("Bill");
        bill.setFont(new Font("monospaced",Font.PLAIN,15));
        menuBar.add(bill);

        //options for bill
        JMenuItem genbill= new JMenuItem("Generate Bill");
        genbill.setFont(new Font("monospaced",Font.PLAIN,15));
        bill.add(genbill);


        //logout
        JMenu exit= new JMenu("Signout");
        exit.setFont(new Font("monospaced",Font.PLAIN,15));
        menuBar.add(exit);

        JMenuItem exit1= new JMenuItem("Logout");
        exit1.setFont(new Font("monospaced",Font.PLAIN,15));
        exit.add(exit1);



        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        new main_class();
    }

}
