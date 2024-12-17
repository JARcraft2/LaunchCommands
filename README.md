This mod is primarily designed for datapackers who want to modify player motion, or have more control over entity motion.
  
Usage:  

**Launch In Facing  Direction**  
launchfacing target strength overwrite  
/launchfacing @p 2  

**Launch Towards Position**  
launchtopoint target destination strength overwrite  
/launchtopoint @p 0 0 0 2  
/execute positioned ~ ~5 ~2 run launchtopoint @s ~ ~ ~ 2 true  
/launchtopoint @s ^ ^ ^2 2 true  

**Launch Towards Entity**  
launchtoentity target destination strength overwrite  
/launchtopoint @s @n[type=marker] 2  
/execute as @e[type=pig,distance=..20] run launchtopoint @s @p 3 true  
  
This mod is for the Fabric mod launcher.  
This mod is available under the CC0 license.
