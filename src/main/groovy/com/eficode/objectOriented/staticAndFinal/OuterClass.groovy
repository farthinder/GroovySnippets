package com.eficode.objectOriented.staticAndFinal

class OuterClass {

    static String outerStatic = "Initial outer static value"
    String outerString = "Initial outer value"

    InnerClass innerClassInitial = new InnerClass()



    class InnerClass {

        static String innerStatic = "Initial inner static value"
        String innerString = "Initial inner value"


        Map<String, String> outputValues() {


            return [innerStatic: innerStatic, innerString : innerString, outerString: outerString , outerStatic: outerStatic]
        }

    }

}
