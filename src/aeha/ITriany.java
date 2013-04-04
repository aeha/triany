/**
 *
 */
package aeha;

/**
 *
 * @author aeha
 *
 */
public interface ITriany {

	/**
	 * Root Triany のid を得る関数である。
	 * 戻り値は常に1 となる。Root Trianyのa,b,c の各フィールドの値は、
	 * set_a,set_b, あるいはset_c で設定されるまで0 である。
	 * @return rootid(1)
	 */
	public int root_triany();

	/**
	 * 新たなTriany を確保し、そのTriay のid を得る関数である。
	 * 戻り値が0または1 になることはない。
	 * 関数allocate_triany を呼ぶたびに戻り値が増えていくという保証はない。
	 * 新たなTriany の確保に失敗することはないものとする。
	 * 得られたTriany のa,b,c の各フィールドは、0 で初期化されている。
	 * 使わなくなったTriany を解放する必要はない。
	 *
	 * @return triany id
	 */
	public int allocate_triany();

	/**
	 * id で指定されたTriany のa フィールドにvalue の値を設定する。
	 * 設定は何度でも行うことができ、最後に設定した値が有効になる。
	 * id が不正なid または0 の場合には何も起きない。
	 * valueが負の場合には何も起きない。
	 * @param id
	 * @param value 値
	 */
	public void set_a(int id, int value);

	/**
	 * id で指定されたTriany のb フィールドにvalue の値を設定する。
	 * 設定は何度でも行うことができ、最後に設定した値が有効になる。
	 * id が不正なid または0 の場合には何も起きない。
	 * valueが負の場合には何も起きない。
	 * @param id
	 * @param value 値
	 */
	public void set_b(int id, int value);

	/**
	 * id で指定されたTriany のc フィールドにvalue の値を設定する。
	 * 設定は何度でも行うことができ、最後に設定した値が有効になる。
	 * id が不正なid または0 の場合には何も起きない。
	 * valueが負の場合には何も起きない。
	 *
	 * @param id
	 * @param value 値
	 */
	public void set_c(int id, int value);


	/**
	 * id で指定されたTriany のa フィールドの値を返す。
	 * id が不正なid または0 の場合には何も起きない。
	 *
	 * @param id
	 * @return フィールド値
	 */
	public int get_a(int id);

	/**
	 * id で指定されたTriany のb フィールドの値を返す。
	 * id が不正なid または0 の場合には何も起きない。
	 *
	 * @param id
	 * @return フィールド値
	 */
	public int get_b(int id);

	/**
	 * id で指定されたTriany のc フィールドの値を返す。
	 * id が不正なid または0 の場合には何も起きない。
	 *
	 * @param id
	 * @return フィールド値
	 */
	public int get_c(int id);
}
