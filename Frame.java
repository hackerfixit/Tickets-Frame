
package tut.ac.za.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import tut.ac.za.members.Member;

public class Frame extends JFrame{
    private JPanel headingPnl;
    private JPanel loginPnl;
    private JPanel namePnl;
    private JPanel passwordPnl;
    private JPanel btnPnl;
    private JPanel mainPnl;
    
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel passwordLbl;
    
    private JTextField nameTxtFld;
    private JPasswordField passwordFld;
    
    private JButton submitBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    
    private ArrayList members;
    
    public Frame(){
        members=new ArrayList();
        
        //set the frame
        setTitle("Login page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setSize(600,650);
        
        //create panels
        headingPnl=new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        namePnl=new JPanel(new FlowLayout());
        passwordPnl=new JPanel(new FlowLayout());
        btnPnl=new JPanel(new FlowLayout());
        loginPnl=new JPanel(new GridLayout(2,1,1,1));
        loginPnl.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Login details"));
        mainPnl=new JPanel(new BorderLayout());
        
        //labels
        headingLbl=new JLabel("Login");
        headingLbl.setBorder(new BevelBorder(BevelBorder.RAISED));
        headingLbl.setFont(new Font(Font.SANS_SERIF,Font.ITALIC+Font.BOLD,30));
       
        headingLbl.setForeground(Color.red);
        
        
        nameLbl=new JLabel("Username:  ");
        passwordLbl=new JLabel("Password:  ");
        
        //textfield
        nameTxtFld=new JTextField(10);
        passwordFld=new JPasswordField(10);
        
        //buttons
        submitBtn=new JButton("Submit");
        clearBtn=new JButton("Clear");
        exitBtn=new JButton("Exit");
        
        submitBtn.addActionListener(new subimtBtnListener());
        clearBtn.addActionListener(new clearBtnListener());
        exitBtn.addActionListener(new exitBtnListener());
        
        //add the components to the panels
        headingPnl.add(headingLbl);
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        passwordPnl.add(passwordLbl);
        passwordPnl.add(passwordFld);
        loginPnl.add(namePnl);
        loginPnl.add(passwordPnl);
        btnPnl.add(submitBtn);
        btnPnl.add(clearBtn);
        btnPnl.add(exitBtn);
        mainPnl.add(headingPnl,BorderLayout.NORTH);
        mainPnl.add(loginPnl,BorderLayout.CENTER);
        mainPnl.add(btnPnl,BorderLayout.SOUTH);
        add(mainPnl);
        setResizable(true);
        pack();
        setVisible(true);
    }

    private class exitBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

        
    }

    private class clearBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                nameTxtFld.setText("");
                passwordFld.setText("");
                
        }
    }
    
    private class subimtBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //READ 
            String name=nameTxtFld.getText();
            String password=nameTxtFld.getText();
            
            Member member=new Member(name, password);
            members.add(member);
            

            
        }
        
    }
    
}
