package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.htl.chess.model.Feld;
import org.htl.chess.model.Figur;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import view.Frame;

public class FeldListener implements MouseListener{
	
	Feld feld;
	Position posAktuell;
	Spielfeld spielfeld;
	JFrame jframe;
	Frame frame;
	
	ArrayList<Position> positionListe;
	static boolean figurWaehlen= true;
	static boolean figurPlatzieren= false;
	static boolean zugBeendet=false;
	
	public FeldListener(Position pos, Spielfeld spielfeld, JFrame jframe, Frame frame, Feld feld){
		
		this.feld=feld;
		this.posAktuell=pos;
		this.spielfeld=spielfeld;
		this.jframe= jframe;
		this.frame= frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		positionListe= new ArrayList<Position>();
		zugBeendet=false;
		
		if(figurPlatzieren && !figurWaehlen) figurPlatzieren();
		else figurPlatzieren=false;
		if((figurWaehlen || !figurPlatzieren) && !zugBeendet) figurWaehlen();
		
		
		
	}
	
	public void figurWaehlen(){
		
		if(feld instanceof Figur){
			
			Figur figur= (Figur)feld;
			figurWaehlen=false;
			figurPlatzieren=true;
			
			spielfeld.setAktuellePositionFigur(posAktuell);
			
			for(int x=0; x<=7;x++){
				for(int y=0;y<=7;y++){
					
					Position posNach= new Position(x,y);
					if(figur.spielzugMoeglich(spielfeld,posAktuell, posNach)){
						positionListe.add(posNach);
						spielfeld.setAktuellePositionListe(positionListe);
					}
				}
			}
			frame.felderAnfaerben(positionListe);
		}
	}
	
	public void figurPlatzieren(){
		
		positionListe=spielfeld.getAktuellePositionListe();
		positionListe.add(spielfeld.getAktuellePositionFigur());
		boolean istGleich=false;
		for(Position pos: positionListe){
			if(pos.getX()==posAktuell.getX() && pos.getY()==posAktuell.getY())istGleich=true;
		}
		if(istGleich){

			Position figurPosition=spielfeld.getAktuellePositionFigur();
			int xFigur=figurPosition.getX();
			int yFigur=figurPosition.getY();
			System.out.println(xFigur+"-"+ yFigur);
			
			spielfeld.spielzugAusfuehren(figurPosition, posAktuell, spielfeld.getFigur(xFigur,yFigur));
			frame.spielfeldAufbauen();
			
			
			positionListe.clear();
			spielfeld.setAktuellePositionListe(positionListe);
			zugBeendet=true;
		}
		figurWaehlen=true;
		figurPlatzieren=false;
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
