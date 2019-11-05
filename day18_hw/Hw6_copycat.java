package day18_hw;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Hw6_copycat extends JFrame implements ActionListener {
	// 라벨 2개 텍필 2개 버튼 2개
	// 버튼 1개
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	final static int OUTTER_MARGIN = 60;
	final static int MARGIN = 30;
	final static int TF_WIDTH = 450;
	final static int TF_HEIGHT = 50;
	final static int LB_WIDTH = 70;
	final static int SIDE_BTN_WIDTH = 80;

	JLabel lb1, lb2;
	JTextField tf1, tf2;
	JButton btnLoad, btnSave;
	JButton btnStart;
	Font f1 = new Font("MyFont", Font.PLAIN, 30);
	Font f2 = new Font("MyFont", Font.PLAIN, 100);

	public Hw6_copycat() {
		super("미련한 복사기");
		setLayout(null);

		lb1 = new JLabel("Source");
		lb2 = new JLabel("Destination");
		tf1 = new JTextField();
		tf2 = new JTextField();
		btnLoad = new JButton("browse");
		btnSave = new JButton("browse");
		btnStart = new JButton("^ↀᴥↀ^");

		lb1.setBounds(OUTTER_MARGIN, OUTTER_MARGIN, LB_WIDTH, TF_HEIGHT);
		lb2.setBounds(OUTTER_MARGIN, OUTTER_MARGIN + TF_HEIGHT + MARGIN, LB_WIDTH, TF_HEIGHT);
		add(lb1);
		add(lb2);

		tf1.setBounds(OUTTER_MARGIN + LB_WIDTH + MARGIN, OUTTER_MARGIN, TF_WIDTH, TF_HEIGHT);
		tf2.setBounds(OUTTER_MARGIN + LB_WIDTH + MARGIN, OUTTER_MARGIN + TF_HEIGHT + MARGIN, TF_WIDTH, TF_HEIGHT);
		add(tf1);
		add(tf2);

		btnLoad.setBounds(OUTTER_MARGIN + LB_WIDTH + MARGIN + TF_WIDTH + MARGIN, OUTTER_MARGIN, SIDE_BTN_WIDTH,
				TF_HEIGHT);
		btnSave.setBounds(OUTTER_MARGIN + LB_WIDTH + MARGIN + TF_WIDTH + MARGIN, OUTTER_MARGIN + TF_HEIGHT + MARGIN,
				SIDE_BTN_WIDTH, TF_HEIGHT);
		btnLoad.addActionListener(this);
		btnSave.addActionListener(this);
		add(btnLoad);
		add(btnSave);

		btnStart.setBounds(OUTTER_MARGIN, OUTTER_MARGIN + (TF_HEIGHT + MARGIN) * 2,
				LB_WIDTH + MARGIN + TF_WIDTH + MARGIN + SIDE_BTN_WIDTH, HEIGHT - TF_HEIGHT * 6);
		btnStart.setFont(f2);
		btnStart.addActionListener(this);
		add(btnStart);

		setSize(WIDTH, HEIGHT);
		setLocation(30, 30);
		setVisible(true);
	}

	public static void main(String[] args) {
		Hw6_copycat copycat = new Hw6_copycat();

	}

//target replica
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnStart) { // 카피 버튼 누르면 파일 생성 시작
			// 필요한 경로 tf1의 txtfield , tf2의 txtfield 를 가지고 파일 읽고 그걸로 다시 생성.

			// 풀이 순서
			// filereader bufferedreader .read
			// filewriter bufferedwriter .write .flush
			try {
				File target = new File(tf1.getText());
				System.out.println(tf1.getText());
				FileReader fr;
				fr = new FileReader(target);
				BufferedReader br = new BufferedReader(fr);

				File replica = new File(tf2.getText());
				FileWriter fw = new FileWriter(replica);
				BufferedWriter bw = new BufferedWriter(fw);

				int value;
				StringBuffer strbuf = new StringBuffer();
				// String은 너무 immutable 객체의 약점이 강하게 들어남

				while ((value = br.read()) != -1) {
					strbuf.append((char) value);
				}
				System.out.println(strbuf);

				// 만약 파일이 중복된다면 다일얼로그 하나 더 생성해서 경고창 만듬
				boolean isExists = replica.exists();

//				if (isExists) {
//					int rsp = JOptionPane.showConfirmDialog(this, "이미 경로에 똑같은 파일이 있습니다. 저장하시겠습니까?", "메모장",
//							JOptionPane.YES_NO_CANCEL_OPTION);
//					if (rsp == JOptionPane.YES_OPTION) {
//						bw.write(strbuf.toString());
//						bw.flush();
//					} else {
//					}
//				} else {
//					bw.write(strbuf.toString());
//					bw.flush();
//				}
				bw.write(strbuf.toString());
				bw.flush();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (obj.equals(btnLoad)) {
			JFileChooser jfc = new JFileChooser(); // filechooser 생성
			jfc.showOpenDialog(this); // show chooser dialog
			File target = jfc.getSelectedFile(); // 선택된 파일을 객체로 받음
			this.tf1.setText(target.getAbsolutePath()); // 절대경로 생성
			System.out.println(target.getName());
		} else if (obj == btnSave) { // 위의 load경로 지정과 같은 문제로 볼 수 있음.
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(this);
			File target = jfc.getSelectedFile();
			this.tf2.setText(target.getAbsolutePath());
			System.out.println(target.getName());
		}
	}
}
