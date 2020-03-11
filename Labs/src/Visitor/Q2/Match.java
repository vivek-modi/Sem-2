package Visitor.Q2;

interface Visitor {
	public void visit(Visitable v);
}

interface Visitable {
	public void accept(Visitor v);
}

public class Match implements Visitable {
	private String team1;
	private String team2;
	private int score1;
	private int score2;

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Match() {
		this.team1 = "City";
		this.team2 = "United";
	}

	public void team1_score() {
		score1++;
	}

	public void team2_score() {
		score2++;
	}

	public int readTeam1Score() {
		return score1;
	}

	public int readTeam2Score() {
		return score2;
	}

	public void setTeam1Score(int s) {
		score1 = s;
	}

	public void setTeam2Score(int s) {
		score2 = s;
	}

	public void print_score() {
		System.out.println("\nScore:");
		System.out.println("" + team1 + "\t" + team2);
		System.out.println(" " + "" + score1 + "\t " + score2);
	}
}
