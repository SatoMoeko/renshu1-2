import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CatApp {

	public static void main(String[] args) {
		System.out.println("***猫集め***");
		ArrayList<Cat> cats = new ArrayList<Cat>();

		while (true) {

			System.out.print("1.集める 2.遊ぶ 3.終了 >>");
			int select = new Scanner(System.in).nextInt();

			switch (select) {
			case 1:
				//猫の種類をきめる
				String[] types = { "黒", "白", "茶トラ" };
				int rand = new Random().nextInt(types.length);
				String type = types[rand];
				System.out.println(type + "猫をみつけた");
				//猫の名前をきめる
				System.out.print("この猫に名前をつけてください >>");
				String name = new Scanner(System.in).nextLine();
				Cat cat = new Cat(name, type);//猫を生む、仲間に加える
				cats.add(cat);
				System.out.println(cat.name + "が仲間に加わった");
				break;
			case 2:
				if (cats.size() == 0) {
					System.out.println("まだ遊ぶ猫がいません…");
				} else {
					for (int i = 0; i < cats.size(); i++) {//猫一覧の表示
						System.out.printf("%d・・・%s[%s](%d)\n", i, cats.get(i).name, cats.get(i).type, cats.get(i).love);
					}
					//遊ぶ猫をえらぶ
					System.out.print("どの猫と遊びますか？>>");
					select = new Scanner(System.in).nextInt();
					System.out.println(cats.get(select).name + "とあそんだ");
					System.out.println("・・・");
					//親密度アップ
					cats.get(select).love++;
					System.out.println(cats.get(select).name + "親密度がアップした！");
				}
				break;
			case 3:
				System.out.println("***結果***");
				//並び替え（親密度高い順）
				for (int i = 0; i < cats.size() - 1; i++) {
					for (int j = i + 1; j < cats.size(); j++) {//二重for文
						// 右側の数字が大きい場合
						if (cats.get(i).love < cats.get(j).love) {
							Cat temp = cats.get(i);//cats.get(i)をtempに避難させる
							cats.set(i, cats.get(j));//配列と違いリストはそのまま代入ができない。テキストp613参照
							cats.set(j, temp);//避難させたtempをｊに代入
						}
					}

					//表示
					for (Cat c : cats) {
						System.out.printf("%s[%s](%d)\n", c.name, c.type, c.love);
					}
					System.out.println("また遊んでね。おしまい");
					return;

				}
			}
		}
	}

}
