package aeha.dicti;

import aeha.ITriany;
import aeha.triany.Triany;

public class Dicti {

	private ITriany _triany = new Triany();

	/**
	 * key とvalue を対とするエントリを辞書に挿入する。
	 * key とvalue はいずれも1以上の整数とする。
	 * key とvalue のいずれかが0 以下の場合には何も起きない。
	 * 与えられたkey をキーに持つエントリがすでに存在するなら、そのエントリの値はvalue で上書きされる。
	 * すなわち、辞書の中で、あるkey に等しいキーを持つエントリはたかだか1 個である。
	 * @param key id
	 * @param value
	 */
	public void set_entry(int key, int value){
		if( key < 0 || value < 0 ){
			return;
		}

		// rootに何も登録されていない場合、rootの次に登録
		if( _triany.get_c(1) == 0 ){
			int id = _triany.allocate_triany();
			// aはidとする
			_triany.set_a(id, key);
			// bはvalue
			_triany.set_b(id, value);
			// cは次データのID
			_triany.set_c(id, 0);
			// rootに自分のIDを登録
			_triany.set_c(1, id);
			return;
		}

		// 探索ID用
		int t = _triany.get_c(1);
		// 保存用探索ID
		int before = _triany.root_triany();

		// リストを探索し、キーの昇順になるようにリストを構築する
		while( t != 0 ){
			// 処理対象トリアニーのkey
			int target_key = _triany.get_a(t);

			if( key == target_key ){
				// idと同じものが見つかった場合、そこを上書き
				_triany.set_b(t, value);
				break;

			} else if( key > target_key ){

				// 前回の探索IDを保存
				before = t;
				// 探索IDが登録IDよりも小さい間は、さらに探索を続ける
				t = _triany.get_c(t);

				if( t == 0 ){
					// リストの末尾に達した場合、末尾に生成IDを追加
					int id = _triany.allocate_triany();
					_triany.set_a(id, key);
					_triany.set_b(id, value);
					_triany.set_c(before, id);
					break;
				}

			} else if( key < target_key ){
				// 探索IDが登録IDより大きくなった場合、前回探索IDと現在探索IDの間にデータを挿入
				int id = _triany.allocate_triany();
				_triany.set_a(id, key);
				_triany.set_b(id, value);

				// 前回のデータに自分のIDを入れる
				_triany.set_c(before, id);
				// 自分の次は、今見ているもの
				_triany.set_c(id, t);
				break;
			}
		}

		return;
	}

	/**
	 * key をキーに持つエントリを検索し、もしも辞書中に存在したら、そのキーに対応するvalue を返す。
	 * key をキーに持つエントリが辞書中に存在しなかったら、0 を返す。
	 * @param key
	 * @return
	 */
	public int find_entry(int key){
		int t = _triany.root_triany();
		while( t != 0 ){
			int triany_a = _triany.get_a(t);
			if( key == triany_a ){
				return _triany.get_b(t);
			}
			t = _triany.get_c(t);
		}
		return 0;
	}

	/**
	 * DICTI内の情報を出力します。
	 * ID:A, B, B
	 */
	public void print_entry(){
		int t = 1;
		int before = 0;
		while( t != 0){
			before = t;
			System.out.println(before + ":" + _triany.get_a(t) + ", " + _triany.get_b(t) + ", " + _triany.get_c(t));
			t = _triany.get_c(t);
		}
	}


}
