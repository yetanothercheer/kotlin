/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.compiler.test.runners

import org.jetbrains.kotlin.platform.jvm.JvmPlatforms
import org.jetbrains.kotlin.test.backend.BlackBoxCodegenSuppressor
import org.jetbrains.kotlin.test.backend.classic.ClassicJvmBackendFacade
import org.jetbrains.kotlin.test.backend.handlers.JvmBoxRunner
import org.jetbrains.kotlin.test.backend.ir.JvmIrBackendFacade
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder
import org.jetbrains.kotlin.test.frontend.classic.ClassicFrontend2ClassicBackendConverter
import org.jetbrains.kotlin.test.frontend.classic.ClassicFrontend2IrConverter
import org.jetbrains.kotlin.test.frontend.classic.ClassicFrontendFacade
import org.jetbrains.kotlin.test.frontend.classic.handlers.ClassicDiagnosticsHandler
import org.jetbrains.kotlin.test.frontend.classic.handlers.DeclarationsDumpHandler
import org.jetbrains.kotlin.test.model.BackendKind
import org.jetbrains.kotlin.test.model.DependencyKind
import org.jetbrains.kotlin.test.model.FrontendKind
import org.jetbrains.kotlin.test.services.JUnit5Assertions
import org.jetbrains.kotlin.test.services.configuration.JvmEnvironmentConfigurator

abstract class AbstractNewBlackBoxCodegenTest : AbstractKotlinTest() {
    open val targetBackend: BackendKind<*>
        get() = BackendKind.ClassicBackend

    override val configuration: TestConfigurationBuilder.() -> Unit = {
        globalDefaults {
            frontend = FrontendKind.ClassicFrontend
            backend = targetBackend
            targetPlatform = JvmPlatforms.defaultJvmPlatform
            dependencyKind = DependencyKind.Binary
        }

        assertions = JUnit5Assertions

        useConfigurators(::JvmEnvironmentConfigurator)

        useFrontendFacades(::ClassicFrontendFacade)
//        useFrontendHandlers(::ClassicDiagnosticsHandler)
        useFrontend2BackendConverters(::ClassicFrontend2ClassicBackendConverter, ::ClassicFrontend2IrConverter)
        useBackendFacades(::ClassicJvmBackendFacade, ::JvmIrBackendFacade)
        useArtifactsHandlers(::JvmBoxRunner)
        useMetaTestConfigurators(::BlackBoxCodegenSuppressor)
    }
}
