# aggregate

> entity 와 value 를 aggregate 로 모으고 각각에 대해 경계를 정의한다.
> 한 entity 를 골라 aggregate 의 루트로 만들고 aggregate 경계 내부의 객체에 대해서는 루트를 거쳐 접근할 수 있게 하라.
> aggregate 밖의 객체는 루트만 참조할 수 있게 하라
> 루그를 경유하지 않고는 aggregate 의 내부를 변경할 수 없다

- 데이터 변경의 단위로 다루는 연관 객체의 묶음
  - entity 와 value 를 aggregate 로 모으고 각각에 대해 경계를 정의한다.
- root 와 boundary 가 존재한다
  - root : 단 하나의 엔티티
    - 불변식을 검사할 책임
  - boundary : 경계 밖의 참조는 있어서는 안됨
    - 경계 안의 객체는 다른 aggregate 의 루트만 참조 가능

## 식별성

- root entity 는 전역 식별성을 가진다
- 일반 entity 는 지역 식별성을 가진다

## 불변식

- 데이터가 변경될 때마다 유지돼야하는 일관성 규칙
- root entity 가 불변식을 검사하는 책임이 있다
