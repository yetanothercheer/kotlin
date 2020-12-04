/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.descriptors.commonizer.cli

import java.io.File

internal object AdditionalLibrariesOptionType : OptionType<List<File>>(
    "additional-libraries", "Path to additional libraries", false
) {
    override fun parse(rawValue: String, onError: (reason: String) -> Nothing): Option<List<File>> {
        val files = rawValue.split(";").map { File(it) }
        return Option(this, files)
    }

}
