/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.diagnostics;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author svtk
 */
public class SimpleDiagnosticFactory<E extends PsiElement> extends DiagnosticFactoryWithPsiElement<E> {

    protected SimpleDiagnosticFactory(Severity severity, PositioningStrategy<? super E> positioningStrategy) {
        super(severity, positioningStrategy);
    }

    public static <T extends PsiElement> SimpleDiagnosticFactory<T> create(Severity severity) {
        return create(severity, PositioningStrategies.DEFAULT);
    }

    public static <T extends PsiElement> SimpleDiagnosticFactory<T> create(Severity severity, PositioningStrategy<? super T> positioningStrategy) {
        return new SimpleDiagnosticFactory<T>(severity, positioningStrategy);
    }

    @NotNull
    public SimpleDiagnostic<E> on(@NotNull E element) {
        return new SimpleDiagnostic<E>(element, this, severity);
    }
}