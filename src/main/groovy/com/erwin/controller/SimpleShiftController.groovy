package com.erwin.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by erwinalberto on 7/20/17.
 */

@RestController
@RefreshScope
class SimpleShiftController {

    @Value('${info.app.name}')
    String infoAppName

    @Value('${info.app.description}')
    String infoAppDescription;


    @RequestMapping("/")
    String index() {
        return "${infoAppName} = ${infoAppDescription}";
    }
}
