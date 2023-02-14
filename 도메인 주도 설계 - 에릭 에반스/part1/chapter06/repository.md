# Repository

안녕하세요 Joon 님!!!!!!!! 이 미천한 글에 댓글을 달아주심에 너무나도 영광스럽고 부끄럽네요.
제가 쓴 글이 joon 님이 고민하신 내용에 비해서 너무나도 성의없고 짧은 글이라서, 또 의견을 남겨주심에 죄송함을 느끼고있어요
(아티클 리뷰는 제가 요즘 하고있는 1일 챌린지의 일환으로 그냥 하루에 채워야하는 todo 중에 하나 쯤으로 여겼거든요..)

좋은 의견과 해설에 더불어서 제 생각을 저도 풀어서 공유해볼게요 :)

앞선 Joon 님의 답글에 대해서 몇가지 제 생각을 적어보면,

### 도메인 논리가 repository 구현체로 이동한다

저는 도메인 논리가 복잡한 구조라면 어떨까? 라는 생각이 우려의 시작이었어요.

현재는 campaign 의 상태를 변경하는 비즈니스 로직이 switchOn() 만 존재하지만, eventHandler 가 A 그리고 B 와도 협력한다고 가정해볼게요.

1. campaign.handle(event)
2. A.doA()
3. B.doB();

A.doA() 그리고 B.doB() 를 순차적으로 호출해야하는 상황이라면, modifier 하나로 해결할 수 있을까? 즉 여러 케이스에 대해서도 general 하게 사용할 수 있을까? 라는 생각을 하게 되었습니다.

그럼 repository.update() 의 인자가 계속 늘어나지 않을까? 라는 걱정이었어요. 물론 그렇게 하지 않을 수 있죠, A.a()와 B.b()를 합쳐서 AB.ab() 로 하나의 연산으로 묶을 수도 있을것 같아요. 그럼 하나의 Consumer 로도 실행 흐름을 결정할 수 있을테니까요

하지만 저는 또다른 우려가 있었습니다.

앞으로 원자성을 지켜야하는 연산에 대해서는 infrastructure 의 어떠한 규칙 (실행 흐름의 제어권을 넘겨주었다.)이 생기는 것을 의미하는데, 이 규칙이 비즈니스에 의해서 결정된 것이 아니라 인프라의 제약에 의해서 결정된 것이라는 생각이 들었어요

결국 저는 version 이라는 속성을 도메인이 갖도록 포기하고 유연성을 얻는다고 생각했었어요.

(이러한 내용들이 처음 글을 쓸 때부터 포함시켜야 했었네요..)

### EventHandler 는 domain logic 인가?

사실 이 부분은 저도 계속해서 헷갈리는 부분입니다.

저도 이전에 eventHandler 를 구현하여 업무를 진행했던 적이 있었고 eventHandler 를 새로운 layer 처럼 사용했기 때문에 이러한 고민을 하는게 아닐까 합니다.

eventHandler 를 이용해서 application layer 를 없애고 handler 자체를 transcational boundary 로 사용했던 경험이 있어서 application layer 가 아닐까? 하고 표현이 되었네요

제 경우에 있어서, eventHandler layer 에서는 useCase 를 호출하거나 도메인 객체들을 orchestration 하도록 사용했었거든요.

또 제가 봤던 cqrs-journey-guide 의 eventHandling 예제코드는 application layer 처럼 동작하고 있다고 보여져서 더 그런것 같아요

https://github.com/dhslrl321/cqrs-journey-guide-korean/blob/master/part02-references/reference04/04.%20Event%20와%20Event%20handlers.md

다시 joon 님의 이야기로 돌아가면, 저는 domain service 라는 것은 어떠한 domain 에게도 책임을 부여할 수 없을 때, 단순한 행위에 대한 책임을 가진 객체를 domain service 로 생각하고 있어요.

하지만 EventHandler 와 같이 repository 와 협력하고, domain 을 호출하는 것은 domain 객체들을 orchestration 하는 application layer 라고 저는 조심스럽게 생각해요 :)

---

제 나름의 논리를 결국 정리해보면 이런것 같아요.

제가 좋아하는 책에서 나오는 내용인, '설계는 트레이드오프의 산물이다' 로 미루어보면 저는 version 정보를 도메인에 침투시키는 선택을 통해서 인프라에 결합되지 않는 트레이드오프를 한것 이라고 봐주셨으면 좋겠습니다.

저도 spring 이 도메인 로직에 침투하는것이 domain 세상에서 어떠한 허들로 작용할지 모른다는 것을 알고있고 스스로 경계하는 부분이에요.

---

끝으로, 제 생각에 대해서 관심가져주시고 이야기를 터주심에 감사함을 느끼고있고 관련하여 더 많은 대화가 오갔으면 좋겠습니다. 다시 한번 감사드립니다 🙇‍♂️
