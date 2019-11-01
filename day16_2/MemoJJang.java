package day16_2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoJJang extends JFrame implements ActionListener{
	JTextArea ta1;
	JScrollPane sp1;
	JMenuBar mb;
	JMenu mFile, mHelp;
	JMenuItem miNew, miOpen, miSave, miExit, miHelp;
	JMenuItem miHelpHelp;
	
	MemoJJang(){
		super("*제목없음 - Windows 메모장");
		
		miNew = new JMenuItem("New");
		miOpen = new JMenuItem("OPEN");
		miSave = new JMenuItem("SAVE");
		miExit = new JMenuItem("EXIT");
		miHelp = new JMenuItem("HELP");
		
		mFile = new JMenu("FILE");
		mHelp = new JMenu("HELP");
		
		mb = new JMenuBar();
		
		// 메뉴에 메뉴아이템 부착
		mFile.add(miNew);	//메뉴에 메뉴옵션 부착
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miExit);
		
		mHelp.add(miHelp);	// 헬프에 헬프 부착
		
		// 메뉴바에 메뉴를 부착
		mb.add(mFile);	// 메뉴     메뉴
		mb.add(mHelp);	// 도움말  메뉴
		
		setJMenuBar(mb);
		
		// 이벤트 처리
		miNew.addActionListener(this);
		miOpen.addActionListener(this);
		miSave.addActionListener(this);
		miExit.addActionListener(this);
		
		miHelp.addActionListener(this);
		
		
		
		// 변경 내용을 내용 없음에 저장하시겠습니까?
		

		// 메뉴 아이템 - 메뉴바 - 프레임, (프레임(메뉴바(메뉴 아이템)))
		ta1 = new JTextArea("\n"
				+ "\\ (^  ^)/\n"
				+ "   |    |\r\n" 
				+ "   |     \\ \n...", 0 , 0);
		Font f = new Font("MyFont", Font.PLAIN, 30);
		ta1.setFont(f);
		ta1.setBounds(100, 200, 600, 600);

		// 프레임에 패널을 붙임. 나머지는 빈공간에 콤포넌트 삽입
		sp1 = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(sp1);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MemoJJang mj1 = new MemoJJang();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//e.getActionCommand() 
		Object obj = e.getSource();
		if(obj == miExit) {
			System.out.println("종료 메뉴 아이템 눌림");
			System.exit(0);
		}else if(obj == miNew) {
//			String data = ta1.getText();
//			if(data.length()!=0)
//			if(ta1.getText().isEmpty()) {
			if(ta1.getText().length()!=0) {
				int result = JOptionPane.showConfirmDialog(this, "저장할래?", 
											"메모장", JOptionPane.YES_NO_CANCEL_OPTION);
				System.out.println("누른버튼 결과값 : "+result);
				if(result == JOptionPane.YES_OPTION)
					System.out.println("저장한다");
//				else if(result == JOptionPane.NO_OPTION)
//				else if(result == JOptionPane.CANCEL_OPTION)
				
			}
			else{
				System.out.println("이미 비어있어...");
			}
			ta1.setText("");
			
		}else if(obj == miOpen) {
			System.out.println("열기 메뉴아이템 선택");
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(this);
			
			
		}else if(obj == miSave) {
			
		}else if(obj == miHelp) {

		}
	}
}
