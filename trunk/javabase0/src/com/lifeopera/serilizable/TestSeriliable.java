package com.lifeopera.serilizable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author jzq Serializable≤‚ ‘ 2009-4-29
 */
public class TestSeriliable {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		DomainObject obj = new DomainObject();
		obj.setAge(29);
		obj.setName("fankai");
		FileOutputStream fos = new FileOutputStream("DomainObject");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
		fos.close();
	}

}
