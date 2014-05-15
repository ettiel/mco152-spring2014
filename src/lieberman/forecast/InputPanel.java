package lieberman.forecast;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel city;
	private final JTextField userInput;

	public InputPanel() {
		city = new JLabel("Enter the location in the format of city,country");
		userInput = new JTextField(10);
		this.add(city);
		this.add(userInput);
	}

	public String getUserInput() {
		String input = userInput.getText();
		input = input.replace(" ", "");
		return input;
	}

}
