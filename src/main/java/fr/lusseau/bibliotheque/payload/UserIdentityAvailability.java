/**
 * 
 */
package fr.lusseau.bibliotheque.payload;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  17 déc. 2020 - 10:55:36
 * @author Claude LUSSEAU
 *
 */
public class UserIdentityAvailability {
    private Boolean available;

    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}