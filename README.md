# java-lotto

마스터즈 멤버스 2022 로또 게임 프로젝트(산토리, Shine)

## STEP 03 TO-DO List

- [x] 자동, 수동 composition을 활용하기
  - [x] TicketFactory interface 구현하기
  - [x] customTicket 팩토리
  - [x] randomTicket 팩토리

- [x] 사용자 입력 검증하기
  - [x] 당첨번호에 대한 검증
    - [x] 당첨번호의 개수
    - [x] 당첨번호의 범위
    - [x] 보너스 번호의 검증
  - [x] 수동 로또 개수에 대한 검증
  - [x] 당첨 번호 간 중복 처리
  - [x] 보너스 번호와 당첨 번호 간 중복 처리

- [x] 코드 리뷰 피드백 반영하기
  - [x] `Person` 클래스가 가지고 있는 `LottoTicketSeller` 의존성 없애기
  - [x] `Person` 내부에 불필요한 멤버 변수 제거
  - [x] 6개의 연속된 번호와 보너스 번호를 따로 담는 `WinningNumbers` 객체 만들기
