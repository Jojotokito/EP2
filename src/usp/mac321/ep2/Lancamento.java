package usp.mac321.ep2;

public class Lancamento {
	private static int contador = 1;
	
	@SuppressWarnings("unused")
	private int identifier;
	private String data;
	private String nickName;
	private boolean expense;
	private String specificType;
	private double value;
	private String description;

	public Lancamento (int identifier, String data, String nickName, boolean expense, String specificType, double value, String description) {	
		if (identifier != contador++) throw new WrongIdentifierException("Identificador errado!");
		this.identifier = identifier;
		this.data = data;
		this.nickName = nickName;
		this.expense = expense;
		this.specificType = specificType;
		this.value = value;
		this.description = description;
	}
	
	public String getData() {
        return data;
    }

    public String getNickName() {
        return nickName;
    }

    public boolean isExpense() {
        return expense;
    }

    public String getSpecificType() {
        return specificType;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
