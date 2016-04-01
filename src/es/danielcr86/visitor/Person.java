package es.danielcr86.visitor;

public abstract class Person {

	public abstract boolean isSameGender(Person man);

	protected abstract boolean accept(PersonVisitor v);
}
