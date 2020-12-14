package example5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			//5000 번 통신 port 를 열고 클라이언트의 접속을 기다린다.
			serverSocket=new ServerSocket(5000);
			/*
			 *  .accept() 메소드는 클라이언트가 접속을 해야지 리턴하는 메소드이다.
			 *  클라이언트가 접속을 해오면 해당 클라이언트와 연결된 Socket 객체의
			 *  참조값을 리턴한다. 
			 */
			while(true) {
				System.out.println("클라이언트의 Socket 접속을 기다립니다...");
				Socket socket=serverSocket.accept();
				System.out.println("클라이언트가 접속을 했습니다.");
				String ip=socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 ip 주소:"+ip);
				//방금 접속을 한 클라이언트로 부터 입력받을 객체의 참조값
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				String msg=br.readLine();
				System.out.println("클라이언트가 전송한 문자열:"+msg);
				
				//클라이언트에게 출력할수 있는 객체의 참조값
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				BufferedWriter bw=new BufferedWriter(osw);
				bw.write("안녕 클라이언트야 난 서버야~");
				bw.newLine();//개행기호를 메소드를 이용해서 출력할수 있다. 
				bw.flush();
				bw.close();
				socket.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("ServerMain main 메소드가 종료 됩니다.");
	}
	// 스레드 클래스 설계
	static class ServerThread extends Thread{
		// 필드( 클라이언트와 연결된 Socket 객체의 참조값을 저장할 필드)
		private Socket socket;
		
		// 생성자
		public ServerThread(Socket socket) {
			// 생성자의 인자로 전달받은 Socket 객체의 참조값을 필드에 저장하기
			this.socket=socket;
		}
		@Override
		public void run() {
			try {
				// 클라이언트가 전송하는 문자열을 읽어들일 객체
				/* InputStream is=socket.getInputStream();
				   InputStreamReader isr=new InputStreamReader(is);
				   BufferedReader br=new BufferedReader(isr);
				*/
				
				//윗 내용 한줄로 전환
				BufferedReader br=
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 클라이언트에게 문자열을 출력할 객체
				BufferedWriter bw=
						new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				// 반복문 돌면서 클라이언트가 전송하는 문자열이 있는지 읽어와 본다.
				while(true) {
					// 문자열 한줄이 전송 될 때 까지 블록킹
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}





