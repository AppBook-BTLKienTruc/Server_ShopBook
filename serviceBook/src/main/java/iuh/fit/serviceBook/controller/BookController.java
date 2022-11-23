package iuh.fit.serviceBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import iuh.fit.serviceBook.Book;
import iuh.fit.serviceBook.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private BookService bookService;


	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	//
	@GetMapping("/home")
	public String myhome() {
		return "my home";
	}
	//
	@GetMapping("/")
	public ResponseEntity<List<Book>> findAll(){
		System.err.println("findAll()");
		List<Book> list = bookService.findAll();
		return ResponseEntity.ok(list);
	}
	//
	@GetMapping("/{id}")
	@Cacheable(value = "books",key = "#bookId",condition="#bookId!=null")
	public Book findById(@PathVariable int id)
	{
		Book a = new Book(null);
		try {
			a = bookService.findById(id);
		} catch (Exception e) {
			System.err.println(e);
		}
		return a;
	}
	//
	//
	@PostMapping("")
	public Book addBook(@RequestBody Book book) {
		bookService.save(book);
		return book;
	}

	//
	@PutMapping("/{id}")
	@CachePut(value = "books",key = "#bookId",condition="#bookId!=null")
	public Book updateBook(@PathVariable int id, @RequestBody Book book) {
		Book book2 = bookService.findById(id);
		if(book2 != null) {
			book2.setBookName(book.getBookName());
			book2.setAuthor_id(book.getAuthor_id());
			book2.setBookImage(book.getBookImage());
			book2.setNumberOfPages(book.getNumberOfPages());
			book2.setPrice(book.getPrice());
			book2.setPublishDate(book.getPublishDate());
			book2.setQuality(book.getQuality());
			bookService.save(book2);
		}else {
			System.out.println("No have bookId:"+id);
		}
	
		return book2;
	}

//
	@DeleteMapping("/{id}")
	@CacheEvict(value = "books", allEntries = true)
	public String deleteBook(@PathVariable int id) {

		Book book = new Book(null);
		try {
			book = bookService.findById(id);
		} catch (Exception e) {
			System.err.println(e);
			return e.toString();
		}

		bookService.delete(id);

		return "Deleted employee with id : " + id;

	}
	 
	
}
