package com.geeksun.string;

public class TestStringBuffer {
	public static void main(String args[]) {
		String s = "abbbbb";
		StringBuffer sb = new StringBuffer(s);
		System.out.println("JVM IS USING MEMORY:"
				+ (Runtime.getRuntime().totalMemory() / 1024 / 1024) + "M");
		Runtime.getRuntime().traceMethodCalls(true);

		int count = 0;
		while (true) {
			try {
				sb.append(s);		//   可换成 sb 试一下
				count++;

			} catch (Exception e) {
				System.out.println(e);
			} catch (Error o) {
				String unit = null;
				int size = sb.length();
				size *= 2;

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

				System.out.println("Loop times:" + count);
				System.out.println("String has used memory:" + size + unit);
				System.out.println("JVM IS USING MEMORY:"
						+ (float) Runtime.getRuntime().totalMemory() / 1024
						/ 1024 + "M");
				System.out.println("MemoryError:" + o);
				break;
			}

		}
	}
}