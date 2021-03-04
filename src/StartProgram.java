import java.util.List;
import java.util.Scanner;

import controller.PetHelper;
import model.Pet;



/**
 * Kristopher Tope - kmtope@dmacc.edu
 * 202102 CIS175 22624
 * Feb 11, 2021
 */

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static PetHelper ph = new PetHelper();
	
	private static void addPet() {
		System.out.print("Pet's name: ");
		String name = in.nextLine();
		System.out.print("Species: ");
		String species = in.nextLine();
		Pet newPet = new Pet(name, species);
		ph.addPet(newPet);
	}
	
	private static void editPet() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Species");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Pet> foundPets;
		if (searchBy == 1) {
			System.out.print("Enter name: ");
			String name = in.nextLine();
			foundPets = ph.searchPetByName(name);
		} else {
			System.out.print("Enter the species: ");
			String species = in.nextLine();
			foundPets = ph.searchPetBySpecies(species);
		}

		if (!foundPets.isEmpty()) {
			System.out.println("Found Results.");
			for (Pet p : foundPets) {
				System.out.println(p.getId() + " : " + p.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Pet toEdit = ph.searchPetById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " (" + toEdit.getSpecies() + ")");
			System.out.println("1 : Edit Name");
			System.out.println("2 : Edit Species");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Species: ");
				String newSpecies = in.nextLine();
				toEdit.setSpecies(newSpecies);
			}

			ph.editPet(toEdit);

		} else {
			System.out.println("No pets found");
		}
	}
	
	private static void removePet() {
		System.out.print("Name of pet to remove: ");
		String name = in.nextLine();
		System.out.print("Species of pet to remove: ");
		String species = in.nextLine();
		Pet toRemove = new Pet(name, species);
		ph.removePet(toRemove);
	}
	
	public static void main(String[] args) {
		runMenu();
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("|~~~~|PETS|~~~~|");
		while (goAgain) {
			System.out.println("*  1 -- Add a pet");
			System.out.println("*  2 -- Edit a pet");
			System.out.println("*  3 -- Remove a pet");
			System.out.println("*  4 -- View all pets");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Make your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addPet();
			} else if (selection == 2) {
				editPet();
			} else if (selection == 3) {
				removePet();
			} else if (selection == 4) {
				viewAllPets();
			} else {
				ph.cleanUp();
				System.out.println("Goodbye!");
				goAgain = false;
			}
		}
	}

	private static void viewAllPets() {
		List<Pet> allItems = ph.showAllPets();
		for(Pet singlePet : allItems){
		System.out.println(singlePet.printPet());
		}
	}
}
