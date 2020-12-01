package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrame extends JFrame implements ActionListener, KeyListener{
	JTextField inputText;
	JLabel label1;
	// 생성자
	public MainFrame(String title) {
		super(title);
		// 레이아웃 매니저 설정
		this.setLayout(new BorderLayout());
		
		// 텍스트필드와 버튼 객체를 만들어서
		this.inputText=new JTextField(10); // 참조값을 필드에 저장
		JButton sendBtn=new JButton("전송");
		inputText.getText();
		
		// 페널 객체 생성
		JPanel topPanel=new JPanel(); 
		
		// 페널에 텍스트필드와 버튼을 추가하고
		topPanel.add(inputText);
		topPanel.add(sendBtn);
		
		// 버튼 리스너 등록
		sendBtn.addActionListener(this);
		
		// 페널의 배경색 지정
		topPanel.setBackground(Color.DARK_GRAY);
		
		// 페널 째로 프레임의 북쪽에 배치하기
		add(topPanel,BorderLayout.NORTH);
		
		// 레이블을 만들어서
		label1=new JLabel();
		// 페널에 추가하기
		topPanel.add(label1);
		
		// JText필드 키보드 리스너 등록하기
		inputText.addKeyListener(this);
	}
	
	// run 했을떄 실행 순서가 시작되는 main 메소드
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	// 키 눌렀을때 호출되는 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. JTextField 에 입력한 문자열을 읽어와서
		String msg=this.inputText.getText();
		// 2. 레이블에 출력한다. (입력은 불가하고 출력 용도로만 사용한다.)
		label1.setText(msg);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 눌러진 키의 코드값 읽어오기
		int code=e.getKeyCode();
		System.out.println(code);
		if(code == KeyEvent.VK_ENTER) {
			// 1. JTextField 에 입력한 문자열을 읽어와서
			String msg=this.inputText.getText();
			// 2. 레이블에 출력한다. (입력은 불가하고 출력 용도로만 사용한다.)
			label1.setText(msg);
			// 3. 입력창 초기화 (빈 문자열을 만들어준것이다.)
			inputText.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
	}
}
