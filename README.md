# java-lotto
마스터즈 멤버스 2022 로또 게임 프로젝트

- ✍️ from reviewer
  - countNumberOfWinnings() for문 대신 stream으로 개선
  - boolean 함수형 반환 이용한 결과 리턴시 불필요한 조건문을 쓰지 않기
  - 패키지명에 복수형을 잘 쓰지 않습니다. 
  - Lotto 객체가 직접 Ranking 결과값을 주는 방식으로 개선해야 하지 않을까요?
  - 당첨번호 리스트를 보관할 만한 객체를 설계해서 그 객체의 리스트로 전달해주면 더 좋을텐데요?
  - java.util.ArrayList 에만 존재하는 메서드나 로직에 애플리케이션이 강결합되어야 할 특별한 이유가 있을까요?
    그렇지 않다면 항상 List<T> 를 사용하는 것이 좋습니다.
    - [link](https://stackoverflow.com/questions/9852831/polymorphism-why-use-list-list-new-arraylist-instead-of-arraylist-list-n)

<details>
<summary>🌱 step2. 자바 로또 2단계 - 보너스 번호 추가</summary>
- pair programming (hanse, sally)

#### 기능요구사항

- [x] 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.



#### 프로그래밍 요구사항

- [x] enum을 적용해 프로그래밍을 구현한다.

#### 출력 결과

<img src="https://user-images.githubusercontent.com/92699009/155632776-f8de735e-2021-4985-8104-3e79c7f7317c.PNG">

</details>
