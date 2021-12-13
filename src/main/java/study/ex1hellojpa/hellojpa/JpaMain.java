package study.ex1hellojpa.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin() ;
		
		try {
			
			Member member = new Member();
			member.setUsername("member1");
			member.setHomeAddress(new Address("homeCity", "street", "10000"));
			
			member.getFavoriteFoods().add("치킨");
			member.getFavoriteFoods().add("족발");
			member.getFavoriteFoods().add("피자");
			
//			member.getAddressHistory().add(new Address("old1", "street", "10000"));
//			member.getAddressHistory().add(new Address("old2", "street", "10000"));
			
			em.persist(member);
			
			em.flush();
			em.clear();
			
			System.out.println("============ START =============");
			Member findMember = em.find(Member.class, member.getId());
			System.out.println("============ END =============");
			
			// homeCity -> newCity
			
			// 값 타입은 이렇게 수정하면안됨.
//			findMember.getHomeAddress().setCity("newCity");
			// 이런 식으로 완전 히 교체를 해줘야한다.
			Address a = findMember.getHomeAddress();
//			findMember.setHomeAddress(new Address("old1", "street", "10000"));
//			findMember.setHomeAddress(new Address("old2", "street", "10000"));
			
//			System.out.println("======= Foods =========");
			// 치킨 -> 한식
			findMember.getFavoriteFoods().remove("치킨");
			findMember.getFavoriteFoods().add("한식");
			
//			System.out.println("======= ADDRESS =========");
			findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
			findMember.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
			findMember.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
			
			
			
			// 조회
//			List<Address> addressHistory = findMember.getAddressHistory();
//			for (Address address : addressHistory) {
//				System.out.println("address = " + address.getCity());
//			}
//			
//			Set<String> favoriteFoods = findMember.getFavoriteFoods();
//			for (String favorriteFood : favoriteFoods) {
//				System.out.println("favoriteFood = " + favoriteFoods);
//			}
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally { }
		 
  		emf.close();
		
		
	}

}
