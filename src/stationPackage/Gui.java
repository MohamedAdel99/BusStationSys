package stationPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTextField;

import org.xml.sax.ErrorHandler;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class Gui {

	private JFrame frame;
	private JPanel Menu;
    private  JPanel CustomersPanel;
    private JPanel ManagersPanel;
    private JTextField textField;
    private JPanel AddTrip;
    private JPanel PricePanel;
    private JPanel DriverPanel;
    private JPanel AvaliablePanel;
    private JPanel Booking;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField txtDdmmyyyy;
    private JTextField txtDdmmyyyyinCase;
    private JTextField textField_3;
    private JTextField textField_4;
    private JComboBox comboBox_4;
    private JComboBox comboBox_6;
     Trips t[] = new Trips[100];
     Trips ob1 = new Trips(null, null, null);
     Passengers p[] = new Passengers[100];
     Reading_Tfile rt = new Reading_Tfile();
     Reading_Pfile rp = new Reading_Pfile();
     Drivers d[] = new Drivers[100];
     public int nP=0;
     public int nd=0;
     public int nT=0;
   String x;
   String y;
   String type;
   int numoftrip;
     private JTextField textField_5;
     private JTextField textField_6;
     private JTextField textField_7;
     private JTextField textField_8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ob1.initial(t);
		frame = new JFrame();
		frame.setBounds(100, 100, 946, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		/////////Reading//////////
		nT=rt.loading(t);
		nP=rp.loading(p);
		System.out.println(nP);
		////////////////////////
		//price set//distance set
		Trips.price.put("Cairo",100);
		Trips.price.put("Aswan",200);
		Trips.price.put("Suez",150);
		Trips.price.put("Hurgada",400);
		Trips.distance.put("Cairo",220);
		Trips.distance.put("Aswan",1075);
		Trips.distance.put("Suez",370);
		Trips.distance.put("Hurgada",670);
		///////////////////////
		 JPanel Menu = new JPanel();
		 Menu.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(Menu, "name_182538505339163");
		Menu.setLayout(null);
		Menu.setVisible(true);
		
		 JPanel CustomersPanel = new JPanel();
		 CustomersPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(CustomersPanel, "name_182538522133039");
		CustomersPanel.setLayout(null);
		

		JPanel PricePanel = new JPanel();
		frame.getContentPane().add(PricePanel, "name_793232453339484");
		PricePanel.setLayout(null);
		PricePanel.setVisible(false);
		
		JPanel Booking = new JPanel();
		Booking.setBackground(Color.GRAY);
		frame.getContentPane().add(Booking, "name_894633632948118");
		Booking.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_1.setBackground(Color.LIGHT_GRAY);
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setBounds(95, 103, 663, 112);
		Booking.add(textArea_1);
		
		textField_8 = new JTextField();
		textField_8.setBackground(Color.LIGHT_GRAY);
		textField_8.setBounds(320, 251, 116, 22);
		Booking.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number of tickets");
		lblEnterNumberOf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterNumberOf.setBounds(105, 254, 203, 16);
		Booking.add(lblEnterNumberOf);
		
		JLabel lblPaymentMethod = new JLabel("Payment method");
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPaymentMethod.setBounds(105, 299, 203, 22);
		Booking.add(lblPaymentMethod);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Visa"}));
		comboBox_5.setBounds(338, 300, 80, 22);
		Booking.add(comboBox_5);
		
		JButton btnFinish = new JButton("FINISH!");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nP++;
				nP=rp.saving(p,nP,"Trip to : "+t[numoftrip].getDest());
				int numboftick = Integer.parseInt(textField_8.getText());
				JOptionPane.showMessageDialog(null,"Ticket #T-0"+nP+"Total price "+numboftick*Trips.price.get(t[numoftrip].getDest())+"'EGP Thank you!");
				Menu.setVisible(true);
				Booking.setVisible(false);
			}
		});
		btnFinish.setBounds(320, 372, 97, 25);
		Booking.add(btnFinish);
		Booking.setVisible(false);
		
		//-----------
		JPanel AddTrip = new JPanel();
		AddTrip.setBackground(Color.GRAY);
		frame.getContentPane().add(AddTrip, "name_522921061758667");
		AddTrip.setLayout(null);
		
		JLabel lblAddTrip = new JLabel("Add Trip");
		lblAddTrip.setBounds(367, 33, 168, 35);
		lblAddTrip.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddTrip.add(lblAddTrip);
		
		JLabel lblTripTo = new JLabel("Trip To");
		lblTripTo.setBounds(216, 94, 56, 16);
		lblTripTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddTrip.add(lblTripTo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(346, 92, 76, 22);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Cairo", "Aswan", "Suez"}));
		AddTrip.add(comboBox_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"one way", "round trip"}));
		comboBox_4.setBounds(342, 127, 97, 22);
		AddTrip.add(comboBox_4);
		
		JLabel lblVehicleType = new JLabel("Vehicle type");
		lblVehicleType.setBounds(191, 166, 111, 16);
		lblVehicleType.setFont(new Font("Tahoma", Font.BOLD, 16));
		AddTrip.add(lblVehicleType);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Bus", "Limo", "Minibus"}));
		comboBox_2.setBounds(346, 164, 76, 22);
		AddTrip.add(comboBox_2);
		
		JLabel lblDriversName = new JLabel("Driver's name");
		lblDriversName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDriversName.setBounds(191, 210, 115, 30);
		AddTrip.add(lblDriversName);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(342, 215, 237, 22);
		AddTrip.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDriversLicenise = new JLabel("Driver's License number ");
		lblDriversLicenise.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDriversLicenise.setBounds(121, 258, 237, 30);
		AddTrip.add(lblDriversLicenise);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(341, 263, 238, 22);
		AddTrip.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDepartureDate = new JLabel("Departure date");
		lblDepartureDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartureDate.setBounds(153, 301, 163, 16);
		AddTrip.add(lblDepartureDate);
		
		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.setText("dd/mm/yyyy");
		txtDdmmyyyy.setBounds(342, 298, 237, 22);
		AddTrip.add(txtDdmmyyyy);
		txtDdmmyyyy.setColumns(10);
		
		JLabel lblReturnDate = new JLabel("Return date");
		lblReturnDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReturnDate.setBounds(153, 330, 163, 16);
		AddTrip.add(lblReturnDate);
		
		txtDdmmyyyyinCase = new JTextField();
		txtDdmmyyyyinCase.setText("dd/mm/yyyy *(in case its a round trip)*");
		txtDdmmyyyyinCase.setColumns(10);
		txtDdmmyyyyinCase.setBounds(342, 333, 237, 22);
		AddTrip.add(txtDdmmyyyyinCase);
		
		JLabel lblTripPrice = new JLabel("Trip Price");
		lblTripPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTripPrice.setBounds(174, 367, 125, 16);
		AddTrip.add(lblTripPrice);
		
		
		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {	
				Date start = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
	                    .parse(txtDdmmyyyy.getText());
	            Date end = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
	                    .parse(txtDdmmyyyyinCase.getText());	
			if(start.compareTo(end) > 0)
				JOptionPane.showMessageDialog(null,"Error in DATE");
			else
			{ t[nT].setDest((String)comboBox_1.getSelectedItem());
			t[nT].setTypes((String)comboBox_4.getSelectedItem());
			t[nT].setDate("dep: "+txtDdmmyyyy.getText()+" return: "+txtDdmmyyyyinCase.getText());
			d[nd]= new Drivers(null, 0, 0, null);
			d[nd].setName(textField_1.getText());
			d[nd].setLicence(textField_2.getText());
			int price = Integer.parseInt(textField_6.getText());
			Trips.price.put((String)comboBox_4.getSelectedItem(),price);
			nT++;
			nd++;
				JOptionPane.showMessageDialog(null, "Added!");
				Menu.setVisible(true);
				AddTrip.setVisible(false);}
			}
			 catch(Exception E)
			   {
				   JOptionPane.showMessageDialog(null,"Error in input");
			   }}
		});
		btnNewButton_4.setBounds(325, 424, 97, 25);
		AddTrip.add(btnNewButton_4);
		
		JLabel lblTripType_1 = new JLabel("Trip Type");
		lblTripType_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTripType_1.setBounds(191, 129, 100, 16);
		AddTrip.add(lblTripType_1);
		
		textField_6 = new JTextField();
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.setBounds(346, 368, 76, 22);
		AddTrip.add(textField_6);
		textField_6.setColumns(10);
		
	
		
		AddTrip.setVisible(false);
		// ------
		JPanel DriverPanel = new JPanel();
		DriverPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(DriverPanel, "name_793609434317461");
		DriverPanel.setLayout(null);
		DriverPanel.setVisible(false);
		
		JLabel lblNewDriver = new JLabel("New Driver");
		lblNewDriver.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewDriver.setBounds(394, 27, 97, 27);
		DriverPanel.add(lblNewDriver);
		
		JLabel lblDriverName = new JLabel("Driver name");
		lblDriverName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDriverName.setBounds(248, 101, 130, 27);
		DriverPanel.add(lblDriverName);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(427, 104, 238, 22);
		DriverPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLicenseNumber = new JLabel("License number");
		lblLicenseNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLicenseNumber.setBounds(248, 164, 136, 16);
		DriverPanel.add(lblLicenseNumber);
		
		textField_4 = new JTextField();
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setBounds(427, 162, 238, 22);
		DriverPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(290, 209, 56, 16);
		DriverPanel.add(lblAge);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		comboBox_3.setBounds(427, 207, 54, 22);
		DriverPanel.add(comboBox_3);
		
		JButton btnNewButton_5 = new JButton("ADD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 JOptionPane.showMessageDialog(null, "Added!");
							Menu.setVisible(true);
							DriverPanel.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(356, 307, 161, 47);
		DriverPanel.add(btnNewButton_5);
		
		//-------
		JPanel AvaliablePanel = new JPanel();
		AvaliablePanel.setBackground(Color.GRAY);
		frame.getContentPane().add(AvaliablePanel, "name_873424573353779");
		AvaliablePanel.setVisible(false);
		AvaliablePanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Avaliable trips");
		lblNewLabel_1.setBounds(263, 29, 316, 31);
		lblNewLabel_1.setFont(new Font("BankGothic Md BT", Font.BOLD, 28));
		AvaliablePanel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 14));
		textArea.setBounds(96, 86, 630, 213);
		AvaliablePanel.add(textArea);
	
		
		JLabel lblTripNumber = new JLabel("Trip Number");
		lblTripNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTripNumber.setBounds(223, 380, 115, 31);
		AvaliablePanel.add(lblTripNumber);
		
		textField_7 = new JTextField();
		textField_7.setBackground(Color.LIGHT_GRAY);
		textField_7.setBounds(368, 386, 51, 22);
		AvaliablePanel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnBook = new JButton("Book!");
		btnBook.setBackground(Color.LIGHT_GRAY);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 numoftrip=Integer.parseInt(textField_7.getText());
				System.out.println("you choose"+numoftrip);
				textArea_1.setText("Travelling To :"+t[numoftrip].getDest()+" "+t[numoftrip].getDate()+"\n"+"Ticket Price : "+Trips.price.get(t[numoftrip].getDest())+"'EGP   "+"Distance : "+Trips.distance.get(t[numoftrip].getDest())+" KM"+"  BY"+type);
				Booking.setVisible(true);
				AvaliablePanel.setVisible(false);
			}
		});
		btnBook.setBounds(459, 385, 97, 25);
		AvaliablePanel.add(btnBook);
		
		JButton btnbckButton_7 = new JButton("Change");
		btnbckButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AvaliablePanel.setVisible(false);
				CustomersPanel.setVisible(true);
			}
		});
		btnbckButton_7.setBackground(Color.LIGHT_GRAY);
		btnbckButton_7.setBounds(459, 421, 96, 25);
		AvaliablePanel.add(btnbckButton_7);
		
		JLabel lblEnterTripNumber = new JLabel("Enter Trip number in Box and press Book button to continue or Change to edit input");
		lblEnterTripNumber.setBounds(177, 335, 511, 16);
		AvaliablePanel.add(lblEnterTripNumber);
		
		
		//------------------
		
		JLabel lblBuyingATicket = new JLabel("Customer Section");
		lblBuyingATicket.setBounds(285, 13, 260, 55);
		lblBuyingATicket.setBackground(new Color(240, 240, 240));
		lblBuyingATicket.setFont(new Font("BankGothic Md BT", Font.BOLD, 21));
		CustomersPanel.add(lblBuyingATicket);
		
		JLabel lblCustomerName = new JLabel("Customer first name");
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerName.setBounds(111, 82, 188, 55);
		CustomersPanel.add(lblCustomerName);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(271, 99, 354, 22);
		CustomersPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFromAlexandria = new JLabel("From   :   Alexandria");
		lblFromAlexandria.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFromAlexandria.setBounds(94, 215, 178, 36);
		CustomersPanel.add(lblFromAlexandria);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(348, 225, 69, 16);
		CustomersPanel.add(lblTo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cairo", "Aswan", "Suez"}));
		comboBox.setBounds(502, 223, 203, 22);
		CustomersPanel.add(comboBox);
		
		
		JLabel lblTripType = new JLabel("Trip type");
		lblTripType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTripType.setBounds(297, 257, 133, 36);
		CustomersPanel.add(lblTripType);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("one way");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(168, 294, 127, 25);
		CustomersPanel.add(rdbtnNewRadioButton);
		 
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("round trip");
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(488, 294, 127, 25);
		CustomersPanel.add(rdbtnNewRadioButton_1);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Bus", "Limo", "MiniBus"}));
		comboBox_6.setBounds(393, 360, 69, 22);
		
		JButton btnNewButton = new JButton("Register and Search for avaliable Trips");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				p[nP].setFname(textField.getText());
				p[nP].setLname(textField_5.getText());
				System.out.println(p[0].getFname());
				System.out.println(p[1].getFname());
				type=(String)comboBox_6.getSelectedItem();
				x=(String)comboBox.getSelectedItem();
				if(rdbtnNewRadioButton.isSelected())
					y="one way";
				if(rdbtnNewRadioButton_1.isSelected())
					y="round trip";
				AvaliablePanel.setVisible(true);
				CustomersPanel.setVisible(false);
				int f=0;
				for(int i=0;i<nT;i++)
				{
				if(t[i].getDest().compareTo(x) == 0 && t[i].getTypes().compareTo(y)==0)
					{f=1;
					textArea.append(t[i].getDest()+" "+t[i].getTypes()+" "+t[i].getDate()+" "+Trips.price.get(t[i].getDest())+"'EGP"+"    Trip NO#"+ i+"\n");
					}
				}
              if(f==0)
            	  textArea.append("SORRY NO TRIPS MATCH YOUR INPUT CHECK AGAIN SOON!");
              btnBook.setEnabled(false);
				}
				catch(Exception E)
				   {
					   JOptionPane.showMessageDialog(null,"Error in input");
				   }
			}
		});
		
		
		btnNewButton.setBounds(388, 424, 260, 25);
		CustomersPanel.add(btnNewButton);
		
		JLabel lblCustomerLastName = new JLabel("Customer last name");
		lblCustomerLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerLastName.setBounds(111, 134, 188, 55);
		CustomersPanel.add(lblCustomerLastName);
		
		textField_5 = new JTextField();
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setColumns(10);
		textField_5.setBounds(271, 150, 354, 22);
		CustomersPanel.add(textField_5);
		
		JLabel lblTripVehicle = new JLabel("Trip Vehicle");
		lblTripVehicle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTripVehicle.setBounds(216, 352, 133, 36);
		CustomersPanel.add(lblTripVehicle);
		
		
		CustomersPanel.add(comboBox_6);
		
		JButton BtnBack = new JButton("Back");
		BtnBack.setBackground(Color.LIGHT_GRAY);
		BtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomersPanel.setVisible(false);
				Menu.setVisible(true);
			}
		});
		BtnBack.setBounds(264, 424, 97, 25);
		CustomersPanel.add(BtnBack);
		CustomersPanel.setVisible(false);
		
		 JPanel ManagersPanel = new JPanel();
		 ManagersPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(ManagersPanel, "name_182538532307754");
		ManagersPanel.setLayout(null);
		
		JLabel lblManagerSection = new JLabel("Manager Section");
		lblManagerSection.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblManagerSection.setBounds(368, 26, 214, 44);
		ManagersPanel.add(lblManagerSection);
		
		JButton btnNewButton_1 = new JButton("Add Trip");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTrip.setVisible(true);
				ManagersPanel.setVisible(false);
		
			}
		});
		btnNewButton_1.setBounds(235, 138, 147, 44);
		ManagersPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Price");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PricePanel.setVisible(true);
				ManagersPanel.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(235, 204, 147, 44);
		ManagersPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Vehicle");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(450, 138, 158, 47);
		ManagersPanel.add(btnNewButton_3);
		
		JButton btnAddDriver = new JButton("Add Driver");
		btnAddDriver.setBackground(Color.LIGHT_GRAY);
		btnAddDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverPanel.setVisible(true);
				ManagersPanel.setVisible(false);
			}
		});
		btnAddDriver.setBounds(450, 204, 158, 44);
		ManagersPanel.add(btnAddDriver);
		
		JButton btnNewButton_6 = new JButton("Save Changes");
		btnNewButton_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nT=rt.savings(t,nT);
				JOptionPane.showMessageDialog(null, "Saved!");
			}
		});
		btnNewButton_6.setBounds(316, 287, 199, 56);
		ManagersPanel.add(btnNewButton_6);
		
		JButton btnManagerBack_7 = new JButton("Back");
		btnManagerBack_7.setBackground(Color.LIGHT_GRAY);
		btnManagerBack_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagersPanel.setVisible(false);
				Menu.setVisible(true);
			}
		});
		btnManagerBack_7.setBounds(368, 366, 95, 44);
		ManagersPanel.add(btnManagerBack_7);
	    ManagersPanel.setVisible(false);
		
		JButton btnNew1 = new JButton("Customer");
		btnNew1.setBackground(Color.LIGHT_GRAY);
		btnNew1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomersPanel.setVisible(true);
				Menu.setVisible(false);
			}
		});
		btnNew1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNew1.setBounds(480, 215, 216, 68);
		Menu.add(btnNew1);
		JButton btnNew2 = new JButton("Manager");
		btnNew2.setBackground(Color.LIGHT_GRAY);
		btnNew2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AddTrip.setVisible(true);
				ManagersPanel.setVisible(true);
				Menu.setVisible(false);
			}
		});
		btnNew2.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNew2.setBounds(146, 215, 216, 68);
		Menu.add(btnNew2);
		
		JLabel lblNewLabel = new JLabel("Bus station system");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("BankGothic Lt BT", Font.BOLD, 28));
		lblNewLabel.setBounds(267, 24, 373, 68);
		Menu.add(lblNewLabel);
	
		
		
	}
}
