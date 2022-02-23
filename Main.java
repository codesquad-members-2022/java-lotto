package PACKAGE_NAME;

import PACKAGE_NAME.domain.LottoCompany;
import PACKAGE_NAME.domain.LottoStore;
import PACKAGE_NAME.domain.LottoTicket;
import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.view.InputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
//    int money = inputView.inputMoney();
    public static void main(String[] args) throws Exception {
        GameManager gameManager = new GameManager();
        gameManager.play();
//        LottoStore lottoStore = new LottoStore();
//        List<Integer> lottoNumbers = lottoStore.getLottoNumbers();
//
//        InputView inputView = new InputView();
//        int money = inputView.inputMoney();
//        int ticketCount = money / 1000;
//
//        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
//
//        LottoCompany lottoCompany = new LottoCompany();
//
//
//        //금액만큼의 티켓 만들고
//        LottoTickets lottoTickets = new LottoTickets(lottoStore.getLottoTickets(ticketCount));
//
//
//        System.out.println(ticketCount + "개를 구매했습니다.");
//
//        lottoTickets.getLottoTickets()
//                .forEach(System.out::println);
//
//        lottoCompany.notifyAnswer(inputView.inputWinningNumber());
//        Map<Integer, Integer> numberMatch = lottoCompany.numberMatch(lottoTickets);
//
//
//        System.out.println("당첨 통계");
//        System.out.println("----------");
//        for (int index = 3; index < 7; index++) {
//            if(index == 3) {
//                System.out.println(index + "개 일치 (5000원) - " + numberMatch.getOrDefault(index, 0) + "개");
//            }
//            if(index == 4){
//                System.out.println(index + "개 일치 (50000원) - " + numberMatch.getOrDefault(index, 0) + "개");
//            }
//            if(index == 5){
//                System.out.println(index + "개 일치 (1500000원) - " + numberMatch.getOrDefault(index, 0) + "개");
//            }
//            if(index == 6){
//                System.out.println(index + "개 일치 (2000000000원) - " + numberMatch.getOrDefault(index, 0) + "개");
//            }
//        }
//        int sum = lottoTickets.winningAmount(numberMatch);
//
//        System.out.println("당첨금액 총합: " + sum);
//
//
//        System.out.print("총 수익률은" + lottoTickets.calculateYield(sum, money) + "% 입니다.");

    }
}
