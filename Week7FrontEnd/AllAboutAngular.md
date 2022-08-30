## **Passing data between component:**

### Case: Passing data from parent_component into child_component.
**Using: @Input decorator**

In the child-component.ts:
```Typescript
import { Component , OnInit , Input ) from @ angular / core ' ;
@Component ( {
  selector : ' app - child ' ,
 templateUrl : ' ./child.component.html ' ,
  styleUrls : [ ./child.component.css ' ]
} )
export class ChildComponent implements OnInit
    @Input ( ) data : string   //this is the variable that will hold the value being passed from the parent component
    constructor ( ) { }
    ngOnInit ( ) : void {
    }
}
```
In the HTML of the child-compoent.ts:
```HTML
<div> <br>
     <h1 class = " header " > CHILD COMPONENT </h1 >
</div>
<div class = " para " >
Parent Says ( data ) )
</div>
```

In the parent component: (app-component.ts):
```Typescript
import { Component } from @ angular / core ' ;

@Component ( {
  selector : ' app - root ' ,
  templateUrl : ../app.component.html ' ,
  styleUrls : [ ./app.component.css ' ]
} )
export class AppComponent
  message = " Welcome to THE GOOD CODE "

```



In the HTML of the parent component: (app-component.html):
```HTML
<div class = " parent " >
<h1 class=" header "> PARENT COMPONENT </h1>
<h3 class=" para "> | </h3>
<div class=" c1 ">
    // here we see that we binded the data from the child-component into the message variable of the parent-component.
    <app-child [data]="message"></app-child>
</div>
<div class=" c2 ">
    <app-child2></app-child2>
</div>
</div>
```


### Case: Passing data from child_component into parent_component.
**Using: @Output decorator & EventEmitter**