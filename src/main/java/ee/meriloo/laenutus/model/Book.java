package ee.meriloo.laenutus.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="BOOK")
public class Book implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="TITLE", nullable=false)
	private String title;

	@NotEmpty
	@Column(name="AUTHOR", nullable=false)
	private String author;

	@Column(name="RENTEDOUT", nullable=false, columnDefinition = "TINYINT")
	private boolean rentedout;

	@Column(name="COMMENT")
	private String comment;

	@Column(name="RENTINGDATE")
	@Type(type="date")
	private Date rentingdate;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isRentedout() {
		return rentedout;
	}

	public void setRentedout(boolean rentedout) {
		this.rentedout = rentedout;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getRentingdate() {
		return rentingdate;
	}

	public void setRentingdate(Date rentingdate) {
		this.rentingdate = rentingdate;
	}
}
