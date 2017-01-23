package br.com.vexta.model;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CaixaTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplicationFirebirdPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Caixa caixa = em.find(Caixa.class, 1);
		System.out.println(caixa.getValorInicial());

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Query query = em.createQuery("SELECT c FROM Caixa c", Caixa.class);
        @SuppressWarnings("unchecked")
		List<Caixa> caixaList = query.getResultList();
        System.out.println("Caixa List:");
        for (Caixa p : caixaList) {
            System.out.println(p.toString());
            System.out.println(format.format(p.getDataInicial()));
            System.out.println(p.getDataFinal() != null ? format.format(p.getDataFinal()) : null);
            System.out.println(p.getDataFinal());
            System.out.println(p.getValorInicial());
            System.out.println(p.getValorFinal());
            System.out.println(p.getFechado());
        }

        em.getTransaction().commit();
	}

}
