package com.pivotal.login

import com.pivotal.api.ApiMethod
import com.pivotal.api.ApiRequest
import login.LoginApiResponse

class LoginApiRequest(val login: String, val password: String): ApiRequest<LoginApiResponse> {
    override val method = ApiMethod.POST

    override val body: String? get() {
        return "$login $password"
    }

    override fun buildResponse(): LoginApiResponse {
        return LoginApiResponse()
    }
}
