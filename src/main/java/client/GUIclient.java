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

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setBounds(83, 13, 96, 19);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(384, 12, 85, 21);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton);
		
		JLabel messageForLoginLogout = new JLabel("Placeholder for messages");
		messageForLoginLogout.setBounds(519, 6, 250, 50);
		messageForLoginLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(messageForLoginLogout);
		
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 151, 250, 19);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(519, 151, 250, 19);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(113, 193, 249, 152);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Choose");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3_1.setBounds(10, 614, 67, 19);
		contentPane.add(lblNewLabel_3_3_1);
		
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
		
		JButton createEvent = new JButton("Create Event");
		createEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createEvent.setBounds(337, 370, 145, 21);
		contentPane.add(createEvent);
		
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
		
		JLabel email_1 = new JLabel("Email");
		email_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email_1.setBounds(10, 451, 67, 19);
		contentPane.add(email_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(75, 451, 250, 19);
		contentPane.add(textField_3);
		
		JLabel eventMessage_1 = new JLabel("Message");
		eventMessage_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eventMessage_1.setBounds(426, 447, 67, 19);
		contentPane.add(eventMessage_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(491, 440, 250, 40);
		contentPane.add(textArea_1);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Google", "Microsoft Outlook", "Zoom", "Microsoft Teams"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setBounds(83, 593, 242, 68);
		contentPane.add(list);
		
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
