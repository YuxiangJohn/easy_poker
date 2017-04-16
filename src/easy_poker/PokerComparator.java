package easy_poker;

import java.util.Comparator;



public class PokerComparator implements Comparator<Poker> {

	public int compare(Poker o1, Poker o2) {
        // 花色、牌值从小到大排列
        String[] cardDesign = { "方片", "梅花", "红桃", "黑桃" };
        String[] cardNum = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
                "Q", "K", "A" };
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < cardNum.length; i++) {
            if (o1.num.equals(cardNum[i]))
                temp1 = 1 + i;
            if (o2.num.equals(cardNum[i]))
                temp2 = 1 + i;
        }
        if (temp1 > temp2) {// 牌值左边大返回-1
            return -1;
        } else if (temp1 == temp2) {// 牌值如果大小相同，比较花色
            for (int i = 0; i < cardDesign.length; i++) {
                if (o1.color.equals(cardDesign[i]))
                    temp1 = temp1 + i;
                if (o2.color.equals(cardDesign[i]))
                    temp2 = temp2 + i;
            }
            if (temp1 > temp2) {// 花色左边大返回-1
                return -1;
            } else if(temp1==temp2){
            	return 0;
            }else  // 花色右边大返回1
                return 1;
            }
         else{// 牌值右边大返回1
            return 1;
              }

    }

		
	}


