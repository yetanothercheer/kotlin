// !DIAGNOSTICS: -UNUSED_VARIABLE

external val x: dynamic

var y: Any? <!DEBUG_INFO_DYNAMIC, DEBUG_INFO_DYNAMIC, DEBUG_INFO_DYNAMIC!>by <!PROPERTY_DELEGATION_BY_DYNAMIC!>x<!><!>

fun foo() {
    val a: Any by <!PROPERTY_DELEGATION_BY_DYNAMIC!>x<!>
}

class C {
    val a: dynamic <!DEBUG_INFO_DYNAMIC, DEBUG_INFO_DYNAMIC!>by <!PROPERTY_DELEGATION_BY_DYNAMIC!>x<!><!>
}

class A {
    operator fun provideDelegate(host: Any?, p: Any): dynamic = TODO("")
}

val z: Any? <!DEBUG_INFO_DYNAMIC!>by <!PROPERTY_DELEGATION_BY_DYNAMIC!>A()<!><!>

class DynamicHandler {
    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): dynamic = 23
}

class B {
    val x: dynamic by DynamicHandler()
}
