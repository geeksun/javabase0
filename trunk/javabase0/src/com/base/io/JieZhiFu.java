package com.base.io;

/**
 * @author Administrator
 * ��дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������ֽ��������Ϊ���ֽڽ�ȡ���ַ����� ����Ҫ��֤���ֲ����ذ������"��ABC"4��
 * Ӧ�ý�Ϊ"��AB"������"��ABC��DEF"��6��Ӧ�����Ϊ"��ABC"������"��ABC+���İ��"��
 */
public class JieZhiFu {
	String SplitStr;

	int SplitByte;

	public JieZhiFu(String str, int bytes) {
		SplitStr = str;
		SplitByte = bytes;
		System.out.println("The String is:��" + SplitStr + "��;SplitBytes="
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
		JieZhiFu ss = new JieZhiFu("��ACBC", 4);
		ss.SplitIt();
	}
}
