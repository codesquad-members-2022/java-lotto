# java-lotto
마스터즈 멤버스 2022 로또 게임 프로젝트

# 프로젝트 구조

```
└── app
    └── lotto
        ├── Main.java
        ├── domain
        │   ├── LottoAutoMachine.java
        │   ├── LottoCashier.java
        │   ├── LottoGame.java
        │   ├── LottoGameDto.java
        │   ├── LottoPrize.java
        │   ├── LottoResult.java
        │   ├── LottoTicket.java
        │   ├── LottoTicketManager.java
        │   ├── PrizeCounter.java
        │   └── WinningLottoNumbers.java
        ├── validation
        │   └── InputViewValidator.java
        └── view
            ├── InputView.java
            └── OutputView.java

```

프로젝트 구조는 크게 3개의 패키지로 나눌 수 있습니다.<br>

- `domain 패키지`<br>
  **로또 게임**과 밀접한 관련이 있는 클래스들
- `validation 패키지`<br>
  **검증**을 담당하는 클래스들
- `view 패키지`<br>
  **사용자와의 상호작용**을 담당하는 클래스들

# 고려한 사항

## 로또 게임 전체 흐름을 단계별로 분리

`로또 3단계 - 수동구매 기능 추가`의 진행 흐름은 Main 클래스에 정의되어 있습니다.<br>
처음에는 이 진행 흐름은 서로 유기적으로 연결되어있어서 분리가 힘들 것이라고 생각했습니다.<br>
하지만, 자세히 살펴보다보니 분리하여 생각할 수 있는 것 같아 3단계로 분리하여 구현했습니다.<br>

```text
# 1. 고객 주문을 받고, 주문 결과를 보여주는 단계

구입금액을 입력해 주세요.
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

------------------------------------

# 2. 당첨 번호 및 보너스 번호를 정하는 단계

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

------------------------------------

# 3. 당첨 결과를 출력하는 단계

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 XX%입니다.
```

```java
public class Main {

    public static void main(String[] args) {
        // 1. 고객 주문을 받고, 주문 결과를 보여주는 단계
        LottoCashier lottoCashier = LottoCashier.receiveOrderAndCreate();
        lottoCashier.showAllLottoTickets();

        // 2. 당첨 번호 및 보너스 번호를 정하는 단계
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.readWinningNumbersAndCreate();
        System.out.println();

        // 3. 당첨 결과를 출력하는 단계
        LottoGameDto lottoGameDto = new LottoGameDto(lottoCashier.getAllLottoTickets(), winningLottoNumbers);
        LottoGame lottoGame = LottoGame.createWithLottoGameDtoAndAmount(lottoGameDto, lottoCashier.getAmount());
        lottoGame.printLottoGameResult();
    }
}
```

이렇게 3단계로 분리하였고, 각 단계를 맡는 각각의 객체에게 역할과 책임을 부여하였습니다.<br>
그래서 `Main` 에서는 전체 흐름만을 관리하고, 각 객체들은 자신이 맡은 단계에 대해서만 책임을 가지게 됩니다.<br>


## 게임 세부 로직의 추상화

위 내용에서 이어지는 내용입니다.<br>
각 단계에서는 사실 많은 작업들이 일어나지만, 그 단계를 외부에서 볼때 한눈에 알아볼 수 있도록 추상화 하였습니다.<br>
예를 들어 1단계의 경우, `구입금액`, `수동 로또 개수`를 입력받고 검증하여 `자동 로또`와 `수동 로또`를 개수에 맞게 생성합니다.<br>

```java
public class LottoCashier {

    private final LottoTicketManager lottoTicketManager;
    private final int amount;

    private LottoCashier(int amount, int customLottoCount) {
        this.amount = amount;
        this.lottoTicketManager = LottoTicketManager.createWithTotalAmountAndCustomTicketCount(amount, customLottoCount);
    }

    public static LottoCashier receiveOrderAndCreate() {
        // 주문을 받음
        int amount = InputView.readAmount();
        int customLottoCount = InputView.readCustomLottoCount(LottoAutoMachine.getLottoCount(amount));

        // 캐셔 객체를 생성함
        return new LottoCashier(amount, customLottoCount);
    }

    public void showAllLottoTickets() {
        OutputView.printLottoCount(lottoTicketManager.getCustomTicketCount(), lottoTicketManager.getAutoTicketCount());
        OutputView.printAllLottoNumbers(lottoTicketManager.getCustomLottoTickets());
        OutputView.printAllLottoNumbers(lottoTicketManager.getAutoLottoTickets());
        System.out.println();
    }

    // 생략 ...
}

```

이런 로직들이 전체 흐름만 관리해야하는 `Main`에 노출된다면, 역할과 책임이 많아지게 되며 다른 로직으로 시야가 분산될 수 있습니다.<br>
그래서 가능한 작업들을 최소화 하고, 외부에서 봤을때 유추 가능한 이름으로 작업의 이름(메서드명 등)을 지으려고 고민했습니다.<br>

# 주요 클래스 설명

## LottoCashier

- 로또 구입 금액을 입력 받고 수동으로 생성할 로또 개수를 입력 받습니다.
- 입력 받은 수동 개수와 자동 개수를 출력해줍니다.
- `LottoTicketManager` 에게 로또 티켓을 만들어달라고 요청합니다.

## LottoTicketManager

- 구입 금액과 수동 로또 개수를 받아서 자동 로또 티켓, 수동 로또 티켓을 생성합니다.
- 자동 로또는 `LottoAutoMachine` 에게 생성을 요청합니다.

## LottoAutoMachine

- 1부터 45 사이의 랜덤한 숫자 6개로 자동 로또 티켓을 발행합니다.

## WinningLottoNumbers

- 당첨 번호와 보너스 볼을 입력 받습니다.

## LottoGameDto

- 발행한 모든 로또 티켓, 당첨 번호, 보너스 번호의 데이터를 가지고 있는 dto 클래스입니다.

## LottoGame

- `LottoGameDto` 로부터 받은 모든 로또 티켓, 당첨 번호를 `processLottoGame` 메서드를 통해 `PrizeCounter` 에게 몇 등에 당첨됐는지 데이터를 요청합니다.
- `getTotalProfit` 메서드에서 당첨 등수와 당첨된 횟수를 이용하여 총 상금을 계산합니다.
- 총 상금을 로또 구입 금액 기준 몇 퍼센트의 수익이 발생하였는지 계산합니다.
- 당첨 결과와 수익률을 출력합니다.