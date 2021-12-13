package study.ex1hellojpa.hellojpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Member extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private String id;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	
	@Embedded
	private Address homeAddress;
	
	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOOD", joinColumns = 
			@JoinColumn(name = "MEMBER_ID")
	)
	
	@Column(name = "FOOD_NAME")
	private Set<String> favoriteFoods = new HashSet<>();
	
//	@ElementCollection
//	@CollectionTable(name = "ADDRESS", joinColumns = 
//			@JoinColumn(name = "MEMBER_ID ") 
//	)
//	private List<Address> addressHistory = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MEMBER_ID")
	private List<AddressEntity> addressHistory = new ArrayList<>();
	

//	@Column(name = "TEAM_ID")
//	private Long teamId;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
//	@OneToOne
//	@JoinColumn(name = "LOCK_ID")
//	private Locker locker;
	
//	@ManyToMany
//	@JoinTable(name =  "MEMBER_PRODUCT")
//	private List<Product> products = new ArrayList<>();
	
	@OneToMany(mappedBy = "member")
	private List<MemberProduct> memberProducts = new ArrayList<>();
	
	// 기간 Period
	@Embedded
	private Period workPeriod;
	
	// 주소 Address
//	@Embedded
//	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides(value = {@AttributeOverride(name="city", 
								column=@Column(name = "WORK_CITY")),
								@AttributeOverride(name="street",
								column=@Column(name = "WORK_STREET")),
								@AttributeOverride(name="zipCode",
								column=@Column(name = "WORK_ZIPCODE"))
	})
	private Address workAddress;

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

	public List<MemberProduct> getMemberProducts() {
		return memberProducts;
	}

	public void setMemberProducts(List<MemberProduct> memberProducts) {
		this.memberProducts = memberProducts;
	}

	public Period getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Set<String> getFavoriteFoods() {
		return favoriteFoods;
	}

	public void setFavoriteFoods(Set<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}

	public List<AddressEntity> getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(List<AddressEntity> addressHistory) {
		this.addressHistory = addressHistory;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	@Override
	public String toString() {
//		return "Member [id=" + id + ", username=" + username + ", team=" + team.toString() + "]";
		return "";
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