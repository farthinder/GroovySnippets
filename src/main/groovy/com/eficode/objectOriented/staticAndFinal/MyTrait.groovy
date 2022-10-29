package com.eficode.objectOriented.staticAndFinal


import org.slf4j.Logger
import org.slf4j.LoggerFactory

trait MyTrait {

    Logger log = LoggerFactory.getLogger(this.class)

    static String staticTraitValue = "Created in trait as static"
    final String finalTraitValue = "Create in trait as final"
    static final  String staticFinalTraitValue = "Create in trait as static and final"

    String traitValue = "A normal trait field"


    static public Map getValuesUsingStaticTraitMethod() {

        return [staticTraitValue: staticTraitValue, staticFinalTraitValue:staticFinalTraitValue]

    }


}
