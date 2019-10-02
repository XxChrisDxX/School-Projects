package HW3ChrisDecker;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/*
 @author ctdecker2727
*/

public class HW3ChrisDecker extends JFrame {
    
    private JTextField rate = new JTextField();
    private JTextField years = new JTextField();
    private JTextField monthlyInvestment = new JTextField();
    private JTextField jtfFutureValue = new JTextField();
    
    private JButton computeFutureValue = new JButton("Calculate");
    private JButton reset = new JButton("Reset");
    
    public HW3ChrisDecker(){
        JPanel p1 = new JPanel(new GridLayout(5, 2));
        jtfFutureValue.setEditable(false);
        
        p1.add(new JLabel("Annual Interest Rate: e.g., 5.0"));
        p1.add(rate);
        p1.add(new JLabel("Number of years: e.g., 10"));
        p1.add(years);
        p1.add(new JLabel("Monthly Investment: e.g., 300"));
        p1.add(monthlyInvestment);
        p1.add(new JLabel("Future Value: "));
        p1.add(jtfFutureValue);
        p1.setBorder(new TitledBorder("Enter interest rate, years, and monthly investment"));
        
        JPanel p2 = new JPanel();
        p2.add(computeFutureValue);
        p2.add(reset);
        
        this.add(p1);
        add(p2, BorderLayout.SOUTH);
        
        computeFutureValue.addActionListener(new ButtonListener());
        reset.addActionListener(new Reseter());
    }   
    public static void main(String[] args) {
        // TODO code application logic here
        HW3ChrisDecker frame = new HW3ChrisDecker();
        
        frame.setTitle("Future Value");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            double investmentAmount = Double.parseDouble(monthlyInvestment.getText());
            double annualRate = Double.parseDouble(rate.getText());
            int numberYears = Integer.parseInt(years.getText());
            
            FutureValue futureValue = new FutureValue(annualRate, numberYears, investmentAmount);

            jtfFutureValue.setText(String.format("%.2f", futureValue.getFutureValue()));
        }
    }
    private class Reseter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            rate.setText("");
            years.setText("");
            monthlyInvestment.setText("");
            jtfFutureValue.setText("");
        }
    }
}
