package iuh.fit.se.libs;

public class CriketCoach implements Coach{
	private String emailAddress;
	private String team;
	private FortuneService fortuneService;

	public CriketCoach() {
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		System.out.println("CriketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}
	public String getTeam() {
		System.out.println("CriketCoach: inside getter method - getTeam");
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
