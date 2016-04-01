package es.danielcr86.visitor;

public class Man extends Person {

	@Override
	public boolean isSameGender(Person p) {
		return p.accept(new ManGenderChecker());
	}

	@Override
	protected boolean accept(PersonVisitor v) {
		return v.visit(this);
	}

}
