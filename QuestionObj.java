
public class QuestionObj {
	String question;
	int category;
	int trait;
	String reply;
	
	public QuestionObj(String question, int category, int trait) {
		this.question = question;
		this.category = category;
		this.trait = trait;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getTrait() {
		return trait;
	}
	public void setTrait(int trait) {
		this.trait = trait;
	}
	public String toString() {
		return this.question;
	}
	public String getReply() {
		return this.reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
