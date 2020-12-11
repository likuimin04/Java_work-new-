package chatting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingFrame extends JFrame implements ActionListener{
	private JPanel displayPanel;
	private JPanel inputPanel;
	
	private JTextArea display;
	private JTextField input;
	
	public ChattingFrame() {
		this.setTitle("Chatting");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		displayPanel=new JPanel();
		displayPanel.setLayout(new FlowLayout());
		display=new JTextArea(11, 30);
		Font displayFont=new Font("Serif",Font.BOLD, 20);
		display.setFont(displayFont);
		display.setEditable(false);
		
		JScrollPane scroll=new JScrollPane(display);
		displayPanel.add(scroll);
		
		inputPanel=new JPanel();
		inputPanel.setLayout(new FlowLayout());
		input=new JTextField(30);
		Font inputFont=new Font("Serif",Font.BOLD, 20);
		input.setFont(inputFont);
		input.addActionListener(this);
		
		inputPanel.add(input);
		
		this.setLayout(new BorderLayout());
		this.add(displayPanel,BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		ChattingFrame frame=new ChattingFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField 에 입력한 문자열을 읽어와서
				String msg=input.getText();
				//2. Socket 접속을 해서 전송한다.
				Socket socket=null;
				try {
					// new Socket("접속할 ip 주소", 포트번호)
					socket=new Socket("14.63.164.99", 5000);
					System.out.println("서버에 Socket 접속 성공!");
					//2. Socket 을 통해서 출력하기 
					OutputStream os=socket.getOutputStream();
					OutputStreamWriter osw=new OutputStreamWriter(os);
					osw.write(msg); //입력한 문자열 출력 
					osw.write("\r\n"); //개행기호 출력
					osw.flush(); //방출
					osw.close(); //닫아주기
					socket.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}		
				//3. JTextField 에 입력한 문자열 삭제
				input.setText("");
	}
}

