package es.vive.libre;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import es.vive.libre.common.Utils;
import es.vive.libre.model.Book;
import es.vive.libre.model.BookDate;

public class Filter {

	public static void main(String[] args) {

		try {

			List<Book> books = Utils.loadData();
			
			Filter filter = new Filter();
			Optional<BookDate> bookDate = filter.filter("a", books);
			
			if(bookDate.isPresent()) {
				System.out.println(bookDate.get());
			}else {
				System.out.print("Items not founded");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Filter all the books by the given filter string
	 * 
	 * @param filter the text to filter the books (the text must be contained in the title, the summary and the Bio of the author)
	 * @param books the books to filter
	 * @return
	 */
	private Optional<BookDate> filter(String filter, List<Book> books) {

		booksMissingPublishDate(books);
		List<Book> filterBooks = filterBooks(filter, books);
		
		if(filterBooks == null || filterBooks.isEmpty()) {
			return Optional.empty();
		}

		return filterBooks.stream().filter(item -> item .getPublicationLocalDate() != null)
		.max(Comparator.comparing(item -> item.getPublicationLocalDate())).map(item -> {
			BookDate founded = new BookDate();
			founded.setBook(item);
			founded.setPublishDate(item.getPublicationLocalDate());
			return founded;
		});
	}
	
	/**
	 * Filter the books that the title and the summary 
	 * and the Biography of the author contains the requested text as argument 
	 * 
	 * @param filter the filter to text all the books
	 * @param books the books List to filter
	 * @return the filtered books
	 */
	private List<Book> filterBooks(String filter, List<Book> books){
		
		return books.stream().filter(item ->{
			return 	item.getTitle().contains(filter) && 
					item.getSummary().contains(filter) && 
					item.getAuthor().getBio().contains(filter);
		}).map(item ->{
			
			if(item.getPublicationTimestamp() != null) {
				item.setPublicationLocalDate(Utils.timestampToLocalDate(item.getPublicationTimestamp()));
				item.setPublicationFormatted(Utils.formatLocalDate(item.getPublicationLocalDate()));
			}
			
			return item;
		}).collect(Collectors.toList());
	}
	
	/**
	 * Filter all the books without the publish date and print the information
	 * in the console
	 * 
	 * @param books the data to filter
	 */
	private void booksMissingPublishDate(List<Book> books) {
		books.stream()
		.filter(item -> item .getPublicationTimestamp() == null)
		.forEach(item ->{
			System.out.println(item);
		});
	}
	
	/**
	 * Group items by the date as key
	 * 
	 * @param books
	 * @return
	 */
	private Map<LocalDate, List<Book>> groupByDate(List<Book> books) {
		
		 Map<LocalDate, List<Book>> grouped = books.stream()
			.collect(Collectors.groupingBy(Book::getPublicationLocalDate));

		 grouped.forEach((key, value) ->{
				value.stream()
				.sorted(Comparator.comparing(item -> item.getAuthor().getBio().length()));
			});
		 
		 return grouped;
	}

}
