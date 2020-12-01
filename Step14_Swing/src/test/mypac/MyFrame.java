package test.mypac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	// 생성자
	public MyFrame() {
		setLayout(null);
		JButton btn=new JButton("눌러보시오");
		btn.setBounds(50, 50, 100, 40);
		add(btn);
		
		ActionListener Listener= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기서 this만 쓰면 안되는 이유는 this만 작성하면 Listener를 뜻하기 때문에 앞에 적용할 MyFrame을 명시해줘야한다
				JOptionPane.showMessageDialog(MyFrame.this, "버튼을 눌렀네?");
			}
		};
		// 지역 변수에 저장된 ActionListener 객체의 참조값 전달
		btn.addActionListener(Listener);
		// 전송 버튼 추가
		JButton sendBtn=new JButton("전송");
		sendBtn.setBounds(200, 50, 100, 40);
		add(sendBtn);
		// 필드에 있는 ActionListener 등록하기
		sendBtn.addActionListener(sendListener);
	}// 생성자를 닫는 중괄호
	ActionListener sendListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MyFrame.this, "전송합니다.");
		}
	};
	
}// 클래스를 닫는 중괄호
