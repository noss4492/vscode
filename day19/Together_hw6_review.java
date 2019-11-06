package day19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Together_hw6_review extends JFrame implements ActionListener {
	JLabel jlbSource, jlbDest;
	JTextField jtfSource, jtfDest;
	JButton jbtnOpen, jbtnSave, jbtnCopy;

	public Together_hw6_review() {
		// 배치관리자 null
		setLayout(null);
		// 컴포넌트 초기화
		jlbSource = new JLabel("SOURCE");
		jlbDest = new JLabel("DEST");
		jtfSource = new JTextField(150);
		jtfDest = new JTextField(150);
		jbtnOpen = new JButton("OPEN");
		jbtnSave = new JButton("SAVE");
		jbtnCopy = new JButton("COPY");

		// 컴포넌트 크기와 위치 지정
		jlbSource.setBounds(50, 100, 100, 50);
		jlbDest.setBounds(50, 200, 100, 50);
		jtfSource.setBounds(150, 100, 350, 50);
		jtfDest.setBounds(150, 200, 350, 50);
		jbtnOpen.setBounds(600, 100, 100, 50);
		jbtnSave.setBounds(600, 200, 100, 50);
		jbtnCopy.setBounds(250, 300, 350, 50);

		add(jlbSource);
		add(jlbDest);
		add(jtfSource);
		add(jtfDest);
		add(jbtnOpen);
		add(jbtnSave);
		add(jbtnCopy);

		jbtnOpen.addActionListener(this);
		jbtnSave.addActionListener(this);
		jbtnCopy.addActionListener(this);

		// 컨테이너에 부착
		setBounds(100, 100, 800, 450);
		setVisible(true);
	}

	public static void main(String[] args) {
		Together_hw6_review h = new Together_hw6_review();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (jbtnCopy == e.getSource()) {
			System.out.println("0");
			// 카피 버튼 눌렀을때 텏필1 텏필2 정보로 카피 시작
			// 파일인풋스트림 파일아웃풋스트림 버퍼드인풋 버퍼드 아웃풋
			// 파일 객체 2개 생성
			// 파일 읽어서
			// 파일 저장
			try {
				File f1 = new File(jtfSource.getText());
				File f2 = new File(jtfDest.getText());
				FileInputStream fis = new FileInputStream(f1);
				BufferedInputStream bis = new BufferedInputStream(fis);
				
				FileOutputStream fos = new FileOutputStream(f2);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				
				int value = 0;
				while( (value = bis.read()) != -1 ) {
					bos.write(value);
					System.out.print((char)value);
				}
				
				bos.flush();
				fis.close();
				bis.close();
				fos.close();
				bos.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (jbtnOpen == e.getSource()) {
			System.out.println("1");
			JFileChooser jfc = new JFileChooser();
			int result = jfc.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				File f = jfc.getSelectedFile();
				System.out.println(f.getAbsolutePath());
				jtfSource.setText(f.getAbsolutePath());
			}
		} else if (jbtnSave == e.getSource()) {
			System.out.println("2");
			JFileChooser jfc = new JFileChooser();
			int result = jfc.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				File f = jfc.getSelectedFile();
				System.out.println(f.getAbsolutePath());
				jtfDest.setText(f.getAbsolutePath());
			}
		}

	}
}