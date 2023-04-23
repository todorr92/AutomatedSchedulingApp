package client;

import java.awt.EventQueue;
import integrate.integrateGrpc.integrateStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import integrate.integrateGrpc.integrateBlockingStub;
import user.userGrpc.userStub;
import user.userGrpc;
import user.userGrpc.userBlockingStub;
import schedule.scheduleGrpc.scheduleStub;
import schedule.scheduleGrpc.scheduleBlockingStub;
import user.LoginRequest;
import user.LoginMessage;
import schedule.Event;
import schedule.ResponseMessage;
import schedule.SendReminder;
import schedule.scheduleGrpc;
import integrate.integrateGrpc;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.AbstractListModel;

public class GUIclient extends JFrame {
	
	private static integrateBlockingStub integrateBlockingStub;
	private static integrateStub integrateAsyncStub;
	private static userBlockingStub userBlockingStub;
	private static userStub userAsyncStub;
	private static scheduleBlockingStub scheduleBlockingStub;
	private static scheduleStub scheduleAsyncStub;
	private ServiceInfo serviceInfo;



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
	
	

private void discoverService(String user_service_type, String integrate_service_type, String schedule_service_type) {
	
	
	try {
		// Create a JmDNS instance
		JmDNS jmdnsUser = JmDNS.create(InetAddress.getLocalHost());
//		JmDNS jmdnsSchedule = JmDNS.create(InetAddress.getLocalHost());
//		JmDNS jmdnsIntegrate = JmDNS.create(InetAddress.getLocalHost());

			
		jmdnsUser.addServiceListener(user_service_type, new ServiceListener() {
			
			@Override
			public void serviceResolved(ServiceEvent event) {
				System.out.println("User Service resolved: " + event.getInfo());

				serviceInfo = event.getInfo();

				int port = serviceInfo.getPort();
				
				System.out.println("resolving " + user_service_type + " with properties ...");
				System.out.println("\t port: " + port);
				System.out.println("\t type:"+ event.getType());
				System.out.println("\t name: " + event.getName());
				System.out.println("\t description/properties: " + serviceInfo.getNiceTextString());
				System.out.println("\t host: " + serviceInfo.getHostAddresses()[0]);
			
				
			}
			
			@Override
			public void serviceRemoved(ServiceEvent event) {
				System.out.println("User service removed: " + event.getInfo());

				
			}
			
			@Override
			public void serviceAdded(ServiceEvent event) {
				System.out.println("User service added: " + event.getInfo());

				
			}
		});

		
		// Wait a bit
		Thread.sleep(2000);
		
		jmdnsUser.close();

	} catch (UnknownHostException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	/**
	 * Create the frame.
	 */
	public GUIclient() {
		
		String user_service_type = "_user._tcp.local.";
		String integrate_service_type = "_integrate._tcp.local.";
		String schedule_service_type = "_schedule._tcp.local.";
		discoverService(user_service_type, integrate_service_type, schedule_service_type);
		
//		String host = serviceInfo.getHostAddresses()[0];
//		int port = serviceInfo.getPort();
//		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		//stubs -- generate from proto
		userBlockingStub = userGrpc.newBlockingStub(channel);
//		scheduleBlockingStub = scheduleGrpc.newBlockingStub(channel);
//		integrateBlockingStub = integrateGrpc.newBlockingStub(channel);
		

		userAsyncStub = userGrpc.newStub(channel);
//		scheduleAsyncStub = scheduleGrpc.newStub(channel);
//		integrateAsyncStub = integrateGrpc.newStub(channel);
		
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 14, 96, 19);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(passwordField);
		
		JTextArea messages = new JTextArea();
		messages.setBounds(535, 10, 242, 52);
		contentPane.add(messages);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				
				LoginRequest login = LoginRequest.newBuilder().setUserName(username).setPassword(password).build();
				LoginMessage response = userBlockingStub.userLogin(login);
				
				messages.append(response.toString());

			}
		});
		loginBtn.setBounds(384, 12, 85, 21);
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(loginBtn);
		
		JLabel eventName = new JLabel("Event Name");
		eventName.setBounds(10, 151, 80, 19);
		eventName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(eventName);
		
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
		
		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eventName = eventField.getText();
				String eventEmail = eventEmailField.getText();
				
				Event event = Event.newBuilder().setName(eventName).setEmail(eventEmail).build();
				ResponseMessage response = scheduleBlockingStub.bookEvent(event);
				messages.append(response.toString());

			}
		});

		btnCreateEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreateEvent.setBounds(337, 370, 145, 21);
		contentPane.add(btnCreateEvent);
		
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
		btnSendReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reminderEmail = reminderEmailField.getText();
				String reminderMessage = reminderMessageField.getText();
				
				SendReminder reminder = SendReminder.newBuilder().setEmail(reminderEmail).setMessage(reminderMessage).build();
				ResponseMessage response = scheduleBlockingStub.sendReminder(reminder);
				messages.append(response.toString());

			}
		});

		btnSendReminder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSendReminder.setBounds(337, 511, 145, 21);
		contentPane.add(btnSendReminder);
		
		
	}
}
