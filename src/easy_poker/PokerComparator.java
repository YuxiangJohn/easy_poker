package easy_poker;

import java.util.Comparator;



public class PokerComparator implements Comparator<Poker> {

	public int compare(Poker o1, Poker o2) {
        // ��ɫ����ֵ��С��������
        String[] cardDesign = { "��Ƭ", "÷��", "����", "����" };
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
        if (temp1 > temp2) {// ��ֵ��ߴ󷵻�-1
            return -1;
        } else if (temp1 == temp2) {// ��ֵ�����С��ͬ���Ƚϻ�ɫ
            for (int i = 0; i < cardDesign.length; i++) {
                if (o1.color.equals(cardDesign[i]))
                    temp1 = temp1 + i;
                if (o2.color.equals(cardDesign[i]))
                    temp2 = temp2 + i;
            }
            if (temp1 > temp2) {// ��ɫ��ߴ󷵻�-1
                return -1;
            } else if(temp1==temp2){
            	return 0;
            }else  // ��ɫ�ұߴ󷵻�1
                return 1;
            }
         else{// ��ֵ�ұߴ󷵻�1
            return 1;
              }

    }

		
	}


