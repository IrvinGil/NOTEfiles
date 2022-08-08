# Spring and Spring boot

1. Spring and Spring boot are both application frameworks.
    - An application framework is a software library that provides a fundamental structure to support the development of applications for a specific environment. An application framework acts as the skeletal support to build an application. The intention of designing application frameworks is to lessen the general issues faced during the development of applications. This is achieved through the use of code that can be shared across different modules of an application. Application frameworks are used not only in the graphical user interface (GUI) development, but also in other areas like web-based applications.
    - Application frameworks helps developers simplify works and writting biolerplate codes.
2. Spring is the core technology used by spring boot. The difference is that spring is more flexible that Spring Boot, with Spring being the native framework.

3. Spring Features:
    - Light weight
    - Aspect Oriented Programming
    - Transaction Management
    - Container
    - Dependency injection (Great support)

4. Spring Container:
    - BeanFactory
    - ApplicationContext

5. Where to put resource files:
    - Front end (html, css, javascript) -> /resource/static
    - resources (images) -> /resource/static

6. Note that the Service in MVC holds the business rule codes.
7. Dealing with the ~/.bashrc:
    ```
    //in the terminal
    sudo gedit ~/.bashrc
    ```
    ---
    ```
    //then, edit the bashrc and then save
    export FIRST_NAME="Irvin Gil" //enclose in quotes if the value has space
    ```
    ---
    ```
    //then in the terminal, route bashrc as the source
    source ~/.bashrc
    ```
    ---
    ```
    //then echo the valueHolder in the terminal 
    echo $FIRST_NAME
    ```
    ---
    ```
    //finaly, run the application
    sh ./gradlew bootRun
    ```