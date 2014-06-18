package LevelUP;

import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static final Logger log = Logger.getLogger("Minecraft");
	public static Main plugin;
	public static Economy econ = null;

	public void onEnable() {
		log.info("~~~Enabled LevelUP2.0.~~~");

		getServer().getPluginManager()
				.registerEvents(new PowerListener(), this);
		if (!setupEconomy()) {
			log.severe(String.format(
					"[%s] - Disabled due to no Vault dependency found!",
					new Object[] { getDescription().getName() }));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
	}

	public void onDisable() {
		log.info("~~~Disabled LevelUP2.0.~~~");
		log.info(String.format("[%s] Disabled Version %s", new Object[] {
				getDescription().getName(), getDescription().getVersion() }));
	}

	private boolean setupEconomy()
  {
    RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
    if (economyProvider != null) {
      econ = (Economy)economyProvider.getProvider();
    }
    return econ != null;
  }

	public boolean onCommand(CommandSender sender, Command com, String label, String[] args) {
		if (!(sender instanceof Player)) {
			log.info("Only players are supported!!!");
			return true;
		}
		Player player = (Player) sender;
		ExperienceManager expMan = new ExperienceManager(player);
		int pxp = expMan.getCurrentExp();
		double bal = econ.getBalance(player.getName());
		int money = (int) bal;
		int monexp = money + pxp;
		if (label.equalsIgnoreCase("savexp")) {
			EconomyResponse r = econ.depositPlayer(player.getName(), pxp);
			if (r.transactionSuccess()) {
				expMan.changeExp(pxp * -1);
				sender.sendMessage("You saved all your experience and were given $" + pxp + ". You now have a balance of $" + monexp + ".");
			} else {
				sender.sendMessage("Could not save your experience. You have " + pxp + " xp and a balance of $" + bal + ".");
			}
			return true;
		}else if (label.equalsIgnoreCase("takexp")) {
			boolean entire_bal=true;
			if (args.length > 0) {
				int asking_balance=0;
				asking_balance=Integer.valueOf(args[0]);
				if (asking_balance < bal) {
					bal = asking_balance;
					entire_bal=false;
				}
			}
			EconomyResponse r = econ.withdrawPlayer(player.getName(), bal);
			if (r.transactionSuccess()) {
				expMan.changeExp(bal);
				if (!entire_bal) {
					sender.sendMessage("You withdrew $"+bal+".");
				}else{
					sender.sendMessage("You took all your saved experience and were given " + money + " xp.");
				}
			} else {
				sender.sendMessage("Could not take your experience. You have " + pxp + "xp.");
			}
			return true;
		}
		return false;
	}
}
