package package2;

public class Break2 {

  public static void main(String[] args) {
    //중첩 반복 일때 break 범위
    for (char upper = 'A'; upper <= 'Z'; upper++) {
      for (char lower = 'a'; lower <= 'z'; lower++) {
        System.out.println(upper + "-" + lower);
        if (lower == 'g') {
          break;  //break문과 가장 가까운 for문을 벗어남
        }
      }
    }

    //중첩 반복 범위일때 break 범위 - label 사용
    Outter:
    for (char upper = 'A'; upper <= 'Z'; upper++) {
      for (char lower = 'a'; lower <= 'z'; lower++) {
        System.out.println(upper + "-" + lower);
        if (lower == 'g') {
          break Outter;  //Outter라는 라벨이 설정된 반복문을 취소
        }

        if (upper == 'K') {
          break Outter;
        }
      }
    }
    System.out.println("프로그램 실행 종료");
  }

}
