package es.danielcr86.visitor;

public class ManGenderChecker implements PersonVisitor {

	@Override
	public boolean visit(Woman woman) {
		return false;
	}

	@Override
	public boolean visit(Man man) {
		return true;
	}

}
