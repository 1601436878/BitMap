package bitMap;

public class BitMap {
	private int [][] bitMap ;
	
	public BitMap(){
		bitMap = new int[17][17];
		setRandom();
	}
	/**
	 * 用随机数初始化位示图
	 */
	public void setRandom(){
		for (int i = 1 ; i <= 16 ; i++){
			for (int j = 1 ; j <= 16 ; j++){
				int flag = Math.random()>0.5?1:0;
				bitMap[i][j] = flag;
			}
		}
	}
	
	/**
	 * 根据块号获得下标的i
	 * @param index
	 * @return
	 */
	public int getRow(int index){
		return (int)((index-1)/16+1);
	}
	
	/**
	 * 根据块号获得下标的j
	 * @param index
	 * @return
	 */
	public int getCol(int index){
		return (index-1)%16+1;
	}
	
	/**
	 * 根据下标获得块号
	 * @param i
	 * @param j
	 * @return
	 */
	public int getIndex(int i, int j){
		return 16*(i-1)+j;
	}
	
	/**
	 * 根据下标获得元素的值
	 * @param i
	 * @param j
	 * @return
	 */
	public int getElement(int i , int j ){
		return bitMap[i][j];
	}
	
	/**
	 * 根据下标更新元素的值
	 * @param i
	 * @param j
	 * @param value
	 */
	public void setElement(int i ,int j ,int value){
		bitMap[i][j] = value;
	}
	
	/**
	 * 根据ID值改变值
	 * @param index
	 * @param value
	 */
	public void setElementByID(int index,int value){
		int x = getRow(index);
		int y = getCol(index);
		bitMap[x][y] = value;
	}
}
