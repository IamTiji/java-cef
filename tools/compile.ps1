# Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
# reserved. Use of this source code is governed by a BSD-style license
# that can be found in the LICENSE file.

$OUT_PATH = "./out/build"
$OUT_PATH_INT = "./out/.java"
$CLS_PATH = ".\third_party\jogamp\jar\*;.\third_party\junit\*;.\java"

# Clear old directory and recreate clean directory
if (Test-Path -Path $OUT_PATH_INT) {
    Remove-Item -Path $OUT_PATH_INT -Recurse -Force
}
New-Item -ItemType Directory -Path $OUT_PATH_INT | Out-Null
New-Item -ItemType Directory -Path $OUT_PATH_INT/tests/detailed/handler | Out-Null
New-Item -ItemType Directory -Path $OUT_PATH_INT/manifest | Out-Null

New-Item -ItemType Directory -Path $OUT_PATH -Force | Out-Null


# Compile Java sources
javac -Xdiags:verbose -cp $CLS_PATH -d $OUT_PATH_INT -g (Get-ChildItem -Path ./java/* -Recurse -Include *.java)

# Copy manifest and resources
Copy-Item -Path .\java\manifest -Destination $OUT_PATH_INT\manifest\ -Recurse -Force
Copy-Item -Path .\java\tests\detailed\handler\*.html -Destination $OUT_PATH_INT\tests\detailed\handler\ -Force
Copy-Item -Path .\java\tests\detailed\handler\*.png -Destination $OUT_PATH_INT\tests\detailed\handler\ -Force

# Compress to Jar file
Compress-Archive -Path $OUT_PATH_INT -DestinationPath $OUT_PATH/tmp.zip -CompressionLevel NoCompression -Force
Move-Item -Path $OUT_PATH/tmp.zip -Destination $OUT_PATH/jcef.jar -Force