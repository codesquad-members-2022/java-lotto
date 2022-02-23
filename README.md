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


<br>

### 의문점

Lotto class 에서 immutable 한 List<Integer> 로또 넘버 6개를 반환하고 싶었습니다.

초기에는 아래와 같이 코드를 작성을 했는데 모두 동일한 로또 번호가 나오는 상황이 발생했었습니다.

버그를 수정하기 위해서 아래와 같이 코드를 수정했는데 왜 아래와 같은 코드는 잘 작동하고 위와 같이 작성하면 동일한 로또 번호가 반환이 되는지 궁금합니다!

```java
public class Lotto {

  public static final int LOTTO_PRICE = 1000;
  private static final List<Integer> allNumbers = IntStream.rangeClosed(1, 45).boxed()
          .collect(Collectors.toList());

  private List<Integer> numbers;

  public Lotto() {
    create();
  }

  private void create() {
    Collections.shuffle(allNumbers);
    numbers = allNumbers.subList(0, 6);
    Collections.sort(numbers);
  }

  public List<Integer> getNumbers() {
    numbers = List.copyOf(numbers);
    return numbers;
  }
}
```

```java
public class Lotto {

  public static final int LOTTO_PRICE = 1000;
  private static final List<Integer> allNumbers = IntStream.rangeClosed(1, 45).boxed()
          .collect(Collectors.toList());

  private List<Integer> numbers;

  public Lotto() {
    create();
  }

  private void create() {
    Collections.shuffle(allNumbers);
    numbers = allNumbers.subList(0, 6);
    Collections.sort(numbers);
    numbers = List.copyOf(numbers);
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
```


