fun <!DYNAMIC_RECEIVER_NOT_ALLOWED!>dynamic<!>.test() {
    val v1 = <!DEBUG_INFO_DYNAMIC!>foo<!>()
    v1.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v2 = <!DEBUG_INFO_DYNAMIC!>foo<!>(1)
    v2.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v3 = <!DEBUG_INFO_DYNAMIC!>foo<!>(1, "")
    v3.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v4 = <!DEBUG_INFO_DYNAMIC!>foo<!><String>()
    v4.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    val v5 = <!DEBUG_INFO_DYNAMIC!>foo<!>
    v5.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>() // to check that anything is resolvable

    <!DEBUG_INFO_DYNAMIC!>foo<!> = 1
}
