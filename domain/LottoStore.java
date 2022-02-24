package PACKAGE_NAME.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private static final List<Integer> lottoNumbers;
    private static final int START_INDEX = 0;
    private static final int START = 1;
    private static final int END = 45;
    private static final int LIMIT = 6;

    static {
        lottoNumbers = IntStream.rangeClosed(START, END)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        shuffle();
        return getSixNumbers();
    }

    private void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    private List<Integer> getSixNumbers() {
        return lottoNumbers.stream()
                .limit(LIMIT)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets(int count) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int index = START_INDEX; index < count; index++) {
            lottoTickets.add(new LottoTicket(getLottoNumbers()));
        }
        return lottoTickets;
    }
}
