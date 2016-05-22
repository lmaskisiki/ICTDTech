package birthtech.enums;

public enum LabourStatusEnum {

	SUCCESS(1), FAIL(0);
	private int value;

	private LabourStatusEnum(int value) {
		this.value = value;
	}
	public int getEnumInt(){
				return value;
	}
	

}
