package view;
/**
 * ist das Panel wo die Bilder angezeigt werden
 * 
 * @author Johannes Haslwanter
 * @version 1.0
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FeldLaden extends JPanel {

	private static final long serialVersionUID = 1L;
	
	int figur;
	boolean weissesFeld;
	
	BufferedImage weiss,schwarz;
	ArrayList<Image> figurenliste;
	
	public void feldSetzen(ArrayList<Image> list, boolean weissesFeld, int index)
	{
		figurenliste=list;
		figur=index;
		
		this.weissesFeld=weissesFeld;
		
		farbenLaden();
	}
	
	protected void paintComponent(Graphics g){
		
		if(weissesFeld)g.drawImage(weiss,0,0,null);
		else g.drawImage(schwarz,0,0,null);
		
		g.drawImage(figurenliste.get(figur),0,0,null);
	}
	
	public void farbenLaden(){
		
	}

}