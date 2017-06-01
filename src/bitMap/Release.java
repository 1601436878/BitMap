package bitMap;

public class Release {
	
	public Release() {
	}

	public void release(String fileName){
		FileInfo f = getFileInfo(fileName);
		update(f);
	}
	/**
	 * 获得文件名
	 * @param fileName
	 * @return
	 */
	public FileInfo getFileInfo(String fileName){
		for (FileInfo item : MainFrame.filelist) {
			if ( item.getFileName().equals(fileName) ){
				return item;
			}
		}
		return null;
	}
	/**
	 * 更新二维数组
	 * @param f
	 */
	public void update(FileInfo f){
		int row = f.getRow();
		int col = f.getCol();
		int size = f.getFileSize();
		boolean isRelease = MainFrame.bitMap.getElement(row, col) == 1 ? true : false;
		
		int count = size;
		boolean find = false;
		for (int i = 1; i <= 16; i++){
			for (int j = 1; j <= 16; j++){
				if (i == row && j == col){
					find = true;
					if (isRelease){
						MainFrame.bitMap.setElement(i, j, 0);
						count--;
					} else {
						MainFrame.bitMap.setElement(i, j, 1);
						count--;
					}
					continue;
				}

				if (count > 0 && find)
				{
					if (isRelease){
						MainFrame.bitMap.setElement(i, j, 0);
						count--;
					} else {
						MainFrame.bitMap.setElement(i, j, 1);
						count--;
					}
				}
			}
		}
	}
}
