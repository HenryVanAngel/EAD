package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class AtualizaTeste {

	public static void main(String[] args) {
		
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		// Atualizar um cliente
		//Instanciar um cliente com um ID que existe no banco
		Cliente c = new Cliente(1, "SoFalamBosta", 
				new GregorianCalendar(2000,Calendar.JANUARY,3),
				"666.666.666-16", Genero.NEUTRO, null, false);
		
		
		em.merge(c);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(c.getNome());
		em.close();
		fabrica.close();
	}

}
