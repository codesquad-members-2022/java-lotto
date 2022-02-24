package application.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoShowDto {

    private int lottosSize;
    private List<Map<String, List<Integer>>> lottos;

    public LottoShowDto(int lottosSize, List<List<Integer>> lottos) {
        this.lottosSize = lottosSize;
        this.lottos = lottos.stream()
                .map(numbers -> new HashMap<String, List<Integer>>() {{
                    put("numbers", numbers);
                }})
                .collect(Collectors.toList());
    }

    public int getLottosSize() {
        return lottosSize;
    }

    public List<Map<String, List<Integer>>> getLottos() {
        return lottos;
    }

    public Map<String, Object> toModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("lottosSize", lottosSize);
        model.put("lottos", lottos);

        return model;
    }
}
