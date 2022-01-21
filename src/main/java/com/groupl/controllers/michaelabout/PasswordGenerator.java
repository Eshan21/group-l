package com.groupl.controllers.michaelabout;
import java.util.ArrayList;

public class PasswordGenerator {
    private String passwordPrefix;
	private int randomNumLength;
	private static ArrayList<String> passwordList = new ArrayList<String>();

	private String numberListCache = "0123456789";

	public PasswordGenerator(int length, String prefix) {
		this.passwordPrefix = prefix;
		this.randomNumLength = length;
	}

	public PasswordGenerator(int length) {
		this.passwordPrefix = "A";
		this.randomNumLength = length;
	}

	public String pwGen() {
		String output = this.passwordPrefix + ".";
		for(int i = 0; i < this.randomNumLength; i++) {
			output += numberListCache.charAt((int)(Math.random() * 10));
		}

		passwordList.add(output);
		return output;

	}

    public void clearPasswordList() {
        passwordList = new ArrayList<String>();
    } 

	public int pwCount() {
		return passwordList.size();
	}

    public ArrayList<String> getGeneratedPassword() {
        return passwordList;
    }

    // public String toString() {

    //     String output = new String();
    //     for(string password : passwordlist) {
    //     }

    // }

	public static void runTests() {
		Object output, expectOutput;
		
		PasswordGenerator pw1 = new PasswordGenerator(4, "chs");
		output = pw1.pwCount();
		System.out.println(output);

		output = pw1.pwGen();
		System.out.println(output);

		output = pw1.pwGen();
		System.out.println(output);

		output = pw1.pwCount();
		System.out.println(output);

		PasswordGenerator pw2 = new PasswordGenerator(6);

		output = pw2.pwCount();
		System.out.println(output);

		output = pw2.pwGen();
		System.out.println(output);

		output = pw2.pwCount();
		System.out.println(output);

		output = pw1.pwCount();
		System.out.println(output);
	}


	public static void main(String[] args) {
		PasswordGenerator.runTests();
	}
}
