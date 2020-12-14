// !DIAGNOSTICS: -UNUSED_VARIABLE

fun test(d: dynamic) {
    d == null
    d != null
    <!DEBUG_INFO_DYNAMIC!>d["foo"]<!> == null
    <!DEBUG_INFO_DYNAMIC!>d["foo"]<!> != null
    d.<!DEBUG_INFO_DYNAMIC!>foo<!> == null
    d.<!DEBUG_INFO_DYNAMIC!>foo<!> != null
}
