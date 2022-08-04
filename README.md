# Coding Challenge

## User Import
We are looking to import some users into out system and often other tools have messy data, or data that does not import easily to our system. To keep our data consistent we need to make sure we check the inputs before we accept them.

We would like you to write a basic user import service that, given some input data, can determine which users are importable.

### The rules behind importing a user into Small Improvements are as follows:
1. An email address is required for each user.
1. The email address needs to be unique.
1. An employee number is optional for each user, but if it exists it must be unique.
1. A user's manager is identified by managerEmail. 
   - A user is not required to have a manager. 
   - The reporting structure is not allowed to be cyclic.

### The solution is expected to provide:
1. An easy way to programmatically access the importable users.
1. An end-user-readable error messages for the users that can't be imported.

### Non functional requirements are:
1. Given a much larger input set of 2000 users, performance should still be reasonable.
1. The core logic should be well-tested.
1. Clean code.

For the tests  JUnit and Spock are provided.
You may add any libraries or frameworks you like, if you think they would help you create a better solution.

## Project Setup
We use Gradle to configure our projects. You can import this project and its `build.gradle` into your IDE. 
If you'd like to use plain gradle you can execute your tests with `./gradlew test`.
You find the users to import inside the ImportUser class.


## Multithreading
Though a for-loop would be more than enough to deal with a collection of size even in the order of a lakh, it will be fruitful to use the multithreading concepts
when the operations performed on the elements of the collection prove to be expensive. This code features use of multithreading to traverse through a list of users and perform
a set of predefined computations in them.

Also, this code has a feature of detecting cycles in a forest containing directed
graphs. 

![enter image description here](https://abhilashsangireddy.github.io/mancala-documentation/pics/4.png)