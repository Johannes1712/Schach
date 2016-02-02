package view;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.htl.chess.model.Bauer;
import org.htl.chess.model.Dame;
import org.htl.chess.model.Feld;
import org.htl.chess.model.Figur;
import org.htl.chess.model.Koenig;
import org.htl.chess.model.Laeufer;
import org.htl.chess.model.Springer;
import org.htl.chess.model.Turm;

public class FeldLaden extends JPanel {

	private static final long serialVersionUID = 1L;
	
	int figurIndex;
	boolean weissesFeld;
	boolean faerbig;
	
	BufferedImage weiss,schwarz,blau;
	ArrayList<Image> figurenliste;
	
	public void feldSetzen(ArrayList<Image> list, boolean weissesFeld, Feld feld)
	{
		figurenliste=list;
		figurIndex=getFigur(feld);
		this.weissesFeld=weissesFeld;
		
		farbenLaden();
	}
	
	protected void paintComponent(Graphics g){
		
		
		if(faerbig){
			g.drawImage(blau,0,0,null);
			faerbig=false;
			
		}else{
			if(weissesFeld)g.drawImage(weiss,0,0,null);
			else g.drawImage(schwarz,0,0,null);
		}
		if(figurIndex<12)g.drawImage(figurenliste.get(figurIndex),22,0,null);
		
	}
	
	public void farbenLaden(){
		try {
			weiss=ImageIO.read(new File("FeldWeiss.jpg"));
			schwarz=ImageIO.read(new File("FeldSchwarz.jpg"));
			blau=ImageIO.read(new File("FeldBlau.jpg"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getFigur(Feld feld){
		
		if (feld instanceof Figur) 
		{
			boolean istWeiss=((Figur) feld).getFarbeW();
			Figur figur= ((Figur)feld);
			
			if (figur instanceof Bauer && istWeiss)figurIndex=0;
			if (figur instanceof Turm && istWeiss)figurIndex=1;
			if (figur instanceof Springer && istWeiss)figurIndex=2;
			if (figur instanceof Laeufer && istWeiss)figurIndex=3;
			if (figur instanceof Koenig && istWeiss)figurIndex=4;
			if (figur instanceof Dame && istWeiss)figurIndex=5;
			if (figur instanceof Bauer && !istWeiss)figurIndex=6;
			if (figur instanceof Turm && !istWeiss)figurIndex=7;
			if (figur instanceof Springer && !istWeiss)figurIndex=8;
			if (figur instanceof Laeufer && !istWeiss)figurIndex=9;
			if (figur instanceof Koenig && !istWeiss)figurIndex=10;
			if (figur instanceof Dame && !istWeiss)figurIndex=11;
		}
		else{
			if (feld instanceof Feld)
				return figurIndex=30;
		}
		
		return figurIndex;
	}

	
	public void setFaerbig(boolean faerbig){
		this.faerbig=faerbig;
	}

}