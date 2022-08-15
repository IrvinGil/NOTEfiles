# Restful Web Services
- **REST** means "REpresentational State Transfer".
- **Web service** connects and allow integration with existing web applications much like a library
- In a REST API request, a JSON is returned as the response from the server.
- Content type of restful web services:
    * JSON
    * XML
- The content type in SOAP is strictly XML. If one thing is not properly defined, then the application would not run. (SOAP) Pretty much stricter than REST.
- Compared to soap, rest is not strict and is more of a guideline. Rest has best practices.
- **Endpoint** is a function that can be used by the consumer (of the API).
- "Resource means the objects being exposed"
---

### Uniform Resource Identifier (URI)
- Every source is identified by a unique identifier (URI).
- 
    + REST is very resource oriented. focused on object instead of action.
    + Best practice is to use nouns in Restful. 
        - ```/profile/{profileId}``` instead of   ```/getProfile?id=1```
        ```/profile/{profileId}``` instead of ```/deactivateProfile```
        - //ways to distinguish the command is through http methods (get, post, put, delete).

    + best practice is to use version:
        `/api/v1/profile/{profileId}`

- sample of resource URI's:
    + /api/v1/student/{student}
    + /api/v1/grade/{gradeId}   ||  /api/v1/student/{student}/grade/{gradeId}
    
- Filtering Collections:
    + Use Pagination:
        `/api/v1/student?page=1&max=10`
    + Use resource fields:
        `/api/v1/student?yearLevel=3`  (in this example, querry parameter is used to filter out the data being responded to the client).
---
## Common HTTP methods:
- GET 
- POST 
- PUT (update; primarily used for updating resources)
- DELETE
- PATCH (more of like PUT) but the difference is in patch you only indicate the field that you will change. And also patch is considered **not safe** and somehow considered **non-idempotent**.
---
### Idempotent
- denoting -an element of a set which is unchanged in value when multiplied or otherwise operated on by itself.

"The purpose of addpath is to add a pathel (path element) to a pathvar (path variable) in an idempotent fashion."

- kung mangyayari sya, safe ba sya? or hindi ba ito makaka affect kahit ilang ulit ito ginagawa (invoked).

| Idempotent Methods  | Non-idempotent Methods  |
|---|---|
|  GET |  POST |
|  DELETE |   |
|  PUT |   |

---
### HTTP Status Codes: 
**1XX - Informational**
| 2XX  |  Success |
|---|---|
|  200 |  Ok |
|  201 |  Created |
|  202 | Accepted  |
|  204 | No Content  |

|3XX | Redirect |
|---|---|
| 301 | Moved Permanently|

|4XX | Client Error|
|---|---|
| 400 | Bad Request |
| 401 | Unauthorized|
| 403 | Forbidden|
| 404 | Not Found |
| 422 | Unprocessable Entity |

| 5XX | Server Error |
|---|---|
| 500 | Internal Server Error |

----
## Best Practices in Designing Restful API's
1. Use **pagination** >> when it come's to list's and requesting (GET) json with many data contents. This is to control and prevent loading too much data streams on a page at a time.
2. Be consistent on the API design (ex. use "product" and not "products" and impose this throughout the design).
3. The company practice in designing Restful APIs is to use nouns and singular words (not plural).


## Sample Restful API designs (frm. mentor):
```URI
/api/v1/order?dateOrdered={date}&max=5
```
This will load the following fields:
- dateOrdered
- max
- page

```URI
/api/v1/order?dateOrdered={date}&max=5&page=1
```
---
## Useful dependecies for spring boot web project:
1. **#Lombok**: dependency used to simplify the use of ***getters and setters***.
```build.gradle
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
```
2. **Guava Core Libraries for Java:** Guava is a set of core Java libraries from Google that includes new collection types (such as multimap and multiset), immutable collections, a graph library, and utilities for concurrency, I/O, hashing, caching, primitives, strings, and more! It is widely used on most Java projects within Google, and widely used by many other companies as well.

```build.gradle
implementation 'com.google.guava:guava:31.1-jre'
```
