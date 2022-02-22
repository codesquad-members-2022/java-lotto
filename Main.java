package PACKAGE_NAME;

import PACKAGE_NAME.domain.LottoCompany;
import PACKAGE_NAME.domain.LottoStore;
import PACKAGE_NAME.domain.LottoTicket;
import PACKAGE_NAME.domain.LottoTickets;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        LottoStore lottoStore = new LottoStore();
        List<Integer> lottoNumbers = lottoStore.getLottoNumbers();

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
//        lottoTicket.getNumbers().forEach(System.out::println);


        LottoCompany lottoCompany = new LottoCompany();


        lottoCompany.notifyAnswer(List.of(3,4,5,6,7,8));


        lottoCompany.numberMatch(lottoStore.getLottoTickets(20))
                .entrySet()
                .forEach(System.out::println);





    }
}
