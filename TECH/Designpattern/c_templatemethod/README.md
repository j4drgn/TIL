# 템플릿 메서드 패턴 (Template Method Pattern)

이 디렉토리는 템플릿 메서드 패턴을 활용한 게임 캐릭터 시스템 구현 예제를 포함하고 있습니다.

## 템플릿 메서드 패턴이란?

템플릿 메서드 패턴은 알고리즘의 구조를 메서드에 정의하고, 하위 클래스에서 알고리즘 구조의 변경 없이 알고리즘의 특정 단계를 재정의할 수 있게 하는 패턴입니다. 이 패턴은 코드 재사용과 확장성을 높이는 데 유용합니다.

## 주요 구성 요소

### Character.java (추상 클래스)

템플릿 메서드 패턴의 핵심 클래스로, 알고리즘의 골격을 정의합니다.

- **주요 특징**:
  - 공통 속성(name, hp, atk, def) 정의
  - 템플릿 메서드(attack, takeDamage)를 구현
  - 하위 클래스에서 구현해야 할 추상 메서드(calAttackWeight, calDefenseWeight) 선언

```java
public abstract class Character {
    protected String name;
    protected int hp;
    protected int currentHp;
    protected int atk;
    protected int def;

    // 템플릿 메서드: 공격 알고리즘의 구조 정의
    public void attack(Character target) {
        System.out.println("[" + name + "] 공격!");
        int damage = calAttackWeight();  // 하위 클래스에서 구현할 부분
        target.takeDamage(damage);
    }

    // 템플릿 메서드: 방어 알고리즘의 구조 정의
    public void takeDamage(int damage) {
        damage = calDefenseWeight(damage);  // 하위 클래스에서 구현할 부분
        System.out.println("[ Damage ] :" + damage);
        this.currentHp -= damage;
        this.currentHp = Math.max(currentHp, 0);
    }

    // 하위 클래스에서 구현해야 하는 추상 메서드
    protected abstract int calDefenseWeight(int damage);
    protected abstract int calAttackWeight();

    // 기타 메서드
    // ...
}
```

### Monster.java (구체 클래스)

Character 추상 클래스를 상속받아 몬스터 캐릭터의 특성을 구현합니다.

- **주요 특징**:
  - 몬스터 특유의 공격 가중치 계산 구현 (atk ~ atk \* 2)
  - 몬스터 특유의 방어 가중치 계산 구현

```java
public class Monster extends Character {
    // 생성자
    public Monster(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    // 몬스터의 방어 가중치 계산 구현
    @Override
    protected int calDefenseWeight(int damage) {
        return damage - (damage * def/100);
    }

    // 몬스터의 공격 가중치 계산 구현 (atk ~ atk * 2)
    @Override
    protected int calAttackWeight() {
        Random random = new Random();
        return random.nextInt(atk, atk * 2);
    }
}
```

### Thief.java (구체 클래스)

Character 추상 클래스를 상속받아 도적 캐릭터의 특성을 구현합니다.

- **주요 특징**:
  - 도적 특유의 공격 가중치 계산 구현 (atk/2 ~ atk \* 5)
  - 도적 특유의 방어 가중치 계산 구현 (50% 확률로 공격 회피)

```java
public class Thief extends Character {
    private Random random = new Random();

    // 생성자
    public Thief(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    // 도적의 방어 가중치 계산 구현 (50% 확률로 공격 회피)
    @Override
    protected int calDefenseWeight(int damage) {
        if(random.nextInt(0, 2) == 0) {
            System.out.println("[Thief 특성 발동]  공격이 빗나갑니다.");
            return 0;
        }
        return damage - (damage * def/100);
    }

    // 도적의 공격 가중치 계산 구현 (atk/2 ~ atk * 5)
    @Override
    protected int calAttackWeight() {
        return random.nextInt(atk/2, atk * 5);
    }
}
```

### Run.java (실행 클래스)

게임 시스템을 실행하는 메인 클래스입니다.

- **주요 특징**:
  - 캐릭터 생성 및 전투 시뮬레이션
  - 다형성을 활용한 캐릭터 상호작용

```java
public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Character player = new Thief("지존짱짱맨", 200, 30, 10);
        Character monster = new Monster("슬라임", 200, 30, 10);

        System.out.println("[전투이벤트] " + monster.getName() + " 등장!");

        // 전투 루프
        while(true) {
            // 승패 확인
            if(player.isDead() || monster.isDead()) {
                // 게임 종료 처리
                break;
            }

            // 턴 진행
            player.attack(monster);
            monster.attack(player);

            // 상태 출력
            System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
            System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
        }
    }
}
```

## 캐릭터 특성 정리

각 캐릭터 클래스는 고유한 특성을 가지고 있습니다:

1. **Player 캐릭터 (미구현)**

   - 공격 가중치: atk/2 ~ atk \* 3

2. **Monster 캐릭터**

   - 공격 가중치: atk ~ atk \* 2
   - 방어 가중치: damage - (damage \* def/100)

3. **Warrior 캐릭터 (미구현)**

   - 공격 가중치: atk ~ atk \* 4
   - 방어 가중치: damage의 30%를 감소시킨 후 방어 가중치 적용

4. **Thief 캐릭터**
   - 공격 가중치: atk/2 ~ atk \* 5
   - 방어 특성: 50% 확률로 적의 공격을 무효화

## 템플릿 메서드 패턴의 장점

1. **코드 재사용**: 공통 알고리즘 구조를 상위 클래스에 정의하여 코드 중복 방지
2. **확장성**: 기존 코드 수정 없이 새로운 캐릭터 클래스 추가 가능
3. **일관성**: 모든 캐릭터가 동일한 공격/방어 알고리즘 구조를 따름
4. **캡슐화**: 각 캐릭터의 특성을 해당 클래스 내부에 캡슐화

## 개선 사항

1. **Player와 Warrior 클래스 구현**: 현재 빈 클래스로 남아있는 Player와 Warrior 클래스를 완성하여 다양한 캐릭터 타입 지원
2. **추가 캐릭터 타입**: Mage, Archer 등 새로운 캐릭터 타입 추가
3. **전투 시스템 강화**: 스킬, 아이템 사용 등의 기능 추가
4. **상태 효과**: 독, 화상 등의 상태 효과 구현

## 학습 포인트

1. 템플릿 메서드 패턴의 구조와 활용 방법
2. 추상 클래스와 추상 메서드를 통한 공통 알고리즘 정의
3. 다형성을 활용한 객체 상호작용
4. 상속을 통한 코드 재사용과 확장
