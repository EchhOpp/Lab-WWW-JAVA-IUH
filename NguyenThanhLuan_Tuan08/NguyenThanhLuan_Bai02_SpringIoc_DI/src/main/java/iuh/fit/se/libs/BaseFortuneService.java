package iuh.fit.se.libs;

public class BaseFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}
}
