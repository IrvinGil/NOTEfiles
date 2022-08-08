# Syntax codes:

## Dependecy code for unit testing with Spock:
Note: You must include these dependencies on the `build.gradle` file of the project.

```
testImplementation 'org.spockframework:spock-core:2.0-groovy-3.0'
testImplementation 'org.codehaus.groovy:groovy-all:3.0.8'
```

----

* Sample test method structure (groovy):
    ```
    def "<methodName : can be string>"{
        when:
        <when s*tatement>

        then:
        <then statement>

        where: 
        <where statement>
    }
    ```

* Another example:
    ```
    def "should expect an error to be thrown for a number of invalid input: #sides"() {
        when:
        int countSides = new Polygon(sides).numberOfSides

        then:
        countSides >= 4

        where:
        sides << [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
    ```
* More examples:

    ```
    def "should demonstrate a simple assertion"() {
        expect:
        1 == 1
    }
    ```
    ```
    // can use just when-then if there's no setup
    def "should demonstrate given-when-then"() {
        given:
        def shape = new Polygon(4)

        when:
        int sides = shape.getNumberOfSides()

        then:
        sides == 4
    }
    ```
    ```
    def "should expect Exceptions"() {
        when:
        new Polygon(0)

        then:
        // no need for .class
        def e = thrown(TooFewSidesException)
        // no need for get
        e.numberOfSides == 0
    }
    ```
    ```
    def "should expect Exceptions for more than one value"() {
        when:
        new Polygon(sides)

        then:
        def e = thrown(TooFewSidesException)
        e.numberOfSides == sides

        where:
        sides << [0, 1, 2]
    }
    ```
    ```

    @Unroll
    def "should demonstrate simple data driven testing. Number of sides: #expected"() {
        expect:
        shape.getNumberOfSides() == expected

        where:
        expected << [3, 4, 5, 8, 14]
        shape = new Polygon(expected)
    }
    ```
    ```

    def "should demonstrate data tables. Max of #a and #b should be #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0
    }
    ```
    ```

    def "should be able to mock a concrete class"() {
        given:
        Renderer renderer = Mock()
        @Subject
        def shape = new Polygon(4, renderer)

        when:
        shape.draw()

        then:
        4 * renderer.drawLine()
    }
    ```
    ```

    def "should be able to use a stub"() {
        given:
        Palette palette = Stub()
        palette.getPrimaryColour() >> Colour.Red
        @Subject
        def renderer = new Renderer(palette)

        expect:
        renderer.getForegroundColour() == Colour.Red
    }
    ```
    ```

    def "should demonstrate helper methods"() {
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def shape = shapeFactory.createDefaultPolygon()

        then:
        checkDefaultShape(shape, renderer)
    }
    ```
    ```

    private static void checkDefaultShape(Polygon shape, Renderer renderer) {
        assert shape.numberOfSides == 4
        assert shape.renderer == renderer
    }
    ```
    ```

    def "should demonstrate 'with'"() {
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def shape = shapeFactory.createDefaultPolygon()

        then:
        with(shape) {
            numberOfSides == 4
            renderer == renderer
        }
    }
    ```
    ```

    def "should demonstrate 'verifyAll'"() {
        given:
        def renderer = Mock(Renderer)
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def shape = shapeFactory.createDefaultPolygon()

        then:
        verifyAll(shape) {
            numberOfSides == 4
            it.renderer == renderer
        }
    }
    ```
    ```

    def "should show specification as documentation"() {
        given: "a palette with red as the primary colour"
        Palette palette = Stub()
        palette.getPrimaryColour() >> Colour.Red

        and: "a renderer initialised with the red palette"
        def renderer = new Renderer(palette)

        expect: "the renderer uses the palette's primary colour as the foreground colour"
        renderer.getForegroundColour() == Colour.Red
    }
    ```
## Mocking syntax examples
In this example, the addresss is mocked so that we can test if the `personRepository.save` is invoked once.
```
def "addPerson should save the new person."() {
        given:
        Address address = Mock()

        when:
        service.addPerson("Kenichi", 32, address, Sex.MALE)

        then:
        1 * personRepository.save(_) >> {Person passedPerson ->
            assert "Kenichi" == passedPerson.name
            assert 32 == passedPerson.age
            assert address == passedPerson.address
            assert Sex.MALE == passedPerson.sex
        }
    }
```


# Spock Unit Test Syntax

## WHEN statement 
is used to call and set the method/function that you want to test
## THEN statement
used to indicate what is to be expected as output (or return) of the function/method
## WHERE statement
is used when there are multiple set values that are input for testing a function/method

-------------------------------------------------------------------


Definitions and explanations:
1. "unit test is usually a mehtod that validates a small portion of the source code"
2. "Comparison of actual and expected results"
3.  Fast - a single project can contain a big number of unit tests, even hundreds or thousands.
4.  Isolated - a unit test shoudn't modify or depend on any external state.
5.  Deterministic - should always return the same result no matter how many times we execute it. Nothing is changed between runs.
6.  Readable- unit test code are that needs to be maintained. Therefore, it should be clear and easily understandable.
7.  Simple - often we can read that the unit test should contain a single assertion. 
8.  Documentation - Well written test work just as well as documentation. They should paint a good picture of what a function does or how it is used.
9. One thing of unit testing is to keep the test **ISOLATED** or class **ISOLATED**



# Commands:
```
sh gradlew test
```




## Company standard for assert code
* In writting code for unit testing (Assert)
    ```
    assert <expected> == <actual>
    ```
* The ones or the authors of the `class, code, methods` is the ones to write the test for them.