package es.danielcr86.visitor;

public class WomanGenderChecker implements PersonVisitor {

	@Override
	public boolean visit(Woman woman) {
		return true;
	}

	@Override
	public boolean visit(Man man) {
		return false;
	}

}
