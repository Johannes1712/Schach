package org.htl.chess.model;

public class Figur extends Feld{
	
	private boolean farbeWeiss;
	private boolean bewegt;
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach){
		if(this.spielzugMoeglich(sp, von, nach)) return true;
		return false;
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach){
		return true;
	}
	
	public void setFarbeWeiss(boolean farbeWeiss){
		this.farbeWeiss=farbeWeiss;
	}
	
	public boolean getFarbeWeiss(){
		return farbeWeiss;
	}
	
	public void setBewegt(boolean bewegt){
		this.bewegt=bewegt;
	}
	
	public boolean getBewegt(){
		return bewegt;
	}

}
