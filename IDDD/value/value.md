# Value

- 도메인 모델에 필수적인 구성요소
  - 모든 도메인 객체가 엔티티라면 모두가 기본키를 가져야하는둥 뭐 많이 복잡해짐
  - 값은 그냥 인스턴스 생성 후에 잊어버려도 됨, 필요할 때만 쓰고 필요없으면 버려도될만큼 가벼운 존재
- 도메인 모델의 특성만 기술한다면 이는 값객체
- 식별해야할 필요가 없다
- 값 객체의 특징
  - 도메인 내의 대상을 기술하고, 측정하고, 수량화한다
  - 불변셩이 유지될 수 있다.
  - 다른 값과 value equality(등가성) 를 통해 비교할 수 있다
  - 협력자에게 side-effect-free behavior 를 제공한다

## 측정, 수량화, 설명

- 값 객체가 잘 하는 것임

## 개념적 전체

- 값 객체는 하나 이상의 개별적 특성을 속성으로 가질 수 있음
  - 이들은 모두 연관되어있어야 함

```java
// 5,000,000₩ 개념적 하나, 두 특성을 하나로 봐야 하나가 됨
class Money {
  long value; // 5,000,000
  String currency; // 원, 달러
}
```

## 불변성

- 값인 객체는 생성되면 변경될 수 없음
  - setter 와 같은 메서드는 동작해선 안됨 (side effect free)
  - 프로그램을 예측 가능하도록 하는 방법
  - 만약 값에 대해서 연속성을 가져야 한다면 entity 로 설계하는게 맞음

## 값 등가성

- 값이 비교가 가능해야하고, equals 동작해야함
  - 만약 값객체의 타입과 특성(값)이 동일하다면 동일한 객체로 간주해야함

## 중요: 값을 사용하면 책임을 덜 수 있다

- 협력을 통해서 엔티티에게 과중되는 책임을 덜자
