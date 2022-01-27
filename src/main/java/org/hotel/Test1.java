package org.hotel;

import org.testng.annotations.Test;

public class Test1 {

	@Test(priority=3,invocationCount=2)
	private void tester1() {
		System.out.println("--test11---");
		System.out.println("--test12---");
		System.out.println("--test13---");
	}
	
	@Test(priority=0,enabled=false)
	private void tester2() {
		System.out.println("--test111---");
		System.out.println("--test122---");
		System.out.println("--test133---");
	}
	@Test(priority=-2)
	private void tester3() {
		System.out.println("--test1111---");
		System.out.println("--test1211---");
		System.out.println("--test1311---");
	}
}
