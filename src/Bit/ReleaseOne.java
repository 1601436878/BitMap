package Bit;

import javax.swing.JOptionPane;

public class ReleaseOne 
{
	int count=0;
	
	public void run(int k,int b[][])
	{
		int applyone=k;
		int array_one[][]=b;
		
		int horizon=applyone/16;
		int vertical=applyone%16;
		
//		计数器,计算可以使用的磁盘数
		
		for(int i=0;i<40;i++)
		{
			for(int j=0;j<16;j++)
			{
				if(array_one[i][j]==0)
				{
					count+=1;
				}
			}
		}
		
		if(applyone==16)
		{
			if(array_one[0][15]==1)
			{
				array_one[0][15]=0;
				JOptionPane.showMessageDialog(null,"您申请释放的磁盘号为"+applyone+" 的磁道号为"+horizon+" 物理块号为16!\n现在可用的磁盘数为："+count++,"正确",JOptionPane.INFORMATION_MESSAGE);
				AttributeDisk.show(array_one);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"您申请释放的"+applyone+"号磁盘的磁道号为"+horizon+" 物理块号为16!\n没有使用，不能释放，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(vertical==0 && applyone!=16 && applyone!=640)
		{
			int temp=horizon-1;
			if(array_one[temp][15]==1)
			{
				array_one[temp][15]=0;
				JOptionPane.showMessageDialog(null,"您申请释放的磁盘号为"+applyone+" 的磁道号为"+horizon+" 物理块号为16!\n现在可用的磁盘数为："+count++,"正确",JOptionPane.INFORMATION_MESSAGE);
				AttributeDisk.show(array_one);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"您申请释放的"+applyone+"磁盘号的磁道号为"+horizon+" 物理块号为16!\n没有被使用，不能释放，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(applyone==640)
		{
			int tem=horizon-1;
			if(array_one[tem][15]==1)
			{
				array_one[tem][15]=0;
				JOptionPane.showMessageDialog(null,"您申请释放的磁盘号为"+applyone+" 的磁道号为"+horizon+" 物理块号为16!\n现在可用的磁盘数为："+count++,"正确",JOptionPane.INFORMATION_MESSAGE);
				AttributeDisk.show(array_one);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"您申请释放的"+applyone+" 磁盘的磁道号为"+horizon+" 物理块号为16!\n没有被使用，不能释放，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			for(int i=0;i<40;i++)
			{
				for(int j=0;j<16;j++)
				{
					if(array_one[horizon][vertical-1]==0)
					{
						JOptionPane.showMessageDialog(null,"您申请释放的"+applyone+" 磁盘的磁道号为"+(horizon+1)+" 物理块号为"+vertical+"\n未被使用，不能释放了，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else
					{
						JOptionPane.showMessageDialog(null,"您申请释放的磁盘号为"+applyone+" 的磁道号为"+(horizon+1)+" 物理块号为"+vertical+" 释放"+"\n现在可用的磁盘数为："+count++,"正确",JOptionPane.INFORMATION_MESSAGE);
						array_one[horizon][vertical-1]=0;
//						在这里，让现在的位示图去覆盖已经存在的位示图
						AttributeDisk.show(array_one);
						break;
					}
				}
				break;
			}
		}
		
	}
}
