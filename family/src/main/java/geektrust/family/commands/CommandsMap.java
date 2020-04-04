package geektrust.family.commands;

import static geektrust.family.pojo.Constants.ADD_CHILD;
import static geektrust.family.pojo.Constants.ADD_FAMILY_HEAD;
import static geektrust.family.pojo.Constants.ADD_SPOUSE;
import static geektrust.family.pojo.Constants.GET_RELATIONSHIP;

import java.util.HashMap;

import geektrust.family.commands.commandsImpl.AddChild;
import geektrust.family.commands.commandsImpl.AddFamilyHead;
import geektrust.family.commands.commandsImpl.AddSpouse;
import geektrust.family.commands.commandsImpl.GetRelationship;

public class CommandsMap {
	private static HashMap<String, Command> commands = new HashMap<>();
	
	public static void init() {
		commands.put(ADD_CHILD, new AddChild());
		commands.put(ADD_SPOUSE, new AddSpouse());
		commands.put(ADD_FAMILY_HEAD, new AddFamilyHead());
		commands.put(GET_RELATIONSHIP, new GetRelationship());
	}
	
	public static Command get(String command) {
		return commands.get(command);
	}
	
	public static boolean contains(String command) {
		return commands.containsKey(command);
	}
}
