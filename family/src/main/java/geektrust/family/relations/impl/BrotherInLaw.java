package geektrust.family.relations.relationsImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import geektrust.family.pojo.Constants;
import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

public class BrotherInLaw implements Relationship {

	@Override
	public String of(Member person) {
		List<String> brotherInLaw = new ArrayList<>();

		// Add husbands of siblings
		if(person.getMother() != null) {
			List<String> brothers = person.getMother().getChildren().stream()
									.filter(m -> m.isFemale() 
												&& m.getSpouse() != null 
												&& !m.getName().equalsIgnoreCase(person.getName())
									)
									.map(m -> m.getSpouse().getName())
									.collect(Collectors.toList());
			brotherInLaw.addAll(brothers);
		}

		// Add brothers of spouse
		if (person.getSpouse() != null) {
			brotherInLaw.addAll(person.getSpouse().brothers());
		}
		String inLaws = String.join(" ", brotherInLaw);
		return inLaws.isEmpty() ? Constants.NONE : inLaws;
	}

}
