package bitMap;

public class FileInfo {
	private String fileName = null;
	private int fileSize;
	private int fileId;
	
	public FileInfo(String fileName, int fileSize,int id)
	{
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileId = id;
	}
	
	/**
	 * 获得文件名
	 * @return
	 */
	public String getFileName(){
		return this.fileName;
	}
	
	/**
	 * 获得文件大小
	 * @return
	 */
	public int getFileSize(){
		return this.fileSize;
	}
	
	/**
	 * 获得文件ID
	 * @return
	 */
	public int getID(){
		return fileId;
	}
	
	/**
	 * 获得行号
	 * @return
	 */
	public int getRow(){
		int size = this.fileId;
		int row = (size - 1) / 16 + 1;
		return row;
	}
	
	/**
	 * 获得列号
	 * @return
	 */
	public int getCol(){
		int size = this.fileId;
		return (size - 1) % 16 + 1;
	}
}


