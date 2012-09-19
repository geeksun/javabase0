package com.base.string;

public class TestString {

	public static void main(String args[]) {
		String s = "abbbbb";
		System.out.println("JVM MAX MEMORY: "
				+ Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
		System.out.println("JVM IS USING MEMORY:"
				+ Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
		Runtime.getRuntime().traceMethodCalls(true);
		while (true) {
			try {
				s = s + s;
			} catch (Exception e) {
				System.out.println(e);
			} catch (Error o) {
				String unit = null;
				int sizeb = s.length();
				int size = sizeb;
				int time = 0;
				while (size > 1024) {
					size = size / 1024;
					time++;
				}
				switch (time) {
				case 0:
					unit = "byte";
					break;
				case 1:
					unit = "k";
					break;
				case 2:
					unit = "M";
					break;
				default:
					unit = "byte";
				}

				System.out.println("String has used memory:" + size + unit);
				System.out.println("JVM IS USING MEMORY:" 
						+ (float) Runtime.getRuntime().totalMemory() / 1024	/ 1024 + "M");
				System.out.println("MemoryError:" + o);
				break;
			}
		}
	}
}
