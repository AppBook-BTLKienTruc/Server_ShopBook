package iuh.fit.serviceBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("")
	public List<Book> findAll(){
		System.err.println("findAll()");
		List<Book> list = bookService.findAll();
		return list;
	}
	//
	@GetMapping("/{id}")
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
	public Book addEmployee(@RequestBody Book book) {
		bookService.save(book);
		return book;
	}

	//
	@PutMapping("")
	public Book updateEmployee(@RequestBody Book book) {
		bookService.save(book);
		return book;
	}

//
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {

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
