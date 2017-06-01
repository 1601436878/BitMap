package Bit;

import javax.swing.JOptionPane;

public class ApplyOne 
{
//	计算器
	int count=0;
	
	public void run(int k,int b[][])
	{
		int applyone=k;
		int array_one[][]=b;

		for(int i=0;i<40;i++)
		{
			for(int j=0;j<16;j++)
			{
				if(array_one[i][j]==0)
				{
					count++;
				}
			}
		}
//		测试用例
/**
		for(int i=0;i<40;i++)
		{
			for(int j=0;j<16;j++)
			{
				System.out.print(array_one[i][j]+" ");
				if((j+1)%16==0)
				{
					System.out.println("\n");
				}
			}
		}
*/
//		System.out.println("可用磁盘总数为："+count);
		
		int horizon=applyone/16;
		int vertical=applyone%16;
		
		if(applyone==16)
		{
			if(array_one[0][15]==0)
			{
				JOptionPane.showMessageDialog(null,"您申请的磁盘号为"+applyone+" 的磁道号为"+horizon+" 物理块号为16!\n现在可用的磁盘数为："+count--,"正确",JOptionPane.INFORMATION_MESSAGE);
				array_one[0][15]=1;
				AttributeDisk.show(array_one);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"您申请的"+applyone+" 磁盘"+horizon+" 物理块号为16已被使用，不能申请了，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(vertical==0 && applyone!=16 && applyone!=640)
		{
			int temp=horizon-1;
			if(array_one[temp][15]==0)
			{
				JOptionPane.showMessageDialog(null,"您申请的磁盘号为"+applyone+" 的磁道号为"+horizon+" 物理块号为16!\n现在可用的磁盘数为："+count--,"正确",JOptionPane.INFORMATION_MESSAGE);
				array_one[temp][15]=1;
				AttributeDisk.show(array_one);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"您申请的"+applyone+" 磁盘的磁道号为"+horizon+" 物理块号为16已被使用，不能申请了，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(applyone==640)
		{
			int tem=horizon-1;
			if(array_one[tem][15]==0)
			{
				JOptionPane.showMessageDialog(null,"您申请的磁盘号为"+applyone+" 的磁道号为"+horizon+" 物理块号为16!\n现在可用的磁盘数为："+count--,"正确",JOptionPane.INFORMATION_MESSAGE);
				array_one[tem][15]=1;
				AttributeDisk.show(array_one);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"您申请的"+applyone+" 磁盘的磁道号为"+horizon+" 物理块号为16!\n已被使用，不能申请了，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			for(int i=0;i<40;i++)
			{
				for(int j=0;j<16;j++)
				{
					if(array_one[horizon][vertical-1]==1)
					{
						JOptionPane.showMessageDialog(null,"您申请的"+applyone+" 磁盘的磁道号为"+(horizon+1)+" 物理块号为"+vertical+"已被使用，不能申请了，请换另一个磁盘！","错误",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else
					{
						JOptionPane.showMessageDialog(null,"您申请的磁盘号为"+applyone+" 的磁道号为"+(horizon+1)+" 物理块号为"+vertical+"\n现在可用的磁盘数为："+count--,"正确",JOptionPane.INFORMATION_MESSAGE);
						array_one[horizon][vertical-1]=1;
						AttributeDisk.show(array_one);
//						在这里，让现在的位示图去覆盖已经存在的位示图
						
						break;
					}
				}
				break;
			}
		}
		
	}
}
