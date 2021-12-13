package study.ex1hellojpa.hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin() ;
		
		try {
			
			
			// JPQL 사용
//			List<Member> result = em.createQuery(
//					"select m From Member m where m.username like '%kim%'"
//					, Member.class
//			).getResultList();
//			
//			for (Member member : result) {
//				System.out.println("member = " + member);
//			}
			
			//Criteria 사용 준비
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<Member> query = cb.createQuery(Member.class);
			//루트 클래스 (조회를 시작할 클래스)
//			Root<Member> m = query.from(Member.class);
			//쿼리 생성
//			CriteriaQuery<Member> cq =  query.select(m).where(cb.equal(m.get("username"), "kim"));
//			List<Member> resultList = em.createQuery(cq).getResultList();
			
			
			Member member = new Member();
			member.setUsername("member1");
			em.persist(member);
			
			em.flush();
			// flush는 commit과 (아래처럼)query가 날아갈 때 flush 된다.
			// 결과 0
			// 위의 경우 수동 flush 처리 필요			
			
			em.createNativeQuery("select MEMER_ID, city, street, zipcode, USERNAME from MEMBER")
			.getResultList();
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally { }
		 
  		emf.close();
		
		
	}

}
