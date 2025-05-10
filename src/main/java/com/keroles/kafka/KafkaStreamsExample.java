package com.keroles.kafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaStreamsExample {

    public void startStreaming() {
        // Configure the Streams application
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-example");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // Create a StreamsBuilder
        StreamsBuilder builder = new StreamsBuilder();

        // Create a KStream from the input topic
        KStream<String, String> textLines = builder.stream("strings");

        // Transform the stream (convert to uppercase)
        KStream<String, String> uppercaseStream = textLines.mapValues(value -> value.toUpperCase());

        // Write the transformed stream to a new topic
        uppercaseStream.to("uppercase-strings");

        // Build the topology
        KafkaStreams streams = new KafkaStreams(builder.build(), props);

        // Start the streams application
        streams.start();

        // Add shutdown hook to close the streams application gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
} 