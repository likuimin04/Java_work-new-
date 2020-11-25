package Main;

import GundamInfo.F91_Gundam;
import GundamInfo.First_Gundam;
import GundamInfo.Freedom_Gundam;
import GundamInfo.OO_Gundam;

public class MainGundamInfo {
	public static void main(String[] args) {
		System.out.println("Weapon Info");
		// 우선 각자의 Gundam들의 정보 출력
		First_Gundam fg=new First_Gundam();
		fg.weapon();
		
		F91_Gundam f91=new F91_Gundam();
		f91.weapon();
		
		Freedom_Gundam fd=new Freedom_Gundam();
		fd.weapon();
		
		OO_Gundam OO=new OO_Gundam();
		OO.weapon();
	}
}