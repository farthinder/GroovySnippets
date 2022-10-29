package com.eficode.objectOriented.childParentClass

class Parent {

    String parentVariable = "parentVariable initial value "
    static String parentStaticVariable = "parentStaticVariable initial value"

    String sharedVariable = "sharedVariable initial value"


    String getMyName() {

        return "Parent"
    }

    String presentMySelf() {

        return "This is $myName"

    }

    String getFamily() {

        return "Parent" //This cannot be this.myName or similar, then Child.getFamily() will return Child & Child

    }


}
