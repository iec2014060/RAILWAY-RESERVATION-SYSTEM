package railway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Signup1 extends JPanel {
	private JTextField usertextField;
	private JPasswordField userpasswordField;
	Connection con;
	Statement st = null;
	ResultSet rs;

	/**
	 * Create the panel.
	 */
	public Signup1() {
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
		setLayout(null);
		
		JLabel userNewLabel = new JLabel("username");
		userNewLabel.setBounds(118, 99, 69, 14);
		add(userNewLabel);
		
		usertextField = new JTextField();
		usertextField.setBounds(220, 96, 86, 20);
		add(usertextField);
		usertextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setBounds(118, 143, 58, 14);
		add(lblNewLabel);
		
		userpasswordField = new JPasswordField();
		userpasswordField.setBounds(220, 140, 98, 20);
		add(userpasswordField);
		
		JButton addNewButton = new JButton("Add");
		addNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String usr = usertextField.getText();
					String pass = new String(userpasswordField.getPassword());
					String adf= "insert into user1 values ('"+usr+"',"+"'"+pass+"')";
					st.executeUpdate(adf);
					JOptionPane.showMessageDialog(null, "WELCOME");
			}
				catch (SQLException d) {
					// TODO Auto-generated catch block
					d.printStackTrace();
				}
			}
		});
		addNewButton.setBounds(186, 202, 89, 23);
		add(addNewButton);

	}

}
