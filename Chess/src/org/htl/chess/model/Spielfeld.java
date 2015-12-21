package org.htl.chess.model;

public class Spielfeld 
{
	private Feld[][] mat = new Feld[8][8];
	@SuppressWarnings("unused")
	private boolean werAmZug;

	public void ausgabe() 
	{
		for (int i = 0; i <= 7; i++) 
		{
			for (int b = 0; b <= 7; b++) 
			{

				Figur figur = (Figur) mat[i][b];
				if (figur instanceof Bauer)
					System.out.print("B ");
				if (figur instanceof Turm)
					System.out.print("T ");
				if (figur instanceof Springer)
					System.out.print("S ");
				if (figur instanceof Laeufer)
					System.out.print("L ");
				if (figur instanceof Koenig)
					System.out.print("K ");
				if (figur instanceof Dame)
					System.out.print("D ");
				if (figur instanceof Feld)
					System.out.print("X ");

				System.out.print("| ");
				if (b == 7)
					System.out.println();

			}
		}
	}

	@SuppressWarnings("null")
	public boolean schach() 
	{

		Position koenig1Pos = new Position();
		Position koenig2Pos = new Position();
		boolean welcherKoenig;

		for (int i = 0; i <= 7; i++)
		{
			for (int b = 0; b <= 7; b++) 
			{
				Figur figur = (Figur) mat[i][b];
				if (figur instanceof Koenig) 
				{
					welcherKoenig = true;
					if (welcherKoenig)
						koenig1Pos.setX(i);
					koenig1Pos.setY(b);
					welcherKoenig = false;
					koenig2Pos.setX(i);
					koenig2Pos.setY(b);
					break;
				}
			}
		}

		welcherKoenig = true;
		for (int i = 0; i <= 7; i++) 
		{
			for (int b = 0; b <= 7; b++) 
			{
				Figur figur = (Figur) mat[i][b];
				if (figur instanceof Figur) 
				{
					Position figurPos = null;
					figurPos.setX(i);
					figurPos.setY(b);

					if (figur.spielzugMoeglich(this, figurPos, koenig1Pos)
							|| figur.spielzugMoeglich(this, figurPos, koenig2Pos)) 
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean schachMatt()
	{
		Position koenig1Pos = new Position();
		Position koenig2Pos=new Position();
		boolean welcherKoenig;
		
		if(this.schach()){
			for(int i=0;i<=7;i++){
				for(int b=0;b<=7;b++){
					
					Figur figur= (Figur) mat[i][b];
					if(figur instanceof Koenig){
						welcherKoenig=true;
						
						
						if(welcherKoenig){
							koenig1Pos.setX(i);koenig1Pos.setY(b);welcherKoenig=false;
							Position nach1 = null; nach1.setX(i);nach1.setY(b);
							if(this.spielzuegePruefen(figur,koenig1Pos))return true;
							
						}
						
						koenig2Pos.setX(i);koenig2Pos.setY(b);
						Position nach2=null; nach2.setX(i);nach2.setY(b);
						if(this.spielzuegePruefen(figur,koenig2Pos))return true;

					}
				}
			}
			
			welcherKoenig=true;
		}
		return false;
	}
	
	private boolean spielzuegePruefen(Figur figur, Position koenigPos) {
		
		Position koenigPosAlt=koenigPos;
		figur=(Koenig)figur;
		boolean schach=false;
		int fall=1;
		if(fall==1){
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY()+1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		if(fall==2){
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY());
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		if(fall==3){
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY()-1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		if(fall==4){
			koenigPos.setX(koenigPos.getX());
			koenigPos.setY(koenigPos.getY()-1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			return true;
		}
		if(fall==5){
			koenigPos.setX(koenigPos.getX()-1);
			koenigPos.setY(koenigPos.getY()-1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		if(fall==6){
			koenigPos.setX(koenigPos.getX()-1);
			koenigPos.setY(koenigPos.getY());
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		if(fall==7){
			koenigPos.setX(koenigPos.getX()-1);
			koenigPos.setY(koenigPos.getY()+1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		if(fall==8){
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY()+1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall=0;
			return true;
		}
		
		return schach;
	}
	public void spielzug(String zug) 
	{
		if (Integer.parseInt(zug) / 2 == 0) 
		{
			werAmZug = true;
		} else 
		{
			werAmZug = false;
		}
	}

	public Position schach2koordinate(String schach) 
	{
		return new Position();
	}

	public Feld[][] getMat() 
	{
		return mat;
	}

	public void spielzugAusfuehren(Position von, Position nach, Figur figur)
	{
		Feld feld = new Feld();
		mat[von.getX()][von.getY()] = feld;
		mat[nach.getX()][nach.getY()] = figur;
	}
}
