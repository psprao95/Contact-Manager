## Contact-Manager
A Java based GUI application that manages a list of contacts by interacting with an SQL database. Contact details may include name, addresses(multiple), phone numbers(multiple) and birthday. User operations include:  

1. Searching for a contact based on any field  
2. Adding a new contact  
3. Modifying an existing contact 
4. Deleting an existing contact

## Running the Application
Instructions form compiling and running the project:

1. Open Eclipse. 
2. Select File -> Open Projects from file system -> Directory -> Choose ‘contact_manager’ folder -> Finish
3. In the Package Explorer tab on the left hand side, right click on contact_manager
Java Build -> PathLibraries -> ClassPath
If the file mysql-connector-java-8.0.12.jar is  already added in the ClassPath, select cancel. Else click Add JARs  Select mysql-connector-java-8.0.12.jar  which is located in folder ‘lib’ of the contact_manager project  Apply and Close
In case the mysql-connector-java-8.0.12.jar is not in the ‘lib’ folder, I have included it in my zip file.
4. Open the file 'ContactManagerApp.java'. Right-click -> Run as Java Application
5. Open MySql Workbench. Run the 'createSchema.sql' file to create the tables
6. Run 'PopulateDatabase.java' to load a list of sample contacts in your application to get started (optional).
7. The application can be used now. Enjoy!


## Project Design 
1. The project consisted of implementing an application that interacts with a SQL database to store and retrieve and modify a user’s contacts.
2. The project has been implemented in Eclipse.
3. A Java GUI interface was chosen for implementing the contact manager app.
4. The Java application interacts with the SQL database to retrieve, add, or modify information about contacts.
5. The application interacts with the SQL database using the Java Database Connection (JDBC) API in Java.
6. The SQL database was implemented in MySQL.
7. The schema for the application database was made as per the requirements given. The SQL database ‘contact_list’ consists of 4 relation tables contact, address, phone, and date.
8. The contents of the contacts.csv file given were imported into the MySQL database under different tables(relations).
9. A Java JFrame Object was used to design the window which displays the contacts. The contacts are displayed in the JFrame using a JTable Object. It includes:
    1. a button for searching for contact(s)
    2. a button for adding a new contact
    3. a button for modifying a contact
    4. A button for viewing a contact's information
10. A Java JDialog Object was used to retrieve information from the user to add a new contact/modify an existing contact. JLabels, JButtons and JTextField objects are used to acquire user input in the JDialog Object. It includes:
    1. A button for saving the new/modifying information
    2. A ‘cancel’ button to return to the search interface
11. The application code consists of 4 java classes:
    1. *ContactDAO.java*, which contains methods to interact with the SQL database using JDBC
    2. *ContactForm.java*, which creates an object that represents a contact every time we require to pass to and from the SQL              database via the methods in ContactDAO
    3. *ContactTableModel.java*, which is a class responsible for displaying all contacts/ contacts which are searched for in the            JTable of the JFrame object
    4. *ContactManagerApp.java*, which creates a JFrame object and starts the application
    5. *AddContact.java, which creates a JDialog object for adding a contact to the database
12. The ContactDAO class contains methods such as searchForContact(contact), getAllContacts(), modifyContact(contact) and addContact(contact) which interface with the SQL database.
13. The application can be accessed by running the ContactManagerApp.java class.
