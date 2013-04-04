package aeha.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import aeha.dicti.Dicti;

public class TrianyExec extends BaseFileReader {

	public Dicti dicti = new Dicti();
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
			dicti.set_entry(key, value);
		} else if( "f".equals( str_array[0] ) ){
			int key = Integer.parseInt( str_array[1] );
			sum += dicti.find_entry( key );
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		File file = new File("C:\\eclipse\\eclipse_4.2_java\\pleiades\\workspace\\triany\\src\\aeha\\sample\\testdata.txt");
		TrianyExec te = new TrianyExec();
		te.readFile(file);

		te.dicti.print_entry();
		System.out.println( "---------------------------" );
		System.out.println( te.sum );
	}

}
