package org.htl.chess.model;

public class Spielfeld 
{
	private Feld[][] mat=new Feld[8][8];
	@SuppressWarnings("unused")
	private boolean werAmZug;

	public void ausgabe() {
		for(int i=0;i<=7;i++){
			for(int b=0;b<=7;b++){
				
				Figur figur= (Figur) mat[i][b];
				if(figur instanceof Bauer)System.out.print("B ");
				if(figur instanceof Turm)System.out.print("T ");
				if(figur instanceof Springer)System.out.print("S ");
				if(figur instanceof Laeufer)System.out.print("L ");
				if(figur instanceof Koenig)System.out.print("K ");
				if(figur instanceof Dame)System.out.print("D ");
				if(figur instanceof Feld)System.out.print("X ");
				
				System.out.print("| ");
				if(b==7)System.out.println();
		
			}
		}
	}

	@SuppressWarnings("null")
	public boolean schach(){
		
		Position koenig1Pos = null;
		Position koenig2Pos=null;
		boolean welcherKoenig;
		
		for(int i=0;i<=7;i++){
			for(int b=0;b<=7;b++){				
				Figur figur= (Figur) mat[i][b];
				if(figur instanceof Koenig){
					welcherKoenig=true;
					if(welcherKoenig)koenig1Pos.setX(i);koenig1Pos.setY(b);welcherKoenig=false;
					koenig2Pos.setX(i);koenig2Pos.setY(b);break;
				}				
			}
		}
		
		welcherKoenig=true;
		for(int i=0;i<=7;i++){
			for(int b=0;b<=7;b++){
				Figur figur= (Figur) mat[i][b];
				if(figur instanceof Figur){
					Position figurPos = null;
					figurPos.setX(i);
					figurPos.setY(b);
					
					if(figur.spielzugMoeglich(this,figurPos,koenig1Pos)||
					figur.spielzugMoeglich(this,figurPos,koenig2Pos)){
						return true;
					}
				}
			}	
		}			
		return false;
	}
	public boolean schachMatt()
	{
		return false;
	}
	
	public void spielzug(String zug)
	{
		if(Integer.parseInt(zug)/2==0)
		{
			werAmZug=true;
		}
		else
		{
			werAmZug=false;
		}
	}
	
	public Position schach2koordinate(String schach)
	{
		return new Position();
	}
	
	public void spielfeldVeraendern(){
		
	}
	
	public Feld [][] getMat(){
		return mat;
	}



	public void spielzugAusfuehren(Position von, Position nach, Figur figur) {
		
		Feld feld = new Feld();;
		mat[von.getX()][von.getY()]= feld;		
		mat[nach.getX()][nach.getY()]= figur;
	}
}
