package PACKAGE_NAME;

import PACKAGE_NAME.domain.LottoStore;
import PACKAGE_NAME.domain.LottoTicket;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        LottoStore lottoStore = new LottoStore();
        List<Integer> lottoNumbers = lottoStore.getLottoNumbers();

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoTicket.getNumbers().forEach(System.out::println);

    }
}
