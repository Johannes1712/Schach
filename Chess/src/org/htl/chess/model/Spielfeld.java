package org.htl.chess.model;

import java.util.ArrayList;

public class Spielfeld 
{
	public Feld[][] mat = new Feld[8][8];
	private boolean weissAmZug=true;
	private Position posVon;
	private ArrayList<Position> positionListe;

	public void ausgabe() 
	{
		boolean schonVergeben=false;
		for (int i = 0; i <= 7; i++) 
		{
			for (int b = 0; b <= 7; b++) 
			{
				Feld figur= mat [i][b];
				
				if(mat[i][b] instanceof Figur){
					figur = (Figur) mat[i][b];
					schonVergeben=false;
				}else schonVergeben=true;
					
				if (figur instanceof Bauer)
					System.out.print("B");
				if (figur instanceof Turm)
					System.out.print("T");
				if (figur instanceof Springer)
					System.out.print("S");
				if (figur instanceof Laeufer)
					System.out.print("L");
				if (figur instanceof Koenig)
					System.out.print("K");
				if (figur instanceof Dame)
					System.out.print("D");
				if (figur instanceof Feld && schonVergeben)
					System.out.print("X ");
				
				if(!schonVergeben){
					
					boolean farbeW=((Figur) figur).getFarbeW();
					if(farbeW)System.out.print("W");
					else System.out.print("B");
				}

				System.out.print("| ");
				if (b == 7)
					System.out.println();
			}
			schonVergeben=false;
		}
		System.out.println(mat[0][0]);
	}


	public boolean schach() 
	{
		Position koenig1Pos = new Position(0,0);
		Position koenig2Pos = new Position(0,0);
		boolean welcherKoenig;
		welcherKoenig = true;
		for (int i = 0; i <= 7; i++)
		{
			for (int b = 0; b <= 7; b++) 
			{
				
				Feld figur= getFeld(b,i);
				if (figur instanceof Koenig) 
				{					
					if (welcherKoenig)
					{
						koenig1Pos.setX(b);
						koenig1Pos.setY(i);
						welcherKoenig = false;
					}
					else
					{
						koenig2Pos.setX(b);
						koenig2Pos.setY(i);
						break;
					}
				}
			}
		}

		welcherKoenig = true;
		for (int i = 0; i <= 7; i++) 
		{
			for (int b = 0; b <= 7; b++) 
			{
				//System.out.println(i + "," + b);
				Feld figur=  getFeld(i,b);
				if (figur instanceof Figur) 
				{
					Position figurPos = new Position(i,b);
					if (((Figur) figur).spielzugMoeglich(this, figurPos, koenig1Pos)
							|| ((Figur) figur).spielzugMoeglich(this, figurPos, koenig2Pos)) 
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
		Position koenig1Pos = new Position(0,0);
		Position koenig2Pos=new Position(0,0);
		boolean welcherKoenig;
		
		if(this.schach())
		{
			for(int i=0;i<=7;i++)
			{
				for(int b=0;b<=7;b++)
				{
					
					Feld figur=  (Figur) getFeld(i,b);
					if(figur instanceof Koenig)
					{
						welcherKoenig=true;						
						if(welcherKoenig)
						{
							koenig1Pos.setX(i);
							koenig1Pos.setY(b);
							welcherKoenig=false;
							Position nach1 = new Position(0,0); 
							nach1.setX(i);
							nach1.setY(b);
							if(this.spielzuegePruefen((Figur) figur,koenig1Pos))return true;
						}
						
						koenig2Pos.setX(i);
						koenig2Pos.setY(b);
						Position nach2=new Position(0,0);
						nach2.setX(i);
						nach2.setY(b);
						if(this.spielzuegePruefen((Figur) figur, koenig2Pos))return true;

					}
				}
			}
			
			welcherKoenig=true;
		}
		return false;
	}
	
	private boolean spielzuegePruefen(Figur figur, Position koenigPos) 
	{
		
		Position koenigPosAlt=koenigPos;
		figur=(Koenig)figur;
		boolean schach=false;
		int fall=1;
		
		if(fall==1)
		{
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY()+1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		
		if(fall==2)
		{
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY());
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		
		if(fall==3)
		{
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY()-1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		
		if(fall==4)
		{
			koenigPos.setX(koenigPos.getX());
			koenigPos.setY(koenigPos.getY()-1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			return true;
		}
		
		if(fall==5)
		{
			koenigPos.setX(koenigPos.getX()-1);
			koenigPos.setY(koenigPos.getY()-1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		
		if(fall==6)
		{
			koenigPos.setX(koenigPos.getX()-1);
			koenigPos.setY(koenigPos.getY());
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		
		if(fall==7)
		{
			koenigPos.setX(koenigPos.getX()-1);
			koenigPos.setY(koenigPos.getY()+1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall++;
			return true;
		}
		
		if(fall==8)
		{
			koenigPos.setX(koenigPos.getX()+1);
			koenigPos.setY(koenigPos.getY()+1);
			if(figur.spielzugMoeglich(this, koenigPosAlt, koenigPos))schach=false;
			fall=0;
			return true;
		}
		
		return schach;
	}
	
	public void setWeissAmZug(boolean weissAmZug){
		this.weissAmZug=weissAmZug;
	}
	public boolean getWeissAmZug(){
		return weissAmZug;
	}

	public Position schach2koordinate(String schach) 
	{
		return new Position(0,0);
	}

	public Feld[][] getMat() 
	{
		return mat;
	}
	
	public Figur getFigur(int x, int y) 
	{
		return (Figur) mat[x][y];
	}
	
	public Feld getFeld(int x, int y){
			return  mat[x][y];		
	}

	public void spielzugAusfuehren(Position von, Position nach, Figur figur)
	{
		Feld feld = new Feld();
		mat[von.getX()][von.getY()] = feld;
		mat[nach.getX()][nach.getY()] = figur;
	}
	
	public void figurenSetzen(Position pos, Feld f){
		mat[pos.getX()][pos.getY()] = f;
	}
	
	public void setAktuellePositionFigur(Position pos){
		posVon=pos;
	}
	public Position getAktuellePositionFigur(){
		return posVon;
	}
	public void setAktuellePositionListe(ArrayList<Position> positionListe){
		this.positionListe=positionListe;
	}
	public ArrayList<Position>  getAktuellePositionListe(){
		return this.positionListe;
	}
	
}