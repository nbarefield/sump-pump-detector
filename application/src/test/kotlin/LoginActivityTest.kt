package com.pivotal.activity

import android.support.v7.appcompat.BuildConfig
import com.pivotal.api.ApiGateway
import com.pivotal.api.ApiMethod
import com.pivotal.api.ApiRequest
import com.pivotal.api.ApiResponse
import com.pivotal.login.LoginActivity
import com.pivotal.tasks.Promise
import login.LoginApiResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import org.junit.Assert.assertThat
import org.junit.Assert.assertNotNull
import org.hamcrest.Matchers.*

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class, manifest = "../../main/AndroidManifest.xml", sdk = intArrayOf(21), packageName = "com.pivotal")
class ExampleRobolectricTest {

    @Test
    fun testLogin() {
        val activity = Robolectric.setupActivity(LoginActivity::class.java)
        val fakeApiGateway = FakeApiGateway()

        activity.apiGateway = fakeApiGateway
        fakeApiGateway.stubbedPromise = Promise<LoginApiResponse>()

        activity.loginEditText.setText("hello@example.com")
        activity.passwordEditText.setText("secret1")
        activity.loginButton.performClick()

        assertThat(fakeApiGateway.performedRequest?.method, equalTo(ApiMethod.POST))
        assertNotNull(fakeApiGateway.performedRequest?.body)
    }

}


class FakeApiGateway: ApiGateway {
    var performedRequest: ApiRequest<*>? = null
    var stubbedPromise: Promise<*>? = null

    override fun <T : ApiResponse> doRequest(request: ApiRequest<T>): Promise<T> {
        performedRequest = request
        return stubbedPromise as Promise<T>
    }
}
