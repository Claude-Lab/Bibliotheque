/**
 * 
 */
package fr.lusseau.bibliotheque.payload;

import java.time.LocalDateTime;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  17 déc. 2020 - 10:56:03
 * @author Claude LUSSEAU
 *
 */
public class UserProfile {
    private Long id;
    private String username;
    private String name;
    private LocalDateTime joinedAt;

    public UserProfile(Long id, String username, String name, LocalDateTime joinedAt) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.joinedAt = joinedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }
}