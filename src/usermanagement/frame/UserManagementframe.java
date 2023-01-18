package usermanagement.frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.JsonObject;

import usermanagement.service.UserService;

public class UserManagementframe extends JFrame {
	
	private List<JTextField> loginFields;
	private List<JTextField> registerFields;

	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordlField;
	private JTextField registerNameField;
	private JTextField registerEamilField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementframe frame = new UserManagementframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementframe() {
		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));

		
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("UserManagement\r\n\r\n");
		logoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(83, 49, 218, 53);
		loginPanel.add(logoText);
		
		JLabel loginText = new JLabel("Login");
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setFont(new Font("CookieRun Regular", Font.PLAIN, 30));
		loginText.setBounds(118, 96, 144, 53);
		loginPanel.add(loginText);
		
		usernameField = new JTextField();
		usernameField.setBounds(34, 221, 320, 32);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(34, 299, 320, 32);
		loginPanel.add(passwordField);
		
		JLabel usernameLabel = new JLabel("Username or email");
		usernameLabel.setFont(new Font("D2Coding", Font.BOLD, 18));
		usernameLabel.setBounds(34, 201, 163, 22);
		loginPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("D2Coding", Font.BOLD, 18));
		passwordLabel.setBounds(34, 279, 163, 22);
		loginPanel.add(passwordLabel);
		
		JButton loginButton = new JButton("LogIn");
		
		loginButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
	

		loginButton.setBackground(new Color(128, 128, 128));
		loginButton.setFont(new Font("D2Coding", Font.BOLD, 19));
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBounds(34, 350, 320, 44);
		loginPanel.add(loginButton);
		
		JLabel signupDesc = new JLabel("Don't have an account?");
		signupDesc.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signupDesc.setBounds(108, 404, 144, 22);
		loginPanel.add(signupDesc);
		
		JLabel sigupLink = new JLabel("Sign up");
		sigupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
			}
		});
		sigupLink.setForeground(new Color(0, 0, 255));
		sigupLink.setFont(new Font("D2Coding", Font.PLAIN, 12));
		sigupLink.setBounds(251, 404, 50, 22);
		loginPanel.add(sigupLink);
		
		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setForeground(new Color(0, 0, 255));
		forgotPasswordLink.setFont(new Font("D2Coding", Font.BOLD, 12));
		forgotPasswordLink.setBounds(132, 436, 144, 15);
		loginPanel.add(forgotPasswordLink);
		
		JPanel resisterpanel = new JPanel();
		resisterpanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(resisterpanel, "registerPanel");
		resisterpanel.setLayout(null);
		
		JLabel SiginInLink = new JLabel("Sign in");
		SiginInLink.setForeground(new Color(0, 0, 255));
		SiginInLink.setFont(new Font("D2Coding", Font.PLAIN, 16));
		SiginInLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel,  "loginPanel");
				clearFields(loginFields);
				clearFields(registerFields);
			}
		});
		SiginInLink.setHorizontalAlignment(SwingConstants.CENTER);
		SiginInLink.setBounds(294, 441, 92, 19);
		resisterpanel.add(SiginInLink);
		
		JLabel logoText2 = new JLabel("UserManagement\r\n\r\n");
		logoText2.setHorizontalAlignment(SwingConstants.CENTER);
		logoText2.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		logoText2.setBounds(83, 49, 218, 53);
		resisterpanel.add(logoText2);
		
		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("CookieRun Regular", Font.PLAIN, 30));
		registerText.setBounds(118, 96, 144, 53);
		resisterpanel.add(registerText);
		
		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setFont(new Font("D2Coding", Font.BOLD, 18));
		registerUsernameLabel.setBounds(41, 159, 163, 22);
		resisterpanel.add(registerUsernameLabel);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(41, 179, 320, 32);
		resisterpanel.add(registerUsernameField);
		
		JLabel registerPasswordLabel = new JLabel("Password");
		registerPasswordLabel.setFont(new Font("D2Coding", Font.BOLD, 18));
		registerPasswordLabel.setBounds(41, 237, 163, 22);
		resisterpanel.add(registerPasswordLabel);
		
		registerPasswordlField = new JPasswordField();
		registerPasswordlField.setBounds(41, 257, 320, 32);
		resisterpanel.add(registerPasswordlField);
		
		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setFont(new Font("D2Coding", Font.BOLD, 18));
		registerNameLabel.setBounds(41, 309, 163, 22);
		resisterpanel.add(registerNameLabel);
		
		registerNameField = new JTextField();
		registerNameField.setColumns(10);
		registerNameField.setBounds(41, 329, 320, 32);
		resisterpanel.add(registerNameField);
		
		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setFont(new Font("D2Coding", Font.BOLD, 18));
		registerEmailLabel.setBounds(41, 379, 163, 22);
		resisterpanel.add(registerEmailLabel);
		
		registerEamilField = new JTextField();
		registerEamilField.setColumns(10);
		registerEamilField.setBounds(41, 399, 320, 32);
		resisterpanel.add(registerEamilField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			// 마우스클릭을 통해서 일어나는 상황
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordlField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEamilField.getText());
				
				System.out.println(userJson.toString());
				
				UserService userService = UserService.getInstance();
				
				Map<String, String> response = userService.register(userJson.toString());
				
				if(response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
		   }
		});
		registerButton.setForeground(Color.BLACK);
		registerButton.setFont(new Font("D2Coding", Font.BOLD, 19));
		registerButton.setBackground(Color.GRAY);
		registerButton.setBounds(97, 434, 195, 31);
		resisterpanel.add(registerButton);
		
		loginFields.add(usernameField);
		loginFields.add(passwordField);
		
		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordlField);
		registerFields.add(registerNameField);
		registerFields.add(registerEamilField);
	}
	
	private void clearFields(List<JTextField> textFields) {
		for(JTextField field : textFields) {
			if(field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
		
	}
}
