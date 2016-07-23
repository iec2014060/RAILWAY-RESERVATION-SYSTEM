package railway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class addpackage extends JPanel {
	private JTextField packagetextField;
	private JTextField avaltextField;
	Connection con;
	Statement st = null;
	ResultSet rs;
	/**
	 * Create the panel.
	 */
	public addpackage() {
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
		
		JLabel pnameNewLabel = new JLabel("package name");
		pnameNewLabel.setBounds(102, 83, 86, 14);
		add(pnameNewLabel);
		
		packagetextField = new JTextField();
		packagetextField.setBounds(222, 80, 119, 20);
		add(packagetextField);
		packagetextField.setColumns(10);
		
		JLabel avalablelblNewLabel = new JLabel("avalability");
		avalablelblNewLabel.setBounds(113, 134, 55, 14);
		add(avalablelblNewLabel);
		
		avaltextField = new JTextField();
		avaltextField.setBounds(223, 131, 119, 20);
		add(avaltextField);
		avaltextField.setColumns(10);
		
		JButton addNewButton = new JButton("ADD");
		addNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String us = packagetextField.getText();
					String pa = avaltextField.getText();
					String ad= "insert into packages values ('"+us+"',"+"'"+pa+"')";
					st.executeUpdate(ad);
					JOptionPane.showMessageDialog(null, "INSERTED");
			}
				catch (SQLException d) {
					// TODO Auto-generated catch block
					d.printStackTrace();
				}
			}
		});
		addNewButton.setBounds(165, 195, 89, 23);
		add(addNewButton);

	}

}
