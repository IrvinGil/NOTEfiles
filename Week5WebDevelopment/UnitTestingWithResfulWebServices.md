# Unit Testring with Restful Web Services

- This is a Sample spock-groovy spec class. Important note for this though is that you can create a `void setup()` for creating the neccessary object for testing on the `spec.class`.

```groovy
package com.synacy.graduateprogramexercise.ordermanagement.product

import spock.lang.Specification

class ProductServiceSpec extends Specification {

    ProductService productService

    Product product1 = Mock()
    Product product2 = Mock()
    Product product3 = Mock()

    void setup() {
        product1.getId() >> 1L
        product2.getId() >> 2L
        product3.getId() >> 3L
        List<Product> productList = [product1, product2, product3]
        productService = new ProductService(productList)
    }

    def "fetchProductById should return the product with the specified id"() {
        given:
        Long productId = 1L

        when:
        Optional<Product> optionalProduct = productService.fetchProductById(productId)

        then:
        optionalProduct.isPresent()
        1L == optionalProduct.get().getId()
        product1 == optionalProduct.get()
    }
}

```