# Repository

안녕하세요 Joon 님! 이 미천한 글에 댓글을 달아주심에 너무나도 영광스럽습니다.

### EventHandler 는 domain logic 인가?

사실 이 부분은 저도 계속해서 헷갈리는 부분입니다.

저도 이전에 eventHandler 를 구현하여 작업을 했던 적이 있었고 eventHandler 를 새로운 layer 처럼 사용했기 때문에 이러한 고민을 하는게 아닐까 합니다.
eventHandler 를 이용해서 application layer 를 없애고 handler 자체를 transcational boundary 로 사용했던 경험이 있어서 application layer 가 아닐까? 하고 표현이 되었네요

제 경우에 있어서, eventHandler layer 에서는 useCase 를 호출하고 orchestration 하도록 사용했었거든요

###

만약 비즈니스 논리가 복잡한 구조라면 어떨까요?
우려의 시작은 다음과 같았습니다.

현재는 campaign 의 상태를 변경하는 비즈니스 로직이 switchOn() 만 존재하지만 campaign 이 다른 A 와 협력한다고 가정해보겠습니다.

A.b() 그리고 B.c() 를 순차적으로 호출해야 할 때 modifier 의 수가 늘어나지 않을까? 라는 생각을 하게 되었습니다.

modifier 가 늘어나면 저라면 이런 선택을 할 수 있을것 같습니다.

A.b() 와 B.c() 를 하나의 연산으로 묶는 AB.bc() 를 만들 수 있을것 같습니다.

그럼 하나의 modifier 로도 실행 흐름을 결정할 수 있을테니까요

여기서 생각해볼 것이, 앞으로 원자성을 지켜야하는 update 를 호출하는 모든 곳에서는 infrastructure 의 연산을 지원하기 위해서 어떠한 규칙이 생기는 것을 의미하는데, 이 규칙이 비즈니스에 의해서 결정된 것이 아니라 인프라 구성요소에 의해서 결정된 것이라는 생각이 듭니다.
