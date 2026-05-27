# Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
# reserved. Use of this source code is governed by a BSD-style license
# that can be found in the LICENSE file.

Param (
    [Parameter(Mandatory = $true)]
    [string]$classFullName
)

$OUT_PATH = "./native"
$CLS_PATH = ".\third_party\jogamp\jar\*;.\third_party\junit\*;.\java"

$className = $classFullName.Split(".")[-1]

javah.exe -force -classpath $CLS_PATH -o $OUT_PATH/$className.h $classFullName