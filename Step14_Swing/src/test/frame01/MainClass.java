package test.frame01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainClass {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		// 제목
		f.setTitle("나의 프레임");
		// 크기
		f.setSize(500, 300);
		// 위치
		f.setLocation(100, 100);
		// 창닫기 (x) 를 누르면 자동으로 프로세스가 종료 되도록 설정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 배치매니저를 사용하지 않겠다(절대 좌표에 절대 크기로 배치하겠다)
		f.setLayout(null);
		// 버튼 객체 생성
		JButton btn=new JButton("누르시오");
		// 버튼 위치와 크기 지정
		btn.setBounds(50, 50, 100, 40);
		// 프레임에 버튼 추가하기
		f.add(btn);
		// 프레임을 보이게 한다.
		f.setVisible(true);
		
		//ActionListener 인터페이스 type 의 참조값 얻어내기
		ActionListener listener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("누르면 안될 것을 눌러버렸스...");
				//JOptionPane 클래스의 static 메소드를 이용해서 알림창 띄우기
				// .showMessageDialog(프레임의 참조값, 띄울 문자열)
				JOptionPane.showMessageDialog(f, "진심인가? 자네?");
			}
		};
		// 버튼에 액션 리스너 등록하기
		btn.addActionListener(listener);
		
		JFrame f1=new JFrame();
		JButton btn1=new JButton("메롱");
		btn1.setBounds(200, 50, 100, 40);
		f.add(btn1);
		f.setVisible(true);
		
		ActionListener listener2=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f1, "약올리지마!");	
			}
		};
		btn1.addActionListener(listener2);
	}
}
