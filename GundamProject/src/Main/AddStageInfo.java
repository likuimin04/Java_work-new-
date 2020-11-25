package Main;

import InfoDto.InfoDto;
import myPac.Rect;

public class AddStageInfo {
	public static void main(String[] args) {
		// 각각 스테이지 생성 디버깅에서 확인 가능
		System.out.println();
		InfoDto ifd1=new InfoDto(1, "우주", "Space Stage",9999,9999);
		InfoDto ifd2=new InfoDto(2, "지구", "Earth Stage",100,100);
		InfoDto ifd3=new InfoDto(3, "바다", "Sea Stage",300,500);
		InfoDto ifd4=new InfoDto(4, "사막", "Desert",400,400);
	}
}