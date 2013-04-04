package aeha.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Test extends BaseFileReader {

	HashMap<Integer, Integer> _hash = new HashMap<Integer, Integer>();
	public int sum = 0;

	@Override
	public void doPerform(String str) {

		// 先頭が#はコメントなので、読み飛ばす
		if( "#".equals( str.charAt(0) ) ){
			return;
		}

		// スペース区切りで分割
		String[] str_array = str.split(" ");

		if( "s".equals( str_array[0] ) ){
			int key = Integer.parseInt(str_array[1]);
			int value = Integer.parseInt(str_array[2]);
			_hash.put(key, value);
		} else if( "f".equals( str_array[0] ) ){
			int key = Integer.parseInt( str_array[1] );
			if( _hash.get(key) != null ){
				sum += _hash.get(key);
			}
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		File file = new File("C:\\eclipse\\eclipse_4.2_java\\pleiades\\workspace\\triany\\src\\aeha\\sample\\testdata.txt");
		Test te = new Test();
		te.readFile(file);

		System.out.println( "---------------------------" );
		System.out.println( te.sum );
	}

}
