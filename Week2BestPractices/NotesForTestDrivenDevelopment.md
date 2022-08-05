# What is Test Driven Developement (TDD)

Test Driven Development is an approach to software development in which the unit test are written before the business logic.

1. Do not write any production code without a failing test first.
2. Write only enough test code as is  sufficient enough to fail.
3. Only implement minimal code that makes the failing test pass.

## Why used Test Driven Development (TDD)

1. *"It's testable even before any implementation is written"*
2. *"It promotes clean code and better code design"*
3. *"Less bugs"*
4. *"More documentation"*

## Early issues with Adopting TDD

1. *"It can feel slow"*
2. *"It can feel unnecesary"*


----
1. You can't test static methods, you can call it on another class and then write test for that class. *(Important note: you cannot stub a static method. You can **"WRAP"** it in another method and stub that method.)*
2. You must write tests for methods that have decission making functions.
3. Practiced company format for unit testing (then):
    
    ```
    assert <expected> == <actual>
    ```