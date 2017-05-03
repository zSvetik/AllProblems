package com.my;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class MainClass {

	public static void main(String[] args) {

		// problem3(new Long("600851475143"));
		final long startTime = System.currentTimeMillis();
		// System.out.println(problem3(new Long("600851475143")));
		//System.out.println(problem8());
		problem8();
		System.out.println((System.currentTimeMillis() - startTime) + " ms.");
	}

	/**
	 * Problem 8: Largest product in a series. The four adjacent digits in the
	 * 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 =
	 * 5832.
	 * 
	 * 7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450
	 * 
	 * Find the thirteen adjacent digits in the 1000-digit number that have the
	 * greatest product. What is the value of this product?
	 * 
	 * @return
	 */
	private static void problem8() {
		// BigDecimal inputNumber = new BigDecimal("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
		String stringNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		System.out.println(stringNumber.chars().mapToObj(i -> String.valueOf((char) i)).mapToInt(Integer::valueOf).max().getAsInt());
		//.forEach(System.out::println);
	}

	/**
	 * Problem 7: 10001st prime. By listing the first six prime numbers: 2, 3,
	 * 5, 7, 11, and 13, we can see that the 6th prime is 13.
	 * 
	 * What is the 10 001st prime number?
	 * 
	 * @return
	 */
	private static long problem7() {
		return LongStream.iterate(2, n -> n + 1).filter(n -> LongStream.range(2, n).noneMatch(i -> n % i == 0)).limit(5)
				.reduce((a, b) -> b).getAsLong();
	}

	/**
	 * Problem 6: Sum square difference. The sum of the squares of the first ten
	 * natural numbers is,
	 * 
	 * 1^2 + 2^2 + ... + 10^2 = 385 The square of the sum of the first ten
	 * natural numbers is,
	 * 
	 * (1 + 2 + ... + 10)^2 = 552 = 3025 Hence the difference between the sum of
	 * the squares of the first ten natural numbers and the square of the sum is
	 * 3025 − 385 = 2640.
	 * 
	 * Find the difference between the sum of the squares of the first one
	 * hundred natural numbers and the square of the sum.
	 * 
	 * @return
	 * 
	 * @return
	 */
	private static long problem6() {
		Long endNumber = new Long("100");
		return LongStream
				.of((long) Math.pow(LongStream.rangeClosed(1, endNumber).parallel().reduce((a, b) -> a + b).getAsLong(),
						2), LongStream.rangeClosed(1, endNumber).map(n -> n * n).sum())
				.reduce((a, b) -> a - b).getAsLong();
	}

	/**
	 * Problem 5: Smallest multiple. 2520 is the smallest number that can be
	 * divided by each of the numbers from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 * 
	 * @return
	 */
	private static Long problem5() {
		return LongStream.iterate(1, n -> n + 1).filter(n -> IntStream.rangeClosed(1, 20).allMatch(i -> n % i == 0))
				.findFirst().getAsLong();
	}

	/**
	 * Problem 4: Largest palindrome product. A palindromic number reads the
	 * same both ways. The largest palindrome made from the product of two
	 * 2-digit numbers is 9009 = 91 × 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 * 
	 * @return
	 */
	private static int problem4() {
		return IntStream.range(100, 1000).parallel()
				.map(i -> IntStream.range(100, 1000).parallel().map(n -> n * i).filter(n -> {
					int inNum = n;
					int outNum = 0;
					while (inNum != 0) {
						outNum *= 10;
						outNum += (inNum % 10);
						inNum /= 10;
					}
					return n == outNum;
				}).max().orElse(0)).max().orElse(0);

	}

	/**
	 * Problem 3: Largest prime factor. The prime factors of 13195 are 5, 7, 13
	 * and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 * 
	 * @param inputNumber
	 * @return
	 */
	private static Long problem3(Long inputNumber) {
		return LongStream.rangeClosed(1, inputNumber).parallel().filter(i -> inputNumber % i == 0)
				.filter(n -> LongStream.range(2, n).allMatch(i -> n % i != 0)).max().getAsLong();
	}

	/**
	 * Problem 2: Even Fibonacci numbers. Each new term in the Fibonacci
	 * sequence is generated by adding the previous two terms. By starting with
	 * 1 and 2, the first 10 terms will be:
	 * 
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 * 
	 * By considering the terms in the Fibonacci sequence whose values do not
	 * exceed four million, find the sum of the even-valued terms.
	 * 
	 * @return
	 */
	private static long problem2() {
		return Stream.iterate(new long[] { 1, 1 }, p -> new long[] { p[1], p[0] + p[1] }).limit(33)
				.filter(p -> p[0] % 2 == 0).mapToLong(p -> p[0]).sum();
	}

	/**
	 * Problem 1: Multiples of 3 and 5. If we list all the natural numbers below
	 * 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
	 * multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 * 
	 * @param belowNumber
	 * @return
	 */
	private static int problem1(int belowNumber) {
		return IntStream.range(1, belowNumber).filter(i -> (i % 3 == 0) || (i % 5 == 0)).sum();
	}

}
