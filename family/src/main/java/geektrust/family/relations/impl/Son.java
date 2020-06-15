package geektrust.family.relations.impl;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

import static geektrust.family.pojo.Constants.NONE;

public class Son implements Relationship {

	@Override
	public String of(Member person) {
		String sons = String.join(" ", person.sons());
		return sons.isEmpty() ? NONE : sons;
	}

}
