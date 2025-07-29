package oopClass.sec05;

public class Tv {
    // 필드 선언
    private boolean power;     // 전원 상태
    private int channel;       // 채널
    private int volume;        // 볼륨
    private String brand;      // 브랜드
    private int size;          // 화면 크기(인치)
    
    // 기본 생성자
    public Tv() {
        this.power = false;
        this.channel = 1;
        this.volume = 10;
        this.brand = "삼성";
        this.size = 55;
    }
    
    // 매개변수가 있는 생성자
    public Tv(String brand, int size) {
        this.power = false;
        this.channel = 1;
        this.volume = 10;
        this.brand = brand;
        this.size = size;
    }
    
    // 전원 켜기/끄기
    public void powerOnOff() {
        this.power = !this.power;
        if(this.power) {
            System.out.println("TV가 켜졌습니다.");
        } else {
            System.out.println("TV가 꺼졌습니다.");
        }
    }
    
    // 채널 올리기
    public void channelUp() {
        if(!this.power) {
            System.out.println("TV가 꺼져 있습니다.");
            return;
        }
        
        this.channel++;
        System.out.println("현재 채널: " + this.channel);
    }
    
    // 채널 내리기
    public void channelDown() {
        if(!this.power) {
            System.out.println("TV가 꺼져 있습니다.");
            return;
        }
        
        if(this.channel > 1) {
            this.channel--;
        } else {
            this.channel = 999; // 마지막 채널로 순환
        }
        System.out.println("현재 채널: " + this.channel);
    }
    
    // 채널 변경
    public void setChannel(int channel) {
        if(!this.power) {
            System.out.println("TV가 꺼져 있습니다.");
            return;
        }
        
        if(channel >= 1 && channel <= 999) {
            this.channel = channel;
            System.out.println("채널이 " + this.channel + "번으로 변경되었습니다.");
        } else {
            System.out.println("유효하지 않은 채널입니다.");
        }
    }
    
    // 볼륨 올리기
    public void volumeUp() {
        if(!this.power) {
            System.out.println("TV가 꺼져 있습니다.");
            return;
        }
        
        if(this.volume < 100) {
            this.volume++;
            System.out.println("현재 볼륨: " + this.volume);
        } else {
            System.out.println("최대 볼륨입니다.");
        }
    }
    
    // 볼륨 내리기
    public void volumeDown() {
        if(!this.power) {
            System.out.println("TV가 꺼져 있습니다.");
            return;
        }
        
        if(this.volume > 0) {
            this.volume--;
            System.out.println("현재 볼륨: " + this.volume);
        } else {
            System.out.println("최소 볼륨입니다.");
        }
    }
    
    // TV 정보 출력
    public void showInfo() {
        System.out.println("\n===== TV 정보 =====");
        System.out.println("브랜드: " + this.brand);
        System.out.println("크기: " + this.size + "인치");
        System.out.println("전원 상태: " + (this.power ? "켜짐" : "꺼짐"));
        if(this.power) {
            System.out.println("현재 채널: " + this.channel);
            System.out.println("현재 볼륨: " + this.volume);
        }
    }
}
