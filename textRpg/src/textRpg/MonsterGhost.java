package textRpg;

public class MonsterGhost extends Monster {
	MonsterGhost() {
		name = "ghost";
	}

	@Override
	public void skill() {
		System.out.println(name + "가 투명 망토 스킬을 썼다.");
		// 공격 막기
	}

}
