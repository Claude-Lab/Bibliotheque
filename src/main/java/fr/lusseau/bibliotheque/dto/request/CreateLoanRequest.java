/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class in charge of defining Loan DTO.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 18:37:24
 * @author Claude LUSSEAU
 *
 */
@ApiModel(value = "Create Loan Model")
public class CreateLoanRequest implements Comparable<CreateLoanRequest> {

	
	@ApiModelProperty(value = "Book concerned by the loan")
	private BookResponse bookResponse = new BookResponse();

	@ApiModelProperty(value = "User concerned by the loan")
	private UserResponse userResponse = new UserResponse();

	@ApiModelProperty(value = "Loan begining date")
	private LocalDate loanBeginDate;

	@ApiModelProperty(value = "Loan ending date")
	private LocalDate loanEndDate;
	
	/**
	 * Empty Constructor.
	 */
	public CreateLoanRequest() {
	}

	/**
	 * Constructor.
	 * @param bookResponse
	 * @param userResponse
	 * @param loanBeginDate
	 * @param loanEndDate
	 */
	public CreateLoanRequest(BookResponse bookResponse, UserResponse userResponse, LocalDate loanBeginDate,
			LocalDate loanEndDate) {
		super();
		this.bookResponse = bookResponse;
		this.userResponse = userResponse;
		this.loanBeginDate = loanBeginDate;
		this.loanEndDate = loanEndDate;
	}

	/**
	 * Method in charge of getting bookResponse's value .
	 * @return the bookResponse
	 */
	public BookResponse getBookResponse() {
		return bookResponse;
	}



	/**
	 * Method in charge of setting bookResponse's value.
	 * @param bookResponse the bookResponse to set
	 */
	public void setBookResponse(BookResponse bookResponse) {
		this.bookResponse = bookResponse;
	}



	/**
	 * Method in charge of getting userResponse's value .
	 * @return the userResponse
	 */
	public UserResponse getUserResponse() {
		return userResponse;
	}



	/**
	 * Method in charge of setting userResponse's value.
	 * @param userResponse the userResponse to set
	 */
	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}



	/**
	 * Method in charge of getting loanBeginDate's value .
	 * @return the loanBeginDate
	 */
	public LocalDate getLoanBeginDate() {
		return loanBeginDate;
	}



	/**
	 * Method in charge of setting loanBeginDate's value.
	 * @param loanBeginDate the loanBeginDate to set
	 */
	public void setLoanBeginDate(LocalDate loanBeginDate) {
		this.loanBeginDate = loanBeginDate;
	}



	/**
	 * Method in charge of getting loanEndDate's value .
	 * @return the loanEndDate
	 */
	public LocalDate getLoanEndDate() {
		return loanEndDate;
	}



	/**
	 * Method in charge of setting loanEndDate's value.
	 * @param loanEndDate the loanEndDate to set
	 */
	public void setLoanEndDate(LocalDate loanEndDate) {
		this.loanEndDate = loanEndDate;
	}



	/**
	 * @{inheritDoc}
	*/
	@Override
	public int compareTo(CreateLoanRequest o) {
		// TODO Auto-generated method stub
		return o.getLoanBeginDate().compareTo(this.loanBeginDate);
	}

}
