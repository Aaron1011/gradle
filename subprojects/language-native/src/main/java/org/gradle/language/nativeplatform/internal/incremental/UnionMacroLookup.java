/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.language.nativeplatform.internal.incremental;

import com.google.common.collect.Iterators;
import org.gradle.language.nativeplatform.internal.Macro;
import org.gradle.language.nativeplatform.internal.MacroFunction;

import java.util.Iterator;

class UnionMacroLookup implements MacroLookup {
    private final MacroLookup first;
    private final MacroLookup second;

    UnionMacroLookup(MacroLookup first, MacroLookup second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Iterator<Macro> getMacros(String name) {
        return Iterators.concat(first.getMacros(name), second.getMacros(name));
    }

    @Override
    public Iterator<MacroFunction> getMacroFunctions(String name) {
        return Iterators.concat(first.getMacroFunctions(name), second.getMacroFunctions(name));
    }
}
