package com.joseph.service;

import com.joseph.entity.Command;
import com.joseph.entity.CommandArticle;
import com.joseph.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public interface CommandService {
    List<Command> getAllCommands();


    //public List<CommandArticle> getCommandArticles(Long commandId);

    List<Command> getCommandsOrderedByPrice();
}
