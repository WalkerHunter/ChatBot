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
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
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
		if(memeChecker(currentInput))
		{
			result = "wow, " + currentInput + " is a meme. Wahoo!";
		}
		else
		{
			result = "not a meme, try again";
		}
		
		if(stringChecker(currentInput))
		{
			result = "wow too much, take it easy";
		}
		return result;
	}

	private void updateChatCount()
	{
		chatCount++;
	}

	
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
	
	
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("yes"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}

	private boolean stringChecker(String input)
	{
		boolean stringTooLong = false;
		
		if(input.length() > 20)
		{
			stringTooLong = true;
		}
		return stringTooLong;
	}
	
}


