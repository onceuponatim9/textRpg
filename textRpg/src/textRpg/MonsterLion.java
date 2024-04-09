package textRpg;

public class MonsterLion extends Monster {
	MonsterLion() {
		name = "lion";
	}

	@Override
	public void skill() {
		System.out.println(name + "이 동료 불러오기 스킬을 썼다.");
		// 공격력 세 배
	}

}
