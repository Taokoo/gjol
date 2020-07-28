package com.taokoo.test;

public class Demo2 {
	public static void main(String[] args) {
		Integer monitorStationId = 2549;
		boolean is = monitorStationId == 2483 || monitorStationId == 2484 || (monitorStationId >= 2545 && monitorStationId <=2552);
		System.out.println(is);
	}
}
