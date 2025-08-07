package info;

/**
 * 애플리케이션 정보를 관리하는 클래스
 * 
 * 이 클래스는 애플리케이션의 기본 정보를 저장하고 표시하는 기능을 제공합니다.
 * 제목, 제작자, 내용 등의 정보를 콘솔에 출력합니다.
 */
public class AppInfo {
    /** 애플리케이션 제목 */
    private static final String APP_TITLE = "gameProject";
    
    /** 애플리케이션 제작자 */
    private static final String APP_AUTHOR = "김지용";
    
    /** 애플리케이션 내용 */
    private static final String APP_CONTENT = "가위바위보 게임/숫자 알아맞히기 게임";
    
    /**
     * 애플리케이션 정보를 콘솔에 출력
     * 
     * 애플리케이션의 제목, 제작자, 내용 등의 정보를 형식화하여 콘솔에 출력합니다.
     * 정보 출력 후 사용자에게 메뉴로 돌아가는 방법을 안내합니다.
     */
    public void showAppInfo() {
        System.out.println("**************************************");
        System.out.println("애플리케이션 정보");
        System.out.println("----------------------------------------");
        System.out.println("제목 : " + APP_TITLE);
        System.out.println("제작자 : " + APP_AUTHOR);
        System.out.println("내용 : " + APP_CONTENT);
        System.out.println("**************************************");
        
        System.out.println("아무 키나 입력하면 메뉴로 돌아갑니다...");
    }
}
