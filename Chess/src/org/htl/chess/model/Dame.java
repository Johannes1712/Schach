
package org.htl.chess.model;
	
public class Dame extends Figur
{
	public Dame(boolean farbe, boolean bewegt) {
		super(farbe,bewegt);
	}
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{	
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
		Figur figurVon = sp.getFigur(von.getX(), von.getY());
		
		
		//runterfahren
		if(von.getX()<7)
		{
			for(int i=1;i<=8;i++)
			{
				Feld figur= sp.getFeld(von.getX()+i,von.getY());
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}
				
				if((nach.getX()== von.getX()+i))
				{
					if(nach.getY()==von.getY())
					{
						return true;
					}	
				}			
			}
		}
		
		//rauffahren
		if(von.getX()>0)
		{
			for(int i=1;i<=8;i++)
			{
				/*Feld figur= sp.getFeld(von.getX()-i,von.getY());
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}*/
				if((nach.getX()== von.getX()-i))
				{
					if((nach.getY()== von.getY()))
					{
						return true;
					}
				}
			}
		}
		//nach rechts fahren
		if(von.getY()<7)
		{
			for(int i=1;i<=8;i++)
			{
				Feld figur= sp.getFeld(von.getX(),von.getY()+i);
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}
				if((nach.getX()== von.getX()))
				{
					if((nach.getY()== von.getY()+i))
					{
						return true;
					}
					
				}
			}
		}
		
		//nach links fahren
		
		if(von.getY()>0)
		{
			for(int i=1;i<=8;i++)
			{
				Feld figur= sp.getFeld(von.getX(),von.getY()-i);
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}
				if((nach.getX()== von.getX()))
				{
					if((nach.getY()== von.getY()-i))
					{
						return true;
					}
				}
			}
		}
		
		//rechts unten fahren
		if((von.getX()<7)&&(von.getY()<7))
		{
			for(int i=1;i<=8;i++)
			{
				Feld figur= sp.getFeld(von.getX()+i,von.getY()+i);
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}
				if((nach.getX()== von.getX()+i))
				{
					if((nach.getY()== von.getY()+i))
					{
						return true;
					}					
				}
			}
			
		}
		//rechts oben fahren
		if((von.getX()>0)&&(von.getY()<7))
		{
			for(int i=1;i<=8;i++)
			{
				/*Feld figur= sp.getFeld(von.getX()-i,von.getY()+i);
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}*/
				if((nach.getX()== von.getX()-i))
				{
					if((nach.getY()== von.getY()+i))
					{
						return true;
					}
				}
			}
		}
	
		//links oben fahren
		if((von.getX()>0)&&(von.getY()>0))
		{
			for(int i=1;i<=8;i++)
			{
				/*Feld figur= sp.getFeld(von.getX()-i,von.getY()-i);
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}*/
				if((nach.getX()== von.getX()-i))
				{
					
					if((nach.getY()== von.getY()-i))
					{
						return true;
					}
				}
			}
		}
		//links unten fahren
		if((von.getX()<7)&&(von.getY()>0))
		{
			for(int i=1;i<=8;i++)
			{
				Feld figur= sp.getFeld(von.getX()+i,von.getY()-i);
				if(figur instanceof Figur)
				{
					if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
					{
						break;
					}
					
				}
				if((nach.getX()== von.getX()+i))
				{
					
					if((nach.getY()== von.getY()-i))
					{
						return true;
					}
				}
			}	
		}	
		return false;
	}
}
