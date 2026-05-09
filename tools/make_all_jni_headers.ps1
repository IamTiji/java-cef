# Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
# reserved. Use of this source code is governed by a BSD-style license
# that can be found in the LICENSE file.

$NATIVE_METHOD_REGEX = "(?:\/\*[\s\S]*?\*\/|\/\/.*)?\s*(?:public|protected|private|static|final|synchronized|\s)*native\s+[\w<>[\]]+\s+\w+\s*\([^)]*\)\s*(?:throws\s+[\w.\s,]+)?\s*;"

$all_java_files = Get-ChildItem -Path ./java/* -Recurse -Include '*.java'

$filtered = $all_java_files | Where-Object {
    $contents = Get-Content $_
    $contents -match $NATIVE_METHOD_REGEX
}
$filtered = $filtered | ForEach-Object {
    $path = Resolve-Path -Relative $_.DirectoryName
    $path.Substring(7).Replace("\", ".") + "." + $_.BaseName
}

foreach ($file in $filtered) {
    .\tools\make_jni_header.ps1 $file
}