package iuh.fit.serviceAuthor;

import java.util.List;

public interface AuthorService {

	public List<Author> findAll();
	public Author findById(int maTim);
	public void save(Author author);
	public void delete (int maXoa);
}
