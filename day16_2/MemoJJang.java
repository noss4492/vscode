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
		super("*������� - Windows �޸���");
		
		miNew = new JMenuItem("New");
		miOpen = new JMenuItem("OPEN");
		miSave = new JMenuItem("SAVE");
		miExit = new JMenuItem("EXIT");
		miHelp = new JMenuItem("HELP");
		
		mFile = new JMenu("FILE");
		mHelp = new JMenu("HELP");
		
		mb = new JMenuBar();
		
		// �޴��� �޴������� ����
		mFile.add(miNew);	//�޴��� �޴��ɼ� ����
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miExit);
		
		mHelp.add(miHelp);	// ������ ���� ����
		
		// �޴��ٿ� �޴��� ����
		mb.add(mFile);	// �޴�     �޴�
		mb.add(mHelp);	// ����  �޴�
		
		setJMenuBar(mb);
		
		// �̺�Ʈ ó��
		miNew.addActionListener(this);
		miOpen.addActionListener(this);
		miSave.addActionListener(this);
		miExit.addActionListener(this);
		
		miHelp.addActionListener(this);
		
		
		
		// ���� ������ ���� ������ �����Ͻðڽ��ϱ�?
		

		// �޴� ������ - �޴��� - ������, (������(�޴���(�޴� ������)))
		ta1 = new JTextArea("\n"
				+ "\\ (^  ^)/\n"
				+ "   |    |\r\n" 
				+ "   |     \\ \n...", 0 , 0);
		Font f = new Font("MyFont", Font.PLAIN, 30);
		ta1.setFont(f);
		ta1.setBounds(100, 200, 600, 600);

		// �����ӿ� �г��� ����. �������� ������� ������Ʈ ����
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
			System.out.println("���� �޴� ������ ����");
			System.exit(0);
		}else if(obj == miNew) {
//			String data = ta1.getText();
//			if(data.length()!=0)
//			if(ta1.getText().isEmpty()) {
			if(ta1.getText().length()!=0) {
				int result = JOptionPane.showConfirmDialog(this, "�����ҷ�?", 
											"�޸���", JOptionPane.YES_NO_CANCEL_OPTION);
				System.out.println("������ư ����� : "+result);
				if(result == JOptionPane.YES_OPTION)
					System.out.println("�����Ѵ�");
//				else if(result == JOptionPane.NO_OPTION)
//				else if(result == JOptionPane.CANCEL_OPTION)
				
			}
			else{
				System.out.println("�̹� ����־�...");
			}
			ta1.setText("");
			
		}else if(obj == miOpen) {
			System.out.println("���� �޴������� ����");
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(this);
			
			
		}else if(obj == miSave) {
			
		}else if(obj == miHelp) {

		}
	}
}
