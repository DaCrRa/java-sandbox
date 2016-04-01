package es.danielcr86.visitor;

public interface PersonVisitor {

	boolean visit(Woman woman);

	boolean visit(Man man);

}
