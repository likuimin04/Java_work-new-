package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.DownloadTask;
import test.mypac.SubThread;

public class MainFrame06 extends JFrame implements ActionListener {
	public MainFrame06(String title) {
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림 입니다!!!");
		
		// Runnable 인터페이스 type 의 참조값을 얻어내서
		Runnable downTask=new Runnable() {
			@Override
			public void run() {
				try {
					for(int i=1; i<=100; i++) {
						System.out.println(i+"%");
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("다운로드를 완료 했습니다.");
			}
		};
		Thread t=new Thread(downTask);
		t.start();
		
		System.out.println("actionPerformend() 메소드가 리턴 합니다.");
	}
	public static void main(String[] args) {
		MainFrame06 f=new MainFrame06("메인 프레임 02");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
