package geektrust.family.commands;

import geektrust.family.commands.impl.AddChild;
import geektrust.family.commands.impl.AddFamilyHead;
import geektrust.family.commands.impl.AddSpouse;
import geektrust.family.commands.impl.GetRelationship;
import geektrust.family.exceptions.InvalidCommandException;

import java.util.HashMap;
import java.util.Map;

import static geektrust.family.pojo.Constants.*;

public class CommandsMap {
	private static Map<String, Command> commands = new HashMap<>();
	
	private CommandsMap() {}
	
	public static void init() {
		commands.put(ADD_CHILD, new AddChild());
		commands.put(ADD_SPOUSE, new AddSpouse());
		commands.put(ADD_FAMILY_HEAD, new AddFamilyHead());
		commands.put(GET_RELATIONSHIP, new GetRelationship());
	}
	
	public static Command get(String command) {
		if(commands.isEmpty()) {
			init();
		}
		if(!commands.containsKey(command)) {
			throw new InvalidCommandException(INVALID_COMMAND);
		}
		
		return commands.get(command);
	}

}
