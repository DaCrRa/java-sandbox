package es.danielcr86.visitor;

public class Woman extends Person {

	@Override
	public boolean isSameGender(Person p) {
		return p.accept(new WomanGenderChecker());
	}

	@Override
	protected boolean accept(PersonVisitor v) {
		return v.visit(this);
	}

}
