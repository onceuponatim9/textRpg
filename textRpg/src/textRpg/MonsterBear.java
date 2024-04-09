package textRpg;

public class MonsterBear extends Monster {
	MonsterBear() {
		name = "bear";
	}

	@Override
	public void skill() {
		System.out.println(name + "이 으르렁 스킬을 썼다.");
	}

}
