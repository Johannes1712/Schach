package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import control.FeldListener;

public class Frame{
	
	private JFrame frame;
	private ArrayList<JPanel> panels;
	private Spielfeld spielfeld;
	private Schachfiguren figuren;
	private JPanel jpanel;
	private JPanel jpanelrechts;
	private JPanel jpanellinks;
	
	public Frame(Spielfeld spielfeld){
		this.spielfeld=spielfeld;
	}
	

	public void initialize(){
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		jpanel= new JPanel();
		jpanel.setPreferredSize(new Dimension(100,600));
	    jpanel.setMaximumSize(new Dimension(100,600));
	    jpanel.setLayout(new GridLayout(8,8));
	    
	    
	    jpanelrechts= new JPanel();
		jpanelrechts.setPreferredSize(new Dimension(307,200));
	    jpanelrechts.setMaximumSize(new Dimension(200,200));
	    
	    jpanellinks= new JPanel();
		jpanellinks.setPreferredSize(new Dimension(307,200));
	    jpanellinks.setMaximumSize(new Dimension(200,200));
		
		figuren= new Schachfiguren();
		figuren.figurenLaden();
		
		panels=new ArrayList<JPanel>();
		
		spielfeldAufbauen();
		
		frame.add(jpanelrechts, BorderLayout.WEST);
		frame.add(jpanellinks, BorderLayout.EAST);
		frame.add(jpanel, BorderLayout.CENTER);
		frame.setVisible(true);
	
	}
	
	public void aktualisieren(){
		
		spielfeldAufbauen();
		frame.repaint();
		frame.setVisible(true);
		
	}
	
	
	public void spielfeldAufbauen(){
		
		panels.clear();
		
		boolean schonAusgewaehlt=false;
		Position pos;
		
		for(int x=0;x<=7;x++){
			
			for(int y=0;y<=7;y++){
				
				pos= new Position(x,y);
				
				FeldLaden feld=new FeldLaden();
				if(y%2==0 && x%2==1 && !schonAusgewaehlt){
					feld.feldSetzen(figuren.getList(), true, spielfeld.getFeld(y, x));
					feld.addMouseListener(new FeldListener(pos, spielfeld, frame,this,spielfeld.getFeld(y, x)));
					
					schonAusgewaehlt=true;
				}
				if(y%2==0 && x%2==0 && !schonAusgewaehlt){
					feld.feldSetzen(figuren.getList(), false, spielfeld.getFeld(y, x));
					feld.addMouseListener(new FeldListener(pos, spielfeld, frame,this,spielfeld.getFeld(y, x)));
					
					schonAusgewaehlt=true;
				}
				if(y%2==1 && x%2==0 && !schonAusgewaehlt){
					feld.feldSetzen(figuren.getList(), true, spielfeld.getFeld(y, x));
					feld.addMouseListener(new FeldListener(pos, spielfeld, frame,this,spielfeld.getFeld(y, x)));
					
					schonAusgewaehlt=true;
				}
				if(y%2==1 && x%2==1 && !schonAusgewaehlt){
					feld.feldSetzen(figuren.getList(), false, spielfeld.getFeld(y, x));
					feld.addMouseListener(new FeldListener(pos, spielfeld, frame,this,spielfeld.getFeld(y, x)));
					
					schonAusgewaehlt=true;
				}
				
				feld.setBounds(0, 0, 20,20);
				jpanel.add(feld);
				
				feld.repaint();
				feld.setVisible(true);
				
				schonAusgewaehlt=false;
				
			}
		}
		
		jpanel.repaint();
		frame.repaint();
		
	}
	
	public void felderAnfaerben(ArrayList<Position> liste){
		
		FeldLaden feld= new FeldLaden();
		
		for(Position pos: liste){
			int x= pos.getX();
			int y= pos.getY();
			
			feld=(FeldLaden) jpanel.getComponentAt(x, y);
			feld.setFaerbig(true);
		}
		
		jpanel.repaint();
		frame.repaint();
		feld.setFaerbig(false);
		
	}

}
