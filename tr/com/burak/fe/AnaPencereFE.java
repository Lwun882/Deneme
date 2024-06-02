package tr.com.burak.fe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import tr.com.burak.Utilities.Menuler;
import tr.com.burak.complex.types.PersonelContractComplex;
import tr.com.burak.complex.types.SatisContractComplex;
import tr.com.burak.complex.types.StokContractComplex;
import tr.com.burak.complex.types.StokContractTotalComplex;
import tr.com.burak.dal.AccountsDAL;
import tr.com.burak.dal.MusteriDAL;
import tr.com.burak.dal.SatisDAL;
import tr.com.burak.dal.SehirDAL;
import tr.com.burak.dal.StokDAL;
import tr.com.burak.dal.UrunlerDAL;
import tr.com.burak.interfaces.FeInterfaces;
import tr.com.burak.types.MusteriContract;
import tr.com.burak.types.PersonelContract;
import tr.com.burak.types.SatisContract;
import tr.com.burak.types.StockContract;
import tr.com.burak.types.UrunlerContract;

public class AnaPencereFE extends JFrame implements FeInterfaces{

	public AnaPencereFE(){
		initPencere();
	}
	
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		JTabbedPane tabs = initTabs();
		JMenuBar bar = initBar();
		
		add(panel);
		setJMenuBar(bar);
		setTitle("Sat�� ve Stok Program�" );
		setSize(600, 250);
//		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JTabbedPane pane = initTabs();
		panel.add(pane,BorderLayout.CENTER);
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		JMenuBar bar = Menuler.initBar();
		return bar;
	}

	@Override
	public JTabbedPane initTabs() {
		JTabbedPane pane = new JTabbedPane();
		
		pane.setBackground(new Color(175, 238, 238));
		pane.setForeground(Color.DARK_GRAY);
		
		JPanel stokPanel = new JPanel(new BorderLayout());
		JPanel satisPanel = new JPanel(new BorderLayout());
	
		JPanel personelPanel = new JPanel(new BorderLayout());
		
//		personel paneli
		
//		personelPanel.setBorder(BorderFactory.createTitledBorder("Personel Bilgileri"));
//		JLabel personelLabel = new JLabel("Personel Bilgileri");
//		personelPanel.add(personelLabel);
//		JTextField perField = new JTextField(10);
//		personelPanel.add(perField);
//		perField.setEditable(false);
//		personelPanel.setVisible(true);
//		JButton pGoster = new JButton("Personel Bilgileri G�ster");
//		personelPanel.add(pGoster);
//	
//		pGoster.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new LoginFe();
//				PersonelContract perscontract = (PersonelContract) LoginFe.emailBox.getSelectedItem();
//				stokPanel.setVisible(new AccountsDAL().GetYetkiId(perscontract.getId()).getYetkiId()==2||new AccountsDAL().GetYetkiId(perscontract.getId()).getYetkiId()==1||new AccountsDAL().GetYetkiId(perscontract.getId()).getYetkiId()==3);
//				satisPanel.setVisible(new AccountsDAL().GetYetkiId(perscontract.getId()).getYetkiId()==2||new AccountsDAL().GetYetkiId(perscontract.getId()).getYetkiId()==1||new AccountsDAL().GetYetkiId(perscontract.getId()).getYetkiId()==3);
//				
//				
//			}
//		});
//		pGoster.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				int satir = personelModel.getRowCount();
//				for (int i = 0; i < satir; i++) {
//					
//					personelModel.removeRow(0);
//					
//				}
//				for(PersonelContractComplex personelDeg : new StokDAL().GetTotalStok()){
//					
//					personelModel.addRow(total.getVeriler());
//				}
//				
//				
//			}
//		});
		
		
		
		
//		Stok �temleri
		JPanel stokSolPanel = new JPanel(new BorderLayout());
		JPanel stokSolUstPanel = new JPanel(new GridLayout(5,2));
		JPanel stokSolAltPanel = new JPanel();
		
		stokSolPanel.setBorder(BorderFactory.createTitledBorder("Stok ��lemleri"));
		String[] stokKolonlar = {"Id","Personel Ad�","�r�n Ad�","Tarihi","Adet","Toplam"};
		DefaultTableModel model = new DefaultTableModel(stokKolonlar,0);
		JTable table = new JTable(model);
		JScrollPane stokTablePane = new JScrollPane(table);
		table.setBackground(Color.ORANGE);
		
		for(StokContractComplex contract : new StokDAL().GetAllStok()){
			model.addRow(contract.getVeriler());
		}
		JLabel stokUrunAdiLabel = new JLabel("�r�n Ad�:",JLabel.RIGHT);
		stokSolUstPanel.add(stokUrunAdiLabel);
		JComboBox stokUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		stokSolUstPanel.add(stokUrunAdiBox);
		stokUrunAdiBox.insertItemAt("--�r�n Se�iniz--", 0);
		stokUrunAdiBox.setSelectedIndex(0);
		JLabel stokAdetLabel = new JLabel("Adet:",JLabel.RIGHT);
		stokSolUstPanel.add(stokAdetLabel);
		JTextField stokAdiField = new JTextField(10);
		stokSolUstPanel.add(stokAdiField);
		stokAdiField.setBackground(new Color(175, 238, 238));
		JLabel stokTarihiLabel = new JLabel("Stok Tarihi:",JLabel.RIGHT);
		stokSolUstPanel.add(stokTarihiLabel);
		JDateChooser stokTarihi = new JDateChooser();
		stokSolUstPanel.add(stokTarihi);
		
		
		JButton stokEkleButton = new JButton("Stok Ekle");
		stokSolUstPanel.add(stokEkleButton);
		JButton stokYenileButton = new JButton("Yenile");
		stokSolUstPanel.add(stokYenileButton);
		JButton stokTotalButton = new JButton("Stok Toplam �r�n");
		stokSolUstPanel.add(stokTotalButton);
		
		stokTotalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {
					
					model.removeRow(0);
					
				}
				for(StokContractTotalComplex total : new StokDAL().GetTotalStok()){
					
					model.addRow(total.getVeriler());
				}
				
			}
		});
		
		
		
		stokYenileButton.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {
					
					model.removeRow(0);
					
				}
//				JOptionPane.showMessageDialog(null, "Temizlendi");
				for(StokContractComplex compContract : new StokDAL().GetAllStok()){
					model.addRow(compContract.getVeriler());
				}
			
				
			}
		});
		
		stokEkleButton.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				try {
				StockContract contract = new StockContract();
				UrunlerContract uContract = (UrunlerContract) stokUrunAdiBox.getSelectedItem();
				PersonelContract pContract = (PersonelContract) LoginFe.emailBox.getSelectedItem();
				
				String date =  new SimpleDateFormat("yyyy-MM-dd").format(stokTarihi.getDate());
				
					contract.setPersonelId(pContract.getId());
					contract.setUrunId(uContract.getId());
					contract.setTarih(date);
					contract.setAdet(Integer.parseInt(stokAdiField.getText()));
					
					new StokDAL().Insert(contract);
					
					JOptionPane.showMessageDialog(null, uContract.getAdi()+" adl� �r�n ba�ar�yla eklenmi�itir.");
			
					int satir = model.getRowCount();
					for (int i = 0; i < satir; i++) {
						
						model.removeRow(0);
						
					}
//					JOptionPane.showMessageDialog(null, "Temizlendi");
					for(StokContractComplex compContract : new StokDAL().GetAllStok()){
						model.addRow(compContract.getVeriler());
					}
					
//				} catch (NullPointerException e2) {
//
//					throw e2;
//					
//				}
				
			
			
			
			}
		});
		
		
		
		
		//		Sat�� �temleri
		JPanel satisSa�Panel = new JPanel(new BorderLayout());
		JPanel satisSa�UstPanel = new JPanel(new GridLayout(5,2));
		JPanel satisSa�AltPanel = new JPanel();
		satisSa�Panel.setBorder(BorderFactory.createTitledBorder("Sat�� ��lemleri"));
		
		String[] satisKolonlar = {"Id","M��teri Ad�","Personel Ad�","�r�n Ad�","Adet","Tarihi"};
		DefaultTableModel satismodel = new DefaultTableModel(satisKolonlar,0);
		JTable satistable = new JTable(satismodel);
		satistable.setBackground(Color.green);
		JScrollPane satisTablePane = new JScrollPane(satistable);
		JLabel musteriLabel = new JLabel("M��teri Ad�:",JLabel.RIGHT);
		satisSa�UstPanel.add(musteriLabel);
		JComboBox musteriComboBox = new JComboBox(new MusteriDAL().GetAll().toArray());
		satisSa�UstPanel.add(musteriComboBox);
		musteriComboBox.insertItemAt("--M��teri Se�iniz--", 0);
		musteriComboBox.setSelectedIndex(0);
		JLabel satisUrunAdiLabel = new JLabel("�r�n Ad�:",JLabel.RIGHT);
		satisSa�UstPanel.add(satisUrunAdiLabel);
	
		JComboBox satisUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		satisSa�UstPanel.add(satisUrunAdiBox);
		satisUrunAdiBox.insertItemAt("--�r�n Se�iniz--", 0);
		satisUrunAdiBox.setSelectedIndex(0);
		JLabel satisAdetLabel = new JLabel("Adet:",JLabel.RIGHT);
		satisSa�UstPanel.add(satisAdetLabel);
		JTextField satisAdetField = new JTextField(10);
		satisSa�UstPanel.add(satisAdetField);
		satisAdetField.setBackground(new Color(175, 238, 238));
		JLabel satisTarihiLabel = new JLabel("Sat�� Tarihi:",JLabel.RIGHT);
		satisSa�UstPanel.add(satisTarihiLabel);
		JDateChooser satisTarihi = new JDateChooser();
		satisSa�UstPanel.add(satisTarihi);
		
	
		
		JButton satisEkleButton = new JButton("Sat�� Yap");
		satisSa�UstPanel.add(satisEkleButton);
		
		for(SatisContractComplex contract : new SatisDAL().GetAllSatis()){
			
			satismodel.addRow(contract.getVeriler());
		}
		
		satisEkleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//			try {
				PersonelContract pContract = (PersonelContract) LoginFe.emailBox.getSelectedItem();
				UrunlerContract uContract = (UrunlerContract) satisUrunAdiBox.getSelectedItem();
				MusteriContract mContract = (MusteriContract) musteriComboBox.getSelectedItem();
				SatisContract contract = new SatisContract();
				String date =  new SimpleDateFormat("yyyy-MM-dd").format(satisTarihi.getDate());

				contract.setMusteriId(mContract.getId());
				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setAdet(Integer.parseInt(satisAdetField.getText()));
				contract.setTarih(date);
				
				new SatisDAL().Insert(contract);
				StockContract stockContract = new StockContract();
				stockContract.setPersonelId(pContract.getId());
				stockContract.setUrunId(uContract.getId());
				stockContract.setAdet(-Integer.parseInt(satisAdetField.getText()));
				stockContract.setTarih(date);
				
				new StokDAL().Insert(stockContract);
				
				JOptionPane.showMessageDialog(null, mContract.getAdiSoyadi() + " �simli m��teriye sat�� ger�ekle�mi�tir ve " +uContract.getAdi()+" Adli �r�nden stokta " + contract.getAdet()+" adet eksiltilmi�tir.");
				int satir = satismodel.getRowCount();
				
				for (int i = 0; i < satir; i++) {
					
					satismodel.removeRow(0);
					
				}
				for(SatisContractComplex yenileContract : new SatisDAL().GetAllSatis()){
					
					satismodel.addRow(yenileContract.getVeriler());
				}
				
//			} catch (NullPointerException e2) {
//				throw e2;
//			}
				
				
				
				
			}
		});
		JButton satisYenileButton = new JButton("Yenile");
		satisSa�UstPanel.add(satisYenileButton);
		satisYenileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int satir = satismodel.getRowCount();
				for (int i = 0; i < satir; i++) {
					
					satismodel.removeRow(0);
					
				}
		for(SatisContractComplex contract : new SatisDAL().GetAllSatis()){
					
					satismodel.addRow(contract.getVeriler());
				}
				
			}
		});
		stokPanel.add(stokSolPanel,BorderLayout.WEST);
		stokPanel.add(stokTablePane,BorderLayout.CENTER);
		
		satisPanel.add(satisSa�Panel,BorderLayout.WEST);
		satisPanel.add(satisTablePane,BorderLayout.CENTER);
		
		satisSa�Panel.add(satisSa�UstPanel,BorderLayout.NORTH);
		satisSa�Panel.add(satisSa�AltPanel,BorderLayout.SOUTH);
		
		stokSolPanel.add(stokSolUstPanel,BorderLayout.NORTH);
		stokSolPanel.add(stokSolAltPanel,BorderLayout.SOUTH);
		
		
		
		pane.addTab("Stoklar",null,stokPanel,"Stok Bilgileri G�r�nt�leme");
		pane.addTab("Sat��lar",null,satisPanel, "Sat�� Bilgileri G�r�nt�leme");
		pane.addTab("Personel Bilgileri",null ,personelPanel,"Personel bilgileri g�r�nt�leme" );
		
		return pane;
	}
	

}
