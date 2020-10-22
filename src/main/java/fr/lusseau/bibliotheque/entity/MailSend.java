/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  20 oct. 2020 - 21:30:03
 * @author Claude LUSSEAU
 *
 */

@ApiModel(value = "Mail Model")
public class MailSend {
	

	@ApiModelProperty(value = "Mail sender address")
	public final String MAIL_FROM = "claude.lusseau.lemarchand@gmail.com";
	
	@ApiModelProperty(value = "Id de la personne recevant le mail")
	private Integer personneId;
	
	@ApiModelProperty(value = "Sujet du mail")
	private String emailSubject;
	
	@ApiModelProperty(value = "Contenu du mail")
	private String emailContent;

	/**
	 * Méthode en charge de récupérer la valeur de personneId.
	 * @return the personneId
	 */
	public Integer getPersonneId() {
		return personneId;
	}

	/**
	 * Méthode en charge de définir la valeur de personneId.
	 * @param personneId the personneId to set
	 */
	public void setPersonneId(Integer personneId) {
		this.personneId = personneId;
	}

	/**
	 * Méthode en charge de récupérer la valeur de emailSubject.
	 * @return the emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}

	/**
	 * Méthode en charge de définir la valeur de emailSubject.
	 * @param emailSubject the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	/**
	 * Méthode en charge de récupérer la valeur de emailContent.
	 * @return the emailContent
	 */
	public String getEmailContent() {
		return emailContent;
	}

	/**
	 * Méthode en charge de définir la valeur de emailContent.
	 * @param emailContent the emailContent to set
	 */
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	/**
	 * Méthode en charge de récupérer la valeur de mAIL_FROM.
	 * @return the mAIL_FROM
	 */
	public String getMAIL_FROM() {
		return MAIL_FROM;
	}
	
	


}
