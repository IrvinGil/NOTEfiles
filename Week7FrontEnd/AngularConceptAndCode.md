# Angular concepts and code:

## Passing data from non heirarchap components: (sibling -> sibling)
- This makes use of a service to house certain fields of values and the components just set and get the values from the service.

1. Create a service in the component with: `ng generate service <service_name>`.
2. Create fields and methods in the service-component to act as storage values of the information to be passed between components.

> This is in the service file:
```Typescript
import { Injectable } from ' @ angular / core ' ;
@Injectable ( {
    providedIn : ' root '
} )
export class Shared Service {

    message : string

    constructor ( ) { }

    setMessage ( data ) {
        this.message = data
    }
 
    getMessage (){
        return this.message;
    }
}
                             
```

> In the first component:

Note: You have to import the service in here to be able to utilize in the class.

```Typescript
import { Component , OnInit } from @ angular / core ' ;
import {SharedService}" ../shared/shared.service "

@Component ( {
  selector : ' app - child ' ,
  templateUrl : ' ./child.component.html ' ,
  styleUrls : [ ./child.component.css ' ]
} )
export class ChildComponent implements OnInit {

    constructor (private shared : Shared Service ) { }

    message = " Hey ! I am child 1 "

    ngOnInit ( ) : void {
        // this sets the field value in the service 
    this.shared.setMessage ( this.message );
    }
 }

```

> In the second component (target_component):
```Typescript
import { Component , OnInit } from @ angular / core ' ;
import { Shared Service } from " ../shared/shared.service "
@Component ( {
  selector : ' app - child2 ' ,
 templateUrl : ' ./child2.component.html ' ,
 styleUrls : [ ./child2.component.css ' ]
} )

export class Child2Component implements OnInit {

 message : string  //this variable is used to house the value that is fetched from the service.

 constructor ( private shared : Shared Service ) { }

 ngOnInit ( ) : void
    this.message = this.shared.getMessage ( );
 } I


```
---
## Utilizing *ngIf directive:

1. Example 1: Displaying HTML element according to a reference boolean variable in the .ts class. The output of this is that the `h2` element will be visible if `displayName = true` and not if `false`. 

```Typescript
import { Component , OnInit } from ' @ angular / core ' ;
@Component ( {
  selector : ' app - test ' ,
 template :
    < h2 * ngIf = " displayName " >
      Codevolution
    < / h2 >
  styles : [ ]
} )
export class TestComponent implements OnInit {
 displayName = true ;
  constructor ( ) { }
 
 ngOnInit ( ) {

 }

}
```
2. Using **ng-template** to display other element other element instead:

```Typescript
import { Component , OnInit } from ' @ angular / core ' ;
@Component ( {
  selector : ' app - test ' ,
 template :
    < h2 * ngIf = " displayName "; else elseBlock >
      Codevolution
    < / h2 >


    // angular calls this template when displayName is false
    <ng-template #elseBlock>
        <h2>
        Name is hidden
        </h2>
    </ng-template>

  styles : [ ]
} )
export class TestComponent implements OnInit {
 displayName = true ;
  constructor ( ) { }
 
 ngOnInit ( ) {

 }

}
```

3. Using `else` and `then` with `ngIf`:
> The `ngIf` statement is read as: If `displayName = true` then display #thenBlock template. If false then display #elseBlock template.

```Typescript
import { Component , OnInit } from ' @ angular / core ' ;
@Component ( {
  selector : ' app - test ' ,
 template : '
    <h2 * ngIf = " displayName "; then thenBlock; else elseBlock >
      Codevolution
    </h2 >


    // angular calls this template when displayName is false
    <ng-template #thenBlock>
        <h2>
        This is ThenBlock
        </h2>
    </ng-template>

     <ng-template #elseBlock>
        <h2>
        This is ElseBlock
        </h2>
    </ng-template>


  styles : [ ]

  '
} )
export class TestComponent implements OnInit {
 displayName = true ;
  constructor ( ) { }
 
 ngOnInit ( ) {

 }

}
```

---

## Using the select element:
**Contents:**
1. Binding data to dropdown.
2. Setting default value.
3. Fetching Selected value.
4. Call a custom function on change event of dropdown.

>Note: When using `ngModel`, we must first import the `FormsModule` on the app-module.



In the `app-component.ts`:

```Typescript
import { Component, OnInit} from '@angular/core' ;
import {Employee} from './employee';

@Component({
  selector: ' my - app ',
  template: '

        <div style = "margin : auto ; width : 50 % ; border : 3px solid green ; padding : 10px ;">
            <select [(ngModel)]="empSelected" (ngModelChange)='onEmployeeSelected($event)'>
                < option *ngFor="let emp of employee" [value]="emp.Id">
                {{emp.Name}}
                < / option >
            </select>
            <br>

            selected value is {{empSelected}} <br>
            {{modifiedText}}
        </div>


 '
})
export class AppComponent implements OnInit {
    employee: Employee[];
    empSelected: Number;

    modifiedText:string;


    ngOnInit(){
        this.employee = [
            {Id: 1, Name: "Alex"},
            {Id: 2, Name: "Gerald"},
            {Id: 3, Name: "Noir"},
            {Id: 3, Name: "Jay"}

        ];

        //setting default selected value
        this.empSelected = 4;
    }

    onEmployeeSelected(val:any){
        // this can be a web API in some use casses.
        this.customFunction(val);

    }

    customFunction(val:any){
        this.modifiedText = "The value " + val + " was selected from the dropdown";

    }


}

```
Then create a employee class in the same directory using: `ng generate class employee`.

```Typescript
export class Employee
{
    public Id: number;
    public Name: string;

}
```

