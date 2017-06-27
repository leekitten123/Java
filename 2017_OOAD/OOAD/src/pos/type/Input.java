package pos.type;

public abstract class Input {

	private int dataNum1;
	private int dataNum2;
	
	private String dataName;

	public Input(int dataNum1, int dataNum2, String dataName) {
		
		setDataNum1(dataNum1);
		setDataNum2(dataNum2);
		setDataName(dataName);
	}
	
	public void setDataNum1(int dataNum1) { this.dataNum1 = dataNum1; }
	public void setDataNum2(int dataNum2) { this.dataNum2 = dataNum2; }
	public void setDataName(String dataName) { this.dataName = dataName; }
	
	public int getDataNum1() { return this.dataNum1; }
	public int getDataNum2() { return this.dataNum2; }
	public String getDataName() { return this.dataName; }
}
