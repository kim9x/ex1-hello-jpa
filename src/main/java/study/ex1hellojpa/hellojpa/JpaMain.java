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
			
			member.getFavoriteFoods().add("ġŲ");
			member.getFavoriteFoods().add("����");
			member.getFavoriteFoods().add("����");
			
//			member.getAddressHistory().add(new Address("old1", "street", "10000"));
//			member.getAddressHistory().add(new Address("old2", "street", "10000"));
			
			em.persist(member);
			
			em.flush();
			em.clear();
			
			System.out.println("============ START =============");
			Member findMember = em.find(Member.class, member.getId());
			System.out.println("============ END =============");
			
			// homeCity -> newCity
			
			// �� Ÿ���� �̷��� �����ϸ�ȵ�.
//			findMember.getHomeAddress().setCity("newCity");
			// �̷� ������ ���� �� ��ü�� ������Ѵ�.
			Address a = findMember.getHomeAddress();
//			findMember.setHomeAddress(new Address("old1", "street", "10000"));
//			findMember.setHomeAddress(new Address("old2", "street", "10000"));
			
//			System.out.println("======= Foods =========");
			// ġŲ -> �ѽ�
			findMember.getFavoriteFoods().remove("ġŲ");
			findMember.getFavoriteFoods().add("�ѽ�");
			
//			System.out.println("======= ADDRESS =========");
			findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
			findMember.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
			findMember.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
			
			
			
			// ��ȸ
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
