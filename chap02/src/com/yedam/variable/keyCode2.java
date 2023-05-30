package com.yedam.variable;

import java.util.Scanner;


public class keyCode2 {
	public static void main(String[] args) throws Exception {
		//keyCode -> 하나의 문자를 받아 올 때
		System.out.println("입력>");
		
		int keyCode = 0;
		
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		
		//Scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력>");
		
		//문자열 읽기
		String inputData = scanner.nextLine();
		
		//정수 읽기
		int data = scanner.nextInt();
		scanner.nextLine();
		
		inputData = scanner.nextLine();
		System.out.println("Scanner 활용 => "+inputData);
		
		//데이터 비교->이력한 값 == 저장된 값 비교
		
		//기본 타입(정수 , 실수 비교 ==)
		//문자열 -> equals
		if(inputData.equals("yedam")) {
			System.out.println("yedam과 일치합니다.");
		}else {
			System.out.println("yedam과 일치하지 않습니다.");
		}
	}

}
