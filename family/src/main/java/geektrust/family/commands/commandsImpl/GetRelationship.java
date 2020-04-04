package geektrust.family.commands.commandsImpl;

import static geektrust.family.pojo.Constants.PERSON_NOT_FOUND;

import java.util.Optional;

import geektrust.family.commands.Command;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;

public class GetRelationship implements Command {

	@Override
	public String execute(String[] commandParams, Family family) {
		String name = commandParams[1];
		String relationship = commandParams[2];
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		if(!memberOpt.isPresent()) return PERSON_NOT_FOUND;
		
		return memberOpt.get().getRelatives(relationship);
	}

}
