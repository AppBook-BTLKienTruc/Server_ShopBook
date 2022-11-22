package iuh.fit.serviceAuthor;

import java.util.ArrayList;
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
@RequestMapping("/author")
public class AuthorController {

	private AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	//
	@GetMapping("")
	public List<Author> findAll(){
		System.err.println("findAll()");
		List<Author> list = authorService.findAll();
		return list;
	}
	//
	@GetMapping("/{id}")
	public Author findById(@PathVariable int id)
	{
		Author a = new Author(null);
		try {
			a = authorService.findById(id);
		} catch (Exception e) {
			System.err.println(e);
		}
		return a;
	}
	//
	//
	@PostMapping("")
	public Author addEmployee(@RequestBody Author author) {
		authorService.save(author);
		return author;
	}

	//
	@PutMapping("")
	public Author updateEmployee(@RequestBody Author author) {
		authorService.save(author);
		return author;
	}

//
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {

		Author author = new Author(null);
		try {
			author = authorService.findById(id);
		} catch (Exception e) {
			System.err.println(e);
			return e.toString();
		}

		authorService.delete(id);

		return "Deleted employee with id : " + id;

	}
	
	
}
