/**
 * 
 */
package com.sudhakar.zapurl;

import java.util.Random;

/**
 * @author Sudhakar Duraiswamy
 * 
 */
public class RandomStringUtils {

	static final String RANDOM_STRING_RANGE;
	
	
	public enum URL_LENGTH{
		FIVE(5);
		
		private Integer len;
		
		URL_LENGTH(int length){
			this.len = length;
		}

		/**
		 * @return the len
		 */
		public Integer getLen() {
			return len;
		}
		
	}

	static {

		StringBuilder str = new StringBuilder();
		for (int i = 49; i < 58; i++) {
			str.append((char) i);
		}

		for (int i = 65; i < 91; i++) {
			str.append((char) i);
		}

		for (int i = 97; i < 123; i++) {
			str.append((char) i);
		}

		RANDOM_STRING_RANGE = str.toString();

	}

	static Random rnd = new Random();

	public static String randomString(URL_LENGTH len) {
		StringBuilder sb = new StringBuilder(len.getLen());
		for (int i = 0; i < len.getLen(); i++)
			sb.append(RANDOM_STRING_RANGE.charAt(rnd.nextInt(RANDOM_STRING_RANGE.length())));
		return sb.toString();
	}

	public static void main(String[] args) {

/*		List<String> min = new ArrayList<String>();

		List<String> min1 = new ArrayList<String>();
		for (int i = 0; i < 1000000; i++) {
			String temp = randomString(6);
			if (!min.contains(temp) && !min1.contains(temp)) {
				if (min.size() < 500000)
					min.add(temp);
				else
					min1.add(temp);

			} else {
				System.out.println("Occured @ " + i + " : " + temp);
			}
		}*/
		System.out.println(Integer.parseInt(Integer.toBinaryString(Integer.MAX_VALUE), 2));
		
		
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.toBinaryString(Long.MAX_VALUE));
		System.out.println(0x5DEECE66DL);
		System.out.println(0xBL);
		
		System.out.println(1L);
		System.out.println((1L << 48));
	}

}
