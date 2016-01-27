package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.htl.chess.model.Spielfeld;

public class Frame{
	
	private JFrame frame;
	private ArrayList<JPanel> panels;
	private Spielfeld spielfeld;
	private Schachfiguren figuren;
	
	public Frame(Spielfeld spielfeld){
		this.spielfeld=spielfeld;
	}
	

	public void initialize(){
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		figuren= new Schachfiguren();
		figuren.figurenLaden();
		
		panels=new ArrayList<JPanel>();
		
		spielfeldAufbauen();
		
		frame.setVisible(true);
	
	}
	
	public void aktualisieren(){
		
		spielfeldAufbauen();
		frame.repaint();
		frame.setVisible(true);
		
	}
	
	
	public void spielfeldAufbauen(){
		
		panels.clear();
		
		int zaehlery=20;
		for(int i=0;i<=7;i++){
			
			int zaehlerx=20;
			for(int a=0;a<=7;a++){
				
				FeldLaden feld=new FeldLaden();
				if(a%2==0) feld.feldSetzen(figuren.getList(), false, spielfeld.getFeld(i, a));
				else feld.feldSetzen(figuren.getList(), true, spielfeld.getFeld(i, a));
				
				
				feld.setBounds(100, 100, zaehlerx,zaehlery);
				feld.setVisible(true);
				
				zaehlerx=zaehlerx+20;
			}
			zaehlery=zaehlery+20;
		}
		
	}

}
