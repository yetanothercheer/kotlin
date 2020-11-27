/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.model

abstract class ResultingArtifact<A : ResultingArtifact<A>> {
    abstract val kind: TestArtifactKind<A>

    class SourcesArtifact : ResultingArtifact<SourcesArtifact>() {
        override val kind: TestArtifactKind<SourcesArtifact>
            get() = SourcesKind
    }

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

        object Empty : Binary<Empty>() {
            override val kind: ArtifactKind<Empty>
                get() = ArtifactKind.NoArtifact
        }
    }
}
