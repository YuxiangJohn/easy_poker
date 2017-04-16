package easy_poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public String id;
	public String name;
	//card list
	public List<Poker> cardInHand=new ArrayList<Poker>();
	public Player(String id, String name){
	
		this.id=id;
	    this.name=name;
	}
}
