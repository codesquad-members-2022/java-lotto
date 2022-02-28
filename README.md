# java-lotto

마스터즈 멤버스 2022 로또 게임 프로젝트

___

## 1단계

> 요구사항

- [x] indent(인덴트, 들여쓰기) depth를 1단계로 구현한다.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- [x] else를 사용하지 마라.
- [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] ArrayList를 사용해서 구현한다.

## 2단계

> 요구사항

- [x] enum을 적용해 프로그래밍을 구현한다.

## 3단계

> 요구사항

- 예외가 발생하는 부분에 대해 자바 Exception을 적용해 예외처리한다.
- 사용자가 입력한 값에 대한 예외 처리를 철저히 한다.
- 상속과 인터페이스를 통해 구현을 간결히 할 수 없는지 고민해 본다.
    - 상속(inheritance)과 구현(implementation), 합성(composition)에 대해 고민해 본다.

## 2단계 Dion리뷰에 따른 리팩토링

- [x] getResult()와 matchRank()가 있는 목적은 무엇인가요? 게임을 실행하기 위한 목적에 부합하나요? 아니라면 분리하는 것이 맞습니다.
  - `LottoMatcher Class`로 분리했습니다.
- [x] Lucky는 조금 애매한 네이밍이네요. -> `WinningNumber`로 변경 했습니다.
- [x] 디미터 법칙 LottoGame, 73라인
    - 객체지향에서 중요하게 다뤄지는 법칙중 하나가 데메테르(디미터) 법칙인데요. 이것에 대해선 학습해보시구요. 예를 들자면, lotto.haveBonusNumber(
      bonusNumber) 같은식으로 작성되는게 훨씬 더 읽기 좋지 않나요?
    - 반영 완료
- [x] Lotto에서 Integer조차 일급객체로 생성.
    - Number에 대한 객체를 만들어보는건 어떨까요?
    - 그런다음 Numbers에 대한 객체를 만들어주면 좋을 것 같아요. 이를 일급 컬렉션이라고 부릅니다.
    - `LottoNumber` class를 만들어 보았습니다.

- [x] 왜 copyOf를 써주셨나요?
    - return List.copyOf(luckyNumbers);
    - 불변한 luckyNumbers를 주고 싶어서 copyOf()를 썻었습니다.
    - 현재는 Collections.unmodifiableList() 로 변경했습니다.

- [x] Input 이나 Output도 충분히 객체로 만들어 줄 수 있습니다.
    - 객체로 변경해보았습니다.
- [x] Rank 에게 직접 물어보죠. 너 2등이니?
  - Rank enum class에 isSecond() 메소드를 추가했습니다.
