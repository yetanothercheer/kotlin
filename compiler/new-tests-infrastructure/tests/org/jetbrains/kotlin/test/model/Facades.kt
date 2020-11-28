/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.model

import org.jetbrains.kotlin.test.services.TestServices

abstract class FrontendFacade<R : ResultingArtifact.Source<R>>(
    val testServices: TestServices,
    final override val outputKind: FrontendKind<R>
) : AbstractTestFacade<SourcesArtifact, R>() {
    final override val inputKind: TestArtifactKind<SourcesArtifact>
        get() = SourcesKind

    abstract fun analyze(module: TestModule): R

    final override fun transform(module: TestModule, inputArtifact: SourcesArtifact): R {
        // TODO: pass sources
        return analyze(module)
    }
}

abstract class Frontend2BackendConverter<R : ResultingArtifact.Source<R>, I : ResultingArtifact.BackendInputInfo<I>>(
    val testServices: TestServices,
    final override val inputKind: FrontendKind<R>,
    final override val outputKind: BackendKind<I>
) : AbstractTestFacade<R, I>()

abstract class BackendFacade<I : ResultingArtifact.BackendInputInfo<I>, A : ResultingArtifact.Binary<A>>(
    val testServices: TestServices,
    final override val inputKind: BackendKind<I>,
    final override val outputKind: ArtifactKind<A>
) : AbstractTestFacade<I, A>()
