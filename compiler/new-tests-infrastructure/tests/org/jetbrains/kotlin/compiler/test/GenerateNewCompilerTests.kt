/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.compiler.test

import org.jetbrains.kotlin.compiler.test.runners.AbstractFirDiagnosticTest
import org.jetbrains.kotlin.compiler.test.runners.AbstractFirOldFrontendDiagnosticsTest
import org.jetbrains.kotlin.compiler.test.runners.AbstractNewBlackBoxCodegenTest
import org.jetbrains.kotlin.test.junit5Generator.generateNewTestGroupSuite
import org.jetbrains.kotlin.compiler.test.runners.AbstractNewDiagnosticTest
import org.jetbrains.kotlin.test.TargetBackend

fun main(args: Array<String>) {
    generateNewTestGroupSuite(args) {
        testGroup("compiler/new-tests-infrastructure/tests-gen", "compiler/testData") {
            testClass<AbstractNewDiagnosticTest> {
                model("diagnostics/tests", pattern = "^(.*)\\.kts?$", excludedPattern = "^(.+)\\.fir\\.kts?\$")
            }

            testClass<AbstractFirOldFrontendDiagnosticsTest> {
                model("diagnostics/tests", pattern = "^(.*)\\.kts?$", excludedPattern = "^(.+)\\.fir\\.kts?\$")
            }

            testClass<AbstractNewBlackBoxCodegenTest> {
                model("codegen/box", targetBackend = TargetBackend.JVM)
            }
        }

        testGroup("compiler/new-tests-infrastructure/tests-gen", "compiler/fir/analysis-tests/testData") {
            testClass<AbstractFirDiagnosticTest> {
                model("resolve", pattern = "^(.*)\\.kts?$", excludedPattern = "^(.+)\\.fir\\.kts?\$")
            }
        }
    }
}
