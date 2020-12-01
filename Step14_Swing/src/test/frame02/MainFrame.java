package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.MyFrame;

public class MainFrame extends JFrame {
	// 생성자
	// 시작할 준비를 하기위해 준비점을 만들어 놓는것이다.
	public MainFrame(String title) {
		super(title); // 부모 생성자에 전달하기
		// 레이아웃 매니저 지정하기
		setLayout(new FlowLayout()); // 물 흐르듯이 배치 되는 레이아웃
		// 버튼 3개를 만들고
		JButton sendBtn=new JButton("전송");
		sendBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame.this, "전송 완료");
		});
		JButton updateBtn=new JButton("수정");
		updateBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame.this, "업데이트 완료");
		});
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MainFrame.this, "삭제 완료");
		});
		
		// 버튼 프레임에 배치하기
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		/*
		- 1번째 패턴 -
		[ 지역변수 로컬 이너로 하는방법 ]
		 전송 버튼에 리스너 등록하기
		sendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "전송합니다");
			}
		});
		 수정 버튼에 리스너 등록하기
		 updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "수정합니다");
			}
		});
		 삭제 버튼에 리스너 등록하기
		 deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this, "삭제합니다");
			}
		});
		*/
	}
	
	// 메인 메소드는 도입점의 역활을 한다.
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		// 위치와 크기 지정
		f.setBounds(100, 100, 500, 300);
		// 프레임을 닫으면 프로세스가 종료 되도록 (앱이 종료 되도록)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면상에 실제 보이게 한다.
		f.setVisible(true);
	}
}
