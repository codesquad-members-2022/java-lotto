package lotto_game.service;

import lotto_game.domain.Lotto;
import lotto_game.domain.LottoResult;
import lotto_game.domain.LottoTicket;
import lotto_game.domain.WinningNumbers;
import lotto_game.exception.MyException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {
    public static final int EACH_LOTTO_PRICE = 1000;
    LottoIssuer lottoIssuer;

    public LottoManager() {
        this.lottoIssuer = new LottoIssuer();
    }

    public LottoTicket makeLottoTicket(int purchaseMoney, List<Lotto> lottoList) {
        return lottoIssuer.makeLottoTicket(calculateCountOfLotto(purchaseMoney), lottoList);
    }

    private int calculateCountOfLotto(int purchaseMoney) {
        return purchaseMoney / EACH_LOTTO_PRICE;
    }

    public WinningNumbers makeWinningNumbers(String winNumbers, int bonusNumber) {
        String[] winNumbersArray = winNumbers.split(", ");
        return new WinningNumbers(Arrays.stream(winNumbers.split(", "))
                .mapToInt(Integer::parseInt)
                .filter(i -> MyException.numberException(i))
                .boxed()
                .collect(Collectors.toList()), bonusNumber);
    }

    public LottoResult makeLottoResult(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        return lottoIssuer.makeLottoResult(lottoTicket, winningNumbers);
    }

    public Lotto makeLotto(List<Integer> manualLottoNumbers) {
        return lottoIssuer.makeLotto(manualLottoNumbers);
    }
}
