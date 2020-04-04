package geektrust.family.pojo;

import static geektrust.family.pojo.Constants.FEMALE;
import static geektrust.family.pojo.Constants.INVALID_GENDER;
import static geektrust.family.pojo.Constants.MALE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import geektrust.family.relations.RelationshipMap;

public class Member {
	private String name;
	private String gender;
	private Member spouse;
	private Member mother;
	private Member father;

	private List<Member> children;

	public Member() {
		this.children = new ArrayList<Member>();
	}

	public Member(String name, String gender) {
		this.name = name;
		this.gender = gender;
		this.children = new ArrayList<Member>();
	}
	
	/* ====================================
	 * DEFAULT METHODS
	 * ====================================*/
	
	
	List<Member> children() {
		return children;
	}
	
	/* ====================================
	 * PUBLIC METHODS
	 * ====================================*/
	
	/**
	 * This method adds child to the children(LinkedHashMap)
	 *
	 * @param childName
	 * @param gender
	 */
	public void addChild(String childName, String gender) {
		if(!gender.equalsIgnoreCase(MALE) && !gender.equalsIgnoreCase(FEMALE)){
			throw new IllegalArgumentException(INVALID_GENDER);
		}
		Member member = new Member(childName, gender);
		member.mother = this;
		member.father = this.spouse;
		this.children.add(member);
	}
	
	/**
	 * This method adds spouse to the member
	 * @param spouseName
	 * @param gender
	 */
	public void addSpouse(String spouseName, String gender) {
		this.spouse = new Member(spouseName, gender);
		this.spouse.spouse = this;
	}

	/**
	 * 
	 * @return brothers of the member
	 */
	public List<String> brothers() {
		List<String> brothers = new ArrayList<>();
		if(this.mother != null) {
			brothers = this.mother.children.stream()
				.filter(e -> e.isMale() && !e.name.equalsIgnoreCase(this.name))
				.map(e -> e.name)
				.collect(Collectors.toList());
		}
		return brothers;
	}

	/**
	 * 
	 * @return sisters of the member
	 */
	public List<String> sisters() {
		List<String> sisters = new ArrayList<>();
		if(this.mother != null) {
			sisters = this.mother.children.stream()
					.filter(e -> e.isFemale() && !e.name.equalsIgnoreCase(this.name))
					.map(e -> e.name)
					.collect(Collectors.toList());
		}
		return sisters;
	}
	
	/**
	 * 
	 * @return siblings of the member
	 */
	public List<String> siblings() {
		return this.mother.children.stream().filter(member -> {
			return !member.name.equalsIgnoreCase(this.name);
		}).map(m -> m.name).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param relationship
	 * @return a 
	 */
	public String getRelatives(String relationship) {
		return RelationshipMap.get(relationship).of(this);
	}
	
	/**
	 * This method will be used in Relationship classes.
	 * 
	 * @return an unmodifiable copy of children. If collection is modified, it will throw UnsupportedOperationException 
	 */
	public Collection<Member> getChildren() {
		return Collections.unmodifiableCollection(children);
	}

	public boolean isFemale() {
		return FEMALE.equalsIgnoreCase(gender);
	}
	public boolean isMale() {
		return MALE.equalsIgnoreCase(gender);
	}
	
	public Member getMother() {
		return mother;
	}

	public Member getFather() {
		return father;
	}
	
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public Member getSpouse() {
		return spouse;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((spouse == null) ? 0 : spouse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (spouse == null) {
			if (other.spouse != null)
				return false;
		} else if (!spouse.equals(other.spouse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", gender=" + gender + ", spouse=" + spouse + ", mother=" + mother + ", father="
				+ father + ", children=" + children + "]";
	}
	
	
}
