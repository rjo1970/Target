package com.target.mygroovyretail

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by jrtitko1 on 8/6/16.
 */
@RestController
class GreetingController {

    @RequestMapping("/groovy")
    String home() {
        "Hello from Groovy"
    }
}
