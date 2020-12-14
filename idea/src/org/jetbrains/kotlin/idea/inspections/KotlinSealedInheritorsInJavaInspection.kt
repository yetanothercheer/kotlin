/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.inspections

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.*
import org.jetbrains.kotlin.asJava.classes.KtUltraLightClass
import org.jetbrains.kotlin.descriptors.isSealed
import org.jetbrains.kotlin.idea.KotlinBundle


class KotlinSealedInheritorsInJavaInspection : LocalInspectionTool() {
    companion object {
        private fun PsiClass.extendsKotlinSealed(): Boolean {
            return when (this) {
                is PsiAnonymousClass -> baseClassType.isKotlinSealed()
                else -> extendsList?.includesKotlinSealed() == true || implementsList?.includesKotlinSealed() == true
            }
        }

        private fun PsiReferenceList.includesKotlinSealed(): Boolean = referencedTypes.any { it.isKotlinSealed() }

        private fun PsiClassType.isKotlinSealed(): Boolean = resolve()?.isKotlinSealed() == true

        private fun PsiClass.isKotlinSealed(): Boolean = this is KtUltraLightClass && getDescriptor()?.isSealed() == true

        private val PsiClass.abstractionTypeName: String
            get() = if (isInterface) "interface" else "class"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : JavaElementVisitor() {
            override fun visitClass(aClass: PsiClass?) {
                if (aClass?.extendsKotlinSealed() == true)
                    holder.registerProblem(aClass, KotlinBundle.message("inheritance.of.kotlin.sealed", aClass.abstractionTypeName))
            }

            override fun visitAnonymousClass(aClass: PsiAnonymousClass?) = visitClass(aClass)
        }
    }
}