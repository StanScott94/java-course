package com.stantonscott.javabasics.compilation.solutions;

public class Main {

	private static final String WARNIGN = "there were no arguments entered";
	
	public static void main(String[] args) { 

		if (args.length > 0) {
			System.out.print(args[0]);
		} else {
			System.out.print(WARNIGN);
		}
	}
}
