package net.sleepyspeller.dynamicallymotd.command.subcommandsMain;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;
import net.sleepyspeller.dynamicallymotd.libs.ConfMgr;
import net.sleepyspeller.dynamicallymotd.libs.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class SubCommandList extends SubCommand {
    public SubCommandList(CommandSender sender, Command command, String s, String[] args, DynamicallyMotd plugin) {
        super(sender, command, s, args, plugin);
    }

    private List<String> getPageByStartingIndex(int start_index, ConfMgr config){
        List<String> finalMotds = new ArrayList<String>();

        for(int i = 0; i < 5; i++){
            if(config.getMotd((start_index + i)) != null){
                finalMotds.add(config.getMotd(start_index + i));

            } else {
                break;
            }
        }

        return finalMotds;
    }

    private void sendMOTDs(List<String> motds, int requested_page, int page_count, int counter){
        getSender().sendMessage(("Displaying MOTDs on page " + requested_page + " out of " + page_count));
        for (String item : motds) {
            getSender().sendMessage(counter + ". " + item);
            counter++;
        }
    }

    @Override
    public boolean run() {
        ConfMgr config = new ConfMgr(getPlugin());
        ArrayList<String> motds = config.getMotds();

        float temp_page_count = (float) motds.size() / 5;
        if (temp_page_count % 5 != 0){
            temp_page_count += 1 - temp_page_count % 1;
        }

        int page_count = (int) temp_page_count;

        if (getArgs().length <= 1){
            sendMOTDs(getPageByStartingIndex(0, config), 1, page_count, 1);

            return true;
        }

        int requested_page;
        try {
            requested_page = (int) Double.parseDouble(getArgs()[1]);
        } catch (NumberFormatException e){
            getSender().sendMessage("[DynamicallyMotd] Page count not valid! Page count: " + page_count);
            return true;
        }

        if (requested_page > page_count || requested_page < 0){
            getSender().sendMessage("[DynamicallyMotd] Page count not valid! Page count: " + page_count);
            return true;
        }

        int start_index = 0;
        if (requested_page != 1){
            start_index = (requested_page - 1) * 5;
        }

        sendMOTDs(getPageByStartingIndex(start_index, config), requested_page, page_count, start_index + 1);
        return true;
    }
}
