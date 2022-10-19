package gui;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.*;
	import javax.swing.*;

	public class LoginPage implements ActionListener{
		
		JFrame frame = new JFrame();
		JButton loginButton = new JButton("Login");
		JButton resetButton = new JButton("Reset");
		JTextField userIDField = new JTextField();
		JPasswordField userPasswordField = new JPasswordField();
		JLabel userIDLabel = new JLabel("User ID:");
	//	JLabel growwLabel1 = new JLabel("Crypto Trading Interface");
		JLabel userPasswordLabel = new JLabel("Password:");
		JLabel messageLabel = new JLabel();
	//	JLabel inter = new JLabel();
		HashMap<String,String> logininfo = new HashMap<String,String>();
		
		LoginPage(HashMap<String,String> loginInfoOriginal){
			
			logininfo = loginInfoOriginal;
		
			userIDLabel.setBounds(50,100,75,25);
			userPasswordLabel.setBounds(50,150,75,25);
			
			messageLabel.setBounds(125,250,250,35);
			messageLabel.setFont(new Font(null,Font.ITALIC,25));
			//			inter.setFont(new Font(null,Font.ITALIC,25));
			//			inter.setText("Crypto and NFT");

			userIDField.setBounds(125,100,200,25);
			userPasswordField.setBounds(125,150,200,25);
			
			loginButton.setBounds(125,200,100,25);
			//loginButton.setForeground(Color.blue);
//			loginButton.setBackground(Color.blue);
//			loginButton.setForeground(Color.BLUE);
		//	loginButton.setBorderPainted(true);
			//loginButton.setVisible(true);
		//	loginButton.setOpaque(true);
			
			loginButton.setFocusable(false);
			loginButton.addActionListener(this);
			
			resetButton.setBounds(225,200,100,25);
			resetButton.setFocusable(false);
			resetButton.addActionListener(this);
			//frame.setContentPane(new JLabel(new ImageIcon("/Users/nischithtn/Downloads/p.png")));
			frame.setTitle("Crypto Trading Interface");
		//	frame.add(inter);
			frame.add(userIDLabel);
			frame.add(userPasswordLabel);
			frame.add(messageLabel);
			frame.add(userIDField);
			frame.add(userPasswordField);
			frame.add(loginButton);
			frame.add(resetButton);
			//frame.add(growwLabel1);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(420,420);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==resetButton) {
				userIDField.setText("");
				userPasswordField.setText("");
				messageLabel.setText("");
			}
			
			if(e.getSource()==loginButton) {
				
				String userID = userIDField.getText();
				String password = String.valueOf(userPasswordField.getPassword());
				
				if(logininfo.containsKey(userID)) {
					if(logininfo.get(userID).equals(password)) {
						messageLabel.setBackground(Color.green);
						frame.getContentPane().setBackground(Color.green);
						messageLabel.setText("Login successful");
						frame.dispose();
						WelcomePage welcomePage = new WelcomePage();
					}
					else {
						
						messageLabel.setText("Wrong Password");
						messageLabel.setForeground(Color.RED);
					}

				}
				else {
					
					messageLabel.setText("Not Found");
				}
			}
		}	
	}
	
