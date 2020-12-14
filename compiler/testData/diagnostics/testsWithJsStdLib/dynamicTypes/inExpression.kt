fun foo() {
    val a: dynamic = Any()
    println(a in setOf(1, 2))
    println(1 <!DEBUG_INFO_DYNAMIC, WRONG_OPERATION_WITH_DYNAMIC!>in<!> a)
    println(1 <!DEBUG_INFO_DYNAMIC, WRONG_OPERATION_WITH_DYNAMIC!>!in<!> a)
    when (2) {
        <!DEBUG_INFO_DYNAMIC, WRONG_OPERATION_WITH_DYNAMIC!>in<!> a -> println("ok")
    }
    when (3) {
        <!DEBUG_INFO_DYNAMIC, WRONG_OPERATION_WITH_DYNAMIC!>!in<!> a -> println("ok")
    }
}
