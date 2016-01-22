package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Schachfiguren{
	
	BufferedImage bauerW,turmW,springerW,laeuferW,koenigW,dameW,bauerB,turmB,springerB,laeuferB,koenigB,dameB;
	ArrayList<Image> list= new ArrayList<Image>();
	
	public void figurenLaden()
	{
		try {
			
			turmW=ImageIO.read(new File("TW.png"));
			list.add(turmW);
			turmW=ImageIO.read(new File("TW.png"));
			list.add(turmW);
			springerW=ImageIO.read(new File("SW.png"));
			list.add(springerW);
			laeuferW=ImageIO.read(new File("LW.png"));
			list.add(laeuferW);
			koenigW=ImageIO.read(new File("KW.png"));
			list.add(koenigW);
			dameW=ImageIO.read(new File("DW.png"));
			list.add(dameW);
			
			turmB=ImageIO.read(new File("TB.png"));
			list.add(turmB);
			springerB=ImageIO.read(new File("SB.png"));
			list.add(springerB);
			laeuferB=ImageIO.read(new File("LB.png"));
			list.add(laeuferB);
			koenigB=ImageIO.read(new File("KB.png"));
			list.add(koenigB);
			dameB=ImageIO.read(new File("DB.png"));
			list.add(dameB);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Image> getList(){
		return list;
	}
	
}