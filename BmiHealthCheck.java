
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class BmiHealthCheck extends JFrame implements ActionListener {
	// instance variables
	private float weight = 0;
	private float height = 0;
	private double bmi;

	String weightResult;
	JTextField jtfWeight;
	JTextField jtfHeight;
	JButton buttonSubmit;
	JButton buttonExit;

	public BmiHealthCheck() {

		JPanel panelDataEntry = new JPanel(new GridLayout(2, 2, 5, 9));

		// Create a JTextField to display the answer
		jtfWeight = new JTextField(10);
		jtfHeight = new JTextField(10);

		// Create and add labels, text fields to panelUserEntry.
		panelDataEntry.add(new JLabel("Enter Weight Kg: "));
		panelDataEntry.add(jtfWeight);
		panelDataEntry.add(new JLabel("Enter Height in Meters: "));
		panelDataEntry.add(jtfHeight);

		// Creates a second Panel hold two buttons.
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 22, 5, 9));

		// Create and add two buttons to panelButtons.
		buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(this);
		buttonsPanel.add(buttonSubmit);
		buttonExit = new JButton("Exit");
		buttonExit.addActionListener(this);
		buttonsPanel.add(buttonExit);

		// Create a parent panel for panel1 and panel2.

		JPanel panelParent = new JPanel(new GridLayout(2, 2, 5, 5));
		panelParent.add(panelDataEntry);
		panelParent.add(buttonsPanel);

		// Instantiate Color object
		Color color = new Color(204, 204, 204);
		Color colorButtons = new Color(153, 204, 255);

		// Set background colour of object
		buttonSubmit.setBackground(colorButtons);
		buttonExit.setBackground(colorButtons);
		jtfWeight.setBackground(color);
		jtfHeight.setBackground(color);

		// Add panelParent to the frame
		add(panelParent);

	}

	// Main method
	public static void main(String[] args) {

		BmiHealthCheck frame = new BmiHealthCheck();

		// Set the attributes of the frame.
		frame.setTitle("BmiHealthCheck");
		frame.setSize(300, 160);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	// method calculates bmi
	public void processData(float weight, float height) {
		// declared Bmi variable
		bmi = (weight / (height * height));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonSubmit) {
			String weightTxt = jtfWeight.getText();
			String heightTxt = jtfHeight.getText();
			String bmiTxt = Double.toString(bmi);
			weight = Float.parseFloat(weightTxt);
			height = Float.parseFloat(heightTxt);

			// call method
			processData(weight, height);

			// condition to check and output category
			if (bmi < 18.5) {
				JOptionPane.showMessageDialog(null, "Your Bmi is: " + bmiTxt);
				JOptionPane.showMessageDialog(null, " Underweigh");
			} else if ((bmi >= 18.5) && (bmi <= 24.9)) {
				JOptionPane.showMessageDialog(null, "Your Bmi is: " + bmiTxt);
				JOptionPane.showMessageDialog(null, " Healthy Weight");

			} else if (((bmi >= 25) && (bmi <= 29.9))) {
				JOptionPane.showMessageDialog(null, "Your Bmi is: " + bmiTxt);
				JOptionPane.showMessageDialog(null, " Overweight");

			} else if ((bmi >= 30) && (bmi <= 34.9)) {
				JOptionPane.showMessageDialog(null, "Your Bmi is: " + bmiTxt);
				JOptionPane.showMessageDialog(null, " Obese Class 1");

			} else if ((bmi >= 35) && (bmi <= 39.9)) {
				JOptionPane.showMessageDialog(null, "Your Bmi is: " + bmiTxt);
				JOptionPane.showMessageDialog(null, "Obese Class 2");

			} else if (bmi >= 40) {
				JOptionPane.showMessageDialog(null, "Your Bmi is: " + bmiTxt);
				JOptionPane.showMessageDialog(null, " Obese Class 3 ");

			}

		} else if ((e.getSource() == buttonExit)) {
			JOptionPane.showMessageDialog(null, "Goodbye");
			System.exit(0);

		}

	}
}
