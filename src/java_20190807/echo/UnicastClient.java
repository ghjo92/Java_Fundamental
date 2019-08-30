package java_20190807.echo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class UnicastClient implements ActionListener{
	private String id;
	private String ip;
	private int port;
	private JFrame jframe;
	private JTextArea jta;
	private JTextField jtf;
	private JButton jbtn;
	
	public UnicastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		jframe = new JFrame("Unicast Chatting");
		
		jframe.setSize(300, 300);
		
		/***************중앙시작****************/
		jta = new JTextArea(30,30);
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setEditable(false);
		jta.setBackground(new Color(255,234,204));
		/***************중앙끝****************/
		
		
		/***************하단시작****************/
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		jbtn.setBackground(new Color(255,235,102));
		jtf.addActionListener(this);
		jbtn.addActionListener(this);
		
		JPanel j1 = new JPanel();
		j1.setLayout(new BorderLayout());
		j1.add(jtf, BorderLayout.CENTER);
		j1.add(jbtn, BorderLayout.EAST);
		
		/***************하단끝****************/
		
		/***************상단시작****************/
		JPanel j2 = new JPanel();
		JLabel jl1 = new JLabel("User ID : ["+id+"]");
		JLabel jl2 = new JLabel("Server IP : "+ip);
		j2.setLayout(new BorderLayout());
		j2.add(jl1, BorderLayout.CENTER);
		j2.add(jl2, BorderLayout.EAST);
		j2.setBackground(new Color(255,205,155));
		/***************상단끝****************/
		
		jframe.add(j2,BorderLayout.NORTH);
		jframe.add(jsp,BorderLayout.CENTER);
		jframe.add(j1,BorderLayout.SOUTH);
		
		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);
		
		
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
		
	}	
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("syh1011","127.0.0.1",5000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == jtf) {
			//텍스트 필드 가져오기
			String message = jtf.getText();
			if(message.trim().length()==0) {
				JOptionPane.showMessageDialog(jframe, "내용을쓰거라", "경고", JOptionPane.INFORMATION_MESSAGE);
			}else {
				//텍스트 에어리어 가져오기
				jta.append(id + ":" + message + "\n");
			}
			jtf.setText("");
		}else if(obj == jbtn) {			
			//텍스트 필드 가져오기
			String message = jtf.getText();
			if(message.trim().length()==0) {
				JOptionPane.showMessageDialog(jframe, "내용을쓰거라", "경고", JOptionPane.ERROR_MESSAGE);
			}else {
				//텍스트 에어리어 가져오기
				jta.append(id + ":" + message + "\n");
							
			}
			jtf.setText("");	
			jtf.requestFocus();
		}
		
		
	}
}
