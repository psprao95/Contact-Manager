# ContactManager
A Java based GUI application that manages a list of contacts by interacting with an SQL database. Contact details may include name, addresses(multiple), phone numbers(multiple) and birthday. User operations include:  
1. Searching for a contact based on any field  
2. Adding a new contact  
3. Modifying existing contacts  
4. Deleting an existing contact

Instructions form compiling and running the project:

1. Open Eclipse. 

2. Select File -> Open Projects from file system -> Directory  Choose ‘contact_manager’ folder -> Finish

3. In the Package Explorer tab on the left hand side, right click on contact_manager
Java Build -> PathLibraries -> ClassPath

If the file mysql-connector-java-8.0.12.jar is  already added in the ClassPath, select cancel. Else click Add JARs  Select mysql-connector-java-8.0.12.jar  which is located in folder ‘lib’ of the contact_manager project  Apply and Close

In case the mysql-connector-java-8.0.12.jar is not in the ‘lib’ folder, I included it in my zip file.

4. Open on ContactManagerApp class. Right-click -> Run as  Java Application

5. The application can be used now
