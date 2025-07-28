package arrayType;

public class Array2D1 {

  public static void main(String[] args) {
    //2차원 배열 선언 할당 저장 => {{행의, 원소, 나열},
    //                        {행의, 원소, 나열}}

    int[][] score =
        {{100, 100, 100},
            {20, 20, 20}};

    //다차원 배열 원소의 접근 : 배열변수[행idx][열idx] -> idx는 0부터 시작
    System.out.println(score[1][1]);

    for (int i = 0; i < score.length; i++) {
      for (int j = 0; j < score[0].length; j++) {
        System.out.print(score[i][j] + "\t");
      }
      System.out.println();
    }
  }

}
