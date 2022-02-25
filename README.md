# java-lotto
마스터즈 멤버스 2022 로또 게임 프로젝트

# 프로젝트 구조

# 고려한 사항

# 주요 로직

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