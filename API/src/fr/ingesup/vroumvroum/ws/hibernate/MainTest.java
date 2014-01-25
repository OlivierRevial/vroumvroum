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

//		// Vide la table USERS de ses éventuelles entrées
//		clean();

		// Lancement des tests successifs
		testCreate();
//		testRead();
//		testUpdate();
//		testDelete();	//Impossible sur la table user si on a ajouté des devices au user (contrainte de clé étrangère)

		// Fermeture de la session Hibernate
		s.close();
	}

	// Création d'un user
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

		// Création des objets à sauvegarder
		for(int i=0; i<10; i++) {
			Event event = new Event();
			event.setName("Event " + i);
			event.setDescription("La description de l'event n°" + i);

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
//		// Récupération du User d'après son prénom
//		Query q = s.createQuery("from User where first_name= :myName");
//		q.setString("myName", "Olivier");
//		
//		for((ArrayList<User> ))
//		User u = (User) q.uniqueResult();
//
//		// Affichage de l'objet récupéré
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
//		// Récupération du User d'après son prénom
//		Query q = s.createQuery("from User where first_name= :myName");
//		q.setString("myName", "Olivier");
//		User u = (User) q.uniqueResult();
//
//		// Modifications des attributs de l'objet
//		u.setFirstName("René");
//
//		// Prise en compte de la modification
//		Transaction tx = s.beginTransaction();
//		s.update(u);
//		tx.commit();
//
//		System.out.println("Après modification");
//		print();
//	}

	// Suppression d'un user
//	private static void testDelete() {
//		System.out.println("--------- testDelete ---------");
//		System.out.println("Avant suppression");
//		print();
//
//		// Récupération du User d'après son prénom
//		Query q = s.createQuery("from User where last_name= :myName");
//		q.setString("myName", "Barthélémy");
//		User u = (User) q.uniqueResult();
//
//		// Enregistrement de la suppression
//		Transaction tx = s.beginTransaction();
//		s.delete(u);
//		tx.commit();
//
//		System.out.println("Après suppression");
//		print();
//	}




	// Vide la table USERS de toutes ses entrées
//	private static void clean() {
//		System.out.println("--------- Vide la table users : ---------");
//		// Début de la transaction
//		Transaction tx = s.beginTransaction();
//
//		// Création de la requête
//		Query q = s.createQuery("delete User");
//		// Exécution de la requête
//		q.executeUpdate();
//
//		// Fin de la transaction
//		tx.commit();
//	}

//	// Affiche le contenu de la table USERS
//	private static void print() {
//		// Début de la transaction
//		Transaction tx = s.beginTransaction();
//
//		// Création de la requête
//		Query q = s.createQuery("from User");
//		ArrayList<User> list = (ArrayList<User>) q.list();
//		// Affichage de la liste de résultats
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
