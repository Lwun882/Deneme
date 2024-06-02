package tr.com.burak.test;

import javax.swing.SwingUtilities;

import tr.com.burak.fe.AnaPencereFE;
import tr.com.burak.fe.LoginFe;

public class Run {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
	
//				new AnaPencereFE();
				new LoginFe();
				
				
			}
		});
		
		
		
	}

}
