package tr.com.burak.fe;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.ws.soap.AddressingFeature;

import tr.com.burak.dal.MusteriDAL;
import tr.com.burak.dal.PersonelDAL;
import tr.com.burak.dal.SehirDAL;
import tr.com.burak.interfaces.FeInterfaces;
import tr.com.burak.types.AccountsContract;
import tr.com.burak.types.MusteriContract;
import tr.com.burak.types.PersonelContract;
import tr.com.burak.types.SehirlerContract;
import tr.com.burak.types.YetkilerContract;

public class MusteriEkleFe extends JDialog implements FeInterfaces {

	public MusteriEkleFe() {
initPencere();
}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Müsteri Ekle"));
		
		add(panel);
		setTitle("Müsteri Ekle");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		
		
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout() );
		JPanel fieldPanel = new JPanel(new GridLayout(5,2));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		JLabel adiSoyadiLabel= new JLabel("Adý Soyadý:",JLabel.RIGHT);
		fieldPanel.add(adiSoyadiLabel);
		JTextField adiSoyadiField = new JTextField(10);
		fieldPanel.add(adiSoyadiField);
		JLabel telefonLabel = new JLabel("Telefon:",JLabel.RIGHT);
		fieldPanel.add(telefonLabel);
		JTextField telefonField = new JTextField(10);
		fieldPanel.add(telefonField);
		JLabel sehirSecLabel = new JLabel("Þehir Seç:",JLabel.RIGHT);
		fieldPanel.add(sehirSecLabel);
		
		JComboBox sehirlerBox = new JComboBox(new SehirDAL().GetAll().toArray());
		fieldPanel.add(sehirlerBox);
		sehirlerBox.insertItemAt("--Þehir Seçiniz--", 0);
		sehirlerBox.setSelectedIndex(0);
		JLabel adresLabel = new JLabel("Adres");
		fieldPanel.add(adresLabel);
//		JTextField adresField = new JTextField();
//		fieldPanel.add(adresField);
	
		
		
		JTextArea adresArea = new JTextArea(7,2);
		JScrollPane pane = new JScrollPane(adresArea);
		pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));
		JButton kaydetButton = new JButton("Kaydet");
		buttonPanel.add(kaydetButton);
		JButton iptal = new JButton("Ýptal et");
		buttonPanel.add(iptal);
		
		panel.add(fieldPanel,BorderLayout.NORTH);
		panel.add(pane,BorderLayout.CENTER);
		panel.add(buttonPanel,BorderLayout.SOUTH);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				MusteriContract contract = new MusteriContract();
				
				SehirlerContract sContract = (SehirlerContract) sehirlerBox.getSelectedItem();
				
				
//				AccountsContract contract = new AccountsContract();
//				PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
//				YetkilerContract yContract = (YetkilerContract) yetkiBox.getSelectedItem();
//				contract.setParentId(kategoribox.getSelectedIndex());
				contract.setAdiSoyadi(adiSoyadiField.getText());
				contract.setAdres(adresArea.getText());
				contract.setTelefon(telefonField.getText());
				contract.setSehirId(sehirlerBox.getSelectedIndex());
				new MusteriDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+ " Müþterisi Kayýt Baþarýlý");
				
			}
		});
			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PersonelContract contract = new PersonelContract();
//				contract.setAdiSoyadi(adiSoyadiField.getText());
//				contract.setEmail(emailField.getText());
//				new PersonelDAL().Insert(contract);
//				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+" adlý personel eklenmiþtir");
//				
//			}
//		});
		
		
		
		
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
