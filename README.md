# BoxLib
The most basic client-side library mod

### Supported Versions
| Minecraft Version | Most Recent Version |
| ------ |---------------|
| 1.16 | Not Supported |
| 1.17 | Not Supported |
| 1.18 | Not Supported |
| 1.19 | Not Supported |
| 1.20 | v5.2.0        |

### Embedding
Most of my mods embed this mod, here is the list:
| Name      | Version |
| ----------- | ----------- |
| Coordinates Display | Since v3.0.0 |
| Debug Keybind | Since v1.0.0 |

### API

#### Features
- Config GUI Handler
- Config file loader/saver
- Client Command Handler
- Basic Math (Vectors, Rect, and Dimension)
- Client Utils
- Gui Utils
- Mouse Utils
- Rendering Utils
- World Utils
- Mod Logger
- Mod Constants Handler (name, version, mod id, etc)


If you would like to use this library, it is published on my maven repository: `https://maven.boxadactle.dev`

Please DO NOT use BoxLib for server mods, it's been specifically written for Client mods.

#### Setup with Fabric
**`build.gradle:`**
```gradle
repositories {
    maven { url = "https://maven.boxadactle.dev/" }
}

dependencies {
    [...]

    modApi("dev.boxadactle:BoxLib-Fabric:VERSION")
    include("dev.boxadactle:BoxLib-Fabric:VERSION")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_

#### Setup with Forge
**`build.gradle:`**
```gradle
// For Forge, I recommend embedding the mod with the built-in jarJar
jarJar.enable()

repositories {
    maven { url = "https://maven.boxadactle.dev/" }
}

dependencies {
    [...]

    implementation fg.deobf("dev.boxadactle:BoxLib-Forge:VERSION")
    
    // optional way of embedding the mod
    jarJar(group: 'dev.boxadactle', name: 'BoxLib-Forge', version: "[VERSION,)")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_
