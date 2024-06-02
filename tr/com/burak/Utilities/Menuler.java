package tr.com.burak.Utilities;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tr.com.burak.dal.AccountsDAL;
import tr.com.burak.fe.KategoriEkleFe;
import tr.com.burak.fe.LoginFe;
import tr.com.burak.fe.MusteriEkleFe;
import tr.com.burak.fe.PersonelEkleFe;
import tr.com.burak.fe.SifreIslemleriFE;
import tr.com.burak.fe.UrunEkleFE;
import tr.com.burak.fe.YetkiEkleFe;
import tr.com.burak.types.PersonelContract;

public class Menuler {

	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();
		
		JMenu dosyaMenu = new JMenu("Dosya");
		bar.add(dosyaMenu);
		JMenuItem cikisItem = new JMenuItem("Çýkýþ");
		dosyaMenu.add(cikisItem);
//		Ürunler Menüsü
		JMenu urunlerMenu = new JMenu("Ürünler");
		bar.add(urunlerMenu);
		JMenuItem urunEkleItem = new JMenuItem("Ürün Ekle");
		urunlerMenu.add(urunEkleItem);
		JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
		urunlerMenu.add(kategoriEkleItem);
		urunlerMenu.addSeparator();
		JMenuItem urunDuzenleItem = new JMenuItem("Ürünü Düzenle");
		urunlerMenu.add(urunDuzenleItem);
		JMenuItem kategoriDuzenleItem = new JMenuItem("Kategoriyi düzenle");
		urunlerMenu.add(kategoriDuzenleItem);
		
//		Personel Menüsü
		JMenu personellerMenu = new JMenu("Personel Ýþlemleri");
		bar.add(personellerMenu);
		JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
		personellerMenu.add(personelEkleItem);
		JMenuItem yetkiEkleItem = new JMenuItem("Yetki ekle");
		personellerMenu.add(yetkiEkleItem);
		JMenuItem sifreBelirleItem = new JMenuItem("Þifre Belirleme");
		personellerMenu.add(sifreBelirleItem);
		personellerMenu.addSeparator();
		
		JMenuItem personelDuzenleItem = new JMenuItem("Personel Düzenle");
		personellerMenu.add(personelDuzenleItem);
		JMenuItem yetkiDuzenle = new JMenuItem("Yetki Düzenle");
		personellerMenu.add(yetkiDuzenle);
		JMenuItem sifreDuzenlemeItem = new JMenuItem("Þifre Düzenle");
		personellerMenu.add(sifreDuzenlemeItem);
//		Müsteri Menüsü
		
		JMenu musterilerMenu = new JMenu("Müþteriler");
		bar.add(musterilerMenu);
		JMenuItem musteriEkleItem = new JMenuItem("Müþteri Ekle");
		musterilerMenu.add(musteriEkleItem);
		JMenuItem sehirEkleItem = new JMenuItem("Þehir Ekle");
		
		musterilerMenu.add(sehirEkleItem);
		musterilerMenu.addSeparator();
		
		JMenuItem musteriDuzenleItem = new JMenuItem("Müsteri Düzenle");
		musterilerMenu.add(musteriDuzenleItem);
		JMenuItem sehirDuzenleItem = new JMenuItem("Þehir Düzenle");
		musterilerMenu.add(sehirDuzenleItem);
	
		PersonelContract contract = (PersonelContract) LoginFe.emailBox.getSelectedItem();
		System.out.println(contract.getAdiSoyadi());
		if(new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==2){
			
			personellerMenu.hide();
		}else if(new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==3){
			
			musterilerMenu.hide();
			personellerMenu.hide();
			urunlerMenu.hide();
		}
		urunEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						new UrunEkleFE();
					}
				});
				
			}
		});
		kategoriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new KategoriEkleFe();
			}
		});
		
	
		personelEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new PersonelEkleFe();
						
					}
				});
				
			}
		});
	
		yetkiEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new YetkiEkleFe();
					}
				});
				
			}
		});
		
		sifreBelirleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new SifreIslemleriFE();
				
				
				
				
			}
		});
		
		musteriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {

						new MusteriEkleFe();
						
					}
				});
				
				
			}
		});
		
		return bar;
	}
}
