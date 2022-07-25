# Notes during discussion with @Froi

# Date: July 25, 2022

## Programming principles:
1. YAGNI - "You Aren't Gonna Need It"
2. KISS - "Keep It Simple Stupid"
3. "Ask, Don't Tell"
4. DRY - "Don't Repeat Yourself"

## Programming terms and concepts:
1. Coupling - "dependency of class to each other" || "Coupling is nothing but the dependency of one class on the other. If one object in a code uses the other object in the program, it is called loose coupling in Java. In coupling, two classes or objects collaborate and work with each other to complete a pre-defined task"

2. Cohesion - "keeping related things close together" || "Cohesion is closely related to ensuring that the purpose for which a class is getting created in Java is well-focused and single. In other words, the more closely related stuff is grouped in a class, the higher will be the cohesiveness."

3. 



## Tips and practice for IDEAL CODE:
1. "Code should have HIGH COHESION and LESS COUPLING" - DRY means having a single authoritative source of truth.

    The cost for DRY is "COUPLING" -> use DELEGATION APPROACH
    "The more DRY you are, the more you are highly COUPLED"
    To avoid more coupling, use: "COMPOSITION APPROACH"

2. "Implementation Inheritance is bad" || "Interface inheritance is good"
3. "Interface is a contract" 
4. RED > GREEN > REFACTOR (TDD related approach)
5. Dependency Injection:
    * Adds more FLEXIBILITY to the code.
    * Increases code complexity.
6. Law of DEMETER - principle of least knowledge || "You don't know the internal parts"

## Composition in Java:
The composition is a design technique in java to implement a has-a relationship. Java Inheritance is used for code reuse purposes and the same we can do by using composition. The composition is achieved by using an instance variable that refers to other objects. If an object contains the other object and the contained object cannot exist without the existence of that object, then it is called composition. In more specific words composition is a way of describing reference between two or more classes using instance variable and an instance should be created before it is used. 


# IntelliJ IDEA shortcut keys and tips:
1. ctrl + D = duplicate
2. ctrl + Y = delete line
3. @Deprecated - anotation that warns the coder that a block of code has already been deprecated
4. 