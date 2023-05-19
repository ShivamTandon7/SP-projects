package com.example.java.springboot;

import com.example.java.springboot.entity.WikimediaData;
import com.example.java.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private WikimediaDataRepository dataRepository;

    @KafkaListener(topics="wikimedia_recentchange",groupId= "myGroup")
    public void consume(String eventMessage){
        logger.info(String.format("Event message received -> %s", eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        dataRepository.save(wikimediaData);
    }

}
