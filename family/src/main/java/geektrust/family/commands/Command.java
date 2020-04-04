package geektrust.family.commands;

import geektrust.family.pojo.Family;

public interface Command {
	String execute(String[] commandParams, Family family);
}
