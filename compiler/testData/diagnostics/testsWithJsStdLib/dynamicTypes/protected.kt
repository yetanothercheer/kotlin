open class Foo {
    open protected fun bar(a: dynamic){
        a.<!DEBUG_INFO_DYNAMIC!>something<!>
    }
}
