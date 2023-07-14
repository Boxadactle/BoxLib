# BoxLib
The most basic client-side library mod

### Embedding
Most of my mods embed this mod, here is the list:
| Name      | Version |
| ----------- | ----------- |
| [Coordinates Display](https://modrinth.com/mod/coordinates-display)      | Since [v3.0.0](https://modrinth.com/mod/coordinates-display/version/3.0.0+1.20.1)       |

### API

#### Features
- Config GUI Handler
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

It is recommended to use a config library such as [Cloth Config](https://modrinth.com/mod/cloth-config/versions) as BoxLib does not handle config saving/loading.

Please DO NOT use BoxLib for server mods, it's been specifically written for Client mods.

#### Setup with Fabric
**`build.gradle:`**
```gradle
repositories {
    maven { url = "https://maven.shedaniel.me/" } #recommended
    maven { url = "https://maven.boxadactle.dev/" }
}

dependencies {
    [...]

	# recommended
    modApi("me.shedaniel.cloth:cloth-config-fabric:VERSION") {
        exclude(group: "net.fabricmc.fabric-api")
    }
    include("me.shedaniel.cloth:cloth-config-fabric:VERSION")

    modApi("dev.boxadactle:BoxLib-Fabric:VERSION")
    include("dev.boxadactle:BoxLib-Fabric:VERSION")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_

#### Setup with Forge
**`build.gradle:`**
```gradle
# For Forge, I recommend embedding the mod with the built-in jarJar
jarJar.enable()

repositories {
    maven { url = "https://maven.shedaniel.me/" } #recommended
    maven { url = "https://maven.boxadactle.dev/" }
}

dependencies {
    [...]

    # recommended
    implementation "me.shedaniel.cloth:cloth-config-forge:VERSION"

    implementation fg.deobf("dev.boxadactle:BoxLib-Forge:VERSION")
    
    # optional way of embedding the mod
    jarJar(group: 'dev.boxadactle', name: 'BoxLib-Forge', version: "[VERSION,)")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_
