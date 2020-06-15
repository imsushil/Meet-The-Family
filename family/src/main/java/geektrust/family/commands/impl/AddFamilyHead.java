package geektrust.family.commands.impl;

import static geektrust.family.pojo.Constants.FAMILY_HEAD_ADDED;

import geektrust.family.commands.Command;
import geektrust.family.pojo.Family;

public class AddFamilyHead implements Command {

	@Override
	public String execute(String[] commandParams, Family family) {
		family.addFamilyHead(commandParams[1], commandParams[2]);
		return FAMILY_HEAD_ADDED;
	}

}
