package test.frame02;
// 1번째 방법
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.MyFrame;

public class MainFrame01 extends JFrame {
	// 생성자
	// 시작할 준비를 하기위해 준비점을 만들어 놓는것이다.
	public MainFrame01(String title) {
		super(title); // 부모 생성자에 전달하기
		// 레이아웃 매니저 지정하기
		setLayout(new FlowLayout()); // 물 흐르듯이 배치 되는 레이아웃
		// 버튼 3개를 만들고
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
	
		// 버튼 프레임에 배치하기
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		//전송 버튼에 리스너 등록하기
		sendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame01.this, "전송합니다");
			}
		});
		 // 수정 버튼에 리스너 등록하기
		 updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame01.this, "수정합니다");
			}
		});
		 // 삭제 버튼에 리스너 등록하기
		 deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame01.this, "삭제합니다");
			}
		});
	}
	
	// 메인 메소드는 도입점의 역활을 한다.
	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("메인 프레임");
		// 위치와 크기 지정
		f.setBounds(100, 100, 500, 300);
		// 프레임을 닫으면 프로세스가 종료 되도록 (앱이 종료 되도록)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면상에 실제 보이게 한다.
		f.setVisible(true);
	}
}
