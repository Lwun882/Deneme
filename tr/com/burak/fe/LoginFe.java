package tr.com.burak.fe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.burak.dal.AccountsDAL;
import tr.com.burak.dal.PersonelDAL;
import tr.com.burak.interfaces.FeInterfaces;
import tr.com.burak.types.PersonelContract;

public class LoginFe extends JDialog implements FeInterfaces {

	public static JComboBox emailBox;
	public LoginFe() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("L�tfen sisteme giri� i�in bilgilerinizi giriniz."));
		add(panel);
		setTitle("Giri� Yap�n�z");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		
		
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(3,2));
		JLabel emailLabel = new JLabel("Personel: ",JLabel.RIGHT);
		panel.add(emailLabel);
		emailBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(emailBox);
		emailBox.insertItemAt("--Personel Se�iniz--", 0);
		emailBox.setSelectedIndex(0);
		JLabel password = new JLabel("�ifreniz:",JLabel.RIGHT);
		panel.add(password);
		JPasswordField passwordField = new JPasswordField(15);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Giri� Yap");
		panel.add(loginButton);
//		loginButton.add(comp)
		JButton iptalButton = new JButton("�ptal Et");
		panel.add(iptalButton);
		
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
				String sifre = passwordField.getText();
				if(new AccountsDAL().GetPersonelIdVeSifre(contract.getId(), sifre).getId()!=0){
					
					new AnaPencereFE();
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Giri� Ba�ar�s�z");
				}
				
				// TODO Auto-generated method stub
				
			}
		});
		
		
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
