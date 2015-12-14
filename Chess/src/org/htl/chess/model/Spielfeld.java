package org.htl.chess.model;

public class Spielfeld 
{
	private Feld[][] mat=new Feld[10][10];
	private boolean werAmZug;
	
	public void ausgabe()
	{
		
	}
	
	public boolean schach()
	{
		if()
		{
			return true;
		}
		else
		{
			return false;
		}
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

	public void spielzugAusführen(Position von, Position nach, Figur figur) {
		
		Feld feld = new Feld();;
		mat[von.getX()][von.getY()]= feld;
		
		mat[nach.getX()][nach.getY()]= figur;
	}
}
