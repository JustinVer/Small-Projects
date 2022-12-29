/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: Name
 * Description: Name object with first name last name and title
 */
package main;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Name {
	private String firstName;
	private String lastName;
	private String title;
public String getFirst() {
	return firstName;
}
public String getLast() {
	return lastName;
}
public String getTitle() {
	return title;
}
public String getInitials() {
	char FL = firstName.charAt(0);
	char LL = lastName.charAt(0);
	String Initials = FL + "." + LL + ".";
	return Initials;
}
public void setTitle(String t) {
	title = t;
}
public void setFirst(String f) {
	firstName = f;
}
public void setLast(String l) {
	lastName = l;
}
}

