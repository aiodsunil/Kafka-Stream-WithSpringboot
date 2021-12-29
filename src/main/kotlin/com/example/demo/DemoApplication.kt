package com.example.demo

import org.apache.kafka.streams.kstream.KStream
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@Component
class EventConsumer{

	@Bean
	fun  event(): Consumer<KStream<String,String>>{
		return Consumer {
			it.foreach { key, value -> println("key :$key,value : $value")  }
		}
	}
}