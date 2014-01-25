package fr.ingesup.vroumvroum.ws.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.ingesup.vroumvroum.ws.models.events.Event;
import fr.ingesup.vroumvroum.ws.models.user.User;

public class MainTest {
	private static Session s = null;

	public static void main(String[] args) {
		// Ouverture d'une session Hibernate
		s = HibernateUtils.getSession();

//		// Vide la table USERS de ses �ventuelles entr�es
//		clean();

		// Lancement des tests successifs
		testCreate();
//		testRead();
//		testUpdate();
//		testDelete();	//Impossible sur la table user si on a ajout� des devices au user (contrainte de cl� �trang�re)

		// Fermeture de la session Hibernate
		s.close();
	}

	// Cr�ation d'un user
	private static void testCreate() {
		System.out.println("--------- testCreate ---------");

		Transaction tx = s.beginTransaction();

		User testUser = new User();
		testUser.setFirstName("Olivier");
		testUser.setLastName("Revial");
		testUser.setFacebookId("123456789");
		testUser.setPassword("************");
		testUser.setPhoneNumber("0102030405");
		s.saveOrUpdate(testUser);

		// Cr�ation des objets � sauvegarder
		for(int i=0; i<10; i++) {
			Event event = new Event();
			event.setName("Event " + i);
			event.setDescription("La description de l'event n�" + i);

			if(i%3 == 0) {
				event.setOwner(testUser);
			}
			
			s.saveOrUpdate(event);
		}
		
		
		// Fermeture de la transaction
		tx.commit();

		// Affiche le contenu de la table USER
//		print();
	}
//
//	// Lecture d'un user
//	private static void testRead() {
//		System.out.println("--------- testRead ---------");
//
//		// R�cup�ration du User d'apr�s son pr�nom
//		Query q = s.createQuery("from User where first_name= :myName");
//		q.setString("myName", "Olivier");
//		
//		for((ArrayList<User> ))
//		User u = (User) q.uniqueResult();
//
//		// Affichage de l'objet r�cup�r�
//		System.out.println("User : [id] = " + u.getId() + "\t" +
//				"[FirstName] = " + u.getFirstName() + "\t" +
//				"[LastName] = " + u.getLastName() + "\t" + 
//				"[Email] = " + u.getEmail() + "\t" + 
//				"[Password] = " + u.getPassword());
//	}

//	// Modification d'un user
//	private static void testUpdate() {
//		System.out.println("--------- testUpdate ---------");
//		System.out.println("Avant modification");
//		print();
//
//		// R�cup�ration du User d'apr�s son pr�nom
//		Query q = s.createQuery("from User where first_name= :myName");
//		q.setString("myName", "Olivier");
//		User u = (User) q.uniqueResult();
//
//		// Modifications des attributs de l'objet
//		u.setFirstName("Ren�");
//
//		// Prise en compte de la modification
//		Transaction tx = s.beginTransaction();
//		s.update(u);
//		tx.commit();
//
//		System.out.println("Apr�s modification");
//		print();
//	}

	// Suppression d'un user
//	private static void testDelete() {
//		System.out.println("--------- testDelete ---------");
//		System.out.println("Avant suppression");
//		print();
//
//		// R�cup�ration du User d'apr�s son pr�nom
//		Query q = s.createQuery("from User where last_name= :myName");
//		q.setString("myName", "Barth�l�my");
//		User u = (User) q.uniqueResult();
//
//		// Enregistrement de la suppression
//		Transaction tx = s.beginTransaction();
//		s.delete(u);
//		tx.commit();
//
//		System.out.println("Apr�s suppression");
//		print();
//	}




	// Vide la table USERS de toutes ses entr�es
//	private static void clean() {
//		System.out.println("--------- Vide la table users : ---------");
//		// D�but de la transaction
//		Transaction tx = s.beginTransaction();
//
//		// Cr�ation de la requ�te
//		Query q = s.createQuery("delete User");
//		// Ex�cution de la requ�te
//		q.executeUpdate();
//
//		// Fin de la transaction
//		tx.commit();
//	}

//	// Affiche le contenu de la table USERS
//	private static void print() {
//		// D�but de la transaction
//		Transaction tx = s.beginTransaction();
//
//		// Cr�ation de la requ�te
//		Query q = s.createQuery("from User");
//		ArrayList<User> list = (ArrayList<User>) q.list();
//		// Affichage de la liste de r�sultats
//		for (User u: list) {
//			System.out.println("User : [id] = " + u.getId() + "\t" +
//					"[FirstName] = " + u.getFirstName() + "\t" +
//					"[LastName] = " + u.getLastName() + "\t" + 
//					"[Email] = " + u.getEmail() + "\t" + 
//					"[Password] = " + u.getPassword());
//		}
//
//		// Fin de la transaction
//		tx.commit();
//	}
}
