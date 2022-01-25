package com.groupl.controllers.jonathanabout;

import java.util.ArrayList;

public class UserName {
    private ArrayList<String> possibleNames;

    public UserName(String firstName, String lastName) {
        possibleNames = new ArrayList<String>();
        for (int i = 1; i < firstName.length(); i++) {
            possibleNames.add(lastName + firstName.substring(0, i));
        }
    }

    public void setAvailableUserNames(String[] usedNames) {
        for (String name : possibleNames) {
            if (isUsed(name, usedNames)) {
                possibleNames.remove(name);
            }
        }
    }

    public boolean isUsed(String name, String[] arr) {
        for (String usedName : arr) {
            if (name.equals(usedName)) {
                return true;
            }
        }

        return false;
    }

    public Object[] getPossibleNames() {
        return possibleNames.toArray();
    }
}

