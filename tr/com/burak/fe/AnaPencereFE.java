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
		setTitle("Satýþ ve Stok Programý" );
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
//		JButton pGoster = new JButton("Personel Bilgileri Göster");
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
		
		
		
		
//		Stok Ýtemleri
		JPanel stokSolPanel = new JPanel(new BorderLayout());
		JPanel stokSolUstPanel = new JPanel(new GridLayout(5,2));
		JPanel stokSolAltPanel = new JPanel();
		
		stokSolPanel.setBorder(BorderFactory.createTitledBorder("Stok Ýþlemleri"));
		String[] stokKolonlar = {"Id","Personel Adý","Ürün Adý","Tarihi","Adet","Toplam"};
		DefaultTableModel model = new DefaultTableModel(stokKolonlar,0);
		JTable table = new JTable(model);
		JScrollPane stokTablePane = new JScrollPane(table);
		table.setBackground(Color.ORANGE);
		
		for(StokContractComplex contract : new StokDAL().GetAllStok()){
			model.addRow(contract.getVeriler());
		}
		JLabel stokUrunAdiLabel = new JLabel("Ürün Adý:",JLabel.RIGHT);
		stokSolUstPanel.add(stokUrunAdiLabel);
		JComboBox stokUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		stokSolUstPanel.add(stokUrunAdiBox);
		stokUrunAdiBox.insertItemAt("--Ürün Seçiniz--", 0);
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
		JButton stokTotalButton = new JButton("Stok Toplam Ürün");
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
					
					JOptionPane.showMessageDialog(null, uContract.getAdi()+" adlý ürün baþarýyla eklenmiþitir.");
			
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
		
		
		
		
		//		Satýþ Ýtemleri
		JPanel satisSaðPanel = new JPanel(new BorderLayout());
		JPanel satisSaðUstPanel = new JPanel(new GridLayout(5,2));
		JPanel satisSaðAltPanel = new JPanel();
		satisSaðPanel.setBorder(BorderFactory.createTitledBorder("Satýþ Ýþlemleri"));
		
		String[] satisKolonlar = {"Id","Müþteri Adý","Personel Adý","Ürün Adý","Adet","Tarihi"};
		DefaultTableModel satismodel = new DefaultTableModel(satisKolonlar,0);
		JTable satistable = new JTable(satismodel);
		satistable.setBackground(Color.green);
		JScrollPane satisTablePane = new JScrollPane(satistable);
		JLabel musteriLabel = new JLabel("Müþteri Adý:",JLabel.RIGHT);
		satisSaðUstPanel.add(musteriLabel);
		JComboBox musteriComboBox = new JComboBox(new MusteriDAL().GetAll().toArray());
		satisSaðUstPanel.add(musteriComboBox);
		musteriComboBox.insertItemAt("--Müþteri Seçiniz--", 0);
		musteriComboBox.setSelectedIndex(0);
		JLabel satisUrunAdiLabel = new JLabel("Ürün Adý:",JLabel.RIGHT);
		satisSaðUstPanel.add(satisUrunAdiLabel);
	
		JComboBox satisUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		satisSaðUstPanel.add(satisUrunAdiBox);
		satisUrunAdiBox.insertItemAt("--Ürün Seçiniz--", 0);
		satisUrunAdiBox.setSelectedIndex(0);
		JLabel satisAdetLabel = new JLabel("Adet:",JLabel.RIGHT);
		satisSaðUstPanel.add(satisAdetLabel);
		JTextField satisAdetField = new JTextField(10);
		satisSaðUstPanel.add(satisAdetField);
		satisAdetField.setBackground(new Color(175, 238, 238));
		JLabel satisTarihiLabel = new JLabel("Satýþ Tarihi:",JLabel.RIGHT);
		satisSaðUstPanel.add(satisTarihiLabel);
		JDateChooser satisTarihi = new JDateChooser();
		satisSaðUstPanel.add(satisTarihi);
		
	
		
		JButton satisEkleButton = new JButton("Satýþ Yap");
		satisSaðUstPanel.add(satisEkleButton);
		
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
				
				JOptionPane.showMessageDialog(null, mContract.getAdiSoyadi() + " Ýsimli müþteriye satýþ gerçekleþmiþtir ve " +uContract.getAdi()+" Adli üründen stokta " + contract.getAdet()+" adet eksiltilmiþtir.");
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
		satisSaðUstPanel.add(satisYenileButton);
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
		
		satisPanel.add(satisSaðPanel,BorderLayout.WEST);
		satisPanel.add(satisTablePane,BorderLayout.CENTER);
		
		satisSaðPanel.add(satisSaðUstPanel,BorderLayout.NORTH);
		satisSaðPanel.add(satisSaðAltPanel,BorderLayout.SOUTH);
		
		stokSolPanel.add(stokSolUstPanel,BorderLayout.NORTH);
		stokSolPanel.add(stokSolAltPanel,BorderLayout.SOUTH);
		
		
		
		pane.addTab("Stoklar",null,stokPanel,"Stok Bilgileri Görüntüleme");
		pane.addTab("Satýþlar",null,satisPanel, "Satýþ Bilgileri Görüntüleme");
		pane.addTab("Personel Bilgileri",null ,personelPanel,"Personel bilgileri görüntüleme" );
		
		return pane;
	}
	

}
