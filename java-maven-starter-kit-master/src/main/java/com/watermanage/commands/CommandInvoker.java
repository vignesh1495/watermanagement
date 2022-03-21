package com.watermanage.commands;

import java.util.HashMap;
import java.util.Map;

import com.watermanage.execptions.NoSuchCommandException;

public class CommandInvoker {
    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register the command into the HashMap
    public void register(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }

    // Get the registered Command
    private ICommand get(String commandName) {
        return commandMap.get(commandName);
    }

    // Execute the registered Command
    public void executeCommand(String commandName,String commandline) throws NoSuchCommandException {
        ICommand command = get(commandName);
        if (command == null) {
            // Handle Exception
            throw new NoSuchCommandException();
        }
        command.execute(commandline);
    }
}
