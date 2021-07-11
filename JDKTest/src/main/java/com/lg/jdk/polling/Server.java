package com.lg.jdk.polling;


import lombok.Builder;

@Builder
public class Server {
    private String ip;
    private int weight;
}
