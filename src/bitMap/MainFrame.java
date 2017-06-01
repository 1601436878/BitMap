package bitMap;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame {
	boolean flag = true;
	
	public static BitMap bitMap = new BitMap();
	private JFrame window;
	public static ArrayList<FileInfo> filelist;
	
	JLabel lb1 = new JLabel("文件名");
	private JTextField jtf1 = new JTextField();
	JLabel lb2 = new JLabel("文件大小");
	private JTextField jtf2 = new JTextField();
	JButton jb1 = new JButton("分配");
	JButton jb2 = new JButton("回收");
	JLabel lb3 = new JLabel("文件名");
	private JTextField jtf3 = new JTextField();
	private JPanel weiPanel = new JPanel();
	
	public MainFrame(){
		filelist = new ArrayList<FileInfo>();
		initUI();
	}
	
	/**
	 * 刷新图形化中的二维数组
	 */
	public void refresh(){

		weiPanel.removeAll();
		for (int i = 1; i <=16; i++){
			for (int j = 1; j <= 16; j++){
				weiPanel.add(new JLabel(String.valueOf(bitMap.getElement(i, j))));
			}
		}
		window.setSize(window.getWidth()+1, window.getHeight()+1);
	}
	
	public void initUI(){
		window = new JFrame("显示窗口");
		window.setBounds(100, 100, 400, 500);
		window.setLayout(null);
		window.add(lb1);
		window.add(jtf1);
		window.add(lb2);
		window.add(jtf2);
		window.add(jb1);
		window.add(jb2);
		window.add(lb3);
		window.add(jtf3);
		window.add(weiPanel);
		
		lb1.setBounds(40, 350, 100, 20);
		jtf1.setBounds(80, 350, 50, 20);
		lb2.setBounds(150, 350, 100, 20);
		jtf2.setBounds(200, 350, 50, 20);
		jb1.setBounds(270, 350, 80, 20);
		lb3.setBounds(40, 400, 100, 20);
		jtf3.setBounds(80, 400, 50, 20);
		jb2.setBounds(150, 400, 100, 20);
		weiPanel.setBounds(20, 0, 350, 350);
		
		weiPanel.setLayout(new GridLayout(16, 16));
		for (int i = 1; i <=16; i++){
			for (int j = 1; j <= 16; j++){
				weiPanel.add(new JLabel(String.valueOf(bitMap.getElement(i, j))));
			}
		}
		
		jb1.addActionListener(new ActionListener() {		// 分配   监听
			public void actionPerformed(ActionEvent e) {
				String filename = jtf1.getText();//获取文件名
				int filesize = Integer.parseInt(jtf2.getText());//获取文件大小
				Assignn assi = new Assignn();
				int index = assi.fenPei(filename, filesize);
				if(index != -1)
	  	    	{
	  				Assign as = new Assign(filename,filesize,index);
	  				as.setVisible(true);
	  	    	}else{
	  	    		JOptionPane.showMessageDialog(null,"没有足够的空间!","错误",JOptionPane.ERROR_MESSAGE);
	  	    	}
				refresh();
			}
		});
		
		jb2.addActionListener(new ActionListener() {		// 回收  监听
			public void actionPerformed(ActionEvent e) {
				String fileName = jtf3.getText();
				Release r = new Release();
				r.release(fileName);
				refresh();
			}
				
		});
		
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
}
