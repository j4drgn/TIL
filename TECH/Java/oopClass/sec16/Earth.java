package oopClass.sec16;

public class Earth {

  //클래스별 상수 - 대문자로 필드명 구성
  static final double EARTH_RADIUS = 6400;
  static final double EARTH_SURFACE_AREA;

  static {
    EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
  }
}
