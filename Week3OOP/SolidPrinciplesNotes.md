# SOLID PRINCIPLES 
## Object Oriented SOLID Design Principles
1. **Single Responsibility Principle** 
    * *"A class should have only one reason to change"* -Uncle Bob (Bob Martin)
    * Trying to have high cohesion on a class. The idea is to try and narrow down the behavior a class can have and motivation to re write it.
    
        <img src="/home/irvin_gil/Documents/NOTEfiles/Week3OOP/MarkDownImageSource/Screenshot from 2022-07-27 07-51-39.png" alt="Single Responsibility Principle Concept" style="height: 400px; width:800px;"/>

    ------
2. **Open/Closed Principle** 
    * *"A class should be open for extension, but closed for modification"*.
    * Promotes re-utilization
    * When you split the responsibility of a class, you should do so in a way that behavior can be extended/replaced.

         <img src="/home/irvin_gil/Documents/NOTEfiles/Week3OOP/MarkDownImageSource/Screenshot from 2022-07-27 07-54-54.png" alt="Open/Close Principle Concept" style="height: 400px; width:800px;"/>
    ------
3. **Liskov Substitution Principle**
    * *"You should be able to change an instance using a sub-type and your code should still still work"*
    * *"Subtypes must be substitutable for their base types"*
    * Only use inheritance when the super class is replaceable by a subclass in all the instances. Don't use inheritance just to save a few lines  of code.

    
        <img src="/home/irvin_gil/Documents/NOTEfiles/Week3OOP/MarkDownImageSource/Screenshot from 2022-07-27 08-04-21.png" alt="Liskov Principle Concept" style="height: 400px; width:800px;"/>
    ------
4. **Interface Segragation Principle**
    * More interfaces are better than too little.
    * Allows to split the responsibility of a class without LSP violation.
    * *"Is a solution to the violation of the LISKOV SUBSTITUTION PRINCIPLE"*
    * The dependency of one class  to another should depend on the **smallest** possible interface.
        - Clients should not be forced to implement interfaces they don't use.
        - Instead of one fat interface, many small interfaces are preferred based on groups of methods, each one serving one submodule.

        ```
        public interface Animal{
            void feed(); //abstract
        }

        Pet implements Animal{
            void groom(); //abstract
        }

        Dog implements Pet{
            void feed(); //implementation
            void groom(); //implementation
        }

        Tiger implements Animal{
            void feed(); //implementation
        }

        ```
    

        <img src="/home/irvin_gil/Documents/NOTEfiles/Week3OOP/MarkDownImageSource/Screenshot from 2022-07-27 08-09-01.png" alt="Interface Segregation Concept" style="height: 400px; width:800px;"/>
    ------
5. **Dependency Inversion**
    * *"One should depend on abstraction and not concrete instances"*

         <img src="/home/irvin_gil/Documents/NOTEfiles/Week3OOP/MarkDownImageSource/Screenshot from 2022-07-27 08-11-24.png" alt="Interface Segregation Concept" style="height: 400px; width:800px;"/>


## Useful java concepts and approaches for SOLID PRINCIPLE
* Single Responsibility Principle
    - Making methods that only has one function, therefore being only responsible to one process.

* Open/Closed Principle
    - Application of Abstract Classes
    - 


* Liskov Substitution Principle


* Interface Segragation Priciple


* Dependency Inversion Princple