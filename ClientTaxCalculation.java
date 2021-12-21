
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientTaxCalculation {
	@SuppressWarnings("serial")
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel question = new JLabel("How much did you earn in 2021?");
		JTextField income = new JTextField();
		JLabel taxes = new JLabel("");
		JButton submit = new JButton("Submit");

		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);
		question.setBounds(10,20, 300, 25);
		income.setBounds(10, 55, 80, 25);
		taxes.setBounds(10, 90, 250, 25);
		submit.setBounds(90, 55,80, 25);

		TaxCalculation first = new TaxCalculation();

		submit.addActionListener( new AbstractAction("add") {
				@Override
				public void actionPerformed(ActionEvent e) {
					String incomeResult = income.getText();
					double finalIncome;
					try {
						finalIncome = Double.parseDouble(incomeResult);
						if(finalIncome < 0) {
							taxes.setText("Error: Please input a positive number");
						} else {
							taxes.setText("You owe $" + first.getTaxCalculation(finalIncome) + " (rate: " + first.getEffectiveRate(finalIncome) + "%)");
						}
					} catch(Exception e1) {
						taxes.setText("Error: Please input a number");
					}
				}}
		);

		panel.add(question);
		panel.add(income);
		panel.add(taxes);
		panel.add(submit);

		frame.setTitle("Tax Calculator");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
