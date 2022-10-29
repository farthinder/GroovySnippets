package com.eficode.objectOriented.childParentClass

Parent parent = new Parent()
Child child = new Child()

//These variables get set on instantiation only by parent
assert parent.parentVariable == child.parentVariable
assert parent.parentStaticVariable == child.parentStaticVariable


//These variables get set to different values by both classes on instantiation
assert parent.sharedVariable != child.sharedVariable


//Updating the parents static field, also updates the child static field
parent.parentStaticVariable = "Updated by parent"
assert child.parentStaticVariable == "Updated by parent"

//And vice versa
child.parentStaticVariable = "Updated by child"
assert parent.parentStaticVariable == "Updated by child"


//A child may override a parent method
assert parent.presentMySelf() == "This is Parent"
assert child.presentMySelf() == "This is Child"



assert parent.family == "Parent"
assert child.family == "Parent & Child"