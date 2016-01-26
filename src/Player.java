import java.util.ArrayList;

public class Player {
	
	public String name = "";
	ArrayList<Tile> myTiles = new ArrayList<Tile>();
	
	
	public Player(String name){
		
		this.name = name;
	}
	public void addTile(Tile input ){
		myTiles.add(input);
	}
}