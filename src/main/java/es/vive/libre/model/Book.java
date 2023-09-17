package es.vive.libre.model;

import java.time.LocalDate;

public class Book {

	private int id;
	private String title;
	private int pages;
	private String publicationTimestamp;
	private String summary;
	private Author author;
	
	private LocalDate publicationLocalDate;
	private String publicationFormatted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getPublicationTimestamp() {
		return publicationTimestamp;
	}
	public void setPublicationTimestamp(String publicationTimestamp) {
		this.publicationTimestamp = publicationTimestamp;
	}
	
	public LocalDate getPublicationLocalDate() {
		return publicationLocalDate;
	}
	public void setPublicationLocalDate(LocalDate publicationLocalDate) {
		this.publicationLocalDate = publicationLocalDate;
	}
	public String getPublicationFormatted() {
		return publicationFormatted;
	}
	public void setPublicationFormatted(String publicationFormatted) {
		this.publicationFormatted = publicationFormatted;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", publicationTimestamp="
				+ publicationTimestamp + ", summary=" + summary + ", author=" + author + "]";
	}
	
	
	
}
