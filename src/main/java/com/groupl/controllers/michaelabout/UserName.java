package com.groupl.controllers.michaelabout;

import java.util.ArrayList;

public class UserName {

	// The list of possible user names, based on a user’s first and last names and initialized by the constructor.

	private ArrayList<String> possibleNames;

	/** Constructs a UserName object as described in part (a).

	* Precondition: firstName and lastName have length greater than 0

	* and contain only uppercase and lowercase letters.

	*/

	private void generateNames(String firstName, String lastName) {

		this.possibleNames.add(lastName+ firstName);
		// this.possibleNames.add(firstName.toLowerCase() + lastName);
		// this.possibleNames.add(firstName + lastName.toLowerCase());
		// this.possibleNames.add(firstName.toLowerCase() + lastName.toLowerCase());

		int firstNameLength = firstName.length();
		int lastNameLength = lastName.length();

		String combination = firstName + lastName;
		for(int i = firstNameLength + lastNameLength; i > firstNameLength; i--) {
			this.possibleNames.add(
				combination.substring(0, i)
			);
		}
	}

	public UserName(String firstName, String lastName) {

		possibleNames = new ArrayList<String>();

		// check if your mom has a name
		//
		if(firstName.length() == 0 || lastName.length() == 0) {

			System.out.println("the name is not long enough lol");
		}

		// start generating possible names

		generateNames(firstName, lastName);
	}

	public void printAllUsers() {
		for(String name : possibleNames) {
			System.out.println(name);
		}
	}

	/** Returns true if arr contains name, and false otherwise. */

	public boolean isUsed(String name, String[] arr) {
	
		for(String possibleName : arr) {
			if(possibleName == name) 
				return true;
		}

		return false;
	}

	 

	/** Removes strings from possibleNames that are found in usedNames as described in part (b).

	*/

	public void setAvailableUserNames(String[] usedNames) {
		for(String usedName : usedNames) {
			for(int i = 0; i < possibleNames.size(); i++) {
				if(usedName.equals(possibleNames.get(i))) {
					// remove not working
					possibleNames.remove(i);
				}
			}
		}
	}

	public static void main(String args[]) {
		UserName person = new UserName("john", "smith");
		String[] used = {
			"johnsmi"
		};
		person.setAvailableUserNames(used);
		person.printAllUsers();
	}

}
