package com.target.mygroovyretail

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by jrtitko1 on 9/1/16.
 */
class SpockTest extends Specification {
    Publisher publisher = new Publisher()
    def subscriber1 = Mock(Subscriber)
    def subscriber2 = Mock(Subscriber)


    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    def "stack test"() {
        setup:
            def stack = new Stack()
            def elem = "push me"

        when:
            stack.push(elem)

        then:
            !stack.empty()
            stack.size() == 1
            stack.peek() == elem
    }

    def "popping a stack"() {
        setup:
            def stack = new Stack()

        when:
            stack.pop()

        then:
            def e = thrown(EmptyStackException)
            e.cause == null
            stack.empty()
    }

    @Unroll
    def "#value using fizz(#fizz) and buzz(#buzz) is #result" (int value, int fizz, int buzz, String result) {
        given:
            def fizzbuzz = new FizzBuzz();

        expect:
            fizzbuzz.check(value, fizz, buzz) == result

        where:
        value   | fizz  | buzz  || result
        11      | 3     | 5     || "11"
        3       | 3     | 5     || "Fizz"
        15      | 3     | 5     || "FizzBuzz"
    }

    def "Interaction based testing Publisher/Subscriber"() {
        setup:
            publisher.subscribers << subscriber1
            publisher.subscribers << subscriber2

        when:
            publisher.send("Hello")

        then:
            1 * subscriber1.receive("Hello")
            1 * subscriber2.receive(!null)
    }

    def "Alternate Interaction based testing Publisher/Subscriber"() {
        setup:
        publisher.subscribers << subscriber1
        publisher.subscribers << subscriber2
        int x = publisher.subscribers.size()

        when:
        publisher.send("Hello")

        then:
        x * _.receive("Hello")
    }
}
