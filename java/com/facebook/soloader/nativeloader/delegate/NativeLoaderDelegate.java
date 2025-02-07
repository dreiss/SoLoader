/*
 * Copyright 2014-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.soloader.nativeloader.delegate;

import android.content.Context;
import java.io.IOException;

/** Interface used to connect chosen loader of native libaries to NativeLoader */
public interface NativeLoaderDelegate {
  /**
   * Initializes native code loading for this app; this class's other static facilities cannot be
   * used until {@link #init} is called. This method is idempotent: calls after the first are
   * ignored.
   *
   * @param context application context.
   */
  void init(Context context) throws IOException;

  /**
   * Load a shared library, initializing any JNI binding it contains.
   *
   * @param shortName Name of library to find, without "lib" prefix or ".so" suffix
   * @return Whether the library was loaded as a result of this call (true), or loading wasn't
   *     successful (false).
   */
  boolean loadLibrary(String shortName);
}
