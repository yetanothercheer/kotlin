/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.model

import org.jetbrains.kotlin.test.backend.classic.ClassicBackendInputInfo
import org.jetbrains.kotlin.test.backend.ir.IrBackendInputInfo
import org.jetbrains.kotlin.test.frontend.classic.ClassicFrontendSourceArtifacts
import org.jetbrains.kotlin.test.frontend.fir.FirSourceArtifact

object FrontendKinds {
    object ClassicFrontend : FrontendKind<ClassicFrontendSourceArtifacts>("ClassicFrontend")
    object FIR : FrontendKind<FirSourceArtifact>("FIR")

    fun fromString(string: String): FrontendKind<*>? {
        return when (string) {
            "ClassicFrontend" -> ClassicFrontend
            "FIR" -> FIR
            else -> null
        }
    }
}

object BackendKinds {
    object ClassicBackend : BackendKind<ClassicBackendInputInfo>("ClassicBackend")
    object IrBackend : BackendKind<IrBackendInputInfo>("IrBackend")

    fun fromString(string: String): BackendKind<*>? {
        return when (string) {
            "ClassicBackend" -> ClassicBackend
            "IrBackend" -> IrBackend
            else -> null
        }
    }
}

object ArtifactKinds {
    object Jvm : ArtifactKind<BinaryArtifacts.Jvm>("JVM")
    object Js : ArtifactKind<BinaryArtifacts.Js>("JS")
    object Native : ArtifactKind<BinaryArtifacts.Native>("Native")
    object KLib : ArtifactKind<BinaryArtifacts.KLib>("KLib")

    fun fromString(string: String): ArtifactKind<*>? {
        return when (string) {
            "Jvm" -> Jvm
            "Js" -> Js
            "Native" -> Native
            "KLib" -> KLib
            else -> null
        }
    }
}
