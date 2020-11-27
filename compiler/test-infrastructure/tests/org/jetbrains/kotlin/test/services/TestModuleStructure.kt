/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.services

import org.jetbrains.kotlin.platform.TargetPlatform
import org.jetbrains.kotlin.platform.js.JsPlatforms
import org.jetbrains.kotlin.platform.jvm.JvmPlatforms
import org.jetbrains.kotlin.platform.konan.NativePlatforms
import org.jetbrains.kotlin.test.directives.model.RegisteredDirectives
import org.jetbrains.kotlin.test.model.ArtifactKind
import org.jetbrains.kotlin.test.model.DependencyKind
import org.jetbrains.kotlin.test.model.TestModule
import org.jetbrains.kotlin.test.services.TestService
import org.jetbrains.kotlin.test.services.TestServices
import java.io.File

data class TestModuleStructure(
    val modules: List<TestModule>,
    val globalDirectives: RegisteredDirectives,
    val originalTestDataFiles: List<File>
) : TestService {
    @OptIn(ExperimentalStdlibApi::class)
    private val targetArtifactsByModule: Map<String, List<ArtifactKind<*>>> = buildMap {
        for (module in modules) {
            val result = mutableListOf<ArtifactKind<*>>()
            for (dependency in module.dependencies) {
                if (dependency.kind == DependencyKind.KLib) {
//                    result += ArtifactKind.KLib
                }
            }
            module.targetPlatform.toArtifactKind()?.let { result += it }
            put(module.name, result)
        }
    }

    fun getTargetArtifactKinds(module: TestModule): List<ArtifactKind<*>> {
        return targetArtifactsByModule[module.name] ?: emptyList()
    }

    override fun toString(): String {
        return buildString {
            appendLine("Global directives:\n  $globalDirectives")
            modules.forEach {
                appendLine(it)
                appendLine()
            }
        }
    }

    companion object {
        private fun TargetPlatform.toArtifactKind(): ArtifactKind<*>? = when (this) {
//            in JvmPlatforms.allJvmPlatforms -> ArtifactKind.Jvm
//            in JsPlatforms.allJsPlatforms -> ArtifactKind.Js
//            in NativePlatforms.allNativePlatforms -> ArtifactKind.Native
            else -> null
        }
    }
}

val TestServices.moduleStructure: TestModuleStructure by TestServices.testServiceAccessor()
