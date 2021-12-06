package study.ex1hellojpa.hellojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private String id;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;

//	@Column(name = "TEAM_ID")
//	private Long teamId;
	
//	@ManyToOne (fetch = FetchType.LAZY)
//	@JoinColumn(name = "TEAM_ID")
//	private Team team;
	
//	@OneToOne
//	@JoinColumn(name = "LOCK_ID")
//	private Locker locker;
	
//	@ManyToMany
//	@JoinTable(name =  "MEMBER_PRODUCT")
//	private List<Product> products = new ArrayList<>();
	
	@OneToMany(mappedBy = "member")
	private List<MemberProduct> memberProducts = new ArrayList<>();
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public Team getTeam() {
//		return team;
//	}
//	
//	public void setTeam(Team team) {
//		this.team = team;
//	}

	@Override
	public String toString() {
//		return "Member [id=" + id + ", username=" + username + ", team=" + team.toString() + "]";
		return "";
	}

	/*
	public void changeTeam(Team team) {
		this.team = team;
		
		// �������� ���� �޼ҵ�
		// setTeam�� ������ team.���� ������ ���� �� �ֵ���..
		team.getMembers().add(this);
	}
	*/
	
	
	
	
}