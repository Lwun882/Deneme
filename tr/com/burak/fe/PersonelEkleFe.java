package tr.com.burak.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.burak.dal.PersonelDAL;
import tr.com.burak.interfaces.FeInterfaces;
import tr.com.burak.types.PersonelContract;

public class PersonelEkleFe extends JDialog implements FeInterfaces{
	
	
	public PersonelEkleFe(){
		
		initPencere();
		
		
		
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		
		add(panel);
		
		
		
		setTitle("Personel Ekle");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		
		
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		panel.setBorder(BorderFactory.createTitledBorder("Personel Ekle"));
		JLabel adiSoyadiLabel = new JLabel("Adý Soyadý:",JLabel.RIGHT);
		panel.add(adiSoyadiLabel);
		JTextField adiSoyadiField = new JTextField(10);
		panel.add(adiSoyadiField);
		JLabel emailLabel = new JLabel("Email:",JLabel.RIGHT);
		panel.add(emailLabel);
		JTextField emailField = new JTextField(10);
		panel.add(emailField);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal Et");
		panel.add(iptalButton);
		
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract = new PersonelContract();
				contract.setAdiSoyadi(adiSoyadiField.getText());
				contract.setEmail(emailField.getText());
				new PersonelDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+" adlý personel eklenmiþtir");
				
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
