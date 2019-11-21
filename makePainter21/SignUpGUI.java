package makePainter21;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
  
public class SignUpGUI extends JFrame implements ActionListener {
    JLabel txtId, txtPw, txtPwcon, txtName;
    JTextField inputId, inputName;
    JPasswordField inputPw, inputPwcon;
    JButton btnSignup, btnCencel, btnOverLap;
    JToggleButton btnChar1, btnChar2, btnChar3, btnChar4;
      
    JPanel background;
    JLabel backImg,charSelect;
      
    String userId = null;
    char[] pwd = null;
    char[] pwd1 = null;
    String nickName = null;
    String charImage = null;
    CatchMindDAO dao = new CatchMindDAO();
    boolean flag = false;
    boolean overLap = false;
    String number1 = null;
    String number2 = null;
      
    ButtonGroup bg = null;
    ImageIcon stopImg1;
    ImageIcon stopImg2;
    ImageIcon stopImg3;
    ImageIcon stopImg4;
         
  
    SignUpGUI() {
        super("ȸ������");
  
        // Layout �ʱ�ȭ
        setLayout(null);
          
        //��Ŷ
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dmen = tool.getScreenSize();
        double scr_Width = dmen.getWidth();
        double scr_Height = dmen.getHeight();
        int widthX = (int)(scr_Width/2 - 610/2); 
        int heightY = (int)(scr_Height/2 - 700/2);
  
        // ������Ʈ �ʱ�ȭ
        background = new JPanel();
        backImg = new JLabel(new ImageIcon("src/images/signupBack.png"));
          
        btnSignup = new JButton(new ImageIcon("src/images/signup.png"));
        btnCencel = new JButton(new ImageIcon("src/images/cencel.png"));
        btnOverLap = new JButton("�ߺ��˻�");
  
        // ���� ĳ���� �̹��� �ʱ�ȭ
        bg = new ButtonGroup();
        stopImg1 = new ImageIcon("src/images/stopChar1.png");
        stopImg2 = new ImageIcon("src/images/stopChar2.png");
        stopImg3 = new ImageIcon("src/images/stopChar3.png");
        stopImg4 = new ImageIcon("src/images/stopChar4.png");
          
          
        // ��ư�� ������ư Ŭ��
        btnChar1 = new JToggleButton(stopImg1);
        btnChar2 = new JToggleButton(stopImg2);
        btnChar3 = new JToggleButton(stopImg3);
        btnChar4 = new JToggleButton(stopImg4);
  
        txtId = new JLabel("        ���̵�");
        txtPw = new JLabel("      ��й�ȣ");
        txtPwcon = new JLabel(" ��й�ȣ Ȯ��");
        txtName = new JLabel("         �г���");
  
        inputId = new JTextField();
        inputPw = new JPasswordField();
        inputPwcon = new JPasswordField();
        inputName = new JTextField();
        charSelect = new JLabel("             SELELCT");
        Font selectFont = new Font("Arial",Font.BOLD,20);
        charSelect.setFont(selectFont);
  
        // ������Ʈ ������
        btnSignup.setBounds(160, 590, 140, 50);
        btnSignup.addActionListener(this);
        btnCencel.setBounds(310, 590, 140, 50);
        btnCencel.addActionListener(this);
        btnOverLap.setBounds(450, 119, 90, 32);
        btnOverLap.addActionListener(this);
  
        btnChar1.setBounds(10, 400, 140, 160);
        btnChar1.addActionListener(this);
        btnChar2.setBounds(160, 400, 140, 160);
        btnChar2.addActionListener(this);
        btnChar3.setBounds(310, 400, 140, 160);
        btnChar3.addActionListener(this);
        btnChar4.setBounds(460, 400, 140, 160);
        btnChar4.addActionListener(this);
  
        txtId.setBounds(145, 120, 90, 30);
        txtPw.setBounds(145, 190, 90, 30);
        txtPwcon.setBounds(145, 230, 90, 30);
        txtName.setBounds(145, 300, 90, 30);
  
        inputId.setBounds(240, 120, 200, 30);
        inputPw.setBounds(240, 190, 200, 30);
        inputPwcon.setBounds(240, 230, 200, 30);
        inputName.setBounds(240, 300, 200, 30);
  
        charSelect.setBounds(180, 360, 240, 30);
        background.setSize(610,700);
        //border
        LineBorder basicBorder = new LineBorder(Color.white);
        btnChar1.setBorder(basicBorder);
        btnChar2.setBorder(basicBorder);
        btnChar3.setBorder(basicBorder);
        btnChar4.setBorder(basicBorder);
   
        inputId.setBorder(null);
        inputPw.setBorder(null);
        inputPwcon.setBorder(null);
        inputName.setBorder(null);
        
        // Color / ����
        Color tran = new Color(0, 0, 0, 80);
        txtId.setOpaque(true);
        txtId.setBackground(tran);
        txtId.setForeground(Color.white);
        txtPw.setOpaque(true);
        txtPw.setBackground(tran);
        txtPw.setForeground(Color.white);
        txtPwcon.setOpaque(true);
        txtPwcon.setBackground(tran);
        txtPwcon.setForeground(Color.white);
        txtName.setOpaque(true);
        txtName.setBackground(tran);
        txtName.setForeground(Color.white);
        btnOverLap.setBackground(new Color(197,148,91));
        btnOverLap.setForeground(Color.white);
        charSelect.setOpaque(true);
        charSelect.setBackground(new Color(0,100,161));
        charSelect.setForeground(Color.white);
          
        // ������Ʈ add
        add(btnSignup);
        add(btnCencel);
        add(btnOverLap);
  
        bg.add(btnChar1);
        bg.add(btnChar2);
        bg.add(btnChar3);
        bg.add(btnChar4);
        this.add(btnChar1);
        this.add(btnChar2);
        this.add(btnChar3);
        this.add(btnChar4);
  
        add(txtId);
        add(txtPw);
        add(txtPwcon);
        add(txtName);
  
        add(inputId);
        add(inputPw);
        add(inputPwcon);
        add(inputName);
  
        add(charSelect);
        
        background.add(backImg);
        add(background);
          
        // window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setBounds(widthX, heightY, 610, 700);
        setVisible(true);
  
    }
  
    // test main ----------------------------------
    public static void main(String[] args) {
        new GameClient();
    }// test main end ---------------------------------
  
    // Action Event -----------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
 
        userId = inputId.getText();
        pwd = inputPw.getPassword();
        pwd1 = inputPwcon.getPassword();
        nickName = inputName.getText();
 
        // passWordField char�迭�� ����
        // ==> String ��ü�� �ޱ�
        String password1 = new String(pwd);
        String password2 = new String(pwd1);
         
        if (obj == btnOverLap) {
             
            // ���� �˻�
            while (true) {
                if (userId.equals("")) {
                    JOptionPane.showConfirmDialog(this, "����", "����", JOptionPane.PLAIN_MESSAGE);
                    break;
                } // ����˻� end
 
                boolean isOk1 = dao.isExists1(userId);
                if (isOk1) {
                    overLap = true;
                    number1 = inputId.getText();
                    System.out.println(number1);
                     
                    System.out.println("overlap: " + overLap);
                    JOptionPane.showConfirmDialog(this, "ID�� �ߺ��Դϴ�", "�ߺ�", JOptionPane.PLAIN_MESSAGE);
                    break;
                } else {
                    overLap = true;
                    number1 = inputId.getText();
                    System.out.println(number1);
                     
                    System.out.println("overlap: " + overLap);
                    JOptionPane.showConfirmDialog(this, "ȸ�������� �����մϴ�.", "�ߺ�", JOptionPane.PLAIN_MESSAGE);
                    break;
                }           
            }
        }
        Hover hover = new Hover(btnChar1, btnChar2, btnChar3, btnChar4);
        // ĳ���� ����
         
        if (obj == btnChar1) {
            charImage = "��ī��";
            hover.HoverChar1();
            
        } else if (obj == btnChar2) {
            charImage = "Ǫ��";
            hover.HoverChar2();
             
        } else if (obj == btnChar3) {
            charImage = "���α�";
            hover.HoverChar3();
             
        } else if (obj == btnChar4) {
            charImage = "�̺���";
            hover.HoverChar4();
            
        }
        if (obj == btnSignup) { // ���Թ�ư !!!
            number2 = inputId.getText();
            while (true) {
                // ���� �˻�
                if (userId.equals("") || nickName.equals("") || charImage == null) {
                    JOptionPane.showConfirmDialog(this, "����", "����", JOptionPane.PLAIN_MESSAGE);
                    break;
                } // ����˻� end
  
                // ID �ߺ� �˻�
                if (overLap == false) {
                    System.out.println("overlap : " + overLap);
                    JOptionPane.showConfirmDialog(this, "ID �ߺ��˻縦 ���ּ���.", "�ߺ�", JOptionPane.PLAIN_MESSAGE);
                    break;
                } else if(!number1.equals(number2)) {
                    System.out.println("2��" + number1+":"+number2);
                    JOptionPane.showConfirmDialog(this, "ID �ߺ��˻縦 �ٽ� ���ּ���.", "�ߺ�", JOptionPane.PLAIN_MESSAGE);
                    break;
                } // ID �ߺ��˻� end
  
                // ��й�ȣ ���ϼ� �˻�
                if (password1.equals(password2)) {
                    System.out.println("��й�ȣ ����");
                } else {
                    JOptionPane.showConfirmDialog(this, "��й�ȣ�� �������� �ʽ��ϴ�", "��й�ȣ", JOptionPane.PLAIN_MESSAGE);
                    break;
                } // ��й�ȣ ���ϼ� �˻� end
  
                // �г��� �ߺ��˻�
                boolean isOk2 = dao.isExists2(nickName);
                if (isOk2) {
                    JOptionPane.showConfirmDialog(this, "�г����� �ߺ��Դϴ�", "�ߺ�", JOptionPane.PLAIN_MESSAGE);
                    break;
                } // �г��� �ߺ��˻� end
  
                // ȸ������
                flag = true;
                break;
            } // while end
  
            // ȸ�� ���� ����
            if (flag == true) {
                dao.insertOne(userId, password1, nickName, charImage);
                JOptionPane.showConfirmDialog(this, "ȸ������", "ȸ������", JOptionPane.PLAIN_MESSAGE);
                setVisible(false);
  
            } // btn_char1 ������ end
  
            // ��� ��ư !!
            // ��� ��ư !!
        } else if (obj == btnCencel) {
            setVisible(false);
        }
    }// Action Event end ---------------------------------
  
}