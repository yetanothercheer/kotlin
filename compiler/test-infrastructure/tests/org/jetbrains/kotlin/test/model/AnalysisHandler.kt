/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.model

import org.jetbrains.kotlin.test.directives.model.DirectivesContainer
import org.jetbrains.kotlin.test.services.Assertions
import org.jetbrains.kotlin.test.services.ServiceRegistrationData
import org.jetbrains.kotlin.test.services.TestServices
import org.jetbrains.kotlin.test.services.assertions

abstract class AnalysisHandler<A : ResultingArtifact<A>>(val testServices: TestServices) {
    protected val assertions: Assertions
        get() = testServices.assertions

    open val directivesContainers: List<DirectivesContainer>
        get() = emptyList()

    open val additionalServices: List<ServiceRegistrationData>
        get() = emptyList()

    abstract val artifactKind: TestArtifactKind<A>

    abstract fun processModule(module: TestModule, info: A)

    abstract fun processAfterAllModules()
}

abstract class FrontendResultsHandler<R : ResultingArtifact.Source<R>>(
    testServices: TestServices,
    override val artifactKind: FrontendKind<R>
) : AnalysisHandler<R>(testServices)

abstract class BackendInitialInfoHandler<I : ResultingArtifact.BackendInputInfo<I>>(
    testServices: TestServices,
    override val artifactKind: BackendKind<I>
) : AnalysisHandler<I>(testServices)

abstract class ArtifactsResultsHandler<A : ResultingArtifact.Binary<A>>(
    testServices: TestServices,
    override val artifactKind: ArtifactKind<A>
) : AnalysisHandler<A>(testServices)
