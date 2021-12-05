package study.ex1hellojpa.hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		member.setTeam(this);
		members.add(member);
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", members=" + members + "]";
		
		
//		return "toString�� ������??";
	}
	
	

}
