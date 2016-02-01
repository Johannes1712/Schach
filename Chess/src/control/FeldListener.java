package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.htl.chess.model.Bauer;
import org.htl.chess.model.Dame;
import org.htl.chess.model.Feld;
import org.htl.chess.model.Figur;
import org.htl.chess.model.Koenig;
import org.htl.chess.model.Laeufer;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.htl.chess.model.Springer;
import org.htl.chess.model.Turm;

import view.Frame;

public class FeldListener implements MouseListener{
	
	Feld feld;
	Position posVon;
	Spielfeld spielfeld;
	JFrame jframe;
	Frame frame;
	
	public FeldListener(Position pos, Spielfeld spielfeld, JFrame jframe, Frame frame, Feld feld){
		
		this.feld=feld;
		this.posVon=pos;
		this.spielfeld=spielfeld;
		this.jframe= jframe;
		this.frame= frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	
		@SuppressWarnings("unused")
		boolean figurAusgewaehlt=false;
		
		ArrayList<Position> positionListe= new ArrayList<Position>();
		
		if(feld instanceof Figur ){
			
			Figur figur= (Figur)feld;
			figurAusgewaehlt=true;
			
			for(int x=0; x<=7;x++){
				for(int y=0;y<=7;y++){
					
					Position posNach= new Position(x,y);
					if(figur.spielzugMoeglich(spielfeld,posVon, posNach)){
						positionListe.add(posNach);
					}
				}
			}
			System.out.println("Listener");
			System.out.println(positionListe.get(0));
			frame.felderAnfaerben(positionListe);
		}
		if(figurAusgewaehlt){
			
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
