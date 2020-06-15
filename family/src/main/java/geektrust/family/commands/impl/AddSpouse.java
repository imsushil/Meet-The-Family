package geektrust.family.commands.impl;

import static geektrust.family.pojo.Constants.SPOUSE_ADDITION_FAILED;
import static geektrust.family.pojo.Constants.SPOUSE_ADDITION_SUCCEEDED;

import java.util.Optional;

import geektrust.family.commands.Command;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;

/**
 * Adds spouse to the specified member
 * 
 * @author sushil
 */
public class AddSpouse implements Command {

	@Override
	public String execute(String[] commandParam, Family family) {
		String memberName = commandParam[1];
		String spouseName = commandParam[2];
		String gender = commandParam[3];
		Optional<Member> memberOpt = family.searchMemberUtil(memberName);
		if(memberOpt.isPresent()) {
			Member member = memberOpt.get();
			member.addSpouse(spouseName, gender);
			return SPOUSE_ADDITION_SUCCEEDED;
		}
		return SPOUSE_ADDITION_FAILED;
	}
}
