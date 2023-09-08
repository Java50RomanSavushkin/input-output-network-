package telran.io.test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ByteStreamsTests {
	private static final String DATA = "Hello World";
	private static final String FILE_NAME = "hello.txt";

	@Test
	@Order(1)
	void fileOutputStreamTest() throws Exception {
		try (OutputStream output = new FileOutputStream(FILE_NAME)) {
			output.write(DATA.getBytes());
		}
	}

	@Test
	@Order(2)
	void fileInputStreamTest() throws Exception {
		try (InputStream input = new FileInputStream(FILE_NAME)) {
			int length = input.available();
			byte[] buffer = new byte[length];
			input.read(buffer);
			assertEquals(DATA, new String(buffer));
		}
	}
}
