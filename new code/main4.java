package assign4;

public class main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book book1 = new Book(121,"1984","George Orwell", true);
		Book book2 = new Book(122,"To Kill a Mockingbird", "Harper Lee", true);
		Book book3 = new Book(123,"The Great Gatsby", "F. Scott Fitzgerald", false);
		
		//call by toString
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
		
		//call by display method
		book1.displayInfo();
		book2.displayInfo();
		
		//call by getter setter
		System.out.println("Title of book1-"+book1.getTitle());
		System.out.println("Author of book2-"+book2.getAuthor());
		System.out.println("Availability of book3-"+(book3.isAvailable()?"Available":"Not Available"));
	
		//use setters to update specific details
		book3.setTitle("Wings of fire");
		book3.setAuthor("Dr. APJ Abdul Kalam");
		
		//display updated details
		System.out.println("Updated details is-");
		book3.displayInfo();
		
		// display total no of books created
		System.out.println("Total no of books-" +Book.getCounter());
	}

}
