package com.mc.algorithm.d_datastructure.map;

import java.util.HashMap;

import com.mc.algorithm.d_datastructure.dto.School;

public class Run {

	public static void main(String[] args) {
		
		School seoulUniv = new School("서울대", "관악구", "대학교");
		School yeonsaeUniv = new School("연세대", "서울", "대학교");
		School minsa = new School("민사고", "대전", "고등학교");
		School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");
		
		_HashMap<String, School> schoolMap = new _HashMap<String, School>();
		schoolMap.put("seoulUniv", seoulUniv);
		schoolMap.put("yeonsaeUniv", yeonsaeUniv);
		schoolMap.put("minsa", minsa);
		schoolMap.put("multicampus", multicampus);
		
		System.out.println(schoolMap.entrySet());
		System.out.println("============================");
		
		schoolMap.put("seoulUniv", new School("서울대 제주캠", "제주도", "대학교"));
		System.out.println(schoolMap.get("seoulUniv"));
		
		System.out.println("============================");
		schoolMap.remove("seoulUniv");
		System.out.println(schoolMap.entrySet());
		
	}
}
