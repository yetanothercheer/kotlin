external class A {
    class B
}

inline fun A.foo(x: Int): String = asDynamic().<!DEBUG_INFO_DYNAMIC!>foo<!>(x)

inline operator fun A.get(x: Int): String = <!DEBUG_INFO_DYNAMIC!>asDynamic()[x]<!>

inline operator fun A.B.get(x: Int): String = <!DEBUG_INFO_DYNAMIC!>asDynamic()[x]<!>
