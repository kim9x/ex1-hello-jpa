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
			
			
			// JPQL ���
//			List<Member> result = em.createQuery(
//					"select m From Member m where m.username like '%kim%'"
//					, Member.class
//			).getResultList();
//			
//			for (Member member : result) {
//				System.out.println("member = " + member);
//			}
			
			//Criteria ��� �غ�
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<Member> query = cb.createQuery(Member.class);
			//��Ʈ Ŭ���� (��ȸ�� ������ Ŭ����)
//			Root<Member> m = query.from(Member.class);
			//���� ����
//			CriteriaQuery<Member> cq =  query.select(m).where(cb.equal(m.get("username"), "kim"));
//			List<Member> resultList = em.createQuery(cq).getResultList();
			
			
			Member member = new Member();
			member.setUsername("member1");
			em.persist(member);
			
			em.flush();
			// flush�� commit�� (�Ʒ�ó��)query�� ���ư� �� flush �ȴ�.
			// ��� 0
			// ���� ��� ���� flush ó�� �ʿ�			
			
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
