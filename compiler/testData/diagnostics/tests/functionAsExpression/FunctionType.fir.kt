// !WITH_NEW_INFERENCE
// !CHECK_TYPE
// !DIAGNOSTICS: -UNUSED_ANONYMOUS_PARAMETER -UNUSED_VARIABLE

fun testReturnType(foo: String) {
    val bar = fun () = foo

    bar.checkType { _<() -> String>() }

    val bas: () -> String = fun () = foo

    val bag: () -> Int = fun () = foo
}

fun testParamType() {
    val bar = fun (bal: String){}

    bar.checkType { _<(String) -> Unit>() }

    val bas: (String) -> Unit = fun (param: String) {}
    val bag: (Int) -> Unit = fun (param: String) {}
}

fun testReceiverType() {
    val bar = fun String.() {}

    bar.checkType { _<String.() -> Unit>() }

    val bas: String.() -> Unit = fun String.() {}

    val bag: Int.() -> Unit = fun String.() {}
}