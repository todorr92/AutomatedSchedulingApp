package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class GUIclient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField eventField;
	private JTextField eventEmailField;
	private JTextField reminderEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIclient frame = new GUIclient();
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
	public GUIclient() {
		setAlwaysOnTop(true);
		setTitle("AutomatedSchedulingApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setBounds(10, 11, 67, 19);
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(username);
		
		JLabel password = new JLabel("Password");
		password.setBounds(189, 14, 67, 13);
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(password);
		
		usernameField = new JTextField();
		usernameField.setBounds(83, 13, 96, 19);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(384, 12, 85, 21);
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(loginBtn);
		
		JLabel messages = new JLabel("Placeholder for messages");
		messages.setBounds(519, 6, 250, 50);
		messages.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(messages);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 14, 96, 19);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(passwordField);
		
		JLabel evetName = new JLabel("Event Name");
		evetName.setBounds(10, 151, 80, 19);
		evetName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(evetName);
		
		JLabel eventMessage = new JLabel("Message");
		eventMessage.setBounds(10, 205, 67, 19);
		eventMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(eventMessage);
		
		JLabel email = new JLabel("Email");
		email.setBounds(454, 151, 67, 19);
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(email);
		
		JLabel eventDate = new JLabel("Date");
		eventDate.setBounds(454, 205, 67, 19);
		eventDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(eventDate);
		
		eventField = new JTextField();
		eventField.setBounds(112, 151, 250, 19);
		eventField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eventField.setColumns(10);
		contentPane.add(eventField);
		
		eventEmailField = new JTextField();
		eventEmailField.setBounds(519, 151, 250, 19);
		eventEmailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eventEmailField.setColumns(10);
		contentPane.add(eventEmailField);
		
		JTextArea eventMessageField = new JTextArea();
		eventMessageField.setBounds(113, 193, 249, 152);
		contentPane.add(eventMessageField);
		
		JLabel integrationOption = new JLabel("Choose");
		integrationOption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		integrationOption.setBounds(10, 614, 67, 19);
		contentPane.add(integrationOption);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 79, 784, 14);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 401, 784, 14);
		contentPane.add(separator_1);
		
		JLabel lblCreateEvent = new JLabel("Create Event");
		lblCreateEvent.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCreateEvent.setBounds(10, 100, 200, 19);
		contentPane.add(lblCreateEvent);
		
		JLabel lblIntegrate = new JLabel("Integrate");
		lblIntegrate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIntegrate.setBounds(10, 554, 200, 29);
		contentPane.add(lblIntegrate);
		
		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreateEvent.setBounds(337, 370, 145, 21);
		contentPane.add(btnCreateEvent);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(519, 193, 250, 152);
		contentPane.add(calendar);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 542, 784, 14);
		contentPane.add(separator_1_1);
		
		JLabel lblSendReminder = new JLabel("Send Reminder");
		lblSendReminder.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSendReminder.setBounds(10, 412, 200, 29);
		contentPane.add(lblSendReminder);
		
		JLabel reminderEmail = new JLabel("Email");
		reminderEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reminderEmail.setBounds(10, 451, 67, 19);
		contentPane.add(reminderEmail);
		
		reminderEmailField = new JTextField();
		reminderEmailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reminderEmailField.setColumns(10);
		reminderEmailField.setBounds(75, 451, 250, 19);
		contentPane.add(reminderEmailField);
		
		JLabel reminderMessage = new JLabel("Message");
		reminderMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reminderMessage.setBounds(426, 447, 67, 19);
		contentPane.add(reminderMessage);
		
		JTextArea reminderMessageField = new JTextArea();
		reminderMessageField.setBounds(491, 440, 250, 40);
		contentPane.add(reminderMessageField);
		
		JList<Object> integrationList = new JList<Object>();
		integrationList.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Google", "Microsoft Outlook", "Zoom", "Microsoft Teams"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		integrationList.setSelectedIndex(0);
		integrationList.setLayoutOrientation(JList.VERTICAL_WRAP);
		integrationList.setBounds(83, 593, 242, 68);
		contentPane.add(integrationList);
		
		JButton btnIntegrate = new JButton("Integrate");
		btnIntegrate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIntegrate.setBounds(337, 684, 145, 21);
		contentPane.add(btnIntegrate);
		
		JButton btnSendReminder = new JButton("Send Reminder");
		btnSendReminder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSendReminder.setBounds(337, 511, 145, 21);
		contentPane.add(btnSendReminder);
	}
}
