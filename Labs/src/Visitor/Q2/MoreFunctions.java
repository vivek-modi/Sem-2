package Visitor.Q2;

public class MoreFunctions implements Visitor {

	private Match match;

	@Override
	public void visit(Visitable v) {
		match = (Match) v;
	}

	public void restartMatch() {
		match.setTeam1Score(0);
		match.setTeam2Score(0);
	}

	public String readResult() {

		if (match.readTeam1Score() > match.readTeam2Score())
			return "City Winning";
		else if (match.readTeam1Score() < match.readTeam2Score())
			return "United Winning";
		else
			return "Draw";

	}

}
