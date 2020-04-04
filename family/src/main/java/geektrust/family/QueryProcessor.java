package geektrust.family;

import static geektrust.family.pojo.Constants.INIT_FILE_PATH;
import static geektrust.family.pojo.Constants.INVALID_COMMAND;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import geektrust.family.commands.Command;
import geektrust.family.commands.CommandsMap;
import geektrust.family.exceptions.InvalidCommandException;
import geektrust.family.pojo.Constants;
import geektrust.family.pojo.Family;
import geektrust.family.relations.RelationshipMap;

/**
 * QueryHandler class handles all the operations related to family tree. It
 * contains methods to serve queries such as ADD_CHILD(which adds a child to the
 * list of children of the mother) or GET_RELATIONSHIP(which finds person(s)
 * related to a specified person)
 * 
 * @author Sushil
 *
 */
public class QueryProcessor {
	
	public QueryProcessor() {
		RelationshipMap.init();
		CommandsMap.init();
	}
	
	/**
	 * @param family
	 * @param command
	 * @return either PERSON_NOT_FOUND or CHILD_ADDITION_SUCCEEDED or
	 *         CHILD_ADDITION_FAILED if query type is ADD_CHILD otherwise the
	 *         person(s) related to the specified person, if query type is
	 *         GET_RELATIONSHIP
	 */
	public String processInputCommand(String command, Family family) {
		String[] commandParams = command.split(" ");
		if(!CommandsMap.contains(commandParams[0])) {
			return INVALID_COMMAND;
		}
		
		Command commandImpl = CommandsMap.get(commandParams[0]);
		return commandImpl.execute(commandParams, family);
	}
	
	/**
	 * This method initializes the Family tree using the init.txt file
	 * @throws IOException
	 */
	public void processInitCommand(Family family) throws IOException {
		try(InputStream input = getClass().getResourceAsStream(INIT_FILE_PATH);
				BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
			String command;
			while((command = br.readLine()) != null) {
				String[] commandParams = command.split(" ");
				if(!CommandsMap.contains(commandParams[0])) {
					throw new InvalidCommandException(INVALID_COMMAND);
				}
				
				Command commandImpl = CommandsMap.get(commandParams[0]);
				commandImpl.execute(commandParams, family);
			}
		}
	}
}