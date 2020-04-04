package geektrust.family.relations.relationsImpl;

import static geektrust.family.pojo.Constants.NONE;

import java.util.stream.Collectors;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

public class MaternalUncle implements Relationship {

	@Override
	public String of(Member person) {
		if(person.getMother() == null) return NONE;
		if(person.getMother().getMother() == null) return NONE;
		
		String uncles = person.getMother().getMother().getChildren().stream()
				.filter(e -> e.isMale())
				.map(e -> e.getName())
				.collect(Collectors.joining(" "));
		return uncles.isEmpty() ? NONE : uncles;
	}
	
}
