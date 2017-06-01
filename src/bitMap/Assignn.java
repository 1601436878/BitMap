package bitMap;


public class Assignn {
	
	/**
	 * 根据文件名和文件大小分配空间
	 * @param fileName
	 * @param size
	 * @return
	 */
	public int fenPei (String fileName,int size){
		int index  = getSpace(size);
		if(index == -1 )
			return -1;
		FileInfo file = new FileInfo(fileName,size,index);
		MainFrame.filelist.add(file);
		
		this.changeValueID(file);
		return index;
	}
	
	/**
	 * 根据文件大小和起始位置更新二维数组
	 * @param f
	 */
	public void update(FileInfo f){
		int row = f.getRow();
		int col = f.getCol();
		int size = f.getFileSize();

		int count = size;
		boolean isRelease = MainFrame.bitMap.getElement(row, col) == 1 ? true : false;

		for (int i = row; i <= 16; i++) {
			for (int j = col; j <= 16; j++) {
				if (count > 0) {
					if (isRelease){
						MainFrame.bitMap.setElement(i, j, 0);
						count--;
					}else{
						MainFrame.bitMap.setElement(i, j, 1);
						count--;
					}					
				}
				continue;
			}
		}
	}
	
	public void changeValueID(FileInfo file){
		for (int i = file.getID() ; i < file.getID()+file.getFileSize(); i++){
			MainFrame.bitMap.setElementByID(i, 1);
		}
	}
	
	/**
	 * 获取最大可用空间的起始块号
	 * @param size
	 * @return
	 */
	public int getSpace(int size){
		int flag = 0 ;
		for (int i = 1 ; i <= 16 ; i++){
			for (int j = 1 ; j <= 16; j++){
				if(MainFrame.bitMap.getElement(i, j) == 0){
					flag++ ;
					if (flag >= size){
						int index = MainFrame.bitMap.getIndex(i,j);
						return index-size+1;
					}
				}else{
					flag = 0 ;
				}
			}
		}
		return -1;
	}
	
	
	/*
	public static void main(String[] args) {
		Assignn sss = new Assignn();
		for(int i = 1 ; i <= 16 ; i ++){
			for(int j = 1 ; j <= 16 ; j++){
				System.out.print(MainFrame.bitMap.getElement(i, j)+" ");
			}
			System.out.println();
		}
		
		sss.fenPei("1.txt", 5);
		System.out.println("----------------");
		for(int i = 1 ; i <= 16 ; i ++){
			for(int j = 1 ; j <= 16 ; j++){
				System.out.print(MainFrame.bitMap.getElement(i, j)+" ");
			}
			System.out.println();
		}
		
		for(FileInfo i :MainFrame.filelist){
			System.out.println(i.getFileName()+":"+i.getFileSize()+":"+i.getID()+":"+i.getRow()+":"+i.getCol());
		}
		
	}
	*/
	
}

