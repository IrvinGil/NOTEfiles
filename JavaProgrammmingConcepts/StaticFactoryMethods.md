# Main point/idea: *"It is better to use **Static Factory Methods** than conventional constructor"*
# Difference Between Constructor and Static Factory Method in Java
Whenever we are creating an object some piece of code will be executed to perform initialization of that object. This piece of code is nothing but a constructor, hence the main purpose of the constructor is to perform initialization of an object but not to create an object. Let us go through the basic set of rules for writing a constructor. They are as follows:

1. The name of the class and the name of the constructor must be the same.
2. Return type concept is not applicable for constructor even void also. By mistake, if we are trying to declare return type for the constructor then we won’t get a compile-time error because the compiler treats it as a method.
3. The only applicable modifiers for the constructor are public, private, protected, and default. If we are trying to use any other modifier we will get a compile-time error saying modifier name_of_modifier Not allowed here.

## Default Constructor 
A compiler is responsible to generate the default constructor but not JVM. If we are not writing any constructor then only the compiler will generate the default constructor i.e if we are writing at least one constructor hence every class in java can contain a constructor it may be a default constructor generated by a compiler or customize constructor explicitly provided by the programmer but not both simultaneously.

The prototype of the default constructor is as follows:

* It is always a no-arg constructor
* The access modifier of the default constructor is exactly the same as the access modifier of the class
* It contains only one line super() it is a no-argument call to the superclass constructor.

## Static Factory Methods
By using a class name if we are calling a method and if that method returns the same class object then such type of method is called static factory method. The static factory methods are methods that return an instance of the native class. The static factory method has names that clarify the code, unlike the constructors. In the static factory method, we do not need to create a new object upon each invocation i.e object can be cached and reused if required. We can also return the subtype of their return type. 

*The first line inside every constructor should be either super() or this() and if we are not writing anything then the compiler will always place super()*

```
// Java Program to showcase Difference Between
// Constructor and Static Factory method

// Importing all utility classes from
// java.util package
// Importing all input output classes

import java.io.*;
import java.util.*;

// Main class
// To find out complex number

public final class GFG {

	// Method 1
	// Static factory method returns an object of this
	// class.
	public static GFG valueOf(float real, float imaginary)
	{
		return new GFG(real, imaginary);
	}

	// Caller cannot see this private constructor.The only
	// way to build a GFG is by calling the static factory
	// method.

	// Constructor
	private GFG(float real, float imaginary)
	{

		// This keyword refers to current object itself
		this.real = real;
		this.imaginary = imaginary;
	}

	private float real;
	private float imaginary;

	// Method 2
	// Main driver method
	public static void main(String[] args)
	{
		// Creating an object of GFG and
		// calling an static factory method valueOf()
		GFG n = GFG.valueOf(2, 4);

		// Print and display the complex number
		System.out.println(n.real + "+" + n.imaginary
						+ "i");
	}
}

```

# Custom Static Factory Methods
Of course, we can implement our own static factory methods. But when is it really worth doing so, instead of creating class instances via plain constructors?

Let's see a simple example.

Let's consider this naive User class:

```public class User {
    
    private final String name;
    private final String email;
    private final String country;
    
    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }
    
    // standard getters / toString
}
```

In this case, there're no visible warnings to indicate that a static factory method could be better than the standard constructor.

What if we want that all the User instances get a default value for the country field?

If we initialize the field with a default value, we'd have to refactor the constructor too, hence making the design more rigid.

We can use a static factory method instead:
```
public static User createWithDefaultCountry(String name, String email) {
    return new User(name, email, "Argentina");
}
```
Here's how we'd get a User instance with a default value assigned to the country field:
```
User user = User.createWithDefaultCountry("John", "john@domain.com");
```


## Moving Logic out of Constructors
Our User class could quickly rot into a flawed design if we decide to implement features that would require adding further logic to the constructor (alarm bells should be sounding off by this time).

Let's suppose that we want to provide the class with the ability for logging the time at which every User object is created.

If we just put this logic into the constructor, we'd be breaking the Single Responsibility Principle. We would end up with a monolithic constructor that does a lot more than initialize fields.

We can keep our design clean with a static factory method:
```
public class User {
    
    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private final String name;
    private final String email;
    private final String country;
    
    // standard constructors / getters
    
    public static User createWithLoggedInstantiationTime(
      String name, String email, String country) {
        LOGGER.log(Level.INFO, "Creating User instance at : {0}", LocalTime.now());
        return new User(name, email, country);
    }
}
```
Here's how we'd create our improved User instance:
```
User user 
  = User.createWithLoggedInstantiationTime("John", "john@domain.com", "Argentina");
```
## Instance-Controlled Instantiation
As shown above, we can encapsulate chunks of logic into static factory methods before returning fully-initialized User objects. And we can do this without polluting the constructor with the responsibility of performing multiple, unrelated tasks.

For instance, suppose we want to make our User class a Singleton. We can achieve this by implementing an instance-controlled static factory method:

```
public class User {
    
    private static volatile User instance = null;
    
    // other fields / standard constructors / getters
    
    public static User getSingletonInstance(String name, String email, String country) {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new User(name, email, country);
                }
            }
        }
        return instance;
    }
}
```
The implementation of the getSingletonInstance() method is thread-safe, with a small performance penalty, due to the synchronized block.

In this case, we used lazy initialization to demonstrate the implementation of an instance-controlled static factory method.

It's worth mentioning, however, that the best way to implement a Singleton is with a Java enum type, as it's both serialization-safe and thread-safe. For the full details on how to implement Singletons using different approaches, please check this article.

As expected, getting a User object with this method looks very similar to the previous examples:

```
User user = User.getSingletonInstance("John", "john@domain.com", "Argentina");
```