import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame{
    Paytm(){
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   

        try {
            j.setPage("https://paytm.com/credit-card-bill-payment");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html><h1>Could Not Load</h1></html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
     
        
        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Payment().setVisible(true);
            }
        });
        back.setBounds(610, 20, 80, 40);
        j.add(back);
        
        setBounds(480, 200, 800, 600);
        
    }
    public static void main(String[] args){
        new Paytm().setVisible(true);
    }
}