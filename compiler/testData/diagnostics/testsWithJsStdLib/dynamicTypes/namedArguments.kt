fun test(d: dynamic) {
    d.<!DEBUG_INFO_DYNAMIC!>foo<!>(name = "name")

    d.<!DEBUG_INFO_DYNAMIC!>foo<!>(1, name = "name")

    d.<!DEBUG_INFO_DYNAMIC!>foo<!>(1, duplicate = "", <!ARGUMENT_PASSED_TWICE!>duplicate<!> = ""<!NO_VALUE_FOR_PARAMETER!>)<!>
}
