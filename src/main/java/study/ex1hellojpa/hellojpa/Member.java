package study.ex1hellojpa.hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

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

	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", team=" + team.toString() + "]";
	}

	/*
	public void changeTeam(Team team) {
		this.team = team;
		
		// 연관관계 편의 메소드
		// setTeam할 시점이 team.에도 셋팅을 해줄 수 있도록..
		team.getMembers().add(this);
	}
	*/
	
	
	
	
}