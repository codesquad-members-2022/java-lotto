# java-lotto
마스터즈 멤버스 2022 로또 게임 프로젝트

팀원 : [땃쥐](https://github.com/ttasjwi), [쿠킴](https://github.com/ku-kim)

---

# Step1 : 기본 기능 구현

- [x] 구입금액 입력시 해당하는 양(1장당 1000원) 로또 발급
- [x] 당첨번호 입력 및, 매칭 후 각 로또별 당첨결과, 수익률 출력

<details>
<summary> 🖼📝 Step 1 결과와 설명 </summary>
<div markdown="1">

### 결과

![Step1 결과](https://i.imgur.com/19IpqSk.jpg)

### 설계 및 고민한 점

#### 설계

```java
public class LottoController {

    public void run() {
        Money money = InputView.inputMoney();
        LottoTickets lottoTickets = LottoTickets.createRandomTickets(money);
        OutputView.printLottoTickets(lottoTickets);

        WinningTicket winningTicket = InputView.inputWinnigTicket();
        LottoGameResults lottoGameResults = new LottoGameResults(money, lottoTickets, winningTicket);

        OutputView.printLottoGameResults(lottoGameResults);
        InputView.close();
    }

}
```

- 최상위 App 클래스의 main 메서드를 통해 LottoController의 `run()` 실행
- LottoController에서, InputView를 통해 구입 금액(Money)을 입력 받고 로또티켓들(LottoTickets)을 구입한다.
- OutputView에서 구입한 로또티켓들 내역을 출력한다.
- 입력을 통해 당첨번호를 입력받고 WinningTickets를 생성한다.
- LottoGameResults를 생성한다. (Money, LottoTickets, WinningTickets)를 인자로 함.
- OutputView에 LottoGameResults를 넘겨, 결과를 출력한다. (통계정보)
- InputView에 close를 요청하여, 자원을 반환하도록 한다.
- run 메서드 호출이 종료되고, App의 main 메서드 호출이 종료됨에 따라 프로그램이 종료된다.


#### 고민한 점

##### 1. ✅ 객체의 역할과 책임 분리
로또 1개의 티켓은 LottoTicket 객체 있고 멤버 변수로 LottoNumbers을 가지고 있었다. LottoNumbers는 List<LottoNumber>를 멤버 변수로 가지고 있었다.
하지만 LottoNumbers가 LottoTicket가 비슷한 역할을 가지고 있었고, LottoNumber 생성하는 행동도 가지고 있었다.
이를 위해 LottoNumbers를 분리하여 LottoTicket으로 합쳤고, LottoNumbers가 가지고 있던 LottoNumber 생성하는 책임을 LottoNumber 자체적으로 책임을 변경했다.

일급 컬렉션을 사용하여 객체의 상태와 행동이 한 곳에 있을 수 있었고 각 `List<>` 의 멤버 변수에 대한 불변성을 가질 수 있었다.

##### 2. ✅ 클래스, 메서드명 고민
현재 `LottoGameResults` 클래스의 맨 처음 이름은 `RewardMachine` 이었다. 하지만 OutputView.printResult(RewardMachine)으로 사용하는 것이 부자연스러웠다.  
따라서 현재의 이름 `LottoGameResults`으로 변경하였다. OutputView.printResult(LottoGameResults)  
그 외에도 메서드와 변수명에 대해 고민을 많이 했다.

##### 3. 당첨 결과의 등수를 enum 으로 정의
당첨 등수를 어떻게 정의할까 고민했다.  
당첨 등수에는 '상금'과 '매치되는 번호의 개수'라는 상태가 필요했고, 외부의 요청에 따른 당첨등수 반환 로직도 필요했다.  
이를 객체로서 정의하자니 당첨등수는 매번 새로 객체를 생성하기보다, 정적 상수로 정의하는 것이 더 자연스럽다는 생각이 들었다.
여러개의 상태를 가지고 있는 비슷한 기능의 상수 인스턴스를 모아두기에는 enum을 사용하는 것이 더 자연스러웠고, enum을 사용하기로 결정했다.


</div>
</details>


# Step2 : 보너스 번호 추가

- [x] 보너스 번호를 입력 및 보너스 추가 추첨 결과 출력

<details>
<summary> 🖼📝 Step 2 결과와 설명 </summary>
<div markdown="1">

### 결과

![Step2결과](https://i.imgur.com/kFpKXbx.jpg)

### 기능 추가 및 리팩토링

#### LottoController

```java
public class LottoController {
    public void run() {
        // (... 생략)
        WinningTicket winningTicket = InputView.inputWinningTicket();
        // (... 생략)
    }
}
```
- LottoController측에서 변경된 코드는 크게 없음.

#### InputView

```java
public class InputView {
    //(... 생략)
    public static WinningTicket inputWinningTicket() {
        Set<LottoNumber> lottoNumbers = inputWinnnigNumbers();
        LottoNumber bonusNumber = inputBonusNumber();
    
        return new WinningTicket(lottoNumbers, bonusNumber);
    }
    //(... 생략)
}
```
- InputWinnnigTicket 메서드 내부적으로, 당첨번호만 입력받던 것을 보너스 번호 입력까지 받도록 하여 WinningTicket을 반환하도록 했다.

#### Rank

```java
public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    FAILED(-1, 0L);
    
    public static Rank of(int matchCount, boolean matchBonus) {
        switch (matchCount) {
            case 6:
                return FIRST;
            case 5:
                return matchBonus ? SECOND : THIRD;
        }
    }
}
```
- if문을 연속적으로 작성하여 들여쓰기 제약을 회피할 수 있었으나, 그렇게 하기엔 코드 길이가 너무 길어지는 문제가 발생했다.
- switch-case 문 및 삼항연산자를 이용해 가독성을 선택하기로 했다.

```java
public enum Rank {

    // (... 중략)
    @Override
    public String toString() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", countOfMatch, reward);
        }
        return String.format("%d개 일치, (%d원)", countOfMatch, reward);
    }
}
```

- Rank의 상태 정보를 OutputView에서 접근하려니 Rank의 여러 getter를 통해 사용하는 불편함이 있었다.
- 이를 위해 toString()을 오버라이딩 하여 해당 내용을 사용하였다.


#### LottoGameResults 

```java
public class LottoGameResults {
    // 변경 전
    private long getTotalReward() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    // 변경 후
    private long getTotalRewards() {
        long totalRewards = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            long reward = entry.getKey().getReward();
            int count = entry.getValue();
            long totalReward = reward * count;
            totalRewards += totalReward;
        }
        return totalRewards;
    }
}
```

- 기존 getTotalReward() 메서드는 스트림으로 구현했다.
- 깔끔해 보이지만 entry.getKey().getReward()나 entry.getValue()에 대한 의미를 파악하기 어려웠다.
- 따라서 for문으로 변경하여 해당 변수명을 할당하여 의미 전달을 높였다.
- 두 사이에 어떤것이 더 좋은지는 ... 잘 모르겠다.

</div>
</details>

---

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fttasjwi%2Fjava-lotto%2Ftree%2Fttasjwi&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)