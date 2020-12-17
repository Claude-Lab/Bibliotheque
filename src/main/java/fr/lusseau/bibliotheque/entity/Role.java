/**
 * 
 */
package fr.lusseau.bibliotheque.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Class in charge of defining Role entity.
 * @Version Bibliotheque -v1,0
 * @date  14 août 2020 - 09:49:04
 * @author Claude LUSSEAU
 *
 */
@Entity
@Table(name = "Role")
public class Role {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 50, unique = true)
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName name;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users;

    /**
     * Constructor without parameter.
     */
    public Role() {
    }

    /**
     * Constructor.
     * @param name
     */
    public Role(final RoleName name) {
        this.name = name;
    }

    /**
     * Constructor.
     * @param name
     * @param users
     */
    public Role(RoleName name, List<User> users) {
        this.name = name;
        this.users = users;
    }

	/**
	 * Method in charge of getting id's value .
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method in charge of setting id's value.
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method in charge of getting name's value .
	 * @return the name
	 */
	public RoleName getName() {
		return name;
	}

	/**
	 * Method in charge of setting name's value.
	 * @param name the name to set
	 */
	public void setName(RoleName name) {
		this.name = name;
	}

	/**
	 * Method in charge of getting users's value .
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Method in charge of setting users's value.
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

    
}