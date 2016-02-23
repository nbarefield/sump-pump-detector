package com.pivotal.login

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import butterknife.bindView
import com.pivotal.R
import com.pivotal.ServiceLocator
import com.pivotal.api.ApiGateway

class LoginActivity : Activity() {
    var apiGateway: ApiGateway = ServiceLocator.apiGateway

    val loginEditText: EditText by bindView(R.id.loginEditText)
    val passwordEditText: EditText by bindView(R.id.passwordEditText)
    val loginButton: Button by bindView(R.id.loginButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        setTitle(R.string.pleaseSignIn)

        loginButton.setOnClickListener {
            val request = LoginApiRequest(login = "", password = "")
            apiGateway.doRequest(request)
        }
    }
}
