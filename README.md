# Coding Challenge

## User Import
At Small Improvements we build an application targeted towards other businesses. Many of our clients maintain their employee list in other tools.  In this case we integrate with those tools to import users into Small Improvements.

Often other tools have messy data, or data that does not import easily to our system. To keep our data consistent we need to make sure we check the inputs before we accept them.

We would like you to write a basic user import service that, given some input data, can determine which users are importable.

### The rules behind importing a user into Small Improvements are as follows:
1. An email address is required for each user.
1. The email address needs to be unique.
1. An employee number is optional for each user, but if it exists it must be unique.
1. A user's manager is identified by managerEmail. 
⋅⋅* A user is not required to have a manager. 
⋅⋅* The reporting structure is not allowed to be cyclic.

### Your solution should provide:
1. An easy way to programmatically access the importable users.
1. An end-user-readable error messages for the users that can't be imported.

### Non functional requirements are:
1. Given a much larger input set of 2000 users, performance should still be reasonable.
1. The core logic should be well-tested.
1. Clean code.

For the tests  JUnit and Spock are provided.
You may add any libraries or frameworks you like, if you think they would help you create a better solution.

## Project Setup
We use Gradle to configure our projects. You can import this project and its `build.gradle` into IntelliJ IDEA.
If you'd like to use plain gradle you can execute your tests with `./gradlew test`.
You find the users to import inside the ImportUser class.
