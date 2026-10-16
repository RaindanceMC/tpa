# RaindanceMC/tpa

- **`tpa-module`** — Rain's Flexible Modules — Teleport requests: Asking somebody whether you may come to them, or whether they will come to you — and going back to where you were. The warm-up, the safe arrival and the teleport itself are RainsCore's, the same ones the warps and the homes use. What is here is what a request is: who has asked whom, how long the asking stands, and what a second one means.
- **`tpa-standalone`** — Rain's TPA: Rain's TPA, as a plugin of its own. Nothing here but a build file and a descriptor: the teleport-request module and the standard wrapper are shaded together, and that is the whole plugin. The name and the data folder are unchanged from the standalone plugin it replaces.

Part of [RaindanceMC](https://github.com/RaindanceMC); built on [RainsCore](https://github.com/RaindanceMC/RainsCore) and the shared parent in [framework](https://github.com/RaindanceMC/framework). Split out of `rains-flexible-modules` on 16.10.2026, history kept.

## Build

```
mvn install
```

Needs Java 25 and read access to `packages.tstieh.de` (server ids `packages-releases` / `packages-snapshots` in `~/.m2/settings.xml`).

## Plugins

- `tpa-standalone/target/RainsTPA-2.9.2.jar` — also published as `de.raindancer.modules:tpa-standalone:2.9.2`

## Versions

A module's version is a property in this repository's root `pom.xml`, a plugin's is `plugin.version` in its own pom. CI publishes every version that is not in the registry yet on the next push to master.
