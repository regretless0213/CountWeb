package WordCount;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import org.junit.Test;

public class WordFrequencyCountTest {

	@Test
	public void testMain1() throws Exception {
		String[] test = { "E:\\Test3\\Test1.txt" };
		WordFrequencyCount.main(test);
		
		FileReader expect = new FileReader("E:\\Test\\Expect.txt");
		BufferedReader ep = new BufferedReader(expect);
		FileReader actual = new FileReader("Result.txt");
		BufferedReader at = new BufferedReader(actual);
		
		String temp;
		while ((temp = at.readLine()) != null) {
			assertEquals(ep.readLine(), temp);
		}
		
		at.close();
		actual.close();
		ep.close();
		expect.close();
	}

	@Test
	public void testMain2() throws Exception {
		String[] test = { "E:\\Test3" };
		WordFrequencyCount.main(test);
		
		FileReader expect = new FileReader("E:\\Test\\Expect.txt");
		BufferedReader ep = new BufferedReader(expect);
		FileReader actual = new FileReader("Result.txt");
		BufferedReader at = new BufferedReader(actual);
		
		String temp;
		while ((temp = at.readLine()) != null) {
			assertEquals(ep.readLine(), temp);
		}
		
		at.close();
		actual.close();
		ep.close();
		expect.close();

	}

	@Test
	public void testMain3() throws Exception {
		String[] test = {};
		String str = "< E:\\Test3\\Test1.txt\n";
		ByteArrayInputStream instr = new ByteArrayInputStream(str.getBytes());
		
		System.setIn(instr);
		WordFrequencyCount.main(test);
		
		FileReader expect = new FileReader("E:\\Test\\Expect.txt");
		BufferedReader ep = new BufferedReader(expect);
		FileReader actual = new FileReader("Result.txt");
		BufferedReader at = new BufferedReader(actual);
		
		String temp;
		while ((temp = at.readLine()) != null) {
			assertEquals(ep.readLine(), temp);
		}
		
		at.close();
		actual.close();
		ep.close();
		expect.close();
	}
	
	@Test
	public void testMain4() throws Exception {
		String[] test = {};
		String str = "content\nMy English is very very poor.\n";
		ByteArrayInputStream instr = new ByteArrayInputStream(str.getBytes());
		
		System.setIn(instr);
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		WordFrequencyCount.main(test);
		assertEquals(
				"请输入文件名：\r\n请输入内容，结尾以回车后ctrl+z结束：\r\n~~~~~~~~~~~~~~~~~~~~\r\ncontent\r\ntotals of the words:6\r\nquantity of vocabulary:5\r\nvery——2\r\nenglish——1\r\nis——1\r\nmy——1\r\npoor——1\r\n~~~~~~~~~~~~~~~~~~~~\r\ntime:1ms\r\n",
				outContent.toString());
	}

}
