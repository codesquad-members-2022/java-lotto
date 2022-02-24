# java-lotto
마스터즈 멤버스 2022 로또 게임 프로젝트
## TODO - refactoring
- [x] LottoIssuer -> lottoTicket 부활 + Issuer 역할 위임
- [x] LottoAmount 와 LottoQuantity 이름 변경 및 유효성 메소드 이름 변경
- [x] LottoCashier 의 역할을 Controller 가 가져가게 변경
- [x] Controller 이름을 LottoGame 으로 변경

## 기능 요구 사항
- [x] 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- [x] 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
### 프로그래밍 요구 사항
- [ ] 예외가 발생하는 부분에 대해 자바 Exception 을 적용해 예외처리한다.
- [ ] 사용자가 입력한 값에 대한 예외 처리를 철저히 한다.
- [ ] 상속과 인터페이스를 통해 구현을 간결히 할 수 없는지 고민해 본다.

## 3단계 설계
- [ ] InputView 클래스에서 입력 값 검증하기 -> LottoSheet
- [x] InputView 클래스에서 수동 로또 번호를 List<String> 으로 처리함

## TODO 3단계
- [ ] WinningNumber 와 LottoSheet 는 같은 역할을 가지므로 상속? 합성?
- [ ] getter, setter 지양하자
- [ ] 지역변수가 필요한지 생각해보기
- [ ] 테스트 코드 작성하기
- [ ] LottoCashier가 필요한지 확인
