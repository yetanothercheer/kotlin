// !DIAGNOSTICS: -UNUSED_PARAMETER

fun foo(dn: dynamic<!REDUNDANT_NULLABLE!>?<!>, d: dynamic, dnn: dynamic<!REDUNDANT_NULLABLE!>?<!><!REDUNDANT_NULLABLE!>?<!>) {
    val a1 = dn.<!DEBUG_INFO_DYNAMIC!>foo<!>()
    a1.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>()

    val a2 = dn?.<!DEBUG_INFO_DYNAMIC!>foo<!>()
    a2.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>()

    val a3 = dn!!.<!DEBUG_INFO_DYNAMIC!>foo<!>()
    a3.<!DEBUG_INFO_DYNAMIC!>isDynamic<!>()

    d.<!DEBUG_INFO_DYNAMIC!>foo<!>()
    d?.<!DEBUG_INFO_DYNAMIC!>foo<!>()
    d!!.<!DEBUG_INFO_DYNAMIC!>foo<!>()
}
