# java-ladder
2022 마스터즈 백엔드 로또 게임 프로젝트

<br/>

## 로또 3단계 - 수동구매 기능 추가

<br/>

### 이벤트 흐름도
> ![image](https://user-images.githubusercontent.com/82401504/155465075-6588caed-5cda-47e4-814d-572c99165afa.png)

<br/>

### 클래스별 역할과 책임
> #### Main 클래스
> + 로또 게임 실행을 위한 Driver Class입니다.
> 
> #### LottoGame 클래스
> + 로또 게임 실행 엔진 역할을 하며 UI, 로또 번호 생성, 출력 등을 총괄(컨트롤)합니다.
> 
> #### UserInterface 클래스
> + 사용자로부터 입력(로또 구매 금액, 수동 로또 개수 등)을 받습니다.

> #### Validation 클래스
> + 사용자 입력이 올바른지를 검사(로또 번호 중복 검사 등)합니다.
> 
> #### LottoMaker 클래스
> + 사용자로부터 입력받은 데이터에 따라 수동 로또 번호와 자동 로또 번호를 생성하여 제공합니다.
> 
> #### WinningStatistic 클래스
> + 수동 로또 번호와 자동 로또 번호를 토대로 통계를 산출하여 통계 데이터를 제공합니다.

<br/>

### 실행결과
> ![image](https://user-images.githubusercontent.com/82401504/155467702-c05fcc01-27f0-4a23-a8fa-41c0a25de061.png)
> ![image](https://user-images.githubusercontent.com/82401504/155467740-f5e94059-deb7-41db-9036-13a60930e067.png)
