package test.frame07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener{
   // 콤보 박스의 문자열 아이템을 String[] 로 미리 준비하기
	String[] usergame= {"가위","바위","보"};
    JComboBox<String>combo;
    JLabel lab1;
    JLabel lab2;
   // 생성자
   public MainFrame(String title) {
      super(title);
      // 레이아웃 법칙 지정 (BorderLayout 동서남북 센터 이렇게 지정해서 위치 선택을 하는 레이아웃)
      setLayout(new BorderLayout());
      // 콤보 박스 객체를 생성하면서 아이템 배열을 생성자의 인자로 전달
      combo= new JComboBox<String>(usergame);
      // 문자열을 출력할 레이블 객체 2개 생성하고 초기 문자열은 빈문자열로 지정
      lab1 = new JLabel("");
      lab2 = new JLabel("");
      // 콤보박스 프레임에 북쪽에 배치, lab1은 서쪽, lab2 동쪽
      add(combo,BorderLayout.NORTH); // NORTH 대신에 "North"도 가능
      add(lab1, BorderLayout.WEST);
      add(lab2, BorderLayout.EAST);
      // 콤보 박스에 액션 리스너 등록
      combo.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // 랜덤 객체 생성
      Random ran=new Random();
      // 컴퓨터의 패로 사용할 값 0~2 중에 하나의 숫자를 랜덤하게 얻어내기
      int ranNum=ran.nextInt(3);
      // "가위", "바위","보" 문자열
      String com=usergame.
      lab2.setText("Computer: "+usergame[ranNum]);
      // 플레이어가 선택한 패 읽어오기
      String user=combo.getSelectedItem().toString();
      lab1.setText("Player: "+user);
      // 결과를 저장할 result 지역변수 미리 만든다.
      String result=null;
      // 이긴 경우의 수, 진 경우의 수, 나머지는 비김
      if(com.equals("가위")&& user.equals("바위")) { // 플레이어가 이긴경우
    	  result="You Win!!";
      }else if(com.equals("바위")&& user.equals("보")) { // 플레이어가 이긴경우
    	  result="You Win!!";
      }else if(com.equals("보")&& user.equals("가위")) { // 플레이어가 이긴경우
    	  result="You Win!!";
      }else if(com.equals(user)) { //비긴 경우
    	  result="Draw!!";
      }else { // 나머지는 진 경우
    	  result="You Lost!!";
      }
      JOptionPane.showMessageDialog(this, result);
   }
   public static void main(String[] args) {
      MainFrame f=new MainFrame("가위,바위,보 게임");
      f.setBounds(100, 100, 300, 300);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }
}
