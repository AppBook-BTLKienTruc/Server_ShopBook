package iuh.fit.serviceBook;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int maTim) {
		Optional<Book> result = bookRepository.findById(maTim);
		Book book = null;
		if (result.isPresent()) {
			book = result.get();
		}else {
			throw new RuntimeException("Khong tim thay ma: "+ maTim);
		}
		return book;
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void delete(int maXoa) {
		bookRepository.deleteById(maXoa);
	}

}
