fun test(d: dynamic) {
    val v1 = d.<!DEBUG_INFO_DYNAMIC!>foo<!>()
    v1.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v2 = d.<!DEBUG_INFO_DYNAMIC!>foo<!>(1)
    v2.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v3 = d.<!DEBUG_INFO_DYNAMIC!>foo<!>(1, "")
    v3.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v4 = d.<!DEBUG_INFO_DYNAMIC!>foo<!><String>()
    v4.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v5 = d.<!DEBUG_INFO_DYNAMIC!>foo<!>
    v5.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    d.<!DEBUG_INFO_DYNAMIC!>foo<!> = 1
}
