package com.example;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class AIController {
    @Autowired 
private ChatClient chatClient;
//http://localhost:8080/ask?prompt=hi
@GetMapping ("/ask")
  public String chat (@RequestParam   String prompt){
    return chatClient.prompt(prompt).call().content();
  }
@GetMapping ("/sports")
  public String getTopSportsPersonalities(@RequestParam  String sports){
    String p="""
                Give me top 5 personalities in {sports}
               with achievments and personal records.
               with proper output format
            """;
            PromptTemplate template=new PromptTemplate(p);
            Prompt prompt=template.create(Map.of("sports",sports));

    return chatClient.prompt(prompt).call().content();
  }
  @GetMapping ("/specfictosports")
  public String getTopSportsPersonalities2(@RequestParam  String sports){
    String p="""
              Your primary role is to provide info about sports,
               if someone ask other than sports, u say i can provide info
               only about sports
                Give me top 5 personalities in {sports}
               with achievments and personal records.
               with proper output format.
              
            """;
            PromptTemplate template=new PromptTemplate(p);
            Prompt prompt=template.create(Map.of("sports",sports));

    return chatClient.prompt(prompt).call().content();
  }
   @GetMapping ("/aboutsports")
  public String systemMsg(@RequestParam  String sports){
    String p="""
               Give me top 5 personalities in {sports}
               with achievments and personal records.
               with proper output format.
              
            """;
      String p2="""
            Your primary role is to provide info about sports,
               if someone ask other than sports, u say i can provide info
               only about sports
          """;
            PromptTemplate template1=new PromptTemplate(p);
            Prompt prompt1=template1.create(Map.of("sports",sports));
          
            var userMsg=new UserMessage(prompt1.getContents());
            var systemMsg= new SystemMessage(p2);
            //creating prompt by combination of user and system messages
            Prompt prompt=new Prompt(List.of(userMsg,systemMsg));

       return chatClient.prompt(prompt).call().content();
  }
}
