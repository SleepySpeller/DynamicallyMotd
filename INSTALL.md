# Install & Setup instructions for DynamicallyMotd
This guide will help you get DynamicallyMotd up and running in no time!<br>

# Table of Contents
1. [Getting Started](#getting-started)
2. [Setting up the MOTD's](#setting-up-the-motds)<br>
   2.1 [How the config works](#how-the-config-works)<br>
   2.2 [Formatting and Coloring](#formatting-and-coloring)<br>
3. [Commands](#commands)

# Getting Started
To kick things off, download the [latest release of the plugin](https://github.com/SleepySpeller/DynamicallyMotd/releases) and drag it into your plugins folder.
<br>
Then go ahead and start your server. If you see:<br>
``[DynamicallyMotd] Loaded successfully!``<br>
That means that the plugin was installed successfully and we can begin setting up the MOTD's.

# Setting up the MOTD's
After the plugin has been enabled, open your ``plugins/DynamicallyMotd`` folder and edit ``config.yml``.
<br>
You should see something like this:
```
motds:
  - "DynamicallyMotd is running!"
```
<br>
That is the default config that we are gonna be modifying.<br>

## How the config works
The ``motds`` is the list of all the MOTD's the plugin cycles through.<br>
If we want to add a new MOTD for the plugin to cycle through, we would modify our config to look something like this:
```
motds:
  - "DynamicallyMotd is running!"
  - "This is a new MOTD"
```
When adding new MOTD's, they need to be in-between quotes with a dash in front, as shown in the example above.<br>
Modifying and removing existing MOTD's should be self-explanitory.<br><br>
**Note:** There is currently no limit as to how many MOTD's you can store at the same time.<br>
**Note:** The plugin randomly selects which MOTD to show, thus the order of the MOTD's in the config doesn't matter.

## Formatting and Coloring
If you want colored or formatted text in your MOTD, DynamicallyMotd supports that as well.<br><br>
I heavily recommend you use [MCTools MOTD Creator](https://mctools.org/motd-creator) for text formatting.<br>
If you prefer formatting the text manually, feel free to look up some [documentation about color codes and formatting](https://www.digminecraft.com/lists/color_list_pc.php).
<br><br>
Feel free to customize your MOTD. For demonstration purposes I came up with this:<br>
<img src="https://i.imgur.com/Ip0Sh7k.jpeg"></img><br>
```\u00A74\u00A7oDynamicallyMotd\u00A7r\n\u00A73Made by \u00A7lSleepySpeller```<br><br>
**Note:** If you're using the [MOTD Creator](https://mctools.org/motd-creator) for creating the MOTD, make sure you copy the MOTD labeled ``For Spigot server.properties file`` as shown in the picture below:
<br>
<img src="https://i.imgur.com/AJV1Pa9.jpeg"></img>
<br>
After copying the MOTD, you can just paste it in the config between quotes (").<br><br>
In the end, our config should look something like this:
```motds:
  - "\u00A74\u00A7oDynamicallyMotd\u00A7r\n\u00A73Made by \u00A7lSleepySpeller"
  - "This is a new MOTD"
```

# Commands
The plugin uses ``/dynamicallymotd`` as it's primary command.<br>
In order for the player to access the command, the player needs to have the permission ``dynamicallymotd.admin`` or to be OP.
<br>
Available commands:
1. ``/dynamicallymotd reload`` - reads the ``config.yml`` and looks for new MOTD's. Use this if you've added new MOTD's and want them to get registered by the plugin without restarting the server.
2. ``/dynamicallymotd add`` - ***This is still in an experimental state and can cause issues with formatting and coloring***. Used for adding new MOTD's through the game chat.
3. ``/dynamicallymotd list <page>`` - lists existing MOTDs in the config. Each page contains 5 MOTDs, and are sorted the same way they are in the config.
