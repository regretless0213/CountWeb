package WordCount;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SuppressWarnings("unused")
public class FileProccessingTest {
//	@Test
//	public void testFPtoFile() throws Exception{
//		new FileProccessing("E:\\Test3\\Test1.txt");
//		FileReader expect = new FileReader("E:\\Test\\Expect.txt");
//		BufferedReader ep= new BufferedReader(expect);
//		FileReader actual = new FileReader("Result.txt");
//		BufferedReader at = new BufferedReader(actual);
//		String temp;
//		while((temp = at.readLine()) != null){
//			assertEquals(ep.readLine(),temp);
//		}
//		at.close();
//		actual.close();
//		ep.close();
//		expect.close();
//	}
//
//	@Test
//	public void testFP() throws Exception {
//
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
//		new FileProccessing("content.txt");
//		assertEquals(
//				"~~~~~~~~~~~~~~~~~~~~\r\ncontent\r\ntotals of the words:6\r\nquantity of vocabulary:5\r\nvery——2\r\nenglish——1\r\nis——1\r\nmy——1\r\npoor——1\r\n~~~~~~~~~~~~~~~~~~~~\r\n",
//				outContent.toString());
//
//	}
	
	@Test
	public void test() throws Exception {
		new FileProccessing("E:\\Test3\\Test1.txt",4096,"English");
	}


}
