package com.target.mygroovyretail

/**
 * Created by jrtitko1 on 9/1/16.
 */
class Publisher {
    List<Subscriber> subscribers = new LinkedList<>();
    void send(String message) {
        for (Subscriber sub : subscribers) {
            sub.receive(message);
        }
    }
}
