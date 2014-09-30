package chatbot.model;

import java.util.ArrayList;

/**
 * the ChatBot model class. Used for checking and manipulating strings.
 * @author Cody Henrichsen
 * @version 1.1 9/26/14
 */
public class ChatBot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;

	public ChatBot(String name)
	{
		this.name = name;
		chatCount = 0;
	}

	/**
	 * Processes input from the user against the checker methods. Returns the next output for the view.
	 * @param currentInput The supplied text.
	 * @return The processed text based on checker or other methods.
	 */
	
	public String processText(String currentInput)
	{
		String result = "";
		
		
		return result;
	}
	
	
	
	/**
	 * Sets the name of the ChatBot to the supplied name.
	 * @param name The new name for the ChatBot.
	 */
	public String getName()
	{
		return name;
	}

	public int getChatCount()
	{
		return chatCount;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	private void updateChatCount()
	{
		chatCount++;
	}

	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("yes"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}

}


