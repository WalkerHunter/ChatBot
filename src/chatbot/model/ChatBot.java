package chatbot.model;

import java.util.ArrayList;
import chatbot.model.ChatBotUser;


/**
 * the ChatBot model class. Used for checking and manipulating strings.
 * @author Walker Hunter
 * @version 1.6 10/9/14
 */
public class ChatBot
{
	private ArrayList<String> memeList;
	private String name;
	private String contentArea;
	private int chatCount;
	private ChatBotUser myUser;
	private ArrayList<String> userInputList;
	
	public ChatBot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		myUser = new ChatBotUser();
		fillTheMemeList();
	}

	/**
	 * Sets the name of the ChatBot to the supplied name.
	 * @param name The new name for the ChatBot.
	 */
	
	public ChatBotUser getMyUser()
	{
		return myUser;
	}

	public void setMyUser(ChatBotUser myUser)
	{
		this.myUser = myUser;
	}
 
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
	
	public String processText (String currentInput)
	
	{
		String result = "";
		
		
		if(getChatCount() < 7)
		{
			result = introduceUser(currentInput);
		}
		else if (currentInput != null && currentInput.length() > 0)
		{
			result = randomChatConversation(currentInput);
		}
		else
		{
			result = "use words!!!!";
			chatCount--;
		}
		updateChatCount();
		return result;
		
		
		private String introduceUser(String input)
		{
			String userQuestion = "";

			if (getChatCount() == 0)
			{
				myUser.setUserName(input);
				userQuestion = "Good name " + myUser.getUserName() + " how old are you?";
			}
			else if (getChatCount() == 1)
			{
				int userAge = Integer.parseInt(input);
				myUser.setAge(userAge);
				userQuestion = "Garsh, you are really old " + myUser.getUserName() + " how much do you weigh?";
			}
			else if (getChatCount() == 2)
			{
				double userWeight = Double.parseDouble(input);
				myUser.setWeight(userWeight);
				userQuestion = "Yikes that is a lot less than a dwarf star " + myUser.getUserName() + " do you have tattoos?";
			}
			else if (getChatCount() == 3)
			{
				boolean userTatts = Boolean.parseBoolean(input);
				myUser.setHasTattoos(userTatts);
				userQuestion = "Some comment about tattoos" + myUser.getUserName() + " do you have corrective lenses?";
			}
			else
			{
				boolean userLenses = Boolean.parseBoolean(input);
				myUser.setNeedsCorrectiveLenses(userLenses);
				userQuestion = "I love my glasses :D " + myUser.getUserName() + " What do you want to talk about????????";
			}

			return userQuestion;
		}
		
		private String randomChatConversation(String input)
		{
			String conversation = "";

			int randomPosition = (int) (Math.random() * 7);
			if (randomPosition == 0)
			{
				if (stringLengthChecker(input))
				{
					conversation = "too long";
				}
				else
				{
					conversation = "short words";
				}
			}
			else if (randomPosition == 1)
			{
				if (contentChecker(input))
				{
					conversation = "yup you know the secret";
				}
				else
				{
					conversation = "try again another time";
				}
			}
			else if (randomPosition == 2)
			{
				if (memeChecker(input))
				{
					conversation = "Wow, " + input + " is a meme. Wahoo!";
				}
				else
				{
					conversation = "not a meme, try again";
				}
			}
			else if (randomPosition == 3)
			{
				conversation = userTopic(input);
			}
			else if (randomPosition == 4)
			{
				// add to our list
				userInputList.add(input);
				conversation = "Thank you for the comment";
			}
			else if (randomPosition == 5)
			{
				if (mashChecker(input))
				{
					conversation = mashingDetected(input);
				}
				else
				{
					conversation = noMashingDetected(input);
				}
			}
			else
			{
				if (userInputChecker(input))
				{
					conversation = "That was nice - you removed it from the list";
				}
				else
				{
					conversation = "that wasn't in the conversation before";
				}
			}

			return conversation;
		}
		
		private String userTopic(String userInput)
		{
			String userBasedResponse = "";

			int randomUserTopic = (int) (Math.random() * 6);

			switch (randomUserTopic)
			{
			case 1:
				userBasedResponse = myUser.hasTattoos() + " is the response to tattoos :D";
				break;
			case 0:
				userBasedResponse = myUser.getUserName() + " is a silly name :P";
				break;
			default:
				userBasedResponse = myUser.getAge() + " is realllly reallllllly old";
				break;
			}

			return userBasedResponse;
		}
		
		int randomPosition = (int) (Math.random() * 4);
		
		if(randomPosition == 0)
		{
			if(stringChecker(currentInput))
			{
				result = "wow too much, take it easy";
			}
			else
			{
				
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
		else if( randomPosition == 2)
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
		else if( randomPosition == 3)
		{
			if(mashChecker(currentInput))
			{
				result = "Stop mashing, its not good for the keyboard";
			}
			
		}
		else
		{
			
		}
		updateChatCount();
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
	
	
	private String mashingDeteced(String input)
	{
		String mashed = "";
		
		mashed = input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		
		return mashed;
	}
	
	private String noMashingDeteced(String input)
	{
		String noMashing = "Thank you for not mashing your keyboad";
		
		noMashing += input.substring(input.length()/3, input.length()/2);
		
		return noMashing;
	}
	
	private boolean mashChecker(String userInput)
	{
		boolean isMashing= false;
		
		if(userInput.indexOf("sdf") > -1);
		{
			isMashing = true;
		}
		
		return isMashing;
	}
	
}


