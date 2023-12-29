package com.joseph.service.Impl;

import com.joseph.entity.Command;
import com.joseph.entity.CommandArticle;
import com.joseph.repository.CommandRepository;
import com.joseph.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Override
    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    @Autowired
    public CommandServiceImpl(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    @Transactional
    public List<Command> getCommandsOrderedByPrice() {
        return commandRepository.findByOrderByPriceTotalAsc();
    }
}
