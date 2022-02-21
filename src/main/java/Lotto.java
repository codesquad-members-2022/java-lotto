import java.util.ArrayList;
import java.util.List;

public class Lotto {

    List<Integer> lottos = new ArrayList<>();

    public Lotto(List<Integer> lottos) {
        this.lottos = lottos;
    }

    // 셔플하는 메소드를 만들어서 새로 만드는 생성자에서 셔플을 진행하고
    // 원래 있던 생성자를 생성하면 위에서 셔플한 리스트를 가져온다
}
