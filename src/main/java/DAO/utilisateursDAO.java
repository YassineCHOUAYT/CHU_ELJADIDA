package DAO;

import beans.utilisateurs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class utilisateursDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CHU");

    public static utilisateurs trouverParEmailEtMotDePasse(String email, String motDePasse) {
        EntityManager em = emf.createEntityManager();
        try {
            // Cr�er une requ�te pour r�cup�rer l'utilisateur par email et mot de passe
            Query query = em.createQuery("FROM utilisateurs WHERE email = :email AND motDePasse = :motDePasse");
            query.setParameter("email", email);
            query.setParameter("motDePasse", motDePasse);

            return (utilisateurs) query.getSingleResult();
        } catch (Exception e) {
            // Si aucune donn�e n'est trouv�e, retourner null
            return null;
        } finally {
            em.close();  // Toujours fermer l'EntityManager
        }
    }
}
