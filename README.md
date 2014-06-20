LevelUP
======
#####LevelUP is a Bukkit plugin allowing Minecraft players to convert an amount their experience into currency and vise versa.
#####As such, the server plugin is dependant on Vault and Craftbukkit.

Building LevelUP Repo
------
#####We build the plugin with Eclipse.. (http://www.eclipse.org/downloads/)
#####You will also need Vault.. (http://dev.bukkit.org/bukkit-plugins/vault/)
#####And Craftbukkit.. (http://dl.bukkit.org/downloads/craftbukkit/get/02535_1.7.2-R0.3/craftbukkit-beta.jar)

###PART I :: Eclispe Setup
######1) Install Eclipse, if you don't already have it,
######2) After downloading (cloning or unzipping) the LevelUP source code, create a workbench in Eclipse in whatever folder the LevelUP folder is in,
```
For example, if your folder tree is set up like this: C:\GitHub\LevelUP,
'C:\GitHub' would be your workbench.
```
######3) Click workbench in the upper-right hand corner,
######4) Click File > New > Java Project,
######5) In the new window (New Java Project), Project name: LevelUP and click Finish.

###PART II :: Adding the Vault and Craftbukkit Libraries
######1) Right click the LevelUP package in the Package Explorer and click Properties,
######2) Click Java Build Path, then Libraries, then Add External JARs..,
######3) Select the Vault and Craftbukkit JAR files and click Open,
######4) Click OK in the Properties window to close it.

Permissions
------
#####__levelup.*__ Gives permissions to all LevelUP commands.
#####__levelup.savexp__ Saves your hard-earned experience.
#####__levelup.takexp__ Converts your experience into currency.

Command Usage
------
#####__/savexp__ will convert all your experience points and convert them into currency. (1xp point = $1)
#####__/takexp__ will convert all your currency and convert it into xp points.
#####__/takexp <amount>__ will convert a portion of your currency and convert it into the same amount of xp points.

https://github.com/SkyNetAB/LevelUP