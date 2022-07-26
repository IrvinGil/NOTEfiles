# Java Singleton Class
In this tutorial, we will learn to implement Singleton Design Pattern in Java with the help of examples.

In Java, Singleton is a design pattern that ensures that a class can only have one object.

To create a singleton class, a class must implement the following properties:

* Create a private constructor of the class to restrict object creation outside of the class.
* Create a private attribute of the class type that refers to the single object.
* Create a public static method that allows us to create and access the object we created. Inside the method, we will create a condition that restricts us from creating more than one object.
```
//Example: Java Singleton Class Syntax
class SingletonExample {

   // private field that refers to the object
   private static SingletonExample singleObject;
                                              
   private SingletonExample() {
      // constructor of the SingletonExample class
   }

   public static SingletonExample getInstance() {
      // write code that allows us to create only one object
      // access the object as per our need
   }
}
```
In the above example,

* private static SingletonExample singleObject - a reference to the object of the class.

* private SingletonExample() - a private constructor that restricts creating objects outside of the class.

* public static SingletonExample getInstance() - this method returns the reference to the only object of the class. Since the method static, it can be accessed using the class name.
## Use of Singleton in Java
Singletons can be used while working with databases. They can be used to create a connection pool to access the database while reusing the same connection for all the clients. For example,
```
class Database {
   private static Database dbObject;

   private Database() {      
   }

   public static Database getInstance() {

      // create object if it's not already created
      if(dbObject == null) {
         dbObject = new Database();
      }

       // returns the singleton object
       return dbObject;
   }

   public void getConnection() {
       System.out.println("You are now connected to the database.");
   }
}

class Main {
   public static void main(String[] args) {
      Database db1;

      // refers to the only object of Database
      db1= Database.getInstance();
      
      db1.getConnection();
   }
}
```
When we run the program, the output will be:

    You are now connected to the database.
In our above example,

We have created a singleton class Database.
The dbObject is a class type field. This will refer to the object of the class Database.
The private constructor Database() prevents object creation outside of the class.
The static class type method getInstance() returns the instance of the class to the outside world.
In the Main class, we have class type variable db1. We are calling getInstance() using db1 to get the only object of the Database.
The method getConnection() can only be accessed using the object of the Database.
Since the Database can have only one object, all the clients can access the database through a single connection.
Singleton is a design pattern rather than a feature specific to Java. A design pattern is like our code library that includes various coding techniques shared by programmers around the world.

It's important to note that, there are only a few scenarios (like logging) where singletons make sense. We recommend you avoid using singletons completely if you are not sure whether to use them or not. 