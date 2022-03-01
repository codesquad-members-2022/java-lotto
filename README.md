# java-lotto

마스터즈 멤버스 2022 로또 게임 프로젝트

## 1단계 - 기본 기능 구현

- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  - 로또 1장의 가격은 1000원이다.
- [x] 당첨 번호를 입력받아서 수익률을 출력한다.
  - 기대 수익은 동작 예시를 참고하자.
- [x] ArrayList를 사용해서 구현한다.

## 2단계 - 보너스 번호 추가

- [x] 2등을 위해 추가 번호를 하나 더 추첨한 다. 당첨 통계에 2등도 추가해야 한다.
- [x] enum을 적용해 프로그래밍을 구현한다.

## 3단계 - 수동구매 기능 추가

- [x] 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
- [x] 예외가 발생하는 부분에 대해 자바 Exception을 적용해 예외처리한다.
- [x] 사용자가 입력한 값에 대한 예외 처리를 철저히 한다.
- [x] 상속과 인터페이스를 통해 구현을 간결히 할 수 없는지 고민해 본다.

## 4단계 - 웹 UI 적용

- [ ] 스프링은 사용하지 않는다.

### 구현과정

- dependency: com.sparkjava:spark-core:2.9.3
  - `SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder"` 에러 발생
  - 서버 자체는 띄워지나 `Defaulting to no-operation (NOP) logger implementation` 메시지가 출력된다
- dependency: org.slf4j:slf4j-simple:1.7.36
  - `SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder"` 에러가 해결된다
  - 참고: spark-core 2.9.3 버전에 포함된 SLF4J는 slf4j-api 1.7.25 버전이다. 
  