# BoxLib
The most basic client-side library mod

### Embedding
Most of my mods embed this mod, here is the list:

| Name      | Version |
| ----------- | ----------- |
| Coordinates Display | Since v3.0.0 |
| Debug Keybind | Since v1.0.0 |

### Library

#### Features
- Config GUI Handler
- Config file loader/saver
- Client Command Handler
- Math
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

    modApi("dev.boxadactle.boxlib:BoxLib-Fabric:VERSION")
    include("dev.boxadactle.boxlib:BoxLib-Fabric:VERSION")
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

    implementation fg.deobf("dev.boxadactle.boxlib:BoxLib-Forge:VERSION")
    
    // optional way of embedding the mod
    jarJar(group: 'dev.boxadactle.boxlib', name: 'BoxLib-Forge', version: "[VERSION,)")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_

#### Setup with Architectury

For fabric and forge, it will be almost exactly the same as a standalone mod.

**`build.gradle`**
```gradle
repositories {
    maven { url = "https://maven.boxadactle.dev/" }
}

dependencies {
    [...]
    
    // dont embed the jar into the common project,
    // it's better to do it when building fabric/forge
    modCompileOnlyApi("dev.boxadactle:BoxLib:VERSION")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_
