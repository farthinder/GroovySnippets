package com.eficode.objectOriented.childParentClass

class Child extends  Parent{


    String sharedVariable = "sharedVariable updated by child on instantiation"


    @Override
    String getMyName() {

        return "Child"
    }

    @Override
    String getFamily() {

        return super.getFamily() + " & Child"
    }




}
