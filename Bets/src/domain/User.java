package domain;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Stores credentials and additional information of registered users, including the active bets it has in place. 
 * Users may be regular or administrators (represented by isAdmin boolean).
 * 
 * @author Julen
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class User {

	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id
	private String ID;
	private String password;
	private String name;
	private String surname;
	private String email;
	private boolean isAdmin;
	private float cash;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private ArrayList<Bet> bets;
	
	public User(String iD, String password, String name, String surname, String email, boolean isAdmin) {
		super();
		this.ID = iD;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.isAdmin = isAdmin;
		this.bets = new ArrayList<Bet>();
		this.cash = 50;         //placeholder value of 50 euros for testing purposes before credit cards etc are implemented.
	}
	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public float getCash() {
		return cash;
	}
	
	public String statusToString() {
		if(this.isAdmin) {
			return("Admin");
		}
		else {
			return("User");
		}
	}
	/**
	 * Registers the bet performed by a user
	 * @param q			the question the bet has been placed on.
	 * @param amount	the amount of money.
	 */
	public void placeBet(Question q, float amount) {
		bets.add(new Bet(q,this,amount));	
		this.cash -= amount;
	}

	public void addBet(Bet b) {
		bets.add(b);
	}
	public void addCash(float amount) {
		this.cash += amount;
	}

}
