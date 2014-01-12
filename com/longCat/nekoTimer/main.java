package com.longCat.nekoTimer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.scheduler.BukkitTask;




public class main extends JavaPlugin{
	public void regTask(int time,String name,Player player){
		new clock(player.getName(),name).runTaskLater(this, time * 20);
		player.sendMessage(ChatColor.GREEN + "A " +
				(time >= 3600 ? String.valueOf(time/3600) + ":" : "") +
				(time >= 60 ? String.valueOf((time/60)%60) + ":" : "") +
				String.valueOf(time%60) + (time >= 60 ? "" : "s") + " task " + name + " has set.");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player) sender;
		if(sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("timer")){
				if(args.length > 0){
					if(args[0].matches("[0-9]*:?[0-9]*:?[0-9]+")){
						int timeLength = 0;
						String spliteTime[] = args[0].split(":");
						for(int i=0;i<spliteTime.length;i++){
							timeLength *= 60;
							timeLength += Integer.parseInt(spliteTime[i]);
						}
						if(timeLength > 0){
							String name = (args.length > 1)?args[1]:(
									(timeLength >= 3600 ? String.valueOf(timeLength/3600) + ":" : "") +
									(timeLength >= 60 ? String.valueOf((timeLength/60)%60) + ":" : "") +
									String.valueOf(timeLength%60) + (timeLength >= 60 ? "" : "s"));
							regTask(timeLength,name,player);
						}else{
							player.sendMessage(ChatColor.RED + "Unexpected time.");
						}
					}else if(args[0].matches("t[0-9]+")){
						String nameArr[] = {
								"dummy",
								"練習航海",
								"長距離練習航海",
								"警備任務",
								"対潜警戒任務",
								"海上護衛任務",
								"防空射撃演習",
								"観艦式予行",
								"観艦式",
								"タンカー護衛任務",
								"強行偵察任務",
								"ボーキサイト輸送任務",
								"資源輸送任務",
								"鼠輸送作戦",
								"包囲陸戦隊撤収作戦",
								"囮機動部隊支援作戦",
								"艦隊決戦援護作戦",
								"敵地偵察作戦",
								"航空機輸送作戦",
								"北号作戦",
								"潜水艦哨戒任務",
								"通商破壊作戦",
								"敵母港空襲作戦",
								"潜水艦通商破壊作戦",
								"西方海域封鎖作戦",
								"潜水艦派遣演習",
								"潜水艦派遣作戦",
								"前衛支援任務",
								"決戦支援任務",
								"ＭＯ作戦",
								"水上機基地建設"
						};
						int timeArr[] = {
								0,
								15*60,
								30*60,
								20*60,
								50*60,
								90*60,
								40*60,
								60*60,
								3*60*60,
								4*60*60,
								90*60,
								5*60*60,
								8*60*60,
								4*60*60,
								6*60*60,
								12*60*60,
								15*60*60,
								45*60,
								5*60*60,
								6*60*60,
								2*60*60,
								40*60*60,
								80*60*60,
								20*60*60,
								25*60*60,
								24*60*60,
								48*60*60,
								15*60,
								30*60,
								7*60*60,
								9*60*60
						};
						int id = Integer.parseInt(args[0].substring(1));
						if(id<36 && id>0){
							regTask(timeArr[id],nameArr[id],player);
						}else{
							player.sendMessage(ChatColor.RED + "Unexpected expedition id.");
						}
					}else{
						player.sendMessage(ChatColor.RED + "Usage: " + ChatColor.WHITE + "/timer h:m:s [TaskName].\n" + ChatColor.RED + "or " + ChatColor.WHITE + "/timer TaskID(ex: t1).");
					}
				}else{
					player.sendMessage(ChatColor.RED + "Usage: " + ChatColor.WHITE + "/timer h:m:s [TaskName].\n" + ChatColor.RED + "or " + ChatColor.WHITE + "/timer TaskID(ex: t1).");
				}
			}
			return true;
		}else{
			sender.sendMessage(ChatColor.GREEN + "This command can only run by player.");
		}
		return false;
	}
}
