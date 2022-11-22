package iuh.fit.serviceBook;

import java.util.List;

public interface BookService {

	public List<Book> findAll();
	public Book findById(int maTim);
	public void save(Book book);
	public void delete (int maXoa);
}
