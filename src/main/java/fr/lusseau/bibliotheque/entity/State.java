/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class in charge of defining State entity.
 * @Version Bibliotheque -v1,0
 * @date  23 oct. 2020 - 12:14:25
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "State")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "label", nullable = false)
	private String label;

	
	/**
	 * Constructor.
	 */
	public State() {
		
	}

	/**
	 * Constructor.
	 * @param label
	 * @param books
	 */
	public State(String label) {
		this.label = label;
	}

	/**
	 * Constructor.
	 * @param idState
	 * @param label
	 * @param books
	 */
	public State(int id, String label) {
		this.id = id;
		this.label = label;
	}

	/**
	 * Method in charge of getting idState's value .
	 * @return the idState
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method in charge of setting idState's value.
	 * @param idState the idState to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting label's value .
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Method in charge of setting label's value.
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	
}
