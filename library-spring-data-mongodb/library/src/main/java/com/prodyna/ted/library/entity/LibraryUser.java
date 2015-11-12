package com.prodyna.ted.library.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public class LibraryUser implements Serializable {

	private static final long serialVersionUID = -740327000132986294L;

	@Id
	private String libraryUserID;
	private String username;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String telephoneNumber;
	
	public LibraryUser() {
	}
	
	public LibraryUser(String firstName, String secondName) {
		this.firstName = firstName;
		this.lastName = secondName;
		this.username = firstName;
		this.dateOfBirth = new Date();
		this.telephoneNumber = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String secondName) {
		this.lastName = secondName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getLibraryUserID() {
		return libraryUserID;
	}

	public void setLibraryUserID(String libraryUserID) {
		this.libraryUserID = libraryUserID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((libraryUserID == null) ? 0 : libraryUserID.hashCode());
		result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryUser other = (LibraryUser) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (libraryUserID == null) {
			if (other.libraryUserID != null)
				return false;
		} else if (!libraryUserID.equals(other.libraryUserID))
			return false;
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null)
				return false;
		} else if (!telephoneNumber.equals(other.telephoneNumber))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LibraryUser [libraryUserID=" + libraryUserID + ", username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", telephoneNumber=" + telephoneNumber
				+ "]";
	}

}
