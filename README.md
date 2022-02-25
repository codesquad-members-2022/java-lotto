# java-lotto
마스터즈 멤버스 2022 로또 게임 프로젝트
- - -

## 페어정보
- Tany
- Ader
- - -

## 프로젝트 전체 흐름
- Application에서 LottoGame의 start() 메소드를 통해 실행됩니다.
- 로또 구입과정은 사용자에게 구입금액을 입력받고 LottoStore에 purchase를 요청합니다.
- LottoStore가 금액에 따른 로또 장수를 판단해 해당하는 장수만큼 Lotto 리스트를 만들어 LottoPaper에 담아줍니다.
- 이후 LottoPaper를 출력하며 당첨번호를 입력받습니다.
- 당첨번호를 LottoPaper에게 judgeWinning() 메소드의 파라미터로 넘겨주며 당첨결과를 리턴받습니다.
- 리턴받은 결과를 통해 당첨정보와 수익률을 출력합니다.

## Mission1 - 기본기능구현
### 기능요구사항
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 당첨 번호를 입력받아서 수익률을 출력한다.
- [x] 기대 수익은 동작 예시를 참고하자.

### 결과출력
> ![2_결과](https://user-images.githubusercontent.com/29879110/155084236-a78af722-2c43-4325-9244-6b0db804d071.JPG)
<br>

### 테스트출력
> ![1_테스트결과](https://user-images.githubusercontent.com/29879110/155083466-bb4a9962-af05-4f6d-9179-f9368c7b5d77.JPG)
- - -
<br>

## Mission2 - 보너스번호 추가
### 기능요구사항
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구사항
- [x] enum을 적용해 프로그래밍을 구현한다.

### 결과출력
> ![1_결과출력](https://user-images.githubusercontent.com/29879110/155278106-3f5717ed-1885-43ba-a2ec-dcb4f10c6c4a.JPG)
<br>
