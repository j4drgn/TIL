package arrayType;

public class Array2D {

  public static void main(String[] args) {
    // 다차원 배열 : 선언 및 생성
    // int[][] score : 2차원 배열 선언
    // score = new int[행수][열수]

    int[][] score = new int[5][3];

    //배열 크기.length
    System.out.println(score.length); //행수
    System.out.println(score[0].length); //열수
    System.out.println(score[1].length); //열수
    System.out.println(score[2].length); //열수
    System.out.println(score[3].length); //열수
    System.out.println(score[4].length); //열수

    //배열명과 각 행의 접근
    System.out.println(score); //행수
    System.out.println(score[0]); //열수
    System.out.println(score[1]); //열수
    System.out.println(score[2]); //열수
    System.out.println(score[3]); //열수
    System.out.println(score[4]);
  }

}
