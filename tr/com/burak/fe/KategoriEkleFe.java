package tr.com.burak.fe;

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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.burak.dal.KategoriDAL;
import tr.com.burak.interfaces.FeInterfaces;
import tr.com.burak.types.KategoriContract;

public class KategoriEkleFe extends JDialog implements FeInterfaces{

	public KategoriEkleFe(){
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
		
		add(panel);
		setTitle("Kategori Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		
		
		JLabel adiLabel = new JLabel("Kategori Adý:",JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(15);
		panel.add(adiField);
		JLabel kategoriLabel = new JLabel("Kategori Seç:",JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoribox = new JComboBox(new KategoriDAL().GetAllParentId().toArray());
		panel.add(kategoribox);
		kategoribox.insertItemAt("--KategoriSeçiniz--", 0);
		kategoribox.setSelectedIndex(0);

		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KategoriContract contract = new KategoriContract();
			
				if(kategoribox.getSelectedIndex()!=0){
					KategoriContract casContract = (KategoriContract) kategoribox.getSelectedItem(); 
					
					contract.setAdi(adiField.getText());
					contract.setParentId(casContract.getId());
					
					
					new KategoriDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, contract.getAdi()+ " adlý Kategori Kayýt Baþarýlý þekilde eklenmiþitir.");
					
			
				}else{
					contract.setAdi(adiField.getText());
					contract.setParentId(kategoribox.getSelectedIndex());
					
					
					new KategoriDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, contract.getAdi()+ " adlý Kategori Kayýt Baþarýlý þekilde eklenmiþitir.");
					kategoribox.addItem(new KategoriDAL().GetAllParentId());
					
				}
			
				
		}
			
			});
	
		JButton iptal = new JButton("Ýptal et");
		panel.add(iptal);
		
		
		
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
