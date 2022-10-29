package com.eficode.objectOriented.staticAndFinal

class Implementation1 implements MyTrait {


    static String implValue = "Original impl value"


    Implementation1() {


    }

    static Map getValuesUsingStaticImplMethod() {


        return [
                staticTraitValue     : staticTraitValue,
                staticFinalTraitValue: staticFinalTraitValue
        ]


    }


}
