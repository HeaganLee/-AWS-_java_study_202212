package simplechating.client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChattingClient extends JFrame {
	
	private Socket socket;
	private String username;
	

	private JPanel contentPane;
	private JTextField ipinput;
	private JTextField portinput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList userList;
	private DefaultListModel<String> userListModel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipinput = new JTextField();
		ipinput.setText("127.0.0.1");
		ipinput.setBounds(408, 18, 114, 30);
		contentPane.add(ipinput);
		ipinput.setColumns(10);
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				
				ip = ipinput.getText();
				port = Integer.parseInt(portinput.getText());
				
				try {
					socket = new Socket(ip, port);
					
					JOptionPane.showMessageDialog(null, socket.getInetAddress() + "서버 접속", 
							"접속성공", 
							JOptionPane.INFORMATION_MESSAGE);
					
					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					
					if(in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null, "사용자이름을 입력하세요.", JOptionPane.INFORMATION_MESSAGE);
						
						OutputStream outputStream =  socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						
						out.println(username);
						
					}
					
					Thread thread = new Thread(() -> {
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));
							
							while(true) {
								String message = reader.readLine();
								if(message.startsWith("@welcome")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
								}else if(message.startsWith("@userList")) {
									System.out.println(message);
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username : usernames) {
										userListModel.addElement(username);
									}
									continue;
								}
								contentView.append(message + "\n");
								
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}); 
					
					thread.start();
					
				}catch (ConnectException e1) {
					
					JOptionPane.showMessageDialog(null, 
							"서버 접속 실패 ", 
							"접속실패", 
							JOptionPane.ERROR_MESSAGE);}
					
				
				catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connectButton.setBounds(572, 17, 70, 31);
		contentPane.add(connectButton);
		
		portinput = new JTextField();
		portinput.setText("9090");
		portinput.setBounds(529, 18, 41, 30);
		contentPane.add(portinput);
		portinput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 18, 387, 351);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(408, 58, 222, 311);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 370, 558, 41);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					if(!messageInput.getText().isBlank()) {
						
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);
							
							out.println(username + " : " + messageInput.getText());
							messageInput.setText("");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
					
				}
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(!messageInput.getText().isBlank()) {
					
					
						
						
							
							try {
								OutputStream outputStream = socket.getOutputStream();
								PrintWriter out = new PrintWriter(outputStream, true);
								
								out.println(username + " : " + messageInput.getText());
								messageInput.setText("");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
						
					}
					
				
				
			}
		});
		sendButton.setBounds(572, 370, 70, 41);
		contentPane.add(sendButton);
	}
	
	
	
}
