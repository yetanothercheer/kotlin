/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.directives

import org.jetbrains.kotlin.config.JvmTarget
import org.jetbrains.kotlin.test.TestJdkKind
import org.jetbrains.kotlin.test.directives.model.SimpleDirectivesContainer

object JvmEnvironmentConfigurationDirectives : SimpleDirectivesContainer() {
    val jvmTarget = enumDirective<JvmTarget>("JVM_TARGET", "Target bytecode version")

    val jdkKind = enumDirective<TestJdkKind>("JDK_KIND", "JDK used in tests")
    val fullJdk = directive("FULL_JDK", "Add full java standard library to classpath")

    val withRuntime = directive("WITH_RUNTIME", "Add Kotlin runtime to classpath")
    val withReflect = directive("WITH_REFLECT", "Add Kotlin reflect to classpath")
    val noRuntime = directive("NO_RUNTIME", "Don't add any runtime libs to classpath")
}
