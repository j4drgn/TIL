# 전략 패턴 (Strategy Pattern)

이 디렉토리는 전략 패턴을 활용한 게임 캐릭터 및 장비 시스템 구현 예제를 포함하고 있습니다.

## 전략 패턴이란?

전략 패턴은 알고리즘군을 정의하고 각각을 캡슐화하여 상호 교환 가능하게 만드는 디자인 패턴입니다. 이 패턴을 사용하면 알고리즘을 사용하는 클라이언트와 독립적으로 알고리즘을 변경할 수 있습니다.

## 주요 구성 요소

### 1. 전략 인터페이스 (DamageWeight.java)

다양한 전략을 정의하는 인터페이스입니다.

```java
public interface DamageWeight {
    int calAttackWeight(int damage);
    int calDefenceWeight(int damage);
}
```

이 인터페이스는 공격 가중치와 방어 가중치를 계산하는 두 가지 메서드를 정의합니다.

### 2. 구체적인 전략 (Equipment.java)

전략 인터페이스를 구현하는 구체적인 클래스입니다.

```java
public class Equipment implements DamageWeight {
    private String name;
    private int atk;
    private int def;
    private Slot slot;
    private String effect;
    private Random random = new Random();
    
    // 생성자
    public Equipment(String name, int atk, int def, Slot slot, String effect) {
        super();
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.slot = slot;
        this.effect = effect;
    }
    
    // 공격 가중치 계산 전략 구현
    @Override
    public int calAttackWeight(int damage) {
        return random.nextInt(damage + atk, damage + atk * 2);
    }
    
    // 방어 가중치 계산 전략 구현
    @Override
    public int calDefenceWeight(int damage) {
        return damage - (damage * def/100);
    }
    
    // 기타 메서드
    // ...
}
```

### 3. 컨텍스트 (Player.java)

전략을 사용하는 클래스입니다.

```java
public class Player extends Character {
    private Random random = new Random();
    private Equipments equipments = new Equipments();
    
    // 생성자
    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }
    
    // 공격 메서드 - 장착된 장비(전략)를 사용하여 공격 가중치 계산
    @Override
    public void attack(Character target) {
        int damage = random.nextInt(atk, atk * 3);
        
        System.out.println("[" + name + "] 공격!");
        for(Equipment e : equipments.findAll()) {
            damage = e.calAttackWeight(damage);
        }
        
        // 무기 슬롯의 장비 효과 출력
        Optional<Equipment> optional = equipments.findBySlot(Slot.WEAPON);
        if(optional.isPresent()) {
            System.out.println(optional.get().getEffect()); 
        }
        
        target.takeDamage(damage);
    }
    
    // 피해 메서드 - 장착된 장비(전략)를 사용하여 방어 가중치 계산
    @Override
    public void takeDamage(int damage) {
        for(Equipment e : equipments.findAll()) {
            damage = e.calDefenceWeight(damage);
        }
        System.out.println("[ Damage ] :" + damage);
        
        this.currentHp -= damage;
        this.currentHp = Math.max(currentHp, 0);
    }
    
    // 장비 장착 메서드 - 새로운 전략 설정
    public void equip(Equipment equipment) {
        equipments.equip(equipment);
    }
}
```

### 4. 장비 관리 (Equipments.java)

장비(전략) 객체들을 관리하는 1급 컬렉션입니다.

### 5. 장비 데이터 (EquipmentData.java)

게임 내 모든 장비 데이터를 정의하는 열거형입니다.

### 6. 메인 실행 클래스 (Run.java)

게임 시스템을 실행하고 전략 패턴을 시연하는 클래스입니다.

```java
public class Run {
    public static void main(String[] args) {
        // 플레이어와 몬스터 생성
        Player player = new Player("지존짱짱맨", 200, 30, 10);
        Monster monster = new Monster("슬라임", 200, 30, 10);
        
        // 게임 진행
        while(true) {
            // 게임 종료 조건 확인
            
            // 이벤트 발생 - 새로운 장비(전략) 획득
            if(player.getCurrentHp() < 150) {
                EquipmentData[] datas = EquipmentData.values();
                int index = random.nextInt(0, datas.length);
                
                if(eventFlg) {
                    // 전략을 생성
                    // 전략을 주입, Dependency Injection, Inversion of Control
                    Equipment equipment = datas[index].create();
                    System.out.println(equipment.getName() + " 발견했습니다.");
                    player.equip(datas[index].create());
                    eventFlg = false;
                }
            }
            
            // 전투 진행
            player.attack(monster);
            monster.attack(player);
            
            // 상태 출력
            // ...
        }
    }
}
```

## 전략 패턴의 장점

1. **알고리즘 교체 용이성**: 런타임에 알고리즘(전략)을 교체할 수 있습니다.
2. **코드 재사용**: 동일한 전략을 여러 컨텍스트에서 재사용할 수 있습니다.
3. **캡슐화**: 알고리즘의 구현 세부 사항을 캡슐화하여 클라이언트 코드와 분리합니다.
4. **확장성**: 새로운 전략을 추가하기 쉽습니다.

## 템플릿 메서드 패턴과의 차이점

1. **구현 방식**:
   - 템플릿 메서드 패턴: 상속을 통한 구현
   - 전략 패턴: 합성(Composition)을 통한 구현

2. **알고리즘 변경 시점**:
   - 템플릿 메서드 패턴: 컴파일 시점에 결정 (Early binding, Static binding)
   - 전략 패턴: 실행 시점에 결정 (Lazy binding, Dynamic binding)

3. **유연성**:
   - 템플릿 메서드 패턴: 상속 구조로 인한 제약
   - 전략 패턴: 객체 조합을 통한 높은 유연성

## 주요 개념

### 1. 의존성 주입 (Dependency Injection)

Run.java에서 Player 객체에 Equipment 객체(전략)를 주입하는 방식으로 구현됩니다.

```java
Equipment equipment = datas[index].create();
player.equip(equipment);  // 전략 주입
```

### 2. 제어의 역전 (Inversion of Control)

Player 클래스가 직접 Equipment 객체를 생성하지 않고, 외부에서 생성된 객체를 주입받아 사용합니다.

### 3. Optional 활용

Player 클래스에서 장비 조회 시 Optional을 활용하여 null 처리를 안전하게 합니다.

```java
Optional<Equipment> optional = equipments.findBySlot(Slot.WEAPON);
if(optional.isPresent()) {
    System.out.println(optional.get().getEffect()); 
}
```

## 개선 사항

1. **다양한 전략 구현**: 더 다양한 장비 효과와 전략 추가
2. **전략 조합**: 여러 전략을 조합하여 복합 효과 구현
3. **전략 교체 메커니즘 강화**: 상황에 따른 자동 전략 교체 기능

## 학습 포인트

1. 전략 패턴의 구조와 활용 방법
2. 인터페이스와 합성을 통한 코드 재사용
3. 실행 시점에 알고리즘을 동적으로 교체하는 방법
4. 의존성 주입과 제어의 역전 개념 이해
