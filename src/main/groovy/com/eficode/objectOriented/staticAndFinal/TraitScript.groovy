package com.eficode.objectOriented.staticAndFinal

import groovy.test.GroovyAssert


/**
 * Conclusions:
 *
 * A 'final' variable is read only
 *
 * A 'static' variable implemented in a class is a single instance shared by all objects of that class
 *
 *      ClassA: Static var
 *
 *          ObjectA1.var == ObjectA2.var
 *
 *
 *          Object1.var = "123"
 *          ObjectA1.var == ObjectA2.var
 *
 *
 * A 'static' variable implemented in a trait, is a single instance shared by all objects of one implementing class:
 *      Trait: Static var
 *          Impl1Class (Class)
 *              Impl1 (Object)
 *              Impl1v2 (Object)
 *                  Impl1.var == Impl1v2.var
 *
 *          Impl2Class (Class)
 *              Impl2 (Object)
 *
 *              Impl1 != Impl2 && Impl1v2 != Impl2
 *
 *  Extending classes does not alter these behaviours.
 */

Implementation1 imp1 = new Implementation1()
Implementation1 imp1v2 = new Implementation1()
Implementation2 imp2 = new Implementation2()
Extension3 ext3 = new Extension3()

//All trait fields are the same to begin with
assert [imp1.staticTraitValue, imp1v2.staticTraitValue, imp2.staticTraitValue, ext3.staticTraitValue].every { it == "Created in trait as static" }
assert [imp1.finalTraitValue, imp1v2.finalTraitValue, imp2.finalTraitValue, ext3.finalTraitValue].every { it == "Create in trait as final" }
assert [imp1.staticFinalTraitValue, imp1v2.staticFinalTraitValue, imp2.staticFinalTraitValue, ext3.staticFinalTraitValue].every { it == "Create in trait as static and final" }
assert [imp1.traitValue, imp1v2.traitValue, imp2.traitValue, ext3.traitValue].every { it == "A normal trait field" }


/**
 * Updating a static trait field of an implementing class, only affects objects of that type/class not other implementing classes
 */
imp1.staticTraitValue = "Updated static value"
assert [imp1.staticTraitValue, imp1v2.staticTraitValue, ext3.staticTraitValue].every { it == "Updated static value" }
assert imp2.staticTraitValue == "Created in trait as static"


imp1.implValue = "An updated impl value"
assert [imp1.implValue, imp1v2.implValue, ext3.implValue].every { it == "An updated impl value" }


/**
 * Updating a normal field of an implementing class, only affects that single object
 */
imp1.traitValue = "Updated normal value"
assert imp1.traitValue == "Updated normal value"
assert [imp2.traitValue, imp1v2.traitValue, ext3.traitValue].every { it == "A normal trait field" }


/**
 * Updating the final variables should thrown an error
 */
GroovyAssert.shouldFail(ReadOnlyPropertyException, { imp1.finalTraitValue = "Updated" })
GroovyAssert.shouldFail(ReadOnlyPropertyException, { imp1.staticFinalTraitValue = "Updated" })


/**
 * Reading the static fields using:
 *      Trait method
 *      Implementing class method from several objects of the same class
 *      Direct field access from objects of the same class
 *
 *
 *  All returns the same result
 *
 */
assert [
        imp1.getValuesUsingStaticTraitMethod(),
        imp1.getValuesUsingStaticImplMethod(),
        imp1v2.getValuesUsingStaticTraitMethod(),
        imp1v2.getValuesUsingStaticImplMethod(),
        Implementation1.getValuesUsingStaticImplMethod(),
        Implementation1.getValuesUsingStaticTraitMethod(),
        Extension3.getValuesUsingStaticImplMethod(),
        Extension3.getValuesUsingStaticTraitMethod(),
        ["staticTraitValue": imp1v2.staticTraitValue, "staticFinalTraitValue": imp1v2.staticFinalTraitValue],
        ["staticTraitValue": imp1.staticTraitValue, "staticFinalTraitValue": imp1.staticFinalTraitValue]
].every {
    it == [
            "staticTraitValue"     : "Updated static value",
            "staticFinalTraitValue": "Create in trait as static and final"
    ]
}

