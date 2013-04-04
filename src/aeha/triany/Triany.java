package aeha.triany;

import java.util.HashMap;

import aeha.ITriany;
import aeha.util.TrianyUtil;

public class Triany implements ITriany {

	HashMap<Integer, TrianyData> _trianyhash = new HashMap<Integer, TrianyData>();

	/**
	 * root trianyを登録して、オブジェクトを生成します。
	 */
	public Triany(){
		this.init();
	}

	/**
	 * 初期化。
	 */
	private void init(){
		TrianyData data = new TrianyData();
		data.setId(1);
		_trianyhash.put(data.getId(), data);
	}


	@Override
	public int root_triany() {
		return 1;
	}

	@Override
	public int allocate_triany() {
		TrianyData data = new TrianyData();
		int id = TrianyUtil.getTrianyID();
		data.setId(id);
		_trianyhash.put(id, data);
		return id;
	}

	@Override
	public void set_a(int id, int value) {
		if( id <= 0 ){
			return;
		}

		// 不正ID
		TrianyData data = _trianyhash.get(id);
		if( data == null ){
			return;
		}

		data.setA(value);
	}

	@Override
	public void set_b(int id, int value) {
		if( id <= 0 ){
			return;
		}

		// 不正ID
		TrianyData data = _trianyhash.get(id);
		if( data == null ){
			return;
		}

		data.setB(value);
	}

	@Override
	public void set_c(int id, int value) {
		if( id <= 0 ){
			return;
		}

		// 不正ID
		TrianyData data = _trianyhash.get(id);
		if( data == null ){
			return;
		}

		data.setC(value);
	}

	@Override
	public int get_a(int id) {
		if( id <= 0 ){
			return  0;
		}

		// 不正ID
		TrianyData data = _trianyhash.get(id);
		if( data == null ){
			return 0;
		}

		return data.getA();
	}

	@Override
	public int get_b(int id) {
		if( id <= 0 ){
			return  0;
		}

		// 不正ID
		TrianyData data = _trianyhash.get(id);
		if( data == null ){
			return 0;
		}

		return data.getB();
	}

	@Override
	public int get_c(int id) {
		if( id <= 0 ){
			return  0;
		}

		// 不正ID
		TrianyData data = _trianyhash.get(id);
		if( data == null ){
			return 0;
		}

		return data.getC();
	}

}
