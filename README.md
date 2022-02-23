# java-lotto
마스터즈 멤버스 2022 로또 게임 프로젝트

## 로또게임 설계구조
![image](https://user-images.githubusercontent.com/75709176/155289769-0f21b86a-9473-483c-98c5-60ee9c5dbace.png)

LottoManager를 관리하는 상위 클래스 LottoController를 만든다. Controller는 사용자에게 입력값을 받고, 출력, 매니저에게 일을 시키는 역할을 한다.

LottoManager는 Controller가 전달해 준 값을 받아서 일하는 역할을 한다.

LottoIssuer에게 로또 게임 수를 전달하여 list(로또 티켓)을 만들어 달라 메시지를 보내고,
이 LottoIssuer가 생산한 list를 LottoTicket에 전달하여, LottoTicket을 만들어 반환한다.

LottoTicket과 Lotto는 데이터만을 가진 일급 컬렉션으로 만든다.
기존에 LottoGames와, Lotto에서 하던 계산 로직을 LottoIssuer가 담당하는 것.

## 1단계 기능요구사항
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 당첨 번호를 입력받아서 수익률을 출력한다.
- [x] 기대 수익은 동작 예시를 참고하자.

## 2단계 요구사항
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다
- [x] enum을 적용해 프로그래밍을 구현한다
