## Contact-Manager
A Java Graphical-User-Interface (GUI) application that manages a list of contacts by interacting with an SQL database. Contact details may include name, multiple addresses, multiple phone numbers and birthday. User operations include:  

1. Searching for a contact based on any field  
2. Adding a new contact  
3. Modifying an existing contact 
4. Deleting an existing contact

## Running the Application
1. Open Eclipse. 

2. Select File -> Open Projects from file system -> Directory -> Choose the *contact_manager* folder -> Finish

3. In the Package Explorer tab on the left hand side, right click on contact_manager -> Java Build -> PathLibraries -> ClassPath

If the file mysql-connector-java-8.0.12.jar is  already added in the ClassPath, select cancel. Else click Add JARs  Select mysql-connector-java-8.0.12.jar  which is located in folder ‘lib’ of the contact_manager project. Click on Apply and Close

4. Right click on the file *ContactManagerApp.java* -> Run as Java Application

5. Open **MySQL Workbench**. Run the *createSchema.sql* file to create the required tables

6. Run *PopulateDatabase.java* to load a list of sample contacts in your application to get started (optional). This code loads the entries from the *contacts.csv* file.

7. The application can be used now


## Design 
* The project consisted of implementing an application that interacts with a SQL database to store and retrieve and modify a user’s contacts

* The project has been implemented in Eclipse

* A Java GUI interface was chosen for implementing the contact manager application

* The Java application interacts with the SQL database to retrieve, add, or modify information about contacts.

* The application interacts with the SQL database using the **Java Database Connection (JDBC)** API in Java.

* The SQL database schema was implemented in MySQL Workbench.

* The schema for the application database was made as per the requirements given. The SQL database ‘contact_list’ consists of four relation tables: contact, address, phone, and date.

* The contents of the contacts.csv file given were imported into the MySQL database under different tables(relations).
* A **JFrame** Object was used to design the window which displays the contacts. The contacts are displayed in the JFrame using a JTable Object. It includes:
    * a **Search** button for searching for contact(s)
    * a **Add Contact** button for adding a new contact
    * a **Modify Contact** button for modifying a contact
    * A **View Contact** button for viewing a contact's information
    
* A **JDialog** object was used to retrieve information from the user to add a new contact/modify an existing contact. JLabels, JButtons and JTextField objects are used to acquire user input in the JDialog Object. It includes:
    * An  **OK** button for saving the new/modifying information
    * A **cancel** button to return to the search interface
    
* The application code consists of 4 java classes:
    * *ContactDAO.java*, which contains methods to interact with the SQL database using JDBC
    * *ContactForm.java*, which creates an object that represents a contact every time we require to pass to and from the SQL              database via the methods in ContactDAO
    * *ContactTableModel.java*, which is a class responsible for displaying all contacts/ contacts which are searched for in the JTable of the JFrame object
    * *ContactManagerApp.java*, which creates a JFrame object and starts the application
    * *AddContact.java*, which creates a JDialog object for adding a contact to the database
    
* The ContactDAO class contains methods such as searchForContact(contact), getAllContacts(), modifyContact(contact) and addContact(contact) which interface with the SQL database.

* The application can be accessed by running the **ContactManagerApp.java** class.
