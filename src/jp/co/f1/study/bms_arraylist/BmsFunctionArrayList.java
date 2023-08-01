package jp.co.f1.study.bms_arraylist;

import jp.co.f1.study.common.KeyIn;
import jp.co.f1.study.common.MyFormat;

import java.util.ArrayList;

public class BmsFunctionArrayList {

	private KeyIn objKeyIn = new KeyIn();
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private final String TAB = "\t";

	MyFormat fm = new MyFormat();

	// メニューを表示
	public void displayMenu() {
		System.out.println("***書籍管理メニュー***");
		System.out.println("1. 登録");
		System.out.println("2. 一覧");
		System.out.println("9. 終了");
		System.out.println("-----------------------");
		System.out.println("番号を選択してください⇒");
	}

	// メニューからやりたいことを選択
	public int selectFunctionFromMenu() {
		int num = objKeyIn.readInt();
		if (num == 1) {
			addFunction();
			System.out.println("");
		} else if (num == 2) {
			listFunction();
			System.out.println("");
		} else if (num == 9) {
			System.out.println("**処理を終了しました**");
		} else {
			System.out.println("正しいメニュー番号を入力してください。");
			System.out.println("");
		}
		return num;
	}

	public void writeIntoMemoryInitially() {
		bookList.add(new Book("a0001", "Java for Dummies", 2500));
		bookList.add(new Book("a0002", "Think Like a Programmer", 3000));
		bookList.add(new Book("a0003", "Eloquent JavaScript", 3400));
	}

	public void listFunction() {
		System.out.println("***書籍一覧***");
		System.out.println("No," + "\t" + "isbn" + "\t" + "title                   price");
		System.out.println("--------------------------------------------------");
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getIsbn() == null) {
				System.out.println("ISBNが不正です。データを修正した後で再度実行してください");
				break;
			}

			String formattedMoney = fm.moneyFormat(bookList.get(i).getPrice());

			System.out.println((i + 1) + "." + "\t" + bookList.get(i).getIsbn() + "\t" + bookList.get(i).getTitle()
					+ "\t" + formattedMoney);
		}
		System.out.println("--------------------------------------------------");
		System.out.println("現在登録されている書籍は合計、" + Book.total + "冊です。");
	}

	public void addFunction() {
		Book newBook = new Book();
		System.out.println("***書籍情報登録***");

		loopIsbn: while (true) {
			System.out.println("ISBNを入力してください。");
			System.out.println("【ISBN】⇒");
			String isbn = objKeyIn.readKey();

			// ISBNが空文字かどうかチェック
			if (isbn.equals("")) {
				System.out.println("空文字が入力されました。ISBNを入力して下さい！");
				continue;
			}

			// ISBNが重複しているかチェック
			for (int i = 0; i < bookList.size(); i++) {
				if (isbn.equals(bookList.get(i).getIsbn())) {
					System.out.println("入力ISBNは既に登録されています：" + isbn);
					continue loopIsbn;
				}
			}
			newBook.setIsbn(isbn);
			break;
		}

		while (true) {
			System.out.println("タイトルを入力してください。");
			System.out.println("【タイトル】⇒");
			String title = objKeyIn.readKey();

			// タイトルが空文字かどうかチェック
			if (title.equals("")) {
				System.out.println("空文字が入力されました。タイトルを入力して下さい！");
				continue;
			}

			newBook.setTitle(title);
			break;
		}

		while (true) {
			System.out.println("価格を入力してください。");
			System.out.println("【価格】⇒");
			int price = objKeyIn.readInt();

			// 値段の入力チェック
			if (price <= 0) {
				System.out.println("0以下の値段が記入されていました。正しい値段を記入してください。");
				continue;
			}
			newBook.setPrice(price);
			break;
		}

		bookList.add(newBook);

		String formattedMoney = fm.moneyFormat(newBook.getPrice());

		System.out.println("***登録済み書籍情報***");
		System.out.println("isbn" + "\t" + "title" + "\t" + "price");
		System.out.println("--------------------------------");
		System.out.println(newBook.getIsbn() + "\t" + newBook.getTitle() + "\t" + formattedMoney);
		System.out.println("--------------------------------");
		System.out.println("上記書籍が登録されました。");
		System.out.println("現在登録されている書籍は合計、" + Book.total + "冊です。");
	}

}
