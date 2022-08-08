# Java Programming Bes Practices
1. Consider Static Factory methods instead of constructors.
    * One advantage of static factor is that, unlike constructors, they have names.
    * A second advantage of static factory method is that, unlike constructors, they
        are not required to create a new object each time they are invoked.
    * Third advante of static factory methods is that, unlike constructors, they can 
        return an object of any subtype of their return type.
    * A fourth advantage if static factory method is that the class of the returned
        object can vary from call to call as a function of the input parameters.
    * Fifth advantage of static factory methods is that the class of the returned object
        need not to exist when the class containing the method is written.
2. Consider a builder when faced with many constructor parameters.
3. Enforce the singleton property with a private constructor or an enum type.
4. Enforce noninstiability with a private constructor.
5. Prefer dependency injection to hardwirring resources
6. Avoid creating unnecessary objects.
7. When choosing a version, safe to do is to use the version one level below because it is more stable.