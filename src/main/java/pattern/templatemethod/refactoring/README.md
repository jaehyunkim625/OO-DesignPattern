### Template Method Pattern (스트래티지패턴)

---
: 일정한 프로세스 를 가진 요구사항을 템플릿 메소드 패턴을 이용하여 구현할 수 있습니다
일정한 프로세스가 존재할때, 부모클래스(abstract class)에서 먼저 프로세스안의 각 단계 스텝을 메소드단위(abstract method)로 나누어, 실제 메소드의구현은 상속하는 자식클래스에서 한다.

#### Pros) 
#### 1. 중복코드를 줄일 수 있다.
#### 2. 자식 클래스의 역할을 줄여 핵심 로직의 관리가 용이하다.
#### 3. 좀더 코드를 객체지향적으로 구성할 수 있다.

#### Cons)
#### 추상 메소드가 많아지면서 클래스 관리가 복잡해진다.

---