package iuh.fit.serviceBook;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "publish_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dddd")
	private Date publishDate;
	private int author_id;
	@Column(name = "number_of_pages")
	private Integer numberOfPages;
	private Integer quality;
	private Integer price;
	@Column(name = "book_image")
	public String bookImage;
	

	//
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}	
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
	//

	//

	public Book(Integer id) {
		super();
		this.id = id;
	}

	public Book(Integer id, String bookName, Date publishDate, int author_id, Integer numberOfPages, Integer quality,
			Integer price, String bookImage) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.publishDate = publishDate;
		this.author_id = author_id;
		this.numberOfPages = numberOfPages;
		this.quality = quality;
		this.price = price;
		this.bookImage = bookImage;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", publishDate=" + publishDate + ", author_id=" + author_id
				+ ", numberOfPages=" + numberOfPages + ", quality=" + quality + ", price=" + price + ", bookImage="
				+ bookImage + "]";
	}
	
	

}

//`id` int unsigned NOT NULL AUTO_INCREMENT,
//`book_name` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
//`publish_date` date DEFAULT NULL,
//`author` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
//`number_of_pages` int DEFAULT NULL,
//`quality` int DEFAULT '0',
//`price` bigint DEFAULT NULL,
//`book_image` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
