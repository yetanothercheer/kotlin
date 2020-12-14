fun test(d: dynamic) {
    val v1 = d?.<!DEBUG_INFO_DYNAMIC!>foo<!>()
    v1.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v2 = d!!.<!DEBUG_INFO_DYNAMIC!>foo<!>(1)
    v2.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable
}
