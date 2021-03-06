package dataInfo;

public class BookVO {
	private String genre;	//장르
	private String bookName;	//제목
	private String bookStatus = "보유중";	//대여상태
	private int rentalFee;	//대여비용
	private int rentalDate;	//대여가능일
	
	public BookVO(String bookName, String genre, String bookStatus, int rentalFee, int rentalDate) {
		this.bookName = bookName;
		this.genre = genre;
		this.bookStatus = bookStatus;
		this.rentalFee = rentalFee;
		this.rentalDate = rentalDate;
	}
	public static void bookTitlePrint() {
		System.out.println("================================================================================");
		System.out.printf("%-20s\t %s\t\t %s\t\t %s\t\t %s\n", "제목", "장르", "상태", "대여비", "대여일");
		System.out.println("================================================================================");
	}
	public void bookPrint() {
		System.out.printf("%-12s\t %s\t\t %-10s\t %d\t\t %3d\n", bookName, genre, bookStatus, rentalFee, rentalDate);
	}
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public int getRentalFee() {
		return rentalFee;
	}

	public void setRentalFee(int rentalFee) {
		this.rentalFee = rentalFee;
	}


	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public int getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(int rentalDate) {
		this.rentalDate = rentalDate;
	}

	public BookVO() {
	}

}
