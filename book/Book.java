package assign4;

public class Book {
	private int bookid;
	private String title;
	private String author;
	private boolean isAvailable;
	private static int counter=0;
	
	
	public Book(int bookid,String title,String author,boolean isAvailable) {
		
		this.bookid=bookid;
		this.title=title;
		this.author=author;
		this.isAvailable=isAvailable;
		
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Book.counter = counter;
	}
	@Override
	public String toString() {
		counter++;
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable
				+ "]";
	}
	
	public void displayInfo() {
		System.out.println("Bookid-"+bookid+" Title-"+title+" Author-"+author+" Available-"+isAvailable);
		//System.out.println(counter);
		//counter++;
	}
}
