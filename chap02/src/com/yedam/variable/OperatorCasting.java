package com.yedam.variable;

public class OperatorCasting {
	public static void main(String[] args) {
		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000;
		
		long result = value1 + value2 + value3;
		System.out.println(result);
		
		int iValue1 = 10;
		int iValue2 = iValue1/4;
		System.out.println(iValue2);
		
		double dValue = iValue1/4.0;
		System.out.println(dValue);
		
		int x = 1;
		int y = 2;
		
		double result2 = (double)x/y; //강제 타입 변환
		System.out.println(result2);
		
		//문자열 + 연산
		int value = 10+2+8;
		
		String str1 = 10+2+"8";
		System.out.println("str1 : " + str1);
		
		String str2 = "10" + 2 + 8;
		System.out.println("str2 : " + str2);
		String str2_2 = "10" + (2 + 8);
		System.out.println("str2_2 : " + str2_2);
		
		//String <-> 기본 타입(정수, 실수, 논리) 변환
		int valueStr = Integer.parseInt(str2_2);
		short shortValue = Short.parseShort(str2_2);
		double doubleValue = Double.parseDouble(str2_2);
		System.out.println(doubleValue);
		
		//기본 타입 -> String 변환
		//int -> String
		String str3 = String.valueOf(valueStr);
		//double -> String
		String str4 = String.valueOf(valueStr);
		System.out.println(str4);
		

		
		
		
		
		
		
		
		
		
	}

}
