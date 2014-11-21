package chatbot.model;



public class ChatBotUser
{
	// four data members
	//at least two different types (String, int, boolean, double....)
	private String userName;
	private int age;
	private boolean hasTattoos;
	private boolean needsCorrectiveLenses;
	
	public ChatBotUser()
	{
		this.userName = "";
		this.age = -999;
		this.hasTattoos = false;
		this.needsCorrectiveLenses = false;
		
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isHasTattoos()
	{
		return hasTattoos;
	}

	public void setHasTattoos(boolean hastTattoos)
	{
		this.hasTattoos = hastTattoos;
	}

	public boolean isNeedsCorrectiveLenses()
	{
		return needsCorrectiveLenses;
	}

	public void setNeedsCorrectiveLenses(boolean needsCorrectiveLenses)
	{
		this.needsCorrectiveLenses = needsCorrectiveLenses;
	}
	
}
