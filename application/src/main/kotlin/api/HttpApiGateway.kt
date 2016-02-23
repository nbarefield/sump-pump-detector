package com.pivotal.api

import com.pivotal.tasks.Promise
import com.pivotal.api.ApiGateway
import com.pivotal.api.ApiRequest
import com.pivotal.api.ApiResponse

class HttpApiGateway: ApiGateway {
    override fun <T : ApiResponse> doRequest(request: ApiRequest<T>): Promise<T> {
        return request.buildResponsePromise()
    }
}
