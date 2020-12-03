package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.SubThread;

public class MainFrame03 extends JFrame implements ActionListener {
	public MainFrame03(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림 입니다!!!");
		// 익명의 local inner class 를 이용해서 Thread 객체를 생성하고
		Thread t=new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("무언가 10초(오랜 시간)이 걸리는 작업을 합니다.");
					Thread.sleep(10000);
					System.out.println("시간이 오래 걸리는 작업이 끝났습니다.");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		};
		// 스레드를 시작 시킨다.
		t.start();
		System.out.println("actionPerformend() 메소드가 리턴 합니다.");
	}
	public static void main(String[] args) {
		MainFrame03 f=new MainFrame03("메인 프레임 02");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
