// !DIAGNOSTICS: -UNUSED_PARAMETER

fun foo() {
    for (<!WRONG_OPERATION_WITH_DYNAMIC!>(<!DEBUG_INFO_DYNAMIC!>x<!>, <!DEBUG_INFO_DYNAMIC!>y<!>)<!> in A()) {
        println(x <!DEBUG_INFO_DYNAMIC!>+<!> y)
    }

    bar { <!WRONG_OPERATION_WITH_DYNAMIC!>(<!DEBUG_INFO_DYNAMIC!>x<!>, <!DEBUG_INFO_DYNAMIC!>y<!>)<!> ->
        println(x <!DEBUG_INFO_DYNAMIC!>+<!> y)
    }

    val x: dynamic = Any()

    <!WRONG_OPERATION_WITH_DYNAMIC!>val (<!DEBUG_INFO_DYNAMIC!>y<!>, <!DEBUG_INFO_DYNAMIC!>z<!>) = x<!>
    println(y <!DEBUG_INFO_DYNAMIC!>+<!> z)
}

class A {
    operator fun iterator(): Iterator<dynamic> = TODO("")
}

fun bar(f: (dynamic) -> Unit): Unit = TODO("")
