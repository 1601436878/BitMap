package Bit;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author 刘善木
 *今天是星期二，现在还有一个问题：就是要把得到的位示图写回原来的位示图，现在我还沿有实现，现在要努力了。
 * 今天是星期三，就是那个覆盖位示图写回原来的位示图，就是现在的这个位示图，会变，这应该是将二维数组
 * 转换为一维数组的时候出了问题。这还需要修改。努力！
 * 
 */

public class AttributeDisk extends JFrame implements ActionListener
{
	private final static long serialVersionUID=1L;
	
	private static String REGEX_EXPRESSION="[a-zA-Z]$";
//	申请和释放的标签
	private JLabel ApplyLabel=new JLabel("申请磁盘号：");
	private JLabel ReleaseLabel=new JLabel("释放磁盘号：");
//	申请和释放的文本框
	private JTextField ApplyText=new JTextField(5);
	private JTextField ReleaseText=new JTextField(5);
//	申请和释放的按钮
	private JButton ApplyButton=new JButton("申请");
	private JButton ReleaseButton=new JButton("释放");
//	申请和释放多个的标签
	private JLabel ApplyManyLabel=new JLabel("申请");
	private JLabel ReleaseManyLabel=new JLabel("释放");
//	申请和释放多外的文本框
	private JTextField ApplyManyText=new JTextField(5);
	private JTextField ReleaseManyText=new JTextField(5);
//	申请和释放多个的标签
	private JLabel ApplyManyLabel_2=new JLabel("个磁盘");
	private JLabel ReleaseManyLabel_2=new JLabel("个磁盘");
//	申请和释放多个的按钮
	private JButton ApplyManyButton=new JButton("申请");
	private JButton ReleaseManyButton=new JButton("释放");
	
	private JLabel[] label_block = new JLabel[640];
//	保存位示图的数值
	private int array[][];
	
	private char serial[]={'0','1'};
	
//	private JPanel panel_diagram;
	
	private static JTextArea ta=new JTextArea(30,30);
	
	public AttributeDisk()
	{
		super();
		//设置标题
		this.setTitle("位示图磁盘管理"); 
//		初始化位示图数组,40行16列
		array=new int[40][16];
//		初始化位示图
		this.init();
		this.setLocation(200,0);
		this.setSize(600,300);
//		this.setBounds(500,300,200,200);
		//面板的大小能变化
		this.setResizable(true); 
		pack();
	}
	
//	初始化
	public void init()
	{
		Font font = new Font("Dialog", Font.BOLD, 14);
		ApplyLabel.setFont(font);
		ReleaseLabel.setFont(font);
		ApplyText.setFont(font);
		ReleaseText.setFont(font);
		ApplyButton.setFont(font);
		ReleaseButton.setFont(font);
		ApplyManyLabel.setFont(font);
		ReleaseManyLabel.setFont(font);
		ApplyManyText.setFont(font);
		ReleaseManyText.setFont(font);
		ApplyManyLabel_2.setFont(font);
		ReleaseManyLabel_2.setFont(font);
		ApplyManyButton.setFont(font);
		ReleaseManyButton.setFont(font);
		
		JPanel panel_ar=new JPanel();
		panel_ar.add(ApplyLabel);
		panel_ar.add(ApplyText);
		panel_ar.add(ApplyButton);
		
		JPanel panel_array=new JPanel();
		panel_array.add(ApplyManyLabel);
		panel_array.add(ApplyManyText);
		panel_array.add(ApplyManyLabel_2);
		panel_array.add(ApplyManyButton);
		
		JPanel panel_rb=new JPanel();
		panel_rb.add(ReleaseLabel);
		panel_rb.add(ReleaseText);
		panel_rb.add(ReleaseButton);
		
		JPanel panel_rbh=new JPanel();
		panel_rbh.add(ReleaseManyLabel);
		panel_rbh.add(ReleaseManyText);
		panel_rbh.add(ReleaseManyLabel_2);
		panel_rbh.add(ReleaseManyButton);
//		添加事件监听器
		ApplyButton.addActionListener(this);
		ApplyManyButton.addActionListener(this);
		ReleaseButton.addActionListener(this);
		ReleaseManyButton.addActionListener(this);
//		放置位示图
		JPanel panel_diagram=new JPanel();
//		网格布局，40行16列
		panel_diagram.setLayout(new GridLayout(40,16,2,1));
		
		for(int i=0;i<640;i++)
		{
			int horizon=i/16;//row
			int vertical=i%16;//col
			
			String strChar="";
			for(int k=0;k<1;k++)
			{
				strChar+=serial[(int)(serial.length*Math.random())];
			}
			label_block[i]=new JLabel(strChar);
			panel_diagram.add(label_block[i]);
//			array数组获得值
			array[horizon][vertical]=Integer.parseInt(strChar);
		}
		
		ta.setEditable(false);
		// 放置以上五个面板
		JPanel panel_main = new JPanel();
		JPanel p2=new JPanel(new BorderLayout());
		JPanel p3=new JPanel(new BorderLayout());
		JScrollPane p4=new JScrollPane(ta);
		// 边界布局管理器
		panel_main.setLayout(new GridLayout(1,3)); 
		panel_main.add(p2);
		panel_main.add(p3);
		panel_main.add(p4);
		p2.setLayout(new GridLayout(4,1));
		p2.add(panel_ar);
		p2.add(panel_array);
		p2.add(panel_rb);
		p2.add(panel_rbh);
		p3.add(panel_diagram);
//		panel_main.add(panel_ar, BorderLayout.SOUTH);
//		panel_main.add(panel_rb, BorderLayout.NORTH);
//		panel_main.add(panel_diagram, BorderLayout.NORTH);
		JScrollBar jscbVert=new JScrollBar(JScrollBar.VERTICAL);
//		JScrollBar jscbEast=new JScrollBar(JScrollBar.VERTICAL);
//		p2.add(jscbEast,BorderLayout.EAST);
		p3.add(jscbVert,BorderLayout.EAST);
		
		getContentPane().add(panel_main);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==ApplyButton)
		{
			boolean regex=Pattern.matches(REGEX_EXPRESSION,ApplyText.getText());
			if(Integer.parseInt(ApplyText.getText())>640)
			{
				JOptionPane.showMessageDialog(null,"您输入的磁盘号超过了总磁盘数，最大只能到640！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(Integer.parseInt(ApplyText.getText())<0 || Integer.parseInt(ApplyText.getText())==0)
			{
				JOptionPane.showMessageDialog(null,"必须输入大于0的整数,且最小为1！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(ApplyText.getText()==null)
			{
				JOptionPane.showMessageDialog(null,"输入数据不能为空！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(regex)
			{
				JOptionPane.showMessageDialog(null,"不能为字符，必须是数字！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int one=Integer.parseInt(ApplyText.getText());
				ApplyOne ao=new ApplyOne();
				ao.run(one,array);
			}
		}
		
		if(e.getSource()==ReleaseButton)
		{
			boolean regex=Pattern.matches(REGEX_EXPRESSION,ReleaseText.getText());
			if(Integer.parseInt(ReleaseText.getText())>640)
			{
				JOptionPane.showMessageDialog(null,"您输入的磁盘号超过了总磁盘数，且最大只能到640！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(Integer.parseInt(ReleaseText.getText())<0 || Integer.parseInt(ReleaseText.getText())==0)
			{
				JOptionPane.showMessageDialog(null,"必须输入大于0的整数！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(ReleaseText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"输入数据不能为空！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(regex)
			{
				JOptionPane.showMessageDialog(null,"不能为字符，必须是数字！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int one=Integer.parseInt(ReleaseText.getText());
				ReleaseOne ro=new ReleaseOne();
				ro.run(one,array);
			}
		}
		
		if(e.getSource()==ApplyManyButton)
		{
			boolean regex=Pattern.matches(REGEX_EXPRESSION,ApplyManyText.getText());
			if(Integer.parseInt(ApplyManyText.getText())>640)
			{
				JOptionPane.showMessageDialog(null,"您输入的磁盘号超过了总磁盘数，且最大只能到640！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(Integer.parseInt(ApplyManyText.getText())<0 || Integer.parseInt(ApplyManyText.getText())==0)
			{
				JOptionPane.showMessageDialog(null,"必须输入大于0的整数！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(ApplyManyText.getText()==null)
			{
				JOptionPane.showMessageDialog(null,"输入数据不能为空！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(regex)
			{
				JOptionPane.showMessageDialog(null,"不能为字符，必须是数字！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int one=Integer.parseInt(ApplyManyText.getText());
				ApplyMany am=new ApplyMany();
				am.run(one,array);
			}
		}
		
		if(e.getSource()==ReleaseManyButton)
		{
			boolean regex=Pattern.matches(REGEX_EXPRESSION,ReleaseManyText.getText());
			if(Integer.parseInt(ReleaseManyText.getText())>640)
			{
				JOptionPane.showMessageDialog(null,"您输入的磁盘号超过了总磁盘数，且最大只能到640！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(Integer.parseInt(ReleaseManyText.getText())<0 || Integer.parseInt(ReleaseManyText.getText())==0)
			{
				JOptionPane.showMessageDialog(null,"必须输入大于0的整数！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(ReleaseManyText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"输入数据不能为空！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else if(regex)
			{
				JOptionPane.showMessageDialog(null,"不能为字符，必须是数字！","错误",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int many=Integer.parseInt(ReleaseManyText.getText());
				ReleaseMany rm=new ReleaseMany();
				rm.run(many,array);
			}
		}
	}
	
	public static void show(int array_temp[][])
	{
//		测试用例
		ta.setText("");
		for(int i=0;i<40;i++)
		{
			for(int j=0;j<16;j++)
			{
				ta.append(" "+array_temp[i][j]+"  ");
				if((j+1)%16==0)
				{
					ta.append("\n");
				}
			}
		}
	}
	public static void main(String args[])
	{
		new AttributeDisk();
	}
}
