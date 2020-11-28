/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.model

import org.jetbrains.kotlin.test.services.ServiceRegistrationData

abstract class AbstractTestFacade<I : ResultingArtifact<I>, O : ResultingArtifact<O>> {
    abstract val inputKind: TestArtifactKind<I>
    abstract val outputKind: TestArtifactKind<O>

    abstract fun transform(module: TestModule, inputArtifact: I): O

    open val additionalServices: List<ServiceRegistrationData>
        get() = emptyList()
}
