## 반버논의 Entity

- entity
  - 식별해야하는 대상
- 식별자
  - 전역 식별자
    - 컨택스트 내에서 식별되어야 할 애들, 애그리거트 루트의 식별자
  - 지역 식별자
    - 애그리거트 내에서만 식별되면 되는 것들
- 식벌자 생성 방법
  - 영속성 메커니즘이 식별자 생성
  - 애플리케이션이 식별자 생성
  - 바운디드 컨텍스트가 식별자 생성
- 식별자 생성 시점
  - 빠른 식별자 할당
  - 느린 식별자 할당
- 식별자 안정성
  - 애플리케이션 내에서 식별자는 변경되어선 안된다.
- 엔티티는 행동이 존재한다
  - 객체지향의 설계 기법이 들어가기도 함
  - 역할과 책임을 발견해야한다
- 엔티티의 속성
  - 속성은 발견하는 것이다.
    - 유비쿼터스 랭귀지와 도메인 탐구 과정에서 발견되는 것들로 속성을 구성한다
  - 속성은 데이터베이스와 연결시켜선 안된다.
    - ERD 모델링에 시간을 많이 쏟지 말아야 한다. 그럼 애너믹한 모델이 나온다.
    - 그럼 딱딱한 소프트웨어가 된다.
- 엔티티 생성
  - 새로운 엔티티를 인스턴스화 할 땐 다른 개발자가 생성 방법을 쉽게 인지할 수 있도록 static factory 를 사용하는것도 방법
  - 생성 방법이 복잡하면 factory pattern 을 사용하기도 한다
- 엔티티는 자기 캡슐화가 되어야한다
  - martin fowler 의 self encapsulation
- 엔티티의 유효성 검사
  - 엔티티의 유효성은 비교적 자주 변경되기 때문에 유효성 검사 컴포넌트와 협력한다
