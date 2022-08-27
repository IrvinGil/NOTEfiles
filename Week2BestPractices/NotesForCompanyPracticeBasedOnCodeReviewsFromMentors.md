# This are notes from code reviews and pull request reviews: 
> All this are comming from senior mentors/engineers.

* Methods/functions that are not used outside the package should have `protected` access modifier for encapsulation.
* Do not use inheritance just to reuse methods. This might lead to tight coupling between your classes.
* Do not add `@setter` on fields that should not be modifier by the user (example: userId, id).
* Identify what type of exception we are anticipating when creating a function. And do not just put exceptionTypes that do not makes sense to be thrown. 
* As you can reuse web exception handling functions and just change the response code and message: keep in mind to use minimal objects in your program and only create new objects when it is of different type and use case.
* Best practice is to set field into private and use @Getter to access these values, this also falls under encapsulation practice.
* It's not good practice to have a field in the service if it makes the service "stateful".  Our services should be "stateless". This means that services should not contain/retain any values. The reason why we avoid states in the service is because it can cause concurrency issues.
* We don't add unit tests for private methods. The smallest unit that we test are the methods/functions that are exposed for other classes to call. Exposed => `public` & `protected`.
* We usually have variable declarations at the start of the test class. This is more of a standard for the team. This best practice applies for all types of class/codes (.java, .groovy, .ts etc.).
