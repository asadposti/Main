package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Association class between the classes user and question. Represents the bet placed by a given user on a question of an event.
 * @author Julen
 *
 */
@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Bet {
	
	@Id 
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	private Question question;
	@XmlIDREF
	private User bettor;
	private float amount;
	
	public Bet(Question question, User better, float amount) {
		super();
		this.question = question;
		this.bettor = better;
		this.amount = amount;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getBettir() {
		return bettor;
	}

	public void setBettor(User bettor) {
		this.bettor = bettor;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
