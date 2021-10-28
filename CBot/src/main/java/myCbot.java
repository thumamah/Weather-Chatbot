
import javax.swing.*;

import net.aksingh.owmjapis.model.param.City;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class chatBot extends JFrame {
	private JTextArea textArea = new JTextArea();
	private JTextField textField = new JTextField();
	private JButton button = new JButton();
	private JLabel label = new JLabel();

	chatBot() {
		// designing the frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setSize(550, 600);
		frame.getContentPane().setBackground(Color.orange);
		frame.setTitle("CTZ Weather ChatBot");
		frame.add(textArea);
		frame.add(textField);
		frame.add(button);
		textArea.setSize(850, 410);
		textArea.setLocation(2, 2);
		textArea.setBackground(Color.white);
		textField.setSize(300, 60);
		textField.setLocation(2, 420);
		label.setText("SEND");
		button.add(label);
		button.setSize(250, 40);
		button.setLocation(300, 420);
		welcomeMessage(); // calling the welcome message

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// declaring myweather object
				Weather MyWeather = new Weather();

				// Message sends on Click button
				if (e.getSource() == button) {

					// changing it to lowerCase
					String text = textField.getText().toLowerCase();

					// text by the user
					textArea.append("You ::  " + text + "\n");
					textField.setText("");

					if (text.contains("hi")) { // input Checking
						replyMessage("Hi there, So which cities are you planning to visit?"); // replying using the
																								// reply
																								// method
					} else if (text.contains("how are you")) {
						replyMessage("I'm Good :).Thank you for asking");

						// if user enters a city
					} else if (Weather.getCity(text)) {
						// replyMessage("Temperature is : ");
						// tell them the temperature of that city
						replyMessage("temperature is : " + MyWeather.getTempMax() + "°C");

						replyMessage("Want to know what to wear for this weather?");

					} else if ((text.contains("yes")) || (text.contains("yeah please"))) {

						// if temp => than 30
						if (MyWeather.getTempMax() >= 30) {
							// suggest high temp clothings
							replyMessage(MyWeather.high);
						}

						// if temp => than 25
						else if (MyWeather.getTempMax() >= 25) {
							// suggest mid temp clothings
							replyMessage(MyWeather.mid);
						}

						// if temp => than 10
						else if (MyWeather.getTempMax() >= 10) {
							// suggest mid temp clothings
							replyMessage(MyWeather.mid);
						}

						// if temp <= than 10
						else if (MyWeather.getTempMax() <= 10) {
							// suggest low temp clothings
							replyMessage(MyWeather.low);
						}
					}

					else if (text.contains("bye bye") || (text.contains("see you"))) {
						replyMessage("See You Soon @CTZ ChatBot, Stay Safe");
					}

					else {
						replyMessage("I Can't Understand");
					}
				}
			}
		});
	}

	// reply message for all other text
	public void replyMessage(String s) {
		textArea.append("CTZ Bot :  " + s + "\n");
	}

//	// replying message for temperatures
//	public void replyMessage2(String string) { // Reply Method by the chatBot
//		textArea.append("CTZ Bot :  " + string + "\n");
//	}

	// welcome message
	public void welcomeMessage() {
		// A welcome message to guide the user on how to use the chatbot
		String startMsg = "Welcome To The CTZ ChatBot, You May enter the city\n that you plan to visit in 3 days so we suggest you"
				+ " suitable\n clothing according to the weather\n " + "We Hope You Enjoy Your Journey\n";
		textArea.append(startMsg);
	}
}

public class myCbot extends JFrame {

	public static void main(String[] args) {
		new chatBot(); // calling the chatbot method in the main method so it can run
	}
}
