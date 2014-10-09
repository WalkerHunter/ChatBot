package chatbot.model;

import java.util.ArrayList;

/**
 * the ChatBot model class. Used for checking and manipulating strings.
 * @author Walker Hunter
 * @version 1.6 10/9/14
 */
public class ChatBot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;

	public ChatBot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
	}

	/**
	 * Sets the name of the ChatBot to the supplied name.
	 * @param name The new name for the ChatBot.
	 */
	
	/**
	 * Gets the name of the person
	 * @return The name of the ChatBot object
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Counts the amount of times you've chat.
	 * @return The number of chats.
	 */
	public int getChatCount()
	{
		return chatCount;
	}

	/**
	 * Sets the name of the ChatBot to the supplied name
	 * @param name Sets ChatBot's name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	private void fillTheMemeList()
	{
		memeList.add("kitties");
		memeList.add("one does not simply");
		memeList.add("doge");
		memeList.add("doh!");
		memeList.add("toddler fist");
		memeList.add("y u no");
	}
	
	/**
	 * Processes input from the user against the checker methods. Returns the next output for the view.
	 * @param currentInput The supplied text.
	 * @return The processed text based on checker or other methods.
	 */
	
	public String processText(String currentInput)
	{
		String result = "";
		
		int randomPosition = (int) (Math.random() * 3);
		
		if(randomPosition == 0)
		{
			if(stringChecker(currentInput))
			{
				result = "wow too much, take it easy";
			}
		}
		else if(randomPosition == 1)
		{
			if(contentChecker(currentInput))
			{
				result = "Love that show!";
			}
			else
			{
				result = "meh, okay.";
			}
		}
		else
		{
			if(memeChecker(currentInput))
			{
				result = "wow, " + currentInput + " is a meme. Wahoo!";
			}
			else
			{
				result = "not a meme, try again";
			}
		}
		
		
		return result;
	}

	/**
	 * Private helper method to update the chat count variable.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}

	/**
	 * Private helper method to check meme's
	 * @param input Meme's
	 * @return If it is a meme or not
	 */
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;
		
		for (String currentMeme : memeList)
		{
			if(input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}
		
		for(int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if(input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	
	/**
	 * Public helper method to check to see if you want to quit
	 * @param input Quitting the ChatBot
	 * @return Says if you want to quit or not
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("yes"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}

	/**
	 * Private helper method to check the length of the strings
	 * @param input The amount of the string length
	 * @return Will tell you if the string is too long
	 */
	private boolean stringChecker(String input)
	{
		boolean isTooLong = false;
		
		if(input.length() >= 20)
		{
			isTooLong = true;
		}
		return isTooLong;
	}
	
	/**
	 * private helper method to check the content
	 * @param input If they talk about supernatural
	 * @return It will talk about supernatural as well
	 */
	private boolean contentChecker(String input)
	{
		boolean supernatural = false;
		
		if(input.contains("supernatural"))
		{
			supernatural = true;
		}
		return supernatural;
	}
	
}


