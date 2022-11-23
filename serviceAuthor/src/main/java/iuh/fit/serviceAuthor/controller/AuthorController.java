package iuh.fit.serviceAuthor.controller;

import java.util.ArrayList;
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

import iuh.fit.serviceAuthor.Author;
import iuh.fit.serviceAuthor.AuthorService;

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
	public ResponseEntity<List<Author>> findAll(){
		System.err.println("findAll()");
		List<Author> list = authorService.findAll();
		return ResponseEntity.ok(list);
	}
	//
	@GetMapping("/{id}")
	@Cacheable(value = "authors",key = "#authorId",condition="#authorId!=null")
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
	public Author addAuthor(@RequestBody Author author) {
		authorService.save(author);
		return author;
	}

	//
	@PutMapping("/{id}")
	@CachePut(value = "authors",key = "authorId",condition="#authorId!=null")
	public Author updateAuthor(@PathVariable int id,@RequestBody Author author) {
		Author author2 = authorService.findById(id);
		if(author2 != null) {
			author2.setAuthorImage(author.getAuthorImage());
			author2.setAuthorInfo(author.getAuthorInfo());
			author2.setAuthorName(author.getAuthorName());
			authorService.save(author2);
		}else {
			System.out.println("Khong ton tai author id:"+id);
		}
		return author2;
	}

//
	@DeleteMapping("/{id}")
	@CacheEvict(value = "authors", allEntries = true)
	public String deleteAuthor(@PathVariable int id) {

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
