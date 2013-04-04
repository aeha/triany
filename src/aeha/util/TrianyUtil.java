package aeha.util;

public class TrianyUtil {


	/**
	 * TrianyIDを返します。
	 * 負数、RootTriany id(1)と終端(0)は発生しないようにします。
	 *
	 * @return id
	 */
	public static int getTrianyID(){

		int ran = 0;
		boolean flag = true;

		do{
			// 0 - 2147483647-1 の乱数を発生
			ran = (int)(Math.random() * 2147483647);
			if( ran >= 2 ){
				flag = false;
			}
		}while( flag );

		return ran;
	}
}
