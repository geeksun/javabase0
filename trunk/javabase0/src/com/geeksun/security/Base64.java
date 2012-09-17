package com.geeksun.security;

//字节数组及字符串转换类
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Base64 {

  public static String encode(byte[] data) {
      StringBuffer sb = new StringBuffer();
      int len = data.length;
      int i = 0;
      int b1, b2;

      while (i < len) {
          byte ms = data[i];
          b1 = (ms >>> 4) & 0xf;// 高四位
          b2 = ms & 0xf;// 低四位
          sb.append(Integer.toHexString(b1));
          sb.append(Integer.toHexString(b2));
          i++;
      }
      return sb.toString();
  }

  public static byte[] decode(String str) throws IOException {
      int len = str.length();
      ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
      int i = 0;
      if (len % 2 != 0) {
          throw new IOException("输入的长度只能为偶数!");
      }

      while (i < len) {
          String tmp_hight = str.substring(i, i + 1);
          String tmp = str.substring(i, i + 2);
          System.out.println(tmp_hight);
          int dec_sign = Integer.parseInt(tmp_hight, 16) >>> 3;
          int dec = 0;
          if (dec_sign == 1) {
              dec = Integer.parseInt(tmp, 16) ^ 0xff;
              dec = dec + 1;
              dec = -dec;
          } else {
              dec = Integer.parseInt(tmp, 16);
          }

          buf.write(dec);
          i = i + 2;
      }
      return buf.toByteArray();
  }

  public static String getBase64Encode(byte[] src) throws Exception {
      try {
          return Base64.encode(src);
      } catch (Exception e) {
          e.printStackTrace();
          throw e;
      }
  }

  public static byte[] getBase64Dencode(String src) throws Exception {
      try {
          return Base64.decode(src);
      } catch (Exception e) {
          e.printStackTrace();
          throw e;
      }
  }

}
