package iuh.fit.serviceAuthor;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author findById(int maTim) {
		Optional<Author> result = authorRepository.findById(maTim);
		Author Author = null;
		if (result.isPresent()) {
			Author = result.get();
		}else {
			throw new RuntimeException("Khong tim thay ma: "+ maTim);
		}
		return Author;
	}

	@Override
	public void save(Author Author) {
		authorRepository.save(Author);
	}

	@Override
	public void delete(int maXoa) {
		authorRepository.deleteById(maXoa);
	}

}
