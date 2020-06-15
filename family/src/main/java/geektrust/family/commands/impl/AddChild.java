package geektrust.family.commands.commandsImpl;

import static geektrust.family.pojo.Constants.CHILD_ADDITION_FAILED;
import static geektrust.family.pojo.Constants.CHILD_ADDITION_SUCCEEDED;
import static geektrust.family.pojo.Constants.PERSON_NOT_FOUND;

import java.util.Optional;

import geektrust.family.commands.Command;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;

/**
 * This commands adds child in the family tree for a specified mother.
 * 
 * @author sushil
 */
public class AddChild implements Command {

	/**
	 * 
	 * @param memberName
	 * @param childName
	 * @param gender
	 * @return PERSON_NOT_FOUND if member is not found in the family. CHILD_ADDITION_SUCCEEDED if child is added successfully 
	 * otherwise CHILD_ADDITION_FAILED if member is not female 
	 */
	@Override
	public String execute(String[] commandParam, Family family) {
		String memberName = commandParam[1];
		String childName = commandParam[2];
		String gender = commandParam[3];
		Optional<Member> memberOpt = family.searchMemberUtil(memberName);
		if(!memberOpt.isPresent()) return PERSON_NOT_FOUND;

		Member member = memberOpt.get();
		if(!member.isFemale()) return CHILD_ADDITION_FAILED;
		member.addChild(childName, gender);
		return CHILD_ADDITION_SUCCEEDED;
	}
	
}
