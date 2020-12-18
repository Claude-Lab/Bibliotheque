/**
 * 
 */
package fr.lusseau.bibliotheque.configuration.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.lusseau.bibliotheque.entity.Loan;
import fr.lusseau.bibliotheque.entity.Role;
import fr.lusseau.bibliotheque.entity.Surety;
import fr.lusseau.bibliotheque.entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class in charge of defining .
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 déc. 2020 - 10:50:48
 * @author Claude LUSSEAU
 *
 */
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = -201918025472828700L;

	private Long id;

	private String firstname;

	private String lastname;

	private String username;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;

	private String phone;

	private String address;

	private String zip;

	private String city;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	private Set<Role> roles;
	
	private Surety surety;
	
	private Set<Loan> loans;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(Long id, String firstname, String lastname, String username, String email, String password, String phone,
			String address, String zip, String city, LocalDateTime createdAt, LocalDateTime updatedAt, Surety surety,
			Set<Loan> loans, Set<Role> roles, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.surety = surety;
		this.loans = loans;
		this.roles = roles;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getAddress(),
                user.getZip(),
                user.getCity(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getSurety(),
                user.getLoans(),
                user.getRoles(),
                authorities
        );
    }
	

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}
	
	

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}
	

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public Surety getSurety() {
		return surety;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
