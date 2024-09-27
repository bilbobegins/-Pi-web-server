//package com.bilbobegins1997.toDoList;
//
//import com.bilbobegins1997.toDoList.entity.ToDoList;
//import com.bilbobegins1997.toDoList.repository.ToDoListRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(ToDoListRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new ToDoList("Bilbo Baggins", "burglar")));
//            log.info("Preloading " + repository.save(new ToDoList("Frodo Baggins", "thief")));
//        };
//    }
//}
