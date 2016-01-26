import java.util.ArrayList;

public class Player {
	
	public int number;
	ArrayList<Tile> myTiles = new ArrayList<Tile>();
	
	
	public Player(int number){
		
		this.number = number;
	}
	public void addTile(Tile input ){
		myTiles.add(input);
	}
	public ArrayList<Tile> getTiles(){
		return myTiles;
	}
}