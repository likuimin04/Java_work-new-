package InfoDto;

public class InfoDto {
	private int num;
	private String name;
	private String addr;
	private int width;
	private int height;
			
	public InfoDto() {}
	
	public InfoDto(int num, String name, String addr,int width, int height) {
		System.out.println(name+" Stage Map 이 열립니다");
		System.out.println("X: "+ width);
		System.out.println("Y: "+ height);
			this.num=num;
			this.name=name;
			this.addr=addr;
			this.width=width;
			this.height=height;		
	}
	public int getArea() {
		return this.width*this.height;
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}