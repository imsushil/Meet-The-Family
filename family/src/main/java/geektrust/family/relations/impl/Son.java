package geektrust.family.relations.relationsImpl;

import static geektrust.family.pojo.Constants.NONE;

import java.util.stream.Collectors;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

public class Son implements Relationship {

	@Override
	public String of(Member person) {
		Member mother = person;
		if(person.isMale()) {
			if(person.getSpouse() == null) return NONE;
			mother = person.getSpouse();
		}

		String sons = mother.getChildren().stream()
							.filter(c -> c.isMale())
							.map(c -> c.getName())
							.collect(Collectors.joining(" "));
		return sons.isEmpty() ? NONE : sons;
	}

}
