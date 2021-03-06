package bitMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Assign extends JDialog{
	private JButton btnreturn = new JButton("返回显示窗口");
	
	JPanel p;
	JLabel info ;
	FileInfo file;
	
	public Assign(String filename,int filesize,int index){
		this.file = new FileInfo(filename,filesize,index);
		
		setTitle("分配成功窗口");
		setBounds(100,100,600,150);
		initUI();
		setVisible(true);
	}
	
	public void initUI(){
		info = new JLabel();
		
		setLayout(null);
		
		btnreturn.setBounds(420, 40, 120, 20);
		info.setBounds(10, 0, 380, 100);
		
		String fileInfo = "" ;
		fileInfo += "文件名："+file.getFileName()+",  ";
		fileInfo += "大小："+file.getFileSize()+",  ";
		fileInfo += "起始盘块号"+file.getID()+",  ";
		fileInfo += "位于位示图的第"+file.getRow()+"行, 第"+file.getCol()+"列";
		
		info.setText(fileInfo);
			
		add(btnreturn);
		add(info);
		setVisible(true);

		btnreturn.addActionListener(new ActionListener(){//返回主界面监听
			public void actionPerformed(ActionEvent e){			
				dispose();
			}
		});
	}
}
