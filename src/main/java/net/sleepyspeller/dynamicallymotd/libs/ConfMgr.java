package net.sleepyspeller.dynamicallymotd.libs;

import net.sleepyspeller.dynamicallymotd.DynamicallyMotd;

import java.util.ArrayList;
import java.util.Random;

public class ConfMgr {
    private final DynamicallyMotd plugin;

    public ConfMgr(DynamicallyMotd plugin){
        this.plugin = plugin;
    }

    public ArrayList<String> getMotds(){
        return (ArrayList<String>) plugin.getConfig().getList("motds");
    }

    public String getMotd(int index) {
        try{
            return (String) plugin.getConfig().getList("motds").get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String getMotdRandom() {
        ArrayList<String> motds = getMotds();
        Random rand = new Random();

        int int_random = rand.nextInt(motds.size());

        if(int_random >= motds.size()) {
            int_random -= 1;
        }

        return getMotd(int_random);

    }
}
