package jp.co.f1.study.bms_arraylist;

import jp.co.f1.study.common.KeyIn;

public class BmsArrayListTester {
	private KeyIn objKeyIn = new KeyIn();

	public static void main(String[] args) {
		try {
			BmsFunctionArrayList bms = new BmsFunctionArrayList();
			bms.writeIntoMemoryInitially();

			while (true) {
				bms.displayMenu();

				int num = bms.selectFunctionFromMenu();

				if (num == 9) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e + "という例外が発生しました。");
		}

	}
}
