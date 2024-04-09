package textRpg;

public class MonsterDragon extends Monster {
	MonsterDragon() {
		name = "dragon";
	}

	@Override
	public void skill() {
		System.out.println(name + "이 불꽃 휘날리기 스킬을 썼다.");
		// 공격력 두 배
	}
}
