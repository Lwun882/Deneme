package tr.com.burak.fe;

import java.awt.GridBagLayout;
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

import tr.com.burak.dal.AccountsDAL;
import tr.com.burak.dal.PersonelDAL;
import tr.com.burak.dal.YetkilerDAL;
import tr.com.burak.interfaces.FeInterfaces;
import tr.com.burak.types.AccountsContract;
import tr.com.burak.types.PersonelContract;
import tr.com.burak.types.YetkilerContract;

public class SifreIslemleriFE  extends JDialog implements FeInterfaces{

	public SifreIslemleriFE() {

		initPencere();
	
	
	
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("�ifre Belirleme i�lemleri"));
		
		
		add(panel);
		setTitle("�ifre belirleme ��lemleri");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5,2));
		JLabel personelLabel = new JLabel("Personel Se�:",JLabel.RIGHT);
		panel.add(personelLabel);
		JComboBox personelBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(personelBox);
		personelBox.insertItemAt("--Personeli Se�iniz--", 0);
		personelBox.setSelectedIndex(0);
		JLabel yetkiLabel = new JLabel("Yetki Se�:",JLabel.RIGHT);
		panel.add(yetkiLabel);
		JComboBox yetkiBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
		panel.add(yetkiBox);
		yetkiBox.insertItemAt("--Yetki Se�iniz--", 0);
		yetkiBox.setSelectedIndex(0);
		JLabel passwordLabel = new JLabel("�ifre Belirle",JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passField = new JPasswordField(10);
		panel.add(passField);
		JLabel passTekrarLabel = new JLabel("�ifre Tekrar:",JLabel.RIGHT);
		panel.add(passTekrarLabel);
		JPasswordField passTekrar = new JPasswordField(10);
		panel.add(passTekrar);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptal = new JButton("�ptal et");
		panel.add(iptal);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				AccountsContract contract = new AccountsContract();
				PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
				YetkilerContract yContract = (YetkilerContract) yetkiBox.getSelectedItem();
				
				
				if(passField.getText().equals(passTekrar.getText())){
					
					contract.setPersonelId(pContract.getId());
					contract.setYetkiId(yContract.getId());
					contract.setSifre(passField.getText());
					
					
					
					new AccountsDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, pContract.getAdiSoyadi()+" Adl� ki�iye "+ yContract.getAdi()+" Yetkisi Ba�ar�l� Bir �ekilde eklenmi�tir.");

				}else
					JOptionPane.showMessageDialog(null, "�ifreler Uyuymuyor tekrar kontrol edin.");
				
				
				
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
