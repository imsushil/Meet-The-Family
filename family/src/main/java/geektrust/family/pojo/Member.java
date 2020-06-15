package geektrust.family.pojo;

import geektrust.family.relations.RelationshipMap;

import java.util.*;
import java.util.stream.Collectors;

import static geektrust.family.pojo.Constants.*;

public class Member {
    private String name;
    private String gender;
    private Member spouse;
    private Member mother;
    private Member father;

    private List<Member> children;

    public Member() {
        this.children = new ArrayList<>();
    }

    public Member(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    /* ====================================
     * DEFAULT METHODS
     * ====================================*/

    /**
     * This method is used in Family class only. It helps in traversing through the family tree for finding any member.
     * Notice the access modifier is default so that only the classes within the pojo can access it.
     *
     * @return reference to the children
     */
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
        if (!gender.equalsIgnoreCase(MALE) && !gender.equalsIgnoreCase(FEMALE)) {
            throw new IllegalArgumentException(INVALID_GENDER);
        }
        Member member = new Member(childName, gender);
        member.mother = this;
        member.father = this.spouse;
        this.children.add(member);
    }

    /**
     * This method adds spouse to the member
     *
     * @param spouseName
     * @param gender
     */
    public void addSpouse(String spouseName, String gender) {
        this.spouse = new Member(spouseName, gender);
        this.spouse.spouse = this;
    }

    /**
     * @return daughters(s) of the person
     */
    public List<String> daughters() {
        Member member = this;
        if(this.isMale()) {
            if(this.getSpouse() == null) return new ArrayList<>();
            member = this.getSpouse();
        }
        return member.children.stream()
                              .filter(Member::isFemale)
                              .map(Member::getName)
                              .collect(Collectors.toList());
    }

    /**
     * @return son(s) of the person
     */
    public List<String> sons() {
        Member member = this;
        if(this.isMale()) {
            if(this.getSpouse() == null) return new ArrayList<>();
            member = this.getSpouse();
        }
        return member.children.stream()
                              .filter(Member::isMale)
                              .map(Member::getName)
                              .collect(Collectors.toList());
    }

    /**
     * @return sibling(s) of the person
     */
    public List<String> siblings() {
        return this.mother.children.stream().filter(member ->
                !member.getName().equalsIgnoreCase(this.getName())
        ).map(Member::getName).collect(Collectors.toList());
    }

    /**
     * @return brothers of the member
     */
    public List<String> brothers() {
        List<String> brothers = new ArrayList<>();
        if (this.mother != null) {
            brothers = this.mother.children
                                  .stream()
                                  .filter(e -> e.isMale() && !e.name.equalsIgnoreCase(this.name))
                                  .map(e -> e.name)
                                  .collect(Collectors.toList());
        }
        return brothers;
    }

    /**
     * @return sisters of the member
     */
    public List<String> sisters() {
        List<String> sisters = new ArrayList<>();
        if (this.mother != null) {
            sisters = this.mother.children
                                 .stream()
                                 .filter(e -> e.isFemale() && !e.name.equalsIgnoreCase(this.name))
                                 .map(e -> e.name)
                                 .collect(Collectors.toList());
        }
        return sisters;
    }

    /**
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) &&
                Objects.equals(gender, member.gender) &&
                Objects.equals(spouse, member.spouse) &&
                Objects.equals(mother, member.mother) &&
                Objects.equals(father, member.father) &&
                Objects.equals(children, member.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, spouse, mother, father, children);
    }
}
