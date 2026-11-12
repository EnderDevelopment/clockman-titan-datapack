# Clockman Titans Minecraft Mod

Clockman Titans is a Fabric Minecraft mod for Minecraft Java Edition 1.21.1 that adds Clockman Titan 1.0 and 2.0 equipment, time-themed powers, and a player-accessible menu controlled by a clock item. It is a Minecraft mod, not a datapack, and provides original gameplay interpretations of the equipment and abilities.

## Install

1. Install Minecraft Java Edition 1.21.1.
2. Install Java 21.
3. Install Fabric Loader 0.16.10 or another compatible Fabric Loader 0.16.x version.
4. Install Fabric API for Minecraft 1.21.1.
5. Build the project with:

```text
./gradlew build
```

6. Copy the generated `clockman-titans` mod JAR from `build/libs` into the Minecraft `mods` folder.
7. On multiplayer servers, install the mod on the server and on every client.

## Use

1. Start Minecraft with Fabric and the installed mod.
2. Obtain the menu clock from the Tools creative tab or use:

```text
/give @s clockman_titans:clock_menu
```

3. Right-click the Clockman Menu Clock to open the equipment and powers panel.
4. Use the equipment buttons to receive the Titan 1.0 Core, Titan 2.0 Core, Time Blade, or Giant Clock.
5. Use the power buttons to activate Time Stop, Time Burst, or Rewind Shield.
6. The menu and powers work for regular players without OP permissions after the clock has been obtained. The `/give` command still follows normal Minecraft permission rules.

Equipment items available through the menu or commands:

```text
/give @s clockman_titans:titan_1_core
/give @s clockman_titans:titan_2_core
/give @s clockman_titans:time_blade
/give @s clockman_titans:giant_clock
```

Time Stop slows and reveals nearby living entities for five seconds. Time Burst grants speed, strength, and resistance for fifteen seconds. Rewind Shield grants absorption, resistance, and regeneration for a defensive effect. All powers share a twenty-second cooldown.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/29122f78-602e-4e4d-b7b5-c8a7f0947ec9?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=29122f78-602e-4e4d-b7b5-c8a7f0947ec9
