package com.joseph.web;

import com.joseph.entity.Command;
import com.joseph.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/command")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @GetMapping("/listCommand")
    public String showCommandList(Model theModel) {
        List<Command> commands = commandService.getAllCommands();
        commands.forEach(System.out::println);
        theModel.addAttribute("commands", commands);
        return "command-form";
    }

    @Autowired
    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @GetMapping("/commands/orderByPrice")
    public String showCommandsOrderedByPrice(Model model) {
        List<Command> commands = commandService.getCommandsOrderedByPrice();
        model.addAttribute("commands", commands);
        return "commands-ordered-by-price";
    }
}
