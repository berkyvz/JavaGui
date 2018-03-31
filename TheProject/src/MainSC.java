import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class MainSC implements ActionListener , MouseListener{
	
	public static ArrayList<Patient>List = new ArrayList<Patient>();
	
	private JFrame mainFrame ; 
	
	
	private JTabbedPane tabbedPane;
	
	private JPanel addPatientPanel ,patientListPanel ,statusPanel;
	
	
	private JMenuBar patientListMenuBar;
	
	
	private JTextField txt_name , txt_surname , txt_email, txt_phone ,txt_search; 
	
	private JLabel lbl_name, lbl_surname , lbl_gender , lbl_birth , lbl_regTime ,   lbl_email ,lbl_a , lbl_phone, lbl_status;
	private JLabel lbl_patientFields , lbl_extraInfo;
	
	private JTextArea txt_extraInfo;
	
	private JTable table;
	DefaultTableModel tableModel ;
	
	
	private JComboBox cb_email;
	private JComboBox cb_birthD ,cb_birthM,cb_birthY ;
	private JComboBox cb_regD ,cb_regM,cb_regY ;
	
	private JRadioButton rb_male , rb_female;
	private ButtonGroup btnGroup;
	private JButton btn_savePatient , btn_resetPatient , btn_reflesh , btn_edit , btn_delete , btn_showPatient, btn_search;
	
	
	
	public JPanel addPatientPanel(){
		addPatientPanel = new JPanel();
		addPatientPanel.setLayout(null);
		
		String [] Email = {"live.com","gmail.com","hotmail.com","yahoo.com","bilgiedu.net"};
				
		String [] Day = new String[32];
		Day[0] = "Day";
		for (int i = 1 ; i <= 31 ; i++) {
			Day[i]=i+"";
		}
		
		
		String [] Month = new String[13];
		Month[0] = "Month";
		for (int i = 1 ; i <= 12 ; i++) {
			Month[i]=i+"";
		}
		
		String [] Year = new String[121];
		Year[0] = "Year";
		for (int i = 1 ; i <= 120 ; i++) {
			Year[i]=(i+1897)+"";
		}
		
		lbl_name = new JLabel("Name:");
		lbl_name.setSize(75,35);
		lbl_name.setLocation(50,70);
		txt_name = new JTextField();
		txt_name.setSize(190,25);
		txt_name.setLocation(120,77);
		addPatientPanel.add(lbl_name);
		addPatientPanel.add(txt_name);
		

		lbl_surname= new JLabel("Surname:");
		lbl_surname.setSize(75,35);
		lbl_surname.setLocation(50,120);
		txt_surname = new JTextField();
		txt_surname.setSize(190,25);
		txt_surname.setLocation(120,127);
		addPatientPanel.add(lbl_surname);
		addPatientPanel.add(txt_surname);
		
		
		lbl_gender = new JLabel("Gender:");
		lbl_gender.setSize(75,35);
		lbl_gender.setLocation(50,170);
		
		
		rb_female = new JRadioButton("Female",false);
		rb_female.setSize(80,35);
		rb_male= new JRadioButton("Male" , false);
		rb_male.setSize(80,35);
		
		rb_female.setLocation(125,171);
		rb_male.setLocation(205,171);
		
		btnGroup = new ButtonGroup();
		
		btnGroup.add(rb_male);
		btnGroup.add(rb_female);
		addPatientPanel.add(lbl_gender);
		addPatientPanel.add(rb_female);
		addPatientPanel.add(rb_male);

		
		lbl_birth = new JLabel("Birth:");
		lbl_birth.setSize(75,35);
		lbl_birth.setLocation(50,220);
		cb_birthD = new JComboBox<>(Day);
		cb_birthD.setSize(52,25);
		cb_birthD.setLocation(120,222);
		
		cb_birthM = new JComboBox<>(Month);
		cb_birthM.setSize(70,25);
		cb_birthM.setLocation(173,222);
		
		cb_birthY = new JComboBox<>(Year);
		cb_birthY.setSize(65,25);
		cb_birthY.setLocation(245,222);
		
		addPatientPanel.add(lbl_birth);
		addPatientPanel.add(cb_birthD);
		addPatientPanel.add(cb_birthM);
		addPatientPanel.add(cb_birthY);
		
		lbl_regTime = new JLabel("Reg.Time:");
		lbl_regTime.setSize(75,35);
		lbl_regTime.setLocation(50,270);
		
		
		cb_regD = new JComboBox<>(Day);
		cb_regD.setSize(52,25);
		cb_regD.setLocation(120,272);
		
		cb_regM = new JComboBox<>(Month);
		cb_regM.setSize(70,25);
		cb_regM.setLocation(173,272);
		
		cb_regY = new JComboBox<>(Year);
		cb_regY.setSize(65,25);
		cb_regY.setLocation(245,272);
		
		addPatientPanel.add(lbl_regTime);
		addPatientPanel.add(cb_regD);
		addPatientPanel.add(cb_regM);
		addPatientPanel.add(cb_regY);
		
		lbl_email= new JLabel("E-Mail:");
		lbl_email.setSize(75,35);
		lbl_email.setLocation(50,320);
		lbl_a= new JLabel("@");
		lbl_a.setSize(25,35);
		lbl_a.setLocation(205,320);
		txt_email = new JTextField();
		txt_email.setSize(80,25);
		txt_email.setLocation(120,325);
		cb_email= new JComboBox<>(Email);
		cb_email.setSize(85,25);
		cb_email.setLocation(225,325);
		addPatientPanel.add(lbl_email);
		addPatientPanel.add(txt_email);
		addPatientPanel.add(cb_email);
		addPatientPanel.add(lbl_a);
		
		
		lbl_phone = new JLabel("Phone:");
		lbl_phone.setSize(75,35);
		lbl_phone.setLocation(50,370);
		txt_phone = new JTextField();
		txt_phone.setSize(190,25);
		txt_phone.setLocation(120,372);
		addPatientPanel.add(lbl_phone);
		addPatientPanel.add(txt_phone);
		

		txt_extraInfo = new JTextArea();
		txt_extraInfo.setSize(400, 320);
		txt_extraInfo.setLocation(400,75);
		txt_extraInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addPatientPanel.add(txt_extraInfo);
		
		lbl_extraInfo = new JLabel("Extra Information");
		lbl_extraInfo.setFont(new Font("Verdana", Font.BOLD, 18));
		lbl_extraInfo.setLocation(400,  5);
		lbl_extraInfo.setSize(200,55);
		addPatientPanel.add(lbl_extraInfo);
		
		lbl_patientFields = new JLabel("Patient Information");
		lbl_patientFields.setFont(new Font("Verdana", Font.BOLD, 18));
		lbl_patientFields.setLocation(50, 5);
		lbl_patientFields.setSize(220,55);
		addPatientPanel.add(lbl_patientFields);
		
		btn_resetPatient = new JButton("  Reset Patient");
		btn_resetPatient.setSize(200,50);
		btn_resetPatient.setLocation(400,430);
		btn_resetPatient.addActionListener(this);
		Image img1 = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		btn_resetPatient.setIcon(new ImageIcon(img1));
		addPatientPanel.add(btn_resetPatient);
		
		btn_savePatient = new JButton("Save Patient");
		btn_savePatient.setSize(200,50);
		btn_savePatient.setLocation(120,430);
		btn_savePatient.addActionListener(this);
		Image img2 = new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		btn_savePatient.setIcon(new ImageIcon(img2));
		addPatientPanel.add(btn_savePatient);
		
		
		return addPatientPanel;
	}
	
	public MainSC(){
		
		mainFrame = new JFrame();
		Image img = new ImageIcon(this.getClass().getResource("/hospital.png")).getImage();
		mainFrame.setIconImage(img);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setTitle("Hospital Software");
		mainFrame.setSize(870, 600);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());

		tabbedPane = new JTabbedPane();
		
		addPatientPanel = new JPanel();
		tabbedPane.add("ADD PATIENT", addPatientPanel());
		patientListPanel = new JPanel();
		tabbedPane.add("PATIENT LIST", patientListPanel());

		statusPanel = new JPanel();
		statusPanel.setLayout(new FlowLayout());
		lbl_status = new JLabel("This is the Status Bar");
		lbl_status.setFont(new Font("Arial", Font.BOLD , 14));
		statusPanel.add(lbl_status);
		
		mainFrame.setLocation(((screenSize.width - 870) / 2), ((screenSize.height - 600) / 2));
		mainFrame.add(tabbedPane);
		mainFrame.add(statusPanel , BorderLayout.SOUTH);
		

		
		mainFrame.setVisible(true);
		
		
	}
	
	
	public JPanel patientListPanel(){
		patientListPanel = new JPanel();
		patientListPanel.setLayout(new BorderLayout());
		
		patientListMenuBar = new JMenuBar();
		patientListMenuBar.setPreferredSize(new Dimension(mainFrame.getWidth() , 40));

		String [] ColumnNames = {"No","Name","Surname","Gender","Birth" , "Registration" , "E-Mail", "Phone"};
		tableModel = new DefaultTableModel(ColumnNames, 0);
		table = new JTable(tableModel);
		table.setSelectionBackground(Color.green);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		table.setLocation(100,50);
		table.setSize(500,400);		
		table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JScrollPane sp = new JScrollPane(table);
		patientListPanel.add(sp);
		
		
		Image img1 = new ImageIcon(this.getClass().getResource("/reflesh.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		Image img4 = new ImageIcon(this.getClass().getResource("/show.png")).getImage();
		Image img5 = new ImageIcon(this.getClass().getResource("/saerch.png")).getImage();

		txt_search = new JTextField("Name of Patient");
		txt_search.setToolTipText("Write Here To find by Name");
		txt_search.addMouseListener(this);
		

		
		btn_search = new JButton("   Search");
		btn_search.setIcon(new ImageIcon(img5));
		btn_search.addActionListener(this);
	
		btn_reflesh = new JButton("   Reflesh");
		btn_reflesh.setIcon(new ImageIcon(img1));
		btn_reflesh.addActionListener(this);
		
		btn_delete = new JButton("    Delete");
		btn_delete.setIcon(new ImageIcon(img2));
		btn_delete.addActionListener(this);
		
		btn_edit = new JButton("  Edit");
		btn_edit.setIcon(new ImageIcon(img3));
		btn_edit.addActionListener(this);
		
		btn_showPatient = new JButton("  Show Patient");
		btn_showPatient.setIcon(new ImageIcon(img4));
		btn_showPatient.addActionListener(this);
		
		patientListMenuBar.add(btn_reflesh);
		patientListMenuBar.add(btn_delete);
		patientListMenuBar.add(btn_edit);
		patientListMenuBar.add(btn_showPatient);
		patientListMenuBar.add(btn_search);
		patientListMenuBar.add(txt_search);
		
		patientListPanel.add(patientListMenuBar, BorderLayout.NORTH);
		
		return patientListPanel;
	}
	
	public static void main(String[] args) {
		
		new MainSC();
	}

	public void savePatientButton(){
		
		if(		txt_name.getText().equals("") 
				||txt_surname.getText().equals("")
				||txt_email.getText().equals("")  
				||txt_phone.getText().equals("")  
				||cb_birthD.getSelectedIndex()== 0
				||cb_birthM.getSelectedIndex()== 0
				||cb_birthY.getSelectedIndex()== 0
				||cb_regD.getSelectedIndex()== 0
				||cb_regM.getSelectedIndex()== 0
				||cb_regY.getSelectedIndex()== 0 
				||( (rb_female.isSelected()==true && rb_male.isSelected()==true)
				|| (rb_female.isSelected()==false && rb_male.isSelected()==false))
				){
			
					statusPanel.setBackground(Color.red);
					lbl_status.setText("WARNING !");
					JOptionPane.showMessageDialog(null, "Fill the blanks , Select the times , Choose one of them in Gender", "Something Missed", JOptionPane.WARNING_MESSAGE, null);

					
				}
				else{	
					addPatient();
		
				}
	}
	
	public void addPatient() {

		int num = 0;

		String name = txt_name.getText();
		String surName = txt_surname.getText();
		String gender;
		if (rb_female.isSelected()) {
			gender = "Female";
		} else {
			gender = "Male";
		}

		String birth;

		String Bd = (String) cb_birthD.getSelectedItem();
		String Bm = (String) cb_birthM.getSelectedItem();
		String By = (String) cb_birthY.getSelectedItem();

		birth = Bd + "." + Bm + "." + By;

		String reg;

		String Rd = (String) cb_regD.getSelectedItem();
		String Rm = (String) cb_regM.getSelectedItem();
		String Ry = (String) cb_regY.getSelectedItem();

		reg = Rd + "." + Rm + "." + Ry;

		String email;

		String fp_email = txt_email.getText() + "@";
		String sp_email = (String) cb_email.getSelectedItem();

		email = fp_email + sp_email;

		String phone = txt_phone.getText();

		String extraInfo = txt_extraInfo.getText();

		Patient p = new Patient(num, name, surName, gender, birth, reg, email, phone, extraInfo);
		
		String savedPatient = p.getName() + " " + p.getSurName();
		boolean  isExist = false;
		
		for (int i = 0; i < List.size(); i++) {
			Patient Checkp = List.get(i);

			if (p.isSame(Checkp)) {
				isExist = true;
			}

		}

		if (!isExist) {
			List.add(p);
			lbl_status.setText(savedPatient + " saved to the List.");
			statusPanel.setBackground(Color.GREEN);
		}
		if (isExist) {
			lbl_status.setText(savedPatient + " can not saved to the List.There is same Patient");
			statusPanel.setBackground(Color.red);

		}

	}
	
	public void resetPatientForm(){
		txt_extraInfo.setText("");
		txt_email.setText("");
		txt_name.setText("");
		txt_surname.setText("");
		txt_phone.setText("");
		
		
		cb_birthD.setSelectedIndex(0);
		cb_birthM.setSelectedIndex(0);
		cb_birthY.setSelectedIndex(0);
		
		cb_email.setSelectedIndex(0);

		cb_regD.setSelectedIndex(0);
		cb_regM.setSelectedIndex(0);
		cb_regY.setSelectedIndex(0);
		
		rb_female.setSelected(false);
		rb_male.setSelected(false);
		
		
	}
	
	public void showPatient(){
		
		try{
			
		int rowX = table.getSelectedRow();
		int ListID =(int) table.getValueAt(rowX, 0) -1;
		
		
		Patient showPatient = List.get(ListID);
		
		statusPanel.setBackground(Color.orange);
		lbl_status.setText("Showing -> "+showPatient.getName()+" "+showPatient.getSurName());
		
		JOptionPane.showMessageDialog(null
				, "Name : \t"+showPatient.getName()+"\n"
				+ "Surname : \t"+showPatient.getSurName()+"\n"
				+ "Gender : \t"+showPatient.getGender()+"\n"
				+ "Birth Time : \t"+showPatient.getBirthTime()+"\n"
				+ "Registration : \t"+showPatient.getRegTime()+"\n"
				+ "E-mail : \t"+showPatient.getEmail()+"\n"
				+ "Phone : \t"+showPatient.getPhone()+"\n" 
				+ "extra : \t"+showPatient.getExtraInfo()
				, ""+showPatient.getName()+" "+showPatient.getSurName(), JOptionPane.INFORMATION_MESSAGE, null);
		
		
		}catch(Exception e){

			statusPanel.setBackground(Color.red);
			lbl_status.setText("WARNING ! Select a patient than can be Shown !");
			
		}
	}
	
	public void edit(){
		
		try {
	
			int rowX = table.getSelectedRow();
			int ListID =(int) table.getValueAt(rowX, 0) -1;
			Patient editPatient = List.get(ListID);
		
		
		Object [] Options = {"Name","Surname","Gender","Birth","Reg.Time","Email","Phone","ExtraInfo"};
		
		int answer = JOptionPane.showOptionDialog(null, "You Select :"+ editPatient.getName() +" "+editPatient.getSurName()+"\nWhat do you want to Edit?", "Edit Page", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, Options, Options[0]);
		
		if (answer == 0) {
			String name =JOptionPane.showInputDialog("Old Name :"+editPatient.getName()+"\nEnter a new One");
			editPatient.setName(name);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		if (answer == 1) {
			String surname =JOptionPane.showInputDialog("Old Surname :"+editPatient.getSurName()+"\nEnter a new One");
			editPatient.setSurName(surname);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		if (answer == 2) {
			String gender =JOptionPane.showInputDialog("Old Gender :"+editPatient.getGender()+"\nEnter a new One");
			editPatient.setGender(gender);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		if (answer == 3) {
			String birth =JOptionPane.showInputDialog("Old Birth :"+editPatient.getBirthTime()+"\nEnter a new One");
			editPatient.setBirthTime(birth);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		if (answer == 4) {
			String RegTime =JOptionPane.showInputDialog("Old Reg.Time :"+editPatient.getRegTime()+"\nEnter a new One");
			editPatient.setRegTime(RegTime);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		if (answer == 5) {
			String email =JOptionPane.showInputDialog("Old Email :"+editPatient.getEmail()+"\nEnter a new One");
			editPatient.setEmail(email);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		if (answer == 6) {
			String phone =JOptionPane.showInputDialog("Old Phone :"+editPatient.getPhone()+"\nEnter a new One");
			editPatient.setPhone(phone);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		if (answer == 7) {
			String name =JOptionPane.showInputDialog("Old ExtraInfo :"+editPatient.getName()+"\nEnter a new One");
			editPatient.setName(name);
			statusPanel.setBackground(Color.YELLOW);
			lbl_status.setText("Edited");
		}
		
		} catch (Exception e) {
			statusPanel.setBackground(Color.red);
			lbl_status.setText("WARNING ! Select A patient than can be able to Edit !");
		}
		
		reflesh();
		
	}
	
	
	
	
	
	public void reflesh(){
		
		tableModel.setRowCount(0);
		
		for (int i = 0; i < List.size() ; i++) {
			
			
			List.get(i).setNum(i+1);
			
			Object[] row = {List.get(i).getNum(),List.get(i).getName(),List.get(i).getSurName() 
					, List.get(i).getGender() , List.get(i).getBirthTime(), List.get(i).getRegTime(),
					List.get(i).getEmail(), List.get(i).getPhone()};

			tableModel.addRow(row);
			
		}
			
		
		
	}
	
	public void search(){ 
		
		int counter= 0;
	tableModel.getDataVector().removeAllElements();
	String name = txt_search.getText();
		for (int i = 0; i < List.size() ; i++) {
			
			if(name.equals(List.get(i).getName())){
				counter++;
			
			
			Object[] row = {List.get(i).getNum(),List.get(i).getName(),List.get(i).getSurName() 
					, List.get(i).getGender() , List.get(i).getBirthTime(), List.get(i).getRegTime(),
					List.get(i).getEmail(), List.get(i).getPhone()};

			tableModel.addRow(row);
			
				}
			
		}
		
		if(counter == 0){
			lbl_status.setText("There is no "+name);
			statusPanel.setBackground(Color.red);
		}
		else{
			lbl_status.setText(counter+" Patient founded name is "+name);
			statusPanel.setBackground(Color.ORANGE);
		}
	}
	
	public void delete(){
		try{
			
			int rowX = table.getSelectedRow();
			int Index = (int) table.getValueAt(rowX, 0)-1;
			String name = List.get(Index).getName();
			String surName = List.get(Index).getSurName();
			List.remove(Index);
			String whois= name+" "+surName;
			statusPanel.setBackground(Color.orange);
			lbl_status.setText(whois+" Deleted");
			
			reflesh();
			}catch(Exception e1){

				statusPanel.setBackground(Color.RED);
				lbl_status.setText("WARNING ! Select a Patient First");
				
			}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btn_savePatient)){
				savePatientButton();
			}
		if(e.getSource().equals(btn_resetPatient)){
			resetPatientForm();
			statusPanel.setBackground(Color.white);
			lbl_status.setText("Form has been Reset");
		}
		if(e.getSource().equals(btn_reflesh)){
			reflesh();
			statusPanel.setBackground(Color.CYAN);
			lbl_status.setText("Refleshed !"+ List.size() +" patient in the List");
		}
		if(e.getSource().equals(btn_delete)){
			delete();
		}
		if(e.getSource().equals(btn_edit)){
			edit();
		}
		if(e.getSource().equals(btn_showPatient)){
			showPatient();
		}
		if(e.getSource().equals(btn_search)){
			search();
		}
		
		
	

}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(txt_search)){
			txt_search.setText("");
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
