package student;

public class Qualification {
	private String board;
	private String percentage;
	private String year;
	
	public Qualification() {
		super();
	}
	
	public Qualification(String board, String percentage, String year) {
		super();
		this.board = board;
		this.percentage = percentage;
		this.year = year;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Qualification [board=" + board + ", percentage=" + percentage + ", year=" + year + "]";
	}
}
