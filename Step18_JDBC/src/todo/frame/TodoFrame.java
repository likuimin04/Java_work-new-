package todo.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
import todo.dao.TodoDao;
import todo.dto.TodoDto;

public class TodoFrame extends JFrame implements ActionListener, PropertyChangeListener {
	//필드
	JTextField text_content, text_regdate;
	JTable table;
	DefaultTableModel model;
	// 1. 생성자
	public TodoFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.LIGHT_GRAY);
		add(topPanel,BorderLayout.SOUTH);
		JLabel label_content=new JLabel("내용");
		text_content=new JTextField(20);
		text_regdate=new JTextField(10);
		JButton btn_add=new JButton("할일 추가");
		topPanel.add(label_content);
		topPanel.add(text_content);
		topPanel.add(btn_add);
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
		
		table=new JTable();
		String[] colNames= {"번호","내용","등록일"};
		model=new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				if(column == 0) {
					return false;
				}else {
					return true;
				}
			}
		};
		table.setModel(model);
		JScrollPane scPane=new JScrollPane(table);
		add(scPane,BorderLayout.CENTER);
		
		JButton btn_delete=new JButton("삭제");
		btn_delete.addActionListener(this);
		btn_delete.setActionCommand("delete");
		
		//삭제 버튼 추가
		topPanel.add(btn_delete);
		table.addPropertyChangeListener(this);
	}// 생성자 End
	
	// 2. 할일 목록을 테이블에 출력하는 메소드
	public void printTodo() {
		TodoDao dao=new TodoDao();
		List<TodoDto> list=dao.selectAll();
		model.setRowCount(0);
		
		for(TodoDto tmp:list) {
			Vector<Object> row=new Vector<>();
			row.add(tmp.getNum());
			row.add(tmp.getContent());
			row.add(tmp.getRegdate());
			
			model.addRow(row);
		}
	} // 할일 목록을 테이블에 출력하는 메소드 End

	// 3.메인 메소드
	public static void main(String[] args) {
		TodoFrame f=new TodoFrame("할일 목록");
		f.setBounds(100, 100, 600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("add")) {
			addTodo();
		}else if(command.equals("delete")) {
			deleteTodo();
		}
	}
	
	// 4. 할일 목록 삭제 메소드
	public void deleteTodo() {
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex == -1) {
			JOptionPane.showMessageDialog(this, "삭제 하실 부분을 선택해 주세요");
			return;
		}
		int num=(int)table.getValueAt(selectedIndex, 0);
		int result=JOptionPane.showConfirmDialog(this, num+" 번 할일 목록을 삭제 하십니까?");
		if(result == JOptionPane.YES_OPTION) {
			new TodoDao().delete(num);
			printTodo();
		}
	} //할일 목록 삭제 메소드 End
	
	// 5. 할일 목록을 추가하는 메소드
	public void addTodo() {
		String content=text_content.getText();
		String regdate=text_regdate.getText();
		
		TodoDto dto=new TodoDto();
		dto.setContent(content);
		dto.setRegdate(regdate);
		
		TodoDao dao=new TodoDao();
		boolean isSuccess=dao.insert(dto);
		
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, content+" 의 할일이 추가 되었습니다.");
			printTodo();
		}else {
			JOptionPane.showMessageDialog(this, "할일 추가가 실패하였습니다.");
		}
	}
	
	class UpdateThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printTodo();
			}
		}
	}
	boolean isEditing=false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("change!");
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String content=(String)model.getValueAt(selectedIndex, 1);
				String regdate=(String)model.getValueAt(selectedIndex, 2);
				TodoDto dto=new TodoDto(num, content, regdate);
				new TodoDao().update(dto);
			}
			//isEditing 의 값을 반대로 바꿔준다. true => false, false => true
			isEditing=!isEditing;
		}
	}
}
