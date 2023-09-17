package es.vive.libre.model;

import java.time.LocalDate;

public class BookDate {
	
	private LocalDate publishDate;
	private Book book;
	
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		return "BookDate [publishDate=" + publishDate + ", \r\n book=" + book + "]";
	}
	
	

}
