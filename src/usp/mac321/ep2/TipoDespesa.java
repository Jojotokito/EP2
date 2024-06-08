package usp.mac321.ep2;

public class TipoDespesa {
	private String mainType;
	private String specificType;
	
	public TipoDespesa(String mainType, String specificType) {
		this.mainType = mainType;
		this.specificType = specificType;
	}
	
	public String getMainType () {
		return this.mainType;
	}
	
	public String getSpecificType () {
		return this.specificType;
	}
}
