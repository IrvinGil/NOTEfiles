# All About @Angular:
- Angular components are reusable.
- You must also to export the compoent on its side to be accessible and reusable throughout the application.
- For research on different validation type search : Angular Validation. (not discussed during graduate program session)
- The @Input() decorator indicates that the property value passes in from the component's parent, ProductListComponent.
- ActivatedRoute is specific to each component that the Angular Router loads. ActivatedRoute contains information about the route and the route's parameters.
By injecting ActivatedRoute, you are configuring the component to use a service. The Managing Data step covers services in more detail.
- Note: if you are using intelliJ as an ide for angular. you also get auto importation when you are instantiating 
and object into your class without importing it.


## Using Angular CLI:
- Creating new application:
```
ng new <app-name>
```
- Running the angular application:
```
ng serve
```
- 

# All About Typescript:
- Typescript is a language that is super set of javascript. Basically all valid typescript is also valid javascript.
- Advantages:
    - Strong typed: variable and object types are highliy specified.
    - Object-oriented features (pretty much just javascript).
    - Compile-time errors: Allows developers to know errors on compile-time unlike javascript that just shows errors on runtime.
    - 
- Difference between `var` and `let`:
    - `var` is made accessible to the nearest function, while:
    - `let` is only made accessible to scope of the codeblock where it is decalared.    
- ''_false or anything that javascript evaluate as empty is considered null.

## Typescript Terminal commands:
- Viewing typescript version:
```
tsc --version
```




## Topics that we have discussed:
1. Routing
2. Exporting components
3. Binding and NgModel (ngModel - two way binding)
4. **Directives**:
    - ngIf
    - ngFor
    - ngSwitch
    - ngClass: injects css class into html element and lets you switch the classes of the html element.
    - ngStyle: injects explicit declaration of the style.
    - Custom directives
5. Forms:
    - subscribable.
6. Asynchronous functions:
---

## **Angular Routing**:
1. To use components, you must also import them on the routing.ts 
2. Use of *routes is to assign a page to a specific url. And *routes are structures like an array and can have multiple paths leading to their own components.
3. Routes must have a unique path or else it will conflict.
4. For routing, we must use the selector router outlet.
5. Best practice in angular is that every page must be routed. And their routing is configured on their own routing module under the same directory as the component.


## **Binding (Property and Event Binding), Interpolation**:

- Property binding [] lets you use the property value in a template expression
- "[]" means input and "()" means output.
    - [] is property binding: and it is used to send values from the component into the view/HTML. (component => HTML)
    - () is event binding: and it is used to send values from the view/HTML into the component. (component <= HTML)
- Interpolation {{ }} lets you render the property value as text.
- adding the $ symbol ahead of an expression makes angular evaluate it first.


### **Subscribable**:
- subscribable accepts 3 arguments:
    - on success
    - on error
    - on complete

## **Promise and Subscribable**:
- **Promise**:
    * Promises are one way used in dealing with asynchronous functions in javascript.
    * the response to the promise is called the resolve.
    * return one action (resolve/reject).
- **Observable**:
    * observable can return multiple values whereas promise can only return one.
    * observable behave like arrays; 
    * Observable : an observable is a producer of multiple values "pushing" them to observers (consumers).
        - subscription in an observable will last until you tell it to "unsubscribe".
        - SUBJECT: another type of observable that allows values to be multicasted to many observers.

> note: use a subject when you have multiple observables and you want updates as they come.

> note: use a behavior-subject when you have multiple observers and you want the latest updates
as soon as they subscribe.

### Application of observable and promise:
- application for promise:
    - deals with asynchronous functions.
    - if you want a function to do something and you dont want to be stuck on one action.
    - sample of this is loading a page that waits for the response of an API.

## **Notes in using ngClass**:
note:
- another way of using terniary operators in using ngClass;
```HTML
<!--<div class="download"
[ngClass]="{'downloading':downloadStatus ==1,'downloaded'}"></div>-->

<div class="download"
[ngClass]="downloadStatus ==1?'downloading':
downloadStatus ==2?'downloaded': '' "></div>
```