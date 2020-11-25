package Main;

import GundamInfo.BattleShip;
import GundamInfo.F91_Gundam;
import GundamInfo.First_Gundam;
import GundamInfo.Freedom_Gundam;
import GundamInfo.OO_Gundam;

public class MainStage {
	public static void main(String[] args) {
		BattleShip.startWar();
		System.out.println("프리덤 건담 출격 명령");
		Freedom_Gundam fd=new Freedom_Gundam();
			fd.on();
			fd.go();
			fd.fly();
		
		System.out.println("퍼스트 건담 출격 명령");
		First_Gundam fg=new First_Gundam();
			fg.on();
			fg.go();
			fg.fly();
		
		System.out.println("더블오 건담 출격 명령");
		OO_Gundam OO=new OO_Gundam();
			OO.on();
			OO.go();
			OO.fly();
			
		System.out.println("F91 건담 출격 명령");
		F91_Gundam f91=new F91_Gundam();
			f91.on();
			f91.go();
			f91.fly();
	}
}