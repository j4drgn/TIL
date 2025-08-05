package oopApi.sec06;

import java.time.LocalDateTime;
import java.util.Calendar;

public class ClendarEx {

  public static void main(String[] args) {
    // Calender class
    Calendar cal = Calendar.getInstance();

    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);

    int week = cal.get(Calendar.DAY_OF_WEEK);

    String strWeek = null;

    switch (week) {
      case Calendar.MONDAY:
        strWeek = "Monday";
        break;
      case Calendar.TUESDAY:
        strWeek = "Tuesday";
        break;
      case Calendar.WEDNESDAY:
        strWeek = "Wednesday";
      case Calendar.THURSDAY:
        strWeek = "Thursday";
        break;
      case Calendar.FRIDAY:
        strWeek = "Friday";
        break;
      case Calendar.SATURDAY:
        strWeek = "Saturday";
        break;
      default:
        strWeek = "Sunday";
    }

    int amPm = cal.get(Calendar.AM_PM);
    String strAMPM = null;
    if (amPm == Calendar.AM) {
      strAMPM = "AM";
    } else {
      strAMPM = "PM";
    }

    int hour = cal.get(Calendar.HOUR);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);

    System.out.print(year + "년 ");
    System.out.print(month + "월 ");
    System.out.println(day + "일 ");
    System.out.println(strWeek + " ");
    System.out.print(strAMPM + " ");
    System.out.print(hour + "시 ");
    System.out.print(minute + "분 ");
    System.out.println(second + "초 ");

    LocalDateTime n = LocalDateTime.now();
    System.out.println(n.getYear() + "년" + n.getMonthValue() + "월" + n.getDayOfMonth() + "일");
    System.out.println("내일은 " + n.plusDays(1) + "일입니다.");
    System.out.println("한시간 이전 시간은 " + n.minusHours(1) + "시 였습니다.");
    System.out.println("일주일 후는 " + n.plusWeeks(1) + "일 입니다.");
    System.out.println("올해는 " + n.getDayOfYear() + "일 지나갑니다.");
  }
}
