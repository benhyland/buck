/*
 * Copyright 2014-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.python;

import static org.junit.Assert.assertEquals;

import com.facebook.buck.util.ProcessExecutor;

import org.junit.Test;

import java.nio.file.Paths;

public class PythonBuckConfigTest {

  @Test
  public void testGetPythonVersion() throws Exception {
    PythonVersion version =
        PythonBuckConfig.extractPythonVersion(
            Paths.get("usr", "bin", "python"),
            new ProcessExecutor.Result(0, "", "Python 2.7.5\n"));
    assertEquals("Python 2.7", version.toString());
  }

  @Test
  public void testGetPyrunVersion() throws Exception {
    PythonVersion version =
        PythonBuckConfig.extractPythonVersion(
            Paths.get("usr", "bin", "python"),
            new ProcessExecutor.Result(0, "", "pyrun 2.7.6 (release 2.0.0)\n"));
    assertEquals("pyrun 2.7", version.toString());
  }
}
