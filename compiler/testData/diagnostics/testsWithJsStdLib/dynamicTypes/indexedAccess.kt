fun foo() {
    val a: dynamic = Any()
    println(<!DEBUG_INFO_DYNAMIC!>a[0]<!>)
    println(<!DEBUG_INFO_DYNAMIC, WRONG_OPERATION_WITH_DYNAMIC!>a[0, 1]<!>)

    <!DEBUG_INFO_DYNAMIC!>a[0]<!> = 23
    <!DEBUG_INFO_DYNAMIC, WRONG_OPERATION_WITH_DYNAMIC!>a[0, 1]<!> = 42
}
