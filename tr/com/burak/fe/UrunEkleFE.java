package tr.com.burak.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
















import com.toedter.calendar.JDateChooser;

import tr.com.burak.dal.KategoriDAL;
import tr.com.burak.dal.UrunlerDAL;
import tr.com.burak.interfaces.FeInterfaces;
import tr.com.burak.types.KategoriContract;
import tr.com.burak.types.UrunlerContract;

public class UrunEkleFE extends JDialog implements FeInterfaces{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UrunEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("�r�n Kay�t Alan�"));
		add(panel);
		setTitle("�r�n Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));
		JLabel adiLabel = new JLabel("Ad�:",JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField2 = new JTextField(10);
		panel.add(adiField2);
		JLabel kategoriLabel = new JLabel("Kategori Se�:",JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new KategoriDAL().GetAll().toArray());
		panel.add(kategoriBox);
		JLabel tarihLabel = new JLabel("Tarih Se�:",JLabel.RIGHT);
		panel.add(tarihLabel);
		JDateChooser tarihDate = new JDateChooser();
		panel.add(tarihDate);
		
		JLabel fiyatLabel = new JLabel("Fiyat Gir:",JLabel.RIGHT);
		panel.add(fiyatLabel);
		JTextField fiyatField = new JTextField(10);
		panel.add(fiyatField);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptal = new JButton("�ptal et");
		panel.add(iptal);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				UrunlerContract contract = new UrunlerContract();
				KategoriContract casContract = (KategoriContract)kategoriBox.getSelectedItem();
				
				String date =  new SimpleDateFormat("yyyy-MM-dd").format(tarihDate.getDate());
//				new SimpleDateFormat("yyyy-MM-dd").format(myDate));
//				String date = format.format(tarihDate.getDate());
				
				
				contract.setAdi(adiField2.getText());
				contract.setKategoriId(casContract.getId());
				contract.setTarih(date);
				contract.setFiyat(Float.parseFloat(fiyatField.getText()));
				
				new UrunlerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+" adl� �r�n Ba�ar�yla eklenmi�tir.");
				
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
