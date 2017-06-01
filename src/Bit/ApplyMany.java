package Bit;

import javax.swing.JOptionPane;

public class ApplyMany 
{
	int count=0;
	int count_attribute=0;
	
	public void run(int k,int b[][])
	{
		int applymany=k;
		int array_many[][]=b;
		boolean check=false;
//		计数器
		
		for(int i=0;i<40;i++)
		{
			for(int j=0;j<16;j++)
			{
				if(array_many[i][j]==0)
				{
					count+=1;
				}
			}
		}
//		判断是否有足够的空磁盘可用
		if(count<applymany)
		{
			JOptionPane.showMessageDialog(null,"您申请的"+applymany+" 个磁盘数已经不够"+"\n现在可用的磁盘总数为："+count+"，请重新输入磁盘数！","错误",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			for(int i=0;i<40;i++)
			{
				for(int j=0;j<16;j++)
				{
					if(array_many[i][j]==0)
					{
						count_attribute++;
//						将这一个磁盘标识为已经分配
						array_many[i][j]=1;
						JOptionPane.showMessageDialog(null,"您申请的第"+count_attribute+"个磁盘的磁盘号为"+((i*16)+j+1)+" 的磁道号为"+(i+1)+" 物理块号为"+(j+1)+"\n现在可用的磁盘数为："+count--,"正确",JOptionPane.INFORMATION_MESSAGE);
						AttributeDisk.show(array_many);
						if(count_attribute==applymany)
						{
							check=true;
							break;
						}
					}
				}
				if(check)
				{
					break;
				}
			}
			
			
		}
//		在这里，让现在的位示图去覆盖已经存在的位示图
		
	}
}
