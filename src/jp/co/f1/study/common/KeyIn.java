package jp.co.f1.study.common;
/*
 * KeyIn.java 1.0 03/10/20
 * Copyright 2003 HCS. All rights reserved.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * キーボードから入力されたデータを読み取ります。
 * 読み取り可能なデータは文字列(String型データ)、および整数(int型データ)です。
 */
public class KeyIn {
	String buf = null; // 入力バッファの初期化
	BufferedReader br = // BufferedReaderクラスのインスタンス
			new BufferedReader(new InputStreamReader(System.in));

	/*
	 * 文字列を入力するメソッドです。 入力された文字列を返します。 行の内容を含む文字列、ただし行の終端文字は含めない
	 * ストリームの終わりに達している場合([Ctrl]+[Z])は、nullを返す [Enter]キーのみが押下された場合は、""を返す
	 */
	public String readKey() {
		try {
			buf = br.readLine(); // キーボード入力
		} catch (IOException e) { // キーボード入力致命的エラー
			System.out.println(e); // エラー情報の表示
			System.exit(1); // プログラムの異常終了
		}
		return buf; // 文字列を返却
	}

	/*
	 * 入力プロンプトを表示して文字列を入力するメソッドです。 入力された文字列を返します。 指定された文字列msgに続き">"を連結しプロンプト表示する。
	 */
	public String readKey(String msg) {
		System.out.print(msg); // プロンプト表示
		return readKey(); // キーボード入力
	}

	/*
	 * 整数値を入力するメソッドです。 入力された数字列を整数値に変換して返します。
	 * 入力された文字列に数字以外のデータが入力されたり、int型の範囲を超えるデータが
	 * 入力されたりした場合は、"再入力>"プロンプトを表示して再入力を要求します。 これは、正しく入力されるまで繰り返されます。
	 */
	public int readInt() {
		int inputIntValue;
		while (true) {
			buf = readKey();
			try {
				inputIntValue = Integer.parseInt(buf); // 数値に変換
				break; // ループ終了
			} catch (NumberFormatException e) { // 数値変換のエラー
				System.out.println("整数値を入力してください:" + buf);
				System.out.print("再入力>");
			}
		}
		return inputIntValue; // 変換した値の返却
	}

	/*
	 * 入力プロンプトを表示して整数値を入力するメソッドです。 入力された数字列を整数値に変換して返します。
	 */
	public int readInt(String msg) {
		System.out.print(msg); // プロンプトを表示
		return readInt(); // readInt()の呼び出し
	}
}
