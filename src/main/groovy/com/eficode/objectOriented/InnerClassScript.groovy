package com.eficode.objectOriented

/**
 *
 * Conclusions:
 *
 * Inner classes can inherit variables from the outer class
 *      If the variables are non-static they remain unique to that outer class instance and any related existing or new inner class instances
 *
 * Outer/Inner classes are use full when different objects are tightly coupled and need to share certain variables but there is still a need
 * for instances that don't share the variables (ie not global variables for all instances of that class)
 *
 */

import com.eficode.objectOriented.staticAndFinal.OuterClass


OuterClass outerClass1 = new OuterClass()
OuterClass outerClass2 = new OuterClass()

assert outerClass1.innerClassInitial.outputValues() == [innerStatic: "Initial inner static value" , innerString : "Initial inner value", outerString: "Initial outer value" , outerStatic: "Initial outer static value"]
assert outerClass2.innerClassInitial.outputValues() == [innerStatic: "Initial inner static value" , innerString : "Initial inner value", outerString: "Initial outer value" , outerStatic: "Initial outer static value"]


//Updating the outer classes static variable, carries through to any existing and new objects of that class or of the InnerClass type
outerClass1.outerStatic = "Updated by outerClass1"
assert outerClass2.outerStatic == "Updated by outerClass1"
assert outerClass2.innerClassInitial.outputValues().outerStatic == "Updated by outerClass1"
assert new OuterClass.InnerClass(outerClass2).outputValues().outerStatic == "Updated by outerClass1"





//Updating the non-static class variable, only affects that instance of the class, and any InnerClass objects instantiated by that outer instance
outerClass1.outerString = "Updated by outerClass1"
assert outerClass2.outerString == "Initial outer value"
assert outerClass1.innerClassInitial.outputValues().outerString == "Updated by outerClass1"
assert outerClass2.innerClassInitial.outputValues().outerString == "Initial outer value"
assert new OuterClass.InnerClass(outerClass1).outputValues().outerStatic == "Updated by outerClass1"