package Bit;

import javax.swing.JOptionPane;

public class ReleaseMany 
{
	int count=0;
	boolean check=false;
//	计数器
	int count_release=0;
	
	public void run(int k,int b[][])
	{
		int releasemany=k;
		int array_many[][]=b;

//		计算可以释放的磁盘数
		for(int i=0;i<40;i++)
		{
			for(int j=0;j<16;j++)
			{
				if(array_many[i][j]==1)
				{
					count+=1;
				}
			}
		}
//		判断是否有足够的磁盘可以释放
		if(count<releasemany)
		{
			JOptionPane.showMessageDialog(null,"您申请释放的"+releasemany+" 个磁盘数已经不够"+"\n现在可释放的磁盘总数为"+count+"，请重新输入磁盘数！","错误",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			for(int i=0;i<40;i++)
			{
				for(int j=0;j<16;j++)
				{
					if(array_many[i][j]==1)
					{
						count_release++;
//						将这一个磁盘标识为已经分配
						array_many[i][j]=0;
						JOptionPane.showMessageDialog(null,"您申请释放的第"+count_release+"磁盘号为"+((i*16)+j+1)+" 的磁道号为"+(i+1)+" 物理块号为"+(j+1)+"\n现在可用的磁盘数为："+count++,"正确",JOptionPane.INFORMATION_MESSAGE);
						AttributeDisk.show(array_many);
						if(count_release==releasemany)
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
	}
}
