# ObjectsJson
This library offers a more object oriented way to parse json data.

# Characteristics
  * Declaritive design
  * Everything is immutable
  * Everything uses interfaces
  * Easy expandable
  * No unnecessary exception throwing
  * **No object mapping**  
    A json object is not comperable with a java object, because it is just a container of data without any behaviour. A java object on the other side should only expose behaviour. Because of this conceptual difference any direct mapping would violate the object oriented design.
  * Supports conversion from and to a json file or anything else
  * Own json sources or targets can be defined
  * No static methods
  * No getters

# Examples
## Creating json
A json object can be created like this:  
```kotlin
val json = JsonObject(
  "firstKey" to JsonString("firstValue"),
  "secondKey" to JsonInt(323),
  "thirdKey" to JsonObject(
    "fourthKey" to JsonArray(
      1, 2, 3, 4, 5
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
Other sources are also possible. The JsonObject can be constructed by using a string, a file or other json objects. It just needs a class that implements the Source interface. Because of this, new sources can be specified.
