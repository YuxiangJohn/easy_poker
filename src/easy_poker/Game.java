package easy_poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Scanner scanner;
	public List<Poker> pokerList;
	//public Map<Player,List<Poker>> playerList;
	public List<Player> playerList;
	public Game(){
		this.pokerList=new ArrayList<Poker>();
		this.playerList=new ArrayList<Player>();
	}
	public void Create(){
		//create 53 poke
		String[] color={"∫⁄Ã“","∫ÏÃ“","√∑ª®","∑Ω∆¨"};
		String[] num={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		System.out.println("-----Create Poker-----");
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				Poker pk=new Poker(color[i],num[j]);
				pokerList.add(pk);
			}
		}
		System.out.println("-----Create Poker Successfully-----");
		for(Poker poker:pokerList){
			System.out.println("["+poker.color+poker.num+"]");
		}
		
	}
	//œ¥≈∆
	public void RandomPoker(){
		System.out.println("-----Start Random-----");
		Collections.shuffle(pokerList);
		System.out.println("-----Random complete-----");
	}
	//ÃÌº”ÕÊº“
	public void AddPlayer(){
		System.out.println("-----create player-----");
		scanner=new Scanner(System.in);
		for(int i=0;i<2;i++){
			System.out.println("please input the "+(i+1)+" player's ID and Name:");
			System.out.println("please input the ID:");
			String id="";
			String name="";
			try{
				id=scanner.nextLine();
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
			System.out.println("please input the Name:");
			try{
				name=scanner.nextLine();
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
			System.out.println(id);
			System.out.println(name);
			Player p=new Player(id,name);
			playerList.add(p);
		}
		System.out.println("-----create player successfully-----");
		for(Player player:playerList){
			System.out.println("welcome player:"+player.name);
		}
	}
	public void getCard(){
		System.out.println("--------start to play---------");
		System.out.println("player:"+playerList.get(0).name+" get a card");
		playerList.get(0).cardInHand.add(pokerList.get(0));
		System.out.println("player:"+playerList.get(1).name+" get a card");
		playerList.get(1).cardInHand.add(pokerList.get(1));
		System.out.println("player:"+playerList.get(0).name+" get a card");
		playerList.get(0).cardInHand.add(pokerList.get(2));
		System.out.println("player:"+playerList.get(1).name+" get a card");
		playerList.get(1).cardInHand.add(pokerList.get(3));
	}
	public void compare(){
		//
		Collections.sort(playerList.get(0).cardInHand,new PokerComparator());
		System.out.println("the player:"+playerList.get(0).name+" get pokers:");
		for(Poker poker: playerList.get(0).cardInHand){
			System.out.println("["+poker.color+poker.num+"]");
		}
		Collections.sort(playerList.get(1).cardInHand,new PokerComparator());
		System.out.println("the player:"+playerList.get(1).name+" get pokers:");
		for(Poker poker: playerList.get(1).cardInHand){
			System.out.println("["+poker.color+poker.num+"]");
		}
		System.out.println("the largest poke of "+ playerList.get(0).name+" is:"+"["+playerList.get(0).cardInHand.get(0).color+playerList.get(1).cardInHand.get(0).num+"]");
		System.out.println("the largest poke of "+ playerList.get(1).name+" is:"+"["+playerList.get(1).cardInHand.get(0).color+playerList.get(1).cardInHand.get(0).num+"]");
		List<Poker> compareList=new ArrayList();
		compareList.add(playerList.get(0).cardInHand.get(0));
		compareList.add(playerList.get(1).cardInHand.get(0));
		Collections.sort(compareList,new PokerComparator());
		
		if(compareList.get(0).equals(playerList.get(0).cardInHand.get(0))){
			System.out.println("Winner is: "+playerList.get(0).name);
		}else
			System.out.println("Winner is: "+playerList.get(1).name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g=new Game();
		g.Create();
		g.RandomPoker();
		g.AddPlayer();
		g.getCard();
		g.compare();

	}

}
