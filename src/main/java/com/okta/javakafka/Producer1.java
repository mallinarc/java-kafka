package com.okta.javakafka;

import java.util.Properties;

import org.apache.kafka.common.serialization.StringSerializer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer1 {
    private static final Logger logger = LoggerFactory.getLogger(Producer1.class);
    public static void main(String[] args) {
        logger.info("Hello World");
        String bootstrapServers = "localhost:9092";
        // create properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create producer
        KafkaProducer<String,String> first_producer = new KafkaProducer<String, String>(properties); 

        //Create a producer record
        ProducerRecord<String, String> record = new ProducerRecord<String,String>("myTopic","Hi Kafka");
        
        // send data
        first_producer.send(record);
        first_producer.flush();
        first_producer.close();
        

    }
    
}
