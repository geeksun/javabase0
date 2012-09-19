package com.base.io;

/**
 * @author Administrator
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。 但是要保证汉字不被截半个，如"我ABC"4，
 * 应该截为"我AB"，输入"我ABC汉DEF"，6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 */
public class JieZhiFu {
	String SplitStr;

	int SplitByte;

	public JieZhiFu(String str, int bytes) {
		SplitStr = str;
		SplitByte = bytes;
		System.out.println("The String is:′" + SplitStr + "′;SplitBytes="
				+ SplitByte);
	}

	public void SplitIt() {
		int loopCount;

		loopCount = (SplitStr.length() % SplitByte == 0) ? (SplitStr.length() / SplitByte)
				: (SplitStr.length() / SplitByte + 1);
		System.out.println("Will Split into " + loopCount);
		for (int i = 1; i <= loopCount; i++) {
			if (i == loopCount) {

				System.out.println(SplitStr.substring((i - 1) * SplitByte,
						SplitStr.length()));
			} else {

				System.out.println(SplitStr.substring((i - 1) * SplitByte,
						(i * SplitByte)));
			}
		}
	}

	public static void main(String[] args) {
		JieZhiFu ss = new JieZhiFu("我ACBC", 4);
		ss.SplitIt();
	}
}
