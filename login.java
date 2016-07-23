package railway;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class login extends JFrame {
	private JPanel contentPane;
	private JTextField usernametextField;
	private JPasswordField passwordField;
	Connection con;
	Statement st = null;
	ResultSet rs;
	JCheckBox adminCheckBox;
	static Signup1  ui = new Signup1(); 
	static addpackage vi = new addpackage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st=con.createStatement();
			System.out.println("Connected");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		ui.setBounds(0, 0,1220, 650);
		getContentPane().add(ui,BorderLayout.CENTER);
		ui.setLayout(null);
		ui.setVisible(false);
		vi.setBounds(0, 0,1220, 650);
		getContentPane().add(vi,BorderLayout.CENTER);
		vi.setLayout(null);
		vi.setVisible(false);
		
		//int ct=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("username");
		userLabel.setBounds(116, 84, 68, 14);
		contentPane.add(userLabel);
		JButton signupButton = new JButton("signup");
		
		usernametextField = new JTextField();
		usernametextField.setBounds(229, 81, 86, 20);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);
		
		JLabel passwordlblNewLabel = new JLabel("password");
		passwordlblNewLabel.setBounds(115, 129, 46, 14);
		contentPane.add(passwordlblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 129, 91, 20);
		contentPane.add(passwordField);
		
JCheckBox adminCheckBox = new JCheckBox("admin");
		
		adminCheckBox.setBounds(41, 23, 97, 23);
		contentPane.add(adminCheckBox);
		
		JButton okButton = new JButton("ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						//String s = rs.getString("usr_name");
					//	String p = rs.getString("pass_word");
						String usr = usernametextField.getText();
						String pass = new String(passwordField.getPassword());
						if(adminCheckBox.isSelected())
						{
							try {
								int ct=0;
								rs = st.executeQuery("select * from admin1");
							while(rs.next())
							{
								String s = rs.getString("usr_name");
								String p = rs.getString("pass_word");
								//System.out.println(s);
								//int ct=0;
								if(s.equals(usr) && p.equals(pass))
								{
									JOptionPane.showMessageDialog(null, "welcome");
									//Home.loggedinadmin = s;
									//new AdminHome();
									
									// write
									//JOptionPane.showMessageDialog(null, "yes");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "invalid");
									ct=ct+1;
									
								}
							
							}
							if(ct==0)
							{
							vi.setBounds(0, 0,1220, 650);
							getContentPane().add(vi,BorderLayout.CENTER);
							vi.setLayout(null);
							vi.setVisible(true);
							usernametextField.setVisible(false);
							passwordlblNewLabel.setVisible(false);
							okButton.setVisible(false);
							userLabel.setVisible(false);
							passwordField.setVisible(false);
							adminCheckBox.setVisible(false);
							signupButton.setVisible(false);
							}
							}
							catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
							}
						else
						{
							try {
								rs = st.executeQuery("select * from user1");
							while(rs.next())
							{
								String s = rs.getString("usr_name");
								String p = rs.getString("pass_word");
								System.out.println(s);
								if(s.equals(usr) && p.equals(pass))
								{
									//JOptionPane.showMessageDialog(null, "welcome");
									//Home.loggedinadmin = s;
									//new AdminHome();
									
									// write
									JOptionPane.showMessageDialog(null, "yes");
								}
							
							} 
							}
							catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
						}
			}
			//}
		});
		
		okButton.setBounds(174, 174, 89, 23);
		contentPane.add(okButton);
		
		
		//JButton signupButton = new JButton("signup");
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ui.setBounds(0, 0,1220, 650);
				getContentPane().add(ui,BorderLayout.CENTER);
				ui.setLayout(null);
				ui.setVisible(true);
				usernametextField.setVisible(false);
				passwordlblNewLabel.setVisible(false);
				okButton.setVisible(false);
				userLabel.setVisible(false);
				passwordField.setVisible(false);
				adminCheckBox.setVisible(false);
				signupButton.setVisible(false);
			}
		});
		signupButton.setBounds(293, 174, 89, 23);
		contentPane.add(signupButton);
		}
}
