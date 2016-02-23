package com.pivotal

import com.pivotal.api.HttpApiGateway
import com.pivotal.api.ApiGateway

object ServiceLocator {
    val apiGateway: ApiGateway = HttpApiGateway()

}
