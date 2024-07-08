# BoxLib
The most basic client-side library mod.

BoxLib is a library mod containing shared code used in Boxadactle's client mods. It is designed to be lightweight and easy to use, with a focus on providing utilities and tools that are commonly used in client-side mods.

### Library

#### Features
- Config GUI Handler
- Config file loader/saver
- Client Command Handler
- Math
- Client Utils
- Gui Utils
- Rendering Utils
- World Utils
- Mod Logger
- Google Translation Features
- Rendering Layouts
- Keybinding helpers
- Prompt system

### Dependents

BoxLib is required by all of the following mods:
- [CoordinatesDisplay](https://www.curseforge.com/minecraft/mc-mods/coordinates-display) v10.0.0 and above
- [DebugKeybind](https://www.curseforge.com/minecraft/mc-mods/debug-keybind) v8.0.0 and above
- [MacroCraft](https://www.curseforge.com/minecraft/mc-mods/macrocraft) v4.0.0 and above

<p style="color: red">If you have trouble finding the required version of BoxLib for a specific mod, just download the latest version of BoxLib for the Minecraft version you are using. </p>

### Usage

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

    modImplementation("dev.boxadactle.boxlib:Boxlib-fabric:VERSION")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_

#### Setup with NeoForge

**`build.gradle`**
```gradle
repositories {
    maven { url = "https://maven.boxadactle.dev/" }
}

dependencies {
    [...]

    modImplementation("dev.boxadactle.boxlib:Boxlib-neoforge:VERSION")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_

#### Setup with Architectury

**`build.gradle`**
```gradle
repositories {
    maven { url = "https://maven.boxadactle.dev/" }
}

dependencies {
    [...]
    
    modCompileOnlyApi("dev.boxadactle:Boxlib-common:VERSION")
}
```

_Make sure to replace `VERSION` with the correct version of each mod_


#### Setup with Forge (DEPRECATED)

<p style="color: red">THE FORGE VERSION OF BOXLIB HAS BEEN DEPRECATED SINCE 1.20.6</p>

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
}
```

_Make sure to replace `VERSION` with the correct version of each mod_
