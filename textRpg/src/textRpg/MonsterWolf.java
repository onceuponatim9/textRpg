package textRpg;

public class MonsterWolf extends Monster {
	MonsterWolf() {
		name = "wolf";
	}

	@Override
	public void skill() {
		System.out.println(name + "가 울음소리 스킬을 썼다.");
		// 공격력 1.5배
	}

}
