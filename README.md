# ObjectsJson
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Shryne_ObjectsJson&metric=coverage)](https://sonarcloud.io/dashboard?id=Shryne_ObjectsJson) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Shryne_ObjectsJson&metric=bugs)](https://sonarcloud.io/dashboard?id=Shryne_ObjectsJson) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Shryne_ObjectsJson&metric=code_smells)](https://sonarcloud.io/dashboard?id=Shryne_ObjectsJson) [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Shryne_ObjectsJson&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=Shryne_ObjectsJson)  
This library offers a more object oriented way to parse json data.

# Characteristics
  * Declaritive design
  * Everything is immutable
  * Everything uses interfaces
  * Easy expandable
  * No unnecessary exception throwing
  * **No object mapping**  
  * Supports conversion from and to a json file or anything else
  * Own json sources or targets can be defined
  * Uses [mutation testing](https://github.com/hcoles/pitest)  
  * Uses [detekt](https://github.com/detekt/detekt-intellij-plugin)

# Examples
## Creating json
A json object can be created like this:  
```kotlin
val json = JsonObject(
  "firstKey" to JsonString("firstValue"),
  "secondKey" to JsonInt(323),
  "thirdKey" to JsonObject(
    "fourthKey" to JsonArray(
      "a" to JsonBoolean("true"),
      "b" to JsonInt("342")
    )
  )
)
```
To export this data:
```kotlin
json.exportTo(
  FileTarget("path")
)
```
Result:
```json
{
  "firstKey": "firstValue",
  "secondKey": 323,
  "thirdKey": {
    "fourthKey": [
      1, 2, 3, 4, 5
    ]
  }
}
```

## Importing a json
To import json data, one has to specify the source of it:
```kotlin
JsonObject(
  FileSource("path")
)
```
Other sources are also possible. The JsonObject can be constructed 
by using a string, a file or other json objects. It just needs a class 
that implements the Source interface.
