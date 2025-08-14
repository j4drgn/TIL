package jdbc.sec06;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMainMenu {

    public static void main(String[] args) {
        // DAO 객체 생성 및 변수 선언
        StudentDAO dao = new StudentDAO(); // 객체 생성시 자동으로 DB 연결
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentDTO> stdList = null;
        String stdNo;
        String deptNo;
        boolean run = true;
        int menuNo;

        try {
            while (run) {
                System.out.println("\n==== 학생 관리 프로그램 ====");
                System.out.println("1. 학생 정보 입력");
                System.out.println("2. 전체 학생 정보 조회");
                System.out.println("3. 학생 정보 상세 조회");
                System.out.println("4. 학생 정보 수정");
                System.out.println("5. 학생 정보 삭제");
                System.out.println("6. 학과번호별 학생 조회");
                System.out.println("7. 학과명별 학생 조회");
                System.out.println("0. 종료");
                System.out.print("메뉴 선택 >> ");
                menuNo = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기

                switch (menuNo) {
                    case 1:
                        // 학생 정보 입력
                        dao.insertStudent(ReadWrite.getStdInfo(sc));
                        break;
                    case 2:
                        // 전체 학생 정보 조회
                        stdList = dao.getALLStudents();
                        ReadWrite.writeStdInfo(stdList);
                        break;
                    case 3:
                        // 학생 정보 상세 조회
                        System.out.print("학번 입력: ");
                        stdNo = sc.nextLine();
                        StudentDTO student = dao.detailStudent(stdNo);
                        if (student != null) {
                            ReadWrite.writeStudentInfo(student);
                        } else {
                            System.out.println("해당 학번의 학생이 존재하지 않습니다.");
                        }
                        break;
                    case 4:
                        // 학생 정보 수정
                        System.out.print("수정할 학생의 학번 입력: ");
                        stdNo = sc.nextLine();
                        StudentDTO existingStudent = dao.detailStudent(stdNo);
                        if (existingStudent != null) {
                            ReadWrite.writeStudentInfo(existingStudent);
                            System.out.println("수정할 정보를 입력하세요 (학번은 " + stdNo + "로 유지됩니다):");
                            StudentDTO updatedStudent = ReadWrite.getStdInfo(sc);
                            // 기존 학번으로 덮어쓰기
                            updatedStudent.setStdNo(stdNo);
                            dao.updateStudent(updatedStudent);
                        } else {
                            System.out.println("해당 학번의 학생이 존재하지 않습니다.");
                        }
                        break;
                    case 5:
                        // 학생 정보 삭제
                        System.out.print("삭제할 학생의 학번 입력: ");
                        stdNo = sc.nextLine();
                        dao.deleteStudent(stdNo);
                        break;
                    case 6:
                        // 학과번호별 학생 조회
                        System.out.print("학과 번호 입력: ");
                        deptNo = sc.nextLine();
                        stdList = dao.searchStudent(deptNo);
                        ReadWrite.writeStdInfo(stdList);
                        break;
                    case 7:
                        // 학과명별 학생 조회
                        System.out.print("학과명 입력 (예: 경영학과, 컴퓨터공학과): ");
                        String deptName = sc.nextLine();
                        stdList = dao.searchStudentByDeptName(deptName);
                        ReadWrite.writeStdInfo(stdList);
                        break;
                    case 0:
                        run = false;
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    default:
                        System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                }
            }
        } catch (Exception e) {
            System.out.println("프로그램 실행 중 오류가 발생했습니다.");
            e.printStackTrace();
        } finally {
            // 자원 해제
            sc.close();
            // DB 연결 종료
            if (dao.conn != null) {
                DBConnect.close(dao.conn);
            }
        }
    }
}