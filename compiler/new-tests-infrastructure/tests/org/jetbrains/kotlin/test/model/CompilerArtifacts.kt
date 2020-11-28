/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.model

import org.jetbrains.kotlin.codegen.ClassFileFactory
import org.jetbrains.kotlin.test.backend.classic.ClassicBackendInputInfo
import org.jetbrains.kotlin.test.backend.ir.IrBackendInputInfo
import org.jetbrains.kotlin.test.frontend.classic.ClassicFrontendSourceArtifacts
import org.jetbrains.kotlin.test.frontend.fir.FirSourceArtifact

abstract class ResultingArtifact<A : ResultingArtifact<A>> {
    abstract val kind: TestArtifactKind<A>

    abstract class Source<R : Source<R>> : ResultingArtifact<R>() {
        abstract override val kind: FrontendKind<R>

        object Empty : Source<Empty>() {
            override val kind: FrontendKind<Empty>
                get() = FrontendKind.NoFrontend
        }
    }

    abstract class BackendInputInfo<I : BackendInputInfo<I>> : ResultingArtifact<I>() {
        abstract override val kind: BackendKind<I>

        object Empty : BackendInputInfo<Empty>() {
            override val kind: BackendKind<Empty>
                get() = BackendKind.NoBackend
        }
    }

    abstract class Binary<A : Binary<A>> : ResultingArtifact<A>() {
        abstract override val kind: ArtifactKind<A>

        class Jvm(val classFileFactory: ClassFileFactory) : Binary<Jvm>() {
            override val kind: ArtifactKind<Jvm>
                get() = ArtifactKind.Jvm
        }

        class Js : Binary<Js>() {
            override val kind: ArtifactKind<Js>
                get() = ArtifactKind.Js
        }

        class Native : Binary<Native>() {
            override val kind: ArtifactKind<Native>
                get() = ArtifactKind.Native
        }

        class KLib : Binary<KLib>() {
            override val kind: ArtifactKind<KLib>
                get() = ArtifactKind.KLib
        }

        object Empty : Binary<Empty>() {
            override val kind: ArtifactKind<Empty>
                get() = ArtifactKind.NoArtifact
        }
    }
}


class SourcesArtifact : ResultingArtifact<SourcesArtifact>() {
    override val kind: TestArtifactKind<SourcesArtifact>
        get() = SourcesKind
}

object SourcesKind : TestArtifactKind<SourcesArtifact>("Sources")

abstract class FrontendKind<R : ResultingArtifact.Source<R>>(representation: String) : TestArtifactKind<R>(representation) {
    object ClassicFrontend : FrontendKind<ClassicFrontendSourceArtifacts>("ClassicFrontend")
    object FIR : FrontendKind<FirSourceArtifact>("FIR")

    object NoFrontend : FrontendKind<ResultingArtifact.Source.Empty>("NoFrontend") {
        override val shouldRunAnalysis: Boolean
            get() = false
    }

    companion object {
        fun fromString(string: String): FrontendKind<*>? {
            return when (string) {
                "ClassicFrontend" -> ClassicFrontend
                "FIR" -> FIR
                else -> null
            }
        }
    }
}

abstract class BackendKind<I : ResultingArtifact.BackendInputInfo<I>>(representation: String) : TestArtifactKind<I>(representation) {
    object ClassicBackend : BackendKind<ClassicBackendInputInfo>("ClassicBackend")
    object IrBackend : BackendKind<IrBackendInputInfo>("IrBackend")

    object NoBackend : BackendKind<ResultingArtifact.BackendInputInfo.Empty>("NoBackend") {
        override val shouldRunAnalysis: Boolean
            get() = false
    }

    companion object {
        fun fromString(string: String): BackendKind<*>? {
            return when (string) {
                "ClassicBackend" -> ClassicBackend
                "IrBackend" -> IrBackend
                else -> null
            }
        }
    }
}

abstract class ArtifactKind<A : ResultingArtifact.Binary<A>>(representation: String) : TestArtifactKind<A>(representation) {
    object Jvm : ArtifactKind<ResultingArtifact.Binary.Jvm>("JVM")
    object Js : ArtifactKind<ResultingArtifact.Binary.Js>("JS")
    object Native : ArtifactKind<ResultingArtifact.Binary.Native>("Native")
    object KLib : ArtifactKind<ResultingArtifact.Binary.KLib>("KLib")

    object NoArtifact : ArtifactKind<ResultingArtifact.Binary.Empty>("NoArtifact") {
        override val shouldRunAnalysis: Boolean
            get() = false
    }

    companion object {
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
}
