package LevelUP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class PowerListener
  implements Listener
{
  @EventHandler
  public void onLevelChange(PlayerLevelChangeEvent event)
  {
    Player player = event.getPlayer();
    String Name = player.getDisplayName();
    String ColoredName = ChatColor.LIGHT_PURPLE + Name;
    String ColoredLevel = ChatColor.GREEN + "Level " + player.getLevel();
    ChatColor white = ChatColor.WHITE;
    int OldLevel = event.getOldLevel();
    int NewLevel = event.getNewLevel();
    int LostLevel = OldLevel - NewLevel;
    String LevelsLost = ChatColor.RED + " lost some levels.. " + LostLevel + " to be exact.";
    if ((NewLevel > OldLevel) && (NewLevel % 5 == 0)) {
      Bukkit.broadcastMessage(ColoredName + white + " powered up to " + ColoredLevel + white + "!!");
    } else if (NewLevel < OldLevel) {
      Bukkit.broadcastMessage(ColoredName + LevelsLost);
    }
  }
}
