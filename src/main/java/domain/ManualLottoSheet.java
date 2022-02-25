package domain;

import java.util.List;

public class ManualLottoSheet {

    private List<LottoSheet> manualNumbers;

    public ManualLottoSheet(List<LottoSheet> manualLottoNumbers) throws IllegalArgumentException {
        LottoSheetValidator lottoSheetValidator = new LottoSheetValidator();
        for (LottoSheet lottoSheet : manualLottoNumbers) {
            List<Integer> lottoNumbers = lottoSheet.getLottoNumbers();
            lottoSheetValidator.validate(lottoNumbers, LottoGenerator.LOTTO_NUMBER_SIZE);
        }
        manualNumbers = manualLottoNumbers;
    }

    public List<LottoSheet> getManualNumbers() {
        return manualNumbers;
    }
}
