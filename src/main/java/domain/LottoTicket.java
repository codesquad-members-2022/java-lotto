package domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Integer> getTicketInfo() {
        return Collections.unmodifiableList(this.lottoTicket);
    }

    public int get(int index){
        if (index < 0 || index >= lottoTicket.size()){
            throw new IndexOutOfBoundsException("인덱스를 초과하였습니다.");
        }
        return lottoTicket.get(index);
    }

    public int comparisonWinningTicket(LottoTicket winningTicket){
        int count = 0;
        for(int i=0; i<lottoTicket.size(); i++){
            count+=checkNumber(winningTicket, i);
        }
        return count;
    }

    private int checkNumber(LottoTicket winningTicket, int index){
        if (lottoTicket.contains(winningTicket.get(index))){
            return 1;
        }
        return 0;
    }

    public boolean checkBonusNumber(int bonusNumber){
        return lottoTicket.contains(bonusNumber);
    }


}
