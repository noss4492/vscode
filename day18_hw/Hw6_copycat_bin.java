package day18_hw;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hw6_copycat_bin extends JFrame implements ActionListener {
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

	public Hw6_copycat_bin() {
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
		Hw6_copycat_bin copycat = new Hw6_copycat_bin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnStart) { // 카피 버튼 누르면 파일 생성 시작
			// 필요한 경로 tf1의 txtfield , tf2의 txtfield 를 가지고 파일 읽고 그걸로 다시 생성.
			try {
				String target = tf1.getText();
				FileInputStream fis = new FileInputStream(target);
				BufferedInputStream br = new BufferedInputStream(fis);
				String replica = tf2.getText();
				FileOutputStream fos = new FileOutputStream(replica);
				BufferedOutputStream bw = new BufferedOutputStream(fos);

				int data;
				// 모든 확장자의 파일을 복사하여야 할 목적이 있으므로 byte로 옮김
				while ((data = fis.read()) != -1) {
					bw.write(data);
				}
				bw.flush();
				System.out.println("복사본 생성됨" + replica);
				// 만약 파일이 중복된다면 다일얼로그 하나 더 생성해서 경고창 만듬
//				boolean isExists = replica.exists();

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
				br.close();
				bw.close();
				fis.close();
				fos.close();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (obj.equals(btnLoad)) {
			JFileChooser jfc = new JFileChooser(); 		// filechooser 생성
			jfc.showOpenDialog(this); 					// show chooser dialog
			
			File target = jfc.getSelectedFile(); 		// 선택된 파일을 객체로 받음
			this.tf1.setText(target.getAbsolutePath()); // 절대경로 생성
		} else if (obj == btnSave) { 					// 위의 load경로 지정과 같은 문제로 볼 수 있음.
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(this);
			
			File target = jfc.getSelectedFile();
			String tmpTxt1 = tf1.getText();
			String tmpTxt2 = target.getAbsolutePath();
			if(!tmpTxt1.isEmpty()) {
				int pos1 = tmpTxt1.lastIndexOf('.');
				if(tmpTxt1.lastIndexOf('.') != -1) {
					String ext = tmpTxt1.substring(pos1, tmpTxt1.length());
					tmpTxt2 += ext;
				}
			}
			this.tf2.setText(tmpTxt2);
		}
	}
}
