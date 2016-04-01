package es.danielcr86.visitor;

public class Main {

	public static void main(String[] args) {
		Person man = new Man();
		Person woman = new Woman();
		
		System.out.println("man.isSameGender(man)..." + man.isSameGender(man));
		System.out.println("woman.isSameGender(woman)..." + woman.isSameGender(woman));
		System.out.println("woman.isSameGender(man)..." + woman.isSameGender(man));
		System.out.println("man.isSameGender(woman)..." + man.isSameGender(woman));
	}

}
