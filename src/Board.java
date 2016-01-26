import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	Bag objBag = new Bag();
	public Board(){
		objBag.Shuffle();
	}
	
	private char[][] objBoard = new char[15][15];
	public boolean setLetter(ArrayList<Tile> tileList){
		Scanner oScan = new Scanner(System.in);
		System.out.println(tileList);
		System.out.print("Choose a Letter or \"-\" to Cancel:  ");
		char input = oScan.nextLine().charAt(0);
		if (input == '-'){
			return false;
		}
		for(int i = 0;i<tileList.size();i++){
			if (input == tileList.get(i).getLetter()){
				System.out.print("Select position on board:  ");
				int inputPos = oScan.nextInt();
				if(setSpace(inputPos, input)){
					System.out.println("Letter Placed");
					tileList.remove(i);
					return true;
				}
				else{
					System.out.println("There is already a letter here!");
				}
			}
		}
		System.out.println("You do not have this letter");
		return true;
	}
	private boolean setSpace(int space,char input){
		int x = space/15;
		int y = space%15;
		if (objBoard[x][y]<9){
			objBoard[x][y]=input;
			return true;
		}
		return false;
	}
	public void getTiles(Player objPlayer){
		int currentNumberofTiles = objPlayer.getTiles().size();
		for (int i = 0;i< 7-currentNumberofTiles;i++){
			if (objBag.Size()>0){
				objPlayer.addTile(objBag.Draw());
			}
		}
	}
	public String toString(){
		String output = "";
		for (int i=0;i<225;i++){
			if(objBoard[i/15][i%15]==0){
				output=output+" | " + String.format("%03d", i);
			}
			else{
				output =output +" |  " + objBoard[i/16][i%15]+" ";
			}
			if (i%15==14 && i/15<14){
				output = output + " |\n"
						+ " +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
			}
		}
		output = output + " |";
		return output;
	}
}
