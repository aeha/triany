package aeha.triany;

import aeha.util.TrianyUtil;

/**
 * トリアニーを表現します。
 * @author aeha
 *
 */
public class TrianyData {
	/** id */
	int id = 0;

	/** 値A */
	int a = 0;
	/** 値B */
	int b = 0;
	/** 値C */
	int c = 0;

	/**
	 * コンストラクタ。
	 */
	public TrianyData() {
		int id = TrianyUtil.getTrianyID();
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
}
