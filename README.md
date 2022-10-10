# devops-bootcamp-v2-project

## Tasks to accomplish
School Manager

Complete the following requirements:

- When a student enters a valid code the system should display 
a list of the subjects of the student with respective grades.
- When a teacher enters a menu should be displayed with the
following options:
	- 1. List the students of "ELEMENTARY_SCHOOL" grade
    - 2. Enter a grade for a student
	- 3. Exit

## Method used

For this project it was choose to use the Command Design Pattern wich executes the command accordingly to the options given in the menu. 

Right now the program allows the user to choose between a student and teacher Log in , and verifies if the code inserted in the input exists. 

When the log in is succesfull there is a menu for the student and the teacher.

When either choose to display a list:
 -List of Scores per subject for student
 -List of students per grade for teacher 

this options invokes the command to display the corresponding list and using the IMenuCommand interface asks the Display Class to print this Lists

In this case teacher not only can see the ELEMENTARY_SCHOOL list, since it was imlemented a method that allows to choose either MIDDLE_SCHOOL and HIGH_SCHOOL too.

Also when Teacher wants to set a score for a student this can be done by the ITeacherCommand interface, the reason there is a teacher exclusive interface is for the idea teacher will have more options in this menu in the future different for the one displaying list.

The teacher can enter the student score, first using the student code, then choosing the score for the subject and finally confirming to save this changes in the database. Wich in this case is the students.json file.

## More implementations for the future

As it was mention before it is expected that teachers could have more options, so with the command pattern all new commands just need to be added without compromisinf the rest of the code.

Also certainly there should be contempleted the implementation for more roles (directors, admin personal, etc), and with more data resources an adapter design pattern to adpat the repository accordingly to the role entering could be implemented.

and each one of this roles should have a Command Interface for each og=f its different actions.

### Clarifications

- Due to some environment issues with the project Tests could not be completely implemented to test the services functions (mayorily Gradle problems with VSCode)





