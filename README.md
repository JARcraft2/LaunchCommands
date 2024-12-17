This mod is primarily designed for datapackers who want to modify player motion, or have more control over entity motion.

Commands:
/launchfacing <target> <strength> <overwrite>
  Launches the given entity in the direction they are facing.
  /launchfacing @p 2

/launchtopoint <target> <destination> <strength> <overwrite>
  Launches the given entity towards a coordinate destination.
  /launchtopoint @p 0 0 0 2
  /launchtopoint @s ~ ~5 ~ 2 true
  /launchtopoint @s ^ ^ ^2 2 true

/launchtoentity <target> <destination> <strength> <overwrite>
  Launches the given entity towards a coordinate destination.
  /launchtopoint @s @n[type=marker] 2
  execute as @e[type=pig,distance=..20] run launchtopoint @s @p 3 true

This mod is available under the CC0 license.
