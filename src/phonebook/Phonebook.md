# 📱 Simple Phonebook Application (Java)

This repository contains a basic command-line phonebook application implemented in Java.

## 📖 Description

This Java program allows users to manage a simple phonebook stored in a text file. Users can add, search for, and delete contacts.

**✨ Key Features:**

* **Contact Management:** Add, search, and delete contacts.
* **File Storage:** Stores contact information in a plain text file (`phonebook.txt`).
* **Command-Line Interface:** Provides a simple menu-driven interface for user interaction.
* **Error Handling:** Includes basic error handling for file operations and invalid input.

#### ⚙️ Functionality

The program provides the following functionalities:

1.  **Add a Contact:**
    * Prompts the user to enter the contact's name and phone number.
    * Appends the contact information to the `phonebook.txt` file.
2.  **Search for a Contact:**
    * Prompts the user to enter the name to search for.
    * Searches the `phonebook.txt` file for matching contacts.
    * Displays the found contact information or a "Contact not found" message.
3.  **Delete a Contact:**
    * Prompts the user to enter the name of the contact to delete.
    * Creates a temporary file, copies all contacts except the one to be deleted, and replaces the original file with the temporary one.
    * Displays a success or failure message.
4.  **Exit:**
    * Exits the application.

##### 📁 Code Structure

* **`Phonebook.java`:** Contains the main application logic, including the menu, file operations, and contact management functions.
* **`FILE_PATH`:** A constant string defining the path to the phonebook file (`phonebook.txt`).
* **`main()`:** The entry point of the application, which displays the menu and handles user input.
* **`addContact()`:** Adds a new contact to the phonebook file.
* **`searchContact()`:** Searches for a contact in the phonebook file.
* **`deleteContact()`:** Deletes a contact from the phonebook file.

###### 📝 Notes

* The phonebook data is stored in a simple text file, which may not be suitable for large datasets.
* Contacts are saved in the format "Name, Telephone".
* Basic error handling is implemented, but more robust error handling could be added.
* This is a simple example and can be extended with additional features, such as editing contacts or sorting the phonebook.
