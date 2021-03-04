package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pet;

/**
 * Kristopher Tope - kmtope@dmacc.edu
 * 202102 CIS175 22624
 * Feb 11, 2021
 */

public class PetHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePetDatabase");

	public void addPet(Pet newPet) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newPet);
		em.getTransaction().commit();
		em.close();
	}

	public void editPet(Pet toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removePet(Pet toRemove) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select pet from Pet pet where pet.name = :selectedName and pet.species = :selectedSpecies", Pet.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toRemove.getName());
		typedQuery.setParameter("selectedSpecies", toRemove.getSpecies());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		Pet result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Pet searchPetById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet found = em.find(Pet.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Pet> searchPetByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select pet from Pet pet where pet.name = :selectedName", Pet.class);
		typedQuery.setParameter("selectedName", name);
		List<Pet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
	
	public List<Pet> searchPetBySpecies(String species) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select pet from Pet pet where pet.species = :selectedSpecies", Pet.class);
		typedQuery.setParameter("selectedSpecies", species);

		List<Pet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

	public List<Pet> showAllPets() {
		EntityManager em = emfactory.createEntityManager();
		List<Pet> allPets = em.createQuery("SELECT i FROM Pet i").getResultList();
		return allPets;
	}

}
