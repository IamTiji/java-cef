# MCEF java-cef
Modified version of java-cef for use with Slicef.

On Windows, build with:

```powershell
javac -cp ".\third_party\jogamp\jar\*;.\third_party\junit\*;.\java" -d "./out/" -g (Get-ChildItem -Recurse -Path ../* -Include *.java -Name)
```

On Linux/MacOS, use compile.sh