This mod is primarily designed for datapackers who want to modify player motion, or have more control over entity motion.

Usage:\n
/launchfacing <target> <strength> <overwrite>\n
  Launches the given entity in the direction they are facing.\n
  /launchfacing @p 2\n
\n
/launchtopoint <target> <destination> <strength> <overwrite>\n
  Launches the given entity towards a coordinate destination.\n
  /launchtopoint @p 0 0 0 2\n
  /launchtopoint @s ~ ~5 ~ 2 true\n
  /launchtopoint @s ^ ^ ^2 2 true\n
\n
/launchtoentity <target> <destination> <strength> <overwrite>\n
  Launches the given entity towards a coordinate destination.\n
  /launchtopoint @s @n[type=marker] 2\n
  execute as @e[type=pig,distance=..20] run launchtopoint @s @p 3 true\n
\n
This mod is for the Fabric mod launcher.\n
This mod is available under the CC0 license.
