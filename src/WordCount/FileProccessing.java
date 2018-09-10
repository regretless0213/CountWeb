package WordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FileProccessing {
	private String genpath = System.getProperty("user.dir");

	public FileProccessing(String filename) {
		try {
			new FileProccessing(filename, 4096, " ,.!?\"\';:0123456789\n\r\t“”‘’·——-=*/()[]{}…（）【】｛｝\0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public FileProccessing(String filename, int ch, String syn) throws Exception {

		Map<String, Integer> hm = new HashMap<String, Integer>();
		FileReader fk = new FileReader(filename);
		BufferedReader br = new BufferedReader(fk);

		int i = 0;
		char[] c = new char[ch];
		String thelast = "";
		String wordpart = "";

		FileOutputStream testfile = new FileOutputStream(genpath + File.separator + "Result.txt");
		testfile.write(new String("").getBytes());
		testfile.close();

		while ((i = br.read(c)) > 0) {
			// int n = 0;
			wordpart = "";
			for (int reset = i; reset < ch; reset++) {
				c[reset - 1] = ' ';
			}

			// while (Character.isLetter(c[n])) {
			// thelast = thelast + String.valueOf(c[n]);
			// n++;
			// }
			int m = i - 1;
			while (Character.isLetter(c[m])) {
				wordpart = String.valueOf(c[m]) + wordpart;
				c[m] = ' ';
				m--;
				if (m < 0) {
					thelast += wordpart;
					break;
				}
			}
			if (m < 0) {
				continue;
			}
			String s = (thelast + String.valueOf(c)).toLowerCase();// 拼接加大写转换小写
			// char[] judge = s.toCharArray();
			//
			// String word = "";
			//
			// for (int n = 0; n < judge.length; n++) {
			// if(Character.isLetter(judge[n])){
			//// if (judge[n] <= 'z' && judge[n] >= 'a') {
			// word += judge[n];
			// } else if (!word.isEmpty()) {
			// if (hm.get(word) != null) {
			// int value = ((Integer) hm.get(word)).intValue();
			// value++;
			// hm.put(word, new Integer(value));
			// } else {
			// hm.put(word, new Integer(1));
			// }
			// word = "";
			// }
			//
			// }
			StringTokenizer st = new StringTokenizer(s, syn); // 用于切分字符串

			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if (hm.get(word) != null) {
					int value = ((Integer) hm.get(word)).intValue();
					value++;
					hm.put(word, value);
				} else {
					hm.put(word, 1);
				}
			}
			thelast = wordpart;
		}
		if (!wordpart.isEmpty()) {
			if (hm.get(wordpart) != null) {
				int value = ((Integer) hm.get(wordpart)).intValue();
				value++;
				hm.put(wordpart, value);
			} else {
				hm.put(wordpart, 1);
			}
		}

		// 需要按照词频输出结果
		// TreeMap tm = new TreeMap(hm);
		// Collections.reverseOrder()
		// Set set = hm.entrySet();
		// Iterator i = set.iterator();
		// while(i.hasNext()) {
		// Object o = i.next();
		// tm.put(o, hm.get(o));
		// }
		ByValueComparator bvc = new ByValueComparator(hm);
		List<Map.Entry<String, Integer>> ll = new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
		Collections.sort(ll, bvc);

		int NumofWord = 0;
		Iterator iter = hm.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			NumofWord += (Integer) entry.getValue();
		}
		String reg = ".*\\\\(.*)";
		String name = filename.replaceAll(reg, "$1");
		if (hm.size() > 100) {

			FileWriter result = new FileWriter(genpath + File.separator + "Result.txt", true);

			result.write("~~~~~~~~~~~~~~~~~~~~\r\n");
			result.write(name.substring(0, name.lastIndexOf(".")) + "\r\n");
			result.write("totals of the words:" + NumofWord + "\r\n");
			result.write("quantity of vocabulary:" + hm.size() + "\r\n");
			for (Map.Entry<String, Integer> str : ll) {
				result.write(str.getKey() + "——" + str.getValue() + "\r\n");
			}

			result.write("~~~~~~~~~~~~~~~~~~~~\r\n");
			result.close();
			System.out.println("由于" + name.substring(0, name.lastIndexOf(".")) + "文件过大，输出到文件Result中。");

		} else {
			System.out.println("~~~~~~~~~~~~~~~~~~~~");
			System.out.println(name.substring(0, name.lastIndexOf(".")));
			System.out.println("totals of the words:" + NumofWord);
			System.out.println("quantity of vocabulary:" + hm.size());
			for (Map.Entry<String, Integer> str : ll) {
				System.out.println(str.getKey() + "——" + str.getValue());
			}

			System.out.println("~~~~~~~~~~~~~~~~~~~~");
		}
		fk.close();
		br.close();
	}

}