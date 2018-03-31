import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSC implements ActionListener , KeyListener{

	private JFrame loginFrame;


	private JPanel menuPanel, loginPanel, statuPanel;

	private JMenuBar menBar;
	private JMenu menu_file, menu_help;
	private JMenuItem item_exit, item_help;

	private JTextField txt_userName;
	private JPasswordField txt_pass;
	private  JLabel lbl_welcome, lbl_username, lbl_pass, lbl_statu;
	private JButton btn_login;

	public LoginSC() {
		
		
		loginFrame = new JFrame();
		Image img = new ImageIcon(this.getClass().getResource("/hospital.png")).getImage();
		loginFrame.setIconImage(img);
		loginFrame.setLayout(new BorderLayout());
		loginFrame.setTitle("Login Page");
		loginFrame.setSize(530, 340);
		loginFrame.setResizable(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());


		loginFrame.setLocation(((screenSize.width - 530) / 2), ((screenSize.height - 530) / 2));

		loginFrame.add(initiliazeMenuPanel(), BorderLayout.NORTH);
		loginFrame.add(initiliazeLoginPanel(), BorderLayout.CENTER);
		loginFrame.add(initiliazeStatuPanel(), BorderLayout.SOUTH);

		loginFrame.setVisible(true);
	}
	
	public JPanel initiliazeStatuPanel(){
		statuPanel = new JPanel();
		statuPanel.setBackground(Color.WHITE);
		lbl_statu = new JLabel("Enter a Username and Password");
		lbl_statu.setSize(new Dimension(120, 35));
		statuPanel.add(lbl_statu);
		
		
		return statuPanel;
	}

	public JPanel initiliazeLoginPanel() {

		loginPanel = new JPanel();
		loginPanel.setLayout(null);

		txt_userName = new JTextField();
		txt_userName.setToolTipText("Enter Your Username Here!");
		txt_userName.setSize(new Dimension(200, 35));
		txt_userName.setLocation(275, 100);
		txt_userName.addKeyListener(this);
		
		txt_pass = new JPasswordField();
		txt_pass.setToolTipText("Enter Your Password Here!");
		txt_pass.setSize(new Dimension(200, 35));
		txt_pass.setLocation(275, 150);
		txt_pass.addKeyListener(this);
		
		lbl_welcome = new JLabel("Welcome to Login Page");
		lbl_welcome.setSize(400, 65);
		lbl_welcome.setLocation(185, 20);
		lbl_welcome.setFont(new Font("Verdana", Font.BOLD, 18));

		lbl_username = new JLabel("User Name :");
		lbl_username.setSize(100, 65);
		lbl_username.setLocation(185, 80);

		lbl_pass = new JLabel("Password  :");
		lbl_pass.setSize(100, 65);
		lbl_pass.setLocation(185, 135);

		btn_login = new JButton("Log In");
		btn_login.setSize(120, 35);
		btn_login.setLocation(355, 200);
		btn_login.addActionListener(this);
		Image img2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		
		btn_login.setIcon(new ImageIcon(img2));


		JLabel imageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/key.png")).getImage();
		imageLabel.setIcon(new ImageIcon(img));
		imageLabel.setSize(128, 128);
		imageLabel.setLocation(20, 60);

		loginPanel.add(imageLabel);
		loginPanel.add(lbl_username);
		loginPanel.add(lbl_pass);
		loginPanel.add(lbl_welcome);
		loginPanel.add(txt_pass);
		loginPanel.add(txt_userName);
		loginPanel.add(btn_login);
		loginPanel.add(new JLabel(new ImageIcon("key.png")));

		return loginPanel;
	}

	public JPanel initiliazeMenuPanel() {

		menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());

		menBar = new JMenuBar();
		menBar.setSize(600, 35);

		menu_file = new JMenu("File");
		item_exit = new JMenuItem("Exit");
		item_exit.addActionListener(this);
		menu_file.add(item_exit);

		menu_help = new JMenu("Help");
		item_help = new JMenuItem("Help");
		item_help.addActionListener(this);
		menu_help.add(item_help);

		menBar.add(menu_file);
		menBar.add(menu_help);

		menuPanel.add(menBar, BorderLayout.NORTH);

		return menuPanel;

	}

	public static void main(String[] args) {
		new LoginSC();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_login)) {
			buttonLogin();
		}
		if (e.getSource().equals(item_exit)) {
			System.exit(0);
		}
		if (e.getSource().equals(item_help)) {
			JOptionPane.showMessageDialog( null, "If you have some problem about LogIn page.."
					+ "\nContact author :\n"
					+ "Berk Yavuz\n113200013", "Help" , JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void buttonLogin() {
		String userName = txt_userName.getText();
		String passWord = txt_pass.getText();

		if (userName.equals("admin") && passWord.equals("admin")) {
			statuPanel.setBackground(Color.green);
			lbl_statu.setText("Correct !");
			JOptionPane.showMessageDialog(null, "Successful !", "Information", JOptionPane.INFORMATION_MESSAGE, null);
			 new MainSC();
			loginFrame.dispose();
		} else {

			lbl_statu.setText("Wrong Password or Username ! ");
			statuPanel.setBackground(Color.red);

		}

	}
	
	public void escape(){
		int a = JOptionPane.showConfirmDialog(null, "Are you Sure", "EXIT", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
		if(a == 0){
			System.exit(0);
		}
		
	}

	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			buttonLogin();
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			escape();
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
